package defeatedcrow.addonforamt.jpaddon.common.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;

public class BlockGemHalfs extends Block {
	public static final String[] type = new String[] {
			"salt",
			"alabaster",
			"smooth_salt",
			"smooth_alabaster" };

	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	protected final boolean isDouble;

	public BlockGemHalfs(boolean isdouble) {
		super(Material.rock);
		this.setHardness(1.0F);
		this.setResistance(15.0F);
		isDouble = isdouble;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		int m = meta & 3;
		return icons[m];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IIconRegister) {
		this.icons = new IIcon[type.length];
		for (int i = 0; i < type.length; ++i) {
			this.icons[i] = par1IIconRegister.registerIcon("amtjp:ores/block_" + type[i]);
		}
	}

	@Override
	public Item getItemDropped(int meta, Random rand, int fortune) {
		return Item.getItemFromBlock(AddonJPCore.gemHalf);
	}

	@Override
	public int quantityDropped(Random rand) {
		return this.isDouble ? 2 : 1;
	}

	@Override
	public int damageDropped(int meta) {
		return meta & 3;
	}

	@Override
	public void setBlockBoundsForItemRender() {
		if (isDouble) {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		} else {
			float f = 0.5F;
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
		}
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
		this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
		return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
		this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
		return super.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int par2, int par3, int par4) {
		this.updateBounds(world.getBlockMetadata(par2, par3, par4));
	}

	protected void updateBounds(int par1) {
		if (isDouble) {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		} else {
			float f = 0.5F;
			boolean rev = (par1 & 8) != 0;
			if (!rev) {
				this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
			} else {
				this.setBlockBounds(0.0F, 1.0F - f, 0.0F, 1.0F, 1.0F, 1.0F);
			}
		}
	}

	@Override
	public boolean isOpaqueCube() {
		return isDouble;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return isDouble;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		if (par1 != Item.getItemFromBlock(AddonJPCore.gemHalf_double)) {
			par3List.add(new ItemStack(this, 1, 0));
			par3List.add(new ItemStack(this, 1, 1));
			par3List.add(new ItemStack(this, 1, 2));
			par3List.add(new ItemStack(this, 1, 3));
		}
	}

	// 半ブロックの動作
	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float fx, float fy, float fz, int meta) {
		return this.isDouble ? meta : (side != 0 && (side == 1 || fy <= 0.5D) ? meta : meta | 8);
	}

	// double化
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float fx,
			float fy, float fz) {
		ItemStack item = player.inventory.getCurrentItem();
		int meta = world.getBlockMetadata(x, y, z);
		if (!isDouble && item != null && item.getItem() == Item.getItemFromBlock(AddonJPCore.gemHalf)
				&& (meta & 7) == item.getItemDamage()) {
			boolean f = false;
			if ((meta & 8) == 0 && side == 1) {
				f = true;
			} else if ((meta & 8) == 8 && side == 0) {
				f = true;
			}
			if (f) {
				if (world.setBlock(x, y, z, AddonJPCore.gemHalf_double, (meta & 3), 2)) {
					world.playSoundEffect(x + 0.5F, y + 0.5F, z + 0.5F, this.stepSound.func_150496_b(),
							(this.stepSound.getVolume() + 1.0F) / 2.0F, this.stepSound.getPitch() * 0.8F);
					if (!player.capabilities.isCreativeMode && --item.stackSize <= 0) {
						player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack) null);
					}
				}
			}
			return f;
		}
		return false;
	}
}
