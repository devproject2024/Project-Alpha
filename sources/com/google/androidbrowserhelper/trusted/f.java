package com.google.androidbrowserhelper.trusted;

import android.content.Context;
import android.content.SharedPreferences;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    final SharedPreferences f37677a;

    public f(Context context) {
        this.f37677a = context.getSharedPreferences("TrustedWebActivityLauncherPrefs", 0);
    }
}
