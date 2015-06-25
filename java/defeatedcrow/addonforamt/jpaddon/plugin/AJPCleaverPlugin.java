package defeatedcrow.addonforamt.jpaddon.plugin;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class AJPCleaverPlugin {

	private AJPCleaverPlugin() {
	}

	public static Item normalCleaver = null;
	public static Item blazeCleaver = null;
	public static Item soulCleaver = null;
	public static Item ogreCleaver = null;

	public static void load() {
		normalCleaver = GameRegistry.findItem("Schr0sCleaver", "itemCleaverNormal");
		blazeCleaver = GameRegistry.findItem("Schr0sCleaver", "itemCleaverBlaze");
		soulCleaver = GameRegistry.findItem("Schr0sCleaver", "itemCleaverSoul");
		ogreCleaver = GameRegistry.findItem("Schr0sCleaver", "itemCleaverOgre");
	}

	public static boolean isCleaver(ItemStack item) {
		boolean flag = false;
		if (item == null || item.getItem() == null)
			return false;

		if (normalCleaver != null && item.getItem() == normalCleaver)
			flag = true;
		else if (blazeCleaver != null && item.getItem() == blazeCleaver)
			flag = true;
		else if (soulCleaver != null && item.getItem() == soulCleaver)
			flag = true;
		else if (ogreCleaver != null && item.getItem() == ogreCleaver)
			flag = true;

		return flag;

	}

}
