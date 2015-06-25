package defeatedcrow.addonforamt.jpaddon.common.item;

import java.util.List;

import mods.defeatedcrow.common.DCsAppleMilk;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

// 仕組みはAMTの酒瓶と同じ
public class ItemBottles extends Item {

	private static String[] name = { "soysource", "vinegar" };

	@SideOnly(Side.CLIENT)
	private IIcon iconItemType[];

	public ItemBottles() {
		super();
		this.setMaxStackSize(8);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setNoRepair();
		this.setContainerItem(Item.getItemFromBlock(DCsAppleMilk.emptyBottle));
	}

	@Override
	@SideOnly(Side.CLIENT)
	// マウスオーバー時の表示情報
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
		int l = par1ItemStack.getItemDamage();
		int type = checkType(l);
		int rem = checkRemain(l) + 1;
		par3List.add(new String("count: " + rem));
	}

	private int checkType(int par1) {
		int m = par1 & 15;// やってることはブロッククラスのものと同じ
		return m;
	}

	private int checkRemain(int par1) {
		int m = par1 >> 4;// 右にシフト。16から1へ。
		m = (m & 3);// 16、32の桁をチェック
		return m;
	}

	// 以下はサブタイプやアイコン登録など
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int par1) {
		int j = (par1 & 15);
		if (j >= this.name.length)
			j = this.name.length - 1;
		return this.iconItemType[j];
	}

	@Override
	public int getMetadata(int par1) {
		return par1;// ここではダメージ値通りのものを返す
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		int j = (par1ItemStack.getItemDamage() & 15);
		return super.getUnlocalizedName() + "_" + j;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int i = 0; i < this.name.length; i++) {
			par3List.add(new ItemStack(this, 1, 48 + i));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {

		this.iconItemType = new IIcon[this.name.length];

		for (int i = 0; i < this.name.length; ++i) {
			this.iconItemType[i] = par1IconRegister.registerIcon("amtjp:materials/bottle_" + name[i]);
		}
	}
}
