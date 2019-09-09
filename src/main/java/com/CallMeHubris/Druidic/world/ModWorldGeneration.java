package com.CallMeHubris.Druidic.world;

import java.util.Random;

import com.CallMeHubris.Druidic.init.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ModWorldGeneration implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		//Overworld generation
		if(world.provider.getDimension() == 0)
		{
			//Amber generates everywhere
			generateOre(ModBlocks.AMBER_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 64, (random.nextInt(4) * 4) + 4, 16);
			
			/* 
			 * Citrine 25% to generate in a chunk
			 * Sappire 25% to generate in a chunk
			 * Carnelian 25% to generate in a chunk
			 * Onyx 25% to generate in a chunk
			 * Opal 10% to generate in a chunk in place of one of the other gems
			 */
			switch(random.nextInt(4))
			{
				case 0 : 
					if(random.nextInt(10) > 0)
						generateOre(ModBlocks.CITRINE_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 32, (random.nextInt(3) * 2) + 4, 8);
					else
						generateOre(ModBlocks.OPAL_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 32, (random.nextInt(3) * 2) + 4, 8);
					break;
				case 1 :
					if(random.nextInt(10) > 0)
						generateOre(ModBlocks.SAPPHIRE_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 32, (random.nextInt(3) * 2) + 4, 8);
					else
						generateOre(ModBlocks.OPAL_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 32, (random.nextInt(3) * 2) + 4, 8);
					break;
				case 2 :
					if(random.nextInt(10) > 0)
						generateOre(ModBlocks.CARNELIAN_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 32, (random.nextInt(3) * 2) + 4, 8);
					else
						generateOre(ModBlocks.OPAL_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 32, (random.nextInt(3) * 2) + 4, 8);
					break;
				case 3 :
					if(random.nextInt(10) > 0)
						generateOre(ModBlocks.ONYX_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 32, (random.nextInt(3) * 2) + 4, 8);
					else
						generateOre(ModBlocks.OPAL_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 32, (random.nextInt(3) * 2) + 4, 8);
					break;
			}
			
			//Only generates sunstone or moonstone in a single chunk
			if(random.nextInt(2) > 0)
				generateOre(ModBlocks.SUNSTONE_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 16, random.nextInt(4) + 1, 4);
			else
				generateOre(ModBlocks.MOONSTONE_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 0, 16, random.nextInt(4) + 1, 4);
		}
	}
	
	//Ore generation
	private void generateOre(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chance)
	{
		int deltaY = maxY - minY;
		
		WorldGenMinable generator = new WorldGenMinable(ore, size);
		BlockPos pos;
		for(int k = 0 ; k < chance; k++)
		{
			pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));
			generator.generate(world, random, pos);
		}
	}
}
