package defeatedcrow.addonforamt.jpaddon.common.block;

import mods.defeatedcrow.common.config.DCsConfig;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLinenContainer extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon texV;
	@SideOnly(Side.CLIENT)
	private IIcon texE;
	@SideOnly(Side.CLIENT)
	private IIcon texSide;

	public BlockLinenContainer() {
		super(Material.wood);
		this.setStepSound(Block.soundTypeGrass);
		this.setHardness(0.1F);
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
		int i = par2;
		boolean flag = par2 > 0;
		if (i > 1)
			i = 1;
		switch (par1) {
		case 0:
			return flag ? this.texV : this.texE;
		case 1:
			return flag ? this.texV : this.texE;
		case 2:
			return flag ? this.texSide : this.texE;
		case 3:
			return flag ? this.texSide : this.texE;
		case 4:
			return flag ? this.texE : this.texSide;
		case 5:
			return flag ? this.texE : this.texSide;
		default:
			return this.texSide;
		}

	}

	@Override
	public int damageDropped(int par1) {
		return 0;
	}

	@Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase,
			ItemStack par6ItemStack) {
		int l = MathHelper.floor_double(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
		int meta = par6ItemStack.getItemDamage();
		byte facing = 0;

		if (l == 0) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 3);
			facing = 0;
		}

		if (l == 1) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 3);
			facing = 1;
		}

		if (l == 2) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 3);
			facing = 2;
		}

		if (l == 3) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 3);
			facing = 4;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon(getTexpass() + "c_linen_S");
		this.texSide = par1IconRegister.registerIcon(getTexpass() + "c_linen_S");
		this.texV = par1IconRegister.registerIcon(getTexpass() + "c_linen_F");
		this.texE = par1IconRegister.registerIcon(getTexpass() + "c_linen_T");

	}

	private String getTexpass() {
		return DCsConfig.setAltTexturePass == 1 ? "amtjp:container/" : "amtjp:container/x32/";
	}

}
