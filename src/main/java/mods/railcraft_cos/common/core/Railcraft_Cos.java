package mods.railcraft_cos.common.core;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import mods.railcraft_cos.common.blocks.BlockRailcraftCosSignalBase;
import mods.railcraft_cos.common.blocks.BlockRailcraftCosTrack;
import mods.railcraft_cos.common.blocks.BlockRailcraftPlatform;
import mods.railcraft_cos.common.blocks.BlockRailcraftSignBasic;
import mods.railcraft_cos.common.blocks.EnumCosSignalType;
import mods.railcraft_cos.common.blocks.EnumSignBasicType;
import mods.railcraft_cos.common.items.ItemRailcraftCosSignalBase;
import mods.railcraft_cos.common.items.ItemRailcraftSignBasic;
import mods.railcraft_cos.common.items.ItemSemaphoreArm;
import mods.railcraft_cos.common.items.ItemSignBlank;
import mods.railcraft_cos.common.tileentities.TileEntityRailcraftCosSignalBlock;
import mods.railcraft_cos.common.tileentities.TileEntityRailcraftCosSignalDistant;
import mods.railcraft_cos.common.tileentities.TileEntityRailcraftSignBasic;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid=Railcraft_Cos.MODID, name=Railcraft_Cos.MODNAME, version=Railcraft_Cos.MODVER, dependencies="after:Railcraft")
public class Railcraft_Cos {
	public static final String MODID = "railcraft_cos";
	public static final String MODNAME = "Railcraft Cosmetic Additions";
	public static final String MODVER = "1.6";
	public static Block SignalBanner;
	public static Block SignalSemaphore;
	public static Block SignalSemaphoreRepeater;
	public static Block SignWhistle;
	public static Block SignMPH5;
	public static Block SignClearance;
	public static Block SignRefuge;
	public static Block PlatformEdge;
	public static Block PlatformEdgeLine;
	public static Block PlatformFloor;
	public static Block PlatformTransition;
	public static Block TrackGrass;
	public static Block TrackWoodenGrass;
	public static Item SemaphoreArm;
	public static Item SignBlank;

