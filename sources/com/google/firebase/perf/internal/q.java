package com.google.firebase.perf.internal;

import com.google.android.gms.internal.p001firebaseperf.ar;

final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final GaugeManager f39224a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39225b;

    /* renamed from: c  reason: collision with root package name */
    private final ar f39226c;

    q(GaugeManager gaugeManager, String str, ar arVar) {
        this.f39224a = gaugeManager;
        this.f39225b = str;
        this.f39226c = arVar;
    }

    public final void run() {
        this.f39224a.zze(this.f39225b, this.f39226c);
    }
}
