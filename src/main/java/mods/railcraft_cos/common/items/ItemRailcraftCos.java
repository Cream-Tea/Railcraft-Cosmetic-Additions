package mods.railcraft_cos.common.items;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import mods.railcraft_cos.common.core.Railcraft_Cos;
import mods.railcraft_cos.common.entity.item.EntityModelledChestCart;
import mods.railcraft_cos.common.entity.item.EntityModelledTankCart;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public final class ItemRailcraftCos 
{
	//Items
	public static Item SemaphoreArm;
	public static Item SignBlank;
	public static ItemArmor TrainOperatorCap;
	public static ItemArmor TrainOperatorChest;
	//public static ItemArmor TrainOperatorLegs;
	//public static ItemArmor TrainOperatorBoots;
	
	//Entity Items (Modelled Carts)
	public static ItemModelled ModelledChestCartQuarry;
	public static ItemModelled ModelledTankCart;
	public static ItemModelled ModelledChestCartWood;
	public static ItemModelled ModelledChestCartEmpty;
	public static ItemModelled ModelledChestCartPanzer;

	public static final void init()
	{
		//Items
		SemaphoreArm = new ItemSemaphoreArm("semaphore.arm");
		SignBlank = new ItemSignBlank("sign.blank");
		ModelledChestCartQuarry = new ItemModelled("cart.modelled.quarry", (short) 0);
		ModelledTankCart = new ItemModelled("cart.modelled.liquid", (short) 1);
		ModelledChestCartWood = new ItemModelled("cart.modelled.wood", (short) 2);
		ModelledChestCartEmpty = new ItemModelled("cart.modelled.empty", (short) 3);
		ModelledChestCartPanzer = new ItemModelled("cart.modelled.panzer", (short) 4);
		TrainOperatorCap = new TrainOperatorUniform("train_operator_cap", ArmorMaterial.CLOTH, "train_operator_cap", 0);
		TrainOperatorChest = new TrainOperatorUniform("train_operator_chest", ArmorMaterial.CLOTH, "train_operator_chest", 1);
		//TrainOperatorChest = new TrainOperatorUniform("train_operator_legs", ArmorMaterial.CLOTH, "train_operator_legs", 2);
		//TrainOperatorChest = new TrainOperatorUniform("train_operator_boots", ArmorMaterial.CLOTH, "train_operator_boots", 3);
		//Register Items
		GameRegistry.registerItem(SemaphoreArm, SemaphoreArm.getUnlocalizedName());
		GameRegistry.registerItem(SignBlank, SignBlank.getUnlocalizedName());
		GameRegistry.registerItem(TrainOperatorCap, TrainOperatorCap.getUnlocalizedName());
		GameRegistry.registerItem(TrainOperatorChest, TrainOperatorChest.getUnlocalizedName());
		//GameRegistry.registerItem(TrainOperatorLegs, TrainOperatorLegs.getUnlocalizedName());
		//GameRegistry.registerItem(TrainOperatorBoots, TrainOperatorBoots.getUnlocalizedName());
		//Register Items With Entities
		EntityRegistry.registerModEntity(EntityModelledTankCart.class, "modelledtankcart", EntityRegistry.findGlobalUniqueEntityId(), Railcraft_Cos.instance, 256, 3, true);
		EntityRegistry.registerModEntity(EntityModelledChestCart.class, "modelledchestcart", EntityRegistry.findGlobalUniqueEntityId()+1, Railcraft_Cos.instance, 256, 3, true);
		GameRegistry.registerItem(ModelledChestCartQuarry, ModelledChestCartQuarry.getUnlocalizedName());		
		GameRegistry.registerItem(ModelledTankCart, ModelledTankCart.getUnlocalizedName());
		GameRegistry.registerItem(ModelledChestCartWood, ModelledChestCartWood.getUnlocalizedName());
		GameRegistry.registerItem(ModelledChestCartEmpty, ModelledChestCartEmpty.getUnlocalizedName());
		GameRegistry.registerItem(ModelledChestCartPanzer, ModelledChestCartPanzer.getUnlocalizedName());
	}
}
