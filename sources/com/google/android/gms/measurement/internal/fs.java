package com.google.android.gms.measurement.internal;

final class fs implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzm f11996a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ fd f11997b;

    fs(fd fdVar, zzm zzm) {
        this.f11997b = fdVar;
        this.f11996a = zzm;
    }

    public final void run() {
        this.f11997b.f11950a.l();
        this.f11997b.f11950a.b(this.f11996a);
    }
}
