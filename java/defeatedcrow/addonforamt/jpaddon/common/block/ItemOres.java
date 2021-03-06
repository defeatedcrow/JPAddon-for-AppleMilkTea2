package defeatedcrow.addonforamt.jpaddon.common.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemOres extends ItemBlock {

	private static final String[] gems = new String[] {
			"_salt",
			"_alabaster" };

	public ItemOres(Block block) {
		super(block);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		int m = (par1ItemStack.getItemDamage() & 7);
		if (m < 2)
			return super.getUnlocalizedName() + gems[m];
		else
			return super.getUnlocalizedName() + m;
	}

	@Override
	public int getMetadata(int par1) {
		return par1;
	}
}
