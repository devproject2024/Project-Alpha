package com.bumptech.glide.g;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Executor f6612a = new Executor() {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f6614a = new Handler(Looper.getMainLooper());

        public final void execute(Runnable runnable) {
            this.f6614a.post(runnable);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final Executor f6613b = new Executor() {
        public final void execute(Runnable runnable) {
            runnable.run();
        }
    };

    public static Executor a() {
        return f6612a;
    }

    public static Executor b() {
        return f6613b;
    }
}
