package defeatedcrow.addonforamt.jpaddon.client.entity;

import mods.defeatedcrow.client.entity.base.RenderFoodEntityBase;
import mods.defeatedcrow.common.base.FoodBaseEntity;
import mods.defeatedcrow.common.base.FoodModelType.Deco;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import defeatedcrow.addonforamt.jpaddon.AddonJPCore;
import defeatedcrow.addonforamt.jpaddon.client.model.inner.ModelHiraki;
import defeatedcrow.addonforamt.jpaddon.client.model.inner.ModelShake;
import defeatedcrow.addonforamt.jpaddon.client.model.inner.ModelTukemono;

public class RenderEntitySquareDish extends RenderFoodEntityBase {

	protected static final ResourceLocation SHAKE_TEX = new ResourceLocation("amtjp:textures/entity/foods/shake.png");
	protected static final ResourceLocation HIRAKI_TEX = new ResourceLocation("amtjp:textures/entity/foods/hiraki.png");
	protected static final ResourceLocation TUKE_TEX = new ResourceLocation("amtjp:textures/entity/foods/tukemono.png");
	protected static final ResourceLocation KABAYAKI_TEX = new ResourceLocation(
			"amtjp:textures/entity/foods/kabayaki.png");

	private ModelShake modelShake = new ModelShake();
	private ModelHiraki modelHiraki = new ModelHiraki();
	private ModelTukemono modelTuke = new ModelTukemono();

	@Override
	protected void renderDeco(FoodBaseEntity entity, byte meta, Deco deco, double par2, double par4, double par6,
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
		case 3:
			this.bindTexture(KABAYAKI_TEX);
			modelHiraki.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			break;
		default:
			break;
		}

		if (meta == 4) {

			float adjY = 0.0F;
			if (!AddonJPCore.proxy.vanillaFancyRenderMode()) {
				EntityPlayer player = Minecraft.getMinecraft().thePlayer;
				if (player != null) {
					adjY = 360 - player.cameraYaw;
				}
			}

			GL11.glTranslatef(0.0F, 1.5F, -0.35F);
			GL11.glRotatef(100.0F, 1.0F, 0.0F, 0.0F);
			GL11.glScalef(1.5F, 1.5F, 1.5F);

			EntityItem entityitem = new EntityItem(entity.worldObj, 0.0D, 0.0D, 0.0D, new ItemStack(
					AddonJPCore.squareDish, 1, 4));
			entityitem.getEntityItem().stackSize = 1;
			entityitem.hoverStart = 0.0F;
			RenderItem.renderInFrame = true;
			RenderManager.instance.renderEntityWithPosYaw(entityitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
			RenderItem.renderInFrame = false;
		}

		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();

	}

}
