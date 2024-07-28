package io.reactivex.rxjava3.g;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.d;
import io.reactivex.rxjava3.a.m;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import java.util.concurrent.atomic.AtomicReference;

public final class g<T> extends a<T, g<T>> implements aa<T>, d, m<T>, w<T>, c {

    /* renamed from: g  reason: collision with root package name */
    private final w<? super T> f47761g;

    /* renamed from: h  reason: collision with root package name */
    private final AtomicReference<c> f47762h;

    enum a implements w<Object> {
        INSTANCE;

        public final void onComplete() {
        }

        public final void onError(Throwable th) {
        }

        public final void onNext(Object obj) {
        }

        public final void onSubscribe(c cVar) {
        }
    }

    public g() {
        this(a.INSTANCE);
    }

    private g(w<? super T> wVar) {
        this.f47762h = new AtomicReference<>();
        this.f47761g = wVar;
    }

    public final void onSubscribe(c cVar) {
        this.f47748e = Thread.currentThread();
        if (cVar == null) {
            this.f47746c.add(new NullPointerException("onSubscribe received a null Subscription"));
        } else if (!this.f47762h.compareAndSet((Object) null, cVar)) {
            cVar.dispose();
            if (this.f47762h.get() != io.reactivex.rxjava3.e.a.c.DISPOSED) {
                this.f47746c.add(new IllegalStateException("onSubscribe received multiple subscriptions: ".concat(String.valueOf(cVar))));
            }
        } else {
            this.f47761g.onSubscribe(cVar);
        }
    }

    public final void onNext(T t) {
        if (!this.f47749f) {
            this.f47749f = true;
            if (this.f47762h.get() == null) {
                this.f47746c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.f47748e = Thread.currentThread();
        this.f47745b.add(t);
        if (t == null) {
            this.f47746c.add(new NullPointerException("onNext received a null value"));
        }
        this.f47761g.onNext(t);
    }

    public final void onError(Throwable th) {
        if (!this.f47749f) {
            this.f47749f = true;
            if (this.f47762h.get() == null) {
                this.f47746c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f47748e = Thread.currentThread();
            if (th == null) {
                this.f47746c.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.f47746c.add(th);
            }
            this.f47761g.onError(th);
        } finally {
            this.f47744a.countDown();
        }
    }

    public final void onComplete() {
        if (!this.f47749f) {
            this.f47749f = true;
            if (this.f47762h.get() == null) {
                this.f47746c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f47748e = Thread.currentThread();
            this.f47747d++;
            this.f47761g.onComplete();
        } finally {
            this.f47744a.countDown();
        }
    }

    public final void dispose() {
        io.reactivex.rxjava3.e.a.c.dispose(this.f47762h);
    }

    public final boolean isDisposed() {
        return io.reactivex.rxjava3.e.a.c.isDisposed(this.f47762h.get());
    }

    public final void onSuccess(T t) {
        onNext(t);
        onComplete();
    }
}
