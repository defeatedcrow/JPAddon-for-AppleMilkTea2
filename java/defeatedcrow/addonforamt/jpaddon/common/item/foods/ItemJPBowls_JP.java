package defeatedcrow.addonforamt.jpaddon.common.item.foods;

import mods.defeatedcrow.plugin.LoadBambooPlugin;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import defeatedcrow.addonforamt.jpaddon.common.entity.EntityJPBowl_JP;

public class ItemJPBowls_JP extends ItemJPBowls {

	public ItemJPBowls_JP() {
		super();
		this.setContainerItem(Items.bowl);
		if (!LoadBambooPlugin.getBasket().isEmpty() && LoadBambooPlugin.getBasket().get(0) != null) {
			setContainerItem(LoadBambooPlugin.getBasket().get(0).getItem());
		} else {
			setContainerItem(Items.bowl);
		}
	}

	@Override
	public ItemStack getReturnContainer(int meta) {

		return (!LoadBambooPlugin.getBasket().isEmpty() && LoadBambooPlugin.getBasket().get(0) != null) ? LoadBambooPlugin
				.getBasket().get(0).copy()
				: new ItemStack(Items.bowl, 1, 0);
	}

	@Override
	protected boolean spownEntityFoods(World world, EntityPlayer player, ItemStack item, double x, double y, double z) {
		EntityJPBowl_JP entity = new EntityJPBowl_JP(world, item, x, y, z);
		entity.rotationYaw = player.rotationYaw - 180.0F;

		if (!world.isRemote && item != null) {
			return world.spawnEntityInWorld(entity);
		}
		return false;
	}
}
