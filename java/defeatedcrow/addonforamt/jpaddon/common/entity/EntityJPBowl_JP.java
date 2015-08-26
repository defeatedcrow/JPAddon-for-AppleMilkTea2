package defeatedcrow.addonforamt.jpaddon.common.entity;

import mods.defeatedcrow.common.base.FoodModelType.Deco;
import mods.defeatedcrow.common.base.FoodModelType.Dish;
import mods.defeatedcrow.common.base.FoodModelType.Soup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;

public class EntityJPBowl_JP extends EntityJPBowl {

	public EntityJPBowl_JP(World world) {
		super(world);
	}

	public EntityJPBowl_JP(World world, ItemStack item) {
		super(world, item);
	}

	public EntityJPBowl_JP(World world, ItemStack item, double x, double y, double z) {
		super(world, item, x, y, z);
	}

	@Override
	public Soup getSoupType() {
		return Soup.Soup;
	}

	@Override
	public Deco getDecoType() {
		return Deco.SoupInner;
	}

	@Override
	public Dish getDishType() {
		return Dish.SoupBowl;
	}

	@Override
	protected ItemStack returnItem() {
		return new ItemStack(AddonJPCore.jpBowls_jp, 1, this.getItemMetadata());
	}

}
