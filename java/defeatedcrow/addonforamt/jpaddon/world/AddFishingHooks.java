package defeatedcrow.addonforamt.jpaddon.world;

import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomFishable;
import net.minecraftforge.common.FishingHooks;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;

public class AddFishingHooks {

	private AddFishingHooks() {
	}

	public static void addFishing() {
		FishingHooks.addFish(new WeightedRandomFishable(new ItemStack(AddonJPCore.fishes, 1, 0), 20));
	}

}
