package defeatedcrow.addonforamt.jpaddon.common.item.foods;

import java.util.ArrayList;
import java.util.List;

import mods.defeatedcrow.common.item.edible.EdibleEntityItem2;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import defeatedcrow.addonforamt.jpaddon.common.entity.EntityJPDish;

/**
 * 和風おやつ。
 * スタミナ・体力回復効果がある。
 */
public class ItemJPDish extends EdibleEntityItem2 {

	@SideOnly(Side.CLIENT)
	private IIcon iconType[];

	private static final String[] nameType = new String[] {
			"oniman",
			"kusamochi",
			"matchacake",
			"hoshiimo",
			"soycake",
			"senbei",
			"brownie",
			"daihuku_strawberry",
			"berrycake",
			"nuts_nougat" };

	public ItemJPDish() {
		super(true, false);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setMaxStackSize(64);
	}

	@Override
	public int[] hungerOnEaten(int meta) {
		return new int[] {
				2,
				2 };
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int par1) {
		int j = MathHelper.clamp_int(par1, 0, 9);
		return this.iconType[j];
	}

	@Override
	public int getMetadata(int par1) {
		return par1;
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		int m = par1ItemStack.getItemDamage();
		return m < 10 ? super.getUnlocalizedName() + "_" + nameType[m] : super.getUnlocalizedName() + "_" + m;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int i = 0; i < nameType.length; i++) {
			par3List.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.iconType = new IIcon[nameType.length];

		for (int i = 0; i < nameType.length; ++i) {
			this.iconType[i] = par1IconRegister.registerIcon("amtjp:foods/" + nameType[i]);
		}
		this.itemIcon = par1IconRegister.registerIcon("amtjp:foods/" + nameType[0]);
	}

	@Override
	protected boolean spownEntityFoods(World world, EntityPlayer player, ItemStack item, double x, double y, double z) {
		EntityJPDish entity = new EntityJPDish(world, item, x, y, z);
		entity.rotationYaw = player.rotationYaw - 180.0F;

		if (!world.isRemote && item != null) {
			return world.spawnEntityInWorld(entity);
		}
		return false;
	}

	@Override
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		if (!par2World.isRemote && par1ItemStack != null) {
			int healAmo = 10;
			int m = par1ItemStack.getItemDamage();
			if (m == 7 || (m & 1) == 0)
				healAmo = 30;
			this.addSSStamina(healAmo, 5F, par3EntityPlayer);
		}
		return super.onEaten(par1ItemStack, par2World, par3EntityPlayer);
	}

	@Override
	public ArrayList<PotionEffect> effectOnEaten(EntityPlayer par1EntityPlayer, int meta) {
		ArrayList<PotionEffect> ret = new ArrayList<PotionEffect>();
		ret.add(new PotionEffect(Potion.heal.id, 1, 1));
		return ret;
	}
}
