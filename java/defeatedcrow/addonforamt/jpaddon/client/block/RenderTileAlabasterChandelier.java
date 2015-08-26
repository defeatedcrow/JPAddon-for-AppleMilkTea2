package defeatedcrow.addonforamt.jpaddon.client.block;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import defeatedcrow.addonforamt.jpaddon.client.model.tile.ModelAlabasterChandelier;
import defeatedcrow.addonforamt.jpaddon.common.block.TileChandelier;

@SideOnly(Side.CLIENT)
public class RenderTileAlabasterChandelier extends TileEntitySpecialRenderer {

	private static final ResourceLocation thisTex = new ResourceLocation(
			"amtjp:textures/entity/tiles/chandelier_alabaster.png");
	public static RenderTileAlabasterChandelier renderer;
	private ModelAlabasterChandelier model = new ModelAlabasterChandelier();

	public void renderTileEntitySteakAt(TileChandelier par1Tile, double par2, double par4, double par6, float par8) {
		this.setRotation(par1Tile, (float) par2, (float) par4, (float) par6);
	}

	public void setTileEntityRenderer(TileEntityRendererDispatcher par1TileEntityRenderer) {
		super.func_147497_a(par1TileEntityRenderer);
		renderer = this;
	}

	public void setRotation(TileChandelier par0Tile, float par1, float par2, float par3) {
		byte m = (byte) par0Tile.getBlockMetadata();
		this.bindTexture(thisTex);

		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glColor4f(2.0F, 2.0F, 2.0F, 1.0F);
		GL11.glTranslatef(par1 + 0.5F, par2 + 1.125F, par3 + 0.5F);
		GL11.glScalef(1.0F, -1.0F, -1.0F);
		GL11.glRotatef(0.0F, 0.0F, 0.0F, 0.0F);
		model.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

		for (int i = 0; i < 4; i++) {
			GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
			model.renderPetal2((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
			model.renderPetal1((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		}

		GL11.glRotatef(0.0F, 0.0F, 0.0F, 0.0F);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();

		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glColor4f(2.0F, 2.0F, 2.0F, 1.0F);
		GL11.glTranslatef(par1 + 0.5F, par2 + 1.125F, par3 + 0.5F);
		GL11.glScalef(1.0F, -1.0F, -1.0F);
		GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);

		for (int i = 0; i < 4; i++) {
			GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
			model.renderLamps((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		}

		GL11.glRotatef(0.0F, 0.0F, 0.0F, 0.0F);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
	}

	@Override
	public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8) {
		this.renderTileEntitySteakAt((TileChandelier) par1TileEntity, par2, par4, par6, par8);
	}
}
