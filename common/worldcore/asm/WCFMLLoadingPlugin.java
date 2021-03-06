package worldcore.asm;

import java.io.File;
import java.util.Map;

import cpw.mods.fml.relauncher.FMLLaunchHandler;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;

@TransformerExclusions({ "worldcore.asm" })
public class WCFMLLoadingPlugin implements IFMLLoadingPlugin
{
    private static String SIDE = FMLLaunchHandler.side().name();
    public static File location;
    
    /*TODO: Remove in 1.7*/
    public String[] getLibraryRequestClass()
    {
        return null;
    }

    @Override
    public String[] getASMTransformerClass()
    {
        if (SIDE.equals("CLIENT"))
        {
            return new String[] {WCFogColour.class.getName(), WCFogDistance.class.getName(), WCDimensionLight.class.getName()};
        }

        return null;
    }

    @Override
    public String getModContainerClass()
    {
        return null;
    }

    @Override
    public String getSetupClass()
    {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data)
    {
        location = (File)data.get("coremodLocation");
    }
}
