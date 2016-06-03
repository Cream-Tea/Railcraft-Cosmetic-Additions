package mods.railcraft_cos.common.tileentities;

import mods.railcraft_cos.common.blocks.BlockRailcraftSignBasic;
import mods.railcraft_cos.common.blocks.EnumSignBasicType;
import mods.railcraft_cos.common.core.Railcraft_Cos;
import mods.railcraft_cos.common.models.CosSignBasicModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityRailcraftSignBasic extends TileEntity {
	
	public EnumSignBasicType getSignType() {
		BlockRailcraftSignBasic blk = (BlockRailcraftSignBasic) worldObj.getBlock(xCoord, yCoord, zCoord);
		return blk.getSignType();
	}
	
	public ResourceLocation getResource() {
		switch(getSignType()) {
		case WHISTLE:
			return new ResourceLocation(Railcraft_Cos.MODID, "textures/tesr/cossign.whistle.png");
		case MPH5:
			return new ResourceLocation(Railcraft_Cos.MODID, "textures/tesr/cossign.mph5.png");
		case CLEARANCE:
			return new ResourceLocation(Railcraft_Cos.MODID, "textures/tesr/cossign.clearance.png");
		case REFUGE:
			return new ResourceLocation(Railcraft_Cos.MODID, "textures/tesr/cossign.refuge.png");
		case SHUNT:
			return new ResourceLocation(Railcraft_Cos.MODID, "textures/tesr/cossign.shunt.png");
		default:
			return null;
		}
	}
	
	public ModelBase getModel() {
		return new CosSignBasicModel();
	}
}
