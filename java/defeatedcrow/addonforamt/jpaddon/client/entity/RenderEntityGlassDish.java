package defeatedcrow.addonforamt.jpaddon.client.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import defeatedcrow.addonforamt.jpaddon.client.model.inner.ModelKobati;
import defeatedcrow.addonforamt.jpaddon.common.entity.EntityFoodBase;
import defeatedcrow.addonforamt.jpaddon.common.entity.FoodType.Deco;

public class RenderEntityGlassDish extends JPRenderEntityBase {

	protected static final ResourceLocation NAMASU_TEX = new ResourceLocation(
			"amtjp:textures/entity/foods/k_namasu.png");
	protected static final ResourceLocation TAKENOKO_TEX = new ResourceLocation(
			"amtjp:textures/entity/foods/k_takenoko.png");
	protected static final ResourceLocation SIGURENI_TEX = new ResourceLocation(
			"amtjp:textures/entity/foods/k_sigureni.png");
	protected static final ResourceLocation OKAKAAE_TEX = new ResourceLocation(
			"amtjp:textures/entity/foods/k_okakaae.png");
	protected static final ResourceLocation SIOKARA_TEX = new ResourceLocation(
			"amtjp:textures/entity/foods/k_siokara.png");
	protected static final ResourceLocation NAMEROU_TEX = new ResourceLocation(
			"amtjp:textures/entity/foods/k_namerou.png");
	protected static final ResourceLocation POTESARA_TEX = new ResourceLocation(
			"amtjp:textures/entity/foods/k_potesara.png");

	private ModelKobati model = new ModelKobati();

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
			this.bindTexture(NAMASU_TEX);
			break;
		case 1:
			this.bindTexture(TAKENOKO_TEX);
			break;
		case 2:
			this.bindTexture(SIGURENI_TEX);
			break;
		case 3:
			this.bindTexture(OKAKAAE_TEX);
			break;
		case 4:
			this.bindTexture(SIOKARA_TEX);
			break;
		case 5:
			this.bindTexture(NAMEROU_TEX);
			break;
		case 6:
			this.bindTexture(POTESARA_TEX);
			break;
		default:
			this.bindTexture(NAMASU_TEX);
		}

		model.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();

	}

}
