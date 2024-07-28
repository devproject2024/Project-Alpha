package com.google.android.gms.measurement.internal;

final class fq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzkl f11988a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ zzm f11989b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ fd f11990c;

    fq(fd fdVar, zzkl zzkl, zzm zzm) {
        this.f11990c = fdVar;
        this.f11988a = zzkl;
        this.f11989b = zzm;
    }

    public final void run() {
        this.f11990c.f11950a.l();
        if (this.f11988a.a() == null) {
            this.f11990c.f11950a.b(this.f11988a, this.f11989b);
        } else {
            this.f11990c.f11950a.a(this.f11988a, this.f11989b);
        }
    }
}
