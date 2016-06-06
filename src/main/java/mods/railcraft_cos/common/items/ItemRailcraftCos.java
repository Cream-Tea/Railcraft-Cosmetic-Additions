package mods.railcraft_cos.common.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public final class ItemRailcraftCos 
{
	//Items
	public static Item SemaphoreArm;
	public static Item SignBlank;
	//Entity Items (Modelled Carts)
	public static ItemModelled ModelledChestCart;
	

	public static final void init()
	{
		SemaphoreArm = new ItemSemaphoreArm("semaphore.arm");
		SignBlank = new ItemSignBlank("sign.blank");
		ModelledChestCart = new ItemModelled(24, "modelled.cart.chest");
		
		GameRegistry.registerItem(SemaphoreArm, SemaphoreArm.getUnlocalizedName());		
		GameRegistry.registerItem(SignBlank, SignBlank.getUnlocalizedName());
		GameRegistry.registerItem(ModelledChestCart, ModelledChestCart.getUnlocalizedName());
	}
}
