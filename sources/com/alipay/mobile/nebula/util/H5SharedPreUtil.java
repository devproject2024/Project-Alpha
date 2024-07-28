package com.alipay.mobile.nebula.util;

import android.content.SharedPreferences;

public class H5SharedPreUtil {
    public static final String H5_APP_SCORE_INFO = "h5_app_score_info";
    public static final String H5_APP_SCORE_RPC_TIME = "h5_app_score_rpc_time";
    public static final String H5_SCORE_RPC_LIMIT = "h5_score_rpc_limit";
    private static final String NEBULA_SHARED_FILE = "nebula_shared_pre";
    private static String TAG = "SharedPreUtils";

    public static final void saveStringData(String str, String str2) {
        try {
            getSharedPreferences().edit().putString(str, str2).apply();
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
        }
    }

    public static final void saveLongData(String str, long j) {
        try {
            getSharedPreferences().edit().putLong(str, j).apply();
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
        }
    }

    public static final String getStringData(String str) {
        try {
            return getSharedPreferences().getString(str, "");
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
            return "";
        }
    }

    public static final long getLongData(String str) {
        try {
            return getSharedPreferences().getLong(str, -1);
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
            return -1;
        }
    }

    public static final void removeData(String str) {
        try {
            getSharedPreferences().edit().remove(str).apply();
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
        }
    }

    public static SharedPreferences getSharedPreferences() {
        return H5Utils.getContext().getSharedPreferences(NEBULA_SHARED_FILE, 0);
    }
}
