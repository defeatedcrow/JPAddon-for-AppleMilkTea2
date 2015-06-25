package defeatedcrow.addonforamt.jpaddon.plugin;

import mods.defeatedcrow.api.recipe.RecipeRegisterManager;
import mods.defeatedcrow.common.DCsAppleMilk;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import ruby.bamboo.BambooInit;
import wa.Items;
import wa.block.Blocks;
import cpw.mods.fml.common.registry.GameRegistry;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;

public class AJPWaPlugin {
	private AJPWaPlugin() {
	}

	public static void load() {
		addBasicRecipe();
	}

	static void addBasicRecipe() {
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.advKimono[0], 1, 0), new Object[] {
				new ItemStack(AddonJPCore.hakama[0], 1, 0),
				new ItemStack(Blocks.sakuraSapling, 1, 0) }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.advKimono[1], 1, 0), new Object[] {
				new ItemStack(AddonJPCore.hakama[0], 1, 0),
				new ItemStack(Blocks.umeSapling, 1, 0) }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.hakama[1], 1, 0), new Object[] {
				new ItemStack(AddonJPCore.hakama[0], 1, 0),
				new ItemStack(Blocks.charm, 1, 0) }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.montukiHaori, 1, 0), new Object[] {
				new ItemStack(AddonJPCore.basicHaori[0], 1, 0),
				new ItemStack(Items.刀, 1, 32767) }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.minced, 1, 9), new Object[] {
				"toolGrater",
				new ItemStack(BambooInit.bambooShoot, 1, 0),
				"cropSansho",
				"bottleSoySauce",
				"foodKatuobushi",
				"foodSugar" }));

		RecipeRegisterManager.processorRecipe.addRecipe(new ItemStack(AddonJPCore.teaLeaves, 1, 0), true, null,
				new Object[] {
						new ItemStack(DCsAppleMilk.foodTea, 1, 0),
						new ItemStack(Blocks.sakuraLeaves, 1, 0) });

		RecipeRegisterManager.processorRecipe.addRecipe(new ItemStack(AddonJPCore.minced, 1, 9), true, null,
				new Object[] {
						new ItemStack(Blocks.takenoko, 1, 0),
						"cropSansho",
						"bottleSoySauce",
						"foodKatuobushi",
						"foodSugar" });
	}

}
