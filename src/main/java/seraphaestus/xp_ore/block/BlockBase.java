package seraphaestus.xp_ore.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import seraphaestus.xp_ore.ModMain;

public class BlockBase extends Block {

	public String id;
	public int xp;
	
	public BlockBase(String id, Material material) {
		super(material);
		this.id = id;
		setUnlocalizedName(ModMain.MODID + "." + id);     // Used for localization (en_US.lang)
        setRegistryName(id); 
	}
	
	public void init() {
    	registerItemBlock();
    }
	
	public void registerItemBlock() {
    	ForgeRegistries.ITEMS.register(new ItemBlock(this).setRegistryName(this.id));
	}

}
