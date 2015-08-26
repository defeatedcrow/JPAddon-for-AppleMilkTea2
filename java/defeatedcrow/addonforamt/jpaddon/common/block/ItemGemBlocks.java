package defeatedcrow.addonforamt.jpaddon.common.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemGemBlocks extends ItemBlock {

	private static final String[] gems = new String[] {
			"salt",
			"alabaster",
			"smooth_salt",
			"smooth_alabaster" };

	public ItemGemBlocks(Block block) {
		super(block);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		int m = (par1ItemStack.getItemDamage() & 7);
		if (m < 4)
			return super.getUnlocalizedName() + "_" + gems[m];
		else
			return super.getUnlocalizedName() + "_" + m;
	}

	@Override
	public int getMetadata(int par1) {
		return par1;
	}
}
