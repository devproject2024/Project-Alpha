package com.google.android.play.core.d;

import java.util.concurrent.atomic.AtomicReference;

public final class av {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReference<au> f37363a = new AtomicReference<>((Object) null);

    static au a() {
        return f37363a.get();
    }

    public static void a(au auVar) {
        f37363a.compareAndSet((Object) null, auVar);
    }
}
