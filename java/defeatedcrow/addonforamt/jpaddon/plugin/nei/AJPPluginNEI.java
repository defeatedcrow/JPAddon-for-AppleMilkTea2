package defeatedcrow.addonforamt.jpaddon.plugin.nei;

import codechicken.nei.api.API;
import defeatedcrow.addonforamt.jpaddon.client.gui.GuiDryingRack;

public class AJPPluginNEI {

	private AJPPluginNEI() {
	}

	public static DryerRecipeHandlerNEI dryerRecipe;
	public static FermRecipeHandlerNEI fermRecipe;

	public static void load() {
		dryerRecipe = new DryerRecipeHandlerNEI();
		fermRecipe = new FermRecipeHandlerNEI();

		API.registerRecipeHandler(dryerRecipe);
		API.registerUsageHandler(dryerRecipe);
		API.registerGuiOverlay(GuiDryingRack.class, dryerRecipe.getOverlayIdentifier(), 0, 0);

		API.registerRecipeHandler(fermRecipe);
		API.registerUsageHandler(fermRecipe);
		API.registerGuiOverlay(GuiDryingRack.class, fermRecipe.getOverlayIdentifier(), 0, 0);
	}

}
