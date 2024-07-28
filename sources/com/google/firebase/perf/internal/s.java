package com.google.firebase.perf.internal;

import com.google.android.gms.internal.p001firebaseperf.ar;

final /* synthetic */ class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final GaugeManager f39228a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39229b;

    /* renamed from: c  reason: collision with root package name */
    private final ar f39230c;

    s(GaugeManager gaugeManager, String str, ar arVar) {
        this.f39228a = gaugeManager;
        this.f39229b = str;
        this.f39230c = arVar;
    }

    public final void run() {
        this.f39228a.zzd(this.f39229b, this.f39230c);
    }
}
