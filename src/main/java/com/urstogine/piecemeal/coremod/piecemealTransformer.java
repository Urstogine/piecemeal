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
                
            }
            ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES|ClassWriter.COMPUTE_MAXS);
            cn.accept(classWriter);
            return classWriter.toByteArray();
        }
        return basicClass;
    }
}
