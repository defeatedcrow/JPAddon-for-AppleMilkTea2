package defeatedcrow.addonforamt.jpaddon.recipe;

import mods.defeatedcrow.common.DCsAppleMilk;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;

public class OreRegisterJP {

	private OreRegisterJP() {
	}

	public static void load() {

		// grater
		OreDictionary.registerOre("toolGrater", new ItemStack(AddonJPCore.woodenGrater, 1, 32767));
		OreDictionary.registerOre("toolGrater", new ItemStack(AddonJPCore.diamondGrater, 1, 32767));

		// bottles
		for (int i = 0; i < 4; i++) {
			OreDictionary.registerOre("bottleSoySauce", new ItemStack(AddonJPCore.bottle, 1, 16 * i));
			OreDictionary.registerOre("bottleVinegar", new ItemStack(AddonJPCore.bottle, 1, 1 + 16 * i));
		}

		// salt
		OreDictionary.registerOre("dustSalt", new ItemStack(AddonJPCore.materials, 1, 2));
		OreDictionary.registerOre("foodSalt", new ItemStack(AddonJPCore.materials, 1, 2));
		OreDictionary.registerOre("salt", new ItemStack(AddonJPCore.materials, 1, 2));
		OreDictionary.registerOre("gemSalt", new ItemStack(AddonJPCore.gems, 1, 0));
		OreDictionary.registerOre("oreSalt", new ItemStack(AddonJPCore.ores, 1, 0));
		OreDictionary.registerOre("blockSalt", new ItemStack(AddonJPCore.gemBlocks, 1, 0));

		OreDictionary.registerOre("gemAlabaster", new ItemStack(AddonJPCore.gems, 1, 1));
		OreDictionary.registerOre("oreAlabaster", new ItemStack(AddonJPCore.ores, 1, 1));
		OreDictionary.registerOre("blockAlabaster", new ItemStack(AddonJPCore.gemBlocks, 1, 1));

		// materials
		OreDictionary.registerOre("cropSansho", new ItemStack(AddonJPCore.materials, 1, 3));
		OreDictionary.registerOre("foodSakekasu", new ItemStack(AddonJPCore.materials, 1, 4));
		OreDictionary.registerOre("foodSakeLees", new ItemStack(AddonJPCore.materials, 1, 4));
		OreDictionary.registerOre("foodKatuobushi", new ItemStack(AddonJPCore.materials, 1, 5));
		OreDictionary.registerOre("cropSpinach", new ItemStack(AddonJPCore.materials, 1, 6));
		OreDictionary.registerOre("cookingVegetable", new ItemStack(AddonJPCore.materials, 1, 6));
		OreDictionary.registerOre("foodMayonnaise", new ItemStack(AddonJPCore.materials, 1, 7));
		OreDictionary.registerOre("mayonnaise", new ItemStack(AddonJPCore.materials, 1, 7));
		OreDictionary.registerOre("mayonaise", new ItemStack(AddonJPCore.materials, 1, 7));
		OreDictionary.registerOre("cropStrawberry", new ItemStack(AddonJPCore.materials, 1, 8));
		OreDictionary.registerOre("strawberry", new ItemStack(AddonJPCore.materials, 1, 8));
		OreDictionary.registerOre("foodKansui", new ItemStack(AddonJPCore.materials, 1, 9));
		OreDictionary.registerOre("foodSquid", new ItemStack(AddonJPCore.fishes, 1, 2));
		OreDictionary.registerOre("foodEel", new ItemStack(AddonJPCore.fishes, 1, 1));
		OreDictionary.registerOre("foodCrab", new ItemStack(AddonJPCore.fishes, 1, 3));
		OreDictionary.registerOre("fishSquid", new ItemStack(AddonJPCore.fishes, 1, 2));
		OreDictionary.registerOre("fishEel", new ItemStack(AddonJPCore.fishes, 1, 1));
		OreDictionary.registerOre("fishCrab", new ItemStack(AddonJPCore.fishes, 1, 3));
		OreDictionary.registerOre("foodNoodle", new ItemStack(AddonJPCore.noodle, 1, 0));
		OreDictionary.registerOre("foodChineseNoodle", new ItemStack(AddonJPCore.noodle, 1, 1));

		// leaves
		OreDictionary.registerOre("foodSakuraTea", new ItemStack(AddonJPCore.teaLeaves, 1, 0));
		OreDictionary.registerOre("foodRoastedBarley", new ItemStack(AddonJPCore.teaLeaves, 1, 1));
		OreDictionary.registerOre("foodOolongTea", new ItemStack(AddonJPCore.teaLeaves, 1, 2));
		OreDictionary.registerOre("foodVanillaCoffee", new ItemStack(AddonJPCore.teaLeaves, 1, 3));

		// foods
		OreDictionary.registerOre("foodCheese", new ItemStack(AddonJPCore.noDish, 1, 1));
		OreDictionary.registerOre("cheese", new ItemStack(AddonJPCore.noDish, 1, 1));

		// linen
		OreDictionary.registerOre("itemCloth", new ItemStack(AddonJPCore.linenCloth, 1, 0));
		OreDictionary.registerOre("itemCloth", new ItemStack(AddonJPCore.linenCloth, 1, 1));
		OreDictionary.registerOre("itemLinenCloth", new ItemStack(AddonJPCore.linenCloth, 1, 0));
		OreDictionary.registerOre("itemCottonCloth", new ItemStack(AddonJPCore.linenCloth, 1, 1));
		OreDictionary.registerOre("itemString", new ItemStack(AddonJPCore.linenBall, 1, 0));
		OreDictionary.registerOre("itemString", new ItemStack(AddonJPCore.linenBall, 1, 1));

		// other
		OreDictionary.registerOre("cropPotato", new ItemStack(Items.potato, 1, 0));
		OreDictionary.registerOre("cropCarrot", new ItemStack(Items.carrot, 1, 0));

		OreDictionary.registerOre("dashi", new ItemStack(DCsAppleMilk.baseSoupBowl, 1, 3));

	}
}
