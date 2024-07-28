package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class gn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Bundle f12054a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ ge f12055b;

    gn(ge geVar, Bundle bundle) {
        this.f12055b = geVar;
        this.f12054a = bundle;
    }

    public final void run() {
        ge.b(this.f12055b, this.f12054a);
    }
}
