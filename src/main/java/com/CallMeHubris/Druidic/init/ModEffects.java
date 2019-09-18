package com.CallMeHubris.Druidic.init;

import java.util.ArrayList;
import java.util.List;

import com.CallMeHubris.Druidic.magic.potions.*;

import net.minecraft.potion.Potion;

public class ModEffects 
{
	public static final List<Potion> EFFECTS = new ArrayList<Potion>();
	
	public static final Potion AMBER_INFUSED = new InfusedEffect(false, InfusedSource.AMBER);
	public static final Potion CARNELIAN_INFUSED = new InfusedEffect(false, InfusedSource.CARNELIAN);
	public static final Potion CITRINE_INFUSED = new InfusedEffect(false, InfusedSource.CITRINE);
	public static final Potion ONYX_INFUSED = new InfusedEffect(false, InfusedSource.ONYX);
	public static final Potion OPAL_INFUSED = new InfusedEffect(false, InfusedSource.OPAL);
	public static final Potion SAPPHIRE_INFUSED = new InfusedEffect(false, InfusedSource.SAPPHIRE);
	public static final Potion SUNSTONE_INFUSED = new InfusedEffect(false, InfusedSource.SUNSTONE);
	public static final Potion MOONSTONE_INFUSED = new InfusedEffect(false, InfusedSource.MOONSTONE);
	
	/*
	 * Converts a string based hexadecimal into an integer
	 */
	public static int convertColor(String colorIn)
	{
		int[] rgb = new int[3];
		for(int k = 0; k < 3; k++)
		{
			int color = 0;
			for(int j = 0; j < 2; j++)
			{
				int value = 0;
				switch(colorIn.toLowerCase().charAt((k * 2) + j))
				{
					case '0': value = 0; break;
					case '1': value = 1; break;
					case '2': value = 2; break;
					case '3': value = 3; break;
					case '4': value = 4; break;
					case '5': value = 5; break;
					case '6': value = 6; break;
					case '7': value = 7; break;
					case '8': value = 8; break;
					case '9': value = 9; break;
					case 'a': value = 10; break;
					case 'b': value = 11; break;
					case 'c': value = 12; break;
					case 'd': value = 13; break;
					case 'e': value = 14; break;
					case 'f': value = 15; break;
				}
				if(j == 0)
				{
					value <<= 4;
				}
				color |= value;
			}
			rgb[k] = color;
		}
		
		return (rgb[0] << 16) | (rgb[1] << 8) | rgb[2];
	}
}
