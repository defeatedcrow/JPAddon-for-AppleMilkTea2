package defeatedcrow.addonforamt.jpaddon.plugin;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import cpw.mods.fml.common.registry.GameRegistry;
import defeatedcrow.addonforamt.jpaddon.AJPLogger;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;
import mods.defeatedcrow.api.recipe.RecipeRegisterManager;
import mods.defeatedcrow.common.DCsAppleMilk;

public class AJPBambooPlugin {

    private AJPBambooPlugin() {}

    public static void load() {
        addBasicRecipe();
        addMachineRecipe();
    }

    static void addBasicRecipe() {

        Block sakuraLeaves = GameRegistry.findBlock("BambooMod", "sakuraLeaves");
        Block sakuraSapling = GameRegistry.findBlock("BambooMod", "sakuraSapling");
        Block bambooShoot = GameRegistry.findBlock("BambooMod", "blockbambooshoot");
        Item katana = GameRegistry.findItem("BambooMod", "katana");
        Item food = GameRegistry.findItem("BambooMod", "bambooFood");
        if (sakuraLeaves != null) {
            AJPLogger.logger.info("got " + sakuraLeaves.getUnlocalizedName());

            GameRegistry.addRecipe(
                new ShapelessOreRecipe(
                    new ItemStack(AddonJPCore.teaLeaves, 1, 0),
                    new Object[] { "toolGrater", new ItemStack(DCsAppleMilk.foodTea, 1, 0),
                        new ItemStack(sakuraLeaves, 1, 32767) }));

            RecipeRegisterManager.processorRecipe.addRecipe(
                new ItemStack(AddonJPCore.teaLeaves, 1, 0),
                true,
                null,
                new Object[] { new ItemStack(DCsAppleMilk.foodTea, 1, 0), new ItemStack(sakuraLeaves, 1, 32767) });
        }
        if (sakuraSapling != null) {
            AJPLogger.logger.info("got " + sakuraSapling.getUnlocalizedName());

            GameRegistry.addRecipe(
                new ShapelessOreRecipe(
                    new ItemStack(AddonJPCore.advKimono[0], 1, 0),
                    new Object[] { new ItemStack(AddonJPCore.hakama[0], 1, 0),
                        new ItemStack(sakuraSapling, 1, 32767) }));
        }
        if (bambooShoot != null) {
            AJPLogger.logger.info("got " + bambooShoot.getUnlocalizedName());

            GameRegistry.addRecipe(
                new ShapelessOreRecipe(
                    new ItemStack(AddonJPCore.minced, 1, 9),
                    new Object[] { "toolGrater", new ItemStack(bambooShoot, 1, 0), "cropSansho", "bottleSoySauce",
                        "foodKatuobushi", "foodSugar" }));

            RecipeRegisterManager.processorRecipe.addRecipe(
                new ItemStack(AddonJPCore.minced, 1, 9),
                true,
                null,
                new Object[] { new ItemStack(bambooShoot, 1, 0), "cropSansho", "bottleSoySauce", "foodKatuobushi",
                    "foodSugar" });
        }
        if (katana != null) {
            AJPLogger.logger.info("got " + katana.getUnlocalizedName());

            GameRegistry.addRecipe(
                new ShapelessOreRecipe(
                    new ItemStack(AddonJPCore.montukiHaori, 1, 0),
                    new Object[] { new ItemStack(AddonJPCore.basicHaori[0], 1, 0), new ItemStack(katana, 1, 32767) }));
        }
        if (food != null) {
            AJPLogger.logger.info("got " + food.getUnlocalizedName());

            GameRegistry.addRecipe(
                new ShapelessOreRecipe(
                    new ItemStack(AddonJPCore.minced, 1, 8),
                    new Object[] { "toolGrater", new ItemStack(Items.fish, 1, 1), "cropCarrot", "cropRadish",
                        "soybeans", new ItemStack(food, 1, 36), "foodSakeLees" }));

            GameRegistry.addRecipe(
                new ShapelessOreRecipe(
                    new ItemStack(AddonJPCore.minced, 1, 8),
                    new Object[] { "toolGrater", new ItemStack(Items.fish, 1, 1), "cropCarrot", "soybeans",
                        new ItemStack(food, 1, 36), "foodSakeLees" }));
        }
    }

    static void addMachineRecipe() {
        Item bean = GameRegistry.findItem("BambooMod", "itembean");
        if (bean != null) {
            AJPLogger.logger.info("got " + bean.getUnlocalizedName());

            RecipeRegisterManager.teaRecipe.register(
                new ItemStack(bean),
                new ItemStack(AddonJPCore.jpDrinks, 1, 5),
                "amtjp:textures/items/contents/contents_sakura.png");
        }
    }

}
