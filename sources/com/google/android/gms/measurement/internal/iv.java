package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final /* synthetic */ class iv implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final it f12235a;

    iv(it itVar) {
        this.f12235a = itVar;
    }

    public final void run() {
        it itVar = this.f12235a;
        itVar.f12232c.h();
        itVar.f12232c.J_().j.a("Application backgrounded");
        itVar.f12232c.b().b("auto", "_ab", new Bundle());
    }
}
