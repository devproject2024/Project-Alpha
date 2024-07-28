package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.util.a.c;
import com.google.android.gms.internal.base.f;
import com.google.android.gms.internal.base.g;
import com.google.android.gms.internal.base.h;
import java.util.concurrent.ExecutorService;

public final class az {

    /* renamed from: a  reason: collision with root package name */
    private static final ExecutorService f8450a;

    public static ExecutorService a() {
        return f8450a;
    }

    static {
        f a2 = g.a();
        c cVar = new c("GAC_Executor");
        int i2 = h.f9110a;
        f8450a = a2.a(cVar);
    }
}
