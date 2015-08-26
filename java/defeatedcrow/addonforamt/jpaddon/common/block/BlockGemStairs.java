package defeatedcrow.addonforamt.jpaddon.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class BlockGemStairs extends BlockStairs {

	public BlockGemStairs(Block block, int meta) {
		super(block, meta);
		this.setLightOpacity(0);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

}
