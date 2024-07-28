package net.one97.paytm.nativesdk.Utils;

import net.one97.paytm.nativesdk.BuildConfig;

public class LogUtility {
    private static final String TAG_PREFIX = "MERCHANT_SDK";

    public static void i(String str, String str2) {
        boolean z = BuildConfig.DEBUG;
    }

    public static void d(String str, String str2) {
        boolean z = BuildConfig.DEBUG;
    }

    public static void e(String str, String str2) {
        boolean z = BuildConfig.DEBUG;
    }

    public static void printStackTrace(Exception exc) {
        if (BuildConfig.DEBUG && exc != null) {
            exc.getMessage();
        }
    }
}
