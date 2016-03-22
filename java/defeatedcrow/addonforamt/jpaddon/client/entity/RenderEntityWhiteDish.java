package defeatedcrow.addonforamt.jpaddon.client.entity;

import mods.defeatedcrow.client.entity.base.RenderFoodEntityBase;
import mods.defeatedcrow.common.base.FoodBaseEntity;
import mods.defeatedcrow.common.base.FoodModelType.Deco;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import defeatedcrow.addonforamt.jpaddon.client.model.inner.ModelBeefstew;
import defeatedcrow.addonforamt.jpaddon.client.model.inner.ModelBreakfast;
import defeatedcrow.addonforamt.jpaddon.client.model.inner.ModelCarpaccio;
import defeatedcrow.addonforamt.jpaddon.client.model.inner.ModelDishPie;
import defeatedcrow.addonforamt.jpaddon.client.model.inner.ModelDishWhite;

public class RenderEntityWhiteDish extends RenderFoodEntityBase {

	protected static final ResourceLocation BEEFSTEW_TEX = new ResourceLocation(
			"amtjp:textures/entity/foods/beefstew.png");
	protected static final ResourceLocation BEEFCAR_TEX = new ResourceLocation(
			"amtjp:textures/entity/foods/carpaccio_beef.png");
	protected static final ResourceLocation FISHCAR_TEX = new ResourceLocation(
			"amtjp:textures/entity/foods/carpaccio_fish.png");
	protected static final ResourceLocation BREAKFAST_TEX = new ResourceLocation(
			"amtjp:textures/entity/foods/breakfast.png");
	protected static final ResourceLocation PIE_TEX = new ResourceLocation("amtjp:textures/entity/foods/applepie.png");

	private ModelBeefstew modelStew = new ModelBeefstew();
	private ModelCarpaccio modelCarpaccio = new ModelCarpaccio();
	private ModelDishPie modelPie = new ModelDishPie();
	private ModelBreakfast modelBF = new ModelBreakfast();

	private ModelDishWhite modelDish = new ModelDishWhite();

	@Override
	protected void renderDeco(FoodBaseEntity entity, byte meta, Deco deco, double par2, double par4, double par6,
			float par8, float par9) {
		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glTranslatef((float) par2, (float) par4 + 1.3F, (float) par6);
		GL11.glScalef(1.0F, -1.0F, -1.0F);
		GL11.glRotatef(par8, 0.0F, 1.0F, 0.0F);

		this.bindTexture(DISH_WHITE_TEX);
		modelDish.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

		switch (meta) {
		case 0:
			this.bindTexture(BREAKFAST_TEX);
			modelBF.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			break;
		case 1:
			this.bindTexture(BEEFSTEW_TEX);
			modelStew.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.9F);
			modelStew.renderSource((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glDisable(GL11.GL_BLEND);
			break;
		case 2:
			this.bindTexture(BEEFCAR_TEX);
			modelCarpaccio.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F);
			modelCarpaccio.renderSource((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glDisable(GL11.GL_BLEND);
			break;
		case 3:
			this.bindTexture(FISHCAR_TEX);
			modelCarpaccio.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F);
			modelCarpaccio.renderSource((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glDisable(GL11.GL_BLEND);
			break;
		case 4:
			this.bindTexture(PIE_TEX);
			modelPie.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			break;
		default:
			break;
		}

		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();

	}

}
