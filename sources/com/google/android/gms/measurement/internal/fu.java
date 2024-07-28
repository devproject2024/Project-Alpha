package com.google.android.gms.measurement.internal;

final class fu implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzv f11998a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ zzm f11999b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ fd f12000c;

    fu(fd fdVar, zzv zzv, zzm zzm) {
        this.f12000c = fdVar;
        this.f11998a = zzv;
        this.f11999b = zzm;
    }

    public final void run() {
        this.f12000c.f11950a.l();
        if (this.f11998a.f12391c.a() == null) {
            this.f12000c.f11950a.b(this.f11998a, this.f11999b);
        } else {
            this.f12000c.f11950a.a(this.f11998a, this.f11999b);
        }
    }
}
