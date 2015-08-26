package defeatedcrow.addonforamt.jpaddon.event;

import java.util.ArrayList;

import mods.defeatedcrow.common.DCsAppleMilk;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.FakePlayer;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;

public class AJPCraftingEvent {

	@SubscribeEvent
	public void onCraftingEvent(PlayerEvent.ItemCraftedEvent event) {

		EntityPlayer player = event.player;
		IInventory craftMatrix = event.craftMatrix;
		ItemStack crafting = event.crafting;

		ArrayList<ItemStack> rets = new ArrayList<ItemStack>();

		for (int i = 0; i < craftMatrix.getSizeInventory(); i++) {
			ItemStack m = craftMatrix.getStackInSlot(i);

			if (m != null && m.getItem() == AddonJPCore.bottle) {
				int type = m.getItemDamage() & 15;
				int rem = (m.getItemDamage() >> 4) & 7;
				rem--;
				if (rem < 0) {
					rets.add(new ItemStack(DCsAppleMilk.emptyBottle, 1, 0));
				} else {
					int next = (rem << 4) + type;
					rets.add(new ItemStack(AddonJPCore.bottle, 1, next));
				}
			}
		}
		if (!rets.isEmpty()) {
			for (ItemStack ret : rets) {
				if (player != null && !(player instanceof FakePlayer) && !player.inventory.addItemStackToInventory(ret)) {
					player.entityDropItem(ret, 1);
				}
			}
		}
	}

}
