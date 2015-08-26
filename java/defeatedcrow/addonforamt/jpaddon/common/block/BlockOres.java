package defeatedcrow.addonforamt.jpaddon.common.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mods.defeatedcrow.common.config.DCsConfig;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import wa.block.Blocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;

public class BlockOres extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon[] oreIcon;

	private String[] oreName = {
			"salt",
			"alabaster" };

	public BlockOres() {
		super(Material.rock);
		this.setStepSound(Block.soundTypeStone);
		this.setHardness(2.0F);
		this.setResistance(15.0F);
	}

	@Override
	public int getHarvestLevel(int meta) {
		return 1;
	}

	// @Override
	// public boolean isOpaqueCube() {
	// return false;
	// }
	//
	// @Override
	// public boolean renderAsNormalBlock() {
	// return false;
	// }

	@Override
	public int getRenderType() {
		return AddonJPCore.renderOres;
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
	}

	@Override
	public Item getItemDropped(int metadata, Random rand, int fortune) {
		return AddonJPCore.gems;
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
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		int chance = 5;
		if (fortune > 0) {
			chance -= fortune;
			if (chance < 2)
				chance = 2;

			for (int i = 0; i < fortune; i++) {
				if (world.rand.nextInt(chance) == 0) {
					ret.add(new ItemStack(AddonJPCore.gems, 1, metadata));
				}
			}
		}
		ret.add(new ItemStack(this.getItemDropped(metadata, world.rand, fortune), 1, this.damageDropped(metadata)));
		return ret;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IIconRegister) {
		this.oreIcon = new IIcon[oreName.length];
		for (int i = 0; i < oreName.length; ++i) {
			this.oreIcon[i] = par1IIconRegister.registerIcon(getTexpass() + oreName[i]);
		}
		this.blockIcon = Blocks.stone.getBlockTextureFromSide(0);
	}

	private String getTexpass() {
		return DCsConfig.setAltTexturePass == 1 ? "amtjp:ores/ore_" : "amtjp:ores/x32/ore_";
	}

}
