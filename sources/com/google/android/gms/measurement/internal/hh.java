package com.google.android.gms.measurement.internal;

import java.util.Map;

final /* synthetic */ class hh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final he f12100a;

    /* renamed from: b  reason: collision with root package name */
    private final int f12101b;

    /* renamed from: c  reason: collision with root package name */
    private final Exception f12102c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f12103d;

    /* renamed from: e  reason: collision with root package name */
    private final Map f12104e;

    hh(he heVar, int i2, Exception exc, byte[] bArr, Map map) {
        this.f12100a = heVar;
        this.f12101b = i2;
        this.f12102c = exc;
        this.f12103d = bArr;
        this.f12104e = map;
    }

    public final void run() {
        he heVar = this.f12100a;
        heVar.f12094a.a(this.f12101b, this.f12102c, this.f12103d);
    }
}
