package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences;

import android.content.SharedPreferences;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.RealPreference;

final class ConverterAdapter<T> implements RealPreference.Adapter<T> {
    private final Preference.Converter<T> converter;

    ConverterAdapter(Preference.Converter<T> converter2) {
        this.converter = converter2;
    }

    public final T get(String str, SharedPreferences sharedPreferences, T t) {
        String string = sharedPreferences.getString(str, (String) null);
        if (string == null) {
            return t;
        }
        T deserialize = this.converter.deserialize(string);
        Preconditions.checkNotNull(deserialize, "Deserialized value must not be null from string: ".concat(String.valueOf(string)));
        return deserialize;
    }

    public final void set(String str, T t, SharedPreferences.Editor editor) {
        String serialize = this.converter.serialize(t);
        Preconditions.checkNotNull(serialize, "Serialized string must not be null from value: ".concat(String.valueOf(t)));
        editor.putString(str, serialize);
    }
}
