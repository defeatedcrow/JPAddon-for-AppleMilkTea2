package defeatedcrow.addonforamt.jpaddon.plugin.ss2;

import mods.defeatedcrow.common.DCsAppleMilk;
import mods.defeatedcrow.handler.Util;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import shift.sextiarysector.api.recipe.RecipeAPI;
import shift.sextiarysector.item.ItemUnit;
import shift.sextiarysector.recipe.FurnaceCraftingManager;
import cpw.mods.fml.common.registry.GameRegistry;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;

public class AJPSS2Plugin {

	public static Item iceUnit;
	public static Item antidoteUnit;
	public static Item dicUnit;
	public static Item qtUnit;
	public static Item unitBase;

	private AJPSS2Plugin() {
	}

	public static void load() {
		addUnit();
		addBasicRecipe();
		addMachineRecipe();
		MinecraftForge.EVENT_BUS.register(new AJPUnitEvent());
		MinecraftForge.EVENT_BUS.register(new LoupeUnitEvent());
		MinecraftForge.EVENT_BUS.register(new QTEvent());
	}

	public static void altRecipes() {

	}

	static void addUnit() {
		unitBase = new Item().setUnlocalizedName("addonamtjp.base_unit").setTextureName("amtjp:tools/ss2unit_base")
				.setCreativeTab(AddonJPCore.amtjpTab);
		GameRegistry.registerItem(unitBase, "addonamtjp.base_unit");

		iceUnit = new ItemUnit().setUnlocalizedName("addonamtjp.ice_unit").setTextureName("amtjp:tools/ss2unit_ice")
				.setCreativeTab(AddonJPCore.amtjpTab);
		GameRegistry.registerItem(iceUnit, "addonamtjp.ice_unit");

		antidoteUnit = new ItemUnit().setUnlocalizedName("addonamtjp.antidote_unit")
				.setTextureName("amtjp:tools/ss2unit_antidote").setCreativeTab(AddonJPCore.amtjpTab);
		GameRegistry.registerItem(antidoteUnit, "addonamtjp.antidote_unit");

		dicUnit = new ItemUnit().setUnlocalizedName("addonamtjp.dic_unit")
				.setTextureName("amtjp:tools/ss2unit_dictionary").setCreativeTab(AddonJPCore.amtjpTab);
		GameRegistry.registerItem(dicUnit, "addonamtjp.dic_unit");

		qtUnit = new ItemUnit().setUnlocalizedName("addonamtjp.qt_unit").setTextureName("amtjp:tools/ss2unit_qt")
				.setCreativeTab(AddonJPCore.amtjpTab);
		GameRegistry.registerItem(qtUnit, "addonamtjp.qt_unit");
	}

	static void addBasicRecipe() {
		Item item = Util.getModItem("SextiarySector", "Hammar");
		if (item != null) {
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.samue, 1, 0), new Object[] {
					new ItemStack(AddonJPCore.basicHaori[0], 1, 0),
					new ItemStack(item, 1, 0) }));
		}

		Item item2 = Util.getModItem("SextiarySector", "IronSpanner");
		if (item2 != null) {
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(AddonJPCore.samue, 1, 0), new Object[] {
					new ItemStack(AddonJPCore.basicHaori[0], 1, 0),
					new ItemStack(item2, 1, 0) }));
		}

	}

	static void addMachineRecipe() {
		// unit
		Item item = Util.getModItem("SextiarySector", "SteelGear");
		Item item2 = Util.getModItem("SextiarySector", "MagicDust");
		Item item3 = Util.getModItem("SextiarySector", "NinjaIngot");
		if (item != null && item2 != null && item3 != null) {
			FurnaceCraftingManager.getInstance().addRecipe(
					new ShapedOreRecipe(new ItemStack(unitBase, 1, 0), new Object[] {
							"XYX",
							"XZX",
							"XYX",
							'X',
							item3,
							'Y',
							item2,
							'Z',
							item }));
		}
		FurnaceCraftingManager.getInstance().addRecipe(
				new ShapelessOreRecipe(new ItemStack(iceUnit, 1, 0), new Object[] {
						new ItemStack(DCsAppleMilk.icyCrystal, 1, 0),
						new ItemStack(unitBase, 1, 0),
						"dustMithril" }));

		FurnaceCraftingManager.getInstance().addRecipe(
				new ShapelessOreRecipe(new ItemStack(antidoteUnit, 1, 0), new Object[] {
						new ItemStack(DCsAppleMilk.leafTea, 1, 1),
						new ItemStack(unitBase, 1, 0),
						"dustDiamond" }));

		FurnaceCraftingManager.getInstance().addRecipe(
				new ShapelessOreRecipe(new ItemStack(dicUnit, 1, 0), new Object[] {
						new ItemStack(DCsAppleMilk.monocle, 1, 32767),
						new ItemStack(unitBase, 1, 0),
						"dustDiamond" }));

		FurnaceCraftingManager.getInstance().addRecipe(
				new ShapelessOreRecipe(new ItemStack(qtUnit, 1, 0), new Object[] {
						new ItemStack(DCsAppleMilk.fossilScale, 1, 0),
						new ItemStack(unitBase, 1, 0),
						"dustMithril" }));

		// linen
		RecipeAPI.spinning_machine.add(new ItemStack(AddonJPCore.linenCont, 1, 0), new ItemStack(AddonJPCore.linenBall,
				1, 0));
		RecipeAPI.spinning_machine.add(new ItemStack(AddonJPCore.linenBall, 1, 2), new ItemStack(Items.lead));

		RecipeAPI.loom.add(new ItemStack(AddonJPCore.linenBall, 1, 2), new ItemStack(AddonJPCore.linenCloth, 1, 0));
		RecipeAPI.loom.add(new ItemStack(AddonJPCore.linenBall, 1, 3), new ItemStack(AddonJPCore.linenCloth, 1, 1));

	}

}
