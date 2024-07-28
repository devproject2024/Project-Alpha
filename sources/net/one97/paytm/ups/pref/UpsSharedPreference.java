package net.one97.paytm.ups.pref;

import com.paytm.utility.CJRSecureSharedPreferences;
import kotlin.g.b.k;
import net.one97.paytm.ups.UpsSdk;

public final class UpsSharedPreference implements UpsSharedPreferenceHelper {
    public static final UpsSharedPreference INSTANCE = new UpsSharedPreference();

    private UpsSharedPreference() {
    }

    public final void saveUserId(String str) {
        k.c(str, "userId");
        CJRSecureSharedPreferences instance = CJRSecureSharedPreferences.getInstance(UpsSdk.INSTANCE.getApplicationContext(), "UPS_PREF");
        instance.putString("UPS_PREF", str);
        instance.apply();
    }

    public final boolean isUserIdSaved() {
        CJRSecureSharedPreferences instance = CJRSecureSharedPreferences.getInstance(UpsSdk.INSTANCE.getApplicationContext(), "UPS_PREF");
        if (!instance.contains("UPS_PREF")) {
            return false;
        }
        String string = instance.getString("UPS_PREF", "");
        if (string == null) {
            k.a();
        }
        k.a((Object) string, "pref.getString(UPS_USER_ID_PREF, \"\")!!");
        if (string.length() > 0) {
            return false;
        }
        return true;
    }

    public final String getUserId() {
        CJRSecureSharedPreferences instance = CJRSecureSharedPreferences.getInstance(UpsSdk.INSTANCE.getApplicationContext(), "UPS_PREF");
        if (instance.contains("UPS_PREF")) {
            String string = instance.getString("UPS_PREF", "");
            if (string == null) {
                k.a();
            }
            k.a((Object) string, "pref.getString(UPS_USER_ID_PREF, \"\")!!");
            if (string.length() > 0) {
                return string;
            }
        }
        return "";
    }
}
