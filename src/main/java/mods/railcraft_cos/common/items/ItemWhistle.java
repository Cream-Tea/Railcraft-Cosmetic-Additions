package mods.railcraft_cos.common.items;

import mods.railcraft_cos.common.core.Railcraft_Cos;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemWhistle extends Item
{
	
	public ItemWhistle(String unlocalizedName)
	{
		this.maxStackSize = 1;
        this.setCreativeTab(Railcraft_Cos.tabRailcraftCos);
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(Railcraft_Cos.MODID + ":" + "whistle");
		
	}
	
	@Override
	public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float px, float py, float pz)
    {
		
        return false;
    }
	
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
    {
		player.setItemInUse(item, this.getMaxItemUseDuration(item));
		world.playSoundAtEntity(player, Railcraft_Cos.MODID + ":whistleSound", 1.0F, 1.0F);
        return item;
    }
	
	public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 72000;
    }
}
