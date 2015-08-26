package defeatedcrow.addonforamt.jpaddon;

import mods.defeatedcrow.common.DCsAppleMilk;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import defeatedcrow.addonforamt.jpaddon.api.RecipeManagerJP;
import defeatedcrow.addonforamt.jpaddon.common.CommonProxyAJP;
import defeatedcrow.addonforamt.jpaddon.common.entity.EntityGlassBowl;
import defeatedcrow.addonforamt.jpaddon.common.entity.EntityJPBowl;
import defeatedcrow.addonforamt.jpaddon.common.entity.EntityJPBowl_JP;
import defeatedcrow.addonforamt.jpaddon.common.entity.EntityJPDish;
import defeatedcrow.addonforamt.jpaddon.common.entity.EntityJPDrinks;
import defeatedcrow.addonforamt.jpaddon.common.entity.EntityJPRice;
import defeatedcrow.addonforamt.jpaddon.common.entity.EntityJPRice_JP;
import defeatedcrow.addonforamt.jpaddon.common.entity.EntityNoDish;
import defeatedcrow.addonforamt.jpaddon.common.entity.EntityRoastPig;
import defeatedcrow.addonforamt.jpaddon.common.entity.EntitySquarePlate;
import defeatedcrow.addonforamt.jpaddon.common.entity.EntityWoodBowl;
import defeatedcrow.addonforamt.jpaddon.common.entity.EntityWoodBowls_JP;
import defeatedcrow.addonforamt.jpaddon.common.entity.WindProjectile;
import defeatedcrow.addonforamt.jpaddon.event.AJPCraftingEvent;
import defeatedcrow.addonforamt.jpaddon.event.GrassHarvestEvent;
import defeatedcrow.addonforamt.jpaddon.event.HurtEventJP;
import defeatedcrow.addonforamt.jpaddon.event.OnFishingEvent;
import defeatedcrow.addonforamt.jpaddon.event.PlayerKimonoEvent;
import defeatedcrow.addonforamt.jpaddon.plugin.PluginHandler;
import defeatedcrow.addonforamt.jpaddon.recipe.AddBasicRecipeJP;
import defeatedcrow.addonforamt.jpaddon.recipe.AddMachineRecipe;
import defeatedcrow.addonforamt.jpaddon.recipe.DrierRecipeRegister;
import defeatedcrow.addonforamt.jpaddon.recipe.FermenterRecipeRegister;
import defeatedcrow.addonforamt.jpaddon.recipe.OreRegisterJP;
import defeatedcrow.addonforamt.jpaddon.world.AddFishingHooks;
import defeatedcrow.addonforamt.jpaddon.world.WorldGenAJPOres;

@Mod(modid = "AMTAddonJP", name = "AddonforAMT-JP", version = "1.7.10_1.2a", dependencies = "required-after:Forge@[10.13.0.1291,);required-after:DCsAppleMilk@[1.7.10_2.8e,);after:FluidityDC")
public class AddonJPCore {

	@SidedProxy(clientSide = "defeatedcrow.addonforamt.jpaddon.client.ClientProxyAJP", serverSide = "defeatedcrow.addonforamt.jpaddon.common.CommonProxyAJP")
	public static CommonProxyAJP proxy;

	@Instance("AMTAddonJP")
	public static AddonJPCore instance;

	public static final CreativeTabs amtjpTab = new CreativetabAMTJP("amtjp");

	// items
	public static Item materials;
	public static Item minced;
	public static Item teaLeaves;
	public static Item dough;
	public static Item bottle;
	public static Item fluidMaterials;
	public static Item gems;
	public static Item fishes;
	public static Item noodle;
	public static Item roastPig;

	// tools
	public static Item woodenGrater;
	public static Item diamondGrater;

	// foods
	public static Item jpDish;
	public static Item jpBowls;
	public static Item riceBowls;
	public static Item woodBowls;
	public static Item squareDish;
	public static Item glassDish;
	public static Item noDish;
	public static Item jpDrinks;

	// banboo basket
	public static Item jpBowls_jp;
	public static Item riceBowls_jp;
	public static Item woodBowls_jp;

	// kimonos
	public static Item linenBall;
	public static Item linenCloth;
	public static Item[] basicKimono;
	public static Item[] basicHaori;
	public static Item montukiHaori;
	public static Item[] advKimono;
	public static Item samue;
	public static Item[] hakama;
	public static Item tofuApron;

	// blocks
	public static Block dryingRack;
	public static Block linenCont;
	public static Block cardboardJP;

	public static Block ores;
	public static Block gemBlocks;

	public static Block gemHalf;
	public static Block gemHalf_double;
	public static Block saltStairs;
	public static Block alabasterStairs;
	public static Block alabasterLamp;
	public static Block alabasterChandelier;

	// fluids
	public static Fluid shoyu_young;
	public static Fluid komezu_young;
	public static Fluid shoyu;
	public static Fluid komezu;
	public static Block fluidDummy;

	// renders
	public static int renderNum1;
	public static int renderOres;
	public static int renderLamp;
	public static int renderChandelier;

	// guis
	public int guiDryingRack = 1;

	// potion
	public static Potion luck;

