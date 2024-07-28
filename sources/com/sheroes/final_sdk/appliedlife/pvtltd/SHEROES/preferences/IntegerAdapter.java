package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences;

import android.content.SharedPreferences;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.RealPreference;

final class IntegerAdapter implements RealPreference.Adapter<Integer> {
    static final IntegerAdapter INSTANCE = new IntegerAdapter();

    IntegerAdapter() {
    }

    public final Integer get(String str, SharedPreferences sharedPreferences, Integer num) {
        return Integer.valueOf(sharedPreferences.getInt(str, num.intValue()));
    }

    public final void set(String str, Integer num, SharedPreferences.Editor editor) {
        editor.putInt(str, num.intValue());
    }
}
