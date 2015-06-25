package defeatedcrow.addonforamt.jpaddon.common.fluid;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDummyFluidJP extends Block {

	@SideOnly(Side.CLIENT)
	protected IIcon baseIcon[];

	private String[] iconType = new String[] { "clear_still", "shoyu_still", "vinegar_still" };

	public BlockDummyFluidJP() {
		super(Material.water);
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		MathHelper.clamp_int(meta, 0, 3);
		if (meta == 2) {
			return this.baseIcon[1];
		} else if (meta == 3) {
			return this.baseIcon[2];
		} else {
			return this.baseIcon[0];
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.baseIcon = new IIcon[3];
		for (int i = 0; i < 3; ++i) {
			this.baseIcon[i] = par1IconRegister.registerIcon("amtjp:fluid/" + this.iconType[i]);
		}

	}

}
