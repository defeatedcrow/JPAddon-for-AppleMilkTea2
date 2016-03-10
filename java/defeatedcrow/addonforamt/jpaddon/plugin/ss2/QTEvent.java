package defeatedcrow.addonforamt.jpaddon.plugin.ss2;

import mods.defeatedcrow.plugin.SSector.LoadSSectorPlugin;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import shift.sextiarysector.api.SextiarySectorAPI;
import shift.sextiarysector.api.equipment.EquipmentType;
import shift.sextiarysector.player.EntityPlayerManager;
import shift.sextiarysector.player.EquipmentStats;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class QTEvent {

	@SubscribeEvent
	public void onHurtEvent(LivingHurtEvent event) {
		EntityLivingBase target = event.entityLiving;
		DamageSource source = event.source;
		float damage = event.ammount;
		if (target != null && !target.worldObj.isRemote && target instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) target;
			float life = player.getHealth();
			if (damage >= 1.0F && life - damage < 0.5F) {
				// unit
				EquipmentStats e = EntityPlayerManager.getEquipmentStats(player);
				boolean hasUnit = false;

				for (int i = 0; i < EquipmentType.Unit.getSlots().length; i++) {
					ItemStack item = e.inventory.getStackInSlot(EquipmentType.Unit.getSlots()[i]);

					if (item == null || item.getItem() == null)
						continue;
					if (item.getItem() == AJPSS2Plugin.qtUnit) {
						hasUnit = true;
					}
				}

				if (hasUnit) {
					float current = LoadSSectorPlugin.getStaminaStats(player);
					float newDam = life - 0.5F;
					float reduceStamina = damage - newDam;
					if (current < reduceStamina) {
						newDam += (reduceStamina - current);
					}
					// スタミナで肩代わり
					SextiarySectorAPI.addStaminaExhaustion(player, newDam * -4.0F);
					// 新ダメージを与える
					if (newDam > 0.0F) {
						event.ammount = newDam;
					} else {
						event.setCanceled(true);
					}
				}
			}
		}
	}

}
