package defeatedcrow.addonforamt.jpaddon.plugin;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import shift.mceconomy2.api.MCEconomyAPI;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;

public class AJPMCEPlugin {

	private AJPMCEPlugin() {
	}

	public static void load() {
		addPurchase();
	}

	static void addPurchase() {
		MCEconomyAPI.addPurchaseItem(new ItemStack(AddonJPCore.dryingRack, 1, 0), 80);
		MCEconomyAPI.addPurchaseItem(new ItemStack(AddonJPCore.linenCont, 1, 0), 1);
		for (int i = 0; i < 3; i++) {
			MCEconomyAPI.addPurchaseItem(new ItemStack(AddonJPCore.cardboardJP, 1, i), 2);
		}
		MCEconomyAPI.addPurchaseItem(new ItemStack(AddonJPCore.woodenGrater, 1, 32767), 5);
		MCEconomyAPI.addPurchaseItem(new ItemStack(AddonJPCore.diamondGrater, 1, 32767), 2000);

		MCEconomyAPI.addPurchaseItem(new ItemStack(AddonJPCore.materials, 1, 0), 3);
		MCEconomyAPI.addPurchaseItem(new ItemStack(AddonJPCore.materials, 1, 1), 10);
		MCEconomyAPI.addPurchaseItem(new ItemStack(AddonJPCore.materials, 1, 2), 2);
		MCEconomyAPI.addPurchaseItem(new ItemStack(AddonJPCore.materials, 1, 3), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(AddonJPCore.materials, 1, 4), 10);
		MCEconomyAPI.addPurchaseItem(new ItemStack(AddonJPCore.materials, 1, 5), 10);
		MCEconomyAPI.addPurchaseItem(new ItemStack(AddonJPCore.materials, 1, 6), 1);
		MCEconomyAPI.addPurchaseItem(new ItemStack(AddonJPCore.materials, 1, 7), 5);
		MCEconomyAPI.addPurchaseItem(new ItemStack(AddonJPCore.materials, 1, 8), 1);

		MCEconomyAPI.addPurchaseItem(new ItemStack(AddonJPCore.linenBall, 1, 0), 2);
		MCEconomyAPI.addPurchaseItem(new ItemStack(AddonJPCore.linenBall, 1, 1), 4);
		MCEconomyAPI.addPurchaseItem(new ItemStack(AddonJPCore.linenBall, 1, 2), 16);
		MCEconomyAPI.addPurchaseItem(new ItemStack(AddonJPCore.linenBall, 1, 3), 32);
		MCEconomyAPI.addPurchaseItem(new ItemStack(AddonJPCore.linenCloth, 1, 0), 25);
		MCEconomyAPI.addPurchaseItem(new ItemStack(AddonJPCore.linenCloth, 1, 1), 50);

		MCEconomyAPI.addPurchaseItem(new ItemStack(AddonJPCore.basicKimono[0], 1, 0), 250);
		MCEconomyAPI.addPurchaseItem(new ItemStack(AddonJPCore.basicKimono[1], 1, 0), 280);
		MCEconomyAPI.addPurchaseItem(new ItemStack(AddonJPCore.basicHaori[1], 1, 0), 250);
		MCEconomyAPI.addPurchaseItem(new ItemStack(AddonJPCore.basicHaori[1], 1, 0), 280);
		MCEconomyAPI.addPurchaseItem(new ItemStack(AddonJPCore.hakama[0], 1, 0), 500);
		MCEconomyAPI.addPurchaseItem(new ItemStack(AddonJPCore.hakama[1], 1, 0), 1200);
		MCEconomyAPI.addPurchaseItem(new ItemStack(AddonJPCore.samue, 1, 0), 800);
		MCEconomyAPI.addPurchaseItem(new ItemStack(AddonJPCore.tofuApron, 1, 0), 800);
		MCEconomyAPI.addPurchaseItem(new ItemStack(AddonJPCore.montukiHaori, 1, 0), 800);
		for (int i = 0; i < 5; i++) {
			MCEconomyAPI.addPurchaseItem(new ItemStack(AddonJPCore.advKimono[i], 1, 0), 800);
		}

	}

	public static void addMP(EntityPlayer player, int mp) {
		if (player != null) {
			if (mp > 0) {
				MCEconomyAPI.addPlayerMP(player, mp, false);
			}
		}
	}

}
