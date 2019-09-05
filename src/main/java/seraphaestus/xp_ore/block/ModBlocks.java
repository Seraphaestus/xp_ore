package seraphaestus.xp_ore.block;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import seraphaestus.xp_ore.ModConfig;
import seraphaestus.xp_ore.ModMain;

public class ModBlocks {
	
	public static List<BlockBase> blocks;
	public static BlockXPOreDrained xpOreDrained;
	private static boolean doneBlockSetup = false;
	
	public static void setupBlocks(){
		blocks = new ArrayList<BlockBase>();
		//
		for(int i = 1; i <= ModConfig.numOreTiers; i++){
        	BlockXPOre block = new BlockXPOre("xp_ore_tier_" + i, i, BlockXPOre.getXP(i));
        	blocks.add(block);
        }
		//
		xpOreDrained = new BlockXPOreDrained("xp_ore_drained", Material.ROCK);
		blocks.add(xpOreDrained);
		//
		doneBlockSetup = true;
	}
	
	public static void preInitCommon() {  	
		if(!doneBlockSetup){
        	setupBlocks();
        }
		//
        for(BlockBase block : blocks){
        	ForgeRegistries.BLOCKS.register(block);
            block.init();
        }
	}

    public static void preInitClientOnly() {
        // model to be used for rendering this item       
        if(!doneBlockSetup){
            setupBlocks();
        }
        //
        for(BlockBase block : blocks){
        	doClientBlockInit(block, block.id);
        }
    }
    
    private static void doClientBlockInit(Block block, String id) {
    	ModelResourceLocation blockModelResourceLocation = new ModelResourceLocation(ModMain.MODID + ":" + id, "inventory");
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, blockModelResourceLocation);
    }
  
}
