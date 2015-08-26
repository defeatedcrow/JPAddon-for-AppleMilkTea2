package defeatedcrow.addonforamt.jpaddon.common.item.foods;

import java.util.List;

import mods.defeatedcrow.common.item.edible.EdibleEntityItem2;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import defeatedcrow.addonforamt.jpaddon.common.entity.EntityRoastPig;

/**
 * 丸豚及び丸焼き。
 * 焼いたものは回復量がとても多く、食べると骨をドロップする
 */
public class ItemPig extends EdibleEntityItem2 {

	@SideOnly(Side.CLIENT)
	private IIcon iconType[];

	private static final String[] nameType = new String[] {
			"raw",
			"roast" };

	public ItemPig() {
		super(true, false);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setMaxStackSize(64);
	}

	@Override
	public ItemStack getReturnContainer(int meta) {
		return new ItemStack(Items.bone, 1, 0);
	}

	@Override
	public int[] hungerOnEaten(int meta) {
		return meta == 0 ? new int[] {
				2,
				0 } : new int[] {
				16,
				8 };
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int par1) {
		int j = MathHelper.clamp_int(par1, 0, nameType.length - 1);
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
			this.iconType[i] = par1IconRegister.registerIcon("amtjp:foods/itempig_" + nameType[i]);
		}
		this.itemIcon = par1IconRegister.registerIcon("amtjp:foods/itempig_" + nameType[0]);
	}

	@Override
	protected boolean spownEntityFoods(World world, EntityPlayer player, ItemStack item, double x, double y, double z) {
		EntityRoastPig entity = new EntityRoastPig(world, item, x, y, z);
		entity.rotationYaw = player.rotationYaw - 180.0F;

		if (!world.isRemote && item != null) {
			return world.spawnEntityInWorld(entity);
		}
		return false;
	}

	@Override
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player) {

		if (!world.isRemote) {
			int m = itemStack.getItemDamage();
			int r = world.rand.nextInt(5);
			if (m == 0) {
				if (r == 0) {
					player.addPotionEffect(new PotionEffect(Potion.hunger.getId(), 200, 0));

				}
			} else {
				ItemStack bone = new ItemStack(Items.bone, 1 + r, 0);
				EntityItem entity = new EntityItem(world, player.posX, player.posY, player.posZ, bone);
				world.spawnEntityInWorld(entity);

			}
		}
		return super.onEaten(itemStack, world, player);
	}

}
