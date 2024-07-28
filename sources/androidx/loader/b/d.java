package androidx.loader.b;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

abstract class d<Params, Progress, Result> {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadFactory f3719a = new ThreadFactory() {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f3728a = new AtomicInteger(1);

        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.f3728a.getAndIncrement());
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final BlockingQueue<Runnable> f3720b = new LinkedBlockingQueue(10);

    /* renamed from: c  reason: collision with root package name */
    private static b f3721c;

    /* renamed from: d  reason: collision with root package name */
    public static final Executor f3722d;
    private static volatile Executor j;

    /* renamed from: e  reason: collision with root package name */
    final C0060d<Params, Result> f3723e = new C0060d<Params, Result>() {
        public final Result call() throws Exception {
            d.this.f3727i.set(true);
            Result result = null;
            try {
                Process.setThreadPriority(10);
                result = d.this.a();
                Binder.flushPendingCommands();
                d.this.d(result);
                return result;
            } catch (Throwable th) {
                d.this.d(result);
                throw th;
            }
        }
    };

    /* renamed from: f  reason: collision with root package name */
    final FutureTask<Result> f3724f = new FutureTask<Result>(this.f3723e) {
        /* access modifiers changed from: protected */
        public final void done() {
            try {
                d.this.c(get());
            } catch (InterruptedException unused) {
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
            } catch (CancellationException unused2) {
                d.this.c(null);
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    };

    /* renamed from: g  reason: collision with root package name */
    volatile c f3725g = c.PENDING;

    /* renamed from: h  reason: collision with root package name */
    final AtomicBoolean f3726h = new AtomicBoolean();

    /* renamed from: i  reason: collision with root package name */
    final AtomicBoolean f3727i = new AtomicBoolean();

    public enum c {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* access modifiers changed from: protected */
    public abstract Result a();

    /* access modifiers changed from: protected */
    public void a(Result result) {
    }

    /* access modifiers changed from: protected */
    public void b(Result result) {
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, f3720b, f3719a);
        f3722d = threadPoolExecutor;
        j = threadPoolExecutor;
    }

    private static Handler b() {
        b bVar;
        synchronized (d.class) {
            if (f3721c == null) {
                f3721c = new b();
            }
            bVar = f3721c;
        }
        return bVar;
    }

    d() {
    }

    /* access modifiers changed from: package-private */
    public final void c(Result result) {
        if (!this.f3727i.get()) {
            d(result);
        }
    }

    /* access modifiers changed from: package-private */
    public final Result d(Result result) {
        b().obtainMessage(1, new a(this, result)).sendToTarget();
        return result;
    }

    /* renamed from: androidx.loader.b.d$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3731a = new int[c.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                androidx.loader.b.d$c[] r0 = androidx.loader.b.d.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3731a = r0
                int[] r0 = f3731a     // Catch:{ NoSuchFieldError -> 0x0014 }
                androidx.loader.b.d$c r1 = androidx.loader.b.d.c.RUNNING     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f3731a     // Catch:{ NoSuchFieldError -> 0x001f }
                androidx.loader.b.d$c r1 = androidx.loader.b.d.c.FINISHED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.loader.b.d.AnonymousClass4.<clinit>():void");
        }
    }

    static class b extends Handler {
        b() {
            super(Looper.getMainLooper());
        }

        public final void handleMessage(Message message) {
            a aVar = (a) message.obj;
            if (message.what == 1) {
                aVar.f3732a.e(aVar.f3733b[0]);
            }
        }
    }

    /* renamed from: androidx.loader.b.d$d  reason: collision with other inner class name */
    static abstract class C0060d<Params, Result> implements Callable<Result> {

        /* renamed from: b  reason: collision with root package name */
        Params[] f3734b;

        C0060d() {
        }
    }

    static class a<Data> {

        /* renamed from: a  reason: collision with root package name */
        final d f3732a;

        /* renamed from: b  reason: collision with root package name */
        final Data[] f3733b;

        a(d dVar, Data... dataArr) {
            this.f3732a = dVar;
            this.f3733b = dataArr;
        }
    }

    /* access modifiers changed from: package-private */
    public final void e(Result result) {
        if (this.f3726h.get()) {
            b(result);
        } else {
            a(result);
        }
        this.f3725g = c.FINISHED;
    }
}
