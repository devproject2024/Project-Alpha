package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.l;
import java.util.Collections;

public final class ap implements av {

    /* renamed from: a  reason: collision with root package name */
    private final ay f8426a;

    public ap(ay ayVar) {
        this.f8426a = ayVar;
    }

    public final void a(int i2) {
    }

    public final void a(Bundle bundle) {
    }

    public final void a(ConnectionResult connectionResult, a<?> aVar, boolean z) {
    }

    public final boolean b() {
        return true;
    }

    public final void a() {
        for (a.f f2 : this.f8426a.f8446f.values()) {
            f2.f();
        }
        this.f8426a.m.f8431c = Collections.emptySet();
    }

    public final <A extends a.b, R extends l, T extends d.a<R, A>> T a(T t) {
        this.f8426a.m.f8429a.add(t);
        return t;
    }

    public final <A extends a.b, T extends d.a<? extends l, A>> T b(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public final void c() {
        ay ayVar = this.f8426a;
        ayVar.f8441a.lock();
        try {
            ayVar.k = new ag(ayVar, ayVar.f8448h, ayVar.f8449i, ayVar.f8444d, ayVar.j, ayVar.f8441a, ayVar.f8443c);
            ayVar.k.a();
            ayVar.f8442b.signalAll();
        } finally {
            ayVar.f8441a.unlock();
        }
    }
}
