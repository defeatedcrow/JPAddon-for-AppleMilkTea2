package defeatedcrow.addonforamt.jpaddon.client.entity;

import mods.defeatedcrow.client.entity.base.ModelInnerSoup;
import mods.defeatedcrow.client.entity.base.RenderFoodEntityBase;
import mods.defeatedcrow.common.base.FoodBaseEntity;
import mods.defeatedcrow.common.base.FoodModelType.Deco;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import defeatedcrow.addonforamt.jpaddon.client.model.inner.ModelHiraki;

public class RenderEntityRiceBowl extends RenderFoodEntityBase {

	protected static final ResourceLocation CLAM_TEX = new ResourceLocation(
			"amtjp:textures/entity/foods/gu_hamagurimesi.png");
	protected static final ResourceLocation KURI_TEX = new ResourceLocation(
			"amtjp:textures/entity/foods/gu_kuriokowa.png");
	protected static final ResourceLocation KABAYAKI_TEX = new ResourceLocation(
			"amtjp:textures/entity/foods/kabayaki.png");

	private ModelInnerSoup model = new ModelInnerSoup();
	private ModelHiraki modelHiraki = new ModelHiraki();

	@Override
	protected void renderDeco(FoodBaseEntity entity, byte meta, Deco deco, double par2, double par4, double par6,
			float par8, float par9) {

		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);

		if (meta == 0) {
			this.bindTexture(CLAM_TEX);
		} else if (meta == 1) {
			this.bindTexture(KURI_TEX);
		}

		if (meta < 2) {
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glTranslatef((float) par2, (float) par4 + 1.35F, (float) par6);
			GL11.glScalef(0.9F, -1.0F, -0.9F);
			GL11.glRotatef(par8, 0.0F, 1.0F, 0.0F);

			model.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		}

		if (meta == 3) {
			this.bindTexture(KABAYAKI_TEX);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glTranslatef((float) par2, (float) par4 + 1.53F, (float) par6);
			GL11.glScalef(0.75F, -1.0F, -0.75F);
			GL11.glRotatef(par8, 0.0F, 1.0F, 0.0F);
			modelHiraki.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		}

		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();

	}

	@Override
	protected ResourceLocation getDecoTexture(FoodBaseEntity entity, byte meta, Deco deco) {

		switch (meta) {
		case 0:
			return CLAM_TEX;
		case 1:
			return KURI_TEX;
		default:
			return INNER_TEX_DEFAULT;
		}
	}

}