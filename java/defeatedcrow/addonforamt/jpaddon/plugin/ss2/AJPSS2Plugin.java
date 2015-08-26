package defeatedcrow.addonforamt.jpaddon.plugin.ss2;

import mods.defeatedcrow.common.DCsAppleMilk;
import mods.defeatedcrow.handler.Util;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import shift.sextiarysector.api.recipe.RecipeAPI;
import shift.sextiarysector.item.ItemUnit;
import shift.sextiarysector.recipe.FurnaceCraftingManager;
import cpw.mods.fml.common.registry.GameRegistry;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;

public class AJPSS2Plugin {

	public static Item iceUnit;
	public static Item antidoteUnit;
	public static Item iceRustUnit;
	public static Item antidoteRustUnit;

	private AJPSS2Plugin() {
	}

	public static void load() {
		addUnit();
		addBasicRecipe();
		addMachineRecipe();
		MinecraftForge.EVENT_BUS.register(new AJPUnitEvent());
	}

	public static void altRecipes() {

	}

	static void addUnit() {
		iceUnit = new ItemUnit().setUnlocalizedName("addonamtjp.ice_unit").setTextureName("amtjp:tools/ss2unit_ice")
				.setCreativeTab(AddonJPCore.amtjpTab);
		GameRegistry.registerItem(iceUnit, "addonamtjp.ice_unit");

		iceRustUnit = new ItemUnit().setUnlocalizedName("addonamtjp.ice_rust_unit")
				.setTextureName("amtjp:tools/ss2unit_rust_ice").setCreativeTab(AddonJPCore.amtjpTab);
		GameRegistry.registerItem(iceRustUnit, "addonamtjp.ice_rust_unit");

		antidoteUnit = new ItemUnit().setUnlocalizedName("addonamtjp.antidote_unit")
				.setTextureName("amtjp:tools/ss2unit_antidote").setCreativeTab(AddonJPCore.amtjpTab);
		GameRegistry.registerItem(antidoteUnit, "addonamtjp.antidote_unit");

		antidoteRustUnit = new ItemUnit().setUnlocalizedName("addonamtjp.antidote_rust_unit")
				.setTextureName("amtjp:tools/ss2unit_rust_antidote").setCreativeTab(AddonJPCore.amtjpTab);
		GameRegistry.registerItem(antidoteRustUnit, "addonamtjp.antidote_rust_unit");
	}

	static void addBasicRecipe() {
		Item item = Util.getModItem("SextiarySector", "Hammer");
		if (item != null) {
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.samue, 1, 0), new Object[] {
					new ItemStack(AddonJPCore.basicHaori[0], 1, 0),
					new ItemStack(item, 1, 0) }));
		}

	}

	static void addMachineRecipe() {
		// unit
		Item item = Util.getModItem("SextiarySector", "Unit");
		Item item2 = Util.getModItem("SextiarySector", "MagicDust");
		if (item != null && item2 != null) {
			FurnaceCraftingManager.getInstance().addShapelessRecipe(new ItemStack(iceRustUnit, 1, 0), new Object[] {
					new ItemStack(DCsAppleMilk.icyCrystal, 1, 0),
					new ItemStack(item2, 1, 0),
					new ItemStack(item, 1, 0) });

			FurnaceCraftingManager.getInstance().addShapelessRecipe(new ItemStack(antidoteRustUnit, 1, 0),
					new Object[] {
							new ItemStack(DCsAppleMilk.princessClam, 1, 0),
							new ItemStack(item2, 1, 0),
							new ItemStack(item, 1, 0) });
		}

		RecipeAPI.timeMachine.add(new ItemStack(iceRustUnit), new ItemStack(iceUnit));
		RecipeAPI.timeMachine.add(new ItemStack(antidoteRustUnit), new ItemStack(antidoteUnit));

		// linen
		RecipeAPI.spinning_machine.add(new ItemStack(AddonJPCore.linenCont, 1, 0), new ItemStack(AddonJPCore.linenBall,
				1, 0));
		RecipeAPI.spinning_machine.add(new ItemStack(AddonJPCore.linenBall, 1, 2), new ItemStack(Items.lead));

		RecipeAPI.loom.add(new ItemStack(AddonJPCore.linenBall, 1, 2), new ItemStack(AddonJPCore.linenCloth, 1, 0));
		RecipeAPI.loom.add(new ItemStack(AddonJPCore.linenBall, 1, 3), new ItemStack(AddonJPCore.linenCloth, 1, 1));

	}

}
