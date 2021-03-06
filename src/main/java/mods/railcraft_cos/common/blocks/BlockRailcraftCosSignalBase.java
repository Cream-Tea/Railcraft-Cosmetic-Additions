package mods.railcraft_cos.common.blocks;

import java.util.Random;

import mods.railcraft.common.items.ItemCrowbar;
import mods.railcraft_cos.common.core.Railcraft_Cos;
import mods.railcraft_cos.common.tileentities.TileEntityRailcraftCosSignalBlock;
import mods.railcraft_cos.common.tileentities.TileEntityRailcraftCosSignalDistant;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockRailcraftCosSignalBase extends BlockContainer {
	
	private EnumCosSignalType signalType;
	
	public BlockRailcraftCosSignalBase(String localizedname, EnumCosSignalType type) {
		super(Material.iron);
		setBlockName(localizedname);
		setCreativeTab(CreativeTabs.tabTransport);
		setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 0.9F, 0.75F);
		setBlockTextureName(Railcraft_Cos.MODID + ":" + "cossignalbase");
		setHardness(1.0F);
		setResistance(5.0F);
		signalType = type;
	}

	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		switch(signalType) {
		case SEMAPHORE_STOP:
			return new TileEntityRailcraftCosSignalBlock();
		default:
			return new TileEntityRailcraftCosSignalDistant();
		}
		
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float sideX, float sideY, float sideZ)
    {	
		if (player.getCurrentEquippedItem() != null)
		{	
			Item item = player.getCurrentEquippedItem().getItem();
			if (item != null && item instanceof ItemCrowbar)
			{
				TileEntity te = world.getTileEntity(x, y, z);
				if (te != null && te instanceof TileEntityRailcraftCosSignalBlock)
				{
					TileEntityRailcraftCosSignalBlock teblock = (TileEntityRailcraftCosSignalBlock) world.getTileEntity(x, y, z);
					teblock.switchQuadrant();
				}
				else if (te != null && te instanceof TileEntityRailcraftCosSignalDistant)
				{
					TileEntityRailcraftCosSignalDistant tedistant = (TileEntityRailcraftCosSignalDistant) world.getTileEntity(x, y, z);
					tedistant.switchQuadrant();
				}				
			}
		}		
        return false;
    }
	
	public EnumCosSignalType getSignalType() {
		return signalType;
	}
	
	public int getRenderType() {
		return -1;
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
	
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune) {
		return Item.getItemFromBlock(this);
	}
	
	public void onBlockAdded(World world, int x, int y, int z)
    {
        super.onBlockAdded(world, x, y, z);
        this.func_149930_e(world, x, y, z);
    }
	
    private void func_149930_e(World world, int x, int y, int z)
    {
        if (!world.isRemote)
        {
            Block block = world.getBlock(x, y, z - 1);
            Block block1 = world.getBlock(x, y, z + 1);
            Block block2 = world.getBlock(x - 1, y, z);
            Block block3 = world.getBlock(x + 1, y, z);
            byte b0 = 3;

            if (block.func_149730_j() && !block1.func_149730_j())
            {
                b0 = 3;
            }

            if (block1.func_149730_j() && !block.func_149730_j())
            {
                b0 = 2;
            }

            if (block2.func_149730_j() && !block3.func_149730_j())
            {
                b0 = 5;
            }

            if (block3.func_149730_j() && !block2.func_149730_j())
            {
                b0 = 4;
            }

            world.setBlockMetadataWithNotify(x, y, z, b0, 2);
        }
    }
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack item)
    {
        int l = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, 0, 2);
        }

        if (l == 1)
        {
            world.setBlockMetadataWithNotify(x, y, z, 1, 2);
        }

        if (l == 2)
        {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }

        if (l == 3)
        {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }

        if (item.hasDisplayName())
        {
            ((TileEntityFurnace)world.getTileEntity(x, y, z)).func_145951_a(item.getDisplayName());
        }
    }
}
