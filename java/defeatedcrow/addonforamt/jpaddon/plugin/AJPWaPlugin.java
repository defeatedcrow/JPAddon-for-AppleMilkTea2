package defeatedcrow.addonforamt.jpaddon.plugin;

import mods.defeatedcrow.api.recipe.RecipeRegisterManager;
import mods.defeatedcrow.common.DCsAppleMilk;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;

public class AJPWaPlugin {
	private AJPWaPlugin() {
	}

	public static void load() {
		addBasicRecipe();
	}

	static void addBasicRecipe() {
		Block sakuraSap = GameRegistry.findBlock("Wa", "sakuraSapling");
		Block sakuraLeaves = GameRegistry.findBlock("Wa", "sakuraLeaves");
		Block umeSap = GameRegistry.findBlock("Wa", "umeSapling");
		Block charm = GameRegistry.findBlock("Wa", "ofuda");
		Item katana = GameRegistry.findItem("Wa", "katana");
		Block takenoko = GameRegistry.findBlock("Wa", "takenoko");

		if (sakuraSap != null)
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.advKimono[0], 1, 0), new Object[] {
					new ItemStack(AddonJPCore.hakama[0], 1, 0),
					new ItemStack(sakuraSap, 1, 0) }));

		if (umeSap != null)
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.advKimono[1], 1, 0), new Object[] {
					new ItemStack(AddonJPCore.hakama[0], 1, 0),
					new ItemStack(umeSap, 1, 0) }));

		if (charm != null)
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.hakama[1], 1, 0), new Object[] {
					new ItemStack(AddonJPCore.hakama[0], 1, 0),
					new ItemStack(charm, 1, 0) }));

		if (katana != null)
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.montukiHaori, 1, 0), new Object[] {
					new ItemStack(AddonJPCore.basicHaori[0], 1, 0),
					new ItemStack(katana, 1, 32767) }));

		if (takenoko != null)
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.minced, 1, 9), new Object[] {
					"toolGrater",
					new ItemStack(takenoko, 1, 0),
					"cropSansho",
					"bottleSoySauce",
					"foodKatuobushi",
					"foodSugar" }));

		if (sakuraLeaves != null)
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.teaLeaves, 1, 0), new Object[] {
					"toolGrater",
					new ItemStack(DCsAppleMilk.foodTea, 1, 0),
					new ItemStack(sakuraLeaves, 1, 32767) }));

		if (sakuraLeaves != null)
			RecipeRegisterManager.processorRecipe.addRecipe(new ItemStack(AddonJPCore.teaLeaves, 1, 0), true, null,
					new Object[] {
							new ItemStack(DCsAppleMilk.foodTea, 1, 0),
							new ItemStack(sakuraLeaves, 1, 0) });

		if (takenoko != null)
			RecipeRegisterManager.processorRecipe.addRecipe(new ItemStack(AddonJPCore.minced, 1, 9), true, null,
					new Object[] {
							new ItemStack(takenoko, 1, 0),
							"cropSansho",
							"bottleSoySauce",
							"foodKatuobushi",
							"foodSugar" });
	}

}
