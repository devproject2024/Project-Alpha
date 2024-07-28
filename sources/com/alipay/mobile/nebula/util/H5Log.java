package com.alipay.mobile.nebula.util;

import android.os.Build;
import android.text.TextUtils;
import com.alipay.mobile.nebula.wallet.H5WalletLog;

public class H5Log {
    public static final String CURRENT_DEVICE_SPEC = (Build.MANUFACTURER + "-" + Build.MODEL + "-" + Build.CPU_ABI + "-api" + Build.VERSION.SDK_INT);
    private static final String TAG = "H5Log";

    public static void d(String str) {
        d(TAG, str);
    }

    public static void d(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            H5WalletLog.d(str, str2);
        }
    }

    public static void w(String str) {
        w(TAG, str);
    }

    public static void w(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            H5WalletLog.w(str, str2, (Throwable) null);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        H5WalletLog.w(str, str2, th);
    }

    public static void e(String str) {
        e(TAG, str, (Throwable) null);
    }

    public static void e(String str, String str2) {
        e(str, str2, (Throwable) null);
    }

    public static void e(String str, Throwable th) {
        e(TAG, str, th);
    }

    public static void e(String str, String str2, Throwable th) {
        H5WalletLog.e(str, str2, th);
    }

    public static void debug(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            H5WalletLog.debug(str, str2);
        }
    }
}
