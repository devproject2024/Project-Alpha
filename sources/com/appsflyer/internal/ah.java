package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;

public final class ah {

    /* renamed from: Ι  reason: contains not printable characters */
    private static String f181;

    /* renamed from: ι  reason: contains not printable characters */
    private static String f182;

    ah() {
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    public static void m136(String str) {
        f181 = str;
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (i2 == 0 || i2 == str.length() - 1) {
                sb.append(str.charAt(i2));
            } else {
                sb.append("*");
            }
        }
        f182 = sb.toString();
    }

    /* renamed from: Ι  reason: contains not printable characters */
    public static void m137(String str) {
        if (f181 == null) {
            m136(AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY));
        }
        String str2 = f181;
        if (str2 != null && str.contains(str2)) {
            AFLogger.afInfoLog(str.replace(f181, f182));
        }
    }
}
