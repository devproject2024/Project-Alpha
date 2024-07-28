package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.k.b;
import java.util.concurrent.Executor;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final Executor f12479a = new a();

    /* renamed from: b  reason: collision with root package name */
    static final Executor f12480b = new aa();

    static final class a implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f12481a = new b(Looper.getMainLooper());

        public final void execute(Runnable runnable) {
            this.f12481a.post(runnable);
        }
    }
}
