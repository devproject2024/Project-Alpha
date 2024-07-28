package com.google.android.gms.measurement.internal;

import java.util.ArrayList;

final class iq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ jj f12222a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Runnable f12223b;

    iq(jj jjVar, Runnable runnable) {
        this.f12222a = jjVar;
        this.f12223b = runnable;
    }

    public final void run() {
        this.f12222a.l();
        jj jjVar = this.f12222a;
        Runnable runnable = this.f12223b;
        jjVar.f();
        if (jjVar.f12267c == null) {
            jjVar.f12267c = new ArrayList();
        }
        jjVar.f12267c.add(runnable);
        this.f12222a.h();
    }
}
