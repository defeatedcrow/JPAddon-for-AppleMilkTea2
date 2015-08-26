package defeatedcrow.addonforamt.jpaddon.client.block;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;

public class RenderAlabasterChandelier extends RenderingHandler {

	private IIcon ironTex;
	private IIcon chainTex;

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
		this.chainTex = block.getBlockTextureFromSide(2);
		if (modelId == this.getRenderId()) {

			boolean sol = world.isSideSolid(x, y + 1, z, ForgeDirection.DOWN, false);

			if (sol) {
				renderer.setOverrideBlockTexture(this.ironTex);
				block.setBlockBounds(7.0F / 16.0F, 15.0F / 16.0F, 7.0F / 16.0F, 9.0F / 16.0F, 16.0F / 16.0F,
						9.0F / 16.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.renderStandardBlock(block, x, y, z);
			}

			renderer.setOverrideBlockTexture(this.chainTex);
			block.setBlockBounds(0.0F / 16.0F, 0.0F / 16.0F, 0.0F / 16.0F, 16.0F / 16.0F, 16.0F / 16.0F, 16.0F / 16.0F);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderCrossedSquares(block, x, y, z);

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
		return AddonJPCore.renderChandelier;
	}

}
