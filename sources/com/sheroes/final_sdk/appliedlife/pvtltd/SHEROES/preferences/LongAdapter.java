package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences;

import android.content.SharedPreferences;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.RealPreference;

final class LongAdapter implements RealPreference.Adapter<Long> {
    static final LongAdapter INSTANCE = new LongAdapter();

    LongAdapter() {
    }

    public final Long get(String str, SharedPreferences sharedPreferences, Long l) {
        return Long.valueOf(sharedPreferences.getLong(str, l.longValue()));
    }

    public final void set(String str, Long l, SharedPreferences.Editor editor) {
        editor.putLong(str, l.longValue());
    }
}
