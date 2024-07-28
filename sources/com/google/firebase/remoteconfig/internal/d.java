package com.google.firebase.remoteconfig.internal;

import java.util.concurrent.Callable;

final /* synthetic */ class d implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final n f39365a;

    private d(n nVar) {
        this.f39365a = nVar;
    }

    public static Callable a(n nVar) {
        return new d(nVar);
    }

    public final Object call() {
        return this.f39365a.a();
    }
}
