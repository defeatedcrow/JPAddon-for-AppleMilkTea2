package defeatedcrow.addonforamt.jpaddon.client.block;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;

public class RenderBlockDryingRack extends RenderingHandler {

	private IIcon netIcon;
	private IIcon woodIcon;

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		this.netIcon = AddonJPCore.dryingRack.getBlockTextureFromSide(1);
		this.woodIcon = Blocks.planks.getBlockTextureFromSide(0);

		if (modelID == this.getRenderId()) {
			// box
			renderInvCuboid(renderer, block, 2.0F / 16.0F, 6.5F / 16.0F, 2.0F / 16.0F, 14.0F / 16.0F, 7.5F / 16.0F,
					14.0F / 16.0F, this.netIcon);

			float m0 = 0.0F / 16.0F;
			float m2 = 2.0F / 16.0F;
			float m14 = 14.0F / 16.0F;
			float m16 = 16.0F / 16.0F;

			renderInvCuboid(renderer, block, m0, 6.0F / 16.0F, m0, m16, 8.0F / 16.0F, m2, this.woodIcon);
			renderInvCuboid(renderer, block, m0, 6.0F / 16.0F, m14, m16, 8.0F / 16.0F, m16, this.woodIcon);
			renderInvCuboid(renderer, block, m0, 6.0F / 16.0F, m2, m2, 8.0F / 16.0F, m14, this.woodIcon);
			renderInvCuboid(renderer, block, m14, 6.0F / 16.0F, m2, m16, 8.0F / 16.0F, m14, this.woodIcon);

			renderInvCuboid(renderer, block, m0, 0.0F / 16.0F, m0, m2, 6.0F / 16.0F, m2, this.woodIcon);
			renderInvCuboid(renderer, block, m14, 0.0F / 16.0F, m0, m16, 6.0F / 16.0F, m2, this.woodIcon);
			renderInvCuboid(renderer, block, m0, 0.0F / 16.0F, m14, m2, 6.0F / 16.0F, m16, this.woodIcon);
			renderInvCuboid(renderer, block, m14, 0.0F / 16.0F, m14, m16, 6.0F / 16.0F, m16, this.woodIcon);
		}

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId,
			RenderBlocks renderer) {
		this.netIcon = AddonJPCore.dryingRack.getBlockTextureFromSide(1);
		this.woodIcon = Blocks.planks.getBlockTextureFromSide(0);

		float m0 = 0.0F / 16.0F;
		float m2 = 2.0F / 16.0F;
		float m14 = 14.0F / 16.0F;
		float m16 = 16.0F / 16.0F;

		float y6 = 6.0F / 16.0F;
		float y8 = 8.0F / 16.0F;

		if (modelId == this.getRenderId()) {
			// box
			renderer.setOverrideBlockTexture(this.netIcon);
			block.setBlockBounds(m2, 6.5F / 16.0F, m2, m14, 7.5F / 16.0F, m14);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);

			// base
			renderer.setOverrideBlockTexture(this.woodIcon);
			block.setBlockBounds(m0, y6, m0, m16, y8, m2);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);

			renderer.setOverrideBlockTexture(this.woodIcon);
			block.setBlockBounds(m0, y6, m14, m16, y8, m16);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);

			renderer.setOverrideBlockTexture(this.woodIcon);
			block.setBlockBounds(m0, y6, m2, m2, y8, m14);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);

			renderer.setOverrideBlockTexture(this.woodIcon);
			block.setBlockBounds(m14, y6, m2, m16, y8, m14);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);

			renderer.setOverrideBlockTexture(this.woodIcon);
			block.setBlockBounds(m0, 0.0F, m0, m2, y6, m2);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);

			renderer.setOverrideBlockTexture(this.woodIcon);
			block.setBlockBounds(m0, 0.0F, m14, m2, y6, m16);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);

			renderer.setOverrideBlockTexture(this.woodIcon);
			block.setBlockBounds(m14, 0.0F, m0, m16, y6, m2);
			renderer.setRenderBoundsFromBlock(block);
			renderer.renderStandardBlock(block, x, y, z);

			renderer.setOverrideBlockTexture(this.woodIcon);
			block.setBlockBounds(m14, 0.0F, m14, m16, y6, m16);
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
		return true;
	}

	@Override
	public int getRenderId() {
		return AddonJPCore.renderNum1;
	}

}
