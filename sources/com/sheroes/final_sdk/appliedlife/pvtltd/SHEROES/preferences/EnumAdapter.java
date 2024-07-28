package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences;

import android.content.SharedPreferences;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.RealPreference;
import java.lang.Enum;

final class EnumAdapter<T extends Enum<T>> implements RealPreference.Adapter<T> {
    private final Class<T> enumClass;

    EnumAdapter(Class<T> cls) {
        this.enumClass = cls;
    }

    public final T get(String str, SharedPreferences sharedPreferences, T t) {
        String string = sharedPreferences.getString(str, (String) null);
        if (string == null) {
            return t;
        }
        return Enum.valueOf(this.enumClass, string);
    }

    public final void set(String str, T t, SharedPreferences.Editor editor) {
        editor.putString(str, t.name());
    }
}
