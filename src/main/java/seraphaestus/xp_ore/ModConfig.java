package seraphaestus.xp_ore;

import org.apache.logging.log4j.Level;

import net.minecraftforge.common.config.Configuration;
import seraphaestus.xp_ore.proxy.CommonProxy;

public class ModConfig {

    private static final String CATEGORY_GENERAL = "general";

    // This values below you can access elsewhere in your mod:
    public static int numOreTiers = 3;
    public static int xpBase = 1;
    public static int xpMultiplier = 2;

    // Call this from CommonProxy.preInit(). It will create our config if it doesn't
    // exist yet and read the values if it does exist.
    public static void readConfig() {
        Configuration cfg = CommonProxy.config;
        try {
            cfg.load();
            initConfig(cfg);
        } catch (Exception e1) {
            ModMain.logger.log(Level.ERROR, "Problem loading config file!", e1);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    private static void initConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_GENERAL, "Configure the mod");
        numOreTiers = cfg.getInt("numOreTiers", CATEGORY_GENERAL, numOreTiers, 0, 10, "How many different tiers of ore there wll be. Maximum of 10.");
        xpBase = cfg.getInt("xpBase", CATEGORY_GENERAL, xpBase, 0, Integer.MAX_VALUE, "The base amount of xp that the first tier of ore starts with.");
        xpMultiplier = cfg.getInt("xpMultiplier", CATEGORY_GENERAL, xpMultiplier, 0, Integer.MAX_VALUE, "Each tier of ore will increase the xp gained by this amount.");
    }
}