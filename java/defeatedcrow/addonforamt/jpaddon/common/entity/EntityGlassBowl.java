package defeatedcrow.addonforamt.jpaddon.common.entity;

import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;
import defeatedcrow.addonforamt.jpaddon.common.entity.FoodType.Deco;
import defeatedcrow.addonforamt.jpaddon.common.entity.FoodType.Dish;
import defeatedcrow.addonforamt.jpaddon.common.entity.FoodType.Soup;

public class EntityGlassBowl extends EntityFoodBase {

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
