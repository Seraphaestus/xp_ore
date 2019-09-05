package seraphaestus.xp_ore;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import seraphaestus.xp_ore.proxy.CommonProxy;

@Mod(modid = ModMain.MODID, name = ModMain.MODNAME, version = ModMain.MODVERSION)
public class ModMain {

    public static final String MODID = "xp_ore";
    public static final String MODNAME = "XP Ore";
    public static final String MODVERSION= "0.0.0";
    
    @SidedProxy(clientSide = "seraphaestus.xp_ore.proxy.ClientProxy", serverSide = "seraphaestus.xp_ore.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance(ModMain.MODID)
    public static ModMain instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
