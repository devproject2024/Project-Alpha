package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.c.b;
import dagger.a.c;
import java.util.concurrent.Executor;
import javax.a.a;

public final class r implements c<o> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Executor> f7952a;

    /* renamed from: b  reason: collision with root package name */
    private final a<com.google.android.datatransport.runtime.scheduling.a.c> f7953b;

    /* renamed from: c  reason: collision with root package name */
    private final a<s> f7954c;

    /* renamed from: d  reason: collision with root package name */
    private final a<b> f7955d;

    public r(a<Executor> aVar, a<com.google.android.datatransport.runtime.scheduling.a.c> aVar2, a<s> aVar3, a<b> aVar4) {
        this.f7952a = aVar;
        this.f7953b = aVar2;
        this.f7954c = aVar3;
        this.f7955d = aVar4;
    }

    public final /* synthetic */ Object get() {
        return new o(this.f7952a.get(), this.f7953b.get(), this.f7954c.get(), this.f7955d.get());
    }
}
