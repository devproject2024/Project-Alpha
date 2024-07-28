package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences;

import android.content.SharedPreferences;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.RealPreference;

final class FloatAdapter implements RealPreference.Adapter<Float> {
    static final FloatAdapter INSTANCE = new FloatAdapter();

    FloatAdapter() {
    }

    public final Float get(String str, SharedPreferences sharedPreferences, Float f2) {
        return Float.valueOf(sharedPreferences.getFloat(str, f2.floatValue()));
    }

    public final void set(String str, Float f2, SharedPreferences.Editor editor) {
        editor.putFloat(str, f2.floatValue());
    }
}
