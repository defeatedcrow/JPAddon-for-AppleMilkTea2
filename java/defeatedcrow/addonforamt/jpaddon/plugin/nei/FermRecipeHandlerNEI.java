package defeatedcrow.addonforamt.jpaddon.plugin.nei;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import defeatedcrow.addonforamt.jpaddon.api.IFermenterRecipe;
import defeatedcrow.addonforamt.jpaddon.api.RecipeManagerJP;
import defeatedcrow.addonforamt.jpaddon.client.gui.GuiDryingRack;

public class FermRecipeHandlerNEI extends TemplateRecipeHandler {

	private List<IFermenterRecipe> thisRecipes;

	private List<IFermenterRecipe> recipeLoader() {
		if (RecipeManagerJP.fermRecipe.getRecipes() != null && !RecipeManagerJP.fermRecipe.getRecipes().isEmpty()) {
			this.thisRecipes = (List<IFermenterRecipe>) RecipeManagerJP.fermRecipe.getRecipes();
		}
		return thisRecipes;
	}

	public class RecipeCacher extends CachedRecipe {

		public ArrayList<PositionedStack> input;
		private PositionedStack result;
		private int days;

		public RecipeCacher() {
			input = new ArrayList<PositionedStack>();
		}

		public RecipeCacher(List<ItemStack> in, ItemStack out, int i) {
			this();
			this.result = new PositionedStack(out, 48, 2);
			this.days = i;
			setInput(in);
		}

		public void setInput(List<ItemStack> in) {
			input.clear();
			PositionedStack stack = new PositionedStack(in, 48, 34);
			stack.setMaxSize(1);
			input.add(stack);
		}

		@Override
		public PositionedStack getResult() {
			return this.result;
		}

		@Override
		public List<PositionedStack> getIngredients() {
			return getCycledIngredients(cycleticks / 20, input);
		}

		@Override
		public PositionedStack getOtherStack() {
			return null;
		}

	}

	public PositionedStack getResult() {
		return null;
	}

	@Override
	public Class<? extends GuiContainer> getGuiClass() {
		return GuiDryingRack.class;
	}

	@Override
	public String getOverlayIdentifier() {
		return "DCsFermenterRack";
	}

	@Override
	public void loadTransferRects() {
		transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(new Rectangle(135, 20, 13, 13),
				"DCsFermenterRack"));
	}

	@Override
	public void loadCraftingRecipes(String outputId, Object... results) {
		if (outputId.equals("DCsFermenterRack") && getClass() == FermRecipeHandlerNEI.class) {
			List<IFermenterRecipe> recipes = this.recipeLoader();

			if (recipes == null || recipes.isEmpty())
				return;
			for (IFermenterRecipe recipe : recipes) {
				ItemStack out = recipe.getOutput();
				ArrayList<ItemStack> in = recipe.getProcessedInput();
				int day = recipe.getTime();
				if (!in.isEmpty())
					arecipes.add(new RecipeCacher(in, out, day));
			}
		} else {
			super.loadCraftingRecipes(outputId, results);
		}
	}

	@Override
	public void loadCraftingRecipes(ItemStack result) {
		List<IFermenterRecipe> recipes = this.recipeLoader();

		if (recipes == null || recipes.isEmpty())
			return;
		for (IFermenterRecipe recipe : recipes) {
			ItemStack items = recipe.getOutput();
			ArrayList<ItemStack> in = recipe.getProcessedInput();
			int day = recipe.getTime();
			if (!in.isEmpty() && NEIServerUtils.areStacksSameType(items, result)) {
				arecipes.add(new RecipeCacher(in, items, day));
			}
		}
	}

	@Override
	public void loadUsageRecipes(ItemStack ingredient) {
		List<IFermenterRecipe> recipes = this.recipeLoader();

		if (recipes == null || recipes.isEmpty())
			return;
		for (IFermenterRecipe recipe : recipes) {
			ItemStack items = recipe.getOutput();
			ArrayList<ItemStack> in = recipe.getProcessedInput();
			int day = recipe.getTime();
			if (!in.isEmpty() && contain(in, ingredient)) {
				RecipeCacher cache = new RecipeCacher(in, items, day);
				arecipes.add(cache);
			}
		}
	}

	private boolean contain(List<ItemStack> in, ItemStack check) {
		boolean flag1 = false;
		if (check == null)
			return false;

		for (ItemStack ret : in) {
			if (ret == null)
				continue;

			if (NEIServerUtils.areStacksSameType(ret, check))
				flag1 = true;
		}

		return flag1;
	}

	@Override
	public String getRecipeName() {
		return StatCollector.translateToLocal("amtjp.nei.fermenter_recipe");
	}

	@Override
	public String getGuiTexture() {
		return "amtjp:textures/gui/dryer_nei.png";
	}

	@Override
	public void drawExtras(int recipe) {
		drawProgressBar(48, 20, 176, 12, 16, 12, 24, 3);

		// mode icon
		Minecraft mc = Minecraft.getMinecraft();
		ResourceLocation res = new ResourceLocation("amtjp:textures/gui/dryer_nei.png");
		mc.getTextureManager().bindTexture(res);
		mc.currentScreen.drawTexturedModalRect(135, 20, 192, 65, 13, 13);

		int day = 0;
		if (!arecipes.isEmpty() && arecipes.get(recipe) instanceof RecipeCacher) {
			RecipeCacher r = (RecipeCacher) arecipes.get(recipe);
			day = r.days;
		}

		if (day > 0) {
			String d = day + " day";
			mc.fontRenderer.drawString(I18n.format(d, new Object[0]), 133, 35, 16777215);
		}
	}

}
