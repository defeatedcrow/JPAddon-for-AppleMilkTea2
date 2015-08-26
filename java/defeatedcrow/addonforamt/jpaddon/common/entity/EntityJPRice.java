package defeatedcrow.addonforamt.jpaddon.common.entity;

import mods.defeatedcrow.common.base.FoodBaseEntity;
import mods.defeatedcrow.common.base.FoodModelType.Deco;
import mods.defeatedcrow.common.base.FoodModelType.Dish;
import mods.defeatedcrow.common.base.FoodModelType.Soup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;

public class EntityJPRice extends FoodBaseEntity {

	public EntityJPRice(World world) {
		super(world);
	}

	public EntityJPRice(World world, ItemStack item) {
		super(world, item);
	}

	public EntityJPRice(World world, ItemStack item, double x, double y, double z) {
		super(world, item, x, y, z);
	}

	@Override
	public Soup getSoupType() {
		return Soup.Rice;
	}

	@Override
	public Deco getDecoType() {
		return Deco.SoupInner;
	}

	@Override
	public Dish getDishType() {
		return Dish.RiceBowl;
	}

	@Override
	public IIcon getSoupIcon(int meta) {
		return AddonJPCore.riceBowls.getIconFromDamage(meta + 16);
	}

	@Override
	protected ItemStack returnItem() {
		return new ItemStack(AddonJPCore.riceBowls, 1, this.getItemMetadata());
	}

}
