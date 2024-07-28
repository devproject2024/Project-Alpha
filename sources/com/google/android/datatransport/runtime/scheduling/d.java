package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.backends.e;
import com.google.android.datatransport.runtime.c.b;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.s;
import dagger.a.c;
import java.util.concurrent.Executor;
import javax.a.a;

public final class d implements c<a> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Executor> f7886a;

    /* renamed from: b  reason: collision with root package name */
    private final a<e> f7887b;

    /* renamed from: c  reason: collision with root package name */
    private final a<s> f7888c;

    /* renamed from: d  reason: collision with root package name */
    private final a<com.google.android.datatransport.runtime.scheduling.a.c> f7889d;

    /* renamed from: e  reason: collision with root package name */
    private final a<b> f7890e;

    public d(a<Executor> aVar, a<e> aVar2, a<s> aVar3, a<com.google.android.datatransport.runtime.scheduling.a.c> aVar4, a<b> aVar5) {
        this.f7886a = aVar;
        this.f7887b = aVar2;
        this.f7888c = aVar3;
        this.f7889d = aVar4;
        this.f7890e = aVar5;
    }

    public final /* synthetic */ Object get() {
        return new a(this.f7886a.get(), this.f7887b.get(), this.f7888c.get(), this.f7889d.get(), this.f7890e.get());
    }
}
