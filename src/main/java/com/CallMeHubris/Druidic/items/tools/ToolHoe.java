package com.CallMeHubris.Druidic.items.tools;

import com.CallMeHubris.Druidic.Main;
import com.CallMeHubris.Druidic.init.ModItems;
import com.CallMeHubris.Druidic.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemHoe;

public class ToolHoe extends ItemHoe implements IHasModel
{
	public ToolHoe(String name, ToolMaterial material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.TOOLS);
			
		ModItems.ITEMS.add(this);
	}

	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
