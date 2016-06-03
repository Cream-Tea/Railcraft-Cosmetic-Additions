package mods.railcraft_cos.common.core;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.railcraft_cos.common.blocks.BlockRailcraftCos;
import mods.railcraft_cos.common.events.RCCosEventHandler;
import mods.railcraft_cos.common.items.ItemRailcraftCos;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

@Mod(modid=Railcraft_Cos.MODID, name=Railcraft_Cos.MODNAME, version=Railcraft_Cos.MODVER, dependencies="after:Railcraft")
public class Railcraft_Cos {
	public static final String MODID = "railcraft_cos";
	public static final String MODNAME = "Railcraft Cosmetic Additions";
	public static final String MODVER = "1.7.2";

	public static CreativeTabs tabRailcraftCos= new CreativeTabs("tabRailcraftCos") {

	    @Override
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem() {
	        return Item.getItemFromBlock(BlockRailcraftCos.SignalSemaphore);
	    }

	    @Override
	    @SideOnly(Side.CLIENT)
	    public int func_151243_f()
	    {
	        return 0;
	    }
	};
	
	@SidedProxy(clientSide="mods.railcraft_cos.common.core.ClientProxy", serverSide="mods.railcraft_cos.common.core.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public static void postInit(FMLInitializationEvent event) 
	{
		RCCosRecipes.init();
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) 
	{
		
		ItemRailcraftCos.init();
		BlockRailcraftCos.init();
		RCCosEventHandler.init();
		
		proxy.registerRendering();
	}
}
