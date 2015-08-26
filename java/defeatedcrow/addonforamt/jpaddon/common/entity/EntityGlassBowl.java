package defeatedcrow.addonforamt.jpaddon.common.entity;

import mods.defeatedcrow.common.base.FoodBaseEntity;
import mods.defeatedcrow.common.base.FoodModelType.Deco;
import mods.defeatedcrow.common.base.FoodModelType.Dish;
import mods.defeatedcrow.common.base.FoodModelType.Soup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;

public class EntityGlassBowl extends FoodBaseEntity {

	public EntityGlassBowl(World world) {
		super(world);
	}

	public EntityGlassBowl(World world, ItemStack item) {
		super(world, item);
	}

	public EntityGlassBowl(World world, ItemStack item, double x, double y, double z) {
		super(world, item, x, y, z);
	}

	@Override
	public Soup getSoupType() {
		return Soup.None;
	}

	@Override
	public Deco getDecoType() {
		return Deco.Kobathi;
	}

	@Override
	public Dish getDishType() {
		return Dish.Glass;
	}

	@Override
	public IIcon getSoupIcon(int meta) {
		return null;
	}

	@Override
	protected ItemStack returnItem() {
		return new ItemStack(AddonJPCore.glassDish, 1, this.getItemMetadata());
	}

}
