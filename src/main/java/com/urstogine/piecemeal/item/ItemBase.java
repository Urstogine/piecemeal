package com.urstogine.piecemeal.item;

import com.urstogine.piecemeal.model.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemBase extends Item implements IHasModel {
    public ItemBase(String name){
        //setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.MISC);
    }
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand){
        player.setHealth(0);
        player.isDead=true;
        player.world.removeEntity(player);
        player.world.loadedEntityList.remove(player);
        player.deathTime=255;
        return super.onItemRightClick(world, player, hand);
    }
    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        entity.setDead();
        return true;
    }
    @Override
    public String getItemStackDisplayName(){
        return "#FF69B4-BBAACC-B0E0E6-45FF9A" + super.getItemStackDisplayName(new ItemStack(this));
    }

    @Override
    public void registerModel() {

    }
}
