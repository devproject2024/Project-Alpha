package com.google.android.gms.measurement.internal;

final class fm implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzm f11978a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ fd f11979b;

    fm(fd fdVar, zzm zzm) {
        this.f11979b = fdVar;
        this.f11978a = zzm;
    }

    public final void run() {
        this.f11979b.f11950a.l();
        this.f11979b.f11950a.a(this.f11978a);
    }
}
