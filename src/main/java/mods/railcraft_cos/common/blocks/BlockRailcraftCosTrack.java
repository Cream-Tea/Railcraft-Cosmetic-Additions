package mods.railcraft_cos.common.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.railcraft_cos.common.core.ClientProxy;
import mods.railcraft_cos.common.core.Railcraft_Cos;
import net.minecraft.block.BlockRailBase;
import net.minecraft.item.Item;

public class BlockRailcraftCosTrack extends BlockRailBase {
	
	public BlockRailcraftCosTrack(String unlocalizedname, boolean b) {
		super(false);
		setBlockName(unlocalizedname);
		setBlockTextureName(Railcraft_Cos.MODID + ":" + "track.grass");
		setResistance(3.0F);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune) {
		return Item.getItemFromBlock(this);
	}
	
	@SideOnly(Side.CLIENT)
	public int getRenderType()
    {
        return ClientProxy.railcraftCosTrackRenderer;
    }
	
	
}
