package com.CallMeHubris.Druidic.items.tools;

import java.util.Map;

import com.CallMeHubris.Druidic.Main;
import com.CallMeHubris.Druidic.init.ModEffects;
import com.CallMeHubris.Druidic.init.ModItems;
import com.CallMeHubris.Druidic.util.IHasModel;
import com.google.common.collect.Multimap;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ToolSword extends ItemSword implements IHasModel
{
	private float baseDamage;
	private float bonusDamage;
	
	public ToolSword(String name, ToolMaterial material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.COMBAT);
			
		baseDamage = 3.0F + material.getAttackDamage();
		bonusDamage = 0;
		
		ModItems.ITEMS.add(this);
	}

	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	@Override 
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
	{
		//Check to see if entity is a child of EntityLiving
		if(EntityLiving.class.isAssignableFrom(entity.getClass())) 
		{
			//Check if the player has active effects on them
			Map<Potion, PotionEffect> activeEffects = player.getActivePotionMap();
			
			if(!activeEffects.isEmpty())
			{
				//Infusion effects on a grass sword
				if(this.getToolMaterialName() == "material_grass")
				{
					if(activeEffects.containsKey(ModEffects.AMBER_INFUSED))
					{
						//Apply a short duration strength effect with the same level as the infusion
						player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 100, activeEffects.get(ModEffects.AMBER_INFUSED).getAmplifier()));
						player.removePotionEffect(ModEffects.AMBER_INFUSED);
					}
					else if(activeEffects.containsKey(ModEffects.CARNELIAN_INFUSED))
					{
						//Set the target on fire based on the level of the infusion
						entity.setFire(5 * (1 + activeEffects.get(ModEffects.CARNELIAN_INFUSED).getAmplifier()));
						player.removePotionEffect(ModEffects.CARNELIAN_INFUSED);
					}
					else if(activeEffects.containsKey(ModEffects.CITRINE_INFUSED))
					{
						//Apply a short duration luck effect with the same level as the infusion
						player.addPotionEffect(new PotionEffect(MobEffects.LUCK, 100, activeEffects.get(ModEffects.CITRINE_INFUSED).getAmplifier()));
						player.removePotionEffect(ModEffects.CITRINE_INFUSED);
					}
					else if(activeEffects.containsKey(ModEffects.ONYX_INFUSED))
					{
						//Apply a short duration weakness effect on the target with the same level as the infusion
						((EntityLiving)entity).addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 200, activeEffects.get(ModEffects.ONYX_INFUSED).getAmplifier()));
						player.removePotionEffect(ModEffects.ONYX_INFUSED);
					}
					else if(activeEffects.containsKey(ModEffects.OPAL_INFUSED))
					{
						//Apply an invisibility effect with the duration based on the infusion level
						player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 100 * (1 + activeEffects.get(ModEffects.OPAL_INFUSED).getAmplifier()), 0));
						player.removePotionEffect(ModEffects.OPAL_INFUSED);
					}
					else if(activeEffects.containsKey(ModEffects.SAPPHIRE_INFUSED))
					{
						//Apply a glowing effect on the target with the duration based on the infusion level
						((EntityLiving)entity).addPotionEffect(new PotionEffect(MobEffects.GLOWING, 200 * (1 + activeEffects.get(ModEffects.SAPPHIRE_INFUSED).getAmplifier()), 0));
						player.removePotionEffect(ModEffects.SAPPHIRE_INFUSED);
					}
					/*
					 * Sunstone infusion should add extra physical damage to the
					 * attack once. Currently doesn't work.
					 */
					else if(activeEffects.containsKey(ModEffects.SUNSTONE_INFUSED))
					{
						//Instantly deals extra physical damage based on the level of the infusion
						bonusDamage += 10.0f * (1 + activeEffects.get(ModEffects.SUNSTONE_INFUSED).getAmplifier());
						player.removePotionEffect(ModEffects.SUNSTONE_INFUSED);
					}
					else if(activeEffects.containsKey(ModEffects.MOONSTONE_INFUSED))
					{
						//Instantly deals extra magical damage based on the level of the infusion
						//Does healing instead to undead
						if(!((EntityLiving)entity).isEntityUndead())
						{
							((EntityLiving)entity).addPotionEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE, 1, activeEffects.get(ModEffects.MOONSTONE_INFUSED).getAmplifier()));
						}
						else
						{
							((EntityLiving)entity).addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 1, 2 + (2 * activeEffects.get(ModEffects.MOONSTONE_INFUSED).getAmplifier())));
						}
						player.removePotionEffect(ModEffects.MOONSTONE_INFUSED);
					}
				}
			}
		}
		return false;
	}
	
	/*
	 * Adds the accumulated bonus damage to the attack of the sword
	 * @see net.minecraft.item.ItemSword#getAttackDamage()
	 */
	@Override
	public float getAttackDamage()
	{
		return super.getAttackDamage() + bonusDamage;
	}
	
	/*
	 * Added bonus damage to the damage calculation
	 * @see net.minecraft.item.ItemSword#getItemAttributeModifiers(net.minecraft.inventory.EntityEquipmentSlot)
	 */
	@Override
	public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
    {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND)
        {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)(this.baseDamage + bonusDamage), 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2.4000000953674316D, 0));
        }
        
        return multimap;
    }
	
	/*
	 * Bonus damage is reset after an entity is hit
	 * @see net.minecraft.item.ItemSword#hitEntity(net.minecraft.item.ItemStack, net.minecraft.entity.EntityLivingBase, net.minecraft.entity.EntityLivingBase)
	 */
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
	{
		bonusDamage = 0;
		return false;
	}
	
}
