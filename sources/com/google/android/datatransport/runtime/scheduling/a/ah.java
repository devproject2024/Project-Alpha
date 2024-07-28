package com.google.android.datatransport.runtime.scheduling.a;

import android.content.Context;
import dagger.a.c;
import javax.a.a;

public final class ah implements c<ac> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Context> f7839a;

    /* renamed from: b  reason: collision with root package name */
    private final a<String> f7840b;

    /* renamed from: c  reason: collision with root package name */
    private final a<Integer> f7841c;

    public ah(a<Context> aVar, a<String> aVar2, a<Integer> aVar3) {
        this.f7839a = aVar;
        this.f7840b = aVar2;
        this.f7841c = aVar3;
    }

    public final /* synthetic */ Object get() {
        return new ac(this.f7839a.get(), this.f7840b.get(), this.f7841c.get().intValue());
    }
}
