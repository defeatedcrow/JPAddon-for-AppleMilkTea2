package defeatedcrow.addonforamt.jpaddon.event;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;

public class PlayerKimonoEvent {

	@SubscribeEvent
	public void onCraftingEvent(PlayerEvent.ItemCraftedEvent event) {

		EntityPlayer player = event.player;
		IInventory craftMatrix = event.craftMatrix;
		ItemStack crafting = event.crafting;
		if (player != null && !player.worldObj.isRemote) {
			ItemStack[] armor = new ItemStack[4];
			for (int k = 0; k < 4; k++) {
				armor[k] = player.inventory.armorInventory[k];
			}

			if (player.worldObj.rand.nextInt(5) == 0 && armor[1] != null && armor[1].getItem() == AddonJPCore.samue) {
				player.worldObj.spawnEntityInWorld(new EntityXPOrb(player.worldObj, player.posX, player.posY,
						player.posZ, 2));
			}
		}
	}

	@SubscribeEvent
	public void onHurtEvent(LivingHurtEvent event) {
		EntityLivingBase target = event.entityLiving;
		DamageSource source = event.source;
		float damage = event.ammount;

		if (!target.worldObj.isRemote && source != null && source.getSourceOfDamage() != null
				&& source.getSourceOfDamage() instanceof EntityLivingBase) {
			boolean flag = false;
			EntityLivingBase liv = (EntityLivingBase) source.getSourceOfDamage();
			if (liv instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) liv;
				ItemStack armor = player.inventory.armorInventory[2];
				if (armor != null && armor.getItem() == AddonJPCore.montukiHaori) {
					flag = true;
				}
			} else if (liv instanceof EntityLiving) {
				EntityLiving mob = (EntityLiving) liv;
				ItemStack armor = mob.getEquipmentInSlot(2);
				if (armor != null && armor.getItem() == AddonJPCore.montukiHaori) {
					flag = true;
				}
			}

			if (flag) {
				event.ammount += 1.0F;
				event.setResult(Result.ALLOW);
			}

		}
	}
}
