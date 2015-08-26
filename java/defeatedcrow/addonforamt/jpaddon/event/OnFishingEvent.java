package defeatedcrow.addonforamt.jpaddon.event;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;

public class OnFishingEvent {

	@SubscribeEvent
	public void onSpawnEvent(EntityJoinWorldEvent event) {
		Entity entity = event.entity;
		World world = event.world;

		if (!world.isRemote && entity != null && entity instanceof EntityItem) {
			EntityItem drop = (EntityItem) entity;
			ItemStack item = drop.getEntityItem();
			if (item == null || item.getItem() == null) {
				return;
			}

			if (item.getItem() == AddonJPCore.fishes && item.getItemDamage() == 0) {
				int x = MathHelper.floor_double(entity.posX);
				int z = MathHelper.floor_double(entity.posZ);
				BiomeGenBase biome = world.getBiomeGenForCoords(x, z);
				if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.OCEAN)) {
					drop.setEntityItemStack(new ItemStack(AddonJPCore.fishes, 1, 2));
				} else if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.BEACH)) {
					drop.setEntityItemStack(new ItemStack(AddonJPCore.fishes, 1, 3));
				} else if (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.RIVER)
						|| BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.SWAMP)) {
					drop.setEntityItemStack(new ItemStack(AddonJPCore.fishes, 1, 1));
				} else {
					drop.setEntityItemStack(new ItemStack(Items.fish, 1, 0));
				}
			}
		}

	}

}
