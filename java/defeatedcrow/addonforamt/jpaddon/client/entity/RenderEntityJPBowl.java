package defeatedcrow.addonforamt.jpaddon.client.entity;

import mods.defeatedcrow.client.entity.base.RenderFoodEntityBase;
import mods.defeatedcrow.common.base.FoodBaseEntity;
import mods.defeatedcrow.common.base.FoodModelType.Deco;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import defeatedcrow.addonforamt.jpaddon.AddonJPCore;
import defeatedcrow.addonforamt.jpaddon.client.model.inner.ModelSoupInnerJP;

public class RenderEntityJPBowl extends RenderFoodEntityBase {

	protected static final ResourceLocation NASU_TEX = new ResourceLocation(
			"amtjp:textures/entity/foods/gu_nasusoumen.png");
	private ModelSoupInnerJP model = new ModelSoupInnerJP();

	@Override
	protected void renderDeco(FoodBaseEntity entity, byte meta, Deco deco, double par2, double par4, double par6,
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

		if (meta == 4) {
			GL11.glPushMatrix();
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
			GL11.glTranslatef((float) par2, (float) par4 - 0.1F, (float) par6);
			GL11.glScalef(0.85F, -0.85F, -0.85F);
			GL11.glRotatef(par8, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(145, 1.0F, 0.0F, 0.0F);

			EntityItem entityitem = new EntityItem(entity.worldObj, 0.0D, 0.0D, 0.0D, new ItemStack(
					AddonJPCore.squareDish, 1, 4));
			entityitem.getEntityItem().stackSize = 1;
			entityitem.hoverStart = 0.0F;
			RenderItem.renderInFrame = true;
			RenderManager.instance.renderEntityWithPosYaw(entityitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
			RenderItem.renderInFrame = false;
			GL11.glDisable(GL12.GL_RESCALE_NORMAL);
			GL11.glPopMatrix();
		}

	}

}
