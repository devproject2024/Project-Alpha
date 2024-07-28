package com.google.android.gms.internal.firebase_ml;

import java.util.concurrent.Callable;

final /* synthetic */ class dv implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final ef f9833a;

    private dv(ef efVar) {
        this.f9833a = efVar;
    }

    static Callable a(ef efVar) {
        return new dv(efVar);
    }

    public final Object call() {
        return this.f9833a.c();
    }
}
