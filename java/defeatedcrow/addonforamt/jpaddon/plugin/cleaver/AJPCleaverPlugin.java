package defeatedcrow.addonforamt.jpaddon.plugin.cleaver;

import mods.defeatedcrow.common.DCsAppleMilk;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.ShapedOreRecipe;
import schr0.cleaver.api.ICleaverItem;
import cpw.mods.fml.common.registry.GameRegistry;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;

public class AJPCleaverPlugin {

	private AJPCleaverPlugin() {
	}

	public static Item windCleaver;
	public static Item nightCleaver;

	public static Item normalCleaver = null;

	// public static Item blazeCleaver = null;
	// public static Item soulCleaver = null;
	// public static Item ogreCleaver = null;

	public static void load() {

		normalCleaver = GameRegistry.findItem("Schr0sCleaver", "cleaverNormal");

		// new cleaver
		windCleaver = new ItemWindCleaver().setUnlocalizedName("addonamtjp.cleaver_wind").setCreativeTab(
				AddonJPCore.amtjpTab);
		GameRegistry.registerItem(windCleaver, "addonamtjp.cleaver_wind");

		nightCleaver = new ItemNightCleaver().setUnlocalizedName("addonamtjp.cleaver_night").setCreativeTab(
				AddonJPCore.amtjpTab);
		GameRegistry.registerItem(nightCleaver, "addonamtjp.cleaver_night");

		MinecraftForge.EVENT_BUS.register(new ItemNightCleaver());
		MinecraftForge.EVENT_BUS.register(new CleaverUpdateEvent());

		// recipe
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(windCleaver, 1, 0), new Object[] {
				"ZXZ",
				"XYX",
				"ZXZ",
				'X',
				new ItemStack(DCsAppleMilk.chalcedony, 1, 0),
				'Y',
				new ItemStack(normalCleaver, 1, 0),
				'Z',
				"gemDiamond" }));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(nightCleaver, 1, 0), new Object[] {
				"ZXZ",
				"XYX",
				"ZXZ",
				'X',
				new ItemStack(DCsAppleMilk.chalcedony, 1, 0),
				'Y',
				new ItemStack(normalCleaver, 1, 0),
				'Z',
				"ingotGold" }));

	}

	public static boolean isCleaver(ItemStack item) {
		boolean flag = false;
		if (item == null || item.getItem() == null)
			return false;

		if (item.getItem() instanceof ICleaverItem)
			flag = true;

		return flag;

	}

}
