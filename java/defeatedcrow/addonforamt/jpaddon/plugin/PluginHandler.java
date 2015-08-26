package defeatedcrow.addonforamt.jpaddon.plugin;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.Loader;
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
			fluidity = true;
			try {
				AJPFluidityPlugin.load();
			} catch (Exception e) {
				AJPLogger.failLoadingModInfo("FluidityDC");
				e.printStackTrace(System.err);
			}
		}

		if (Loader.isModLoaded("Schr0sCleaver")) {
			cleaver = true;
			try {
				AJPCleaverPlugin.load();
			} catch (Exception e) {
				AJPLogger.failLoadingModInfo("Schr0sCleaver");
				e.printStackTrace(System.err);
			}
		}
	}

	public static void loadPost() {

		if (Loader.isModLoaded("SextiarySector")) {
			ss2 = true;
			try {
				AJPSS2Plugin.load();
			} catch (Exception e) {
				AJPLogger.failLoadingModInfo("SextiarySector");
				e.printStackTrace(System.err);
			}
		}

		if (Loader.isModLoaded("BambooMod")) {
			bamboo = true;
			try {
				AJPBambooPlugin.load();
			} catch (Exception e) {
				AJPLogger.failLoadingModInfo("BambooMod");
				e.printStackTrace(System.err);
			}
		}

		if (Loader.isModLoaded("mod_ecru_MapleTree")) {
			maple = true;
			try {
				AJPMaplePlugin.load();
			} catch (Exception e) {
				AJPLogger.failLoadingModInfo("mod_ecru_MapleTree");
				e.printStackTrace(System.err);
			}
		}

		if (Loader.isModLoaded("Wa")) {
			wa = true;
			try {
				AJPWaPlugin.load();
			} catch (Exception e) {
				AJPLogger.failLoadingModInfo("Wa");
				e.printStackTrace(System.err);
			}
		}

		if (Loader.isModLoaded("TofuCraft")) {
			tofu = true;
			try {
				AJPTofuPlugin.load();
			} catch (Exception e) {
				AJPLogger.failLoadingModInfo("TofuCraft");
				e.printStackTrace(System.err);
			}
		}

		if (Loader.isModLoaded("jp-plusplus-ir2")) {
			ir2 = true;
			try {
				AJPIR2Plugin.load();
			} catch (Exception e) {
				AJPLogger.failLoadingModInfo("jp-plusplus-ir2");
				e.printStackTrace(System.err);
			}
		}

		if (Loader.isModLoaded("mceconomy2")) {
			mce = true;
			try {
				AJPMCEPlugin.load();
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

			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(AddonJPCore.linenBall, 1, 3), new Object[] {
					"XXX",
					"X X",
					"XXX",
					'X',
					new ItemStack(Items.string, 1, 0) }));
		}

		if (!ss2 && fluidity) {
			AJPFluidityPlugin.loadAlt();
		}
	}

}
