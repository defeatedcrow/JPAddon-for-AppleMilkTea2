package defeatedcrow.addonforamt.jpaddon;

import mods.defeatedcrow.common.DCsAppleMilk;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import defeatedcrow.addonforamt.jpaddon.common.block.BlockCardboardJP;
import defeatedcrow.addonforamt.jpaddon.common.block.BlockDryingRack;
import defeatedcrow.addonforamt.jpaddon.common.block.BlockLinenContainer;
import defeatedcrow.addonforamt.jpaddon.common.block.ItemCardboardJP;
import defeatedcrow.addonforamt.jpaddon.common.fluid.BlockDummyFluidJP;
import defeatedcrow.addonforamt.jpaddon.common.fluid.ItemDummyFluidJP;
import defeatedcrow.addonforamt.jpaddon.common.item.ItemAdvGrater;
import defeatedcrow.addonforamt.jpaddon.common.item.ItemBottles;
import defeatedcrow.addonforamt.jpaddon.common.item.ItemDough;
import defeatedcrow.addonforamt.jpaddon.common.item.ItemFluidMaterials;
import defeatedcrow.addonforamt.jpaddon.common.item.ItemLinenBall;
import defeatedcrow.addonforamt.jpaddon.common.item.ItemLinenCloth;
import defeatedcrow.addonforamt.jpaddon.common.item.ItemMaterials;
import defeatedcrow.addonforamt.jpaddon.common.item.ItemMincedJP;
import defeatedcrow.addonforamt.jpaddon.common.item.ItemTeaLeaves;
import defeatedcrow.addonforamt.jpaddon.common.item.armor.ArmorKimonoBase;
import defeatedcrow.addonforamt.jpaddon.common.item.foods.ItemGlassBowls;
import defeatedcrow.addonforamt.jpaddon.common.item.foods.ItemJPBowls;
import defeatedcrow.addonforamt.jpaddon.common.item.foods.ItemJPBowls_JP;
import defeatedcrow.addonforamt.jpaddon.common.item.foods.ItemJPDish;
import defeatedcrow.addonforamt.jpaddon.common.item.foods.ItemJPDrinks;
import defeatedcrow.addonforamt.jpaddon.common.item.foods.ItemNoDish;
import defeatedcrow.addonforamt.jpaddon.common.item.foods.ItemRiceBowls;
import defeatedcrow.addonforamt.jpaddon.common.item.foods.ItemRiceBowls_JP;
import defeatedcrow.addonforamt.jpaddon.common.item.foods.ItemSquareDish;
import defeatedcrow.addonforamt.jpaddon.common.item.foods.ItemWoodBowls;
import defeatedcrow.addonforamt.jpaddon.common.item.foods.ItemWoodBowls_JP;
import defeatedcrow.addonforamt.jpaddon.util.PotionJPLuck;

public class Materials {

	private static Fluid registerShoyuYoung;
	private static Fluid registerShoyu;
	private static Fluid registerKomezuYoung;
	private static Fluid registerKomezu;

	private Materials() {
	}

