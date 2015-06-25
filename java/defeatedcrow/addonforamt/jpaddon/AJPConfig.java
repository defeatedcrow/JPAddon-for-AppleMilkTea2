package defeatedcrow.addonforamt.jpaddon;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class AJPConfig {

	public static int entityIdJPDish = 0;
	public static int entityIdJPSweets = 1;
	public static int entityIdkobatiDish = 2;
	public static int entityIdglassDish = 3;
	public static int entityIdwhiteDish = 4;

	public static int potionLuckID = 90;

	private final String BR = System.getProperty("line.separator");

	public static void config(Configuration cfg) {

		try {
			cfg.load();

			cfg.addCustomCategoryComment("potionID",
					"Set new potion ID for this mod. These must be bigger than 32, and smaller than 127.");

			Property luckID = cfg.get("potionID", "Luck", potionLuckID);
			potionLuckID = luckID.getInt();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cfg.save();
		}
	}

}
