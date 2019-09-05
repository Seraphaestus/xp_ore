package seraphaestus.xp_ore.proxy;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import seraphaestus.xp_ore.ModConfig;
import seraphaestus.xp_ore.block.ModBlocks;

@Mod.EventBusSubscriber
public class CommonProxy {
	
	// Config instance
    public static Configuration config;
    
    public void preInit(FMLPreInitializationEvent e) {
    	File directory = e.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "xp_ore.cfg"));
        ModConfig.readConfig();
        
        ModBlocks.preInitCommon();
    }

    public void init(FMLInitializationEvent e) {
    }

    public void postInit(FMLPostInitializationEvent e) {
    	if (config.hasChanged()) {
            config.save();
        }
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
    }
}