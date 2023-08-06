package com.urstogine.piecemeal.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import org.objectweb.asm.Opcodes;

import net.minecraft.block.BlockPortal;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

@Mixin(BlockPortal.Size.class)
public abstract class MixinBlockPortal {
	
	@Redirect(method = "getDistanceUntilEdge", at = @At(value = "FIELD", target = "net.minecraft.init.Blocks.OBSIDIAN:Lnet/minecraft/block/Block;", opcode = Opcodes.GETSTATIC))
	private Block proxy_getDistanceUntilEdge_getStatic_OBSIDIAN() {
		return Blocks.LOG;
	}
	
	@Redirect(method = "calculatePortalHeight", at = @At(value = "FIELD", target = "net.minecraft.init.Blocks.OBSIDIAN:Lnet/minecraft/block/Block;", opcode = Opcodes.GETSTATIC))
	private Block proxy_calculatePortalHeight_getStatic_OBSIDIAN() {
		return Blocks.LOG;
	}
}
