package com.CallMeHubris.Druidic.magic.potions;

import net.minecraft.potion.Potion;

public class InfusedEffect extends Potion
{
	private final InfusedSource source;

	public InfusedEffect(boolean isBadEffectIn, InfusedSource sourceIn) 
	{
		super(isBadEffectIn, sourceIn.getColor());
		source = sourceIn;
	}
	
	@Override
	public boolean isReady(int duration, int amplifier)
	{
		return false;
	}
}
