package com.google.android.gms.measurement.internal;

final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ fv f12241a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ g f12242b;

    j(g gVar, fv fvVar) {
        this.f12242b = gVar;
        this.f12241a = fvVar;
    }

    public final void run() {
        if (kd.a()) {
            this.f12241a.K_().a((Runnable) this);
            return;
        }
        boolean b2 = this.f12242b.b();
        long unused = this.f12242b.f12009d = 0;
        if (b2) {
            this.f12242b.a();
        }
    }
}
