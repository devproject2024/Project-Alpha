package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

final class fh implements Callable<List<jr>> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f11959a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f11960b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f11961c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ fd f11962d;

    fh(fd fdVar, String str, String str2, String str3) {
        this.f11962d = fdVar;
        this.f11959a = str;
        this.f11960b = str2;
        this.f11961c = str3;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.f11962d.f11950a.l();
        return this.f11962d.f11950a.c().a(this.f11959a, this.f11960b, this.f11961c);
    }
}
