package defeatedcrow.addonforamt.jpaddon.plugin.cleaver;

import mods.defeatedcrow.api.potion.AMTPotionManager;
import mods.defeatedcrow.common.DCsAppleMilk;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import defeatedcrow.addonforamt.jpaddon.AJPLogger;

public class ItemNightCleaver extends ItemSword {

	private final float damage;
	private final int bloodLimit;

	@SideOnly(Side.CLIENT)
	private IIcon iconType[];

	public ItemNightCleaver() {
		super(DCsAppleMilk.enumToolMaterialChalcedony);
		this.setMaxStackSize(1);
		this.setMaxDamage(512);
		this.damage = 8.0F;
		this.bloodLimit = 100;
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
			boolean force = false;
			if (nbt.hasKey("Reverse")) {
				rev = nbt.getBoolean("Reverse");
			}
			if (nbt.hasKey("Forced")) {
				force = nbt.getBoolean("Forced");
			}
			short blood = 0;
			if (nbt.hasKey("Blood")) {
				blood = nbt.getShort("Blood");
			}
			if (!force) {
				boolean ret = !rev;
				if (!rev && blood < 2) {
					ret = false;
				}
				nbt.setBoolean("Reverse", ret);
				stack.setTagCompound(nbt);
				return stack;
			}

		}
		player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
		return stack;
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int i) {
	}

	@Override
	public boolean hitEntity(ItemStack item, EntityLivingBase entity, EntityLivingBase target) {
		if (entity == null || entity.worldObj.isRemote) {
			return true;
		}
		if (item != null && item.getItem() == this && target != null) {
			NBTTagCompound nbt = item.getTagCompound();
			if (nbt == null) {
				nbt = new NBTTagCompound();
			}

			boolean isReversal = false;
			if (nbt.hasKey("Reverse")) {
				isReversal = nbt.getBoolean("Reverse");
			}
			boolean forcedRev = false;
			if (nbt.hasKey("Forced")) {
				forcedRev = nbt.getBoolean("Forced");
			}
			short blood = 0;
			if (nbt.hasKey("Blood")) {
				blood = nbt.getShort("Blood");
			}
			short burst = 0;
			if (nbt.hasKey("Burst")) {
				burst = nbt.getShort("Burst");
			}

			/*-- 反転中--*/
			if (isReversal) {

				// 耐久値回復
				int dam = item.getItemDamage() - 1;
				if (dam < 0) {
					dam = 0;
				}
				item.setItemDamage(dam);

				boolean revEnd = false;
				// Forced
				if (forcedRev) {
					if (burst <= 0) {
						// 反転終了
						revEnd = true;
					} else {
						burst -= 2; // 2ずつ減る
					}
				} else {
					if (blood <= 0) {
						revEnd = true;
					} else {
						blood -= 1;
					}
				}

				if (revEnd) {
					// 反転終了
					forcedRev = false;
					isReversal = false;
					burst = (short) 0;
					blood = (short) 0;
				}

			} else {
				blood += 1;
				if (blood >= bloodLimit) {
					// bloodゲージが限界のため、強制反転状態に移行
					forcedRev = true;
					isReversal = true;
					burst = (short) 10;

					// 強制反転開始時にデバフを受ける
					entity.addPotionEffect(new PotionEffect(Potion.blindness.id, 1200, 2));
					entity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 1200, 2));
					entity.addPotionEffect(new PotionEffect(AMTPotionManager.manager.AMTgetPotion("hallucination").id,
							1200, 2));
				}

				item.damageItem(1, entity);
			}

			nbt.setBoolean("Forced", forcedRev);
			nbt.setBoolean("Reverse", isReversal);
			nbt.setShort("Blood", blood);
			nbt.setShort("Burst", burst);
			AJPLogger.debugInfo("reversal : " + isReversal);
			AJPLogger.debugInfo("forced : " + forcedRev);
			AJPLogger.debugInfo("blood count : " + blood);
			AJPLogger.debugInfo("burst count : " + burst);
			item.setTagCompound(nbt);
		}
		return true;
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

			int blood = 0;
			boolean rev = false;
			if (nbt.hasKey("Blood")) {
				blood = nbt.getShort("Blood");
			}
			if (nbt.hasKey("Reverse")) {
				rev = nbt.getBoolean("Reverse");
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

	// モードによるダメージ増
	@SubscribeEvent
	public void onHurtEvent(LivingHurtEvent event) {
		EntityLivingBase target = event.entityLiving;
		DamageSource source = event.source;
		float damage = event.ammount;
		if (target != null && !target.worldObj.isRemote) {
			// attacking側がplayerの場合
			if (source instanceof EntityDamageSource && source.getEntity() != null
					&& source.getEntity() instanceof EntityLivingBase) {
				EntityLivingBase base = (EntityLivingBase) source.getEntity();
				ItemStack hold = null;
				if (base instanceof EntityPlayer) {
					hold = ((EntityPlayer) base).getCurrentEquippedItem();
				} else if (base instanceof EntityLiving) {
					hold = ((EntityLiving) base).getHeldItem();
				}

				if (hold != null && hold.getItem() == AJPCleaverPlugin.nightCleaver) {
					AJPLogger.debugInfo("Cleaver!");
					boolean rev = false;
					NBTTagCompound nbt = hold.getTagCompound();
					if (nbt != null && nbt.hasKey("Reverse")) {
						rev = nbt.getBoolean("Reverse");
					}

					if (rev) {
						// Reverse中 : Damageが5倍になり、自傷ダメージを受ける
						event.ammount = damage * 5;
						base.attackEntityFrom(DamageSource.starve, 1.0F);
					} else {
						// 通常時 : 体力を回復
						base.heal(1.0F);
					}
					event.setResult(Result.ALLOW);
				}
			}

			// target側がplayer
			if (target != null && target instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) target;
				ItemStack hold = player.getCurrentEquippedItem();
				if (hold != null && hold.getItem() == AJPCleaverPlugin.nightCleaver) {
					AJPLogger.debugInfo("Cleaver!");
					if (player.isBlocking()) {
						// Projectile
						if (source instanceof EntityDamageSource && source.getEntity() != null
								&& source.getEntity() instanceof IProjectile) {
							event.ammount = 0.0F;
						} else {
							damage /= 2.0F;
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

}
