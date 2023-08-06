package com.urstogine.piecemeal.item;

import com.urstogine.piecemeal.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ItemArmorBase extends ItemArmor {
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL = EnumHelper.addArmorMaterial(
            "COPPER", Main.MODID + ":copper", -1, new int[] {0, 0, 0, 6}, 20, SoundEvents.ENTITY_BAT_LOOP, 4);

    public ItemArmorBase(EntityEquipmentSlot equipmentSlotIn) {
        super(ARMOR_MATERIAL, 0, equipmentSlotIn);
        //setUnlocalizedName(Main.MODID + ".copperArmor." + equipmentSlotIn.getName());
        setRegistryName("copper_armor_" + equipmentSlotIn.getName());
        setCreativeTab(CreativeTabs.TOOLS);
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);

    }
    @Override
    public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player) {
        return super.onDroppedByPlayer(item, player);
    }
}
