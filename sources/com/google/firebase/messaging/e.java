package com.google.firebase.messaging;

import java.util.concurrent.Executor;

final /* synthetic */ class e implements Executor {

    /* renamed from: a  reason: collision with root package name */
    static final Executor f39006a = new e();

    private e() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
