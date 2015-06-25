package defeatedcrow.addonforamt.jpaddon.client.entity;

import mods.defeatedcrow.client.model.model.ModelTeaCup;
import mods.defeatedcrow.client.model.model.ModelWoodBowl;
import mods.defeatedcrow.common.config.DCsConfig;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import defeatedcrow.addonforamt.jpaddon.client.model.ModelBowlRice;
import defeatedcrow.addonforamt.jpaddon.client.model.ModelBowlSoup;
import defeatedcrow.addonforamt.jpaddon.client.model.ModelDishGlass;
import defeatedcrow.addonforamt.jpaddon.client.model.ModelDishJP;
import defeatedcrow.addonforamt.jpaddon.client.model.ModelDishWhite;
import defeatedcrow.addonforamt.jpaddon.common.entity.EntityFoodBase;
import defeatedcrow.addonforamt.jpaddon.common.entity.FoodType;

@SideOnly(Side.CLIENT)
public abstract class JPRenderEntityBase extends Render {
	protected static final String[] PASS = { "foods", "foods/x32" };

	protected static final ResourceLocation BOWL_RICE_TEX = new ResourceLocation("amtjp:textures/entity/" + getPass()
			+ "/bowlJP_rice.png");
	protected static final ResourceLocation BOWL_SOUP_TEX = new ResourceLocation("amtjp:textures/entity/" + getPass()
			+ "/bowlJP_soup.png");
	protected static final ResourceLocation BOWL_WOOD_TEX = new ResourceLocation(
			"defeatedcrow:textures/entity/woodbowl.png");
	protected static final ResourceLocation DISH_GLASS_TEX = new ResourceLocation("amtjp:textures/entity/" + getPass()
			+ "/dish_glass.png");
	protected static final ResourceLocation DISH_JP_TEX = new ResourceLocation("amtjp:textures/entity/" + getPass()
			+ "/dish_jp.png");
	protected static final ResourceLocation DISH_SQUARE_TEX = new ResourceLocation("amtjp:textures/entity/" + getPass()
			+ "/dish_square.png");
	protected static final ResourceLocation DISH_WHITE_TEX = new ResourceLocation("amtjp:textures/entity/" + getPass()
			+ "/dish_white.png");
	protected static final ResourceLocation MAG_WHITE_TEX = new ResourceLocation(
			"defeatedcrow:textures/blocks/whitepanel.png");

	protected ModelBowlRice modelBowlR = new ModelBowlRice();
	protected ModelBowlSoup modelBowlS = new ModelBowlSoup();
	protected ModelWoodBowl modelBowlW = new ModelWoodBowl();
	protected ModelDishGlass modelDishG = new ModelDishGlass();
	protected ModelDishJP modelDishJ = new ModelDishJP();
	protected ModelDishWhite modelDishW = new ModelDishWhite();
	protected ModelTeaCup modelCup = new ModelTeaCup();

	public JPRenderEntityBase() {
		this.shadowSize = 0.3F;
	}

	/**
	 * The render method used in RenderBoat that renders the boat model.
	 */
	public void render(EntityFoodBase entity, double par2, double par4, double par6, float par8, float par9) {
		byte l = (byte) entity.getItemMetadata();
		FoodType.Dish dish = entity.getDishType();
		FoodType.Soup soup = entity.getSoupType();
		FoodType.Deco deco = entity.getDecoType();

		this.renderDeco(entity, l, deco, par2, par4, par6, par8, par9);

		this.renderDish(entity, l, dish, par2, par4, par6, par8, par9);

		this.renderSoup(entity, l, soup, par2, par4, par6, par8, par9);

	}

