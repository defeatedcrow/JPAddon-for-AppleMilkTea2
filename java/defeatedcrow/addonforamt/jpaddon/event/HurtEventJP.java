package defeatedcrow.addonforamt.jpaddon.event;

import java.util.Iterator;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;
import defeatedcrow.addonforamt.jpaddon.plugin.AJPMCEPlugin;
import defeatedcrow.addonforamt.jpaddon.plugin.PluginHandler;
import defeatedcrow.addonforamt.jpaddon.util.PotionJPLuck;

public class HurtEventJP {

	@SubscribeEvent
	public void onHurtEvent(LivingHurtEvent event) {
		EntityLivingBase target = event.entityLiving;
		DamageSource source = event.source;
		float damage = event.ammount;
		if (target != null && !target.worldObj.isRemote) {
			// luck potion
			if (source instanceof EntityDamageSource && source.getEntity() != null
					&& source.getEntity() instanceof EntityPlayer) {
				EntityPlayer attacker = (EntityPlayer) source.getEntity();
				boolean activeLuck = false;

				Iterator iterator = attacker.getActivePotionEffects().iterator();
				while (iterator.hasNext()) {
					PotionEffect effect = (PotionEffect) iterator.next();
					int id = effect.getPotionID();
					Potion potion = Potion.potionTypes[id];
					int amp = effect.getAmplifier();
					int dur = effect.getDuration();
					if (potion != null && potion instanceof PotionJPLuck) {
						activeLuck = true;
					}

					if (activeLuck) {
						int count = 2 * amp;
						int exp = 3 + target.worldObj.rand.nextInt(count);
						target.worldObj.spawnEntityInWorld(new EntityXPOrb(target.worldObj, target.posX, target.posY,
								target.posZ, exp));

						if (PluginHandler.mce) {
							AJPMCEPlugin.addMP(attacker, exp);
						}
					}
				}
			}

			// pig
			if (target instanceof EntityPig) {
				float max = target.getMaxHealth();
				float current = target.getHealth();
				if (current > max - 1.0F && damage >= max) {
					if (target.worldObj.rand.nextInt(10) > 0) {
						ItemStack pig = new ItemStack(AddonJPCore.roastPig, 1, 0);
						EntityItem entity = new EntityItem(target.worldObj, target.posX, target.posY, target.posZ, pig);
						entity.motionY = 0.15D;
						target.worldObj.spawnEntityInWorld(entity);
					}

				}
			}
		}
	}

}
