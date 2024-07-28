package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.util.a.c;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class bp {

    /* renamed from: a  reason: collision with root package name */
    private static final ExecutorService f8472a = new ThreadPoolExecutor(0, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c("GAC_Transform"));

    public static ExecutorService a() {
        return f8472a;
    }
}
