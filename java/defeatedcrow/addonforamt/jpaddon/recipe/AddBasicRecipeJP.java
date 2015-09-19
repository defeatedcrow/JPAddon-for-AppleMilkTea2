package defeatedcrow.addonforamt.jpaddon.recipe;

import mods.defeatedcrow.common.DCsAppleMilk;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;

public class AddBasicRecipeJP {
	private AddBasicRecipeJP() {
	}

	public static void load() {
		addTools();
		addMaterials();
		addFoods();
		addKimono();
		addSmelting();
	}

	static void addTools() {

		// block
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(AddonJPCore.dryingRack, 1, 0), new Object[] {
				"YXY",
				"XZX",
				"YXY",
				'X',
				"plankWood",
				'Y',
				"stickWood",
				'Z',
				new ItemStack(AddonJPCore.linenBall, 1, 0) }));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(AddonJPCore.linenBall, 1, 0), new Object[] {
				"XXX",
				"XYX",
				"XXX",
				'X',
				new ItemStack(Blocks.tallgrass, 1, 1),
				'Y',
				"stickWood" }));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(AddonJPCore.linenBall, 1, 1), new Object[] {
				"XXX",
				"XYX",
				"XXX",
				'X',
				"cropCotton",
				'Y',
				"stickWood" }));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(AddonJPCore.woodenGrater, 1, 0), new Object[] {
				" X ",
				"XYX",
				"XYX",
				'X',
				"stickWood",
				'Y',
				"plankWood" }));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(AddonJPCore.diamondGrater, 1, 0), new Object[] {
				" X ",
				"XYX",
				"XYX",
				'X',
				"stickWood",
				'Y',
				"gemDiamond" }));

		// gems
		for (int i = 0; i < 2; i++) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(AddonJPCore.gemBlocks, 1, i), new Object[] {
					"XX",
					"XX",
					'X',
					new ItemStack(AddonJPCore.gems, 1, i) }));

			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(AddonJPCore.gemBlocks, 4, 2 + i), new Object[] {
					"XX",
					"XX",
					'X',
					new ItemStack(AddonJPCore.gemBlocks, 1, i) }));

			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(AddonJPCore.gemBlocks, 4, i), new Object[] {
					"XX",
					"XX",
					'X',
					new ItemStack(AddonJPCore.gemBlocks, 1, 2 + i) }));

			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(AddonJPCore.gems, 4, i), new Object[] {
					"X",
					'X',
					new ItemStack(AddonJPCore.gemBlocks, 1, i) }));

			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(AddonJPCore.gemHalf, 6, i), new Object[] {
					"XXX",
					'X',
					new ItemStack(AddonJPCore.gemBlocks, 1, i) }));

			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(AddonJPCore.gemHalf, 6, i + 2), new Object[] {
					"XXX",
					'X',
					new ItemStack(AddonJPCore.gemBlocks, 1, i + 2) }));
		}

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(AddonJPCore.saltStairs, 4, 0), new Object[] {
				"X  ",
				"XX ",
				"XXX",
				'X',
				new ItemStack(AddonJPCore.gemBlocks, 1, 0) }));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(AddonJPCore.alabasterStairs, 4, 0), new Object[] {
				"X  ",
				"XX ",
				"XXX",
				'X',
				new ItemStack(AddonJPCore.gemBlocks, 1, 1) }));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(AddonJPCore.alabasterLamp, 1, 0), new Object[] {
				" X ",
				"XYX",
				" X ",
				'X',
				"gemAlabaster",
				'Y',
				new ItemStack(Blocks.torch, 1, 0) }));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(AddonJPCore.alabasterChandelier, 1, 0), new Object[] {
				" X ",
				"XYX",
				" X ",
				'X',
				new ItemStack(AddonJPCore.alabasterLamp, 1, 0),
				'Y',
				"ingotIron" }));

		// container
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(AddonJPCore.linenCont, 1, 0), new Object[] {
				"XXX",
				"XXX",
				"XXX",
				'X',
				new ItemStack(Blocks.tallgrass, 1, 1) }));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(AddonJPCore.cardboardJP, 1, 0), new Object[] {
				"XXX",
				"XXX",
				"XXX",
				'X',
				"cropSansho" }));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(AddonJPCore.cardboardJP, 1, 1), new Object[] {
				"XXX",
				"XXX",
				"XXX",
				'X',
				"cropSpinach" }));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(AddonJPCore.cardboardJP, 1, 2), new Object[] {
				"XXX",
				"XXX",
				"XXX",
				'X',
				"cropStrawberry" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Blocks.tallgrass, 9, 1),
				new Object[] { new ItemStack(AddonJPCore.linenCont, 1, 0) }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.materials, 9, 3),
				new Object[] { new ItemStack(AddonJPCore.cardboardJP, 1, 0) }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.materials, 9, 6),
				new Object[] { new ItemStack(AddonJPCore.cardboardJP, 1, 1) }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.materials, 9, 8),
				new Object[] { new ItemStack(AddonJPCore.cardboardJP, 1, 2) }));
	}

	static void addMaterials() {
		// no grater foods
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.materials, 1, 1), new Object[] {
				new ItemStack(Items.fish, 1, 1),
				"foodSakeLees" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.materials, 1, 7), new Object[] {
				new ItemStack(Items.egg, 1, 0),
				"bottleVinegar",
				"bottleVegitableOil" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.materials, 1, 7), new Object[] {
				new ItemStack(Items.egg, 1, 0),
				"bottleVinegar",
				"rapeseedOil" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.materials, 1, 7), new Object[] {
				new ItemStack(Items.egg, 1, 0),
				"bottleVinegar",
				"soyOil" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.teaLeaves, 1, 3), new Object[] {
				"foodCoffee",
				"vanillaBeans" }));

		// grater
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.dough, 3, 0), new Object[] {
				"toolGrater",
				new ItemStack(Items.dye, 1, 3),
				new ItemStack(Items.wheat, 1, 0),
				"cropApple",
				"bucketMilk" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.dough, 3, 1), new Object[] {
				"toolGrater",
				new ItemStack(Items.wheat, 1, 0),
				new ItemStack(DCsAppleMilk.foodTea, 1, 0),
				"redbeans",
				"bucketMilk" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.dough, 3, 2), new Object[] {
				"toolGrater",
				"foodSugar",
				new ItemStack(Items.wheat, 1, 0),
				"tofuKinu",
				"bucketSoymilk" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.minced, 1, 0), new Object[] {
				"toolGrater",
				new ItemStack(Items.porkchop, 1, 0),
				"cabbage" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.minced, 1, 1), new Object[] {
				"toolGrater",
				"foodClam",
				"foodSeaweed",
				"bottleSoySauce" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.minced, 1, 2), new Object[] {
				"toolGrater",
				"cropCarrot",
				"cropRadish",
				"cropSpinach",
				"tofuKinu",
				"bottleSoySauce" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.minced, 1, 2), new Object[] {
				"toolGrater",
				"cropCarrot",
				"Radish",
				"cropSpinach",
				"tofuKinu",
				"bottleSoySauce" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.minced, 1, 3), new Object[] {
				"toolGrater",
				"cropChestnut",
				"cropRice",
				"bottleSake",
				"foodKatuobushi" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.minced, 1, 3), new Object[] {
				"toolGrater",
				"chestnut",
				"cropRice",
				"bottleSake",
				"foodKatuobushi" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.minced, 1, 4), new Object[] {
				"toolGrater",
				"cropEggplant",
				"foodKatuobushi",
				"foodNoodle" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.minced, 1, 4), new Object[] {
				"toolGrater",
				"eggplant",
				"foodKatuobushi",
				"foodNoodle" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.minced, 1, 4), new Object[] {
				"toolGrater",
				"cropEggplant",
				"soupStock",
				"tofuSomen" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.minced, 1, 4), new Object[] {
				"toolGrater",
				"eggplant",
				"soupStock",
				"tofuSomen" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.minced, 1, 5), new Object[] {
				"toolGrater",
				"eggplant",
				"tomato",
				"onion",
				"cheese" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.minced, 1, 5), new Object[] {
				"toolGrater",
				"cropEggplant",
				"cropTomato",
				"cropOnion",
				"cheese" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.minced, 1, 6), new Object[] {
				"toolGrater",
				"foodSalt",
				"cropOnion",
				"cheese" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.minced, 1, 6), new Object[] {
				"toolGrater",
				"foodSalt",
				"onion",
				"cheese" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.minced, 1, 7), new Object[] {
				"toolGrater",
				new ItemStack(Items.beef),
				"cropSansho",
				"bottleSoySauce",
				"bottleSake",
				"foodSugar" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.minced, 1, 8), new Object[] {
				"toolGrater",
				new ItemStack(Items.fish, 1, 1),
				"cropCarrot",
				"Radish",
				"soybeans",
				"foodOage",
				"foodSakeLees" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.minced, 1, 8), new Object[] {
				"toolGrater",
				new ItemStack(Items.fish, 1, 1),
				"cropCarrot",
				"cropRadish",
				"soybeans",
				"foodOage",
				"foodSakeLees" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.minced, 1, 10), new Object[] {
				"toolGrater",
				"cropCorn",
				"bucketMilk" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.minced, 1, 11), new Object[] {
				"toolGrater",
				"fishCrab",
				"miso",
				"cropLeek" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.noodle, 2, 0), new Object[] {
				"toolGrater",
				"foodDough" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.noodle, 2, 1), new Object[] {
				"toolGrater",
				"foodDough",
				"foodKansui" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.noodle, 2, 0), new Object[] {
				"toolGrater",
				Items.wheat,
				"dustSalt",
				"bucketWater" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.noodle, 2, 1), new Object[] {
				"toolGrater",
				Items.wheat,
				"dustSalt",
				"bucketWater",
				"foodKansui" }));

		// brewing material
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.fluidMaterials, 1, 0), new Object[] {
				"bucketWater",
				"soybeans",
				"foodYeast" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.fluidMaterials, 1, 0), new Object[] {
				"bucketWater",
				"soybeans",
				"kouji" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.fluidMaterials, 1, 1), new Object[] {
				new ItemStack(DCsAppleMilk.moromi, 1, 0),
				"foodYeast" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.fluidMaterials, 1, 1), new Object[] {
				new ItemStack(DCsAppleMilk.moromi, 1, 0),
				"bottleVinegar" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.materials, 2, 2), new Object[] {
				"toolGrater",
				"gemSalt" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.dye, 2, 15), new Object[] {
				"toolGrater",
				"gemAlabaster" }));

	}

	static void addFoods() {

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.noDish, 1, 0), new Object[] {
				"cookingRice",
				"bottleVinegar",
				new ItemStack(Items.fish, 1, 1) }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.noDish, 1, 2), new Object[] {
				"cropSpinach",
				"cropTomato",
				new ItemStack(Items.egg, 1, 0),
				"mayonnaise" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.noDish, 1, 2), new Object[] {
				"cropSpinach",
				"tomato",
				new ItemStack(Items.egg, 1, 0),
				"mayonnaise" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.glassDish, 1, 0), new Object[] {
				"cropCarrot",
				"cropRadish",
				"bottleVinegar",
				new ItemStack(Items.bowl, 1, 0) }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.glassDish, 1, 0), new Object[] {
				"cropCarrot",
				"Radish",
				"bottleVinegar",
				new ItemStack(Items.bowl, 1, 0) }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.glassDish, 1, 3), new Object[] {
				"cropSpinach",
				"foodKatuobushi",
				"bottleSoySauce",
				new ItemStack(Items.bowl, 1, 0) }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.glassDish, 1, 5), new Object[] {
				new ItemStack(Items.fish, 1, 0),
				"miso",
				new ItemStack(Items.bowl, 1, 0) }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.glassDish, 1, 6), new Object[] {
				"cropCarrot",
				"cropPotato",
				"mayonnaise" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.jpDish, 1, 0), new Object[] {
				new ItemStack(Items.wheat, 1, 0),
				"cropSweetPotato",
				"foodSugar" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.jpDish, 1, 1), new Object[] {
				"riceCake",
				"redbeans",
				new ItemStack(Blocks.tallgrass, 1, 1) }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.jpDish, 1, 1), new Object[] {
				"mochi",
				"AzukiBeans",
				new ItemStack(Blocks.tallgrass, 1, 1) }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.jpDish, 1, 7), new Object[] {
				"cookingRice",
				"cropStrawberry",
				"foodSugar" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.riceBowls_jp, 1, 2), new Object[] {
				"cookingRice",
				"mayonnaise" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.riceBowls_jp, 1, 3), new Object[] {
				"cookingRice",
				new ItemStack(AddonJPCore.squareDish, 1, 3) }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.woodBowls, 1, 3), new Object[] {
				"foodChineseNoodle",
				new ItemStack(DCsAppleMilk.baseSoupBowl, 1, 5),
				"dustSalt",
				"foodEgg",
				new ItemStack(Items.cooked_porkchop, 1, 0) }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.woodBowls, 1, 4), new Object[] {
				"foodChineseNoodle",
				new ItemStack(DCsAppleMilk.baseSoupBowl, 1, 4),
				"cropSpinach",
				"foodEgg",
				new ItemStack(Items.cooked_porkchop, 1, 0) }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.woodBowls, 1, 4), new Object[] {
				"foodChineseNoodle",
				new ItemStack(DCsAppleMilk.baseSoupBowl, 1, 4),
				"cropLeek",
				"foodEgg",
				new ItemStack(Items.cooked_porkchop, 1, 0) }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.squareDish, 1, 3), new Object[] {
				"cropSansho",
				"foodEel",
				"dustSugar",
				"bottleSoySauce" }));

	}

	static void addKimono() {
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(AddonJPCore.basicKimono[0], 1, 0), new Object[] {
				"X X",
				"XXX",
				"XXX",
				'X',
				new ItemStack(AddonJPCore.linenCloth, 1, 0) }));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(AddonJPCore.basicHaori[0], 1, 0), new Object[] {
				"XXX",
				"XXX",
				"X X",
				'X',
				new ItemStack(AddonJPCore.linenCloth, 1, 0) }));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(AddonJPCore.hakama[0], 1, 0), new Object[] {
				"X X",
				"XXX",
				"XXX",
				'X',
				"itemCottonCloth" }));

		// adv kimono

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.basicHaori[1], 1, 0), new Object[] {
				new ItemStack(AddonJPCore.basicHaori[0], 1, 0),
				"dyeBlue" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.basicKimono[1], 1, 0), new Object[] {
				new ItemStack(AddonJPCore.basicKimono[0], 1, 0),
				"dyeBlue" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.advKimono[3], 1, 0), new Object[] {
				new ItemStack(AddonJPCore.hakama[0], 1, 0),
				"bamboo" }));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.advKimono[2], 1, 0), new Object[] {
				new ItemStack(AddonJPCore.hakama[0], 1, 0),
				"gemClam" }));

	}

	static void addSmelting() {
		GameRegistry.addSmelting(new ItemStack(AddonJPCore.materials, 1, 0),
				new ItemStack(AddonJPCore.squareDish, 1, 0), 0.3F);

		GameRegistry.addSmelting(new ItemStack(AddonJPCore.materials, 1, 1),
				new ItemStack(AddonJPCore.squareDish, 1, 1), 0.3F);

		GameRegistry.addSmelting(new ItemStack(AddonJPCore.fishes, 1, 3), new ItemStack(AddonJPCore.squareDish, 1, 4),
				0.3F);

		GameRegistry.addSmelting(new ItemStack(AddonJPCore.dough, 1, 0), new ItemStack(AddonJPCore.jpDish, 1, 6), 0.3F);

		GameRegistry.addSmelting(new ItemStack(AddonJPCore.dough, 1, 1), new ItemStack(AddonJPCore.jpDish, 1, 2), 0.3F);

		GameRegistry.addSmelting(new ItemStack(AddonJPCore.dough, 1, 2), new ItemStack(AddonJPCore.jpDish, 1, 4), 0.3F);
	}

}
