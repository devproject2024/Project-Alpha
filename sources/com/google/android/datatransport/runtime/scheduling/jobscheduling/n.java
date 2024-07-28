package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.e;
import com.google.android.datatransport.runtime.c.b;
import dagger.a.c;
import java.util.concurrent.Executor;
import javax.a.a;

public final class n implements c<h> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Context> f7939a;

    /* renamed from: b  reason: collision with root package name */
    private final a<e> f7940b;

    /* renamed from: c  reason: collision with root package name */
    private final a<com.google.android.datatransport.runtime.scheduling.a.c> f7941c;

    /* renamed from: d  reason: collision with root package name */
    private final a<s> f7942d;

    /* renamed from: e  reason: collision with root package name */
    private final a<Executor> f7943e;

    /* renamed from: f  reason: collision with root package name */
    private final a<b> f7944f;

    /* renamed from: g  reason: collision with root package name */
    private final a<com.google.android.datatransport.runtime.d.a> f7945g;

    public n(a<Context> aVar, a<e> aVar2, a<com.google.android.datatransport.runtime.scheduling.a.c> aVar3, a<s> aVar4, a<Executor> aVar5, a<b> aVar6, a<com.google.android.datatransport.runtime.d.a> aVar7) {
        this.f7939a = aVar;
        this.f7940b = aVar2;
        this.f7941c = aVar3;
        this.f7942d = aVar4;
        this.f7943e = aVar5;
        this.f7944f = aVar6;
        this.f7945g = aVar7;
    }

    public final /* synthetic */ Object get() {
        return new h(this.f7939a.get(), this.f7940b.get(), this.f7941c.get(), this.f7942d.get(), this.f7943e.get(), this.f7944f.get(), this.f7945g.get());
    }
}
