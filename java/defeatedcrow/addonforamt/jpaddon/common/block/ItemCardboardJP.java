package defeatedcrow.addonforamt.jpaddon.common.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemCardboardJP extends ItemBlock {

	private static final String[] bagVegi = new String[] {
			"_sansho",
			"_spinach",
			"_strawberry" };

	public ItemCardboardJP(Block block) {
		super(block);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		int m = (par1ItemStack.getItemDamage() & 7);
		if (m < 3)
			return super.getUnlocalizedName() + bagVegi[m];
		else
			return super.getUnlocalizedName() + m;
	}

	@Override
	public int getMetadata(int par1) {
		return par1;
	}
}
