package defeatedcrow.addonforamt.jpaddon.common.block;

import java.util.List;

import mods.defeatedcrow.common.config.DCsConfig;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCardboardJP extends Block {

	private static final String[] bagVegi = new String[] {
			"sansho",
			"spinach",
			"strawberry" };

	@SideOnly(Side.CLIENT)
	private IIcon[] texTop;
	@SideOnly(Side.CLIENT)
	private IIcon texBottom;
	@SideOnly(Side.CLIENT)
	private IIcon[] texFront;
	@SideOnly(Side.CLIENT)
	private IIcon texSide;

	public BlockCardboardJP() {
		super(Material.wood);
		this.setStepSound(Block.soundTypeWood);
		this.setHardness(0.1F);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		int i = par2 & 3;
		boolean flag = par2 > 7;
		if (i > 2)
			i = 2;
		switch (par1) {
		case 0:
			return this.texBottom;
		case 1:
			return this.texTop[i];
		case 2:
			return flag ? this.texFront[i] : this.texSide;
		case 3:
			return flag ? this.texFront[i] : this.texSide;
		case 4:
			return flag ? this.texSide : this.texFront[i];
		case 5:
			return flag ? this.texSide : this.texFront[i];

		default:
			return this.texTop[i];
		}

	}

	@Override
	public int damageDropped(int par1) {
		return par1 & 3;
	}

	@Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase,
			ItemStack par6ItemStack) {
		int l = MathHelper.floor_double(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
		int meta = par6ItemStack.getItemDamage();
		byte facing = 0;
		int next = meta;

		if (par5EntityLivingBase.isSneaking()) {
			next = next | 4;
		}

		if (l == 0 || l == 2) {
			next = next | 8;
		}

		par1World.setBlockMetadataWithNotify(par2, par3, par4, next, 3);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(par1, 1, 0));
		par3List.add(new ItemStack(par1, 1, 1));
		par3List.add(new ItemStack(par1, 1, 2));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon(getTexpass() + "c_base_B");
		this.texBottom = par1IconRegister.registerIcon(getTexpass() + "c_base_B");
		this.texSide = par1IconRegister.registerIcon(getTexpass() + "c_base_S");
		this.texTop = new IIcon[3];
		this.texFront = new IIcon[3];

		for (int i = 0; i < 3; ++i) {
			this.texTop[i] = par1IconRegister.registerIcon(getTexpass() + "c_" + bagVegi[i] + "_T");
			this.texFront[i] = par1IconRegister.registerIcon(getTexpass() + "c_" + bagVegi[i] + "_F");
		}

	}

	private String getTexpass() {
		return DCsConfig.setAltTexturePass == 1 ? "amtjp:container/" : "amtjp:container/x32/";
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
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
		this.updateThisBounds(par1IBlockAccess.getBlockMetadata(par2, par3, par4));
	}

	public void updateThisBounds(int meta) {
		if ((meta & 4) == 4) {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
		} else {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}
	}

	@Override
	public void setBlockBoundsForItemRender() {
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	@Override
	public boolean getBlocksMovement(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
		return false;
	}

}
