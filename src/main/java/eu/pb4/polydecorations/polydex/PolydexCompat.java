package eu.pb4.polydecorations.polydex;

import net.fabricmc.loader.api.FabricLoader;

import static eu.pb4.polydecorations.ModInit.LOGGER;

public class PolydexCompat {
    private static final boolean IS_PRESENT = FabricLoader.getInstance().isModLoaded("polydex2");


    public static void register() {
        if (IS_PRESENT) {
            PolydexCompatImpl.register();
        } else {
            LOGGER.info("Polydex not found, skipping compatibility registration");
        }
    }
}
