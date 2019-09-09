package com.CallMeHubris.Druidic.util.handlers;

import com.CallMeHubris.Druidic.entities.EntityDeer;
import com.CallMeHubris.Druidic.entities.render.RenderDeer;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler 
{
	public static void registerEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityDeer.class, new IRenderFactory<EntityDeer>()
		{
			@Override
			public Render<? super EntityDeer> createRenderFor(RenderManager manager) 
			{
				return new RenderDeer(manager);
			}
		});
	}
}
