package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.lw;

final class hx implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzan f12151a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f12152b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ lw f12153c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ hm f12154d;

    hx(hm hmVar, zzan zzan, String str, lw lwVar) {
        this.f12154d = hmVar;
        this.f12151a = zzan;
        this.f12152b = str;
        this.f12153c = lwVar;
    }

    public final void run() {
        byte[] bArr = null;
        try {
            dq dqVar = this.f12154d.f12120b;
            if (dqVar == null) {
                this.f12154d.J_().f11828c.a("Discarding data. Failed to send event to service to bundle");
                return;
            }
            bArr = dqVar.a(this.f12151a, this.f12152b);
            this.f12154d.D();
            this.f12154d.L_().a(this.f12153c, bArr);
        } catch (RemoteException e2) {
            this.f12154d.J_().f11828c.a("Failed to send event to the service to bundle", e2);
        } finally {
            this.f12154d.L_().a(this.f12153c, bArr);
        }
    }
}
