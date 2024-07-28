package io.reactivex.rxjava3.j;

import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.e.a.d;
import io.reactivex.rxjava3.e.c.k;
import io.reactivex.rxjava3.e.e.b;
import io.reactivex.rxjava3.e.g.c;
import io.reactivex.rxjava3.e.k.j;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class f<T> extends e<T> {

    /* renamed from: a  reason: collision with root package name */
    final c<T> f47815a;

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<w<? super T>> f47816b = new AtomicReference<>();

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<Runnable> f47817c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f47818d = true;

    /* renamed from: e  reason: collision with root package name */
    volatile boolean f47819e;

    /* renamed from: f  reason: collision with root package name */
    volatile boolean f47820f;

    /* renamed from: g  reason: collision with root package name */
    Throwable f47821g;

    /* renamed from: h  reason: collision with root package name */
    final AtomicBoolean f47822h = new AtomicBoolean();

    /* renamed from: i  reason: collision with root package name */
    final b<T> f47823i = new a();
    boolean j;

    public static <T> f<T> a() {
        return new f<>(bufferSize(), (Runnable) null);
    }

    public static <T> f<T> a(int i2, Runnable runnable) {
        io.reactivex.rxjava3.e.b.b.a(i2, "capacityHint");
        Objects.requireNonNull(runnable, "onTerminate");
        return new f<>(i2, runnable);
    }

    private f(int i2, Runnable runnable) {
        this.f47815a = new c<>(i2);
        this.f47817c = new AtomicReference<>(runnable);
    }

    public final void subscribeActual(w<? super T> wVar) {
        if (this.f47822h.get() || !this.f47822h.compareAndSet(false, true)) {
            d.error((Throwable) new IllegalStateException("Only a single observer allowed."), (w<?>) wVar);
            return;
        }
        wVar.onSubscribe(this.f47823i);
        this.f47816b.lazySet(wVar);
        if (this.f47819e) {
            this.f47816b.lazySet((Object) null);
        } else {
            c();
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        Runnable runnable = this.f47817c.get();
        if (runnable != null && this.f47817c.compareAndSet(runnable, (Object) null)) {
            runnable.run();
        }
    }

    public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
        if (this.f47820f || this.f47819e) {
            cVar.dispose();
        }
    }

    public final void onNext(T t) {
        j.a(t, "onNext called with a null value.");
        if (!this.f47820f && !this.f47819e) {
            this.f47815a.offer(t);
            c();
        }
    }

    public final void onError(Throwable th) {
        j.a(th, "onError called with a null Throwable.");
        if (this.f47820f || this.f47819e) {
            io.reactivex.rxjava3.h.a.a(th);
            return;
        }
        this.f47821g = th;
        this.f47820f = true;
        b();
        c();
    }

    public final void onComplete() {
        if (!this.f47820f && !this.f47819e) {
            this.f47820f = true;
            b();
            c();
        }
    }

    private void a(w<? super T> wVar) {
        c<T> cVar = this.f47815a;
        boolean z = !this.f47818d;
        boolean z2 = true;
        int i2 = 1;
        while (!this.f47819e) {
            boolean z3 = this.f47820f;
            T poll = this.f47815a.poll();
            boolean z4 = poll == null;
            if (z3) {
                if (z && z2) {
                    if (!a(cVar, wVar)) {
                        z2 = false;
                    } else {
                        return;
                    }
                }
                if (z4) {
                    c(wVar);
                    return;
                }
            }
            if (!z4) {
                wVar.onNext(poll);
            } else {
                i2 = this.f47823i.addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
        }
        this.f47816b.lazySet((Object) null);
        cVar.clear();
    }

    private void b(w<? super T> wVar) {
        c<T> cVar = this.f47815a;
        int i2 = 1;
        boolean z = !this.f47818d;
        while (!this.f47819e) {
            boolean z2 = this.f47820f;
            if (!z || !z2 || !a(cVar, wVar)) {
                wVar.onNext(null);
                if (z2) {
                    c(wVar);
                    return;
                }
                i2 = this.f47823i.addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            } else {
                return;
            }
        }
        this.f47816b.lazySet((Object) null);
    }

    private void c(w<? super T> wVar) {
        this.f47816b.lazySet((Object) null);
        Throwable th = this.f47821g;
        if (th != null) {
            wVar.onError(th);
        } else {
            wVar.onComplete();
        }
    }

    private boolean a(k<T> kVar, w<? super T> wVar) {
        Throwable th = this.f47821g;
        if (th == null) {
            return false;
        }
        this.f47816b.lazySet((Object) null);
        kVar.clear();
        wVar.onError(th);
        return true;
    }

    private void c() {
        if (this.f47823i.getAndIncrement() == 0) {
            w wVar = this.f47816b.get();
            int i2 = 1;
            while (wVar == null) {
                i2 = this.f47823i.addAndGet(-i2);
                if (i2 != 0) {
                    wVar = this.f47816b.get();
                } else {
                    return;
                }
            }
            if (this.j) {
                b(wVar);
            } else {
                a(wVar);
            }
        }
    }

    final class a extends b<T> {
        private static final long serialVersionUID = 7926949470189395511L;

        a() {
        }

        public final int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            f.this.j = true;
            return 2;
        }

        public final T poll() {
            return f.this.f47815a.poll();
        }

        public final boolean isEmpty() {
            return f.this.f47815a.isEmpty();
        }

        public final void clear() {
            f.this.f47815a.clear();
        }

        public final void dispose() {
            if (!f.this.f47819e) {
                f fVar = f.this;
                fVar.f47819e = true;
                fVar.b();
                f.this.f47816b.lazySet((Object) null);
                if (f.this.f47823i.getAndIncrement() == 0) {
                    f.this.f47816b.lazySet((Object) null);
                    if (!f.this.j) {
                        f.this.f47815a.clear();
                    }
                }
            }
        }

        public final boolean isDisposed() {
            return f.this.f47819e;
        }
    }
}
