package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.a.b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.s;

public class z extends cl {

    /* renamed from: b  reason: collision with root package name */
    final b<b<?>> f8639b = new b<>();

    /* renamed from: f  reason: collision with root package name */
    private f f8640f;

    public static void a(Activity activity, f fVar, b<?> bVar) {
        j a2 = a(activity);
        z zVar = (z) a2.a("ConnectionlessLifecycleHelper", z.class);
        if (zVar == null) {
            zVar = new z(a2);
        }
        zVar.f8640f = fVar;
        s.a(bVar, (Object) "ApiKey cannot be null");
        zVar.f8639b.add(bVar);
        fVar.a(zVar);
    }

    private z(j jVar) {
        super(jVar);
        this.f8394a.a("ConnectionlessLifecycleHelper", (LifecycleCallback) this);
    }

    public final void b() {
        super.b();
        g();
    }

    public final void c() {
        super.c();
        g();
    }

    public final void d() {
        super.d();
        f fVar = this.f8640f;
        synchronized (f.f8585b) {
            if (fVar.f8589e == this) {
                fVar.f8589e = null;
                fVar.f8590f.clear();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void a(ConnectionResult connectionResult, int i2) {
        this.f8640f.b(connectionResult, i2);
    }

    /* access modifiers changed from: protected */
    public final void e() {
        this.f8640f.c();
    }

    private final void g() {
        if (!this.f8639b.isEmpty()) {
            this.f8640f.a(this);
        }
    }
}
