package defeatedcrow.addonforamt.jpaddon.client.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import defeatedcrow.addonforamt.jpaddon.client.model.inner.ModelSoupInnerJP;
import defeatedcrow.addonforamt.jpaddon.common.entity.EntityFoodBase;
import defeatedcrow.addonforamt.jpaddon.common.entity.FoodType.Deco;

public class RenderEntityJPBowl extends JPRenderEntityBase {

	protected static final ResourceLocation NASU_TEX = new ResourceLocation(
			"amtjp:textures/entity/foods/gu_nasusoumen.png");
	private ModelSoupInnerJP model = new ModelSoupInnerJP();

	@Override
	protected void renderDeco(EntityFoodBase entity, byte meta, Deco deco, double par2, double par4, double par6,
			float par8, float par9) {

		if (meta == 2) {
			GL11.glPushMatrix();
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
			this.bindTexture(NASU_TEX);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glTranslatef((float) par2, (float) par4 + 1.3F, (float) par6);
			GL11.glScalef(1.0F, -1.0F, -1.0F);
			GL11.glRotatef(par8, 0.0F, 1.0F, 0.0F);
			model.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glDisable(GL12.GL_RESCALE_NORMAL);
			GL11.glPopMatrix();
		}

	}

}
