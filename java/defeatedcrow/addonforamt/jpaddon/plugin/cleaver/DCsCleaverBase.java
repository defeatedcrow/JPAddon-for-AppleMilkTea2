package defeatedcrow.addonforamt.jpaddon.plugin.cleaver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import schr0.cleaver.api.ICleaverItem;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DCsCleaverBase extends ItemSword implements ICleaverItem, ICleaverAMT {

	private final float damage;
	protected static short bloodLimit = 1200;

	public DCsCleaverBase(ToolMaterial material, float damage) {
		super(material);
		this.setMaxStackSize(1);
		this.damage = damage;
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
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		if (stack != null && stack.getItem() instanceof ICleaverAMT) {
			CleaverMode mode = this.getMode(stack);
			if (mode == CleaverMode.BERSERK) {
				return EnumRarity.epic;
			} else if (mode == CleaverMode.REVERSAL) {
				return EnumRarity.rare;
			}
		}
		return EnumRarity.common;
	}

	/* === ICleaverAMT === */

	@Override
	public CleaverMode getMode(ItemStack stack) {
		if (stack == null || !(stack.getItem() instanceof ICleaverAMT))
			return CleaverMode.NONE;
		NBTTagCompound nbt = stack.getTagCompound();
		if (nbt == null) {
			nbt = new NBTTagCompound();
		}
		if (nbt.hasKey("Forced") && nbt.getBoolean("Forced")) {
			return CleaverMode.BERSERK;
		} else if (nbt.hasKey("Reverse") && nbt.getBoolean("Reverse")) {
			return CleaverMode.REVERSAL;
		}

		return CleaverMode.NORMAL;
	}

	@Override
	public void setMode(ItemStack stack, CleaverMode mode) {
		if (stack == null || !(stack.getItem() instanceof ICleaverAMT))
			return;
		NBTTagCompound nbt = stack.getTagCompound();
		if (nbt == null) {
			nbt = new NBTTagCompound();
		}
		if (mode == CleaverMode.BERSERK) {
			nbt.setBoolean("Forced", true);
			nbt.setBoolean("Reverse", true);
		} else if (mode == CleaverMode.REVERSAL) {
			nbt.setBoolean("Forced", false);
			nbt.setBoolean("Reverse", true);
		} else if (mode == CleaverMode.NORMAL) {
			nbt.setBoolean("Forced", false);
			nbt.setBoolean("Reverse", false);
		}
		stack.setTagCompound(nbt);
	}

	@Override
	public int getBloodCount(ItemStack stack) {
		if (stack == null || !(stack.getItem() instanceof ICleaverAMT))
			return 0;
		NBTTagCompound nbt = stack.getTagCompound();
		if (nbt == null) {
			nbt = new NBTTagCompound();
		}
		short blood = 0;
		if (nbt.hasKey("Blood")) {
			blood = nbt.getShort("Blood");
		}
		return blood;
	}

	@Override
	public void addBloodCount(ItemStack stack, int add) {
		if (stack == null || !(stack.getItem() instanceof ICleaverAMT))
			return;
		NBTTagCompound nbt = stack.getTagCompound();
		if (nbt == null) {
			nbt = new NBTTagCompound();
		}
		short blood = 0;
		if (nbt.hasKey("Blood")) {
			blood = nbt.getShort("Blood");
		}
		blood += add;
		if (blood < 0)
			blood = 0;
		if (blood > bloodLimit)
			blood = bloodLimit;
		nbt.setShort("Blood", blood);
		stack.setTagCompound(nbt);
	}

	/* === getter setter === */

	@Override
	public float getCleaverPeelPower(ItemStack stack, EntityLivingBase owner) {
		// Cleaver本家ベース
		float attackPower = (float) owner.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();

		if (!stack.getAttributeModifiers().isEmpty()) {
			Iterator iterator = stack.getAttributeModifiers().entries().iterator();

			while (iterator.hasNext()) {
				Entry entry = (Entry) iterator.next();
				AttributeModifier attributemodifier = (AttributeModifier) entry.getValue();
				double amount = attributemodifier.getAmount();

				if (attributemodifier.getName().equals("Weapon modifier")) {
					attackPower += (float) (amount + EnchantmentHelper.func_152377_a(stack,
							EnumCreatureAttribute.UNDEFINED));
				}
			}
		}

		attackPower *= 0.6F; // 6がけ

		// blood補正
		int blood = getBloodCount(stack);
		float f = (1000.0F + blood) / 1000.0F;
		attackPower *= f;

		float peelPower = attackPower;
		float maxPeelPower = this.getCleaverMaxPeelPower();

		if (peelPower <= 1.0F) {
			peelPower = 1.0F;
		}

		if (maxPeelPower < peelPower) {
			peelPower = maxPeelPower;
		}

		return peelPower;
	}

	@Override
	public float getCleaverMaxPeelPower() {
		return 9.0F;
	}

	@Override
	public float getCleaverAttackAmmount(float rawAttackAmmount, boolean isCritical, EntityLivingBase target,
			float peelPower, ItemStack stack, EntityLivingBase owner) {
		// nightはここでダメージに倍率を掛ける
		return rawAttackAmmount;
	}

	@Override
	public boolean isCleaverAttack(float attackAmmount, boolean isCritical, EntityLivingBase target, float peelPower,
			ItemStack stack, EntityLivingBase owner) {
		return true;
	}

	@Override
	public boolean isCleaverPeel(float attackAmmount, boolean isCritical, EntityLivingBase target, float peelPower,
			ItemStack stack, EntityLivingBase owner) {
		if (owner.worldObj.isRemote)
			return false;
		// 強化すれば100%にできる
		int chance = (100 - ((int) peelPower * 10));

		if (isCritical) {
			chance /= 1.5F;
		}

		if (chance < 10) {
			chance = 10;
		}

		return owner.worldObj.rand.nextInt(chance) < 10;
	}

	@Override
	public void onCleaverAttackAndPeel(boolean isAttack, boolean isPeel, float attackAmmount, boolean isCritical,
			EntityLivingBase target, float peelPower, ItemStack stack, EntityLivingBase owner) {
		// 実際に何かをはぎ取る処理。
		// 要実装
	}

	@Override
	public ArrayList<EntityItem> getCleaverKillDrop(ArrayList<EntityItem> killDrop, int lootingLevel,
			boolean recentlyHit, int specialDropValue, boolean isCritical, EntityLivingBase target, float peelPower,
			ItemStack stack, EntityLivingBase owner) {
		// このアドオンの武器はドロップ増加できない
		return killDrop;
	}

	@Override
	public void onCleaverKill(boolean isCritical, EntityLivingBase target, float peelPower, ItemStack stack,
			EntityLivingBase owner) {
		// とどめを刺したとき。
		// 要実装

	}

	@Override
	public boolean isCleaverEntityInteract(Entity target, float peelPower, ItemStack stack, EntityPlayer player) {
		// interact効果はない
		return false;
	}

	@Override
	public void onCleaverEntityInteract(boolean isEntityInteract, Entity target, float peelPower, ItemStack stack,
			EntityPlayer player) {
	}

	@Override
	public boolean isCleaverBlockInteract(int blockX, int blockY, int blockZ, int blockFace, Block block,
			int blockMetadata, World world, float peelPower, ItemStack stack, EntityPlayer player) {
		// ガード時の独自実装なのでこれもなし
		return false;
	}

	@Override
	public void onCleaverBlockInteract(boolean isBlockInteract, int blockX, int blockY, int blockZ, int blockFace,
			Block block, int blockMetadata, World world, float peelPower, ItemStack stack, EntityPlayer player) {
	}

	@Override
	public void onCleaverUpdate(int slot, boolean isHeld, float peelPower, ItemStack stack, EntityLivingBase owner) {
		// 手持ち効果

	}

	@Override
	public float getCleaverHurtAmmount(float rawHurtAmmount, DamageSource damageSource, float peelPower,
			ItemStack stack, EntityLivingBase owner) {
		// おそらく外部イベント用かな
		return rawHurtAmmount;
	}

	@Override
	public boolean isCleaverHurt(float hurtAmmount, DamageSource damageSource, float peelPower, ItemStack stack,
			EntityLivingBase owner) {
		return true;
	}

	@Override
	public void onCleaverHurt(boolean isHurt, float hurtAmmount, DamageSource damageSource, float peelPower,
			ItemStack stack, EntityLivingBase owner) {
	}

	@Override
	public ArrayList<EntityItem> getCleaverDeathDrop(ArrayList<EntityItem> deathDrop, int lootingLevel,
			boolean recentlyHit, int specialDropValue, DamageSource damageSource, float peelPower, ItemStack stack,
			EntityLivingBase owner) {
		return deathDrop;
	}

	@Override
	public void onCleaverDeath(DamageSource damageSource, float peelPower, ItemStack stack, EntityLivingBase owner) {
	}

	@Override
	public ArrayList<ItemStack> getCleaverHarvestDrop(ArrayList<ItemStack> blockDrop, int blockX, int blockY,
			int blockZ, Block block, int blockMetadata, World world, float peelPower, ItemStack stack,
			EntityPlayer player) {
		// ブロック破壊の追加 今回は無し
		return blockDrop;
	}

	@Override
	public void onCleaverHarvest(int blockX, int blockY, int blockZ, Block block, int blockMetadata, World world,
			float peelPower, ItemStack stack, EntityPlayer player) {
	}

}
