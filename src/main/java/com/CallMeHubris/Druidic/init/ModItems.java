package com.CallMeHubris.Druidic.init;

import java.util.ArrayList;
import java.util.List;

import com.CallMeHubris.Druidic.items.ItemBase;
import com.CallMeHubris.Druidic.items.AncientSeeds;
import com.CallMeHubris.Druidic.items.armor.ArmorBase;
import com.CallMeHubris.Druidic.items.tools.*;
import com.CallMeHubris.Druidic.util.Reference;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Materials
	public static final ToolMaterial MATERIAL_OWO = EnumHelper.addToolMaterial("material_owo", 69, 9001, 10.0f, 50.0f, 100);
	public static final ToolMaterial MATERIAL_GRASS = EnumHelper.addToolMaterial("material_grass", 1, 150, 3.0f, 1.0f, 18);
	public static final ArmorMaterial ARMOR_MATERIAL_CLOTH = EnumHelper.addArmorMaterial("armor_material_cloth", Reference.MOD_ID + ":cloth", 10, new int[]{1, 4, 5, 2}, 20, SoundEvents.BLOCK_CLOTH_PLACE, 0.0f);
	
	//Items
	public static final Item OWO = new ItemBase("owo");
	public static final Item ANCIENT_SEEDS = new AncientSeeds("ancient_seeds");
	public static final Item AMBER = new ItemBase("amber");					//Power - None
	public static final Item CARNELIAN = new ItemBase("carnelian");			//Protection - Fire		
	public static final Item CITRINE = new ItemBase("citrine");				//Fortune - Air
	public static final Item ONYX = new ItemBase("onyx");					//Ward Evil/Purification - Earth
	public static final Item OPAL = new ItemBase("opal");					//Flexibe/Invisibility - Any
	public static final Item SAPPHIRE = new ItemBase("sapphire");			//Divination - Water
	public static final Item SUNSTONE = new ItemBase("sunstone");			//Physical Power - Solar
	public static final Item MOONSTONE = new ItemBase("moonstone");			//Magical Power - Lunar
	
	//Tools
	public static final ItemSword OWO_SWORD = new ToolSword("owo_sword", MATERIAL_OWO);
	public static final ItemSword GRASS_SWORD = new ToolSword("grass_sword", MATERIAL_GRASS);
	public static final ItemPickaxe GRASS_PICKAXE = new ToolPickaxe("grass_pickaxe", MATERIAL_GRASS);
	public static final ItemAxe GRASS_AXE = new ToolAxe("grass_axe", MATERIAL_GRASS);
	public static final ItemSpade GRASS_SHOVEL = new ToolSpade("grass_shovel", MATERIAL_GRASS);
	public static final ItemHoe GRASS_HOE = new ToolHoe("grass_hoe", MATERIAL_GRASS);
	public static final ItemShears WOODEN_SHEARS = new ToolShears("wooden_shears");
	
	//Armor
	public static final Item DRUID_ROBE = new ArmorBase("druid_robe", ARMOR_MATERIAL_CLOTH, 1, EntityEquipmentSlot.CHEST);
}
