package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.internal.measurement.hs;

abstract class g {

    /* renamed from: b  reason: collision with root package name */
    private static volatile Handler f12006b;

    /* renamed from: a  reason: collision with root package name */
    private final fv f12007a;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f12008c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public volatile long f12009d;

    g(fv fvVar) {
        s.a(fvVar);
        this.f12007a = fvVar;
        this.f12008c = new j(this, fvVar);
    }

    public abstract void a();

    public final void a(long j) {
        c();
        if (j >= 0) {
            this.f12009d = this.f12007a.j().a();
            if (!d().postDelayed(this.f12008c, j)) {
                this.f12007a.J_().f11828c.a("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public final boolean b() {
        return this.f12009d != 0;
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        this.f12009d = 0;
        d().removeCallbacks(this.f12008c);
    }

    private final Handler d() {
        Handler handler;
        if (f12006b != null) {
            return f12006b;
        }
        synchronized (g.class) {
            if (f12006b == null) {
                f12006b = new hs(this.f12007a.k().getMainLooper());
            }
            handler = f12006b;
        }
        return handler;
    }
}
