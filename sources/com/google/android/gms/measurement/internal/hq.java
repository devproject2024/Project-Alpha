package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

final class hq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzm f12133a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ hm f12134b;

    hq(hm hmVar, zzm zzm) {
        this.f12134b = hmVar;
        this.f12133a = zzm;
    }

    public final void run() {
        dq dqVar = this.f12134b.f12120b;
        if (dqVar == null) {
            this.f12134b.J_().f11828c.a("Failed to reset data on the service; null service");
            return;
        }
        try {
            dqVar.d(this.f12133a);
        } catch (RemoteException e2) {
            this.f12134b.J_().f11828c.a("Failed to reset data on the service", e2);
        }
        this.f12134b.D();
    }
}
