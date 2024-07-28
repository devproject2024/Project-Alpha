package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

final class jm implements Callable<String> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzm f12281a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ jj f12282b;

    jm(jj jjVar, zzm zzm) {
        this.f12282b = jjVar;
        this.f12281a = zzm;
    }

    public final /* synthetic */ Object call() throws Exception {
        fb c2 = this.f12282b.c(this.f12281a);
        if (c2 != null) {
            return c2.c();
        }
        this.f12282b.J_().f11831f.a("App info was null when attempting to get app instance id");
        return null;
    }
}