	// material
	public static ItemArmor.ArmorMaterial materialAJPLinen;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		// api
		RecipeManagerJP.dryerRecipe = new DrierRecipeRegister();
		RecipeManagerJP.fermRecipe = new FermenterRecipeRegister();

		// config
		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		AJPConfig.config(cfg);

		// materials
		materialAJPLinen = EnumHelper.addArmorMaterial("LINEN_AMT", 7, new int[] {
				1,
				4,
				3,
				1 }, 15);
		materialAJPLinen.customCraftingMaterial = linenCloth;

		// items
		Materials.addItems();

		// blocks
		Materials.addBlocks();
		Materials.addFluid();

		// potion
		if (DCsAppleMilk.RequiredCoreEnabled) {
			Materials.addPotion();
			AJPLogger.debugInfo("Succeed to add new potion effect.");
		}
		if (luck == null) {
			luck = Potion.regeneration;
		}

		PluginHandler.loadPre();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		// ore
		OreRegisterJP.load();

		// recipe
		AddBasicRecipeJP.load();

		// event
		MinecraftForge.EVENT_BUS.register(new HurtEventJP());
		MinecraftForge.EVENT_BUS.register(new GrassHarvestEvent());
		MinecraftForge.EVENT_BUS.register(new PlayerKimonoEvent());
		MinecraftForge.EVENT_BUS.register(new OnFishingEvent());
		FMLCommonHandler.instance().bus().register(new PlayerKimonoEvent());
		FMLCommonHandler.instance().bus().register(new AJPCraftingEvent());

		// entity

		int idJPDish = 0; // EntityRegistry.findGlobalUniqueEntityId();
		int idJPBowl = 1; // EntityRegistry.findGlobalUniqueEntityId();
		int idRiceBowl = 2; // EntityRegistry.findGlobalUniqueEntityId();
		int idWoodBowl = 3; // EntityRegistry.findGlobalUniqueEntityId();
		int idSquareDish = 4; // EntityRegistry.findGlobalUniqueEntityId();
		int idGlassDish = 5; // EntityRegistry.findGlobalUniqueEntityId();
		int idNoDish = 6; // EntityRegistry.findGlobalUniqueEntityId();
		int idJPDrink = 7; // EntityRegistry.findGlobalUniqueEntityId();
		int idJPBowl2 = 8; // EntityRegistry.findGlobalUniqueEntityId();
		int idRiceBowl2 = 9; // EntityRegistry.findGlobalUniqueEntityId();
		int idWoodBowl2 = 10; // EntityRegistry.findGlobalUniqueEntityId();
		int idRoastPig = 12; // EntityRegistry.findGlobalUniqueEntityId();

		int windProj = 11;

		EntityRegistry.registerModEntity(EntityJPDish.class, "amtjp.entity.dish_jp", idJPDish, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityJPBowl.class, "amtjp.entity.bowl_jp", idJPBowl, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityJPRice.class, "amtjp.entity.bowl_rice", idRiceBowl, this, 250, 5, true);
		EntityRegistry
				.registerModEntity(EntityWoodBowl.class, "amtjp.entity.bowl_wood", idWoodBowl, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntitySquarePlate.class, "amtjp.entity.dish_square", idSquareDish, this, 250,
				5, true);
		EntityRegistry.registerModEntity(EntityGlassBowl.class, "amtjp.entity.dish_glass", idGlassDish, this, 250, 5,
				true);
		EntityRegistry.registerModEntity(EntityNoDish.class, "amtjp.entity.dish_non", idNoDish, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityJPDrinks.class, "amtjp.entity.drink_jp", idJPDrink, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityJPBowl_JP.class, "amtjp.entity.bowl_jp_bamboo", idJPBowl2, this, 250, 5,
				true);
		EntityRegistry.registerModEntity(EntityJPRice_JP.class, "amtjp.entity.bowl_rice_bamboo", idRiceBowl2, this,
				250, 5, true);
		EntityRegistry.registerModEntity(EntityWoodBowls_JP.class, "amtjp.entity.bowl_wood_bamboo", idWoodBowl2, this,
				250, 5, true);
		EntityRegistry
				.registerModEntity(EntityRoastPig.class, "amtjp.entity.roast_pig", idRoastPig, this, 125, 5, true);

		EntityRegistry.registerModEntity(WindProjectile.class, "amtjp.entity.projectile_wind", windProj, this, 125, 5,
				true);

		// render
		renderNum1 = proxy.getRenderID();
		renderOres = proxy.getRenderID();
		renderLamp = proxy.getRenderID();
		renderChandelier = proxy.getRenderID();

		proxy.registerRenderers();
		proxy.registerTileEntity();

		// gen
		GameRegistry.registerWorldGenerator(new WorldGenAJPOres(), 2);
		AddFishingHooks.addFishing();

		// gui
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, proxy);

		// plugin init
		PluginHandler.loadInit();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

		PluginHandler.loadPost();

		AddMachineRecipe.addRecipe();

		proxy.loadNEI();

	}

	public int getMajorVersion() {
		return 1;
	}

	public int getMinorVersion() {
		return 2;
	}

	public String getRivision() {
		return "a";
	}

	public String getModName() {
		return "AddonforAMT-JP";
	}

	public String getModID() {
		return "AMTAddonJP";
	}

}
