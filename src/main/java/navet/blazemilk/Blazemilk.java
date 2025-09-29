package navet.blazemilk;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Blazemilk implements ModInitializer {
	public static final String MOD_ID = "blazemilk";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Blazemilk loaded!");
	}
}