package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import dagger.a.c;
import javax.a.a;

public final class j implements c<i> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Context> f7756a;

    /* renamed from: b  reason: collision with root package name */
    private final a<com.google.android.datatransport.runtime.d.a> f7757b;

    /* renamed from: c  reason: collision with root package name */
    private final a<com.google.android.datatransport.runtime.d.a> f7758c;

    public j(a<Context> aVar, a<com.google.android.datatransport.runtime.d.a> aVar2, a<com.google.android.datatransport.runtime.d.a> aVar3) {
        this.f7756a = aVar;
        this.f7757b = aVar2;
        this.f7758c = aVar3;
    }

    public final /* synthetic */ Object get() {
        return new i(this.f7756a.get(), this.f7757b.get(), this.f7758c.get());
    }
}
