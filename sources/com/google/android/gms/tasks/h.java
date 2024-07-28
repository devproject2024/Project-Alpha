package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.s;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class h {

    interface c extends OnFailureListener, OnSuccessListener<Object>, b {
    }

    public static <TResult> Task<TResult> a(TResult tresult) {
        ab abVar = new ab();
        abVar.a(tresult);
        return abVar;
    }

    public static final class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final CountDownLatch f12482a;

        private a() {
            this.f12482a = new CountDownLatch(1);
        }

        public final void onSuccess(Object obj) {
            this.f12482a.countDown();
        }

        public final void onFailure(Exception exc) {
            this.f12482a.countDown();
        }

        public final void a() {
            this.f12482a.countDown();
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static <TResult> Task<TResult> a(Exception exc) {
        ab abVar = new ab();
        abVar.a(exc);
        return abVar;
    }

    static final class b implements c {

        /* renamed from: a  reason: collision with root package name */
        private final Object f12483a = new Object();

        /* renamed from: b  reason: collision with root package name */
        private final int f12484b;

        /* renamed from: c  reason: collision with root package name */
        private final ab<Void> f12485c;

        /* renamed from: d  reason: collision with root package name */
        private int f12486d;

        /* renamed from: e  reason: collision with root package name */
        private int f12487e;

        /* renamed from: f  reason: collision with root package name */
        private int f12488f;

        /* renamed from: g  reason: collision with root package name */
        private Exception f12489g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f12490h;

        public b(int i2, ab<Void> abVar) {
            this.f12484b = i2;
            this.f12485c = abVar;
        }

        public final void onFailure(Exception exc) {
            synchronized (this.f12483a) {
                this.f12487e++;
                this.f12489g = exc;
                b();
            }
        }

        public final void onSuccess(Object obj) {
            synchronized (this.f12483a) {
                this.f12486d++;
                b();
            }
        }

        public final void a() {
            synchronized (this.f12483a) {
                this.f12488f++;
                this.f12490h = true;
                b();
            }
        }

        private final void b() {
            int i2 = this.f12486d;
            int i3 = this.f12487e;
            int i4 = i2 + i3 + this.f12488f;
            int i5 = this.f12484b;
            if (i4 != i5) {
                return;
            }
            if (this.f12489g != null) {
                ab<Void> abVar = this.f12485c;
                StringBuilder sb = new StringBuilder(54);
                sb.append(i3);
                sb.append(" out of ");
                sb.append(i5);
                sb.append(" underlying tasks failed");
                abVar.a((Exception) new ExecutionException(sb.toString(), this.f12489g));
            } else if (this.f12490h) {
                this.f12485c.f();
            } else {
                this.f12485c.a(null);
            }
        }
    }

    public static <TResult> Task<TResult> a(Executor executor, Callable<TResult> callable) {
        s.a(executor, (Object) "Executor must not be null");
        s.a(callable, (Object) "Callback must not be null");
        ab abVar = new ab();
        executor.execute(new af(abVar, callable));
        return abVar;
    }

    public static Task<Void> a(Collection<? extends Task<?>> collection) {
        if (collection == null || collection.isEmpty()) {
            return a((Object) null);
        }
        for (Task task : collection) {
            if (task == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        ab abVar = new ab();
        b bVar = new b(collection.size(), abVar);
        for (Task a2 : collection) {
            a((Task<?>) a2, (c) bVar);
        }
        return abVar;
    }

    public static Task<Void> a(Task<?>... taskArr) {
        return a((Collection<? extends Task<?>>) Arrays.asList(taskArr));
    }

    public static Task<List<Task<?>>> b(Task<?>... taskArr) {
        List asList = Arrays.asList(taskArr);
        if (asList == null || asList.isEmpty()) {
            return a(Collections.emptyList());
        }
        return a((Collection<? extends Task<?>>) asList).b(new i(asList));
    }

    public static <TResult> TResult a(Task<TResult> task) throws ExecutionException {
        if (task.b()) {
            return task.d();
        }
        if (task.c()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(task.e());
    }

    public static void a(Task<?> task, c cVar) {
        task.a(g.f12480b, (OnSuccessListener<? super Object>) cVar);
        task.a(g.f12480b, (OnFailureListener) cVar);
        task.a(g.f12480b, (b) cVar);
    }

    public static <TResult> TResult a(Task<TResult> task, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        s.c("Must not be called on the main application thread");
        s.a(task, (Object) "Task must not be null");
        s.a(timeUnit, (Object) "TimeUnit must not be null");
        if (task.a()) {
            return a(task);
        }
        a aVar = new a((byte) 0);
        a((Task<?>) task, (c) aVar);
        if (aVar.f12482a.await(j, timeUnit)) {
            return a(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }
}
