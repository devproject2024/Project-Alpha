package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.s;

public final class en {

    /* renamed from: a  reason: collision with root package name */
    private final String f11885a;

    /* renamed from: b  reason: collision with root package name */
    private final String f11886b = null;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11887c;

    /* renamed from: d  reason: collision with root package name */
    private String f11888d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ eh f11889e;

    public en(eh ehVar, String str) {
        this.f11889e = ehVar;
        s.a(str);
        this.f11885a = str;
    }

    public final String a() {
        if (!this.f11887c) {
            this.f11887c = true;
            this.f11888d = this.f11889e.c().getString(this.f11885a, (String) null);
        }
        return this.f11888d;
    }

    public final void a(String str) {
        if (this.f11889e.H_().d((String) null, o.aN) || !jq.c(str, this.f11888d)) {
            SharedPreferences.Editor edit = this.f11889e.c().edit();
            edit.putString(this.f11885a, str);
            edit.apply();
            this.f11888d = str;
        }
    }
}
