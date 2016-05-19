package mods.railcraft_cos.common.tileentities;

import com.mojang.authlib.GameProfile;

import mods.railcraft.api.signals.IControllerTile;
import mods.railcraft.api.signals.ISignalBlockTile;
import mods.railcraft.api.signals.SignalAspect;
import mods.railcraft.api.signals.SignalBlock;
import mods.railcraft.api.signals.SignalBlockSimple;
import mods.railcraft.api.signals.SignalController;
import mods.railcraft.api.signals.SimpleSignalController;
import mods.railcraft_cos.common.blocks.BlockRailcraftCosSignalBase;
import mods.railcraft_cos.common.blocks.EnumCosSignalType;
import mods.railcraft_cos.common.core.Railcraft_Cos;
import mods.railcraft_cos.common.models.CosSignalSemaphoreModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class TileEntityRailcraftCosSignalBlock extends TileEntity implements IControllerTile, ISignalBlockTile {
	
	EnumCosSignalType signalType;
	private boolean alternate;
	private boolean quadrant;
	
	private final SimpleSignalController controller = new SimpleSignalController(getLocalizationTag(), this);
	private final SignalBlock signalBlock = new SignalBlockSimple(getLocalizationTag(), this);
	
	public boolean getState() {
		return alternate;
	}
	
	public boolean getQuadrant()
	{
		return quadrant;
	}
	
	public void switchQuadrant()
	{
		boolean q = getQuadrant();
		System.out.println(q);
		quadrant = q ? false : true;
		System.out.println(q);
		getWorld().markBlockForUpdate(xCoord, yCoord, zCoord);
	}
	
	public EnumCosSignalType getSignalType() {
		BlockRailcraftCosSignalBase blk = (BlockRailcraftCosSignalBase) worldObj.getBlock(xCoord, yCoord, zCoord);
		return blk.getSignalType();
	}
	
	public ResourceLocation getResource() {
		switch(getSignalType()) {
		case SEMAPHORE_STOP:
			return new ResourceLocation(Railcraft_Cos.MODID, "textures/tesr/cossignalsemaphore.png");
		default:
			return null;
		}
	}
	
	public ModelBase getModel() 
	{
		int quad = getQuadrant() ? 1 : -1;
		switch(getSignalType()) {
		case SEMAPHORE_STOP:
			if(!getState()) 
			{
				return new CosSignalSemaphoreModel(0);
			} else {
				return new CosSignalSemaphoreModel(quad);
			}
		default:
			return null;
		}
	}

	public World getWorld() {
		return worldObj;
	}
	
	@Override
    public void writeToNBT(NBTTagCompound data) {
        try {
            super.writeToNBT(data);
            signalBlock.writeToNBT(data);
            controller.writeToNBT(data);
            data.setBoolean("alt", alternate);
            data.setBoolean("quadrant", quadrant);
        } catch (Throwable er) {
            //Game.logThrowable(Level.ERROR, "Signal Tile crashed on write.", 10, er);
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        try {
            super.readFromNBT(data);
            signalBlock.readFromNBT(data);
            controller.readFromNBT(data);
            boolean b = data.getBoolean("alt");
            if(alternate != b) {
            	alternate = b;
            }
            boolean q = data.getBoolean("quadrant");
            if (quadrant != q)
            {
            	quadrant = q;
            }
        } catch (Throwable er) {
            //Game.logThrowable(Level.ERROR, "Signal Tile crashed on read.", 10, er);
        }
    }
	
	public void updateBlockSignalState(SignalController con,
			SignalAspect aspect) {
		if(aspect == SignalAspect.RED || aspect == SignalAspect.OFF || aspect == SignalAspect.BLINK_RED) {
			if(alternate) {
				alternate = false;
				getWorld().playSoundEffect(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D, "tile.piston.out", 0.5F, getWorld().rand.nextFloat() * 0.25F + 0.6F);
				getWorld().markBlockForUpdate(xCoord, yCoord, zCoord);
			}
		} else {
			if(!alternate) {
				alternate = true;
				getWorld().playSoundEffect(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D, "tile.piston.in", 0.5F, getWorld().rand.nextFloat() * 0.25F + 0.6F);
				getWorld().markBlockForUpdate(xCoord, yCoord, zCoord);
			}
		}
	}
	
	@Override
	public void updateEntity() {
		super.updateEntity();
        if (worldObj.isRemote) {
            controller.tickClient();
            signalBlock.tickClient();
            return;
        }
		controller.tickServer();
		signalBlock.tickServer();
        SignalAspect prevAspect = controller.getAspect();
        if (controller.isBeingPaired()) {
            controller.setAspect(SignalAspect.BLINK_YELLOW);
        } else {
            controller.setAspect(signalBlock.getSignalAspect());
        }
        if (prevAspect != controller.getAspect()) {
            updateBlockSignalState(controller, controller.getAspect());
        }
        /*if (SignalTools.printSignalDebug && prevAspect != SignalAspect.BLINK_RED && controller.getAspect() == SignalAspect.BLINK_RED) {
        	LogManager.getLogger(Railcraft_Cos.MODID).log(Level.INFO, "Signal Tile changed aspect to BLINK_RED: source:[{0}, {1}, {2}]", xCoord, yCoord, zCoord);
        }*/
	}
	
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound tagCompound = new NBTTagCompound();
        writeToNBT(tagCompound);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, tagCompound);
	}
	
	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		readFromNBT(pkt.func_148857_g());
	}

	@Override
	public String getLocalizationTag() {
		return "Block Signal";
	}

	@Override
	public GameProfile getOwner() {
		return null;
	}

	@Override
	public SignalBlock getSignalBlock() {
		return signalBlock;
	}

	@Override
	public SignalController getController() {
		return controller;
	}

}
