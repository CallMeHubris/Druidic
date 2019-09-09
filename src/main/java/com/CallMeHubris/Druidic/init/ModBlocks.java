package com.CallMeHubris.Druidic.init;

import java.util.ArrayList;
import java.util.List;

import com.CallMeHubris.Druidic.blocks.*;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block OWO_BLOCK = new OwOBlock("owo_block", Material.ROCK);
	public static final Block AMBER_ORE = new GemOre("amber_ore", ModItems.AMBER, Material.ROCK, 1);
	public static final Block CARNELIAN_ORE = new GemOre("carnelian_ore", ModItems.CARNELIAN, Material.ROCK, 2);
	public static final Block CITRINE_ORE = new GemOre("citrine_ore", ModItems.CITRINE, Material.ROCK, 2);
	public static final Block ONYX_ORE = new GemOre("onyx_ore", ModItems.ONYX, Material.ROCK, 2);
	public static final Block SAPPHIRE_ORE = new GemOre("sapphire_ore", ModItems.SAPPHIRE, Material.ROCK, 2);
	public static final Block OPAL_ORE = new GemOre("opal_ore", ModItems.OPAL, Material.ROCK, 2);
	public static final Block SUNSTONE_ORE = new GemOre("sunstone_ore", ModItems.SUNSTONE, Material.ROCK, 3);
	public static final Block MOONSTONE_ORE = new GemOre("moonstone_ore", ModItems.MOONSTONE, Material.ROCK, 3);
}
