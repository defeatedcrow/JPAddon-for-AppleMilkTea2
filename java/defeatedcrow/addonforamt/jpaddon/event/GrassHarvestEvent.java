package defeatedcrow.addonforamt.jpaddon.event;

import mods.defeatedcrow.common.item.ItemChalcedonyKnife;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.event.world.BlockEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;
import defeatedcrow.addonforamt.jpaddon.plugin.AJPCleaverPlugin;

public class GrassHarvestEvent {

	@SubscribeEvent
	public void harvestEvent(BlockEvent.HarvestDropsEvent event) {
		ItemStack added = null;
		Block block = event.block;
		int meta = event.blockMetadata;
		int chance = event.world.rand.nextInt(12);
		EntityPlayer player = event.harvester;

		if (block instanceof BlockBush) {
			EnumPlantType type = ((BlockBush) block).getPlantType(event.world, event.x, event.y, event.z);
			if (type == EnumPlantType.Plains && player != null && !player.worldObj.isRemote) {
				ItemStack hold = player.inventory.getCurrentItem();

				boolean flag = false;
				if (hold != null) {
					if (hold.getItem() instanceof ItemChalcedonyKnife) {
						flag = true;
					} else if (AJPCleaverPlugin.isCleaver(hold)) {
						flag = true;
					}
				}

				if (flag) {
					if ((chance & 4) == 0) {
						event.drops.add(new ItemStack(AddonJPCore.materials, 1, 6));
					}
					if ((chance & 3) == 0) {
						event.drops.add(new ItemStack(AddonJPCore.materials, 1, 3));
					}
					if ((chance & 11) == 0) {
						event.drops.add(new ItemStack(AddonJPCore.materials, 1, 8));
					}
					event.setResult(Result.ALLOW);
				}
			}
		}

	}

}
