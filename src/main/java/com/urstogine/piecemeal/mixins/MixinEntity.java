package com.urstogine.piecemeal.mixins;

import net.minecraft.entity.Entity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Entity.class)
public abstract class MixinEntity {
    @Shadow public double posX;
    @Shadow public double posY;
    @Shadow public double posZ;
    @Shadow public World world;
    @Inject(method = "onEntityUpdate",at = @At(value = "HEAD"))
    public void onEntityUpdate(CallbackInfo ci) {
        if (!world.isRemote) {
            world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, posX,
                    posY + 2.0d, posZ, 0, 0, 0);
        }
    }
}