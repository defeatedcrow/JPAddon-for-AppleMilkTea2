package defeatedcrow.addonforamt.jpaddon.client.block;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import defeatedcrow.addonforamt.jpaddon.AddonJPCore;

public class RenderOres extends RenderingHandler {

	private IIcon oreTex;
	private IIcon stoneTex;

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		this.oreTex = AddonJPCore.ores.getIcon(0, metadata);
		this.stoneTex = Blocks.stone.getBlockTextureFromSide(0);

		if (modelID == this.getRenderId()) {
			renderInvCuboid(renderer, block, 0.01F / 16.0F, 0.01F / 16.0F, 0.01F / 16.0F, 15.99F / 16.0F,
					15.99F / 16.0F, 15.99F / 16.0F, this.stoneTex);
			renderInvCuboid(renderer, block, 0.0F / 16.0F, 0.0F / 16.0F, 0.0F / 16.0F, 16.0F / 16.0F, 16.0F / 16.0F,
					16.0F / 16.0F, this.oreTex);
		}

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId,
			RenderBlocks renderer) {
		int meta = world.getBlockMetadata(x, y, z);
		this.oreTex = AddonJPCore.ores.getIcon(0, meta);
		this.stoneTex = Blocks.stone.getBlockTextureFromSide(0);
		if (modelId == this.getRenderId()) {
			// renderer.setOverrideBlockTexture(this.stoneTex);
			// block.setBlockBounds(0.01F / 16.0F, 0.01F / 16.0F, 0.01F / 16.0F, 15.99F / 16.0F,
			// 15.99F / 16.0F,
			// 15.99F / 16.0F);
			// renderer.setRenderBoundsFromBlock(block);
			// renderer.renderStandardBlock(block, x, y, z);
			// renderer.renderAllFaces = true;
			//
			// renderer.setOverrideBlockTexture(this.oreTex);
			// block.setBlockBounds(0.0F / 16.0F, 0.0F / 16.0F, 0.0F / 16.0F, 16.0F / 16.0F, 16.0F /
			// 16.0F, 16.0F / 16.0F);
			// renderer.setRenderBoundsFromBlock(block);
			// renderer.renderStandardBlock(block, x, y, z);
			//
			// renderer.renderAllFaces = false;
			// renderer.clearOverrideBlockTexture();
			// block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			// renderer.setRenderBoundsFromBlock(block);

			GL11.glPushMatrix();
			renderer.renderStandardBlock(Blocks.stone, x, y, z);
			GL11.glPopMatrix();
			GL11.glPushMatrix();
			renderer.renderStandardBlock(block, x, y, z);
			GL11.glPopMatrix();
			return true;
		}
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory(int a) {
		return true;
	}

	@Override
	public int getRenderId() {
		return AddonJPCore.renderOres;
	}

}
