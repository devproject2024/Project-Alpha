package com.appsflyer;

import android.net.TrafficStats;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AFExecutor {

    /* renamed from: ι  reason: contains not printable characters */
    private static AFExecutor f23;

    /* renamed from: ı  reason: contains not printable characters */
    final ThreadFactory f24 = new ThreadFactory() {
        public final Thread newThread(final Runnable runnable) {
            return new Thread(new Runnable() {
                public final void run() {
                    TrafficStats.setThreadStatsTag("AppsFlyer".hashCode());
                    runnable.run();
                }
            });
        }
    };

    /* renamed from: ǃ  reason: contains not printable characters */
    ScheduledExecutorService f25;

    /* renamed from: ɩ  reason: contains not printable characters */
    ScheduledExecutorService f26;

    /* renamed from: Ι  reason: contains not printable characters */
    Executor f27;

    private AFExecutor() {
    }

    public static AFExecutor getInstance() {
        if (f23 == null) {
            f23 = new AFExecutor();
        }
        return f23;
    }

    public Executor getThreadPoolExecutor() {
        Executor executor = this.f27;
        if (executor == null || ((executor instanceof ThreadPoolExecutor) && (((ThreadPoolExecutor) executor).isShutdown() || ((ThreadPoolExecutor) this.f27).isTerminated() || ((ThreadPoolExecutor) this.f27).isTerminating()))) {
            this.f27 = Executors.newFixedThreadPool(2, this.f24);
        }
        return this.f27;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ι  reason: contains not printable characters */
    public final ScheduledThreadPoolExecutor m8() {
        ScheduledExecutorService scheduledExecutorService = this.f26;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown() || this.f26.isTerminated()) {
            this.f26 = Executors.newScheduledThreadPool(2, this.f24);
        }
        return (ScheduledThreadPoolExecutor) this.f26;
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    static void m7(ExecutorService executorService) {
        try {
            AFLogger.afRDLog("shut downing executor ...");
            executorService.shutdown();
            executorService.awaitTermination(10, TimeUnit.SECONDS);
            if (!executorService.isTerminated()) {
                AFLogger.afRDLog("killing non-finished tasks");
            }
            executorService.shutdownNow();
        } catch (InterruptedException unused) {
            AFLogger.afRDLog("InterruptedException!!!");
            if (!executorService.isTerminated()) {
                AFLogger.afRDLog("killing non-finished tasks");
            }
            executorService.shutdownNow();
        } catch (Throwable th) {
            if (!executorService.isTerminated()) {
                AFLogger.afRDLog("killing non-finished tasks");
            }
            executorService.shutdownNow();
            throw th;
        }
    }
}
