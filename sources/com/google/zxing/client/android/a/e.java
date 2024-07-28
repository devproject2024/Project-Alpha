package com.google.zxing.client.android.a;

import android.content.SharedPreferences;

public enum e {
    ON,
    AUTO,
    OFF;

    private static e parse(String str) {
        return str == null ? OFF : valueOf(str);
    }

    public static e readPref(SharedPreferences sharedPreferences) {
        return parse(sharedPreferences.getString("preferences_front_light_mode", OFF.toString()));
    }
}
