package com.CallMeHubris.Druidic.items.tools;

import com.CallMeHubris.Druidic.Main;
import com.CallMeHubris.Druidic.init.ModItems;
import com.CallMeHubris.Druidic.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemShears;

public class ToolShears extends ItemShears implements IHasModel
{
	
	public ToolShears(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setMaxStackSize(1);
        setMaxDamage(128);
        setCreativeTab(CreativeTabs.TOOLS);
        
        ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
