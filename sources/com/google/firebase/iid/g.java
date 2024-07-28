package com.google.firebase.iid;

import com.google.android.gms.common.util.a.b;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Executor f38864a = h.f38865a;

    static Executor a() {
        return f38864a;
    }

    static ExecutorService b() {
        return new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b("firebase-iid-executor"));
    }
}
