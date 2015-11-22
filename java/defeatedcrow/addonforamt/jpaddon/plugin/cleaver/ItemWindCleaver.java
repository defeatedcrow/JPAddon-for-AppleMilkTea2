package defeatedcrow.addonforamt.jpaddon.plugin.cleaver;

import java.util.Iterator;

import mods.defeatedcrow.common.DCsAppleMilk;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import defeatedcrow.addonforamt.jpaddon.AJPLogger;
import defeatedcrow.addonforamt.jpaddon.common.entity.WindProjectile;

public class ItemWindCleaver extends DCsCleaverBase {

	@SideOnly(Side.CLIENT)
	private IIcon iconType[];

	public ItemWindCleaver() {
		super(DCsAppleMilk.enumToolMaterialChalcedony, 10.0F);
		this.setMaxStackSize(1);
		this.setMaxDamage(512);
		this.setTextureName("amtjp:tools/cleaver_wind");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (player != null && player.isSneaking()) {
			// mode変更処理
			CleaverMode mode = getMode(stack);
			if (mode == CleaverMode.REVERSAL) {
				setMode(stack, CleaverMode.NORMAL);
			} else if (mode == CleaverMode.NORMAL) {
				setMode(stack, CleaverMode.REVERSAL);
			}
			player.worldObj.playSoundAtEntity(player, "random.pop", 1.0F, 1.0F);
		}

		player.setItemInUse(stack, getMaxItemUseDuration(stack));
		return super.onItemRightClick(stack, world, player);
	}

	// タメ解放
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int i) {
		if (player != null && stack != null && !player.worldObj.isRemote) {
			CleaverMode mode = getMode(stack);
			if (mode != CleaverMode.REVERSAL)
				return;

			int j = this.getMaxItemUseDuration(stack) - i;
			int exp = player.experienceTotal;
			int sharp = EnchantmentHelper.getEnchantmentLevel(Enchantment.sharpness.effectId, stack);
			int holy = EnchantmentHelper.getEnchantmentLevel(Enchantment.smite.effectId, stack);
			int arthro = EnchantmentHelper.getEnchantmentLevel(Enchantment.baneOfArthropods.effectId, stack);
			boolean inf = EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, stack) > 0;

			if (!inf && !player.capabilities.isCreativeMode && !this.reduceExp(player, 5)) {
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
				WindProjectile bullet = new WindProjectile(player.worldObj, player, 3.0F, 1.0D + (sharp * 0.30D), 5.0F,
						adj);
				bullet.setParalysis(true);
				bullet.setInsecticide(arthro);
				bullet.setPurify(holy);
				player.worldObj.spawnEntityInWorld(bullet);
				player.worldObj.playSoundEffect(player.posX, player.posY - 1, player.posZ, "amtjp:wind", 0.15F, 0.75F);
			}

		}
	}

	// 攻撃時
	@Override
	public boolean onEntitySwing(EntityLivingBase entity, ItemStack stack) {
		if (entity != null && stack != null && !entity.worldObj.isRemote) {
			CleaverMode mode = getMode(stack);
			if (mode != CleaverMode.REVERSAL)
				return false;

			if (entity instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) entity;
				int exp = player.experienceTotal;
				boolean inf = EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, stack) > 0;
				if (!inf && !player.capabilities.isCreativeMode && !this.reduceExp(player, 1)) {
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
			float dam = 2.0F + (sharp * 0.25F);

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

	/* === ICleaverItem === */

	@Override
	public void onCleaverAttackAndPeel(boolean isAttack, boolean isPeel, float attackAmmount, boolean isCritical,
			EntityLivingBase target, float peelPower, ItemStack stack, EntityLivingBase owner) {
		int blood = this.getBloodCount(stack);
		CleaverMode mode = this.getMode(stack);
		// 速度を剥ぐ
		if (isPeel) {
			AJPLogger.debugInfo("on peel");
			Iterator iterator = owner.getActivePotionEffects().iterator();
			int level = 0;
			int dur = 0;
			while (iterator.hasNext()) {
				PotionEffect effect = (PotionEffect) iterator.next();
				if (effect != null && effect.getPotionID() == Potion.moveSpeed.getId()) {
					level = effect.getAmplifier();
					dur = effect.getDuration() + 200;
				}
			}
			if (level < 9 && this.itemRand.nextInt(8) == 0) {
				level++;
			}
			if (dur > 12000) {
				dur = 12000;
			}

			// ownerには速度上昇
			owner.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), dur, level));

			// 敵には速度低下
			target.addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(), 200, level));
		}
	}

	@Override
	public void onCleaverUpdate(int slot, boolean isHeld, float peelPower, ItemStack stack, EntityLivingBase owner) {
		// 手持ち効果
		if (owner.worldObj.isRemote || !isHeld)
			return;
		CleaverMode mode = this.getMode(stack);
		if (mode == CleaverMode.REVERSAL) {
			owner.fallDistance = 0.0F;
			owner.addPotionEffect(new PotionEffect(Potion.jump.id, 4, 1));
		}
	}

}
