package defeatedcrow.addonforamt.jpaddon.plugin;

import mods.defeatedcrow.api.recipe.RecipeRegisterManager;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;
import defeatedcrow.addonforamt.jpaddon.api.RecipeManagerJP;

public class AJPMaplePlugin {

	private AJPMaplePlugin() {
	}

	public static ItemStack kuri = null;
	public static ItemStack mayo = null;
	public static ItemStack moti = null;
	public static ItemStack maple = null;
	public static ItemStack surume = null;
	public static ItemStack azuki = null;
	public static ItemStack maple_leaves = null;

	public static void load() {
		advOreDic();
		addRecipes();
	}

	static void advOreDic() {
		Item item1 = GameRegistry.findItem("mod_ecru_MapleTree", "chestnut");
		if (item1 != null) {
			kuri = new ItemStack(item1, 1, 0);
			OreDictionary.registerOre("cropChestnut", kuri);
		}

		Item item2 = GameRegistry.findItem("mod_ecru_MapleTree", "mapleSyrup");
		if (item2 != null) {
			maple = new ItemStack(item2, 1, 0);
		}

		Item item3 = GameRegistry.findItem("mod_ecru_MapleTree", "foodstuff");
		if (item3 != null) {
			mayo = new ItemStack(item3, 1, 5);
			OreDictionary.registerOre("mayonnaise", mayo);
		}

		Item item4 = GameRegistry.findItem("mod_ecru_MapleTree", "foodsDish");
		if (item4 != null) {
			moti = new ItemStack(item4, 1, 3);
			surume = new ItemStack(item4, 1, 29);
		}

		Item item5 = GameRegistry.findItem("mod_ecru_MapleTree", "AzukiBeans");
		if (item5 != null) {
			azuki = new ItemStack(item5, 1, 0);
		}

		Block block1 = GameRegistry.findBlock("mod_ecru_MapleTree", "ecru_BlockMapleSapling");
		if (block1 != null) {
			maple_leaves = new ItemStack(block1, 1, 0);
		}
	}

	static void addRecipes() {

		if (moti != null) {
			RecipeRegisterManager.plateRecipe.register(moti, new ItemStack(AddonJPCore.jpDish, 1, 5), 80, false);
		}

		if (surume != null) {
			RecipeManagerJP.dryerRecipe.addRecipe(surume.copy(), 1, "rawSquid");
		}

		if (maple_leaves != null) {
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.advKimono[4], 1, 0), new Object[] {
					new ItemStack(AddonJPCore.hakama[0], 1, 0),
					maple_leaves.copy() }));
		}

		if (azuki != null) {
			RecipeRegisterManager.teaRecipe.register(azuki.copy(), new ItemStack(AddonJPCore.jpDrinks, 1, 5),
					"amtjp:textures/item/contents/contents_siruko");
		}

	}

}
