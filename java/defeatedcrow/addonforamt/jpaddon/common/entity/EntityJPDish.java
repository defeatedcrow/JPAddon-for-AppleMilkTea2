package defeatedcrow.addonforamt.jpaddon.common.entity;

import mods.defeatedcrow.common.base.FoodBaseEntity;
import mods.defeatedcrow.common.base.FoodModelType.Deco;
import mods.defeatedcrow.common.base.FoodModelType.Dish;
import mods.defeatedcrow.common.base.FoodModelType.Soup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;

public class EntityJPDish extends FoodBaseEntity {

	public EntityJPDish(World world) {
		super(world);
	}

	public EntityJPDish(World world, ItemStack item) {
		super(world, item);
	}

	public EntityJPDish(World world, ItemStack item, double x, double y, double z) {
		super(world, item, x, y, z);
	}

	@Override
	public Soup getSoupType() {
		return Soup.None;
	}

	@Override
	public Deco getDecoType() {
		return Deco.None;
	}

	@Override
	public Dish getDishType() {
		return Dish.Obon;
	}

	@Override
	public IIcon getSoupIcon(int meta) {
		return null;
	}

	@Override
	protected ItemStack returnItem() {
		return new ItemStack(AddonJPCore.jpDish, 1, this.getItemMetadata());
	}

}
