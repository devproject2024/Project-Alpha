package com.google.android.play.core.missingsplits;

import android.content.Context;
import java.util.concurrent.atomic.AtomicReference;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReference<Boolean> f37485a = new AtomicReference<>((Object) null);

    public static a a(Context context) {
        return new d(context, Runtime.getRuntime(), new c(context, context.getPackageManager()), f37485a);
    }
}
