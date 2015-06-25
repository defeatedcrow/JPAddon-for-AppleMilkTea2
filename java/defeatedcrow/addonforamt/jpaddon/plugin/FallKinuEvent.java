package defeatedcrow.addonforamt.jpaddon.plugin;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import tsuteto.tofu.block.BlockTofuBase;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;

public class FallKinuEvent {

	@SubscribeEvent
	public void fallOnKinu(LivingEvent.LivingUpdateEvent event) {
		EntityLivingBase living = event.entityLiving;
		if (living != null && !living.worldObj.isRemote && living instanceof EntityPlayer) {
			// player
			EntityPlayer player = (EntityPlayer) living;
			World world = living.worldObj;
			// target block
			int x = MathHelper.floor_double(player.posX);
			int y = MathHelper.floor_double(player.posY);
			int z = MathHelper.floor_double(player.posZ);
			Block target = null;
			// armor
			ItemStack[] armor = new ItemStack[4];
			for (int k = 0; k < 4; k++) {
				armor[k] = player.inventory.armorInventory[k];
			}

			boolean isKinu = false;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					target = world.getBlock(x + i - 1, y - 1, z + j - 1);
					if (!world.isAirBlock(x + i - 1, y - 1, z + j - 1) && target instanceof BlockTofuBase) {
						isKinu = true;
					}
				}
			}

			if (isKinu && armor[1] != null && armor[1].getItem() == AddonJPCore.tofuApron) {
				player.fallDistance = 0.0F;
			}
		}
	}

}
