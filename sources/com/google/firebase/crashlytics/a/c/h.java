package com.google.firebase.crashlytics.a.c;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.a;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    final ExecutorService f38186a;

    /* renamed from: b  reason: collision with root package name */
    ThreadLocal<Boolean> f38187b = new ThreadLocal<>();

    /* renamed from: c  reason: collision with root package name */
    private Task<Void> f38188c = com.google.android.gms.tasks.h.a(null);

    /* renamed from: d  reason: collision with root package name */
    private final Object f38189d = new Object();

    public h(ExecutorService executorService) {
        this.f38186a = executorService;
        executorService.submit(new Runnable() {
            public final void run() {
                h.this.f38187b.set(Boolean.TRUE);
            }
        });
    }

    public final Task<Void> a(final Runnable runnable) {
        return a(new Callable<Void>() {
            public final /* synthetic */ Object call() throws Exception {
                runnable.run();
                return null;
            }
        });
    }

    private <T> a<Void, T> c(final Callable<T> callable) {
        return new a<Void, T>() {
            public final T a(Task<Void> task) throws Exception {
                return callable.call();
            }
        };
    }

    private <T> Task<Void> a(Task<T> task) {
        return task.a((Executor) this.f38186a, (a<T, TContinuationResult>) new a<T, Void>() {
            public final /* bridge */ /* synthetic */ Object a(Task task) throws Exception {
                return null;
            }
        });
    }

    public final <T> Task<T> a(Callable<T> callable) {
        Task<TContinuationResult> a2;
        synchronized (this.f38189d) {
            a2 = this.f38188c.a((Executor) this.f38186a, c(callable));
            this.f38188c = a(a2);
        }
        return a2;
    }

    public final <T> Task<T> b(Callable<Task<T>> callable) {
        Task<TContinuationResult> b2;
        synchronized (this.f38189d) {
            b2 = this.f38188c.b(this.f38186a, c(callable));
            this.f38188c = a(b2);
        }
        return b2;
    }

    public final void a() {
        if (!Boolean.TRUE.equals(this.f38187b.get())) {
            throw new IllegalStateException("Not running on background worker thread as intended.");
        }
    }
}
