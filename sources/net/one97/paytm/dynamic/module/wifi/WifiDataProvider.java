package net.one97.paytm.dynamic.module.wifi;

import android.content.Context;
import android.content.Intent;
import net.one97.paytm.wifi.a;
import net.one97.paytm.wifi.ui.WiFiHomeActivity;

public class WifiDataProvider {
    public static void initWifiModule(Context context) {
        WifiJarvisHelper instance = WifiJarvisHelper.getInstance();
        if (a.f21067a == null) {
            a.f21067a = new a();
        }
        a.f21067a.f21068b = instance;
    }

    public static Intent getWiFiHomeActivityIntent(Context context) {
        return new Intent(context, WiFiHomeActivity.class);
    }

    public static String getWiFiHomeActivityName() {
        return WiFiHomeActivity.class.getName();
    }
}
