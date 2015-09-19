package defeatedcrow.addonforamt.jpaddon.plugin;

import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class AJPIR3Plugin {

	private AJPIR3Plugin() {
	}

	public static void load() {
		addOreDic();
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

}
