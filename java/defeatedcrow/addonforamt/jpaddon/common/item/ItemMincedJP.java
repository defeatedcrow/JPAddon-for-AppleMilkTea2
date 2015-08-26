package defeatedcrow.addonforamt.jpaddon.common.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMincedJP extends Item {

	private static String[] name = {
			"cabbagepork",
			"hamagurimeshi",
			"kentin",
			"kuriokowa",
			"nasusoumen",
			"nasutomato",
			"onionsoup",
			"sigureni",
			"simotukare",
			"takenoko",
			"cornsoup",
			"kanijiru" };

	@SideOnly(Side.CLIENT)
	private IIcon iconItemType[];

	public ItemMincedJP() {
		super();
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		maxStackSize = 64;

	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int par1) {
		int j = MathHelper.clamp_int(par1, 0, this.name.length);
		return this.iconItemType[j];
	}

	@Override
	public int getMetadata(int par1) {
		return par1;
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		int j = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, this.name.length);
		return super.getUnlocalizedName() + "_" + name[j];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int i = 0; i < this.name.length; i++) {
			par3List.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.iconItemType = new IIcon[this.name.length];

		for (int i = 0; i < this.name.length; i++) {
			this.iconItemType[i] = par1IconRegister.registerIcon("amtjp:materials/mincedfoods_" + this.name[i]);
		}
	}
}
