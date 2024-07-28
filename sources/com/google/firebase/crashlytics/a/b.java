package com.google.firebase.crashlytics.a;

import android.util.Log;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    static final b f38144a = new b("FirebaseCrashlytics");

    /* renamed from: b  reason: collision with root package name */
    private final String f38145b;

    /* renamed from: c  reason: collision with root package name */
    private int f38146c = 4;

    private b(String str) {
        this.f38145b = str;
    }

    public static b a() {
        return f38144a;
    }

    public final boolean a(int i2) {
        return this.f38146c <= i2 || Log.isLoggable(this.f38145b, i2);
    }
}
