package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.s;

public final class ek {

    /* renamed from: a  reason: collision with root package name */
    private final String f11874a;

    /* renamed from: b  reason: collision with root package name */
    private final String f11875b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11876c;

    /* renamed from: d  reason: collision with root package name */
    private final long f11877d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ eh f11878e;

    private ek(eh ehVar, String str, long j) {
        this.f11878e = ehVar;
        s.a(str);
        s.b(j > 0);
        this.f11874a = String.valueOf(str).concat(":start");
        this.f11875b = String.valueOf(str).concat(":count");
        this.f11876c = String.valueOf(str).concat(":value");
        this.f11877d = j;
    }

    private final void b() {
        this.f11878e.h();
        long a2 = this.f11878e.j().a();
        SharedPreferences.Editor edit = this.f11878e.c().edit();
        edit.remove(this.f11875b);
        edit.remove(this.f11876c);
        edit.putLong(this.f11874a, a2);
        edit.apply();
    }

    public final void a(String str) {
        this.f11878e.h();
        if (c() == 0) {
            b();
        }
        if (str == null) {
            str = "";
        }
        long j = this.f11878e.c().getLong(this.f11875b, 0);
        if (j <= 0) {
            SharedPreferences.Editor edit = this.f11878e.c().edit();
            edit.putString(this.f11876c, str);
            edit.putLong(this.f11875b, 1);
            edit.apply();
            return;
        }
        long j2 = j + 1;
        boolean z = (this.f11878e.L_().d().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / j2;
        SharedPreferences.Editor edit2 = this.f11878e.c().edit();
        if (z) {
            edit2.putString(this.f11876c, str);
        }
        edit2.putLong(this.f11875b, j2);
        edit2.apply();
    }

    public final Pair<String, Long> a() {
        long j;
        this.f11878e.h();
        this.f11878e.h();
        long c2 = c();
        if (c2 == 0) {
            b();
            j = 0;
        } else {
            j = Math.abs(c2 - this.f11878e.j().a());
        }
        long j2 = this.f11877d;
        if (j < j2) {
            return null;
        }
        if (j > (j2 << 1)) {
            b();
            return null;
        }
        String string = this.f11878e.c().getString(this.f11876c, (String) null);
        long j3 = this.f11878e.c().getLong(this.f11875b, 0);
        b();
        if (string == null || j3 <= 0) {
            return eh.f11858a;
        }
        return new Pair<>(string, Long.valueOf(j3));
    }

    private final long c() {
        return this.f11878e.c().getLong(this.f11874a, 0);
    }

    /* synthetic */ ek(eh ehVar, String str, long j, byte b2) {
        this(ehVar, str, j);
    }
}
