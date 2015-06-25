package defeatedcrow.addonforamt.jpaddon.recipe;

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

		// leaves
		OreDictionary.registerOre("foodSakuraTea", new ItemStack(AddonJPCore.teaLeaves, 1, 0));
		OreDictionary.registerOre("foodRoastedBarley", new ItemStack(AddonJPCore.teaLeaves, 1, 0));
		OreDictionary.registerOre("foodOolongTea", new ItemStack(AddonJPCore.teaLeaves, 1, 0));
		OreDictionary.registerOre("foodVanillaCoffee", new ItemStack(AddonJPCore.teaLeaves, 1, 0));

		// foods
		OreDictionary.registerOre("foodCheese", new ItemStack(AddonJPCore.noDish, 1, 1));
		OreDictionary.registerOre("cheese", new ItemStack(AddonJPCore.noDish, 1, 1));

		// linen
		OreDictionary.registerOre("craftingSmallCloth", new ItemStack(AddonJPCore.linenCloth, 1, 0));
		OreDictionary.registerOre("craftingSmallCloth", new ItemStack(AddonJPCore.linenCloth, 1, 1));
		OreDictionary.registerOre("craftingCloth", new ItemStack(AddonJPCore.linenCloth, 1, 1));
		OreDictionary.registerOre("blockCloth", new ItemStack(AddonJPCore.linenCloth, 1, 0));
		OreDictionary.registerOre("blockCloth", new ItemStack(AddonJPCore.linenCloth, 1, 1));
		OreDictionary.registerOre("itemString", new ItemStack(AddonJPCore.linenBall, 1, 0));
		OreDictionary.registerOre("itemString", new ItemStack(AddonJPCore.linenBall, 1, 1));

		// other
		OreDictionary.registerOre("cropPotato", new ItemStack(Items.potato, 1, 0));
		OreDictionary.registerOre("cropCarrot", new ItemStack(Items.carrot, 1, 0));

	}
}
