package com.CallMeHubris.Druidic.magic.potions;

import com.CallMeHubris.Druidic.init.ModEffects;

public enum InfusedSource 
{
	AMBER ("FF00FF"),
	CARNELIAN ("FF0000"),
	CITRINE ("FFFF00"),
	ONYX ("000000"),
	OPAL("FFFFFF"),
	SAPPHIRE ("0080FF"),
	SUNSTONE ("FF9933"),
	MOONSTONE ("CCFFFF");
	
	private final String hexColor;
	
	InfusedSource(String hexColorIn)
	{
		hexColor = hexColorIn;
	}
	
	public int getColor()
	{
		return ModEffects.convertColor(hexColor);
	}
}
