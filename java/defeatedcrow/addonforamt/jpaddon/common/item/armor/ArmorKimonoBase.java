package defeatedcrow.addonforamt.jpaddon.common.item.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;

/*
 * 着物追加クラスのベース。
 * 特別な機能はないお洒落用アイテム。
 * */
public class ArmorKimonoBase extends ItemArmor {

	protected final int number;
	protected IIcon textureType;
	protected final String name;

	public ArmorKimonoBase(ItemArmor.ArmorMaterial material, int par3, int par4, int s, String n) {
		super(material, par3, par4);
		this.number = s;
		this.name = n;
	}

	@Override
	public void onCreated(ItemStack par1Itemstack, World par2World, EntityPlayer par3EntityPlayer) {
		super.onCreated(par1Itemstack, par2World, par3EntityPlayer);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon("amtjp:armor/" + name);
	}

	@Override
	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type) {
		return "amtjp:textures/armor/armor_" + name + ".png";
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) {

		return this.number == 1 ? AddonJPCore.proxy.getHaoriModel() : AddonJPCore.proxy.getKimonoModel();
	}

}
