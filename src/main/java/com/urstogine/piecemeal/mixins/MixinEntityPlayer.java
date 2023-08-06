package com.urstogine.piecemeal.mixins;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumParticleTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = EntityPlayer.class)
public class MixinEntityPlayer {
    @Inject(method = "jump", at = @At(value = "HEAD"),remap = true)
    private void onJump(CallbackInfo ci) {
        EntityLivingBase entity = (EntityLivingBase) (Object) this;
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            if (!player.world.isRemote) {
                player.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, player.posX,
                        player.posY + 1.0d, player.posZ, 0, 0, 0);
            }
            player.posY+=0.1d;
        }
    }
}