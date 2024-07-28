package net.one97.paytm.deeplink;

import net.one97.paytm.dynamicModule.DynamicModuleManager;

public class FlightUtils {
    public static String DYNAMIC_MODULE_FLIGHT = "flight_dynamic";

    public static boolean isFlightInstalled() {
        return DynamicModuleManager.getInstance().isInstalled(DYNAMIC_MODULE_FLIGHT);
    }
}
