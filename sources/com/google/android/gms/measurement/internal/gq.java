package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

final class gq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f12060a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f12061b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f12062c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ String f12063d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ ge f12064e;

    gq(ge geVar, AtomicReference atomicReference, String str, String str2, String str3) {
        this.f12064e = geVar;
        this.f12060a = atomicReference;
        this.f12061b = str;
        this.f12062c = str2;
        this.f12063d = str3;
    }

    public final void run() {
        this.f12064e.y.i().a((AtomicReference<List<zzv>>) this.f12060a, this.f12061b, this.f12062c, this.f12063d);
    }
}
