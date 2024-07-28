package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences;

import android.content.SharedPreferences;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.RealPreference;

final class BooleanAdapter implements RealPreference.Adapter<Boolean> {
    static final BooleanAdapter INSTANCE = new BooleanAdapter();

    BooleanAdapter() {
    }

    public final Boolean get(String str, SharedPreferences sharedPreferences, Boolean bool) {
        return Boolean.valueOf(sharedPreferences.getBoolean(str, bool.booleanValue()));
    }

    public final void set(String str, Boolean bool, SharedPreferences.Editor editor) {
        editor.putBoolean(str, bool.booleanValue());
    }
}
