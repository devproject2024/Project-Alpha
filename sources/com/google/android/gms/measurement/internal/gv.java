package com.google.android.gms.measurement.internal;

final class gv implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ boolean f12077a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ ge f12078b;

    gv(ge geVar, boolean z) {
        this.f12078b = geVar;
        this.f12077a = z;
    }

    public final void run() {
        boolean r = this.f12078b.y.r();
        boolean q = this.f12078b.y.q();
        this.f12078b.y.a(this.f12077a);
        if (q == this.f12077a) {
            this.f12078b.y.J_().k.a("Default data collection state already set to", Boolean.valueOf(this.f12077a));
        }
        if (this.f12078b.y.r() == r || this.f12078b.y.r() != this.f12078b.y.q()) {
            this.f12078b.y.J_().f11833h.a("Default data collection is different than actual status", Boolean.valueOf(this.f12077a), Boolean.valueOf(r));
        }
        this.f12078b.G();
    }
}
