package com.bumptech.glide.load.b.c;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class a implements ExecutorService {

    /* renamed from: a  reason: collision with root package name */
    private static final long f6817a = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: b  reason: collision with root package name */
    private static volatile int f6818b;

    /* renamed from: c  reason: collision with root package name */
    private final ExecutorService f6819c;

    public interface c {

        /* renamed from: a  reason: collision with root package name */
        public static final c f6831a = new c() {
            public final void a(Throwable th) {
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final c f6832b = new c() {
            public final void a(Throwable th) {
                Log.isLoggable("GlideExecutor", 6);
            }
        };

        /* renamed from: c  reason: collision with root package name */
        public static final c f6833c = new c() {
            public final void a(Throwable th) {
                throw new RuntimeException("Request threw uncaught throwable", th);
            }
        };

        /* renamed from: d  reason: collision with root package name */
        public static final c f6834d = f6832b;

        void a(Throwable th);
    }

    public static a c() {
        return new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f6817a, TimeUnit.MILLISECONDS, new SynchronousQueue(), new b("source-unlimited", c.f6834d, false)));
    }

    a(ExecutorService executorService) {
        this.f6819c = executorService;
    }

    public final void execute(Runnable runnable) {
        this.f6819c.execute(runnable);
    }

    public final Future<?> submit(Runnable runnable) {
        return this.f6819c.submit(runnable);
    }

    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f6819c.invokeAll(collection);
    }

    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        return this.f6819c.invokeAll(collection, j, timeUnit);
    }

    public final <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return this.f6819c.invokeAny(collection);
    }

    public final <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.f6819c.invokeAny(collection, j, timeUnit);
    }

    public final <T> Future<T> submit(Runnable runnable, T t) {
        return this.f6819c.submit(runnable, t);
    }

    public final <T> Future<T> submit(Callable<T> callable) {
        return this.f6819c.submit(callable);
    }

    public final void shutdown() {
        this.f6819c.shutdown();
    }

    public final List<Runnable> shutdownNow() {
        return this.f6819c.shutdownNow();
    }

    public final boolean isShutdown() {
        return this.f6819c.isShutdown();
    }

    public final boolean isTerminated() {
        return this.f6819c.isTerminated();
    }

    public final boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.f6819c.awaitTermination(j, timeUnit);
    }

    public final String toString() {
        return this.f6819c.toString();
    }

    private static int e() {
        if (f6818b == 0) {
            f6818b = Math.min(4, b.a());
        }
        return f6818b;
    }

    static final class b implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        final c f6826a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f6827b;

        /* renamed from: c  reason: collision with root package name */
        private final String f6828c;

        /* renamed from: d  reason: collision with root package name */
        private int f6829d;

        b(String str, c cVar, boolean z) {
            this.f6828c = str;
            this.f6826a = cVar;
            this.f6827b = z;
        }

        public final synchronized Thread newThread(Runnable runnable) {
            AnonymousClass1 r0;
            r0 = new Thread(runnable, "glide-" + this.f6828c + "-thread-" + this.f6829d) {
                public final void run() {
                    Process.setThreadPriority(9);
                    if (b.this.f6827b) {
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        super.run();
                    } catch (Throwable th) {
                        b.this.f6826a.a(th);
                    }
                }
            };
            this.f6829d = this.f6829d + 1;
            return r0;
        }
    }

    /* renamed from: com.bumptech.glide.load.b.c.a$a  reason: collision with other inner class name */
    public static final class C0095a {

        /* renamed from: a  reason: collision with root package name */
        String f6820a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f6821b;

        /* renamed from: c  reason: collision with root package name */
        private int f6822c;

        /* renamed from: d  reason: collision with root package name */
        private int f6823d;

        /* renamed from: e  reason: collision with root package name */
        private c f6824e = c.f6834d;

        /* renamed from: f  reason: collision with root package name */
        private long f6825f;

        C0095a(boolean z) {
            this.f6821b = z;
        }

        public final C0095a a(int i2) {
            this.f6822c = i2;
            this.f6823d = i2;
            return this;
        }

        public final a a() {
            if (!TextUtils.isEmpty(this.f6820a)) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.f6822c, this.f6823d, this.f6825f, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new b(this.f6820a, this.f6824e, this.f6821b));
                if (this.f6825f != 0) {
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
                return new a(threadPoolExecutor);
            }
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f6820a);
        }
    }

    public static a a() {
        C0095a a2 = new C0095a(true).a(1);
        a2.f6820a = "disk-cache";
        return a2.a();
    }

    public static a b() {
        C0095a a2 = new C0095a(false).a(e());
        a2.f6820a = "source";
        return a2.a();
    }

    public static a d() {
        C0095a a2 = new C0095a(true).a(e() >= 4 ? 2 : 1);
        a2.f6820a = "animation";
        return a2.a();
    }
}
