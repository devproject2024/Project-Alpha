package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.lw;

final class hs implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzm f12139a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ lw f12140b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ hm f12141c;

    hs(hm hmVar, zzm zzm, lw lwVar) {
        this.f12141c = hmVar;
        this.f12139a = zzm;
        this.f12140b = lwVar;
    }

    public final void run() {
        try {
            dq dqVar = this.f12141c.f12120b;
            if (dqVar == null) {
                this.f12141c.J_().f11828c.a("Failed to get app instance id");
                return;
            }
            String c2 = dqVar.c(this.f12139a);
            if (c2 != null) {
                this.f12141c.b().a(c2);
                this.f12141c.I_().k.a(c2);
            }
            this.f12141c.D();
            this.f12141c.L_().a(this.f12140b, c2);
        } catch (RemoteException e2) {
            this.f12141c.J_().f11828c.a("Failed to get app instance id", e2);
        } finally {
            this.f12141c.L_().a(this.f12140b, (String) null);
        }
    }
}
