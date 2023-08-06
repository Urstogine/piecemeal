package com.urstogine.piecemeal.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import org.objectweb.asm.Opcodes;

import net.minecraft.world.Teleporter;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

@Mixin(Teleporter.class)
public abstract class MixinTeleporter {
	
	@Redirect(method = "makePortal", at = @At(value = "FIELD", target = "net.minecraft.init.Blocks.OBSIDIAN:Lnet/minecraft/block/Block;", opcode = Opcodes.GETSTATIC))
	private Block proxy_makePortal_getStatic_OBSIDIAN() {
		return Blocks.LOG;
	}

	@Redirect(method = "placeInPortal", at = @At(value = "FIELD", target = "net.minecraft.init.Blocks.OBSIDIAN:Lnet/minecraft/block/Block;", opcode = Opcodes.GETSTATIC))
	private Block proxy_placeInPortal_getStatic_OBSIDIAN() {
		return Blocks.LOG;
	}
}
