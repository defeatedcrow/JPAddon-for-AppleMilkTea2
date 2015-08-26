package defeatedcrow.addonforamt.jpaddon.common.entity;

import java.util.ArrayList;
import java.util.List;

import mods.defeatedcrow.api.plants.IRightClickHarvestable;
import mods.defeatedcrow.client.particle.EntityFeatherFX;
import mods.defeatedcrow.client.particle.ParticleTex;
import mods.defeatedcrow.common.entity.dummy.EntityStunEffect;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockStem;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;

/*
 * YuzuBulletの亜種。
 * すぐに消える代わりにサイズが大きめで、葉や草を消す。
 * */
public class WindProjectile extends Entity implements IProjectile {

	/* 地中判定に使うもの */
	protected int xTile = -1;
	protected int yTile = -1;
	protected int zTile = -1;
	protected Block inTile;
	protected int inData;
	protected boolean inGround;

	/* この弾を撃ったエンティティ */
	public Entity shootingEntity;

	/* 地中・空中にいる時間 */
	protected int ticksInGround;
	protected int ticksInAir;
	protected int livingTimeCount = 0;

	/* ダメージの大きさ */
	protected final double damage;

	/* 前進速度 */
	protected double speed = 1.0D;

	/* 幅 */
	protected final double range;

	/* 特殊効果 */
	protected boolean paralysis = false;
	protected boolean isFire = false;
	protected float knockback = 0.0F;
	protected int purifucationLevel = 0;
	protected int insecticideLevel = 0;
	protected int loot = 0;

	public WindProjectile(World par1World) {
		super(par1World);
		this.renderDistanceWeight = 10.0D;
		this.setSize(5F, 5F);
		this.damage = 10.0D;
		this.range = 4.0D;
	}

	public WindProjectile(World par1World, float size, double thisdamage, double thisrange) {
		super(par1World);
		this.setSize(size, size);
		this.range = thisrange;
		this.damage = thisdamage;
	}

