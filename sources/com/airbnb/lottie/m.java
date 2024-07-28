package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import com.airbnb.lottie.f.d;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public final class m<T> {

    /* renamed from: a  reason: collision with root package name */
    public static Executor f6166a = Executors.newCachedThreadPool();

    /* renamed from: b  reason: collision with root package name */
    private final Set<h<T>> f6167b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<h<Throwable>> f6168c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f6169d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public volatile l<T> f6170e;

    public m(Callable<l<T>> callable) {
        this(callable, (byte) 0);
    }

    private m(Callable<l<T>> callable, byte b2) {
        this.f6167b = new LinkedHashSet(1);
        this.f6168c = new LinkedHashSet(1);
        this.f6169d = new Handler(Looper.getMainLooper());
        this.f6170e = null;
        f6166a.execute(new a(callable));
    }

    public final synchronized m<T> a(h<T> hVar) {
        if (!(this.f6170e == null || this.f6170e.f6164a == null)) {
            hVar.onResult(this.f6170e.f6164a);
        }
        this.f6167b.add(hVar);
        return this;
    }

    public final synchronized m<T> b(h<T> hVar) {
        this.f6167b.remove(hVar);
        return this;
    }

    public final synchronized m<T> c(h<Throwable> hVar) {
        if (!(this.f6170e == null || this.f6170e.f6165b == null)) {
            hVar.onResult(this.f6170e.f6165b);
        }
        this.f6168c.add(hVar);
        return this;
    }

    public final synchronized m<T> d(h<Throwable> hVar) {
        this.f6168c.remove(hVar);
        return this;
    }

    /* access modifiers changed from: private */
    public synchronized void a(T t) {
        for (h onResult : new ArrayList(this.f6167b)) {
            onResult.onResult(t);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void a(Throwable th) {
        ArrayList<h> arrayList = new ArrayList<>(this.f6168c);
        if (arrayList.isEmpty()) {
            d.b("Lottie encountered an error but no failure listener was added:");
            return;
        }
        for (h onResult : arrayList) {
            onResult.onResult(th);
        }
    }

    class a extends FutureTask<l<T>> {
        a(Callable<l<T>> callable) {
            super(callable);
        }

        /* access modifiers changed from: protected */
        public final void done() {
            if (!isCancelled()) {
                try {
                    m.a(m.this, (l) get());
                } catch (InterruptedException | ExecutionException e2) {
                    m.a(m.this, new l(e2));
                }
            }
        }
    }

    static /* synthetic */ void a(m mVar, l lVar) {
        if (mVar.f6170e == null) {
            mVar.f6170e = lVar;
            mVar.f6169d.post(new Runnable() {
                public final void run() {
                    if (m.this.f6170e != null) {
                        l a2 = m.this.f6170e;
                        if (a2.f6164a != null) {
                            m.this.a(a2.f6164a);
                        } else {
                            m.this.a(a2.f6165b);
                        }
                    }
                }
            });
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }
}
