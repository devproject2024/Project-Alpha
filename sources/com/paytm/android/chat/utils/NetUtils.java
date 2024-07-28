package com.paytm.android.chat.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetUtils {
    public static final int NO_NET_WORK = 0;
    public static final int NO_WIFI = 2;
    public static final int WIFI = 1;

    public static boolean getIsWifi(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || activeNetworkInfo.getType() != 1) {
            return false;
        }
        return true;
    }

    public static boolean isNetWorkAvailable(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }

    public static int getNetWorkType(Context context) {
        if (!isNetWorkAvailable(context)) {
            return 0;
        }
        if (((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1).isConnectedOrConnecting()) {
            return 1;
        }
        return 2;
    }

    public static boolean isWiFiConnected(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().getType() == 1;
    }

    public static boolean isMobileDataEnable(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(0).isConnectedOrConnecting();
    }

    public static boolean isWifiDataEnable(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1).isConnectedOrConnecting();
    }

    public static void GoSetting(Activity activity) {
        activity.startActivity(new Intent("android.settings.ACCESSIBILITY_SETTINGS"));
    }

    public static void openSetting(Activity activity) {
        Intent intent = new Intent("/");
        intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.WirelessSettings"));
        intent.setAction("android.intent.action.VIEW");
        activity.startActivityForResult(intent, 0);
    }
}
