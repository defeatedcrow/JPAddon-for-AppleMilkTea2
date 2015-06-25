package defeatedcrow.addonforamt.jpaddon.common.entity;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;

public class EntityJPRice_JP extends EntityJPRice {

	public EntityJPRice_JP(World world) {
		super(world);
	}

	public EntityJPRice_JP(World world, ItemStack item) {
		super(world, item);
	}

	public EntityJPRice_JP(World world, ItemStack item, double x, double y, double z) {
		super(world, item, x, y, z);
	}

	@Override
	protected ItemStack returnItem() {
		return new ItemStack(AddonJPCore.riceBowls_jp, 1, this.getItemMetadata());
	}

}
