package com.google.android.datatransport.runtime;

import dagger.a.c;
import dagger.a.g;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class i implements c<Executor> {

    /* renamed from: a  reason: collision with root package name */
    private static final i f7788a = new i();

    public static i a() {
        return f7788a;
    }

    public final /* synthetic */ Object get() {
        return (Executor) g.a(new j(Executors.newSingleThreadExecutor()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
