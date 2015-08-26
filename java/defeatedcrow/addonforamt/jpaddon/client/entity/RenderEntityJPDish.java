package defeatedcrow.addonforamt.jpaddon.client.entity;

import mods.defeatedcrow.client.entity.base.RenderFoodEntityBase;
import mods.defeatedcrow.common.base.FoodBaseEntity;
import mods.defeatedcrow.common.base.FoodModelType.Deco;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import defeatedcrow.addonforamt.jpaddon.client.model.inner.ModelBrownie;
import defeatedcrow.addonforamt.jpaddon.client.model.inner.ModelJPCake;
import defeatedcrow.addonforamt.jpaddon.client.model.inner.ModelMoti;
import defeatedcrow.addonforamt.jpaddon.client.model.inner.ModelOniman;
import defeatedcrow.addonforamt.jpaddon.client.model.inner.ModelSenbei;
import defeatedcrow.addonforamt.jpaddon.client.model.inner.ModelSwissroll;

public class RenderEntityJPDish extends RenderFoodEntityBase {

	protected static final ResourceLocation ONIMAN_TEX = new ResourceLocation("amtjp:textures/entity/foods/oniman.png");
	protected static final ResourceLocation KUSAMOTI_TEX = new ResourceLocation(
			"amtjp:textures/entity/foods/kusamoti.png");
	protected static final ResourceLocation MACHAROLL_TEX = new ResourceLocation(
			"amtjp:textures/entity/foods/swissroll.png");
	protected static final ResourceLocation HOSIIMO_TEX = new ResourceLocation(
			"amtjp:textures/entity/foods/hosiimo.png");
	protected static final ResourceLocation SOYCAKE_TEX = new ResourceLocation(
			"amtjp:textures/entity/foods/soycake.png");
	protected static final ResourceLocation SENBEI_TEX = new ResourceLocation("amtjp:textures/entity/foods/senbei.png");
	protected static final ResourceLocation BROWNIE_TEX = new ResourceLocation(
			"amtjp:textures/entity/foods/brownie.png");
	protected static final ResourceLocation DAIHUKU_TEX = new ResourceLocation(
			"amtjp:textures/entity/foods/daihuku_strawberry.png");

	private ModelOniman oniman = new ModelOniman();
	private ModelMoti moti = new ModelMoti();
	private ModelSwissroll roll = new ModelSwissroll();
	private ModelBrownie hosiimo = new ModelBrownie();
	private ModelJPCake cake = new ModelJPCake();
	private ModelSenbei senbei = new ModelSenbei();

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
			this.bindTexture(ONIMAN_TEX);
			oniman.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			break;
		case 1:
			this.bindTexture(KUSAMOTI_TEX);
			moti.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			break;
		case 2:
			this.bindTexture(MACHAROLL_TEX);
			roll.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			break;
		case 3:
			this.bindTexture(HOSIIMO_TEX);
			hosiimo.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			break;
		case 4:
			this.bindTexture(SOYCAKE_TEX);
			cake.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			break;
		case 5:
			this.bindTexture(SENBEI_TEX);
			senbei.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			break;
		case 6:
			this.bindTexture(BROWNIE_TEX);
			hosiimo.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			break;
		case 7:
			this.bindTexture(DAIHUKU_TEX);
			oniman.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			break;
		default:
			this.bindTexture(ONIMAN_TEX);
			oniman.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		}

		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();

	}

}
