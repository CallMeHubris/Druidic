package com.CallMeHubris.Druidic.init;

import java.util.ArrayList;
import java.util.List;

import com.CallMeHubris.Druidic.Main;
import com.CallMeHubris.Druidic.entities.EntityDeer;
import com.CallMeHubris.Druidic.util.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities 
{
	public static void registerEntities()
	{
		registerEntity("deer", EntityDeer.class, 50, 100, 6766613, 0);
	}
	
	//Simplified entity registry method to avoid repetition of code
	private static void registerEntity(String name, Class entityClass, int id, int range, int color1, int color2)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entityClass, name, id, Main.instance, range, 1, true, color1, color2);

	}
}
