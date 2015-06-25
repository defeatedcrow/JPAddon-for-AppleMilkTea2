package defeatedcrow.addonforamt.jpaddon.client.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import defeatedcrow.addonforamt.jpaddon.client.model.inner.ModelCheese;
import defeatedcrow.addonforamt.jpaddon.client.model.inner.ModelMasuzushi;
import defeatedcrow.addonforamt.jpaddon.client.model.inner.ModelSalad;
import defeatedcrow.addonforamt.jpaddon.common.entity.EntityFoodBase;
import defeatedcrow.addonforamt.jpaddon.common.entity.FoodType.Deco;

public class RenderEntityNoDish extends JPRenderEntityBase {

	protected static final ResourceLocation MASU_TEX = new ResourceLocation("amtjp:textures/entity/foods/masuzushi.png");
	protected static final ResourceLocation CHEESE_TEX = new ResourceLocation("amtjp:textures/entity/foods/cheese.png");
	protected static final ResourceLocation SALAD_TEX = new ResourceLocation("amtjp:textures/entity/foods/salad.png");

	private ModelMasuzushi modelMasu = new ModelMasuzushi();
	private ModelCheese modelCheese = new ModelCheese();
	private ModelSalad modelSalad = new ModelSalad();

	@Override
	protected void renderDeco(EntityFoodBase entity, byte meta, Deco deco, double par2, double par4, double par6,
			float par8, float par9) {
		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glTranslatef((float) par2, (float) par4 + 1.3F, (float) par6);
		GL11.glScalef(1.0F, -1.0F, -1.0F);
		GL11.glRotatef(par8, 0.0F, 1.0F, 0.0F);

		switch (meta) {
		case 0:
			this.bindTexture(DISH_SQUARE_TEX);
			modelDishJ.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			this.bindTexture(MASU_TEX);
			modelMasu.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			break;
		case 1:
			this.bindTexture(CHEESE_TEX);
			modelCheese.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			break;
		case 2:
			this.bindTexture(SALAD_TEX);
			modelSalad.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			break;
		default:
			this.bindTexture(MASU_TEX);
			modelMasu.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			break;
		}

		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();

	}

}
