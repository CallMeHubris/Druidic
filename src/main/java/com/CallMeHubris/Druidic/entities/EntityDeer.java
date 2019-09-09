package com.CallMeHubris.Druidic.entities;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

public class EntityDeer extends EntityPigZombie
{
	public EntityDeer(World worldIn) 
	{
		super(worldIn);
		this.setSize(1, 1);
	}
	
	@Override
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
		if(this.isPotionActive(Potion.getPotionById(20)))
		{
			this.removeActivePotionEffect(Potion.getPotionById(20));
		}
	}
	
	@Override
	protected SoundEvent getAmbientSound()
    {
        return SoundEvents.ENTITY_GHAST_AMBIENT;
    }

	@Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundEvents.ENTITY_GHAST_HURT;
    }

	@Override
    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_GHAST_DEATH;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return LootTableList.EMPTY;
    }
	
	/*
	private void becomeAngryAt(Entity p_70835_1_)
    {
        this.angerLevel = 400 + this.rand.nextInt(400);
        this.randomSoundDelay = this.rand.nextInt(40);

        if (p_70835_1_ instanceof EntityLivingBase)
        {
            this.setRevengeTarget((EntityLivingBase)p_70835_1_);
        }
    }
    */
	
	/*
	@Override
	protected void entityInit() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound) 
	{
		// TODO Auto-generated method stub
		
	}
	*/

}
