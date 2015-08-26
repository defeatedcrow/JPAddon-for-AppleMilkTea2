package defeatedcrow.addonforamt.jpaddon.plugin;

import mods.defeatedcrow.common.DCsAppleMilk;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import defeatedcrow.addonforamt.fluidity.recipe.IMCReceptor;

public class AJPFluidityPlugin {
	private AJPFluidityPlugin() {
	}

	public static void load() {
		// add replace table
		IMCReceptor.getReplaceTable().put(new ItemStack(Items.string), "itemString");
		IMCReceptor.getReplaceTable().put(new ItemStack(DCsAppleMilk.DCgrater), "toolGrater");
	}

	public static void loadAlt() {
		IMCReceptor.getReplaceTable().put(new ItemStack(Blocks.wool, 1, 32767), "itemCloth");
	}

}
