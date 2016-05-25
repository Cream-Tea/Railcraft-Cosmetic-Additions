package mods.railcraft_cos.common.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public final class ItemRailcraftCos 
{
	public static Item SemaphoreArm;
	public static Item SignBlank;
	
	
	public static final void init()
	{
		SemaphoreArm = new ItemSemaphoreArm("semaphore.arm");
		SignBlank = new ItemSignBlank("sign.blank");
		
		GameRegistry.registerItem(SemaphoreArm, SemaphoreArm.getUnlocalizedName());		
		GameRegistry.registerItem(SignBlank, SignBlank.getUnlocalizedName());
	}
	

}
