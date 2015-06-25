package defeatedcrow.addonforamt.jpaddon.plugin;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import tsuteto.tofu.init.TcItems;
import cpw.mods.fml.common.registry.GameRegistry;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;

public class AJPTofuPlugin {

	public static final AJPTofuPlugin instance = new AJPTofuPlugin();

	private AJPTofuPlugin() {
	}

	public static void load() {
		addBasicRecipe();
		MinecraftForge.EVENT_BUS.register(new FallKinuEvent());
	}

	static void addBasicRecipe() {
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(TcItems.dashi, 1, 0), new Object[] {
				"bucketWater",
				"foodKatuobushi",
				new ItemStack(Items.glass_bottle, 1, 0) }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.tofuApron, 1, 0), new Object[] {
				new ItemStack(AddonJPCore.basicHaori[0], 1, 0),
				new ItemStack(TcItems.bugle, 1, 0) }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.hakama[1], 1, 0), new Object[] {
				new ItemStack(AddonJPCore.hakama[0], 1, 0),
				"morijio" }));
	}

}
