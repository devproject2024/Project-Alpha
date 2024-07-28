package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

final class ih implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ ComponentName f12206a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Cif f12207b;

    ih(Cif ifVar, ComponentName componentName) {
        this.f12207b = ifVar;
        this.f12206a = componentName;
    }

    public final void run() {
        hm.a(this.f12207b.f12199c, this.f12206a);
    }
}
