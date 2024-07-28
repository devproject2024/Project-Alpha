package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.internal.measurement.zzv;
import com.google.android.gms.measurement.internal.ip;

public final class il<T extends Context & ip> {

    /* renamed from: a  reason: collision with root package name */
    public final T f12213a;

    public il(T t) {
        s.a(t);
        this.f12213a = t;
    }

    public final void a() {
        fc.a((Context) this.f12213a, (zzv) null).J_().k.a("Local AppMeasurementService is starting up");
    }

    public final void b() {
        fc.a((Context) this.f12213a, (zzv) null).J_().k.a("Local AppMeasurementService is shutting down");
    }

    public final void a(Runnable runnable) {
        jj a2 = jj.a((Context) this.f12213a);
        a2.K_().a((Runnable) new iq(a2, runnable));
    }

    public final boolean a(Intent intent) {
        if (intent == null) {
            c().f11828c.a("onUnbind called with null intent");
            return true;
        }
        c().k.a("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    public final void b(Intent intent) {
        if (intent == null) {
            c().f11828c.a("onRebind called with null intent");
            return;
        }
        c().k.a("onRebind called. action", intent.getAction());
    }

    public final dy c() {
        return fc.a((Context) this.f12213a, (zzv) null).J_();
    }
}
