package defeatedcrow.addonforamt.jpaddon.common.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;

public class BlockAlabasterChandelier extends BlockContainer {

	@SideOnly(Side.CLIENT)
	private IIcon itemIcon;
	@SideOnly(Side.CLIENT)
	private IIcon chainIcon;

	public BlockAlabasterChandelier() {
		super(Material.glass);
		this.setStepSound(Block.soundTypeGlass);
		this.setHardness(0.2F);
		this.setResistance(5.0F);
		this.setLightLevel(1.0F);
	}

	@Override
	public int damageDropped(int par1) {
		return par1;
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
	public IIcon getIcon(int side, int meta) {
		return side == 1 ? this.itemIcon : side == 0 ? this.blockIcon : this.chainIcon;
	}

	@Override
	public int getRenderType() {
		return AddonJPCore.renderChandelier;
	}

	@Override
	public Item getItemDropped(int metadata, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon("defeatedcrow:teppann");
		this.itemIcon = par1IconRegister.registerIcon("amtjp:ores/alabaster_chandelier_item");
		this.chainIcon = par1IconRegister.registerIcon("amtjp:ores/chandelier_chain");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int a) {
		return new TileChandelier();
	}

}
