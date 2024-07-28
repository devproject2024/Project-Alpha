package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

final class hu implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ hi f12145a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ hm f12146b;

    hu(hm hmVar, hi hiVar) {
        this.f12146b = hmVar;
        this.f12145a = hiVar;
    }

    public final void run() {
        dq dqVar = this.f12146b.f12120b;
        if (dqVar == null) {
            this.f12146b.J_().f11828c.a("Failed to send current screen to service");
            return;
        }
        try {
            if (this.f12145a == null) {
                dqVar.a(0, (String) null, (String) null, this.f12146b.k().getPackageName());
            } else {
                dqVar.a(this.f12145a.f12107c, this.f12145a.f12105a, this.f12145a.f12106b, this.f12146b.k().getPackageName());
            }
            this.f12146b.D();
        } catch (RemoteException e2) {
            this.f12146b.J_().f11828c.a("Failed to send current screen to the service", e2);
        }
    }
}
