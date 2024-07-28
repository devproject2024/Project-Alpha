package com.google.android.gms.measurement.internal;

final class gx implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ long f12081a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ ge f12082b;

    gx(ge geVar, long j) {
        this.f12082b = geVar;
        this.f12081a = j;
    }

    public final void run() {
        this.f12082b.I_().m.a(this.f12081a);
        this.f12082b.J_().j.a("Session timeout duration set", Long.valueOf(this.f12081a));
    }
}
