package com.google.android.gms.measurement.internal;

final class ff implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzv f11955a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ fd f11956b;

    ff(fd fdVar, zzv zzv) {
        this.f11956b = fdVar;
        this.f11955a = zzv;
    }

    public final void run() {
        this.f11956b.f11950a.l();
        if (this.f11955a.f12391c.a() == null) {
            jj a2 = this.f11956b.f11950a;
            zzv zzv = this.f11955a;
            zzm a3 = a2.a(zzv.f12389a);
            if (a3 != null) {
                a2.b(zzv, a3);
                return;
            }
            return;
        }
        jj a4 = this.f11956b.f11950a;
        zzv zzv2 = this.f11955a;
        zzm a5 = a4.a(zzv2.f12389a);
        if (a5 != null) {
            a4.a(zzv2, a5);
        }
    }
}
