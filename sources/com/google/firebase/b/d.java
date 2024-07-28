package com.google.firebase.b;

import android.content.Context;
import android.content.SharedPreferences;

final class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f38069a;

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f38070b;

    private d(Context context) {
        this.f38070b = context.getSharedPreferences("FirebaseAppHeartBeat", 0);
    }

    static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (f38069a == null) {
                f38069a = new d(context);
            }
            dVar = f38069a;
        }
        return dVar;
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean a(String str, long j) {
        if (!this.f38070b.contains(str)) {
            this.f38070b.edit().putLong(str, j).apply();
            return true;
        } else if (j - this.f38070b.getLong(str, -1) < 86400000) {
            return false;
        } else {
            this.f38070b.edit().putLong(str, j).apply();
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean a(long j) {
        return a("fire-global", j);
    }
}
