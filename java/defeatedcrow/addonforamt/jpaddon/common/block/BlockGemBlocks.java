package defeatedcrow.addonforamt.jpaddon.common.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGemBlocks extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon[] oreIcon;

	private String[] oreName = {
			"salt",
			"alabaster",
			"smooth_salt",
			"smooth_alabaster" };

	public BlockGemBlocks() {
		super(Material.rock);
		this.setStepSound(Block.soundTypeStone);
		this.setHardness(2.0F);
		this.setResistance(15.0F);
	}

	@Override
	public int getHarvestLevel(int meta) {
		return 0;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		int i = Math.min(par2, oreName.length - 1);
		return this.oreIcon[i];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(this, 1, 0));
		par3List.add(new ItemStack(this, 1, 1));
		par3List.add(new ItemStack(this, 1, 2));
		par3List.add(new ItemStack(this, 1, 3));
	}

	@Override
	public Item getItemDropped(int metadata, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}

	@Override
	public int damageDropped(int par1) {
		return par1;
	}

	@Override
	public int quantityDropped(Random random) {
		return 1;
	}

	@Override
	protected boolean canSilkHarvest() {
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IIconRegister) {
		this.oreIcon = new IIcon[oreName.length];
		for (int i = 0; i < oreName.length; ++i) {
			this.oreIcon[i] = par1IIconRegister.registerIcon("amtjp:ores/block_" + oreName[i]);
		}
		this.blockIcon = Blocks.stone.getBlockTextureFromSide(0);
	}

}
