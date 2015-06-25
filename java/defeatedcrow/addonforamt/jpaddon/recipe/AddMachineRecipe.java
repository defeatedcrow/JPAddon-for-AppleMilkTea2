package defeatedcrow.addonforamt.jpaddon.recipe;

import java.util.ArrayList;

import mods.defeatedcrow.api.recipe.RecipeRegisterManager;
import mods.defeatedcrow.common.DCsAppleMilk;
import mods.defeatedcrow.recipe.BrewingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;
import defeatedcrow.addonforamt.jpaddon.api.RecipeManagerJP;

public class AddMachineRecipe {

	private AddMachineRecipe() {
	}

	public static void addRecipe() {
		addTeaRecipe();
		addBrewRecipe();
		addPanRecipe();
		addTeppanRecipe();
		addEvaporatorRecipe();
		addDryerRecipe();
		addProcessorRecipe();
	}

	private static void addTeaRecipe() {
		RecipeRegisterManager.teaRecipe.register(new ItemStack(AddonJPCore.teaLeaves, 1, 0), new ItemStack(
				AddonJPCore.jpDrinks, 1, 0), "amtjp:textures/items/contents/contents_sakura.png");

		RecipeRegisterManager.teaRecipe.register(new ItemStack(AddonJPCore.teaLeaves, 1, 1), new ItemStack(
				AddonJPCore.jpDrinks, 1, 1), "amtjp:textures/items/contents/contents_mugicha.png");

		RecipeRegisterManager.teaRecipe.register(new ItemStack(AddonJPCore.teaLeaves, 1, 2), new ItemStack(
				AddonJPCore.jpDrinks, 1, 2), "amtjp:textures/items/contents/contents_oolong.png");

		RecipeRegisterManager.teaRecipe.register(new ItemStack(AddonJPCore.teaLeaves, 1, 3), new ItemStack(
				AddonJPCore.jpDrinks, 1, 3), "amtjp:textures/items/contents/contents_vanilla_coffee.png");

		RecipeRegisterManager.teaRecipe.register(new ItemStack(AddonJPCore.materials, 1, 4), new ItemStack(
				AddonJPCore.jpDrinks, 1, 4), "amtjp:textures/items/contents/contents_amazake.png");
	}

