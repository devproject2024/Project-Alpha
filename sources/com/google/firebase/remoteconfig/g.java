package com.google.firebase.remoteconfig;

import java.util.concurrent.Callable;

public final /* synthetic */ class g implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final a f39344a;

    /* renamed from: b  reason: collision with root package name */
    private final n f39345b;

    private g(a aVar, n nVar) {
        this.f39344a = aVar;
        this.f39345b = nVar;
    }

    public static Callable a(a aVar, n nVar) {
        return new g(aVar, nVar);
    }

    public final Object call() {
        return a.a(this.f39344a, this.f39345b);
    }
}
