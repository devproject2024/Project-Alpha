package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences;

import android.content.SharedPreferences;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.RealPreference;
import java.util.Collections;
import java.util.Set;

final class StringSetAdapter implements RealPreference.Adapter<Set<String>> {
    static final StringSetAdapter INSTANCE = new StringSetAdapter();

    StringSetAdapter() {
    }

    public final Set<String> get(String str, SharedPreferences sharedPreferences, Set<String> set) {
        return Collections.unmodifiableSet(sharedPreferences.getStringSet(str, set));
    }

    public final void set(String str, Set<String> set, SharedPreferences.Editor editor) {
        editor.putStringSet(str, set);
    }
}
