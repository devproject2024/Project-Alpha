package com.alipay.mobile.rome.syncsdk.e;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private ExecutorService f15087a;

    /* renamed from: b  reason: collision with root package name */
    private ScheduledExecutorService f15088b;

    /* synthetic */ d(byte b2) {
        this();
    }

    private d() {
        this.f15087a = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new n((byte) 0));
        this.f15088b = new ScheduledThreadPoolExecutor(0, new m((byte) 0));
    }

    public final synchronized void a(e eVar, Runnable runnable) {
        ExecutorService executorService = null;
        if (eVar == e.SYNC_RECEIVE) {
            if (this.f15087a == null || this.f15087a.isTerminated() || this.f15087a.isShutdown()) {
                this.f15087a = Executors.newSingleThreadExecutor(new n((byte) 0));
            }
            executorService = this.f15087a;
        } else if (eVar == e.SYNC_DISPATCH) {
            if (this.f15088b == null || this.f15088b.isTerminated() || this.f15088b.isShutdown()) {
                this.f15088b = Executors.newSingleThreadScheduledExecutor(new m((byte) 0));
            }
            executorService = this.f15088b;
        } else {
            h.a("SyncThreadManager", "unknown thread type: ".concat(String.valueOf(eVar)));
        }
        if (executorService == null) {
            executorService = Executors.newSingleThreadExecutor(new n((byte) 0));
        }
        if (executorService != null) {
            executorService.submit(runnable);
        }
    }
}
