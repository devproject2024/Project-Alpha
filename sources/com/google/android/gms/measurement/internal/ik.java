package com.google.android.gms.measurement.internal;

final class ik implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ dq f12211a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Cif f12212b;

    ik(Cif ifVar, dq dqVar) {
        this.f12212b = ifVar;
        this.f12211a = dqVar;
    }

    public final void run() {
        synchronized (this.f12212b) {
            boolean unused = this.f12212b.f12197a = false;
            if (!this.f12212b.f12199c.z()) {
                this.f12212b.f12199c.J_().j.a("Connected to remote service");
                this.f12212b.f12199c.a(this.f12211a);
            }
        }
    }
}
