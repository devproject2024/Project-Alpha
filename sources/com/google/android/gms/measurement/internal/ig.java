package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.lw;

final class ig implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f12200a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f12201b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ boolean f12202c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ zzm f12203d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ lw f12204e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ hm f12205f;

    ig(hm hmVar, String str, String str2, boolean z, zzm zzm, lw lwVar) {
        this.f12205f = hmVar;
        this.f12200a = str;
        this.f12201b = str2;
        this.f12202c = z;
        this.f12203d = zzm;
        this.f12204e = lwVar;
    }

    public final void run() {
        Bundle bundle = new Bundle();
        try {
            dq dqVar = this.f12205f.f12120b;
            if (dqVar == null) {
                this.f12205f.J_().f11828c.a("Failed to get user properties", this.f12200a, this.f12201b);
                return;
            }
            bundle = jq.a(dqVar.a(this.f12200a, this.f12201b, this.f12202c, this.f12203d));
            this.f12205f.D();
            this.f12205f.L_().a(this.f12204e, bundle);
        } catch (RemoteException e2) {
            this.f12205f.J_().f11828c.a("Failed to get user properties", this.f12200a, e2);
        } finally {
            this.f12205f.L_().a(this.f12204e, bundle);
        }
    }
}
