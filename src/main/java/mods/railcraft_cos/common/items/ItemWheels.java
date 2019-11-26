package mods.railcraft_cos.common.items;

import mods.railcraft_cos.common.core.Railcraft_Cos;
import net.minecraft.item.Item;

public class ItemWheels extends Item
{
	
	public ItemWheels(String unlocalizedName)
	{
		this.maxStackSize = 16;
        this.setCreativeTab(Railcraft_Cos.tabRailcraftCos);
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(Railcraft_Cos.MODID + ":" + "wheels");
		
	}

}
