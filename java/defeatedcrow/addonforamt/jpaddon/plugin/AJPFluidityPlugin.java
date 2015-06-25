package defeatedcrow.addonforamt.jpaddon.plugin;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import defeatedcrow.addonforamt.fluidity.recipe.IMCReceptor;

public class AJPFluidityPlugin {
	private AJPFluidityPlugin() {
	}

	public static void load() {
		// add replace table
		IMCReceptor.getReplaceTable().put(new ItemStack(Blocks.wool, 1, 32767), "craftingSmallCloth");
		IMCReceptor.getReplaceTable().put(new ItemStack(Items.string), "itemString");
	}

}
