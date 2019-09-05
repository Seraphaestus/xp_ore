package seraphaestus.xp_ore.block;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockXPOreDrained extends BlockBase {

	public String id;
	public int xp;
	
	public BlockXPOreDrained(String id, Material material) {
		super(id, material);
        //properties
        setHardness(3.0f);
        setResistance(15.0f);
        setHarvestLevel("pickaxe", 1);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, ITooltipFlag advanced)
    {
		tooltip.add(I18n.format("xp_ore.xp_ore_drained_tooltip"));
    }

}
