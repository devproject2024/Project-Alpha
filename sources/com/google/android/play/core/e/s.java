package com.google.android.play.core.e;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

final class s implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f37477a = new Handler(Looper.getMainLooper());

    public final void execute(Runnable runnable) {
        this.f37477a.post(runnable);
    }
}
