package defeatedcrow.addonforamt.jpaddon.plugin.cleaver;

import mods.defeatedcrow.common.DCsAppleMilk;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class CleaverUpdateEvent {

	private boolean pushKey = false;
	private boolean pushSec = false;

	@SubscribeEvent
	public void onLivingUpdate(LivingEvent.LivingUpdateEvent event) {
		Entity entity = event.entity;

		if (entity != null && (entity instanceof EntityPlayer)) {
			EntityPlayer player = (EntityPlayer) event.entity;
			ItemStack hold = player.getCurrentEquippedItem();
			if (hold == null)
				return;
			boolean cre = player.capabilities.isCreativeMode;

			if (player.worldObj.isRemote) {
				// client side : キー操作
				if (hold.getItem() == AJPCleaverPlugin.windCleaver) {
					NBTTagCompound nbt = hold.getTagCompound();
					if (nbt == null) {
						nbt = new NBTTagCompound();
					}
					boolean rev = false;
					if (nbt.hasKey("Reverse")) {
						rev = nbt.getBoolean("Reverse");
					}

					if (rev && player.isSneaking() && player.motionY < 0.0D && !cre) {
						// 落下中
						double d = player.motionY + 0.09D;
						if (d > -0.03D)
							d = -0.03D;
						player.motionY = d;
					}

					if (player.onGround) {
						this.pushKey = false;
						this.pushSec = false;
					}

					if (rev && player instanceof EntityPlayerSP) {
						if (!player.onGround) {
							if (DCsAppleMilk.proxy.isJumpKeyDown()) {
								if (!this.pushKey) {
									if (this.pushSec) {
										float yaw = player.rotationYaw;
										double newMX = (-MathHelper.sin(yaw / 180.0F * (float) Math.PI) * MathHelper
												.cos(player.rotationPitch / 180.0F * (float) Math.PI));
										double newMZ = (MathHelper.cos(yaw / 180.0F * (float) Math.PI) * MathHelper
												.cos(player.rotationPitch / 180.0F * (float) Math.PI));
										double newMY = ((-MathHelper.sin(player.rotationPitch / 180.0F
												* (float) Math.PI)));
										player.motionX += newMX * 0.5D;
										player.motionZ += newMZ * 0.5D;
										player.motionY += 0.25D + newMY * 0.5D;
									}
								}
								this.pushKey = true;
							} else if (this.pushKey) {
								this.pushKey = false;
								this.pushSec = true;
							}
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onDeath(LivingDeathEvent event) {
		Entity entity = event.entity;

		// プレイヤーが死ぬと暴走が解除される
		if (entity != null && (entity instanceof EntityPlayer)) {
			EntityPlayer player = (EntityPlayer) event.entity;
			ItemStack hold = player.getCurrentEquippedItem();
			if (hold == null)
				return;
			if (hold.getItem() instanceof ItemNightCleaver) {
				ItemNightCleaver night = (ItemNightCleaver) hold.getItem();
				CleaverMode mode = night.getMode(hold);
				if (mode == CleaverMode.BERSERK) {
					night.setMode(hold, CleaverMode.NORMAL);
				}
			}
		}
	}

}
