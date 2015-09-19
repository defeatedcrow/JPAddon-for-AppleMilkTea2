package defeatedcrow.addonforamt.jpaddon.common.item.foods;

import java.util.ArrayList;
import java.util.List;

import mods.defeatedcrow.api.potion.AMTPotionManager;
import mods.defeatedcrow.common.DCsAppleMilk;
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
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;
import defeatedcrow.addonforamt.jpaddon.common.entity.EntityJPDrinks;

/**
 * 茶系飲み物。
 * 大抵はポーション効果を持つ。
 */
public class ItemJPDrinks extends EdibleEntityItem2 {

	@SideOnly(Side.CLIENT)
	private IIcon iconType[];
	@SideOnly(Side.CLIENT)
	private IIcon innerType[];

	private static final String[] nameType = new String[] {
			"sakura",
			"mugicha",
			"oolong",
			"vanilla_coffee",
			"amazake",
			"siruko" };

	public ItemJPDrinks() {
		super(true, true);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setMaxStackSize(64);
		this.setContainerItem(Item.getItemFromBlock(DCsAppleMilk.emptyCup));
	}

	@Override
	public ItemStack getReturnContainer(int meta) {
		return new ItemStack(DCsAppleMilk.emptyCup, 1, 0);
	}

	@Override
	public int[] hungerOnEaten(int meta) {
		return new int[] {
				0,
				0 };
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int par1) {
		int m = par1 & 15;
		int j = MathHelper.clamp_int(m, 0, nameType.length);
		return par1 > 15 ? this.innerType[j] : this.iconType[j];
	}

	@Override
	public int getMetadata(int par1) {
		return par1;
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		int m = par1ItemStack.getItemDamage();
		return m < (nameType.length + 1) ? super.getUnlocalizedName() + "_" + nameType[m] : super.getUnlocalizedName()
				+ "_" + m;
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
		this.innerType = new IIcon[nameType.length];

		for (int i = 0; i < nameType.length; ++i) {
			this.iconType[i] = par1IconRegister.registerIcon("amtjp:foods/cup_" + nameType[i]);
			this.innerType[i] = par1IconRegister.registerIcon("amtjp:contents/contents_" + nameType[i]);
		}
		this.itemIcon = par1IconRegister.registerIcon("amtjp:foods/cup_" + nameType[0]);
	}

	@Override
	protected boolean spownEntityFoods(World world, EntityPlayer player, ItemStack item, double x, double y, double z) {
		EntityJPDrinks entity = new EntityJPDrinks(world, item, x, y, z);
		entity.rotationYaw = player.rotationYaw - 180.0F;

		if (!world.isRemote && item != null) {
			return world.spawnEntityInWorld(entity);
		}
		return false;
	}

	@Override
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		if (!par2World.isRemote) {
			this.addSSMoisture(6, 4F, par3EntityPlayer);
		}
		return super.onEaten(par1ItemStack, par2World, par3EntityPlayer);
	}

	@Override
	public ArrayList<PotionEffect> effectOnEaten(EntityPlayer par1EntityPlayer, int meta) {
		ArrayList<PotionEffect> ret = new ArrayList<PotionEffect>();

		switch (meta) {
		case 0:
			if (AddonJPCore.luck == null) {
				ret.add(new PotionEffect(Potion.regeneration.id, 600, 1));
			} else {
				ret.add(new PotionEffect(AddonJPCore.luck.id, 600, 1));
			}
			break;
		case 1:
			ret.add(new PotionEffect(Potion.fireResistance.id, 600, 0));
			break;
		case 2:
			ret.add(new PotionEffect(AMTPotionManager.manager.AMTgetPotion("projectile_resist").getId(), 600, 0));
			break;
		case 3:
			ret.add(new PotionEffect(Potion.field_76444_x.getId(), 600, 0));
			break;
		case 4:
			ret.add(new PotionEffect(Potion.field_76443_y.getId(), 600, 0));
			break;
		case 5:
			ret.add(new PotionEffect(AMTPotionManager.manager.AMTgetPotion("immunization").getId(), 600, 1));
			break;
		}
		return ret;
	}

	// @Override
	// @SideOnly(Side.CLIENT)
	// // マウスオーバー時の表示情報
	// public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List
	// par3List, boolean par4) {
	// super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
	// int l = par1ItemStack.getItemDamage();
	// ArrayList<PotionEffect> effect = this.effectOnEaten(par2EntityPlayer, l);
	// if (effect != null && this.showTooltip) {
	// for (PotionEffect p : effect) {
	// String s = StatCollector.translateToLocal(p.getEffectName()).trim();
	// if (p.getAmplifier() > 0) {
	// if (p.getAmplifier() < 4) {
	// s = s + " " + StatCollector.translateToLocal("potion.potency." + p.getAmplifier()).trim();
	// } else {
	// s = s + " " + p.getAmplifier();
	// }
	// }
	//
	// if (p.getDuration() > 20) {
	// s = s + " (" + Potion.getDurationString(p) + ")";
	// }
	//
	// par3List.add(s);
	// }
	// }
	// }
}
