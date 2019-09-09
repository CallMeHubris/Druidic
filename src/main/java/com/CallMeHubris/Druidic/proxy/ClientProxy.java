package com.CallMeHubris.Druidic.proxy;

import com.CallMeHubris.Druidic.entities.models.ModelDeer;
import com.CallMeHubris.Druidic.entities.render.RenderDeer;
import com.CallMeHubris.Druidic.init.ModEntities;
import com.CallMeHubris.Druidic.world.ModWorldGeneration;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy
{
	public void registerItemRenderer(Item item, int meta, String id) 
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
}
