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
	/*
	@SubscribeEvent
	public static void blockHarvest(HarvestDropsEvent event)
	{
		System.out.println("Block Harvested");
		if(!event.isSilkTouching())
		{
			if(event.getState() == Blocks.TALLGRASS.getDefaultState().withProperty(BlockTallGrass.TYPE, BlockTallGrass.EnumType.GRASS))
			{
				event.setDropChance(0.05f);
				event.getDrops().add(new ItemStack(ModItems.ANCIENT_SEEDS, 1));
			}
			else
			{
				System.out.println("Grass not found");
			}
		}
	}
	*/
	
	@SubscribeEvent
	public static void modifyLootTables(LootTableLoadEvent event)
	{
		if(event.getName() == Blocks.TALLGRASS.getRegistryName())
		{
			LootEntry entry = new LootEntryItem(ModItems.ANCIENT_SEEDS, 1, 1, null, null, "ancient_seeds");
			
			List<LootEntry> entriesIn = new ArrayList<LootEntry>();
			entriesIn.add(entry);
			
			LootPool pool = new LootPool((LootEntry[])entriesIn.toArray(), null, new RandomValueRange(1.0f), new RandomValueRange(0.0f), "druidicPool");
			event.getTable().addPool(pool);
		}
		
	}
}
