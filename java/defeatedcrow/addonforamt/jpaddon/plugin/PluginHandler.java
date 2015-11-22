package defeatedcrow.addonforamt.jpaddon.plugin;

import java.util.List;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.registry.GameRegistry;
import defeatedcrow.addonforamt.jpaddon.AJPLogger;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;
import defeatedcrow.addonforamt.jpaddon.plugin.cleaver.AJPCleaverPlugin;
import defeatedcrow.addonforamt.jpaddon.plugin.ss2.AJPSS2Plugin;

public class PluginHandler {
	private PluginHandler() {
	}

	public static boolean bamboo = false;
	public static boolean maple = false;
	public static boolean wa = false;
	public static boolean tofu = false;
	public static boolean ss2 = false;
	public static boolean ir2 = false;
	public static boolean mce = false;
	public static boolean fluidity = false;
	public static boolean cleaver = false;

	public static void loadPre() {

	}

	public static void loadInit() {

		if (Loader.isModLoaded("FluidityDC")) {
			try {
				AJPFluidityPlugin.load();
				AJPFluidityPlugin.loadAlt();
				fluidity = true;
			} catch (Exception e) {
				AJPLogger.failLoadingModInfo("FluidityDC");
				e.printStackTrace(System.err);
			}
		}

		if (Loader.isModLoaded("Schr0sCleaver")) {
			ModContainer mod = Loader.instance().getIndexedModList().get("Schr0sCleaver");
			String s = mod.getVersion();
			if (s.contains("ver2")) {
				try {
					AJPCleaverPlugin.load();
					cleaver = true;
				} catch (Exception e) {
					AJPLogger.failLoadingModInfo("Schr0sCleaver");
					e.printStackTrace(System.err);
				}
			}
		}
	}

	public static void loadPost() {

		if (Loader.isModLoaded("SextiarySector")) {
			try {
				AJPSS2Plugin.load();
				ss2 = true;
			} catch (Exception e) {
				AJPLogger.failLoadingModInfo("SextiarySector");
				e.printStackTrace(System.err);
			}
		}

		if (Loader.isModLoaded("BambooMod")) {
			try {
				AJPBambooPlugin.load();
				bamboo = true;
			} catch (Exception e) {
				AJPLogger.failLoadingModInfo("BambooMod");
				e.printStackTrace(System.err);
			}
		}

		if (Loader.isModLoaded("mod_ecru_MapleTree")) {
			try {
				AJPMaplePlugin.load();
				maple = true;
			} catch (Exception e) {
				AJPLogger.failLoadingModInfo("mod_ecru_MapleTree");
				e.printStackTrace(System.err);
			}
		}

		if (Loader.isModLoaded("Wa")) {
			try {
				AJPWaPlugin.load();
				wa = true;
			} catch (Exception e) {
				AJPLogger.failLoadingModInfo("Wa");
				e.printStackTrace(System.err);
			}
		}

		if (Loader.isModLoaded("TofuCraft")) {
			try {
				AJPTofuPlugin.load();
				tofu = true;
			} catch (Exception e) {
				AJPLogger.failLoadingModInfo("TofuCraft");
				e.printStackTrace(System.err);
			}
		}

		if (Loader.isModLoaded("jp-plusplus-ir2")) {
			try {
				AJPIR2Plugin.load();
				ir2 = true;
			} catch (Exception e) {
				AJPLogger.failLoadingModInfo("jp-plusplus-ir2");
				e.printStackTrace(System.err);
			}
		}

		if (Loader.isModLoaded("mceconomy2")) {
			try {
				AJPMCEPlugin.load();
				mce = true;
			} catch (Exception e) {
				AJPLogger.failLoadingModInfo("mceconomy2");
				e.printStackTrace(System.err);
			}
		}

		linenRecipe();
	}

	static void linenRecipe() {
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(AddonJPCore.linenBall, 1, 2), new Object[] {
				"XXX",
				"X X",
				"XXX",
				'X',
				new ItemStack(AddonJPCore.linenBall, 1, 0) }));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(AddonJPCore.linenBall, 1, 3), new Object[] {
				"XXX",
				"X X",
				"XXX",
				'X',
				new ItemStack(AddonJPCore.linenBall, 1, 1) }));

		if (!ss2 && !ir2) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(AddonJPCore.linenCloth, 1, 0), new Object[] {
					"XX",
					"XX",
					'X',
					new ItemStack(AddonJPCore.linenBall, 1, 2) }));

			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(AddonJPCore.linenCloth, 1, 1), new Object[] {
					"XX",
					"XX",
					'X',
					new ItemStack(AddonJPCore.linenBall, 1, 3) }));
		}

		List<ItemStack> cotton = OreDictionary.getOres("cropCotton");
		if (cotton == null || cotton.isEmpty()) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(AddonJPCore.linenBall, 1, 3), new Object[] {
					"XXX",
					"X X",
					"XXX",
					'X',
					new ItemStack(Items.string, 1, 0) }));
		}
	}

}
