package seraphaestus.xp_ore.block;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import seraphaestus.xp_ore.ModConfig;

public class BlockXPOre extends BlockBase {

	public int tier;
	public int xp;
	
	public BlockXPOre(String id, int tier, int xp) {
		super(id, Material.ROCK);
		this.tier = tier;
		this.xp = xp;
        //properties
        setHardness(3.0f);
        setResistance(15.0f);
        setHarvestLevel("pickaxe", 1);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
	
	static int getXP(int tier) {
		return ModConfig.xpBase + (tier - 1) * ModConfig.xpMultiplier;
	}
	
	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune)
    {
        return xp;
    }
	
	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(ModBlocks.xpOreDrained);
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, ITooltipFlag advanced)
    {
		tooltip.add(I18n.format("xp_ore.xp_ore_tooltip", tier, xp));
    }
}
