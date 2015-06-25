package defeatedcrow.addonforamt.jpaddon.client.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import defeatedcrow.addonforamt.jpaddon.client.model.inner.ModelHiraki;
import defeatedcrow.addonforamt.jpaddon.client.model.inner.ModelShake;
import defeatedcrow.addonforamt.jpaddon.client.model.inner.ModelTukemono;
import defeatedcrow.addonforamt.jpaddon.common.entity.EntityFoodBase;
import defeatedcrow.addonforamt.jpaddon.common.entity.FoodType.Deco;

public class RenderEntitySquareDish extends JPRenderEntityBase {

	protected static final ResourceLocation SHAKE_TEX = new ResourceLocation("amtjp:textures/entity/foods/shake.png");
	protected static final ResourceLocation HIRAKI_TEX = new ResourceLocation("amtjp:textures/entity/foods/hiraki.png");
	protected static final ResourceLocation TUKE_TEX = new ResourceLocation("amtjp:textures/entity/foods/tukemono.png");

	private ModelShake modelShake = new ModelShake();
	private ModelHiraki modelHiraki = new ModelHiraki();
	private ModelTukemono modelTuke = new ModelTukemono();

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
			this.bindTexture(HIRAKI_TEX);
			modelHiraki.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			break;
		case 1:
			this.bindTexture(SHAKE_TEX);
			modelShake.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			break;
		case 2:
			this.bindTexture(TUKE_TEX);
			modelTuke.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			break;
		default:
			this.bindTexture(HIRAKI_TEX);
			modelHiraki.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			break;
		}

		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();

	}

}
