package seraphaestus.xp_ore;

import org.apache.logging.log4j.Level;

import net.minecraft.client.resources.I18n;
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
            initMultiCraftingConfig(cfg);
        } catch (Exception e1) {
            ModMain.logger.log(Level.ERROR, "Problem loading config file!", e1);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    private static void initMultiCraftingConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_GENERAL, I18n.format("xp_ore.config.general_category.description"));
        numOreTiers = cfg.getInt("numOreTiers", CATEGORY_GENERAL, numOreTiers, 0, 10, I18n.format("xp_ore.config.num_ore_tiers.description"));
        xpBase = cfg.getInt("xpBase", CATEGORY_GENERAL, xpBase, 0, Integer.MAX_VALUE, I18n.format("xp_ore.config.xp_base.description"));
        xpMultiplier = cfg.getInt("xpMultiplier", CATEGORY_GENERAL, xpMultiplier, 0, Integer.MAX_VALUE, I18n.format("xp_ore.config.xp_multiplier.description"));
    }
}