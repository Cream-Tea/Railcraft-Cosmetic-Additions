package mods.railcraft_cos.common.items;

import net.minecraft.item.Item;
import mods.railcraft_cos.common.core.Railcraft_Cos;

public class ItemSignBlank extends Item {
	public ItemSignBlank(String unlocalizedname) {
		setMaxStackSize(1);
		setCreativeTab(Railcraft_Cos.tabRailcraftCos);
		setUnlocalizedName(unlocalizedname);
		setTextureName(Railcraft_Cos.MODID + ":" + "sign.blank");
	}
}
