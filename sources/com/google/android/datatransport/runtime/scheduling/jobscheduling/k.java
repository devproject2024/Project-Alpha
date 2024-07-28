package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.backends.g;
import com.google.android.datatransport.runtime.c.b;
import com.google.android.datatransport.runtime.l;
import com.google.android.datatransport.runtime.scheduling.a.h;

final /* synthetic */ class k implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private final h f7930a;

    /* renamed from: b  reason: collision with root package name */
    private final g f7931b;

    /* renamed from: c  reason: collision with root package name */
    private final Iterable f7932c;

    /* renamed from: d  reason: collision with root package name */
    private final l f7933d;

    /* renamed from: e  reason: collision with root package name */
    private final int f7934e;

    k(h hVar, g gVar, Iterable iterable, l lVar, int i2) {
        this.f7930a = hVar;
        this.f7931b = gVar;
        this.f7932c = iterable;
        this.f7933d = lVar;
        this.f7934e = i2;
    }

    public final Object a() {
        h hVar = this.f7930a;
        g gVar = this.f7931b;
        Iterable iterable = this.f7932c;
        l lVar = this.f7933d;
        int i2 = this.f7934e;
        if (gVar.a() == g.a.TRANSIENT_ERROR) {
            hVar.f7919c.a((Iterable<h>) iterable);
            hVar.f7920d.a(lVar, i2 + 1);
            return null;
        }
        hVar.f7919c.b((Iterable<h>) iterable);
        if (gVar.a() == g.a.OK) {
            hVar.f7919c.a(lVar, hVar.f7922f.a() + gVar.b());
        }
        if (!hVar.f7919c.b(lVar)) {
            return null;
        }
        hVar.f7920d.a(lVar, 1);
        return null;
    }
}