	private static void addPanRecipe() {
		RecipeRegisterManager.panRecipe.register(new ItemStack(AddonJPCore.minced, 1, 0), new ItemStack(
				AddonJPCore.jpBowls, 1, 0), new ItemStack(AddonJPCore.jpBowls_jp, 1, 0),
				"amtjp:textures/items/contents/contents_cabbagepork.png", "Cabbage and Pork");

		RecipeRegisterManager.panRecipe.register(new ItemStack(AddonJPCore.minced, 1, 2), new ItemStack(
				AddonJPCore.jpBowls, 1, 1), new ItemStack(AddonJPCore.jpBowls_jp, 1, 1),
				"amtjp:textures/items/contents/contents_kentin.png", "Kenchin Soup");

		RecipeRegisterManager.panRecipe.register(new ItemStack(AddonJPCore.minced, 1, 4), new ItemStack(
				AddonJPCore.jpBowls, 1, 2), new ItemStack(AddonJPCore.jpBowls_jp, 1, 2),
				"amtjp:textures/items/contents/contents_nasusoumen.png", "Nasu Soumen");

		RecipeRegisterManager.panRecipe.register(new ItemStack(AddonJPCore.minced, 1, 1), new ItemStack(
				AddonJPCore.riceBowls, 1, 0), new ItemStack(AddonJPCore.riceBowls_jp, 1, 0),
				"amtjp:textures/items/contents/contents_hamagurimesi.png", "Clam Rice");

		RecipeRegisterManager.panRecipe.register(new ItemStack(AddonJPCore.minced, 1, 3), new ItemStack(
				AddonJPCore.riceBowls, 1, 1), new ItemStack(AddonJPCore.riceBowls_jp, 1, 1),
				"amtjp:textures/items/contents/contents_kuriokowa.png", "Chestnut Rice");

		RecipeRegisterManager.panRecipe.register(new ItemStack(AddonJPCore.minced, 1, 5), new ItemStack(
				AddonJPCore.woodBowls, 1, 0), new ItemStack(AddonJPCore.woodBowls_jp, 1, 0),
				"amtjp:textures/items/contents/contents_nasutomato.png", "Ratatouille");

		RecipeRegisterManager.panRecipe.register(new ItemStack(AddonJPCore.minced, 1, 6), new ItemStack(
				AddonJPCore.woodBowls, 1, 1), new ItemStack(AddonJPCore.woodBowls_jp, 1, 1),
				"amtjp:textures/items/contents/contents_onionsoup.png", "Onion Soup");

		RecipeRegisterManager.panRecipe.register(new ItemStack(AddonJPCore.minced, 1, 7), new ItemStack(
				AddonJPCore.glassDish, 1, 2), new ItemStack(AddonJPCore.glassDish, 1, 2),
				"amtjp:textures/items/contents/contents_sigureni.png", "Sigure Beef");

		RecipeRegisterManager.panRecipe.register(new ItemStack(AddonJPCore.minced, 1, 8), new ItemStack(
				AddonJPCore.jpBowls, 1, 3), new ItemStack(AddonJPCore.jpBowls_jp, 1, 3),
				"amtjp:textures/items/contents/contents_simotukare.png", "Simotukare");

		RecipeRegisterManager.panRecipe.register(new ItemStack(AddonJPCore.minced, 1, 9), new ItemStack(
				AddonJPCore.glassDish, 1, 1), new ItemStack(AddonJPCore.glassDish, 1, 1),
				"amtjp:textures/items/contents/contents_takenoko.png", "Boiled Bambooshoot");

		RecipeRegisterManager.panRecipe.register(new ItemStack(AddonJPCore.minced, 1, 10), new ItemStack(
				AddonJPCore.woodBowls, 1, 2), new ItemStack(AddonJPCore.woodBowls_jp, 1, 2),
				"amtjp:textures/items/contents/contents_cornsoup.png", "Corn Soup");

	}

	private static void addTeppanRecipe() {

		RecipeRegisterManager.plateRecipe.register(new ItemStack(Items.wheat, 1, 0), new ItemStack(
				AddonJPCore.teaLeaves, 1, 1), 40, false);

		RecipeRegisterManager.plateRecipe.register(new ItemStack(AddonJPCore.materials, 1, 0), new ItemStack(
				AddonJPCore.squareDish, 1, 0), 120, false);

		RecipeRegisterManager.plateRecipe.register(new ItemStack(AddonJPCore.materials, 1, 1), new ItemStack(
				AddonJPCore.squareDish, 1, 1), 120, false);

		RecipeRegisterManager.plateRecipe.register(new ItemStack(AddonJPCore.dough, 1, 0), new ItemStack(
				AddonJPCore.jpDish, 1, 6), 120, true);

		RecipeRegisterManager.plateRecipe.register(new ItemStack(AddonJPCore.dough, 1, 1), new ItemStack(
				AddonJPCore.jpDish, 1, 2), 120, true);

		RecipeRegisterManager.plateRecipe.register(new ItemStack(AddonJPCore.dough, 1, 2), new ItemStack(
				AddonJPCore.jpDish, 1, 4), 120, true);

		ArrayList<ItemStack> rice = new ArrayList<ItemStack>();
		rice = OreDictionary.getOres("cookingRice");
		for (ItemStack item : rice) {
			if (item == null || item.getItem() == null)
				continue;
			RecipeRegisterManager.plateRecipe.register(item.copy(), new ItemStack(AddonJPCore.jpDish, 1, 5), 80, false);
		}

	}

	private static void addBrewRecipe() {
		BrewingRecipe.instance.registerRecipe(AddonJPCore.shoyu_young, AddonJPCore.shoyu);
		BrewingRecipe.instance.registerRecipe(AddonJPCore.komezu_young, AddonJPCore.komezu);
	}

