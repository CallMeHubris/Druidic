package com.CallMeHubris.Druidic.util.handlers;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

import java.util.ArrayList;
import java.util.List;

import com.CallMeHubris.Druidic.init.ModItems;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTableManager;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.block.BlockTallGrass;


@Mod.EventBusSubscriber
public class EventHandler 
{
	
	@SubscribeEvent
	public static void blockHarvest(HarvestDropsEvent event)
	{
		if(event.getState().getBlock() == Blocks.TALLGRASS)
		{
			//The drop rate of ancient seeds varies depending on if the grass broken was a normal
			//	tall grass block or a fern
			if(event.getState() == Blocks.TALLGRASS.getDefaultState().withProperty(BlockTallGrass.TYPE, BlockTallGrass.EnumType.GRASS))
			{
				event.getDrops().add(new ItemStack(ModItems.ANCIENT_SEEDS, 1));
				event.setDropChance(0.01f + (0.3f * event.getFortuneLevel()));
			}
			else if(event.getState() == Blocks.TALLGRASS.getDefaultState().withProperty(BlockTallGrass.TYPE, BlockTallGrass.EnumType.FERN))
			{
				event.getDrops().add(new ItemStack(ModItems.ANCIENT_SEEDS, 1));
				event.setDropChance(0.05f + (0.5f * event.getFortuneLevel()));
			}
		}	
	}
	
}
