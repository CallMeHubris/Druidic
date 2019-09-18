package com.CallMeHubris.Druidic.items;

import java.util.List;

import com.CallMeHubris.Druidic.init.ModItems;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class AncientSeeds extends ItemBase
{
	private boolean plantable;
	public AncientSeeds(String name) 
	{
		super(name);
		plantable = false;
	}
	
	@Override
	public boolean onEntityItemUpdate(EntityItem item) 
	{
		/*
		 * checks if the item is in water then attempts to do
		 * in world crafting that takes place in water
		 */
		if(item.isInWater() && !item.getEntityWorld().isRemote)
		{
			//Gets all items in the same water block
			AxisAlignedBB checkInWater = new AxisAlignedBB(new BlockPos(item));
			List<EntityItem> items = item.getEntityWorld().getEntitiesWithinAABB(EntityItem.class, checkInWater);
			for(EntityItem k : items) 
			{
				
				switch(Item.getIdFromItem(k.getItem().getItem())) 
				{
					/*
					 * Checks if the item is a wooden tool for
					 * grass tool crafting
					 */
					case 268 :
						EntityItem sword = item.entityDropItem(new ItemStack(ModItems.GRASS_SWORD), 0.5f);
						sword.getItem().addEnchantment(Enchantment.getEnchantmentByLocation("mending"), 1);
						k.getItem().shrink(1); item.getItem().shrink(1); return true;
					case 269:
						EntityItem shovel = item.entityDropItem(new ItemStack(ModItems.GRASS_SHOVEL), 0.5f);
						shovel.getItem().addEnchantment(Enchantment.getEnchantmentByLocation("mending"), 1);
						k.setDead(); item.setDead(); return true;
					case 270 :
						EntityItem pickaxe = item.entityDropItem(new ItemStack(ModItems.GRASS_PICKAXE), 0.5f);
						pickaxe.getItem().addEnchantment(Enchantment.getEnchantmentByLocation("mending"), 1);
						k.setDead(); item.setDead(); return true;
					case 271 :
						EntityItem axe = item.entityDropItem(new ItemStack(ModItems.GRASS_AXE), 0.5f);
						axe.getItem().addEnchantment(Enchantment.getEnchantmentByLocation("mending"), 1);
						k.setDead(); item.setDead(); return true;
					case 290 :
						EntityItem hoe = item.entityDropItem(new ItemStack(ModItems.GRASS_HOE), 0.5f);
						hoe.getItem().addEnchantment(Enchantment.getEnchantmentByLocation("mending"), 1);
						k.setDead(); item.setDead(); return true;
					/*
					 * checks for rotten flesh and bone meal to awaken the seed
					 */
					
				}
					
			}
			
			/*
			if(items.contains())
			{
				plantable = true;
				items.get(items.indexOf(Items.ROTTEN_FLESH)).getItem().shrink(1);
			}*/
		}
		return false;
	}
	
	
}