	protected void renderDish(EntityFoodBase entity, byte meta, FoodType.Dish dish, double par2, double par4,
			double par6, float par8, float par9) {
		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glTranslatef((float) par2, (float) par4 + 1.3F, (float) par6);
		GL11.glScalef(1.0F, -1.0F, -1.0F);
		GL11.glRotatef(par8, 0.0F, 1.0F, 0.0F);

		if (dish == FoodType.Dish.RiceBowl) {
			this.bindTexture(BOWL_RICE_TEX);
			modelBowlR.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		} else if (dish == FoodType.Dish.SoupBowl) {
			this.bindTexture(BOWL_SOUP_TEX);
			modelBowlS.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		} else if (dish == FoodType.Dish.WoodBowl) {
			this.bindTexture(BOWL_WOOD_TEX);
			modelBowlW.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		} else if (dish == FoodType.Dish.Obon) {
			this.bindTexture(DISH_JP_TEX);
			modelDishJ.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		} else if (dish == FoodType.Dish.SquarePlate) {
			this.bindTexture(DISH_SQUARE_TEX);
			modelDishJ.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		} else if (dish == FoodType.Dish.Glass) {
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F);

			this.bindTexture(DISH_GLASS_TEX);
			modelDishG.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

			GL11.glDisable(GL11.GL_BLEND);
		} else if (dish == FoodType.Dish.White) {
			this.bindTexture(DISH_WHITE_TEX);
			modelDishW.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		} else if (dish == FoodType.Dish.Mag) {
			this.bindTexture(MAG_WHITE_TEX);
			modelCup.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		}

		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
	}

	protected void renderSoup(EntityFoodBase entity, byte meta, FoodType.Soup soup, double par2, double par4,
			double par6, float par8, float par9) {
		Tessellator tessellator = Tessellator.instance;
		IIcon iicon = entity.getSoupIcon(meta);
		if (iicon == null)
			return;

		float f14 = iicon.getMinU();
		float f15 = iicon.getMaxU();
		float f4 = iicon.getMinV();
		float f5 = iicon.getMaxV();

		double x;
		double y;
		double z;

		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		if (soup == FoodType.Soup.Drink) {
			GL11.glColor4f(2.0F, 2.0F, 2.0F, 0.9F);
		} else {
			GL11.glColor4f(2.0F, 2.0F, 2.0F, 1.0F);
		}
		GL11.glTranslatef((float) par2, (float) par4 + 0.5F, (float) par6);
		GL11.glScalef(1.0F, -1.0F, -1.0F);
		GL11.glRotatef(par8, 0.0F, 1.0F, 0.0F);

		this.bindTexture(TextureMap.locationItemsTexture);

		if (soup != FoodType.Soup.Rice && soup != FoodType.Soup.Rice) {
			if (soup == FoodType.Soup.Soup) {
				x = 0.2D;
				y = 0.45D;
				z = 0.2D;
			} else if (soup == FoodType.Soup.WoodSoup) {
				x = 0.25D;
				y = 0.43D;
				z = 0.25D;
			} else if (soup == FoodType.Soup.Drink) {
				x = 0.15D;
				y = 0.3D;
				z = 0.15D;
			} else {
				x = 0.25D;
				y = 0.5D;
				z = 0.25D;
			}

			tessellator.startDrawingQuads();
			tessellator.setNormal(1.0F, 0.0F, 0.0F);
			tessellator.addVertexWithUV(-x, y, -z, f14, f5);
			tessellator.addVertexWithUV(x, y, -z, f15, f5);
			tessellator.addVertexWithUV(x, y, z, f15, f4);
			tessellator.addVertexWithUV(-x, y, z, f14, f4);
			tessellator.draw();
		} else if (soup == FoodType.Soup.WoodRice) {

			tessellator.startDrawingQuads();
			tessellator.setNormal(1.0F, 0.0F, 0.0F);
			tessellator.addVertexWithUV(-0.1D, 0.3D, -0.1D, f14, f5);
			tessellator.addVertexWithUV(0.1D, 0.3D, -0.1D, f15, f5);
			tessellator.addVertexWithUV(0.1D, 0.3D, 0.1D, f15, f4);
			tessellator.addVertexWithUV(-0.1D, 0.3D, 0.1D, f14, f4);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal(1.0F, 0.0F, 0.0F);
			tessellator.addVertexWithUV(-0.25D, 0.5D, -0.25D, f14, f5);
			tessellator.addVertexWithUV(0.25D, 0.5D, -0.25D, f15, f5);
			tessellator.addVertexWithUV(0.1D, 0.3D, -0.1D, f15, f4);
			tessellator.addVertexWithUV(-0.1D, 0.3D, -0.1D, f14, f4);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal(1.0F, 0.0F, 0.0F);
			tessellator.addVertexWithUV(0.25D, 0.5D, 0.25D, f14, f5);
			tessellator.addVertexWithUV(-0.25D, 0.5D, 0.25D, f15, f5);
			tessellator.addVertexWithUV(-0.1D, 0.3D, 0.1D, f15, f4);
			tessellator.addVertexWithUV(0.1D, 0.3D, 0.1D, f14, f4);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal(1.0F, 0.0F, 0.0F);
			tessellator.addVertexWithUV(-0.25D, 0.5D, -0.25D, f14, f5);
			tessellator.addVertexWithUV(-0.1D, 0.3D, -0.1D, f15, f5);
			tessellator.addVertexWithUV(-0.1D, 0.3D, 0.1D, f15, f4);
			tessellator.addVertexWithUV(-0.25D, 0.5D, 0.25D, f14, f4);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal(1.0F, 0.0F, 0.0F);
			tessellator.addVertexWithUV(0.1D, 0.3D, -0.1D, f14, f5);
			tessellator.addVertexWithUV(0.25D, 0.5D, -0.25D, f15, f5);
			tessellator.addVertexWithUV(0.25D, 0.5D, 0.25D, f15, f4);
			tessellator.addVertexWithUV(0.1D, 0.3D, 0.1D, f14, f4);
			tessellator.draw();
		} else if (soup == FoodType.Soup.Rice) {
			tessellator.startDrawingQuads();
			tessellator.setNormal(1.0F, 0.0F, 0.0F);
			tessellator.addVertexWithUV(-0.1D, 0.3D, -0.1D, f14, f5);
			tessellator.addVertexWithUV(0.1D, 0.3D, -0.1D, f15, f5);
			tessellator.addVertexWithUV(0.1D, 0.3D, 0.1D, f15, f4);
			tessellator.addVertexWithUV(-0.1D, 0.3D, 0.1D, f14, f4);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal(1.0F, 0.0F, 0.0F);
			tessellator.addVertexWithUV(-0.2D, 0.45D, -0.2D, f14, f5);
			tessellator.addVertexWithUV(0.2D, 0.45D, -0.2D, f15, f5);
			tessellator.addVertexWithUV(0.1D, 0.3D, -0.1D, f15, f4);
			tessellator.addVertexWithUV(-0.1D, 0.3D, -0.1D, f14, f4);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal(1.0F, 0.0F, 0.0F);
			tessellator.addVertexWithUV(0.2D, 0.45D, 0.2D, f14, f5);
			tessellator.addVertexWithUV(-0.2D, 0.45D, 0.2D, f15, f5);
			tessellator.addVertexWithUV(-0.1D, 0.3D, 0.1D, f15, f4);
			tessellator.addVertexWithUV(0.1D, 0.3D, 0.1D, f14, f4);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal(1.0F, 0.0F, 0.0F);
			tessellator.addVertexWithUV(-0.2D, 0.45D, -0.2D, f14, f5);
			tessellator.addVertexWithUV(-0.1D, 0.3D, -0.1D, f15, f5);
			tessellator.addVertexWithUV(-0.1D, 0.3D, 0.1D, f15, f4);
			tessellator.addVertexWithUV(-0.2D, 0.45D, 0.2D, f14, f4);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal(1.0F, 0.0F, 0.0F);
			tessellator.addVertexWithUV(0.1D, 0.3D, -0.1D, f14, f5);
			tessellator.addVertexWithUV(0.2D, 0.45D, -0.2D, f15, f5);
			tessellator.addVertexWithUV(0.2D, 0.45D, 0.2D, f15, f4);
			tessellator.addVertexWithUV(0.1D, 0.3D, 0.1D, f14, f4);
			tessellator.draw();
		}

		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
	}

	protected abstract void renderDeco(EntityFoodBase entity, byte meta, FoodType.Deco deco, double par2, double par4,
			double par6, float par8, float par9);

	protected ResourceLocation getBowlTextures(EntityFoodBase par1Entity) {
		return BOWL_RICE_TEX;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity) {
		return this.getBowlTextures((EntityFoodBase) par1Entity);
	}

	@Override
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
		this.render((EntityFoodBase) par1Entity, par2, par4, par6, par8, par9);
	}

	private static String getPass() {
		int i = DCsConfig.setAltTexturePass == 0 ? 0 : 1;
		return PASS[i];
	}
}
