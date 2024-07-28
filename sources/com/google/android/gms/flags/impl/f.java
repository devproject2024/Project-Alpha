package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import com.google.android.gms.internal.g.e;

public final class f extends a<Long> {
    public static Long a(SharedPreferences sharedPreferences, String str, Long l) {
        try {
            return (Long) e.a(new g(sharedPreferences, str, l));
        } catch (Exception e2) {
            String valueOf = String.valueOf(e2.getMessage());
            if (valueOf.length() != 0) {
                "Flag value not available, returning default: ".concat(valueOf);
            } else {
                new String("Flag value not available, returning default: ");
            }
            return l;
        }
    }
}
