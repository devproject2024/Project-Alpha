package com.arthurivanets.arvi.a.b;

import android.os.Handler;
import com.google.android.exoplayer2.f.ad;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.f.l;

public final class a<T extends d, S extends ad> implements ad, d {

    /* renamed from: a  reason: collision with root package name */
    final T f30982a;

    /* renamed from: b  reason: collision with root package name */
    final S f30983b;

    public a(T t, S s) {
        this.f30982a = t;
        this.f30983b = s;
    }

    public final void a(Handler handler, d.a aVar) {
        this.f30982a.a(handler, aVar);
    }

    public final void a(d.a aVar) {
        this.f30982a.a(aVar);
    }

    public final ad a() {
        return this.f30982a.a();
    }

    public final long b() {
        return this.f30982a.b();
    }

    public final void a(i iVar, l lVar, boolean z) {
        this.f30983b.a(iVar, lVar, z);
    }

    public final void a(i iVar, l lVar, boolean z, int i2) {
        this.f30983b.a(iVar, lVar, z, i2);
    }

    public final void b(i iVar, l lVar, boolean z) {
        this.f30983b.b(iVar, lVar, z);
    }
}
