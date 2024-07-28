package com.google.android.gms.internal.firebase_ml;

import java.util.concurrent.Callable;

final /* synthetic */ class dq implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final Cdo f9811a;

    /* renamed from: b  reason: collision with root package name */
    private final ea f9812b;

    /* renamed from: c  reason: collision with root package name */
    private final di f9813c;

    /* renamed from: d  reason: collision with root package name */
    private final dm f9814d;

    dq(Cdo doVar, ea eaVar, di diVar, dm dmVar) {
        this.f9811a = doVar;
        this.f9812b = eaVar;
        this.f9813c = diVar;
        this.f9814d = dmVar;
    }

    public final Object call() {
        return this.f9811a.a(this.f9812b, this.f9813c, this.f9814d);
    }
}
