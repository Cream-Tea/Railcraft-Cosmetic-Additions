package mods.railcraft_cos.common.tileentities;

import net.minecraft.client.model.ModelBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import mods.railcraft.api.signals.IReceiverTile;
import mods.railcraft.api.signals.SignalAspect;
import mods.railcraft.api.signals.SignalController;
import mods.railcraft.api.signals.SignalReceiver;
import mods.railcraft.api.signals.SimpleSignalReceiver;
import mods.railcraft_cos.common.blocks.BlockRailcraftCosSignalBase;
import mods.railcraft_cos.common.blocks.EnumCosSignalType;
import mods.railcraft_cos.common.core.Railcraft_Cos;
import mods.railcraft_cos.common.models.CosSignalBannerModel;
import mods.railcraft_cos.common.models.CosSignalSemaphoreModel;
import mods.railcraft_cos.common.models.CosSignalSemaphoreModelClear;

public class TileEntityRailcraftCosSignalDistant extends TileEntity implements IReceiverTile {
	
	private boolean alternate;
	
	private final SimpleSignalReceiver receiver = new SimpleSignalReceiver("Distant Signal", this);
	
	public boolean getState() {
		return alternate;
	}
	
	public EnumCosSignalType getSignalType() {
		BlockRailcraftCosSignalBase blk = (BlockRailcraftCosSignalBase) worldObj.getBlock(xCoord, yCoord, zCoord);
		return blk.getSignalType();
	}
	
	public ResourceLocation getResource() {
		switch(getSignalType()) {
		case BANNER_REPEATER:
			if(!getState()) {
				return new ResourceLocation(Railcraft_Cos.MODID, "textures/tesr/cossignalbanner.png");
			} else {
				return new ResourceLocation(Railcraft_Cos.MODID, "textures/tesr/cossignalbanneralt.png");
			}
		case SEMAPHORE_REPEATER:
			return new ResourceLocation(Railcraft_Cos.MODID, "textures/tesr/cossignalsemaphoredistant.png");
		default:
			return null;
		}
	}
	
	public ModelBase getModel() {
		switch(getSignalType()) {
		case BANNER_REPEATER:
			return new CosSignalBannerModel();
		case SEMAPHORE_REPEATER:
			if(!getState()) {
				return new CosSignalSemaphoreModel();
			} else {
				return new CosSignalSemaphoreModelClear();
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
        super.writeToNBT(data);

        receiver.writeToNBT(data);
        data.setBoolean("alt", alternate);
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        receiver.readFromNBT(data);
        
        boolean b = data.getBoolean("alt");
        if(alternate != b) {
        	alternate = b;
        }
        
    }
	
	public void onControllerAspectChange(SignalController con,
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
	public SignalReceiver getReceiver() {
		return receiver;
	}

}
