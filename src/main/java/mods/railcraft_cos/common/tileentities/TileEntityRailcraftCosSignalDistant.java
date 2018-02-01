package mods.railcraft_cos.common.tileentities;

import mods.railcraft.api.signals.IReceiverTile;
import mods.railcraft.api.signals.SignalAspect;
import mods.railcraft.api.signals.SignalController;
import mods.railcraft.api.signals.SignalReceiver;
import mods.railcraft.api.signals.SimpleSignalReceiver;
import mods.railcraft.common.blocks.aesthetics.post.BlockPostBase;
import mods.railcraft_cos.common.blocks.BlockRailcraftCosSignalBase;
import mods.railcraft_cos.common.blocks.BlockRailcraftSignBasic;
import mods.railcraft_cos.common.blocks.EnumCosSignalType;
import mods.railcraft_cos.common.core.Railcraft_Cos;
import mods.railcraft_cos.common.models.CosSignalBannerModel;
import mods.railcraft_cos.common.models.CosSignalSemaphoreModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockSign;
import net.minecraft.client.model.ModelBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class TileEntityRailcraftCosSignalDistant extends TileEntity implements IReceiverTile {
	
	private boolean alternate;
	private boolean quadrant;
	private static ResourceLocation textureArray[] =
		{	new ResourceLocation(Railcraft_Cos.MODID, "textures/tesr/cossignalbanner.png"),
			new ResourceLocation(Railcraft_Cos.MODID, "textures/tesr/cossignalbanneralt.png"),
			new ResourceLocation(Railcraft_Cos.MODID, "textures/tesr/cossignalsemaphore.png"),
			new ResourceLocation(Railcraft_Cos.MODID, "textures/tesr/cossignalsemaphoredistant.png")
		};
	private static ModelBase modelArray[] =
		{	new CosSignalBannerModel(),
			new CosSignalSemaphoreModel(0, 0),
			new CosSignalSemaphoreModel(0, 1),
			new CosSignalSemaphoreModel(-1, 0),
			new CosSignalSemaphoreModel(-1, 1),
			new CosSignalSemaphoreModel(1, 0),
			new CosSignalSemaphoreModel(1, 1)				
		};
	
	private final SimpleSignalReceiver receiver = new SimpleSignalReceiver("Distant Signal", this);
	
	public boolean getState() {
		return alternate;
	}
	
	public boolean getQuadrant()
	{
		return quadrant;
	}
	
	public int getBlocksAround()
	{
		if (checkBlockAbove(worldObj,xCoord,yCoord,zCoord))
		{
			return 1;
		}
		else
		{
			return 0;
		}
		
	}
	
	public boolean checkBlockAbove(IBlockAccess world, int x,int y,int z)
	{
		Block block = world.getBlock(x, y+1, z);
		Block blockAbove = world.getBlock(x, y+2, z);
		if (block instanceof BlockFence) return true;
		else if ((block instanceof BlockPostBase) && (blockAbove instanceof BlockPostBase)) return true;
		else if (block instanceof BlockRailcraftSignBasic) return true;
		else if (block instanceof BlockRailcraftCosSignalBase) return true;
		else if ((block instanceof BlockSign) && Block.getIdFromBlock(block) == 63) return true;
		else return false;
	}
	
	public void switchQuadrant()
	{
		boolean q = getQuadrant();
		quadrant = q ? false : true;
		getWorld().markBlockForUpdate(xCoord, yCoord, zCoord);
	}
	
	public EnumCosSignalType getSignalType() {
		BlockRailcraftCosSignalBase blk = (BlockRailcraftCosSignalBase) worldObj.getBlock(xCoord, yCoord, zCoord);
		return blk.getSignalType();
	}
	
	public ResourceLocation getResource() {
		switch(getSignalType()) {
		case BANNER_REPEATER:
			if(getState()) {
				return textureArray[0];
			} else {
				return textureArray[1];
			}
		case SEMAPHORE_REPEATER:
			return textureArray[3];
		case SEMAPHORE_REPEATER_ALT:
			return textureArray[2];
		default:
			return null;
		}
	}
	
	public ModelBase getModel() 
	{
		int quad = getQuadrant() ? 1 : -1;
		int ySize = getBlocksAround();
		switch(getSignalType()) 
			{	case BANNER_REPEATER: return modelArray[0];
				case SEMAPHORE_REPEATER:
					if(!getState()) 
					{
						if (ySize == 1) 
						{
							return modelArray[2];						
						}
						else 
						{
							return modelArray[1];
						}
						
					} 
					else 
					{
						if (ySize == 1 && quad == -1)
						{
							return modelArray[4];
						}
						else if (ySize == 1 && quad == 1)
						{
							return modelArray[6];
						}
						else if (ySize == 0 && quad == -1)
						{
							return modelArray[3];
						}
						else
						{
							return modelArray[5];
						}
					}
				case SEMAPHORE_REPEATER_ALT:
					if(!getState()) 
					{
						if (ySize == 1) 
						{
							return modelArray[2];						
						}
						else 
						{
							return modelArray[1];
						}
					} 
					else 
					{
						if (ySize == 1 && quad == -1)
						{
							return modelArray[4];
						}
						else if (ySize == 1 && quad == 1)
						{
							return modelArray[6];
						}
						else if (ySize == 0 && quad == -1)
						{
							return modelArray[3];
						}
						else
						{
							return modelArray[5];
						}
					}
				default: return null;
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
        data.setBoolean("quadrant", quadrant);
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        receiver.readFromNBT(data);
        
        boolean b = data.getBoolean("alt");
        if(alternate != b) {
        	alternate = b;
        }
        boolean q = data.getBoolean("quadrant");
        if (quadrant != q)
        {
        	quadrant = q;
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