	public WindProjectile(World world, EntityLivingBase attacker, float speed, double damage, double range,
			float adjustYaw) {
		this(world, 5.0F, damage, range);
		this.shootingEntity = attacker;
		this.yOffset = 0.0F;

		float y = attacker.rotationYaw + adjustYaw;

		// 初期状態での向きの決定
		this.setLocationAndAngles(attacker.posX, attacker.posY + attacker.getEyeHeight() - 1.0D, attacker.posZ, y,
				attacker.rotationPitch);

		// 位置の調整
		this.posX += (-MathHelper.sin(y / 180.0F * (float) Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F
				* (float) Math.PI));
		this.posZ += (MathHelper.cos(y / 180.0F * (float) Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F
				* (float) Math.PI));
		this.setPosition(this.posX, this.posY, this.posZ);

		float f1 = worldObj.rand.nextFloat() * 0.1F - 0.05F;
		float f2 = worldObj.rand.nextFloat() * 0.1F - 0.05F;
		float f3 = worldObj.rand.nextFloat() * 0.1F - 0.05F;

		// 初速度
		this.motionX = f1
				+ ((double) (-MathHelper.sin(y / 180.0F * (float) Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F
						* (float) Math.PI)));
		this.motionZ = f2
				+ ((double) (MathHelper.cos(y / 180.0F * (float) Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F
						* (float) Math.PI)));
		this.motionY = f3 + ((double) (-MathHelper.sin(this.rotationPitch / 180.0F * (float) Math.PI)));
		this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, speed, 1.0F);
	}

	@Override
	protected void entityInit() {

	}

	@Override
	public void setThrowableHeading(double par1, double par3, double par5, float par7, float par8) {
		float f2 = MathHelper.sqrt_double(par1 * par1 + par3 * par3 + par5 * par5);
		par1 /= f2;
		par3 /= f2;
		par5 /= f2;
		par1 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * par8;
		par3 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * par8;
		par5 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * par8;
		par1 *= par7;
		par3 *= par7;
		par5 *= par7;
		this.motionX = par1;
		this.motionY = par3;
		this.motionZ = par5;
		float f3 = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
		this.prevRotationYaw = this.rotationYaw = (float) (Math.atan2(par1, par5) * 180.0D / Math.PI);
		this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(par3, f3) * 180.0D / Math.PI);
		this.ticksInGround = 0;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
		this.setPosition(par1, par3, par5);
		this.setRotation(par7, par8);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void setVelocity(double par1, double par3, double par5) {
		this.motionX = par1;
		this.motionY = par3;
		this.motionZ = par5;

		if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
			float f = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
			this.prevRotationYaw = this.rotationYaw = (float) (Math.atan2(par1, par5) * 180.0D / Math.PI);
			this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(par3, f) * 180.0D / Math.PI);
			this.prevRotationPitch = this.rotationPitch;
			this.prevRotationYaw = this.rotationYaw;
			this.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
			this.ticksInGround = 0;
		}
	}

	/*
	 * Tick毎に呼ばれる更新処理。
	 * 速度の更新、衝突判定などをここで行う。
	 */
	@Override
	public void onUpdate() {
		super.onUpdate();

		livingTimeCount++;
		if (livingTimeCount > 2)
			this.setDead();

		// 直前のパラメータと新パラメータを一致させているところ。
		// また、速度に応じてエンティティの向きを調整し、常に進行方向に前面が向くようにしている。
		if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
			float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
			this.prevRotationYaw = this.rotationYaw = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
			this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(this.motionY, f) * 180.0D / Math.PI);
		}

		// block消去処理
		// 消去直前にのみ発動する
		if (livingTimeCount > 0 && !worldObj.isRemote) {
			int x = MathHelper.floor_double(this.posX - 3.0D);
			int y = MathHelper.floor_double(this.posY - 3.0D);
			int z = MathHelper.floor_double(this.posZ - 3.0D);
			int X = MathHelper.floor_double(this.posX + 3.0D);
			int Y = MathHelper.floor_double(this.posY + 3.0D);
			int Z = MathHelper.floor_double(this.posZ + 3.0D);
			for (int a = x; a < X; a++) {
				for (int b = y; b < Y; b++) {
					for (int c = z; c < Z; c++) {
						Block target = worldObj.getBlock(a, b, c);
						int meta = worldObj.getBlockMetadata(a, b, c);

						if (target != null && target.getMaterial() != Material.air) {
							if (target instanceof IGrowable && !(target instanceof BlockTallGrass)) {
								// 雑草以外のIGrowable
								IGrowable crop = (IGrowable) target;
								if (!crop.func_149851_a(worldObj, a, b, c, true) && !(crop instanceof BlockStem)) {
									target.dropBlockAsItemWithChance(worldObj, a, b, c, meta, 1.0F, 0);
									worldObj.setBlockToAir(a, b, c);
								}
							} else if (target instanceof IRightClickHarvestable) {
								// 右クリック収穫系
								IRightClickHarvestable plantsAMT = (IRightClickHarvestable) target;
								plantsAMT.onHarvest(worldObj, a, b, c, null, null);
							} else if (target instanceof BlockBush) {
								// 雑草
								if (!worldObj.isRemote) {
									worldObj.func_147480_a(a, b, c, true);
									int chance = worldObj.rand.nextInt(30);
									ItemStack ret = null;
									if ((chance & 15) == 4) {
										ret = new ItemStack(AddonJPCore.materials, 1, 6);
									}
									if ((chance & 15) == 1) {
										ret = new ItemStack(AddonJPCore.materials, 1, 3);
									}
									if ((chance & 15) == 0) {
										ret = new ItemStack(AddonJPCore.materials, 1, 8);
									}
									if (ret != null) {
										EntityItem drop = new EntityItem(worldObj, a, b, c, ret);
										worldObj.spawnEntityInWorld(drop);
									}
								}
							} else if (target.getMaterial() == Material.leaves) {
								worldObj.func_147480_a(a, b, c, true);
							}
						}
					}
				}
			}
		}

		++this.ticksInAir;

		if (!worldObj.isRemote) {
			List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this,
					this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(range, range, range));
			double db = 0.0D;
			int l;
			ArrayList<Entity> entityList = new ArrayList<Entity>();

			// 1ブロック分の範囲内にいるエンティティ全てに対して繰り返す
			for (l = 0; l < list.size(); ++l) {
				Entity entity = (Entity) list.get(l);

				// 発射物自身or射手だとすりぬける
				if (entity.canBeCollidedWith() && entity != this.shootingEntity && !(entity instanceof WindProjectile)) {
					double dis = 0.0D;
					if (shootingEntity != null) {
						dis = entity.getDistanceSqToEntity(shootingEntity);
					}

					if (dis < 45.0D || dis == 0.0D) {
						entityList.add(entity);
					}
				}
			}

			/*
			 * 当たったエンティティそれそれについての判定部分。
			 * ここで特定の種類のエンティティに当たらないようにできる。
			 */
			if (entityList != null && !entityList.isEmpty()) {
				for (int n = 0; n < entityList.size(); n++) {
					Entity target = entityList.get(n);

					if (target instanceof EntityPlayer) {
						// プレイヤーに当たった時
						EntityPlayer entityplayer = (EntityPlayer) target;

						if (entityplayer.capabilities.disableDamage || this.shootingEntity instanceof EntityPlayer
								&& !((EntityPlayer) this.shootingEntity).canAttackPlayer(entityplayer)) {
							// PvPが許可されていないと当たらない
							entityList.remove(n);
						}
					} else if (target == this.shootingEntity) {
						// 対象が撃った本人の場合も当たらない
						entityList.remove(n);
					}
				}
			}

			float f2;
			float f3;

			// 当たったあとの処理
			// まずはリストから
			if (entityList != null && !entityList.isEmpty()) {
				for (Entity target : entityList) {
					if (target != null) {
						// ダメージ
						// 特攻エンチャントの効果を載せる
						double dam = this.damage;
						if ((target instanceof EntityLivingBase) && ((EntityLivingBase) target).isEntityUndead()) {
							dam += this.getPurificationLevel() * 3.0F;
						}
						if ((target instanceof EntityLivingBase)
								&& ((EntityLivingBase) target).getCreatureAttribute() == EnumCreatureAttribute.ARTHROPOD) {
							dam += this.getInsecticideLevel() * 3.0F;
						}
						// 0~2程度の乱数値を上乗せ
						float i1 = (float) dam + this.rand.nextInt(3);

						// 別メソッドでダメージソースを確認
						DamageSource damagesource = this.thisDamageSource(this.shootingEntity);

						if (target instanceof IProjectile) {
							// 対象が矢などの飛翔Entityの場合、打ち消すことが出来る
							target.setDead();
						} else {
							if (target instanceof EntityLivingBase) {
								// ダメージを与えることに成功したら以下の処理を行う
								if (target.attackEntityFrom(damagesource, i1)) {
									EntityLivingBase living = (EntityLivingBase) target;

									// 移動速度を下げる
									if (this.paralysis) {
										living.addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(), 1200, 2));
									}

									// 着火
									if (this.isFire) {
										living.setFire(3);
									}

									// looting
									if (this.loot > 0 && !worldObj.isRemote) {
										int i = loot * 5;
										int j = i + worldObj.rand.nextInt(i);
										worldObj.spawnEntityInWorld(new EntityXPOrb(worldObj, posX, posY, posZ, j));
									}

									// ノックバック
									if (this.paralysis) {
										if (!this.worldObj.isRemote && living instanceof EntityLiving) {
											EntityStunEffect stun = new EntityStunEffect(this.worldObj,
													(EntityLiving) living, null, 20);
											this.worldObj.spawnEntityInWorld(stun);
										}
									} else {
										f3 = this.getKnockback();
										if (f3 > 0.0F) {
											living.knockBack(target, 10.0F, motionX * f3, motionZ * f3);
										}
									}

									// 無敵時間
									// if (this.getKnockback() < 2.0F) {
									// target.hurtResistantTime = 0;
									// }

									// マルチプレイ時に、両者がプレイヤーだった時のパケット送信処理
									if (this.shootingEntity != null && target != this.shootingEntity
											&& target instanceof EntityPlayer
											&& this.shootingEntity instanceof EntityPlayerMP) {
										((EntityPlayerMP) this.shootingEntity).playerNetServerHandler
												.sendPacket(new S2BPacketChangeGameState(6, 0.0F));
									}
								}
							}
						}
					}
				}
			}
		}

		// 改めてポジションに速度を加算。向きも更新。
		this.posX += this.motionX;
		this.posY += this.motionY;
		this.posZ += this.motionZ;
		float sp = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
		this.rotationYaw = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
		this.rotationPitch = (float) (Math.atan2(this.motionY, sp) * 180.0D / Math.PI);

		while (this.rotationPitch - this.prevRotationPitch < -180.0F) {
			this.prevRotationPitch -= 360.0F;
		}

		while (this.rotationPitch - this.prevRotationPitch >= 180.0F) {
			this.prevRotationPitch += 360.0F;
		}

		while (this.rotationYaw - this.prevRotationYaw < -180.0F) {
			this.prevRotationYaw -= 360.0F;
		}

		while (this.rotationYaw - this.prevRotationYaw >= 180.0F) {
			this.prevRotationYaw += 360.0F;
		}

		this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
		this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;

		// 徐々に減速する
		float f4 = 0.9F;

		// 水中に有る
		if (this.isInWater()) {
			if (this.isBurning()) {
				this.extinguish();
			}

			// 減速も大きくなる
			f4 = 0.1F;
		}

		if (this.worldObj.isRemote) {
			double d0 = this.posX + this.worldObj.rand.nextFloat();
			double d1 = this.posY + this.worldObj.rand.nextFloat();
			double d2 = this.posZ + this.worldObj.rand.nextFloat();
			double d3 = this.motionX * 0.1D + this.worldObj.rand.nextFloat() - 0.5D;
			double d4 = this.worldObj.rand.nextFloat() / 2.0D;
			double d5 = this.motionZ * 0.1D + this.worldObj.rand.nextFloat() - 0.5D;

			EntityFeatherFX cloud = new EntityFeatherFX(this.worldObj, d0, d1, d2, d3, d4, d5, 20);
			cloud.setParticleIcon(ParticleTex.getInstance().getIcon("feather"));
			FMLClientHandler.instance().getClient().effectRenderer.addEffect(cloud);
		}

		this.motionX *= f4;
		this.motionY *= f4;
		this.motionZ *= f4;

		// 一定以上遅くなったら消える
		if (this.worldObj.isRemote && (this.motionX * this.motionX + this.motionZ * this.motionZ) < 0.001D) {
			this.setDead();
		}

		this.setPosition(this.posX, this.posY, this.posZ);
		this.func_145775_I();
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		par1NBTTagCompound.setShort("xTile", (short) this.xTile);
		par1NBTTagCompound.setShort("yTile", (short) this.yTile);
		par1NBTTagCompound.setShort("zTile", (short) this.zTile);
		par1NBTTagCompound.setByte("inTile", (byte) Block.getIdFromBlock(this.inTile));
		par1NBTTagCompound.setByte("inData", (byte) this.inData);
		par1NBTTagCompound.setByte("inGround", (byte) (this.inGround ? 1 : 0));
	}

	/*
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		this.xTile = par1NBTTagCompound.getShort("xTile");
		this.yTile = par1NBTTagCompound.getShort("yTile");
		this.zTile = par1NBTTagCompound.getShort("zTile");
		this.inTile = Block.getBlockById(par1NBTTagCompound.getByte("inTile") & 255);
		this.inData = par1NBTTagCompound.getByte("inData") & 255;
		this.inGround = par1NBTTagCompound.getByte("inGround") == 1;
	}

	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getShadowSize() {
		return 0.0F;
	}

	@Override
	public boolean canAttackWithItem() {
		return false;
	}

	/* 後から追加するパラメータ */
	public float fallSpeed() {
		return 0.0F;
	}

	public void setParalysis(boolean b) {
		this.paralysis = b;
	}

	public boolean getParalysis() {
		return this.paralysis;
	}

	public void setAdvFire(boolean b) {
		this.isFire = b;
	}

	public boolean getAdvFire() {
		return this.isFire;
	}

	public void setKnockback(float f) {
		this.knockback = f;
	}

	public float getKnockback() {
		return this.knockback;
	}

	public void setPurify(int i) {
		this.purifucationLevel = i;
	}

	public int getPurificationLevel() {
		return this.purifucationLevel;
	}

	public void setInsecticide(int i) {
		this.insecticideLevel = i;
	}

	public int getInsecticideLevel() {
		return this.insecticideLevel;
	}

	public void setLooting(int i) {
		this.loot = i;
	}

	public int getLooting() {
		return this.loot;
	}

	/* ダメージソースのタイプ */
	public DamageSource thisDamageSource(Entity entity) {
		// 発射元のEntityがnullだった場合の対策を含む。
		if (entity == null) {
			return DamageSource.drown;
		} else {
			if (entity instanceof EntityPlayer) {
				return DamageSource.causePlayerDamage((EntityPlayer) entity);
			} else if (entity instanceof EntityLivingBase) {
				return DamageSource.causeMobDamage((EntityLivingBase) entity);
			} else {
				return DamageSource.drown;
			}
		}
	}

	/* ブロック貫通 */
	public boolean isPenetrateBlock() {
		return true;
	}

	/* エンティティ貫通 */
	public boolean isPenetrateEntity() {
		return true;
	}

}
