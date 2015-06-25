package defeatedcrow.addonforamt.jpaddon.common.entity;

import defeatedcrow.addonforamt.jpaddon.AddonJPCore;
import defeatedcrow.addonforamt.jpaddon.common.entity.FoodType.Deco;
import defeatedcrow.addonforamt.jpaddon.common.entity.FoodType.Dish;
import defeatedcrow.addonforamt.jpaddon.common.entity.FoodType.Soup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class EntityJPDish extends EntityFoodBase {

	public EntityJPDish(World world){
    	super(world);
    }

	public EntityJPDish(World world, ItemStack item) {
		super(world, item);
	}

	public EntityJPDish(World world, ItemStack item,
			double x, double y, double z) {
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
