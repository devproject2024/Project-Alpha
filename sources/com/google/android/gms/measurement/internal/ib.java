package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

final class ib implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ boolean f12175a = true;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ boolean f12176b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ zzv f12177c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ zzm f12178d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ zzv f12179e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ hm f12180f;

    ib(hm hmVar, boolean z, zzv zzv, zzm zzm, zzv zzv2) {
        this.f12180f = hmVar;
        this.f12176b = z;
        this.f12177c = zzv;
        this.f12178d = zzm;
        this.f12179e = zzv2;
    }

    public final void run() {
        dq dqVar = this.f12180f.f12120b;
        if (dqVar == null) {
            this.f12180f.J_().f11828c.a("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.f12175a) {
            this.f12180f.a(dqVar, (AbstractSafeParcelable) this.f12176b ? null : this.f12177c, this.f12178d);
        } else {
            try {
                if (TextUtils.isEmpty(this.f12179e.f12389a)) {
                    dqVar.a(this.f12177c, this.f12178d);
                } else {
                    dqVar.a(this.f12177c);
                }
            } catch (RemoteException e2) {
                this.f12180f.J_().f11828c.a("Failed to send conditional user property to the service", e2);
            }
        }
        this.f12180f.D();
    }
}
