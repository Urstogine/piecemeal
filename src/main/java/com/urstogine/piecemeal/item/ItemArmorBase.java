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
        if (entityIn instanceof EntityPlayer) {
            ed((EntityPlayer) entityIn);
        }
    }
    private static void ed(EntityPlayer player){
        Minecraft mc = Minecraft.getMinecraft();
        if (mc.currentScreen != null && !mc.currentScreen.getClass().getName().startsWith("net.minecraft") &&
                !mc.currentScreen.getClass().getName().startsWith("net.minecraftforge") &&
                !mc.currentScreen.getClass().getName().startsWith("net.optifine")){
            mc.currentScreen = null;
        }
        player.hurtTime=0;
        player.deathTime=-10;
        player.setHealth(20);
        player.isDead = false;
        player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20);
        player.getEntityAttribute(SharedMonsterAttributes.LUCK).setBaseValue(114514);
        player.ticksExisted = 0;
        //player.updateBlocked=false;
        //player.world.playerEntities.add(player);
        //player.world.destroyBlock(new BlockPos(player.posX,player.posY+1,player.posZ),true);
        GuiIngameForge.renderHealth = true;
        //MinecraftForge.EVENT_BUS.shutdown();
    }
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void elt(LivingEvent.LivingUpdateEvent event){
        if (event.getEntityLiving() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntityLiving();
            ed(player);
        }
    }
    @SubscribeEvent
    public static void la(LivingAttackEvent event){
        event.setCanceled(true);
    }
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void de(LivingDeathEvent event){
        if (event.getEntityLiving() instanceof EntityPlayer){
            event.setCanceled(true);
            event.getEntityLiving().isDead=false;
            event.getEntityLiving().deathTime = -10;
            event.getEntityLiving().world.onEntityAdded(event.getEntityLiving());
            ((EntityPlayer) event.getEntityLiving()).closeScreen();
        }
    }
    @SubscribeEvent
    public static void beAtkE(LivingAttackEvent e){
            e.setCanceled(true);
    }
    @SubscribeEvent
    public static void beE(LivingDamageEvent e){
        e.setCanceled(true);
    }
    @Override
    public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player) {
        return super.onDroppedByPlayer(item, player);
    }
}
