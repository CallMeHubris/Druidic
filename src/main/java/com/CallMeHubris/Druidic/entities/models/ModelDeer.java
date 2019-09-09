package com.CallMeHubris.Druidic.entities.models;

import org.lwjgl.opengl.GL11;

import com.CallMeHubris.Druidic.entities.EntityDeer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelDeer extends ModelBase
{
	public ModelRenderer head;
	public ModelRenderer antlers;
	public ModelRenderer headBase;
	public ModelRenderer body;
	public ModelRenderer legBackRight;
	public ModelRenderer legBackLeft;
	public ModelRenderer legFrontRight;
	public ModelRenderer legFrontLeft;
	
	public int textureWidth = 64;
	public int textureHeight = 32;
	
	public ModelDeer()
	{
		//Neck, head, and antlers
		headBase = new ModelRenderer(this, 20, 16);
		headBase.addBox(-1, -7, -1, 2, 9, 2);
		headBase.setRotationPoint(0, 13, -4);
		setRotation(headBase, (float)(0.05 * Math.PI), 0, 0);
		headBase.setTextureSize(textureWidth, textureHeight);
		head = new ModelRenderer(this, 0, 16);
		head.addBox(-2, -11, -4, 4, 4, 6);
		head.setTextureSize(textureWidth, textureHeight);
		headBase.addChild(head);
		antlers = new ModelRenderer(this, 0, 0);
		//Right antler
		antlers.addBox(-2, -14, 0, 1, 3, 1);					
		antlers.addBox(-2, -13, -2, 1, 1, 2);
		antlers.addBox(-2, -16, -1, 1, 2, 1);
		antlers.addBox(-2, -17, -3, 1, 1, 2);
		antlers.addBox(-2, -17, 1, 1, 3, 1);
		antlers.addBox(-2, -18, 0, 1, 1, 1);
		//Left antler
		antlers.addBox(1, -14, 0, 1, 3, 1);					
		antlers.addBox(1, -13, -2, 1, 1, 2);
		antlers.addBox(1, -16, -1, 1, 2, 1);
		antlers.addBox(1, -17, -3, 1, 1, 2);
		antlers.addBox(1, -17, 1, 1, 3, 1);
		antlers.addBox(1, -18, 0, 1, 1, 1);
		head.addChild(antlers);
		
		//Body
		body = new ModelRenderer(this, 0, 0);
		body.addBox(-3, 10, -4, 6, 6, 10);
		body.setTextureSize(textureWidth, textureHeight);
		
		//Legs
		legBackRight = new ModelRenderer(this, 28, 16);
		legBackRight.addBox(-1, 0, -1, 2, 8, 2);
		legBackRight.setRotationPoint(-2, 16, 5);
		legBackRight.setTextureSize(textureWidth, textureHeight);
		legBackLeft = new ModelRenderer(this, 28, 16);
		legBackLeft.addBox(-1, 0, -1, 2, 8, 2);
		legBackLeft.setRotationPoint(2, 16, 5);
		legBackLeft.setTextureSize(textureWidth, textureHeight);
		legFrontRight = new ModelRenderer(this, 28, 16);
		legFrontRight.addBox(-1, 0, -1, 2, 8, 2);
		legFrontRight.setRotationPoint(-2, 16, -3);
		legFrontRight.setTextureSize(textureWidth, textureHeight);
		legFrontLeft = new ModelRenderer(this, 28, 16);
		legFrontLeft.addBox(-1, 0, -1, 2, 8, 2);
		legFrontLeft.setRotationPoint(2, 16, -3);
		legFrontLeft.setTextureSize(textureWidth, textureHeight);
	}
	
	@Override
	public void render(Entity parEntity, float parTime, float parSwingSuppress, float par4, float parHeadAngleY, float parHeadAngleX, float par7)
	{
		legBackRight.rotateAngleX = (float) Math.sin((parEntity.ticksExisted % 20) * (Math.PI / 10));
		legBackLeft.rotateAngleX = (float) Math.sin((parEntity.ticksExisted % 20) * (Math.PI / 10) * -1);
		legFrontRight.rotateAngleX = (float) Math.sin((parEntity.ticksExisted % 20) * (Math.PI / 10) * -1);
		legFrontLeft.rotateAngleX = (float) Math.sin((parEntity.ticksExisted % 20) * (Math.PI / 10));
		headBase.render(par7);
		body.render(par7);
		legBackRight.render(par7);
		legBackLeft.render(par7);
		legFrontRight.render(par7);
		legFrontLeft.render(par7);
	}
	
	/*
	public void renderDeer(EntityDeer deer)
	{
		
	}
	*/
	
	private void setRotation(ModelRenderer model, float rotationX, float rotationY, float rotationZ)
	{
		model.rotateAngleX = rotationX;
		model.rotateAngleY = rotationY;
		model.rotateAngleZ = rotationZ;
	}
}
