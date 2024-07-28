package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.g.e;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    private static SharedPreferences f9048a;

    public static SharedPreferences a(Context context) throws Exception {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (f9048a == null) {
                f9048a = (SharedPreferences) e.a(new k(context));
            }
            sharedPreferences = f9048a;
        }
        return sharedPreferences;
    }
}
