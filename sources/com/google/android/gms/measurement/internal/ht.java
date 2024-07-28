package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

final class ht implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f12142a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ zzm f12143b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ hm f12144c;

    ht(hm hmVar, AtomicReference atomicReference, zzm zzm) {
        this.f12144c = hmVar;
        this.f12142a = atomicReference;
        this.f12143b = zzm;
    }

    public final void run() {
        synchronized (this.f12142a) {
            try {
                dq dqVar = this.f12144c.f12120b;
                if (dqVar == null) {
                    this.f12144c.J_().f11828c.a("Failed to get app instance id");
                    this.f12142a.notify();
                    return;
                }
                this.f12142a.set(dqVar.c(this.f12143b));
                String str = (String) this.f12142a.get();
                if (str != null) {
                    this.f12144c.b().a(str);
                    this.f12144c.I_().k.a(str);
                }
                this.f12144c.D();
                this.f12142a.notify();
            } catch (RemoteException e2) {
                try {
                    this.f12144c.J_().f11828c.a("Failed to get app instance id", e2);
                    this.f12142a.notify();
                } catch (Throwable th) {
                    this.f12142a.notify();
                    throw th;
                }
            }
        }
    }
}
