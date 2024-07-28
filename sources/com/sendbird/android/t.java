package com.sendbird.android;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.sendbird.android.log.Logger;

final class t {

    /* renamed from: a  reason: collision with root package name */
    static SharedPreferences f45283a;

    static void a() {
        f45283a.edit().clear().apply();
    }

    static String b() {
        String string = f45283a.getString("PREFERENCE_KEY_SEED", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                return a.b(string, f45283a.getString("PREFERENCE_KEY_SESSION_KEY", ""));
            } catch (Exception e2) {
                Logger.e((Throwable) e2);
            }
        }
        return "";
    }
}
