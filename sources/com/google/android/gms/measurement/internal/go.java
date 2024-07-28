package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class go implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Bundle f12056a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ ge f12057b;

    go(ge geVar, Bundle bundle) {
        this.f12057b = geVar;
        this.f12056a = bundle;
    }

    public final void run() {
        ge.a(this.f12057b, this.f12056a);
    }
}
