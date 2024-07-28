package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class gs implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f12067a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f12068b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f12069c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ String f12070d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ boolean f12071e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ ge f12072f;

    gs(ge geVar, AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        this.f12072f = geVar;
        this.f12067a = atomicReference;
        this.f12068b = str;
        this.f12069c = str2;
        this.f12070d = str3;
        this.f12071e = z;
    }

    public final void run() {
        this.f12072f.y.i().a(this.f12067a, this.f12068b, this.f12069c, this.f12070d, this.f12071e);
    }
}
