package com.google.firebase.remoteconfig;

import java.util.concurrent.Callable;

final /* synthetic */ class p implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final o f39443a;

    private p(o oVar) {
        this.f39443a = oVar;
    }

    public static Callable a(o oVar) {
        return new p(oVar);
    }

    public final Object call() {
        return this.f39443a.a("firebase");
    }
}
