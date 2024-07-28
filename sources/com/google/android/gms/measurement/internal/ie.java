package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.lw;
import java.util.ArrayList;

final class ie implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f12192a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f12193b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ zzm f12194c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ lw f12195d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ hm f12196e;

    ie(hm hmVar, String str, String str2, zzm zzm, lw lwVar) {
        this.f12196e = hmVar;
        this.f12192a = str;
        this.f12193b = str2;
        this.f12194c = zzm;
        this.f12195d = lwVar;
    }

    public final void run() {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            dq dqVar = this.f12196e.f12120b;
            if (dqVar == null) {
                this.f12196e.J_().f11828c.a("Failed to get conditional properties", this.f12192a, this.f12193b);
                return;
            }
            arrayList = jq.b(dqVar.a(this.f12192a, this.f12193b, this.f12194c));
            this.f12196e.D();
            this.f12196e.L_().a(this.f12195d, arrayList);
        } catch (RemoteException e2) {
            this.f12196e.J_().f11828c.a("Failed to get conditional properties", this.f12192a, this.f12193b, e2);
        } finally {
            this.f12196e.L_().a(this.f12195d, arrayList);
        }
    }
}