	public static CreativeTabs tabRailcraftCos= new CreativeTabs("tabRailcraftCos") {

	    @Override
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem() {
	        return Item.getItemFromBlock(SignalSemaphore);
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
	public static void postInit(FMLInitializationEvent event) {
		ItemStack iron = new ItemStack(Items.iron_ingot);
		ItemStack semaphore = new ItemStack(SemaphoreArm);
		ItemStack sign = new ItemStack(SignBlank);
		ItemStack receiver_circuit = GameRegistry.findItemStack("Railcraft", "part.circuit.receiver", 1);
		ItemStack signal_circuit = GameRegistry.findItemStack("Railcraft", "part.circuit.signal", 1);
		ItemStack black_dye = new ItemStack(Items.dye, 1, 0);
		ItemStack red_dye = new ItemStack(Items.dye, 1, 1);
		ItemStack yellow_dye = new ItemStack(Items.dye, 1, 11);
		ItemStack blue_dye = new ItemStack(Items.dye, 1, 4);
		ItemStack paper = new ItemStack(Items.paper);
		ItemStack redstone = new ItemStack(Items.redstone);
		ItemStack compass = new ItemStack(Items.compass);
		ItemStack polished_slab = new ItemStack(Blocks.stone_slab);
		ItemStack cobble = new ItemStack(Blocks.cobblestone);
		ItemStack basic_track = new ItemStack(Blocks.rail);
		ItemStack grass = new ItemStack(Items.wheat_seeds);
		
		GameRegistry.addRecipe(new ItemStack(SemaphoreArm),
				"IIR",
				'I', iron,
				'R', redstone);
		
		GameRegistry.addRecipe(new ItemStack(SignalBanner),
				"SCI",
				"RBI",
				'S', compass,
				'C', receiver_circuit,
				'I', iron,
				'R', paper,
				'B', black_dye);
		
		GameRegistry.addRecipe(new ItemStack(SignalSemaphore),
				"SCI",
				"RBI",
				'S', semaphore,
				'C', signal_circuit,
				'I', iron,
				'R', red_dye,
				'B', black_dye);
		
		GameRegistry.addRecipe(new ItemStack(SignalSemaphoreRepeater),
				"SCI",
				"RBI",
				'S', semaphore,
				'C', receiver_circuit,
				'I', iron,
				'R', yellow_dye,
				'B', black_dye);
		
		GameRegistry.addRecipe(new ItemStack(SignBlank, 8),
				"III",
				"III",
				" I ",
				'I', iron);
		
		GameRegistry.addRecipe(new ItemStack(SignWhistle),
				" R ",
				" S ",
				'S', sign,
				'R', paper);
		
		GameRegistry.addRecipe(new ItemStack(SignMPH5),
				"  R",
				" S ",
				'S', sign,
				'R', paper);
		
		GameRegistry.addRecipe(new ItemStack(SignClearance),
				" R ",
				" S ",
				'S', sign,
				'R', red_dye);
		
		GameRegistry.addRecipe(new ItemStack(SignRefuge),
				" R ",
				" S ",
				'S', sign,
				'R', blue_dye);
		
		GameRegistry.addRecipe(new ItemStack(PlatformFloor),
				" SP",
				'S', cobble,
				'P', polished_slab);
		
		GameRegistry.addRecipe(new ItemStack(PlatformEdge),
				" P ",
				" S ",
				'S', cobble,
				'P', polished_slab);
		
		GameRegistry.addRecipe(new ItemStack(PlatformEdgeLine),
				" R ",
				" P ",
				" S ",
				'S', cobble,
				'P', polished_slab,
				'R', yellow_dye);

		GameRegistry.addRecipe(new ItemStack(PlatformTransition),
				"P P",
				" S ",
				'S', cobble,
				'P', polished_slab);
		
		GameRegistry.addRecipe(new ItemStack(TrackGrass),
				" G ",
				" T ",
				'T', basic_track,
				'G', grass);
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		
		
		SignalBanner = new BlockRailcraftCosSignalBase("signalbanner", EnumCosSignalType.BANNER_REPEATER);
		GameRegistry.registerBlock(SignalBanner, ItemRailcraftCosSignalBase.class, SignalBanner.getUnlocalizedName());
		SignalSemaphore = new BlockRailcraftCosSignalBase("signalsemaphore", EnumCosSignalType.SEMAPHORE_STOP);
		GameRegistry.registerBlock(SignalSemaphore, ItemRailcraftCosSignalBase.class, SignalSemaphore.getUnlocalizedName());
		SignalSemaphoreRepeater = new BlockRailcraftCosSignalBase("signalsemaphorerepeater", EnumCosSignalType.SEMAPHORE_REPEATER);
		GameRegistry.registerBlock(SignalSemaphoreRepeater, ItemRailcraftCosSignalBase.class, SignalSemaphoreRepeater.getUnlocalizedName());
		SignWhistle = new BlockRailcraftSignBasic("sign.whistle", EnumSignBasicType.WHISTLE);
		GameRegistry.registerBlock(SignWhistle, ItemRailcraftSignBasic.class, SignWhistle.getUnlocalizedName());
		SignMPH5 = new BlockRailcraftSignBasic("sign.mph5", EnumSignBasicType.MPH5);
		GameRegistry.registerBlock(SignMPH5, ItemRailcraftSignBasic.class, SignMPH5.getUnlocalizedName());
		SignClearance = new BlockRailcraftSignBasic("sign.clearance", EnumSignBasicType.CLEARANCE);
		GameRegistry.registerBlock(SignClearance, ItemRailcraftSignBasic.class, SignClearance.getUnlocalizedName());
		SignRefuge = new BlockRailcraftSignBasic("sign.refuge", EnumSignBasicType.REFUGE);
		GameRegistry.registerBlock(SignRefuge, ItemRailcraftSignBasic.class, SignRefuge.getUnlocalizedName());
		
		PlatformFloor = new BlockRailcraftPlatform("platform.floor", (byte) 0);
		GameRegistry.registerBlock(PlatformFloor, PlatformFloor.getUnlocalizedName());
		PlatformEdge = new BlockRailcraftPlatform("platform.edge", (byte) 1);
		GameRegistry.registerBlock(PlatformEdge, PlatformEdge.getUnlocalizedName());
		PlatformEdgeLine = new BlockRailcraftPlatform("platform.edge.line", (byte) 2);
		GameRegistry.registerBlock(PlatformEdgeLine, PlatformEdgeLine.getUnlocalizedName());
		PlatformTransition = new BlockRailcraftPlatform("platform.transition", (byte) 3);
		GameRegistry.registerBlock(PlatformTransition, PlatformTransition.getUnlocalizedName());
		
		TrackGrass = new BlockRailcraftCosTrack("track.grass", false);
		GameRegistry.registerBlock(TrackGrass, TrackGrass.getUnlocalizedName());
		SemaphoreArm = new ItemSemaphoreArm("semaphore.arm");
		GameRegistry.registerItem(SemaphoreArm, SemaphoreArm.getUnlocalizedName());
		SignBlank = new ItemSignBlank("sign.blank");
		GameRegistry.registerItem(SignBlank, SignBlank.getUnlocalizedName());
		
		GameRegistry.registerTileEntity(TileEntityRailcraftCosSignalBlock.class, "tileentityrailcraftcossignalblock");
		GameRegistry.registerTileEntity(TileEntityRailcraftCosSignalDistant.class, "tileentityrailcraftcossignaldistant");
		GameRegistry.registerTileEntity(TileEntityRailcraftSignBasic.class, "tileentityrailcraftsignbasic");
		proxy.registerRendering();
	}
}
