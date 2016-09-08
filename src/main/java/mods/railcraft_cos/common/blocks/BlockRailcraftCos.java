package mods.railcraft_cos.common.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import mods.railcraft_cos.common.items.ItemRailcraftCosSignalBase;
import mods.railcraft_cos.common.items.ItemRailcraftSignBasic;
import mods.railcraft_cos.common.tileentities.TileEntityRailcraftCosSignalBlock;
import mods.railcraft_cos.common.tileentities.TileEntityRailcraftCosSignalDistant;
import mods.railcraft_cos.common.tileentities.TileEntityRailcraftSignBasic;
import net.minecraft.block.Block;

public final class BlockRailcraftCos 
{
	public static Block SignalBanner;
	public static Block SignalSemaphore;
	public static Block SignalSemaphoreRepeater;
	public static Block SignalSemaphoreRepeaterAlt;
	public static Block SignWhistle;
	public static Block SignMPH5;
	public static Block SignClearance;
	public static Block SignRefuge;
	public static Block SignShunt;
	public static Block PlatformEdge;
	public static Block PlatformEdgeLine;
	public static Block PlatformFloor;
	public static Block PlatformTransition;
	public static Block TrackGrass;
	public static Block TrackWoodenGrass;
	public static Block TrackCobweb;
	
	public static final void init()
	{
		SignalBanner = new BlockRailcraftCosSignalBase("signalbanner", EnumCosSignalType.BANNER_REPEATER);
		SignalSemaphore = new BlockRailcraftCosSignalBase("signalsemaphore", EnumCosSignalType.SEMAPHORE_STOP);
		SignalSemaphoreRepeater = new BlockRailcraftCosSignalBase("signalsemaphorerepeater", EnumCosSignalType.SEMAPHORE_REPEATER);
		SignalSemaphoreRepeaterAlt = new BlockRailcraftCosSignalBase("signalsemaphorerepeateralt", EnumCosSignalType.SEMAPHORE_REPEATER_ALT);
		SignWhistle = new BlockRailcraftSignBasic("sign.whistle", EnumSignBasicType.WHISTLE);
		SignMPH5 = new BlockRailcraftSignBasic("sign.mph5", EnumSignBasicType.MPH5);
		SignClearance = new BlockRailcraftSignBasic("sign.clearance", EnumSignBasicType.CLEARANCE);
		SignRefuge = new BlockRailcraftSignBasic("sign.refuge", EnumSignBasicType.REFUGE);
		SignShunt = new BlockRailcraftSignBasic("sign.shunt", EnumSignBasicType.SHUNT);
		PlatformFloor = new BlockRailcraftPlatform("platform.floor", (byte) 0);
		PlatformEdge = new BlockRailcraftPlatform("platform.edge", (byte) 1);
		PlatformEdgeLine = new BlockRailcraftPlatform("platform.edge.line", (byte) 2);
		PlatformTransition = new BlockRailcraftPlatform("platform.transition", (byte) 3);
		TrackGrass = new BlockRailcraftCosTrack("track.grass", false);
		TrackCobweb = new BlockRailcraftCosTrackCobweb("track.cobweb", false);
		
		GameRegistry.registerBlock(SignalBanner, ItemRailcraftCosSignalBase.class, SignalBanner.getUnlocalizedName());		
		GameRegistry.registerBlock(SignalSemaphore, ItemRailcraftCosSignalBase.class, SignalSemaphore.getUnlocalizedName());		
		GameRegistry.registerBlock(SignalSemaphoreRepeater, ItemRailcraftCosSignalBase.class, SignalSemaphoreRepeater.getUnlocalizedName());
		GameRegistry.registerBlock(SignalSemaphoreRepeaterAlt, ItemRailcraftCosSignalBase.class, SignalSemaphoreRepeaterAlt.getUnlocalizedName());
		GameRegistry.registerBlock(SignWhistle, ItemRailcraftSignBasic.class, SignWhistle.getUnlocalizedName());		
		GameRegistry.registerBlock(SignMPH5, ItemRailcraftSignBasic.class, SignMPH5.getUnlocalizedName());		
		GameRegistry.registerBlock(SignClearance, ItemRailcraftSignBasic.class, SignClearance.getUnlocalizedName());		
		GameRegistry.registerBlock(SignRefuge, ItemRailcraftSignBasic.class, SignRefuge.getUnlocalizedName());
		GameRegistry.registerBlock(SignShunt, ItemRailcraftSignBasic.class, SignShunt.getUnlocalizedName());
		GameRegistry.registerBlock(PlatformFloor, PlatformFloor.getUnlocalizedName());		
		GameRegistry.registerBlock(PlatformEdge, PlatformEdge.getUnlocalizedName());		
		GameRegistry.registerBlock(PlatformEdgeLine, PlatformEdgeLine.getUnlocalizedName());		
		GameRegistry.registerBlock(PlatformTransition, PlatformTransition.getUnlocalizedName());				
		GameRegistry.registerBlock(TrackGrass, TrackGrass.getUnlocalizedName());
		GameRegistry.registerBlock(TrackCobweb, TrackCobweb.getUnlocalizedName());
		
		GameRegistry.registerTileEntity(TileEntityRailcraftCosSignalBlock.class, "tileentityrailcraftcossignalblock");
		GameRegistry.registerTileEntity(TileEntityRailcraftCosSignalDistant.class, "tileentityrailcraftcossignaldistant");
		GameRegistry.registerTileEntity(TileEntityRailcraftSignBasic.class, "tileentityrailcraftsignbasic");
	}

}
