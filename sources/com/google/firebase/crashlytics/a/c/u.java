package com.google.firebase.crashlytics.a.c;

import com.google.firebase.crashlytics.a.b;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class u {
    public static ExecutorService a(String str) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(b(str));
        a(str, newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    private static ThreadFactory b(final String str) {
        final AtomicLong atomicLong = new AtomicLong(1);
        return new ThreadFactory() {
            public final Thread newThread(final Runnable runnable) {
                Thread newThread = Executors.defaultThreadFactory().newThread(new d() {
                    public final void a() {
                        runnable.run();
                    }
                });
                newThread.setName(str + atomicLong.getAndIncrement());
                return newThread;
            }
        };
    }

    private static final void a(String str, ExecutorService executorService) {
        a(str, executorService, TimeUnit.SECONDS);
    }

    private static void a(final String str, final ExecutorService executorService, final TimeUnit timeUnit) {
        Runtime.getRuntime().addShutdownHook(new Thread(new d() {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ long f38319c = 2;

            public final void a() {
                try {
                    b a2 = b.a();
                    new StringBuilder("Executing shutdown hook for ").append(str);
                    a2.a(3);
                    executorService.shutdown();
                    if (!executorService.awaitTermination(this.f38319c, timeUnit)) {
                        b a3 = b.a();
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append(" did not shut down in the allocated time. Requesting immediate shutdown.");
                        a3.a(3);
                        executorService.shutdownNow();
                    }
                } catch (InterruptedException unused) {
                    b a4 = b.a();
                    String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", new Object[]{str});
                    a4.a(3);
                    executorService.shutdownNow();
                }
            }
        }, "Crashlytics Shutdown Hook for ".concat(String.valueOf(str))));
    }
}
