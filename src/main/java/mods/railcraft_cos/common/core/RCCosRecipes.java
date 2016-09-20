package mods.railcraft_cos.common.core;

import cpw.mods.fml.common.registry.GameRegistry;
import mods.railcraft_cos.common.blocks.BlockRailcraftCos;
import mods.railcraft_cos.common.items.ItemRailcraftCos;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class RCCosRecipes 
{
	public static final void init()
	{
		ItemStack semaphore = new ItemStack(ItemRailcraftCos.SemaphoreArm);
		ItemStack sign = new ItemStack(ItemRailcraftCos.SignBlank);
		ItemStack cartEmpty = new ItemStack(ItemRailcraftCos.ModelledChestCartEmpty);
		ItemStack receiver_circuit = GameRegistry.findItemStack("Railcraft", "part.circuit.receiver", 1);
		ItemStack signal_circuit = GameRegistry.findItemStack("Railcraft", "part.circuit.signal", 1);
		ItemStack plateIronRC = GameRegistry.findItemStack("Railcraft", "part.plate", 1);
		Block btRC = GameRegistry.findBlock("Railcraft",  "machine.beta");
		ItemStack blockTankRC = new ItemStack(btRC, 1, 1);
		ItemStack compass = new ItemStack(Items.compass);
		ItemStack polished_slab = new ItemStack(Blocks.stone_slab);
		ItemStack basic_track = new ItemStack(Blocks.rail);
		ItemStack grass = new ItemStack(Blocks.tallgrass, 1, 1);
		ItemStack cobweb = new ItemStack(Blocks.web, 1, 1);
		ItemStack lightbluewool = new ItemStack(Blocks.wool, 1, 3);
		ItemStack graywool = new ItemStack(Blocks.wool, 1, 7);
		ItemStack yellowwool = new ItemStack(Blocks.wool, 1, 4);
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRailcraftCos.SemaphoreArm),
				"IIR",
				'I', "ingotIron",
				'R', "dustRedstone"));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRailcraftCos.SignalBanner),
				"SCI",
				"RBI",
				'S', compass,
				'C', receiver_circuit,
				'I', "ingotIron",
				'R', "paperEmpty",
				'B', "dyeBlack"));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRailcraftCos.SignalSemaphore),
				"SCI",
				"RBI",
				'S', semaphore,
				'C', signal_circuit,
				'I', "ingotIron",
				'R', "dyeRed",
				'B', "dyeBlack"));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRailcraftCos.SignalSemaphoreRepeater),
				"SCI",
				"RBI",
				'S', semaphore,
				'C', receiver_circuit,
				'I', "ingotIron",
				'R', "dyeYellow",
				'B', "dyeBlack"));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRailcraftCos.SignBlank, 8),
				"III",
				"III",
				" I ",
				'I', "ingotIron"));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRailcraftCos.SignWhistle),
				" R ",
				" S ",
				'S', sign,
				'R', "paperEmpty"));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRailcraftCos.SignMPH5),
				"  R",
				" S ",
				'S', sign,
				'R', "paperEmpty"));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRailcraftCos.SignClearance),
				" R ",
				" S ",
				'S', sign,
				'R', "dyeRed"));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRailcraftCos.SignRefuge),
				" R ",
				" S ",
				'S', sign,
				'R', "dyeBlue"));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRailcraftCos.SignShunt),
				"RWR",
				" S ",
				'S', sign,
				'R', "dyeRed",
				'W', "paperEmpty"));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRailcraftCos.PlatformFloor),
				" SP",
				'S', "cobblestone",
				'P', polished_slab));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRailcraftCos.PlatformEdge),
				" P ",
				" S ",
				'S', "cobblestone",
				'P', polished_slab));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRailcraftCos.PlatformEdgeLine),
				" R ",
				" P ",
				" S ",
				'S', "cobblestone",
				'P', polished_slab,
				'R', "dyeYellow"));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRailcraftCos.PlatformTransition),
				"P P",
				" S ",
				'S', "cobblestone",
				'P', polished_slab));
		
		GameRegistry.addRecipe(new ItemStack(BlockRailcraftCos.TrackGrass),
				" G ",
				" T ",
				'T', basic_track,
				'G', grass);
		GameRegistry.addRecipe(new ItemStack(BlockRailcraftCos.TrackCobweb),
				" C ",
				" T ",
				'T', basic_track,
				'C', cobweb);
		GameRegistry.addRecipe(new ItemStack(ItemRailcraftCos.TrainOperatorCap, 1), 
				"xxx",
				"y y",
				'x', graywool,
				'y', yellowwool);
		GameRegistry.addRecipe(new ItemStack(ItemRailcraftCos.TrainOperatorChest, 1),
				"x x",
				"xyx",
				"xxx",
				'x', graywool,
				'y', lightbluewool);
		GameRegistry.addRecipe(new ItemStack(ItemRailcraftCos.TrainOperatorLegs, 1),
				"xxx",
				"x x",
				"x x",
				'x', graywool);
		GameRegistry.addRecipe(new ItemStack(ItemRailcraftCos.TrainOperatorBoots, 1),
				"x x",
				"x x",
				'x', graywool);
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRailcraftCos.Wheels, 2),
				"x x",
				'x', "ingotIron"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRailcraftCos.ModelledChestCartEmpty, 1),
				"xxx",
				"y y",
				'x', plateIronRC,
				'y', "minecartWheelsIron"));
		GameRegistry.addRecipe(new ItemStack(ItemRailcraftCos.ModelledTankCart, 1),
				"x",
				"y",
				'x', blockTankRC,
				'y', cartEmpty);
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRailcraftCos.ModelledChestCartContainer, 1),
				"x",
				"y",
				'x', "chestWood",
				'y', cartEmpty));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRailcraftCos.ModelledChestCartWood, 1), 
				"x",
				"y",
				'x', "ingotIron",
				'y', cartEmpty));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRailcraftCos.ModelledChestCartQuarry, 1),
				"x",
				"y",
				'x', plateIronRC,
				'y', cartEmpty));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRailcraftCos.ModelledTankCart, 1),
				" T ",
				"xxx",
				"y y",
				'T', blockTankRC,
				'x', plateIronRC,
				'y', "minecartWheelsIron"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRailcraftCos.ModelledChestCartContainer, 1),
				" x ",
				"yyy",
				"z z",
				'x', "chestWood",
				'y', plateIronRC,
				'z', "minecartWheelsIron"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRailcraftCos.ModelledChestCartQuarry, 1),
				" y ",
				"yyy",
				"z z",
				'y', plateIronRC,
				'z', "minecartWheelsIron"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRailcraftCos.ModelledChestCartWood, 1),
				"x x",
				"yyy",
				"z z",
				'x', "stickIron",
				'y', plateIronRC,
				'z', "minecartWheelsIron"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRailcraftCos.Whistle, 1), 
				"x",
				"x",
				'x', "ingotIron"));
		
	}

}