	private static void addEvaporatorRecipe() {
		RecipeRegisterManager.evaporatorRecipe.addRecipe(new ItemStack(AddonJPCore.materials, 1, 4), new FluidStack(
				DCsAppleMilk.shothu_young, 100), new ItemStack(DCsAppleMilk.moromi, 1, 0), true);
	}

	private static void addDryerRecipe() {

		RecipeManagerJP.dryerRecipe.addRecipe(new ItemStack(AddonJPCore.materials, 1, 0), 1, Items.fish);

		RecipeManagerJP.dryerRecipe.addRecipe(new ItemStack(AddonJPCore.materials, 1, 2), 4, "bucketWater");

		RecipeManagerJP.dryerRecipe.addRecipe(new ItemStack(AddonJPCore.jpDish, 1, 3), 2, "cropSweetPotato");

		RecipeManagerJP.fermRecipe.addRecipe(new ItemStack(AddonJPCore.teaLeaves, 1, 2), 2, new ItemStack(
				DCsAppleMilk.foodTea, 1, 0));

		RecipeManagerJP.fermRecipe.addRecipe(new ItemStack(DCsAppleMilk.foodTea, 1, 1), 2, new ItemStack(
				AddonJPCore.teaLeaves, 1, 2));

		RecipeManagerJP.fermRecipe.addRecipe(new ItemStack(AddonJPCore.materials, 1, 5), 4, new ItemStack(Items.fish,
				1, 0));

		RecipeManagerJP.fermRecipe.addRecipe(new ItemStack(AddonJPCore.noDish, 1, 1), 4, "bucketMilk");

		RecipeManagerJP.fermRecipe.addRecipe(new ItemStack(AddonJPCore.materials, 1, 4), 2, new ItemStack(
				DCsAppleMilk.moromi, 1, 0));

		RecipeManagerJP.fermRecipe.addRecipe(new ItemStack(AddonJPCore.squareDish, 1, 2), 1, "cropEggplant");

		RecipeManagerJP.fermRecipe.addRecipe(new ItemStack(AddonJPCore.squareDish, 1, 2), 1, "eggplant");

		RecipeManagerJP.fermRecipe.addRecipe(new ItemStack(AddonJPCore.squareDish, 1, 2), 1, "cropRadish");

		RecipeManagerJP.fermRecipe.addRecipe(new ItemStack(AddonJPCore.squareDish, 1, 2), 1, "cropCucumber");

		RecipeManagerJP.fermRecipe.addRecipe(new ItemStack(AddonJPCore.squareDish, 1, 2), 1, new ItemStack(
				Blocks.melon_block, 1, 0));

		RecipeManagerJP.fermRecipe.addRecipe(new ItemStack(AddonJPCore.glassDish, 1, 4), 2, "rawSquid");
	}

