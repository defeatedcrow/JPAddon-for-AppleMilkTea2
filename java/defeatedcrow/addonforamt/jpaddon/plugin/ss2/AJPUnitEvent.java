package defeatedcrow.addonforamt.jpaddon.plugin.ss2;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import shift.sextiarysector.api.equipment.EquipmentType;
import shift.sextiarysector.player.EntityPlayerManager;
import shift.sextiarysector.player.EquipmentStats;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class AJPUnitEvent {

	private static int[] oX = {
			0,
			-1,
			0,
			1 };
	private static int[] oZ = {
			1,
			0,
			-1,
			0 };

	@SubscribeEvent
	public void UnitEvent(LivingEvent.LivingUpdateEvent event) {
		EntityLivingBase living = event.entityLiving;
		if (living != null && !living.worldObj.isRemote && living instanceof EntityPlayer) {
			// player
			EntityPlayer player = (EntityPlayer) living;
			World world = living.worldObj;
			// riding mob
			EntityLivingBase riding = null;
			if (player.ridingEntity != null && player.ridingEntity instanceof EntityLivingBase) {
				riding = (EntityLivingBase) player.ridingEntity;
			}

			// unit
			EquipmentStats e = EntityPlayerManager.getEquipmentStats(player);
			boolean hasIce = false;
			boolean hasAntidote = false;
			int size = 0;

			for (int i = 0; i < EquipmentType.Unit.getSlots().length; i++) {

				ItemStack item = e.inventory.getStackInSlot(EquipmentType.Unit.getSlots()[i]);

				if (item == null || item.getItem() == null)
					continue;
				if (item.getItem() == AJPSS2Plugin.iceUnit) {
					hasIce = true;
				} else if (item.getItem() == AJPSS2Plugin.antidoteUnit) {
					hasAntidote = true;
					size += item.stackSize;
				}

			}

			// 氷のユニット
			if (hasIce) {

				int side = MathHelper.floor_double(player.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
				int x = MathHelper.floor_double(player.posX);
				int y = MathHelper.floor_double(player.posY);
				int z = MathHelper.floor_double(player.posZ);
				if (riding != null) {
					x = MathHelper.floor_double(riding.posX);
					y = MathHelper.floor_double(riding.posY);
					z = MathHelper.floor_double(riding.posZ);
				}

				// 先行処理
				Block target = null;
				target = world.getBlock(x, y - 1, z);
				if (!world.isAirBlock(x, y - 1, z) && target == Blocks.water) {
					world.setBlock(x, y - 1, z, Blocks.ice);
				} else if (!world.isAirBlock(x, y - 1, z) && target == Blocks.lava) {
					world.setBlock(x, y - 1, z, Blocks.cobblestone);
				}

				// ついでに周囲も固める
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						int x1 = x + i - 1 + oX[side];
						int z1 = z + j - 1 + oZ[side];
						target = world.getBlock(x1, y - 1, z1);
						if (!world.isAirBlock(x1, y - 1, z1) && target == Blocks.water) {
							world.setBlock(x1, y - 1, z1, Blocks.ice);
						} else if (!world.isAirBlock(x1, y - 1, z1) && target == Blocks.lava) {
							world.setBlock(x1, y - 1, z1, Blocks.cobblestone);
						}
					}
				}
			}

			// 耐毒ユニット
			if (hasAntidote) {
				if (size > 3) {
					if (player.isPotionActive(Potion.blindness.id)) {
						player.removePotionEffect(Potion.blindness.id);
					}
					if (riding != null && riding.isPotionActive(Potion.blindness.id)) {
						riding.removePotionEffect(Potion.blindness.id);
					}

					if (player.isPotionActive(Potion.confusion.id)) {
						player.removePotionEffect(Potion.confusion.id);
					}
					if (riding != null && riding.isPotionActive(Potion.confusion.id)) {
						riding.removePotionEffect(Potion.confusion.id);
					}
				}
				if (size > 2) {
					if (player.isPotionActive(Potion.wither.id)) {
						player.removePotionEffect(Potion.wither.id);
					}
					if (riding != null && riding.isPotionActive(Potion.wither.id)) {
						riding.removePotionEffect(Potion.wither.id);
					}
				}
				if (size > 1) {
					if (player.isPotionActive(Potion.poison.id)) {
						player.removePotionEffect(Potion.poison.id);
					}
					if (riding != null && riding.isPotionActive(Potion.poison.id)) {
						riding.removePotionEffect(Potion.poison.id);
					}
				}
				if (size > 0) {
					if (player.isPotionActive(Potion.hunger.id)) {
						player.removePotionEffect(Potion.hunger.id);
					}
					if (riding != null && riding.isPotionActive(Potion.hunger.id)) {
						riding.removePotionEffect(Potion.hunger.id);
					}
				}

			}

		}
	}

}
