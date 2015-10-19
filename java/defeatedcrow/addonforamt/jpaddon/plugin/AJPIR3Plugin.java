package defeatedcrow.addonforamt.jpaddon.plugin;

import jp.plusplus.ir2.api.IR3RecipeAPI;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;

public class AJPIR3Plugin {

	private AJPIR3Plugin() {
	}

	public static void load() {
		addOreDic();
		addRecipe();
	}

	static void addOreDic() {
		Item weed = GameRegistry.findItem("jp-plusplus-ir2", "waterweed");
		Item cheese = GameRegistry.findItem("jp-plusplus-ir2", "cheese");

		if (weed != null) {
			OreDictionary.registerOre("cropSeaweed", weed);
			OreDictionary.registerOre("foodSeaweed", weed);
		}

		if (cheese != null) {
			OreDictionary.registerOre("foodCheese", cheese);
			OreDictionary.registerOre("cheese", cheese);
		}
	}

	static void addRecipe() {
		IR3RecipeAPI.AddSpinning(new ItemStack(AddonJPCore.linenCont, 1), new ItemStack(AddonJPCore.linenBall, 1));
	}

}
