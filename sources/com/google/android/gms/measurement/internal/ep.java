package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.measurement.bs;
import com.google.android.gms.internal.measurement.eq;

public final class ep implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ em f11893a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f11894b;

    ep(em emVar, String str) {
        this.f11893a = emVar;
        this.f11894b = str;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.f11893a.f11884a.J_().f11831f.a("Install Referrer connection returned with null binder");
            return;
        }
        try {
            bs a2 = eq.a(iBinder);
            if (a2 == null) {
                this.f11893a.f11884a.J_().f11831f.a("Install Referrer Service implementation was not found");
                return;
            }
            this.f11893a.f11884a.J_().f11834i.a("Install Referrer Service connected");
            this.f11893a.f11884a.K_().a((Runnable) new eo(this, a2, this));
        } catch (Exception e2) {
            this.f11893a.f11884a.J_().f11831f.a("Exception occurred while calling Install Referrer API", e2);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f11893a.f11884a.J_().f11834i.a("Install Referrer Service disconnected");
    }
}
