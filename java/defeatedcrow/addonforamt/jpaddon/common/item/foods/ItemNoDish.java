package defeatedcrow.addonforamt.jpaddon.common.item.foods;

import java.util.List;

import mods.defeatedcrow.common.item.edible.EdibleEntityItem2;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import defeatedcrow.addonforamt.jpaddon.common.entity.EntityNoDish;

/**
 * debuff効果の解除。
 */
public class ItemNoDish extends EdibleEntityItem2 {

	@SideOnly(Side.CLIENT)
	private IIcon iconType[];

	private static final String[] nameType = new String[] {
			"masuzushi",
			"cheese",
			"salad" };

	public ItemNoDish() {
		super(true, false);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setMaxStackSize(64);
	}

	@Override
	public int[] hungerOnEaten(int meta) {
		int a = meta == 2 ? 4 : 8;
		return new int[] {
				a,
				3 };
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int par1) {
		int j = MathHelper.clamp_int(par1, 0, nameType.length);
		return this.iconType[j];
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

		for (int i = 0; i < nameType.length; ++i) {
			this.iconType[i] = par1IconRegister.registerIcon("amtjp:foods/" + nameType[i]);
		}
		this.itemIcon = par1IconRegister.registerIcon("amtjp:foods/" + nameType[0]);
	}

	@Override
	protected boolean spownEntityFoods(World world, EntityPlayer player, ItemStack item, double x, double y, double z) {
		EntityNoDish entity = new EntityNoDish(world, item, x, y, z);
		entity.rotationYaw = player.rotationYaw - 180.0F;

		if (!world.isRemote && item != null) {
			return world.spawnEntityInWorld(entity);
		}
		return false;
	}

	@Override
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player) {
		if (!world.isRemote) {
			if (player.isPotionActive(Potion.blindness)) {
				player.removePotionEffect(Potion.blindness.id);
			}
			if (player.isPotionActive(Potion.confusion)) {
				player.removePotionEffect(Potion.confusion.id);
			}
			if (player.isPotionActive(Potion.hunger)) {
				player.removePotionEffect(Potion.hunger.id);
			}
			if (player.isPotionActive(Potion.poison)) {
				player.removePotionEffect(Potion.moveSlowdown.id);
			}
			if (player.isPotionActive(Potion.weakness)) {
				player.removePotionEffect(Potion.weakness.id);
			}
		}
		return super.onEaten(itemStack, world, player);
	}
}
