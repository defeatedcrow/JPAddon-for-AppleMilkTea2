package defeatedcrow.addonforamt.jpaddon.plugin.cleaver;

import net.minecraft.item.ItemStack;

public interface ICleaverAMT {

	CleaverMode getMode(ItemStack stack);

	void setMode(ItemStack stack, CleaverMode mode);

	int getBloodCount(ItemStack stack);

	void addBloodCount(ItemStack stack, int add);

}
