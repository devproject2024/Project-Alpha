package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.s;

final class fg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzm f11957a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ fd f11958b;

    fg(fd fdVar, zzm zzm) {
        this.f11958b = fdVar;
        this.f11957a = zzm;
    }

    public final void run() {
        this.f11958b.f11950a.l();
        jj a2 = this.f11958b.f11950a;
        zzm zzm = this.f11957a;
        a2.K_().h();
        a2.g();
        s.a(zzm.f12380a);
        a2.c(zzm);
    }
}
