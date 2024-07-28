package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.s;

public final class ej {

    /* renamed from: a  reason: collision with root package name */
    private final String f11869a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f11870b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11871c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11872d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ eh f11873e;

    public ej(eh ehVar, String str, boolean z) {
        this.f11873e = ehVar;
        s.a(str);
        this.f11869a = str;
        this.f11870b = z;
    }

    public final boolean a() {
        if (!this.f11871c) {
            this.f11871c = true;
            this.f11872d = this.f11873e.c().getBoolean(this.f11869a, this.f11870b);
        }
        return this.f11872d;
    }

    public final void a(boolean z) {
        SharedPreferences.Editor edit = this.f11873e.c().edit();
        edit.putBoolean(this.f11869a, z);
        edit.apply();
        this.f11872d = z;
    }
}
