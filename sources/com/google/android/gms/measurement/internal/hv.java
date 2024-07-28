package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

final class hv implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzm f12147a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ boolean f12148b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ hm f12149c;

    hv(hm hmVar, zzm zzm, boolean z) {
        this.f12149c = hmVar;
        this.f12147a = zzm;
        this.f12148b = z;
    }

    public final void run() {
        dq dqVar = this.f12149c.f12120b;
        if (dqVar == null) {
            this.f12149c.J_().f11828c.a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            dqVar.a(this.f12147a);
            if (this.f12148b) {
                this.f12149c.r().B();
            }
            this.f12149c.a(dqVar, (AbstractSafeParcelable) null, this.f12147a);
            this.f12149c.D();
        } catch (RemoteException e2) {
            this.f12149c.J_().f11828c.a("Failed to send app launch to the service", e2);
        }
    }
}
