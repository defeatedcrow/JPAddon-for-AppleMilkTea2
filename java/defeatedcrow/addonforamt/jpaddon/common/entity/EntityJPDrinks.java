package defeatedcrow.addonforamt.jpaddon.common.entity;

import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;
import defeatedcrow.addonforamt.jpaddon.common.entity.FoodType.Deco;
import defeatedcrow.addonforamt.jpaddon.common.entity.FoodType.Dish;
import defeatedcrow.addonforamt.jpaddon.common.entity.FoodType.Soup;

public class EntityJPDrinks extends EntityFoodBase {

	public EntityJPDrinks(World world) {
		super(world);
	}

	public EntityJPDrinks(World world, ItemStack item) {
		super(world, item);
	}

	public EntityJPDrinks(World world, ItemStack item, double x, double y, double z) {
		super(world, item, x, y, z);
	}

	@Override
	public Soup getSoupType() {
		return Soup.Drink;
	}

	@Override
	public Deco getDecoType() {
		return Deco.None;
	}

	@Override
	public Dish getDishType() {
		return Dish.Mag;
	}

	@Override
	public IIcon getSoupIcon(int meta) {
		return AddonJPCore.jpDrinks.getIconFromDamage(meta + 16);
	}

	@Override
	protected ItemStack returnItem() {
		return new ItemStack(AddonJPCore.jpDrinks, 1, this.getItemMetadata());
	}

}
