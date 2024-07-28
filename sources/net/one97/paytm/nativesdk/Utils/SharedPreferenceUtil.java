package net.one97.paytm.nativesdk.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.PaytmSDK;

public class SharedPreferenceUtil {
    private static volatile SharedPreferenceUtil INSTANCE;
    private static Context context;
    private static SharedPreferences.Editor editor;
    private static SharedPreferences preferences;

    public static SharedPreferenceUtil getInstance() {
        if (INSTANCE == null) {
            synchronized (SharedPreferenceUtil.class) {
                if (INSTANCE == null) {
                    Context appContext = PaytmSDK.getAppContext();
                    context = appContext;
                    SharedPreferences sharedPreferences = appContext.getSharedPreferences(SDKConstants.APP_SHARED_PREFERENCE, 0);
                    preferences = sharedPreferences;
                    editor = sharedPreferences.edit();
                    INSTANCE = new SharedPreferenceUtil();
                }
            }
        }
        return INSTANCE;
    }

    public void setInt(String str, int i2) {
        if (str != null && !str.isEmpty()) {
            editor.putInt(str, i2);
            editor.apply();
        }
    }

    public void setString(String str, String str2) {
        if (str != null && !str.isEmpty()) {
            editor.putString(str, str2);
            editor.apply();
        }
    }

    public int getInt(String str, int i2) {
        return preferences.contains(str) ? preferences.getInt(str, i2) : i2;
    }

    public void setBoolean(String str, boolean z) {
        if (str != null && !str.isEmpty()) {
            editor.putBoolean(str, z);
            editor.apply();
        }
    }

    public boolean getBoolean(String str, boolean z) {
        return preferences.contains(str) ? preferences.getBoolean(str, z) : z;
    }

    public String getString(String str, String str2) {
        return preferences.contains(str) ? preferences.getString(str, str2) : str2;
    }

    public void setLong(String str, long j) {
        if (str != null && !str.isEmpty()) {
            editor.putLong(str, j);
            editor.apply();
        }
    }

    public long getLong(String str, long j) {
        return preferences.contains(str) ? preferences.getLong(str, j) : j;
    }

    public void clearAll() {
        editor.clear();
        editor.apply();
    }
}
