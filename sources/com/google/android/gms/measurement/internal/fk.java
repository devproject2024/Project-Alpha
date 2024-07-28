package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

final class fk implements Callable<List<zzv>> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzm f11971a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f11972b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f11973c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ fd f11974d;

    fk(fd fdVar, zzm zzm, String str, String str2) {
        this.f11974d = fdVar;
        this.f11971a = zzm;
        this.f11972b = str;
        this.f11973c = str2;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.f11974d.f11950a.l();
        return this.f11974d.f11950a.c().b(this.f11971a.f12380a, this.f11972b, this.f11973c);
    }
}
