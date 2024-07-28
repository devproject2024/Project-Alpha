package com.google.android.gms.measurement.internal;

final class gi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f12033a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f12034b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ Object f12035c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ long f12036d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ ge f12037e;

    gi(ge geVar, String str, String str2, Object obj, long j) {
        this.f12037e = geVar;
        this.f12033a = str;
        this.f12034b = str2;
        this.f12035c = obj;
        this.f12036d = j;
    }

    public final void run() {
        this.f12037e.a(this.f12033a, this.f12034b, this.f12035c, this.f12036d);
    }
}
