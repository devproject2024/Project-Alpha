package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import dagger.a.c;
import javax.a.a;

public final class l implements c<k> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Context> f7764a;

    /* renamed from: b  reason: collision with root package name */
    private final a<i> f7765b;

    public l(a<Context> aVar, a<i> aVar2) {
        this.f7764a = aVar;
        this.f7765b = aVar2;
    }

    public final /* synthetic */ Object get() {
        return new k(this.f7764a.get(), this.f7765b.get());
    }
}
