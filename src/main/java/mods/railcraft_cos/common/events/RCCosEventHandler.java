package mods.railcraft_cos.common.events;

import net.minecraftforge.common.MinecraftForge;

public class RCCosEventHandler 
{
	public static void init()
	{
		MinecraftForge.EVENT_BUS.register(new PlayerEventListener());
	}

}