	static void addProcessorRecipe() {
		RecipeRegisterManager.processorRecipe.addRecipe(new ItemStack(AddonJPCore.dough, 3, 0), true, null,
				new Object[] {
						new ItemStack(Items.dye, 1, 3),
						new ItemStack(Items.wheat, 1, 0),
						"cropApple",
						"bucketMilk" });

		RecipeRegisterManager.processorRecipe.addRecipe(new ItemStack(AddonJPCore.dough, 3, 1), true, null,
				new Object[] {
						new ItemStack(Items.wheat, 1, 0),
						new ItemStack(DCsAppleMilk.foodTea, 1, 0),
						"redbeans",
						"bucketMilk" });

		RecipeRegisterManager.processorRecipe.addRecipe(new ItemStack(AddonJPCore.dough, 3, 2), true, null,
				new Object[] {
						"foodSugar",
						new ItemStack(Items.wheat, 1, 0),
						"tofuKinu",
						"bucketSoymilk" });

		RecipeRegisterManager.processorRecipe.addRecipe(new ItemStack(AddonJPCore.minced, 1, 0), true, null,
				new Object[] {
						"foodSugar",
						new ItemStack(Items.porkchop, 1, 0),
						"cabbage" });

		RecipeRegisterManager.processorRecipe.addRecipe(new ItemStack(AddonJPCore.minced, 1, 1), true, null,
				new Object[] {
						"foodClam",
						"foodSeaweed",
						"bottleSoySauce" });

		RecipeRegisterManager.processorRecipe.addRecipe(new ItemStack(AddonJPCore.minced, 1, 2), true, null,
				new Object[] {
						"cropCarrot",
						"cropRadish",
						"cropSpinach",
						"tofuKinu",
						"bottleSoySauce" });

		RecipeRegisterManager.processorRecipe.addRecipe(new ItemStack(AddonJPCore.minced, 1, 2), true, null,
				new Object[] {
						"cropCarrot",
						"Radish",
						"cropSpinach",
						"tofuKinu",
						"bottleSoySauce" });

		RecipeRegisterManager.processorRecipe.addRecipe(new ItemStack(AddonJPCore.minced, 1, 3), true, null,
				new Object[] {
						"cropChestnut",
						"cropRice",
						"bottleSake",
						"foodKatuobushi" });

		RecipeRegisterManager.processorRecipe.addRecipe(new ItemStack(AddonJPCore.minced, 1, 3), true, null,
				new Object[] {
						"chestnut",
						"cropRice",
						"bottleSake",
						"foodKatuobushi" });

		RecipeRegisterManager.processorRecipe.addRecipe(new ItemStack(AddonJPCore.minced, 1, 4), true, null,
				new Object[] {
						"cropEggplant",
						"foodKatuobushi",
						"foodNoodle" });

		RecipeRegisterManager.processorRecipe.addRecipe(new ItemStack(AddonJPCore.minced, 1, 4), true, null,
				new Object[] {
						"eggplant",
						"foodKatuobushi",
						"foodNoodle" });

		RecipeRegisterManager.processorRecipe.addRecipe(new ItemStack(AddonJPCore.minced, 1, 4), true, null,
				new Object[] {
						"cropEggplant",
						"soupStock",
						"tofuSomen" });

		RecipeRegisterManager.processorRecipe.addRecipe(new ItemStack(AddonJPCore.minced, 1, 4), true, null,
				new Object[] {
						"eggplant",
						"soupStock",
						"tofuSomen" });

		RecipeRegisterManager.processorRecipe.addRecipe(new ItemStack(AddonJPCore.minced, 1, 5), true, null,
				new Object[] {
						"eggplant",
						"tomato",
						"onion",
						"cheese" });

		RecipeRegisterManager.processorRecipe.addRecipe(new ItemStack(AddonJPCore.minced, 1, 5), true, null,
				new Object[] {
						"cropEggplant",
						"cropTomato",
						"cropOnion",
						"cheese" });

		RecipeRegisterManager.processorRecipe.addRecipe(new ItemStack(AddonJPCore.minced, 1, 6), true, null,
				new Object[] {
						"foodSalt",
						"cropOnion",
						"cheese" });

		RecipeRegisterManager.processorRecipe.addRecipe(new ItemStack(AddonJPCore.minced, 1, 6), true, null,
				new Object[] {
						"foodSalt",
						"onion",
						"cheese" });

		RecipeRegisterManager.processorRecipe.addRecipe(new ItemStack(AddonJPCore.minced, 1, 7), true, null,
				new Object[] {
						new ItemStack(Items.beef),
						"cropSansho",
						"bottleSoySauce",
						"bottleSake",
						"foodSugar" });

		RecipeRegisterManager.processorRecipe.addRecipe(new ItemStack(AddonJPCore.minced, 1, 8), true, null,
				new Object[] {
						new ItemStack(Items.fish, 1, 1),
						"cropCarrot",
						"Radish",
						"soybeans",
						"foodOage",
						"foodSakeLees" });

		RecipeRegisterManager.processorRecipe.addRecipe(new ItemStack(AddonJPCore.minced, 1, 8), true, null,
				new Object[] {
						new ItemStack(Items.fish, 1, 1),
						"cropCarrot",
						"cropRadish",
						"soybeans",
						"foodOage",
						"foodSakeLees" });

		RecipeRegisterManager.processorRecipe.addRecipe(new ItemStack(AddonJPCore.minced, 1, 10), true, null,
				new Object[] {
						"cropCorn",
						"bucketMilk" });
	}

}
