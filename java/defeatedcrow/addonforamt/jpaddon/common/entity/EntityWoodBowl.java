package defeatedcrow.addonforamt.jpaddon.common.entity;

import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;
import defeatedcrow.addonforamt.jpaddon.common.entity.FoodType.Deco;
import defeatedcrow.addonforamt.jpaddon.common.entity.FoodType.Dish;
import defeatedcrow.addonforamt.jpaddon.common.entity.FoodType.Soup;

public class EntityWoodBowl extends EntityFoodBase {

	public EntityWoodBowl(World world) {
		super(world);
	}

	public EntityWoodBowl(World world, ItemStack item) {
		super(world, item);
	}

	public EntityWoodBowl(World world, ItemStack item, double x, double y, double z) {
		super(world, item, x, y, z);
	}

	@Override
	public Soup getSoupType() {
		return Soup.WoodSoup;
	}

	@Override
	public Deco getDecoType() {
		return Deco.SoupInner;
	}

	@Override
	public Dish getDishType() {
		return Dish.WoodBowl;
	}

	@Override
	public IIcon getSoupIcon(int meta) {
		return AddonJPCore.woodBowls.getIconFromDamage(meta + 8);
	}

	@Override
	protected ItemStack returnItem() {
		return new ItemStack(AddonJPCore.woodBowls, 1, this.getItemMetadata());
	}

}
