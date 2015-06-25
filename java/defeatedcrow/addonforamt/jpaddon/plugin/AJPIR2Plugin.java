package defeatedcrow.addonforamt.jpaddon.plugin;

import jp.plusplus.ir2.Recipes;
import jp.plusplus.ir2.items.ItemCore;
import mods.defeatedcrow.common.DCsAppleMilk;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;

public class AJPIR2Plugin {

	private AJPIR2Plugin() {
	}

	public static void load() {
		addBasicRecipe();
		addMachineRecipe();
	}

	static void addBasicRecipe() {
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.samue, 1, 0), new Object[] {
				new ItemStack(AddonJPCore.basicHaori[0], 1, 0),
				new ItemStack(ItemCore.wrench, 1, 0) }));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(AddonJPCore.linenBall, 1, 1), new Object[] {
				"XXX",
				"XYX",
				"XXX",
				'X',
				new ItemStack(ItemCore.cottonRaw, 1, 0),
				'Y',
				"stickWood" }));

	}

	static void addMachineRecipe() {
		// spinning
		Recipes.addWeaving(new ItemStack(AddonJPCore.linenBall, 1, 2), new ItemStack(AddonJPCore.linenCloth, 1, 0));
		Recipes.addWeaving(new ItemStack(AddonJPCore.linenBall, 1, 3), new ItemStack(AddonJPCore.linenCloth, 1, 1));

		Recipes.addFishingSea(new ItemStack(DCsAppleMilk.princessClam, 1, 0), 125);
		Recipes.addFishingSea(new ItemStack(DCsAppleMilk.fossilScale, 1, 0), 125);

	}

}
