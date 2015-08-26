package defeatedcrow.addonforamt.jpaddon.world;

import java.util.Random;

import mods.defeatedcrow.common.DCsAppleMilk;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.BiomeDictionary;
import cpw.mods.fml.common.IWorldGenerator;
import defeatedcrow.addonforamt.jpaddon.AddonJPCore;

public class WorldGenAJPOres implements IWorldGenerator {

	private int genDim1 = 0;

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGen,
			IChunkProvider chunkProv) {

		genDim1 = world.provider.dimensionId;

		int chunk2X = chunkX << 4;
		int chunk2Z = chunkZ << 4;
		int count = 3;

		if ((genDim1 != 1 && genDim1 != -1)) {
			for (int i = 0; i < count; i++) {
				// 比較的高高度に生成
				int PosX = chunk2X + random.nextInt(16);
				int PosY = 90 + random.nextInt(30);
				int PosZ = chunk2Z + random.nextInt(16);

				BiomeGenBase biome = world.getBiomeGenForCoords(PosX, PosZ);
				boolean suitableBiome = BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.MOUNTAIN)
						|| DCsAppleMilk.debugMode;

				// 生成可能位置
				if (world.getBlock(PosX, PosY, PosZ).getMaterial() == Material.rock && suitableBiome) {
					int range = 2 + random.nextInt(4);
					int range2 = range * 2;
					for (int y = 0; y < range; y++) {
						int genMeta = 1;
						int i2 = range / 2;
						int i3 = random.nextInt(i2);
						if (range > 2 && (y & 1) == 1 && y >= i2) {
							genMeta = 0;
						}
						range2 -= i3;
						for (int x = -range2; x < range2; x++) {
							for (int z = -range2; z < range2; z++) {
								Block b = world.getBlock(PosX + x, PosY + y, PosZ + z);
								double r = Math.sqrt(x * x + z * z);
								Block target = AddonJPCore.ores;
								if (r <= range2
										&& b.isReplaceableOreGen(world, PosX + x, PosY + y, PosZ + z, Blocks.stone)) {
									world.setBlock(PosX + x, PosY + y, PosZ + z, target, genMeta, 2);
								}
							}
						}
					}
				}
			}
		}

	}
}
