package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

final class fj implements Callable<List<zzv>> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f11967a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f11968b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f11969c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ fd f11970d;

    fj(fd fdVar, String str, String str2, String str3) {
        this.f11970d = fdVar;
        this.f11967a = str;
        this.f11968b = str2;
        this.f11969c = str3;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.f11970d.f11950a.l();
        return this.f11970d.f11950a.c().b(this.f11967a, this.f11968b, this.f11969c);
    }
}
