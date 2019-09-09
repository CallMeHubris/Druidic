package com.CallMeHubris.Druidic.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class OwOBlock extends BlockBase
{

	public OwOBlock(String name, Material material) 
	{
		super(name, material);
		
		setSoundType(SoundType.CLOTH);
		setHardness(0);
		setResistance(18000000.0f);
		setHarvestLevel("hoe", 0);
		setLightLevel(4.0f);
		setLightOpacity(1);
		//setBlockUnbreakable();
	}

}
