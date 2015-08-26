package defeatedcrow.addonforamt.jpaddon.client.entity;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import defeatedcrow.addonforamt.jpaddon.common.entity.WindProjectile;

@SideOnly(Side.CLIENT)
public class RenderWindProjectile extends Render {

	// 仮
	private static final ResourceLocation tex = new ResourceLocation("defeatedcrow:textures/entity/kinoko_red.png");

	@Override
	public void doRender(Entity par1Entity, double posX, double posY, double posZ, float round, float yaw) {
		// なにもしない
	}

	protected ResourceLocation getStunTextures(WindProjectile par1Entity) {
		return tex;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getStunTextures((WindProjectile) entity);
	}

}
