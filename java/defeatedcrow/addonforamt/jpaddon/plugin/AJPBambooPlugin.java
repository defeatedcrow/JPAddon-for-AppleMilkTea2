package defeatedcrow.addonforamt.jpaddon.plugin;

import mods.defeatedcrow.api.recipe.RecipeRegisterManager;
import mods.defeatedcrow.common.DCsAppleMilk;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import ruby.bamboo.BambooInit;
import cpw.mods.fml.common.registry.GameRegistry;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;

public class AJPBambooPlugin {
	private AJPBambooPlugin() {
	}

	public static void load() {
		addBasicRecipe();
		addMachineRecipe();
	}

	static void addBasicRecipe() {
		// grater
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.teaLeaves, 1, 0), new Object[] {
				"toolGrater",
				new ItemStack(DCsAppleMilk.foodTea, 1, 0),
				new ItemStack(BambooInit.sakuraleavs, 1, 32767) }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.minced, 1, 8), new Object[] {
				"toolGrater",
				new ItemStack(Items.fish, 1, 1),
				"cropCarrot",
				"cropRadish",
				"soybeans",
				new ItemStack(BambooInit.foods, 1, 36),
				"foodSakeLees" }));

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
						new ItemStack(BambooInit.sakuraleavs, 1, 32767) });

		RecipeRegisterManager.processorRecipe.addRecipe(new ItemStack(AddonJPCore.minced, 1, 9), true, null,
				new Object[] {
						new ItemStack(BambooInit.bambooShoot, 1, 0),
						"cropSansho",
						"bottleSoySauce",
						"foodKatuobushi",
						"foodSugar" });

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.advKimono[0], 1, 0), new Object[] {
				new ItemStack(AddonJPCore.hakama[0], 1, 0),
				new ItemStack(BambooInit.sakura, 1, 32767) }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.montukiHaori, 1, 0), new Object[] {
				new ItemStack(AddonJPCore.basicHaori[0], 1, 0),
				new ItemStack(BambooInit.katana, 1, 32767) }));

	}

	static void addMachineRecipe() {
		// amt
		RecipeRegisterManager.teaRecipe.register(new ItemStack(BambooInit.bean), new ItemStack(AddonJPCore.jpDrinks, 1,
				5), "amtjp:textures/items/contents/contents_sakura.png");
		// bamboo
	}

}
