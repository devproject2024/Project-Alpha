package com.google.firebase.remoteconfig.internal;

import java.util.concurrent.Callable;

final /* synthetic */ class b implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final a f39360a;

    /* renamed from: b  reason: collision with root package name */
    private final f f39361b;

    private b(a aVar, f fVar) {
        this.f39360a = aVar;
        this.f39361b = fVar;
    }

    public static Callable a(a aVar, f fVar) {
        return new b(aVar, fVar);
    }

    public final Object call() {
        return this.f39360a.f39357c.a(this.f39361b);
    }
}
