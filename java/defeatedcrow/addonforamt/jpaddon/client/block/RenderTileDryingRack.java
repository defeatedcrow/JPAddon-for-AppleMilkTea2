package defeatedcrow.addonforamt.jpaddon.client.block;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import defeatedcrow.addonforamt.jpaddon.common.block.TileDryingRack;

@SideOnly(Side.CLIENT)
public class RenderTileDryingRack extends TileEntitySpecialRenderer {
	public static RenderTileDryingRack thisRenderer;

	public void renderTileEntityCaseAt(TileDryingRack par1Tile, double par2, double par4, double par6, float par8) {
		this.setRotation(par1Tile, (float) par2, (float) par4, (float) par6);
	}

	public void setTileEntityRenderer(TileEntityRendererDispatcher par1TileEntityRenderer) {
		super.func_147497_a(par1TileEntityRenderer);
		thisRenderer = this;
	}

	public void setRotation(TileDryingRack par0Tile, float par1, float par2, float par3) {
		// inner
		if (par0Tile.getWorldObj() != null) {
			GL11.glPushMatrix();
			GL11.glTranslatef(par1 + 0.25F, par2 + 0.55F, par3 + 0.25F);
			GL11.glRotatef(0.0F, 0.0F, 0.0F, 0.0F);
			this.renderInner(par0Tile, 0);
			GL11.glPopMatrix();

			GL11.glPushMatrix();
			GL11.glTranslatef(par1 + 0.25F, par2 + 0.55F, par3 + 0.75F);
			GL11.glRotatef(0.0F, 0.0F, 0.0F, 0.0F);
			this.renderInner(par0Tile, 1);
			GL11.glPopMatrix();

			GL11.glPushMatrix();
			GL11.glTranslatef(par1 + 0.75F, par2 + 0.55F, par3 + 0.25F);
			GL11.glRotatef(0.0F, 0.0F, 0.0F, 0.0F);
			this.renderInner(par0Tile, 2);
			GL11.glPopMatrix();

			GL11.glPushMatrix();
			GL11.glTranslatef(par1 + 0.75F, par2 + 0.55F, par3 + 0.75F);
			GL11.glRotatef(0.0F, 0.0F, 0.0F, 0.0F);
			this.renderInner(par0Tile, 3);
			GL11.glPopMatrix();
		}
	}

	private void renderInner(TileDryingRack tile, int i) {
		ItemStack in = tile.getStackInSlot(i);
		ItemStack out = tile.getStackInSlot(i + 4);
		ItemStack item = null;

		if (out != null) {
			item = out.copy();
		} else if (in != null) {
			item = in.copy();
		}

		if (item != null) {
			EntityItem entityitem = new EntityItem(tile.getWorldObj(), 0.0D, 0.0D, 0.0D, item);
			entityitem.getEntityItem().stackSize = 1;
			entityitem.hoverStart = 0.0F;

			if (item.getItem() instanceof ItemBlock) {
				GL11.glScalef(1.0F, 1.0F, 1.0F);
			} else {
				GL11.glScalef(0.75F, 0.75F, 0.75F);
			}

			RenderItem.renderInFrame = false;
			RenderManager.instance.renderEntityWithPosYaw(entityitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
			RenderItem.renderInFrame = false;
		}
	}

	@Override
	public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8) {
		this.renderTileEntityCaseAt((TileDryingRack) par1TileEntity, par2, par4, par6, par8);
	}
}
