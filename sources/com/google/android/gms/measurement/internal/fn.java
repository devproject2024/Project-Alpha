package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

final class fn implements Callable<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzan f11980a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f11981b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ fd f11982c;

    fn(fd fdVar, zzan zzan, String str) {
        this.f11982c = fdVar;
        this.f11980a = zzan;
        this.f11981b = str;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.f11982c.f11950a.l();
        jj a2 = this.f11982c.f11950a;
        jj.a((jg) a2.f12265a);
        return a2.f12265a.a(this.f11980a, this.f11981b);
    }
}
