package com.google.android.gms.common.util.a;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.d.h;
import java.util.concurrent.Executor;

public final class a implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f8960a;

    public a(Looper looper) {
        this.f8960a = new h(looper);
    }

    public final void execute(Runnable runnable) {
        this.f8960a.post(runnable);
    }
}
