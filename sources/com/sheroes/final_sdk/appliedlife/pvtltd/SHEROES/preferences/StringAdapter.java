package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences;

import android.content.SharedPreferences;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.RealPreference;

final class StringAdapter implements RealPreference.Adapter<String> {
    static final StringAdapter INSTANCE = new StringAdapter();

    StringAdapter() {
    }

    public final String get(String str, SharedPreferences sharedPreferences, String str2) {
        return sharedPreferences.getString(str, str2);
    }

    public final void set(String str, String str2, SharedPreferences.Editor editor) {
        editor.putString(str, str2);
    }
}
