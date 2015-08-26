package defeatedcrow.addonforamt.jpaddon.common.item.foods;

import java.util.ArrayList;
import java.util.List;

import mods.defeatedcrow.common.item.edible.EdibleEntityItem2;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
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
import defeatedcrow.addonforamt.jpaddon.common.entity.EntityJPBowl;

/**
 * 和風スープ。
 * 腹持ち高め、SS2水分回復効果がある。
 */
public class ItemJPBowls extends EdibleEntityItem2 {

	@SideOnly(Side.CLIENT)
	private IIcon iconType[];
	@SideOnly(Side.CLIENT)
	private IIcon innerType[];

	private static final String[] nameType = new String[] {
			"cabbagepork",
			"kentin",
			"nasusoumen",
			"simotukare",
			"kanijiru" };

	public ItemJPBowls() {
		super(true, false);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setMaxStackSize(64);
		this.setContainerItem(Items.bowl);
	}

	@Override
	public ItemStack getReturnContainer(int meta) {
		return new ItemStack(Items.bowl, 1, 0);
	}

	@Override
	public int[] hungerOnEaten(int meta) {
		return new int[] {
				4,
				6 };
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
			this.iconType[i] = par1IconRegister.registerIcon("amtjp:foods/" + nameType[i]);
			this.innerType[i] = par1IconRegister.registerIcon("amtjp:contents/contents_" + nameType[i]);
		}
		this.itemIcon = par1IconRegister.registerIcon("amtjp:foods/" + nameType[0]);
	}

	@Override
	protected boolean spownEntityFoods(World world, EntityPlayer player, ItemStack item, double x, double y, double z) {
		EntityJPBowl entity = new EntityJPBowl(world, item, x, y, z);
		entity.rotationYaw = player.rotationYaw - 180.0F;

		if (!world.isRemote && item != null) {
			return world.spawnEntityInWorld(entity);
		}
		return false;
	}

	@Override
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		if (!par2World.isRemote) {
			this.addSSMoisture(4, 4F, par3EntityPlayer);
		}
		return super.onEaten(par1ItemStack, par2World, par3EntityPlayer);
	}

	@Override
	public ArrayList<PotionEffect> effectOnEaten(EntityPlayer par1EntityPlayer, int meta) {
		ArrayList<PotionEffect> ret = new ArrayList<PotionEffect>();
		// simotukare
		if (meta == 3) {
			ret.add(new PotionEffect(Potion.field_76443_y.id, 1, 2));
		}
		return ret;
	}
}
