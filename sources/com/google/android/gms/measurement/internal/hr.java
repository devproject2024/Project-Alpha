package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

final class hr implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f12135a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ zzm f12136b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ boolean f12137c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ hm f12138d;

    hr(hm hmVar, AtomicReference atomicReference, zzm zzm, boolean z) {
        this.f12138d = hmVar;
        this.f12135a = atomicReference;
        this.f12136b = zzm;
        this.f12137c = z;
    }

    public final void run() {
        synchronized (this.f12135a) {
            try {
                dq dqVar = this.f12138d.f12120b;
                if (dqVar == null) {
                    this.f12138d.J_().f11828c.a("Failed to get user properties");
                    this.f12135a.notify();
                    return;
                }
                this.f12135a.set(dqVar.a(this.f12136b, this.f12137c));
                this.f12138d.D();
                this.f12135a.notify();
            } catch (RemoteException e2) {
                try {
                    this.f12138d.J_().f11828c.a("Failed to get user properties", e2);
                    this.f12135a.notify();
                } catch (Throwable th) {
                    this.f12135a.notify();
                    throw th;
                }
            }
        }
    }
}
