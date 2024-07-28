package com.alipay.mobile.h5container.api;

import android.text.TextUtils;
import java.util.HashMap;

public class H5Flag {
    public static boolean hasShowLoading = false;
    public static boolean initUcNormal = true;
    public static boolean isInChane = true;
    public static boolean isUploadLog = true;
    public static long lastTouchTime = 0;
    public static HashMap<String, Boolean> sOpenAuthGrantFlag = new HashMap<>();
    public static boolean ucReady = false;

    public static synchronized boolean getOpenAuthGrantFlag(String str) {
        boolean z;
        synchronized (H5Flag.class) {
            z = false;
            if (sOpenAuthGrantFlag.containsKey(str)) {
                z = sOpenAuthGrantFlag.get(str).booleanValue();
            }
        }
        return z;
    }

    public static synchronized void setOpenAuthGrantFlag(String str, boolean z) {
        synchronized (H5Flag.class) {
            if (!TextUtils.isEmpty(str)) {
                sOpenAuthGrantFlag.put(str, Boolean.valueOf(z));
            }
        }
    }
}
