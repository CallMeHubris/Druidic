package com.CallMeHubris.Druidic.blocks;

import com.CallMeHubris.Druidic.init.ModEffects;
import com.CallMeHubris.Druidic.init.ModItems;
import com.CallMeHubris.Druidic.magic.potions.*;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiScreenEvent.PotionShiftEvent;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Altar extends BlockBase
{
	Random random;
	
	public Altar(String name, Material material) 
	{
		super(name, material);
		random = new Random();
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		ItemStack heldItem = playerIn.getHeldItem(hand);
		if(heldItem == null)
		{
			return true;
		}
		Item item = heldItem.getItem();
		
		//Only affect the server side
		if(!worldIn.isRemote)
		{
			Map<Potion, PotionEffect> activeEffects = playerIn.getActivePotionMap();
			
			/*
			 * checks to see if the player has an item that activates the altar twice
			 * 	first iteration checks the main hand
			 * 	second iteration checks the off hand
			 */
			if(item == ModItems.AMBER)
			{
				heldItem.shrink(1);
				
				if(activeEffects.containsKey(ModEffects.AMBER_INFUSED))
				{
					playerIn.removePotionEffect(ModEffects.AMBER_INFUSED);
					playerIn.addPotionEffect(new PotionEffect(MobEffects.POISON, 200, 0));
					playerIn.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 200, 1));
				}
				else
				{
					playerIn.addPotionEffect(new PotionEffect(ModEffects.AMBER_INFUSED, 1200, 0));
				}
				
				return true;
			}
			else if(item == ModItems.CARNELIAN)
			{
				if(activeEffects.containsKey(ModEffects.AMBER_INFUSED))
				{
					heldItem.shrink(1);
					playerIn.addPotionEffect(new PotionEffect(ModEffects.CARNELIAN_INFUSED, 1200, activeEffects.get(ModEffects.AMBER_INFUSED).getAmplifier()));
					playerIn.removePotionEffect(ModEffects.AMBER_INFUSED);
					return true;
				}
				return false;
			}
			else if(item == ModItems.CITRINE)
			{
				if(activeEffects.containsKey(ModEffects.AMBER_INFUSED))
				{
					heldItem.shrink(1);
					playerIn.addPotionEffect(new PotionEffect(ModEffects.CITRINE_INFUSED, 1200, activeEffects.get(ModEffects.AMBER_INFUSED).getAmplifier()));
					playerIn.removePotionEffect(ModEffects.AMBER_INFUSED);
					return true;
				}
				return false;
			}
			else if(item == ModItems.ONYX)
			{
				if(activeEffects.containsKey(ModEffects.AMBER_INFUSED))
				{
					heldItem.shrink(1);
					playerIn.addPotionEffect(new PotionEffect(ModEffects.ONYX_INFUSED, 1200, activeEffects.get(ModEffects.AMBER_INFUSED).getAmplifier()));
					playerIn.removePotionEffect(ModEffects.AMBER_INFUSED);
					return true;
				}
				return false;
			}
			else if(item == ModItems.OPAL)
			{
				if(activeEffects.containsKey(ModEffects.AMBER_INFUSED))
				{
					heldItem.shrink(1);
					playerIn.addPotionEffect(new PotionEffect(ModEffects.OPAL_INFUSED, 1200, activeEffects.get(ModEffects.AMBER_INFUSED).getAmplifier()));
					playerIn.removePotionEffect(ModEffects.AMBER_INFUSED);
					return true;
				}
				return false;
			}
			else if(item == ModItems.SAPPHIRE)
			{
				if(activeEffects.containsKey(ModEffects.AMBER_INFUSED))
				{
					heldItem.shrink(1);
					playerIn.addPotionEffect(new PotionEffect(ModEffects.SAPPHIRE_INFUSED, 1200, activeEffects.get(ModEffects.AMBER_INFUSED).getAmplifier()));
					playerIn.removePotionEffect(ModEffects.AMBER_INFUSED);
					return true;
				}
				return false;
			}
			else if(item == ModItems.SUNSTONE)
			{
				if(activeEffects.containsKey(ModEffects.AMBER_INFUSED))
				{
					heldItem.shrink(1);
					playerIn.addPotionEffect(new PotionEffect(ModEffects.SUNSTONE_INFUSED, 1200, activeEffects.get(ModEffects.AMBER_INFUSED).getAmplifier()));
					playerIn.removePotionEffect(ModEffects.AMBER_INFUSED);
					return true;
				}
				return false;
			}
			else if(item == ModItems.MOONSTONE)
			{
				if(activeEffects.containsKey(ModEffects.AMBER_INFUSED))
				{
					heldItem.shrink(1);
					playerIn.addPotionEffect(new PotionEffect(ModEffects.MOONSTONE_INFUSED, 1200, activeEffects.get(ModEffects.AMBER_INFUSED).getAmplifier()));
					playerIn.removePotionEffect(ModEffects.AMBER_INFUSED);
					return true;
				}
				return false;
			}
		}
		/*
		 * Particles can only be spawned on the client side
		 * Returning true when called on the client side prevents the
		 * 	method from running twice each click
		 */
		else
		{
			spawnParticles(worldIn, item, pos.getX(), pos.getY(), pos.getZ());
			return true;
		}
		//default return
		return false;
	}
	
	private void spawnParticles(World worldIn, Item item, double xPos, double yPos, double zPos)
	{
		if(item == ModItems.AMBER)
		{
			int particlesSpawned = 10;
			
			double xOff;
			double yOff;
			double zOff;
			
			for(int k = 0; k < particlesSpawned; k++)
			{
				xOff = 0.5 + (random.nextGaussian() * 0.25);
				yOff = 1 + random.nextDouble();
				zOff = 0.5 + (random.nextGaussian() * 0.25);
				worldIn.spawnParticle(EnumParticleTypes.SPELL_WITCH, true, xPos + xOff, yPos + yOff, zPos + zOff, 0.0, 1.0, 0.0);
			}
		}
	}
}
