package defeatedcrow.addonforamt.jpaddon.plugin.cleaver;

import mods.defeatedcrow.common.DCsAppleMilk;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import defeatedcrow.addonforamt.jpaddon.common.entity.WindProjectile;

public class ItemWindCleaver extends ItemSword {

	private final float damage;

	@SideOnly(Side.CLIENT)
	private IIcon iconType[];

	public ItemWindCleaver() {
		super(DCsAppleMilk.enumToolMaterialChalcedony);
		this.setMaxStackSize(1);
		this.setMaxDamage(512);
		this.damage = 10.0F;
		this.setTextureName("amtjp:tools/cleaver_wind");
	}

	@Override
	public Multimap getItemAttributeModifiers() {
		Multimap multimap = HashMultimap.create();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(
				field_111210_e, "Weapon modifier", this.damage, 0));
		return multimap;
	}

	@Override
	public float func_150931_i() {
		return this.damage;
	}

	@Override
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		return par1ItemStack;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		return 6000;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.block;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (player != null && player.isSneaking()) {
			NBTTagCompound nbt = stack.getTagCompound();
			if (nbt == null) {
				nbt = new NBTTagCompound();
			}
			boolean rev = false;
			if (nbt.hasKey("Reverse")) {
				rev = nbt.getBoolean("Reverse");
			}

			boolean ret = !rev;
			nbt.setBoolean("Reverse", ret);
			stack.setTagCompound(nbt);
			return stack;
		}
		player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
		return stack;
	}

	// タメ解放
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int i) {
		if (player != null && stack != null && !player.worldObj.isRemote) {
			NBTTagCompound nbt = stack.getTagCompound();
			if (nbt == null) {
				nbt = new NBTTagCompound();
			}
			boolean isReversal = false;
			if (nbt.hasKey("Reverse")) {
				isReversal = nbt.getBoolean("Reverse");
			}
			if (!isReversal)
				return;

			int j = this.getMaxItemUseDuration(stack) - i;
			int exp = player.experienceTotal;
			if (!player.capabilities.isCreativeMode && !this.reduceExp(player, 5)) {
				return;
			}

			float f = j / 20.0F;
			f = (f * f + f * 2.0F) / 3.0F;

			if (f < 0.5D) {
				return;
			}

			if (f > 1.0F) {
				f = 1.0F;
			}

			// 8方向に飛ばす
			for (int k = 0; k < 8; k++) {
				float adj = k * 45.0F;
				WindProjectile bullet = new WindProjectile(player.worldObj, player, 3.0F, 1.0F, 5.0F, adj);
				bullet.setParalysis(true);
				player.worldObj.spawnEntityInWorld(bullet);
				player.worldObj.playSoundEffect(player.posX, player.posY - 1, player.posZ, "amtjp:wind", 0.15F, 0.75F);
			}

		}
	}

	// 攻撃時
	@Override
	public boolean onEntitySwing(EntityLivingBase entity, ItemStack stack) {
		if (entity != null && stack != null && !entity.worldObj.isRemote) {
			NBTTagCompound nbt = stack.getTagCompound();
			if (nbt == null) {
				nbt = new NBTTagCompound();
			}
			boolean isReversal = false;
			if (nbt.hasKey("Reverse")) {
				isReversal = nbt.getBoolean("Reverse");
			}
			if (!isReversal)
				return false;

			if (entity instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) entity;
				int exp = player.experienceTotal;
				if (!player.capabilities.isCreativeMode && !this.reduceExp(player, 1)) {
					return false;
				}
			}

			int sharp = EnchantmentHelper.getEnchantmentLevel(Enchantment.sharpness.effectId, stack);
			int knock = EnchantmentHelper.getEnchantmentLevel(Enchantment.knockback.effectId, stack);
			int fire = EnchantmentHelper.getEnchantmentLevel(Enchantment.fireAspect.effectId, stack);
			int smite = EnchantmentHelper.getEnchantmentLevel(Enchantment.smite.effectId, stack);
			int bane = EnchantmentHelper.getEnchantmentLevel(Enchantment.baneOfArthropods.effectId, stack);
			int loot = EnchantmentHelper.getEnchantmentLevel(Enchantment.looting.effectId, stack);

			// damage
			float dam = 10.0F + (sharp * 0.30F);

			// knockback
			float kno = 0.0F;
			if (entity.isSneaking()) {
				kno = 0.0F;
			} else {
				double a = entity.motionX * entity.motionX;
				double b = entity.motionZ * entity.motionZ;
				double c = Math.sqrt(a + b);
				if (entity.isSprinting())
					c *= 5.0D;
				kno = (float) c + (2.0F * knock);
				if (entity.isSprinting())
					kno *= 2.0F;
			}

			float adj = 0.0F;
			WindProjectile bullet = new WindProjectile(entity.worldObj, entity, 3.0F, dam, 5.0F, adj);
			bullet.setKnockback(kno);
			bullet.setAdvFire(fire > 0);
			bullet.setPurify(smite);
			bullet.setInsecticide(bane);
			bullet.setLooting(loot);
			entity.worldObj.spawnEntityInWorld(bullet);
			entity.worldObj.playSoundEffect(entity.posX, entity.posY - 1, entity.posZ, "amtjp:wind", 0.25F, 1.5F);
		}
		return false;
	}

	private boolean reduceExp(EntityPlayer player, int i) {
		int exp = player.experienceTotal;
		if (exp < i) {
			return false;
		} else {
			player.addExperience(-i);
			if (player.experience < 0.0F) {
				player.experience = 1.0F;
				player.addExperienceLevel(-1);
			}
			return true;
		}
	}

	@Override
	public IIcon getIcon(ItemStack stack, int pass) {
		return this.getIconIndex(stack);
	}

	@Override
	public IIcon getIconIndex(ItemStack stack) {
		if (stack != null) {
			NBTTagCompound nbt = stack.getTagCompound();
			if (nbt == null) {
				return this.itemIcon;
			}
			boolean rev = false;
			if (nbt.hasKey("Reverse")) {
				rev = nbt.getBoolean("Reverse");
			}
			return rev ? this.iconType[1] : this.iconType[0];
		}
		return this.itemIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon("amtjp:tools/cleaver_wind_" + 0);
		this.iconType = new IIcon[2];
		for (int i = 0; i < 2; i++) {
			this.iconType[i] = par1IconRegister.registerIcon("amtjp:tools/cleaver_wind_" + i);
		}
	}

}
