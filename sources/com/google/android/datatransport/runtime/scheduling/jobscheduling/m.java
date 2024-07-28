package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.c.b;
import com.google.android.datatransport.runtime.l;

final /* synthetic */ class m implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private final h f7936a;

    /* renamed from: b  reason: collision with root package name */
    private final l f7937b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7938c;

    m(h hVar, l lVar, int i2) {
        this.f7936a = hVar;
        this.f7937b = lVar;
        this.f7938c = i2;
    }

    public final Object a() {
        h hVar = this.f7936a;
        hVar.f7920d.a(this.f7937b, this.f7938c + 1);
        return null;
    }
}
