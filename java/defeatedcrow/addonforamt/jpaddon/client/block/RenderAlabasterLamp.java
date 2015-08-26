package defeatedcrow.addonforamt.jpaddon.client.block;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;

public class RenderAlabasterLamp extends RenderingHandler {

	private IIcon ironTex;

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		this.ironTex = block.getBlockTextureFromSide(0);

		if (modelID == this.getRenderId()) {
			renderInvCuboid(renderer, block, 0.0F / 16.0F, 0.0F / 16.0F, 0.0F / 16.0F, 16.0F / 16.0F, 16.0F / 16.0F,
					16.0F / 16.0F, this.ironTex);
		}

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId,
			RenderBlocks renderer) {
		int meta = world.getBlockMetadata(x, y, z);
		this.ironTex = block.getBlockTextureFromSide(0);
		if (modelId == this.getRenderId()) {

			renderer.setOverrideBlockTexture(this.ironTex);
			block.setBlockBounds(4.0F / 16.0F, 0.0F / 16.0F, 4.0F / 16.0F, 12.0F / 16.0F, 1.0F / 16.0F, 12.0F / 16.0F);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);

			block.setBlockBounds(6.0F / 16.0F, 1.0F / 16.0F, 6.0F / 16.0F, 10.0F / 16.0F, 2.0F / 16.0F, 10.0F / 16.0F);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);

			block.setBlockBounds(7.5F / 16.0F, 2.0F / 16.0F, 7.5F / 16.0F, 8.5F / 16.0F, 8.0F / 16.0F, 8.5F / 16.0F);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);

			renderer.clearOverrideBlockTexture();
			block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			renderer.setRenderBoundsFromBlock(block);

			return true;
		}
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory(int a) {
		return false;
	}

	@Override
	public int getRenderId() {
		return AddonJPCore.renderLamp;
	}

}
