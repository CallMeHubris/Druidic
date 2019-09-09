package com.CallMeHubris.Druidic.entities.render;

import com.CallMeHubris.Druidic.entities.EntityDeer;
import com.CallMeHubris.Druidic.entities.models.ModelDeer;
import com.CallMeHubris.Druidic.util.Reference;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderDeer extends RenderLiving<EntityDeer>
{
	public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entities/deer_antler.png");
	
	public RenderDeer(RenderManager manager) 
	{
		super(manager, new ModelDeer(), 0.5f);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityDeer entity) 
	{
		return TEXTURE;
	}

}
