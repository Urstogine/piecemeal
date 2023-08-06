package com.urstogine.piecemeal.coremod;


import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraftforge.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

public class piecemealTransformer implements IClassTransformer {
    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        if ("net.minecraft.entity.EntityLivingBase".equals(transformedName)) {
            ClassReader cr = new ClassReader(basicClass);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode method : cn.methods){
                String srg = FMLDeobfuscatingRemapper.INSTANCE.mapMethodName(name, method.name, method.desc);
                if ("func_110143_aJ".equals(srg)){
                    method.instructions.clear();
                    method.instructions.add(new VarInsnNode(Opcodes.AALOAD,0));
                    method.instructions.add(new MethodInsnNode(Opcodes.INVOKEDYNAMIC,
                            "com/urstogine/piecemeal/coremod/coreUtil","getHealth",
                            "(Lnet/minecraft/entity/EntityLivingBase;)F",false));
                    method.instructions.add(new InsnNode(Opcodes.FRETURN));
                }
            }
            ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES|ClassWriter.COMPUTE_MAXS);
            cn.accept(classWriter);
            return classWriter.toByteArray();
        }
        return basicClass;
    }
}
