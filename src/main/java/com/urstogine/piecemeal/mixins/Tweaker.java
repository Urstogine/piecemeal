package com.urstogine.piecemeal.mixins;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import zone.rong.mixinbooter.IEarlyMixinLoader;

@IFMLLoadingPlugin.MCVersion("1.12.2")
@IFMLLoadingPlugin.Name("PiecemealCore")
@IFMLLoadingPlugin.SortingIndex()
@IFMLLoadingPlugin.TransformerExclusions({"com.urstogine.piecemeal."})
public class Tweaker implements IFMLLoadingPlugin,IEarlyMixinLoader{
    @Override
    public List<String> getMixinConfigs() {
        return Collections.singletonList("mixins.piecemeal.json");
    }
    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
        //return new String[]{"com.urstogine.piecemeal.coremod.piecemealTransformer"};
    }
    @Override
    public String getModContainerClass() {return null;}
    @Nullable
    @Override
    public String getSetupClass() {return null;}
    @Override
    public void injectData(Map<String, Object> data) {}
    @Override
    public String getAccessTransformerClass() {return null;}
}