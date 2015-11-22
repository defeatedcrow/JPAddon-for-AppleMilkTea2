package defeatedcrow.addonforamt.jpaddon.plugin.cleaver;

import mods.defeatedcrow.api.potion.AMTPotionManager;
import mods.defeatedcrow.common.DCsAppleMilk;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import defeatedcrow.addonforamt.jpaddon.AJPLogger;

public class ItemNightCleaver extends DCsCleaverBase {

	@SideOnly(Side.CLIENT)
	private IIcon iconType[];

	public ItemNightCleaver() {
		super(DCsAppleMilk.enumToolMaterialChalcedony, 8.0F);
		this.setMaxStackSize(1);
		this.setMaxDamage(512);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (player != null && player.isSneaking()) {
			// mode変更処理
			CleaverMode mode = getMode(stack);
			if (mode == CleaverMode.REVERSAL) {
				setMode(stack, CleaverMode.NORMAL);
			} else if (mode == CleaverMode.NORMAL && getBloodCount(stack) > 2) {
				setMode(stack, CleaverMode.REVERSAL);
			}
			player.worldObj.playSoundAtEntity(player, "random.pop", 1.0F, 1.0F);
		}

		player.setItemInUse(stack, getMaxItemUseDuration(stack));
		return super.onItemRightClick(stack, world, player);
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int i) {
	}

	// アイコン制御
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconIndex(ItemStack stack) {
		if (stack != null) {
			NBTTagCompound nbt = stack.getTagCompound();
			if (nbt == null) {
				return this.itemIcon;
			}

			int blood = getBloodCount(stack);
			boolean rev = false;
			if (this.getMode(stack) == CleaverMode.REVERSAL) {
				rev = true;
			}
			if (this.getMode(stack) == CleaverMode.BERSERK) {
				rev = true;
			}

			float f = (blood * 5.0F) / bloodLimit;
			int ret = MathHelper.floor_float(f);
			ret = MathHelper.clamp_int(ret, 0, 4);
			return rev ? this.iconType[5] : this.iconType[ret];
		}
		return this.itemIcon;
	}

	@Override
	public IIcon getIcon(ItemStack stack, int pass) {
		return this.getIconIndex(stack);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon("amtjp:tools/cleaver_night_" + 0);
		this.iconType = new IIcon[6];
		for (int i = 0; i < 6; i++) {
			this.iconType[i] = par1IconRegister.registerIcon("amtjp:tools/cleaver_night_" + i);
		}
	}

	// ブロック時のダメージ減少
	@SubscribeEvent
	public void onHurtEvent(LivingHurtEvent event) {
		EntityLivingBase target = event.entityLiving;
		DamageSource source = event.source;
		float damage = event.ammount;
		if (target != null && !target.worldObj.isRemote) {
			// target側がplayer
			if (target != null && target instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) target;
				ItemStack hold = player.getCurrentEquippedItem();
				if (hold != null && hold.getItem() == AJPCleaverPlugin.nightCleaver) {
					if (player.isBlocking()) {
						// Projectile
						if (source instanceof EntityDamageSource && source.getEntity() != null
								&& source.getEntity() instanceof IProjectile) {
							event.ammount = 0.0F;
						} else {
							damage /= 4.0F;
							if (damage < 1.0F) {
								damage = 0.0F;
							}
							event.ammount = damage;
						}
						event.setResult(Result.ALLOW);
					}
				}
			}
		}
	}

	/* === ICleaverItem === */

	@Override
	public float getCleaverAttackAmmount(float rawAttackAmmount, boolean isCritical, EntityLivingBase target,
			float peelPower, ItemStack stack, EntityLivingBase owner) {
		// ここでダメージに倍率を掛ける
		CleaverMode mode = this.getMode(stack);
		int blood = this.getBloodCount(stack);

		float f = (1000.0F + blood) / 1000.0F;
		float ret = rawAttackAmmount * f;

		if (mode == CleaverMode.REVERSAL) {
			return ret * 5.0F;
		} else if (mode == CleaverMode.BERSERK) {
			return ret * 10.0F;
		}
		return ret;
	}

	@Override
	public void onCleaverAttackAndPeel(boolean isAttack, boolean isPeel, float attackAmmount, boolean isCritical,
			EntityLivingBase target, float peelPower, ItemStack stack, EntityLivingBase owner) {
		int blood = this.getBloodCount(stack);
		CleaverMode mode = this.getMode(stack);
		// Bloodゲージ管理
		if (mode == CleaverMode.NORMAL) {
			// 増加と暴走判定
			if (blood > bloodLimit - 1) {
				this.setMode(stack, CleaverMode.BERSERK);
				owner.worldObj.playSoundAtEntity(owner, "dig.glass", 1.0F, 1.0F);
			} else {
				this.addBloodCount(stack, 1);
			}
			stack.damageItem(1, owner);
		} else if (mode == CleaverMode.BERSERK || mode == CleaverMode.REVERSAL) {
			if (blood < 1) {
				this.setMode(stack, CleaverMode.NORMAL);
				owner.worldObj.playSoundAtEntity(owner, "random.pop", 1.0F, 1.0F);
			} else {
				this.addBloodCount(stack, -1);
			}
			int dam = stack.getItemDamage() - 1;
			if (dam < 0) {
				dam = 0;
			}
			stack.setItemDamage(dam);
		}
		// 体力を剥ぐ
		if (isPeel) {
			AJPLogger.debugInfo("on peel");
			owner.heal(1.0F);
		}
	}

	@Override
	public void onCleaverUpdate(int slot, boolean isHeld, float peelPower, ItemStack stack, EntityLivingBase owner) {
		// 手持ち効果
		if (owner.worldObj.isRemote || !isHeld)
			return;
		int blood = this.getBloodCount(stack);
		CleaverMode mode = this.getMode(stack);
		if (mode == CleaverMode.BERSERK) {
			owner.addPotionEffect(new PotionEffect(Potion.blindness.id, 4, 2));
			owner.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 4, 2));
			owner.addPotionEffect(new PotionEffect(AMTPotionManager.manager.AMTgetPotion("hallucination").id, 4, 1));
			this.addBloodCount(stack, -1);
			if (blood < 2) {
				this.setMode(stack, CleaverMode.NORMAL);
				owner.worldObj.playSoundAtEntity(owner, "dig.glass", 1.0F, 1.0F);
			}
		} else if (mode == CleaverMode.REVERSAL) {
			owner.addPotionEffect(new PotionEffect(Potion.nightVision.id, 4, 0));
			owner.addPotionEffect(new PotionEffect(Potion.invisibility.id, 4, 0));
			owner.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 4, 1));
		}
	}

}
