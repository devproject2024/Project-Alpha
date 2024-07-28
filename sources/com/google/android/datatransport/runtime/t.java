package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.scheduling.e;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.h;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.o;
import dagger.a.c;
import javax.a.a;

public final class t implements c<q> {

    /* renamed from: a  reason: collision with root package name */
    private final a<com.google.android.datatransport.runtime.d.a> f7956a;

    /* renamed from: b  reason: collision with root package name */
    private final a<com.google.android.datatransport.runtime.d.a> f7957b;

    /* renamed from: c  reason: collision with root package name */
    private final a<e> f7958c;

    /* renamed from: d  reason: collision with root package name */
    private final a<h> f7959d;

    /* renamed from: e  reason: collision with root package name */
    private final a<o> f7960e;

    public t(a<com.google.android.datatransport.runtime.d.a> aVar, a<com.google.android.datatransport.runtime.d.a> aVar2, a<e> aVar3, a<h> aVar4, a<o> aVar5) {
        this.f7956a = aVar;
        this.f7957b = aVar2;
        this.f7958c = aVar3;
        this.f7959d = aVar4;
        this.f7960e = aVar5;
    }

    public final /* synthetic */ Object get() {
        return new q(this.f7956a.get(), this.f7957b.get(), this.f7958c.get(), this.f7959d.get(), this.f7960e.get());
    }
}