	public static void addItems() {

		/* tools */

		AddonJPCore.woodenGrater = new ItemAdvGrater(16, "grater_wooden")
				.setUnlocalizedName("addonamtjp.grater_wooden").setCreativeTab(AddonJPCore.amtjpTab);
		GameRegistry.registerItem(AddonJPCore.woodenGrater, "addonamtjp.grater_wooden");

		AddonJPCore.diamondGrater = new ItemAdvGrater(1024, "grater_diamond").setUnlocalizedName(
				"addonamtjp.grater_diamond").setCreativeTab(AddonJPCore.amtjpTab);
		GameRegistry.registerItem(AddonJPCore.diamondGrater, "addonamtjp.grater_diamond");

		/* materials */

		AddonJPCore.materials = new ItemMaterials().setUnlocalizedName("addonamtjp.materials").setCreativeTab(
				AddonJPCore.amtjpTab);
		GameRegistry.registerItem(AddonJPCore.materials, "addonamtjp.materials");

		AddonJPCore.teaLeaves = new ItemTeaLeaves().setUnlocalizedName("addonamtjp.tealeaves").setCreativeTab(
				AddonJPCore.amtjpTab);
		GameRegistry.registerItem(AddonJPCore.teaLeaves, "addonamtjp.tealeaves");

		AddonJPCore.dough = new ItemDough().setUnlocalizedName("addonamtjp.dough").setCreativeTab(AddonJPCore.amtjpTab);
		GameRegistry.registerItem(AddonJPCore.dough, "addonamtjp.dough");

		AddonJPCore.minced = new ItemMincedJP().setUnlocalizedName("addonamtjp.mincedfoods").setCreativeTab(
				AddonJPCore.amtjpTab);
		GameRegistry.registerItem(AddonJPCore.minced, "addonamtjp.mincedfoods");

		AddonJPCore.fluidMaterials = new ItemFluidMaterials().setUnlocalizedName("addonamtjp.fluid_materials")
				.setCreativeTab(AddonJPCore.amtjpTab);
		GameRegistry.registerItem(AddonJPCore.fluidMaterials, "addonamtjp.fluid_materials");

		AddonJPCore.bottle = new ItemBottles().setUnlocalizedName("addonamtjp.bottle").setCreativeTab(
				AddonJPCore.amtjpTab);
		GameRegistry.registerItem(AddonJPCore.bottle, "addonamtjp.bottle");

		AddonJPCore.linenBall = new ItemLinenBall().setUnlocalizedName("addonamtjp.linen_ball").setCreativeTab(
				AddonJPCore.amtjpTab);
		GameRegistry.registerItem(AddonJPCore.linenBall, "addonamtjp.linen_ball");

		AddonJPCore.linenCloth = new ItemLinenCloth().setUnlocalizedName("addonamtjp.linen_cloth").setCreativeTab(
				AddonJPCore.amtjpTab);
		GameRegistry.registerItem(AddonJPCore.linenCloth, "addonamtjp.linen_cloth");

		/* foods */

		AddonJPCore.jpDrinks = new ItemJPDrinks().setUnlocalizedName("addonamtjp.drink_jp").setCreativeTab(
				AddonJPCore.amtjpTab);
		GameRegistry.registerItem(AddonJPCore.jpDrinks, "addonamtjp.drink_jp");

		AddonJPCore.noDish = new ItemNoDish().setUnlocalizedName("addonamtjp.dish_non").setCreativeTab(
				AddonJPCore.amtjpTab);
		GameRegistry.registerItem(AddonJPCore.noDish, "addonamtjp.dish_non");

		AddonJPCore.squareDish = new ItemSquareDish().setUnlocalizedName("addonamtjp.dish_square").setCreativeTab(
				AddonJPCore.amtjpTab);
		GameRegistry.registerItem(AddonJPCore.squareDish, "addonamtjp.dish_square");

		AddonJPCore.glassDish = new ItemGlassBowls().setUnlocalizedName("addonamtjp.dish_glass").setCreativeTab(
				AddonJPCore.amtjpTab);
		GameRegistry.registerItem(AddonJPCore.glassDish, "addonamtjp.dish_glass");

		AddonJPCore.jpDish = new ItemJPDish().setUnlocalizedName("addonamtjp.dish_jp").setCreativeTab(
				AddonJPCore.amtjpTab);
		GameRegistry.registerItem(AddonJPCore.jpDish, "addonamtjp.dish_jp");

		AddonJPCore.riceBowls = new ItemRiceBowls().setUnlocalizedName("addonamtjp.bowl_rice").setCreativeTab(
				AddonJPCore.amtjpTab);
		GameRegistry.registerItem(AddonJPCore.riceBowls, "addonamtjp.bowl_rice");

		AddonJPCore.jpBowls = new ItemJPBowls().setUnlocalizedName("addonamtjp.bowl_jp").setCreativeTab(
				AddonJPCore.amtjpTab);
		GameRegistry.registerItem(AddonJPCore.jpBowls, "addonamtjp.bowl_jp");

		AddonJPCore.woodBowls = new ItemWoodBowls().setUnlocalizedName("addonamtjp.bowl_wood").setCreativeTab(
				AddonJPCore.amtjpTab);
		GameRegistry.registerItem(AddonJPCore.woodBowls, "addonamtjp.bowl_wood");

		// bamboo
		AddonJPCore.riceBowls_jp = new ItemRiceBowls_JP().setUnlocalizedName("addonamtjp.bowl_rice_bamboo")
				.setCreativeTab(AddonJPCore.amtjpTab);
		GameRegistry.registerItem(AddonJPCore.riceBowls_jp, "addonamtjp.bowl_rice_bamboo");

		AddonJPCore.jpBowls_jp = new ItemJPBowls_JP().setUnlocalizedName("addonamtjp.bowl_jp_bamboo").setCreativeTab(
				AddonJPCore.amtjpTab);
		GameRegistry.registerItem(AddonJPCore.jpBowls_jp, "addonamtjp.bowl_jp_bamboo");

		AddonJPCore.woodBowls_jp = new ItemWoodBowls_JP().setUnlocalizedName("addonamtjp.bowl_wood_bamboo")
				.setCreativeTab(AddonJPCore.amtjpTab);
		GameRegistry.registerItem(AddonJPCore.woodBowls_jp, "addonamtjp.bowl_wood_bamboo");

		// kimono
		AddonJPCore.basicKimono = new Item[2];
		AddonJPCore.hakama = new Item[2];
		AddonJPCore.basicHaori = new Item[2];
		String[] hitoe = {
				"linen",
				"indigo" };
		String[] hakama = {
				"black",
				"miko" };
		for (int i = 0; i < 2; i++) {
			AddonJPCore.basicKimono[i] = (new ArmorKimonoBase(AddonJPCore.materialAJPLinen,
					AddonJPCore.proxy.addArmor("amtjp.kimono"), 2, 0, "hitoe_" + hitoe[i])).setUnlocalizedName(
					"addonamtjp.basic_hitoe_" + hitoe[i]).setCreativeTab(AddonJPCore.amtjpTab);
			GameRegistry.registerItem(AddonJPCore.basicKimono[i], "addonamtjp.basic_hitoe_" + hitoe[i]);

			AddonJPCore.basicHaori[i] = (new ArmorKimonoBase(AddonJPCore.materialAJPLinen,
					AddonJPCore.proxy.addArmor("amtjp.haori"), 1, 1, "haori_" + hitoe[i])).setUnlocalizedName(
					"addonamtjp.basic_haori_" + hitoe[i]).setCreativeTab(AddonJPCore.amtjpTab);
			GameRegistry.registerItem(AddonJPCore.basicHaori[i], "addonamtjp.basic_haori_" + hitoe[i]);

			AddonJPCore.hakama[i] = (new ArmorKimonoBase(AddonJPCore.materialAJPLinen,
					AddonJPCore.proxy.addArmor("amtjp.kimono"), 2, 0, "hakama_" + hakama[i])).setUnlocalizedName(
					"addonamtjp.hakama_" + hakama[i]).setCreativeTab(AddonJPCore.amtjpTab);
			GameRegistry.registerItem(AddonJPCore.hakama[i], "addonamtjp.hakama_" + hakama[i]);
		}

		AddonJPCore.tofuApron = (new ArmorKimonoBase(AddonJPCore.materialAJPLinen,
				AddonJPCore.proxy.addArmor("amtjp.apron_tofu"), 2, 0, "apron_tofu")).setUnlocalizedName(
				"addonamtjp.apron_tofu").setCreativeTab(AddonJPCore.amtjpTab);
		GameRegistry.registerItem(AddonJPCore.tofuApron, "addonamtjp.apron_tofu");

		AddonJPCore.samue = (new ArmorKimonoBase(AddonJPCore.materialAJPLinen,
				AddonJPCore.proxy.addArmor("amtjp.samue_indigo"), 2, 0, "samue_indigo")).setUnlocalizedName(
				"addonamtjp.samue_indigo").setCreativeTab(AddonJPCore.amtjpTab);
		GameRegistry.registerItem(AddonJPCore.samue, "addonamtjp.samue_indigo");

		AddonJPCore.montukiHaori = (new ArmorKimonoBase(AddonJPCore.materialAJPLinen,
				AddonJPCore.proxy.addArmor("amtjp.haori_montuki"), 1, 1, "haori_montuki")).setUnlocalizedName(
				"addonamtjp.haori_montuki").setCreativeTab(AddonJPCore.amtjpTab);
		GameRegistry.registerItem(AddonJPCore.montukiHaori, "addonamtjp.haori_montuki");

		AddonJPCore.advKimono = new Item[5];
		String[] kimono = {
				"sakura",
				"kanbai",
				"sea",
				"take",
				"momiji" };
		for (int i = 0; i < 5; i++) {
			AddonJPCore.advKimono[i] = (new ArmorKimonoBase(AddonJPCore.materialAJPLinen,
					AddonJPCore.proxy.addArmor("amtjp.kimono"), 2, 0, "kimono_" + kimono[i])).setUnlocalizedName(
					"addonamtjp.kimono_" + kimono[i]).setCreativeTab(AddonJPCore.amtjpTab);
			GameRegistry.registerItem(AddonJPCore.advKimono[i], "addonamtjp.kimono_" + kimono[i]);
		}

	}

