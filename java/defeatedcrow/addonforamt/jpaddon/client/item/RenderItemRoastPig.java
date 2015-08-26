package defeatedcrow.addonforamt.jpaddon.client.item;

import net.minecraft.client.model.ModelPig;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

public class RenderItemRoastPig implements IItemRenderer {

	protected static final ResourceLocation RAW_TEX = new ResourceLocation("amtjp:textures/entity/foods/rawpig.png");
	protected static final ResourceLocation ROAST_TEX = new ResourceLocation("amtjp:textures/entity/foods/roastpig.png");

	private ModelPig model = new ModelPig();

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return canRendering(item, type);
	}

	private boolean canRendering(ItemStack item, ItemRenderType type) {
		switch (type) {
		case ENTITY:
		case EQUIPPED:
		case EQUIPPED_FIRST_PERSON:
		case INVENTORY:
			return true;
		default:
			return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		switch (helper) {
		case INVENTORY_BLOCK:
		case ENTITY_BOBBING:
		case ENTITY_ROTATION:
			return true;
		default:
			return false;
		}
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		if (canRendering(item, type)) {

			GL11.glPushMatrix();
			/*
			 * 描画する種類によって回転, 平行移動を行う.
			 */
			switch (type) {
			case INVENTORY:
				glMatrixForRenderInInventory();
				break;
			case EQUIPPED:
			case EQUIPPED_FIRST_PERSON:
				glMatrixForRenderInEquipped();
				break;
			case ENTITY:
				glMatrixForRenderInEntity();
			default:
				break;
			}
			/*
			 * リソースをTextureMangerにbindし, modelのrenderを呼んで描画する.
			 */

			int meta = 0;
			if (item != null) {
				meta = item.getItemDamage();
			}

			switch (meta) {
			case 0:
				FMLClientHandler.instance().getClient().getTextureManager().bindTexture(RAW_TEX);
				break;
			case 1:
				FMLClientHandler.instance().getClient().getTextureManager().bindTexture(ROAST_TEX);
				break;
			default:
				FMLClientHandler.instance().getClient().getTextureManager().bindTexture(RAW_TEX);

			}

			model.isChild = false;
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			model.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
		}
	}

	/*
	 * インベントリ内での描画位置の調整.
	 */
	private void glMatrixForRenderInInventory() {
		GL11.glRotatef(-180F, 1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(0.0F, -1.0F, 0.0F);
	}

	/*
	 * 装備状態での描画位置の調整.
	 */
	private void glMatrixForRenderInEquipped() {
		GL11.glRotatef(-210F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(-0F, 0.0F, 1.0F, 0.0F);
		GL11.glScalef(1.2F, 1.2F, 1.2F);
		GL11.glTranslatef(0.4F, -1.0F, -0.15F);
	}

	/*
	 * ドロップ状態での描画位置の調整.
	 */
	private void glMatrixForRenderInEntity() {
		GL11.glRotatef(-180F, 1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(0.0F, -1.5F, 0.0F);
	}

}
