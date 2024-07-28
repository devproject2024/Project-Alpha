package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

final class fi implements Callable<List<jr>> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzm f11963a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f11964b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f11965c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ fd f11966d;

    fi(fd fdVar, zzm zzm, String str, String str2) {
        this.f11966d = fdVar;
        this.f11963a = zzm;
        this.f11964b = str;
        this.f11965c = str2;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.f11966d.f11950a.l();
        return this.f11966d.f11950a.c().a(this.f11963a.f12380a, this.f11964b, this.f11965c);
    }
}
