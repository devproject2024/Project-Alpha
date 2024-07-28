package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.s;

public final class el {

    /* renamed from: a  reason: collision with root package name */
    private final String f11879a;

    /* renamed from: b  reason: collision with root package name */
    private final long f11880b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11881c;

    /* renamed from: d  reason: collision with root package name */
    private long f11882d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ eh f11883e;

    public el(eh ehVar, String str, long j) {
        this.f11883e = ehVar;
        s.a(str);
        this.f11879a = str;
        this.f11880b = j;
    }

    public final long a() {
        if (!this.f11881c) {
            this.f11881c = true;
            this.f11882d = this.f11883e.c().getLong(this.f11879a, this.f11880b);
        }
        return this.f11882d;
    }

    public final void a(long j) {
        SharedPreferences.Editor edit = this.f11883e.c().edit();
        edit.putLong(this.f11879a, j);
        edit.apply();
        this.f11882d = j;
    }
}
