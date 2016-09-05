package mods.railcraft_cos.common.items;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import mods.railcraft_cos.common.core.Railcraft_Cos;
import mods.railcraft_cos.common.entity.item.EntityModelledChestCart;
import net.minecraft.item.Item;

public final class ItemRailcraftCos 
{
	//Items
	public static Item SemaphoreArm;
	public static Item SignBlank;
	//Entity Items (Modelled Carts)
	public static ItemModelled ModelledChestCartQuarry;
	public static ItemModelled ModelledChestCartLiquid;

	public static final void init()
	{
		//Items
		SemaphoreArm = new ItemSemaphoreArm("semaphore.arm");
		SignBlank = new ItemSignBlank("sign.blank");
		ModelledChestCartQuarry = new ItemModelled("cart.modelled.quarry", (short) 0);
		ModelledChestCartLiquid = new ItemModelled("cart.modelled.liquid", (short) 1);
		
		//Register Items
		GameRegistry.registerItem(SemaphoreArm, SemaphoreArm.getUnlocalizedName());
		GameRegistry.registerItem(SignBlank, SignBlank.getUnlocalizedName());
		//Register Items With Entities
		EntityRegistry.registerModEntity(EntityModelledChestCart.class, "modelledcart", EntityRegistry.findGlobalUniqueEntityId(), Railcraft_Cos.instance, 256, 3, true);
		GameRegistry.registerItem(ModelledChestCartQuarry, ModelledChestCartQuarry.getUnlocalizedName());
		GameRegistry.registerItem(ModelledChestCartLiquid, ModelledChestCartLiquid.getUnlocalizedName());
	}
}
