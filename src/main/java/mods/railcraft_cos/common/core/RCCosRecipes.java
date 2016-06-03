package mods.railcraft_cos.common.core;

import cpw.mods.fml.common.registry.GameRegistry;
import mods.railcraft_cos.common.blocks.BlockRailcraftCos;
import mods.railcraft_cos.common.items.ItemRailcraftCos;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RCCosRecipes 
{
	public static final void init()
	{
		ItemStack iron = new ItemStack(Items.iron_ingot);
		ItemStack semaphore = new ItemStack(ItemRailcraftCos.SemaphoreArm);
		ItemStack sign = new ItemStack(ItemRailcraftCos.SignBlank);
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
		
		GameRegistry.addRecipe(new ItemStack(ItemRailcraftCos.SemaphoreArm),
				"IIR",
				'I', iron,
				'R', redstone);
		
		GameRegistry.addRecipe(new ItemStack(BlockRailcraftCos.SignalBanner),
				"SCI",
				"RBI",
				'S', compass,
				'C', receiver_circuit,
				'I', iron,
				'R', paper,
				'B', black_dye);
		
		GameRegistry.addRecipe(new ItemStack(BlockRailcraftCos.SignalSemaphore),
				"SCI",
				"RBI",
				'S', semaphore,
				'C', signal_circuit,
				'I', iron,
				'R', red_dye,
				'B', black_dye);
		
		GameRegistry.addRecipe(new ItemStack(BlockRailcraftCos.SignalSemaphoreRepeater),
				"SCI",
				"RBI",
				'S', semaphore,
				'C', receiver_circuit,
				'I', iron,
				'R', yellow_dye,
				'B', black_dye);
		
		GameRegistry.addRecipe(new ItemStack(ItemRailcraftCos.SignBlank, 8),
				"III",
				"III",
				" I ",
				'I', iron);
		
		GameRegistry.addRecipe(new ItemStack(BlockRailcraftCos.SignWhistle),
				" R ",
				" S ",
				'S', sign,
				'R', paper);
		
		GameRegistry.addRecipe(new ItemStack(BlockRailcraftCos.SignMPH5),
				"  R",
				" S ",
				'S', sign,
				'R', paper);
		
		GameRegistry.addRecipe(new ItemStack(BlockRailcraftCos.SignClearance),
				" R ",
				" S ",
				'S', sign,
				'R', red_dye);
		
		GameRegistry.addRecipe(new ItemStack(BlockRailcraftCos.SignRefuge),
				" R ",
				" S ",
				'S', sign,
				'R', blue_dye);
		
		GameRegistry.addRecipe(new ItemStack(BlockRailcraftCos.SignShunt),
				"RWR",
				" S ",
				'S', sign,
				'R', red_dye,
				'W', paper);
		
		GameRegistry.addRecipe(new ItemStack(BlockRailcraftCos.PlatformFloor),
				" SP",
				'S', cobble,
				'P', polished_slab);
		
		GameRegistry.addRecipe(new ItemStack(BlockRailcraftCos.PlatformEdge),
				" P ",
				" S ",
				'S', cobble,
				'P', polished_slab);
		
		GameRegistry.addRecipe(new ItemStack(BlockRailcraftCos.PlatformEdgeLine),
				" R ",
				" P ",
				" S ",
				'S', cobble,
				'P', polished_slab,
				'R', yellow_dye);

		GameRegistry.addRecipe(new ItemStack(BlockRailcraftCos.PlatformTransition),
				"P P",
				" S ",
				'S', cobble,
				'P', polished_slab);
		
		GameRegistry.addRecipe(new ItemStack(BlockRailcraftCos.TrackGrass),
				" G ",
				" T ",
				'T', basic_track,
				'G', grass);
	}

}
