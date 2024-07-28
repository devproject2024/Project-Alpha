package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

final class aw extends bj {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<as> f8439a;

    aw(as asVar) {
        this.f8439a = new WeakReference<>(asVar);
    }

    public final void a() {
        as asVar = (as) this.f8439a.get();
        if (asVar != null) {
            as.a(asVar);
        }
    }
}