	public static void addBlocks() {

		AddonJPCore.dryingRack = new BlockDryingRack().setBlockName("addonamtjp.drying_rack").setCreativeTab(
				AddonJPCore.amtjpTab);
		GameRegistry.registerBlock(AddonJPCore.dryingRack, "addonamtjp.drying_rack");

		AddonJPCore.linenCont = new BlockLinenContainer().setBlockName("addonamtjp.container_linen").setCreativeTab(
				AddonJPCore.amtjpTab);
		GameRegistry.registerBlock(AddonJPCore.linenCont, "addonamtjp.container_linen");

		AddonJPCore.cardboardJP = new BlockCardboardJP().setBlockName("addonamtjp.cardboard_jp").setCreativeTab(
				AddonJPCore.amtjpTab);
		GameRegistry.registerBlock(AddonJPCore.cardboardJP, ItemCardboardJP.class, "addonamtjp.cardboard_jp");

	}

	public static void addFluid() {

		AddonJPCore.fluidDummy = (new BlockDummyFluidJP()).setBlockName("amtjp.fluid_block");
		GameRegistry.registerBlock(AddonJPCore.fluidDummy, ItemDummyFluidJP.class, "amtjp.fluid_block");

		registerShoyuYoung = new Fluid("amtjp.shoyu_young").setDensity(1000).setViscosity(1000);
		FluidRegistry.registerFluid(registerShoyuYoung);
		AddonJPCore.shoyu_young = FluidRegistry.getFluid("amtjp.shoyu_young");

		registerKomezuYoung = new Fluid("amtjp.komezu_young").setDensity(1000).setViscosity(1000);
		FluidRegistry.registerFluid(registerKomezuYoung);
		AddonJPCore.komezu_young = FluidRegistry.getFluid("amtjp.komezu_young");

		registerShoyu = new Fluid("amtjp.shoyu").setDensity(1000).setViscosity(1000);
		FluidRegistry.registerFluid(registerShoyu);
		AddonJPCore.shoyu = FluidRegistry.getFluid("amtjp.shoyu");

		registerKomezu = new Fluid("amtjp.komezu").setDensity(1000).setViscosity(1000);
		FluidRegistry.registerFluid(registerKomezu);
		AddonJPCore.komezu = FluidRegistry.getFluid("amtjp.komezu");

		// container
		FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("amtjp.shoyu_young",
				FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(AddonJPCore.fluidMaterials, 1, 0), new ItemStack(
				Items.paper));

		FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("amtjp.komezu_young",
				FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(AddonJPCore.fluidMaterials, 1, 1), new ItemStack(
				Items.paper));

		FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("amtjp.shoyu", 200), new ItemStack(
				AddonJPCore.bottle, 1, 48), new ItemStack(DCsAppleMilk.emptyBottle));

		FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("amtjp.komezu", 200), new ItemStack(
				AddonJPCore.bottle, 1, 49), new ItemStack(DCsAppleMilk.emptyBottle));

		AddonJPCore.proxy.registerFluidTex();
	}

	public static void addPotion() {
		if (Potion.potionTypes[AJPConfig.potionLuckID] == null && AJPConfig.potionLuckID < 128) {
			AddonJPCore.luck = (new PotionJPLuck(AJPConfig.potionLuckID, false, 0x30FF30))
					.setPotionName("potion.amtjp.luck");
		}
	}

}
