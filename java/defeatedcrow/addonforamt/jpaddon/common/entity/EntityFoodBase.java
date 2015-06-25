package defeatedcrow.addonforamt.jpaddon.common.entity;

import defeatedcrow.addonforamt.jpaddon.common.entity.FoodType.Deco;
import defeatedcrow.addonforamt.jpaddon.common.entity.FoodType.Dish;
import defeatedcrow.addonforamt.jpaddon.common.entity.FoodType.Soup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import mods.defeatedcrow.common.DCsAppleMilk;
import mods.defeatedcrow.common.entity.edible.PlaceableFoods;

public abstract class EntityFoodBase extends PlaceableFoods implements IFoodType{

	public EntityFoodBase(World world){
    	super(world);
    }

	public EntityFoodBase(World world, ItemStack item) {
		super(world, true, item);
	}

	public EntityFoodBase(World world, ItemStack item,
			double x, double y, double z) {
		super(world, true, item, x, y, z);
	}
	
	public abstract IIcon getSoupIcon(int meta);

}
