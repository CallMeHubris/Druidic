package com.CallMeHubris.Druidic.blocks;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class GemOre extends BlockBase
{
	private Item drop;

	public GemOre(String name, Item drop, Material material, int miningLevel) 
	{
		super(name, material);
		setSoundType(SoundType.STONE);
		setHardness(3.0f);
		setResistance(15.0f);
		setHarvestLevel("pickaxe", miningLevel);
		this.drop = drop;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return drop;
	}
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random rand)
	{
		int quantity;
		quantity = rand.nextInt(fortune + 1);
		if(quantity == 0) {quantity++;}
		return quantity;
	}

}
