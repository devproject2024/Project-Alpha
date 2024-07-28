package com.google.android.gms.measurement.internal;

final class gy implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ long f12083a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ ge f12084b;

    gy(ge geVar, long j) {
        this.f12084b = geVar;
        this.f12083a = j;
    }

    public final void run() {
        this.f12084b.I_().l.a(this.f12083a);
        this.f12084b.J_().j.a("Minimum session duration set", Long.valueOf(this.f12083a));
    }
}
