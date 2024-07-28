package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.u;

public final class ab implements av {

    /* renamed from: a  reason: collision with root package name */
    final ay f8397a;

    /* renamed from: b  reason: collision with root package name */
    boolean f8398b = false;

    public ab(ay ayVar) {
        this.f8397a = ayVar;
    }

    public final void a() {
    }

    public final void a(Bundle bundle) {
    }

    public final void a(ConnectionResult connectionResult, a<?> aVar, boolean z) {
    }

    public final <A extends a.b, R extends l, T extends d.a<R, A>> T a(T t) {
        return b(t);
    }

    public final <A extends a.b, T extends d.a<? extends l, A>> T b(T t) {
        try {
            this.f8397a.m.f8433e.a(t);
            as asVar = this.f8397a.m;
            a.f fVar = asVar.f8430b.get(t.f8568a);
            s.a(fVar, (Object) "Appropriate Api was not requested.");
            if (fVar.g() || !this.f8397a.f8447g.containsKey(t.f8568a)) {
                boolean z = fVar instanceof u;
                a.b bVar = fVar;
                if (z) {
                    bVar = ((u) fVar).f8867a;
                }
                t.b(bVar);
                return t;
            }
            t.b(new Status(17));
            return t;
        } catch (DeadObjectException unused) {
            this.f8397a.a((ax) new ae(this, this));
        }
    }

    public final boolean b() {
        if (this.f8398b) {
            return false;
        }
        if (this.f8397a.m.j()) {
            this.f8398b = true;
            for (bx bxVar : this.f8397a.m.f8432d) {
                bxVar.f8487b = null;
            }
            return false;
        }
        this.f8397a.a((ConnectionResult) null);
        return true;
    }

    public final void c() {
        if (this.f8398b) {
            this.f8398b = false;
            this.f8397a.a((ax) new ad(this, this));
        }
    }

    public final void a(int i2) {
        this.f8397a.a((ConnectionResult) null);
        this.f8397a.n.a(i2, this.f8398b);
    }
}
