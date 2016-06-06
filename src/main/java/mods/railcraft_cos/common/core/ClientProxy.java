package mods.railcraft_cos.common.core;

import net.minecraft.item.Item;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import mods.railcraft_cos.client.renderer.entity.RenderModelledMinecart;
import mods.railcraft_cos.common.blocks.BlockRailcraftCos;
import mods.railcraft_cos.common.blocks.EnumCosSignalType;
import mods.railcraft_cos.common.blocks.EnumSignBasicType;
import mods.railcraft_cos.common.blocks.RailcraftCosTrackRenderer;
import mods.railcraft_cos.common.blocks.RailcraftPlatformRenderer;
import mods.railcraft_cos.common.entity.item.EntityModelledChestCart;
import mods.railcraft_cos.common.items.ItemRendererRailcraftCosSignalBase;
import mods.railcraft_cos.common.items.ItemRendererRailcraftSignBasic;
import mods.railcraft_cos.common.tileentities.TESRCosSignalBase;
import mods.railcraft_cos.common.tileentities.TESRSignBasic;
import mods.railcraft_cos.common.tileentities.TileEntityRailcraftCosSignalBlock;
import mods.railcraft_cos.common.tileentities.TileEntityRailcraftCosSignalDistant;
import mods.railcraft_cos.common.tileentities.TileEntityRailcraftSignBasic;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;

public class ClientProxy extends CommonProxy {
	
	public static int railcraftPlatformRenderer;
	public static int railcraftCosTrackRenderer;
	
	@Override
	public void registerRendering() 
	{
		railcraftPlatformRenderer = RenderingRegistry.getNextAvailableRenderId();
		railcraftCosTrackRenderer = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(railcraftPlatformRenderer, new RailcraftPlatformRenderer());
		RenderingRegistry.registerBlockHandler(railcraftCosTrackRenderer, new RailcraftCosTrackRenderer());
		RenderingRegistry.registerEntityRenderingHandler(EntityModelledChestCart.class, new RenderModelledMinecart());
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
}