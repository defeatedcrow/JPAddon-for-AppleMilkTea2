package defeatedcrow.addonforamt.jpaddon;

import mods.defeatedcrow.common.DCsAppleMilk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AJPLogger {

	public static Logger logger = LogManager.getLogger("AMTAddonJP");

	public static void debugInfo(String msg) {
		if (DCsAppleMilk.debugMode) {
			AJPLogger.logger.info("Debug: " + msg);
		}
	}

	public static void debugTrace(String msg) {
		if (DCsAppleMilk.debugMode) {
			AJPLogger.logger.debug("Debug: " + msg);
		}
	}

	public static void loadingModInfo(String modid) {
		AJPLogger.logger.trace("Now checking other mod :" + modid);
	}

	public static void loadedModInfo(String modid) {
		AJPLogger.logger.trace("Succeeded to check other mod :" + modid);
	}

	public static void failLoadingModInfo(String modid) {
		AJPLogger.logger.error("Failed to check other mod :" + modid);
	}

}
