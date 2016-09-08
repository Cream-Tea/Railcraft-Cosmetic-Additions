package mods.railcraft_cos.common.core;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import mods.railcraft_cos.client.renderer.entity.RenderModelledCartCustom;
import mods.railcraft_cos.common.blocks.BlockRailcraftCos;
import mods.railcraft_cos.common.blocks.EnumCosSignalType;
import mods.railcraft_cos.common.blocks.EnumSignBasicType;
import mods.railcraft_cos.common.blocks.RailcraftCosTrackRenderer;
import mods.railcraft_cos.common.blocks.RailcraftPlatformRenderer;
import mods.railcraft_cos.common.entity.item.EntityModelledChestCart;
import mods.railcraft_cos.common.entity.item.EntityModelledTankCart;
import mods.railcraft_cos.common.items.ItemRendererRailcraftCosSignalBase;
import mods.railcraft_cos.common.items.ItemRendererRailcraftSignBasic;
import mods.railcraft_cos.common.models.armor.ModelTrainOperatorCap;
import mods.railcraft_cos.common.models.armor.ModelTrainOperatorChest;
import mods.railcraft_cos.common.tileentities.TESRCosSignalBase;
import mods.railcraft_cos.common.tileentities.TESRSignBasic;
import mods.railcraft_cos.common.tileentities.TileEntityRailcraftCosSignalBlock;
import mods.railcraft_cos.common.tileentities.TileEntityRailcraftCosSignalDistant;
import mods.railcraft_cos.common.tileentities.TileEntityRailcraftSignBasic;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	public static int railcraftPlatformRenderer;
	public static int railcraftCosTrackRenderer;
	private static final ModelTrainOperatorCap cap = new ModelTrainOperatorCap(1.0f);
	private static final ModelTrainOperatorChest chest = new ModelTrainOperatorChest(1.0f);
	//private static final ModelTrainOperatorLegs legs = new ModelTrainOperatorLegs(0.5f);
	//private static final ModelTrainOperatorBoots boots = new ModelTrainOperatorBoots(1.0f);
	
	@Override
	public void registerRendering() 
	{
		railcraftPlatformRenderer = RenderingRegistry.getNextAvailableRenderId();
		railcraftCosTrackRenderer = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(railcraftPlatformRenderer, new RailcraftPlatformRenderer());
		RenderingRegistry.registerBlockHandler(railcraftCosTrackRenderer, new RailcraftCosTrackRenderer());
		RenderingRegistry.registerEntityRenderingHandler(EntityModelledChestCart.class, new RenderModelledCartCustom());
		RenderingRegistry.registerEntityRenderingHandler(EntityModelledTankCart.class, new RenderModelledCartCustom());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRailcraftCosSignalBlock.class, new TESRCosSignalBase());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRailcraftCosSignalDistant.class, new TESRCosSignalBase());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRailcraftSignBasic.class, new TESRSignBasic());
		
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRailcraftCos.SignalBanner),
				(IItemRenderer) new ItemRendererRailcraftCosSignalBase(EnumCosSignalType.BANNER_REPEATER));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRailcraftCos.SignalSemaphore),
				(IItemRenderer) new ItemRendererRailcraftCosSignalBase(EnumCosSignalType.SEMAPHORE_STOP));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRailcraftCos.SignalSemaphoreRepeater),
				(IItemRenderer) new ItemRendererRailcraftCosSignalBase(EnumCosSignalType.SEMAPHORE_REPEATER));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRailcraftCos.SignalSemaphoreRepeaterAlt),
				(IItemRenderer) new ItemRendererRailcraftCosSignalBase(EnumCosSignalType.SEMAPHORE_REPEATER_ALT));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRailcraftCos.SignWhistle),
				(IItemRenderer) new ItemRendererRailcraftSignBasic(EnumSignBasicType.WHISTLE));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRailcraftCos.SignMPH5),
				(IItemRenderer) new ItemRendererRailcraftSignBasic(EnumSignBasicType.MPH5));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRailcraftCos.SignClearance),
				(IItemRenderer) new ItemRendererRailcraftSignBasic(EnumSignBasicType.CLEARANCE));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRailcraftCos.SignRefuge),
				(IItemRenderer) new ItemRendererRailcraftSignBasic(EnumSignBasicType.REFUGE));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockRailcraftCos.SignShunt),
				(IItemRenderer) new ItemRendererRailcraftSignBasic(EnumSignBasicType.SHUNT));		
	}
	
	public static ModelBiped getArmorModel(int id)
	{ 	switch (id) 
		{ 
			case 0: return cap; 
			case 1: return chest; 
			//case 2: return legs;
			//case 3: return boots;
			default: break; 
		} 
		return cap;  
	} 
	
	
}