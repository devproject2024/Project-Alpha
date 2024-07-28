package com.alipay.mobile.nebulacore.util;

import android.content.ContentResolver;
import android.provider.Settings;
import android.text.TextUtils;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebulacore.env.H5Environment;

public class AccessibilityUtil {
    private static final String TAG = "AccessibilityUtil";
    private static String ac;

    public static String getEnabledAccessibilities() {
        if (!TextUtils.isEmpty(ac)) {
            return ac;
        }
        ContentResolver contentResolver = H5Environment.getContext().getContentResolver();
        try {
            int i2 = Settings.Secure.getInt(contentResolver, "accessibility_enabled");
            H5Log.d(TAG, "accessibilityEnabled: ".concat(String.valueOf(i2)));
            if (i2 == 1) {
                String string = Settings.Secure.getString(contentResolver, "enabled_accessibility_services");
                String string2 = Settings.Secure.getString(contentResolver, "accessibility_display_inversion_enabled");
                String string3 = Settings.Secure.getString(contentResolver, "speak_password");
                String string4 = Settings.Secure.getString(contentResolver, "touch_exploration_enabled");
                H5Log.d(TAG, "all enabled accessibility services: ".concat(String.valueOf(string)));
                H5Log.d(TAG, "displayInversion: ".concat(String.valueOf(string2)));
                H5Log.d(TAG, "touchExplore: ".concat(String.valueOf(string4)));
                if ("1".equals(string4)) {
                    ac = getAc(ac, "V|");
                }
                if ("1".equals(string2)) {
                    ac = getAc(ac, "I|");
                }
                if ("1".equals(string3)) {
                    ac = getAc(ac, "sp|");
                }
                if (ac != null) {
                    if (ac.endsWith("|")) {
                        ac = ac.substring(0, ac.length() - 1);
                    }
                    if (ac.length() > 0) {
                        ac = ",ac:" + ac;
                    }
                }
            }
            return ac;
        } catch (Exception unused) {
            H5Log.e(TAG, "get accessibilityEnabled setting exception");
            return ac;
        }
    }

    private static String getAc(String str, String str2) {
        if (str == null) {
            return str2;
        }
        return str + str2;
    }
}
