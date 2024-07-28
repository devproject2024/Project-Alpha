package com.google.android.gms.measurement.internal;

final class ii implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ dq f12208a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Cif f12209b;

    ii(Cif ifVar, dq dqVar) {
        this.f12209b = ifVar;
        this.f12208a = dqVar;
    }

    public final void run() {
        synchronized (this.f12209b) {
            boolean unused = this.f12209b.f12197a = false;
            if (!this.f12209b.f12199c.z()) {
                this.f12209b.f12199c.J_().k.a("Connected to service");
                this.f12209b.f12199c.a(this.f12208a);
            }
        }
    }
}
