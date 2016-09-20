package mods.railcraft_cos.common.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.railcraft_cos.common.core.ClientProxy;
import mods.railcraft_cos.common.core.Railcraft_Cos;
import net.minecraft.block.BlockRailBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockRailcraftCosTrackSnow extends BlockRailBase
{	
	public BlockRailcraftCosTrackSnow(String unlocalizedName, boolean powered) 
	{
		super(powered);
		setBlockName(unlocalizedName);
		setBlockTextureName(Railcraft_Cos.MODID + ":" + unlocalizedName);
		setResistance(3.0F);
		setStepSound(soundTypeSnow);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune) 
	{
		return Item.getItemFromBlock(this);
	}
	
	@SideOnly(Side.CLIENT)
	public int getRenderType()
    {
        return ClientProxy.railcraftCosTrackRenderer;
    }
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float sideX, float sideY, float sideZ)
    {
		if(player.getCurrentEquippedItem() != null)
		{
			ItemStack item = player.getCurrentEquippedItem();			
			if(item.getItem() instanceof ItemSpade)
			{				
				int oldmeta = world.getBlockMetadata(x, y, z);
				world.setBlock(x, y, z, Blocks.rail, oldmeta, 2);
				ItemStack itemstack = new ItemStack(Items.snowball, 1, 1);
				dropBlockAsItem(world, x, y, z, itemstack);
								
				item.damageItem(1, player);
				return true;
			}
			else
			{
				return false;
			}
		}
		
		else
		{
			return false;
		}		
    }
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
        if (entity != null && entity instanceof EntityMinecart)
        {
        	int oldmeta = world.getBlockMetadata(x, y, z);
			world.setBlock(x, y, z, Blocks.rail, oldmeta, 2);
			ItemStack itemstack = new ItemStack(Items.snowball, 1, 1);
			dropBlockAsItem(world, x, y, z, itemstack);        	
        }
    }
	
	@Override
	public void setBlockBoundsForItemRender()
    {
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
    }

}
