package defeatedcrow.addonforamt.jpaddon.plugin.ss2;

import java.util.ArrayList;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.oredict.OreDictionary;
import shift.sextiarysector.api.equipment.EquipmentType;
import shift.sextiarysector.player.EntityPlayerManager;
import shift.sextiarysector.player.EquipmentStats;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LoupeUnitEvent {

	private ArrayList<String> ores = new ArrayList<String>();

	@SubscribeEvent
	public void advancedTooltip(ItemTooltipEvent event) {
		EntityPlayer player = event.entityPlayer;
		ItemStack target = event.itemStack;
		boolean flag = false;

		if (player != null && player instanceof EntityPlayerSP && target != null) {
			// unit
			EquipmentStats e = EntityPlayerManager.getEquipmentStats(player);
			boolean hasUnit = false;

			for (int i = 0; i < EquipmentType.Unit.getSlots().length; i++) {
				ItemStack item = e.inventory.getStackInSlot(EquipmentType.Unit.getSlots()[i]);

				if (item == null || item.getItem() == null)
					continue;
				if (item.getItem() == AJPSS2Plugin.dicUnit) {
					hasUnit = true;
				}

			}

			if (hasUnit) {
				this.ores = this.getOre(target);
				event.toolTip.addAll(ores);
				flag = true;
			}
		}
	}

	@SideOnly(Side.CLIENT)
	private ArrayList<String> getOre(ItemStack item) {
		ArrayList<String> ore = new ArrayList<String>();

		int[] id = OreDictionary.getOreIDs(item);
		if (id != null && id.length > 0) {
			for (int i = 0; i < id.length; i++) {
				String s = OreDictionary.getOreName(id[i]);
				ore.add(s);
			}
		} else {
			ore.add("No ore dictionary name");
		}

		return ore;
	}

}
