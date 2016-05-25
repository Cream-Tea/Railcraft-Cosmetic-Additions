package mods.railcraft_cos.common.events;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import mods.railcraft_cos.common.blocks.BlockRailcraftCos;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class PlayerEventListener 
{
	@SubscribeEvent(priority=EventPriority.HIGHEST, receiveCanceled=true)
	public void bonemealRail(BonemealEvent event)
	{
		if (event.block == Blocks.rail)
		{	
			int meta = event.world.getBlockMetadata(event.x, event.y, event.z);
			event.world.setBlock(event.x, event.y, event.z, BlockRailcraftCos.TrackGrass, meta, 2);
			Result result = Result.ALLOW;
			event.setResult(result);
		}

	}	

}
