package defeatedcrow.addonforamt.jpaddon.common.item.foods;

import java.util.List;

import mods.defeatedcrow.common.item.edible.EdibleEntityItem2;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import defeatedcrow.addonforamt.jpaddon.common.entity.EntityWhiteDish;

/**
 * 主菜系2。
 * 回復量が大きく、スタミナも回復する。
 */
public class ItemWhiteDish extends EdibleEntityItem2 {

	@SideOnly(Side.CLIENT)
	private IIcon iconType[];

	private static final String[] nameType = new String[] {
			"breakfast",
			"winestew",
			"carpaccio_beef",
			"carpaccio_fish",
			"applepie" };

	public ItemWhiteDish() {
		super(true, false);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setMaxStackSize(64);
		// this.setContainerItem(Items.bowl);
	}

	@Override
	public ItemStack getReturnContainer(int meta) {
		return meta == 1 ? new ItemStack(Items.bowl, 1, 0) : null;
	}

	@Override
	public int[] hungerOnEaten(int meta) {
		return new int[] {
				10,
				2 };
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
		return m < (nameType.length) ? super.getUnlocalizedName() + "_" + nameType[m] : super.getUnlocalizedName()
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
		EntityWhiteDish entity = new EntityWhiteDish(world, item, x, y, z);
		entity.rotationYaw = player.rotationYaw - 180.0F;

		if (!world.isRemote && item != null) {
			return world.spawnEntityInWorld(entity);
		}
		return false;
	}

	@Override
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player) {
		if (!world.isRemote && itemStack != null) {
			int healAmo = 20;
			this.addSSStamina(healAmo, 5F, player);
		}
		return super.onEaten(itemStack, world, player);
	}
}
