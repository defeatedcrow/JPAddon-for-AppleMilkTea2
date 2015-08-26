package defeatedcrow.addonforamt.jpaddon.client.entity;

import mods.defeatedcrow.client.entity.base.RenderFoodEntityBase;
import mods.defeatedcrow.common.base.FoodBaseEntity;
import mods.defeatedcrow.common.base.FoodModelType.Deco;
import net.minecraft.util.ResourceLocation;

public class RenderEntityGlassDish extends RenderFoodEntityBase {

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

	@Override
	protected ResourceLocation getDecoTexture(FoodBaseEntity entity, byte meta, Deco deco) {

		switch (meta) {
		case 0:
			return NAMASU_TEX;
		case 1:
			return TAKENOKO_TEX;
		case 2:
			return SIGURENI_TEX;
		case 3:
			return OKAKAAE_TEX;
		case 4:
			return SIOKARA_TEX;
		case 5:
			return NAMEROU_TEX;
		case 6:
			return POTESARA_TEX;
		default:
			return NAMASU_TEX;
		}
	}

}
