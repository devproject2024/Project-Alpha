package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

final class hz implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzm f12161a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ hm f12162b;

    hz(hm hmVar, zzm zzm) {
        this.f12162b = hmVar;
        this.f12161a = zzm;
    }

    public final void run() {
        dq dqVar = this.f12162b.f12120b;
        if (dqVar == null) {
            this.f12162b.J_().f11828c.a("Failed to send measurementEnabled to service");
            return;
        }
        try {
            dqVar.b(this.f12161a);
            this.f12162b.D();
        } catch (RemoteException e2) {
            this.f12162b.J_().f11828c.a("Failed to send measurementEnabled to the service", e2);
        }
    }
}
