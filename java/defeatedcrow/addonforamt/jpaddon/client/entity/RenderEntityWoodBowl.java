package defeatedcrow.addonforamt.jpaddon.client.entity;

import mods.defeatedcrow.client.entity.base.ModelInnerSoup;
import mods.defeatedcrow.client.entity.base.RenderFoodEntityBase;
import mods.defeatedcrow.common.base.FoodBaseEntity;
import mods.defeatedcrow.common.base.FoodModelType.Deco;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class RenderEntityWoodBowl extends RenderFoodEntityBase {

	protected static final ResourceLocation NASU_TEX = new ResourceLocation(
			"amtjp:textures/entity/foods/gu_nasutomato.png");
	private ModelInnerSoup model = new ModelInnerSoup();

	@Override
	protected void renderDeco(FoodBaseEntity entity, byte meta, Deco deco, double par2, double par4, double par6,
			float par8, float par9) {

		if (meta == 0) {
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
