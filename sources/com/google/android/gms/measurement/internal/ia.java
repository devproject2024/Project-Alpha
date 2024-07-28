package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

final class ia implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f12169a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f12170b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f12171c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ String f12172d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ zzm f12173e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ hm f12174f;

    ia(hm hmVar, AtomicReference atomicReference, String str, String str2, String str3, zzm zzm) {
        this.f12174f = hmVar;
        this.f12169a = atomicReference;
        this.f12170b = str;
        this.f12171c = str2;
        this.f12172d = str3;
        this.f12173e = zzm;
    }

    public final void run() {
        synchronized (this.f12169a) {
            try {
                dq dqVar = this.f12174f.f12120b;
                if (dqVar == null) {
                    this.f12174f.J_().f11828c.a("Failed to get conditional properties", dy.a(this.f12170b), this.f12171c, this.f12172d);
                    this.f12169a.set(Collections.emptyList());
                    this.f12169a.notify();
                    return;
                }
                if (TextUtils.isEmpty(this.f12170b)) {
                    this.f12169a.set(dqVar.a(this.f12171c, this.f12172d, this.f12173e));
                } else {
                    this.f12169a.set(dqVar.a(this.f12170b, this.f12171c, this.f12172d));
                }
                this.f12174f.D();
                this.f12169a.notify();
            } catch (RemoteException e2) {
                try {
                    this.f12174f.J_().f11828c.a("Failed to get conditional properties", dy.a(this.f12170b), this.f12171c, e2);
                    this.f12169a.set(Collections.emptyList());
                    this.f12169a.notify();
                } catch (Throwable th) {
                    this.f12169a.notify();
                    throw th;
                }
            }
        }
    }
}
