package mods.railcraft_cos.common.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.railcraft_cos.common.core.ClientProxy;
import mods.railcraft_cos.common.core.Railcraft_Cos;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockRailcraftPlatform extends Block {

	private byte platformType;
	private IIcon lineIcon;
	
	public BlockRailcraftPlatform(String unlocalizedname, byte type) {
		super(Material.rock);
		setCreativeTab(Railcraft_Cos.tabRailcraftCos);
		setBlockName(unlocalizedname);
		if(type == 3) {
			setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		} else {
			setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
		}
		setBlockTextureName(Railcraft_Cos.MODID + ":" + "platform");
		setHardness(1.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 1);
		platformType = type;
	}
	
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
	
	public byte getPlatformType() {
		return platformType;
	}
	
	@Override
	public IIcon getIcon(int side, int meta) {
		if(side == 1) {
			switch(platformType) {
			case 2:
				return lineIcon;
			}
		}
		return blockIcon;	
	}
	
	@Override
	public void registerBlockIcons(IIconRegister reg) {
	    blockIcon = reg.registerIcon(this.textureName + ".generic");
	    lineIcon = reg.registerIcon(this.textureName + ".line");
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune) {
		return Item.getItemFromBlock(this);
	}
	
	@SideOnly(Side.CLIENT)
	public int getRenderType() {
		return ClientProxy.railcraftPlatformRenderer;
	}
	
	public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_)
    {
        super.onBlockAdded(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
    }
	
	public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_)
    {
		if(platformType != 0) {
	        int l = MathHelper.floor_double((double)(p_149689_5_.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
	
	        if (l == 0)
	        {
	            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 0, 2);
	        }
	
	        if (l == 1)
	        {
	            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 1, 2);
	        }
	
	        if (l == 2)
	        {
	            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 2, 2);
	        }
	
	        if (l == 3)
	        {
	            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 3, 2);
	        }
	
	        if (p_149689_6_.hasDisplayName())
	        {
	            ((TileEntityFurnace)p_149689_1_.getTileEntity(p_149689_2_, p_149689_3_, p_149689_4_)).func_145951_a(p_149689_6_.getDisplayName());
	        }
		} else {
			p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 4, 2);
		}
    }
}
