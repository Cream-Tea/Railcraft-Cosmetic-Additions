package mods.railcraft_cos.common.items;

import mods.railcraft_cos.common.core.Railcraft_Cos;
import net.minecraft.item.Item;

public class ItemSemaphoreArm extends Item {
	
	public ItemSemaphoreArm(String unlocalizedname) {
		setMaxStackSize(1);
		setCreativeTab(Railcraft_Cos.tabRailcraftCos);
		setUnlocalizedName(unlocalizedname);
		setTextureName(Railcraft_Cos.MODID + ":" + "semaphore.arm");
	}
}
