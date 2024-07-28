package com.google.firebase.remoteconfig.internal;

import java.util.concurrent.Executor;

final /* synthetic */ class e implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private static final e f39366a = new e();

    private e() {
    }

    public static Executor a() {
        return f39366a;
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
