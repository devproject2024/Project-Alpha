package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

final class ic implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f12181a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f12182b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f12183c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ String f12184d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ boolean f12185e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ zzm f12186f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ hm f12187g;

    ic(hm hmVar, AtomicReference atomicReference, String str, String str2, String str3, boolean z, zzm zzm) {
        this.f12187g = hmVar;
        this.f12181a = atomicReference;
        this.f12182b = str;
        this.f12183c = str2;
        this.f12184d = str3;
        this.f12185e = z;
        this.f12186f = zzm;
    }

    public final void run() {
        synchronized (this.f12181a) {
            try {
                dq dqVar = this.f12187g.f12120b;
                if (dqVar == null) {
                    this.f12187g.J_().f11828c.a("Failed to get user properties", dy.a(this.f12182b), this.f12183c, this.f12184d);
                    this.f12181a.set(Collections.emptyList());
                    this.f12181a.notify();
                    return;
                }
                if (TextUtils.isEmpty(this.f12182b)) {
                    this.f12181a.set(dqVar.a(this.f12183c, this.f12184d, this.f12185e, this.f12186f));
                } else {
                    this.f12181a.set(dqVar.a(this.f12182b, this.f12183c, this.f12184d, this.f12185e));
                }
                this.f12187g.D();
                this.f12181a.notify();
            } catch (RemoteException e2) {
                try {
                    this.f12187g.J_().f11828c.a("Failed to get user properties", dy.a(this.f12182b), this.f12183c, e2);
                    this.f12181a.set(Collections.emptyList());
                    this.f12181a.notify();
                } catch (Throwable th) {
                    this.f12181a.notify();
                    throw th;
                }
            }
        }
    }
}
