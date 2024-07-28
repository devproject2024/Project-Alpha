package io.reactivex.rxjava3.g;

import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.e.a.d;
import io.reactivex.rxjava3.e.k.j;
import io.reactivex.rxjava3.h.a;

public final class e<T> implements w<T>, c {

    /* renamed from: a  reason: collision with root package name */
    final w<? super T> f47752a;

    /* renamed from: b  reason: collision with root package name */
    c f47753b;

    /* renamed from: c  reason: collision with root package name */
    boolean f47754c;

    public e(w<? super T> wVar) {
        this.f47752a = wVar;
    }

    public final void onSubscribe(c cVar) {
        if (io.reactivex.rxjava3.e.a.c.validate(this.f47753b, cVar)) {
            this.f47753b = cVar;
            try {
                this.f47752a.onSubscribe(this);
            } catch (Throwable th) {
                b.b(th);
                a.a((Throwable) new io.reactivex.rxjava3.c.a(th, th));
            }
        }
    }

    public final void dispose() {
        this.f47753b.dispose();
    }

    public final boolean isDisposed() {
        return this.f47753b.isDisposed();
    }

    public final void onNext(T t) {
        if (!this.f47754c) {
            if (this.f47753b == null) {
                this.f47754c = true;
                NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
                try {
                    this.f47752a.onSubscribe(d.INSTANCE);
                    try {
                        this.f47752a.onError(nullPointerException);
                    } catch (Throwable th) {
                        b.b(th);
                        a.a((Throwable) new io.reactivex.rxjava3.c.a(nullPointerException, th));
                    }
                } catch (Throwable th2) {
                    b.b(th2);
                    a.a((Throwable) new io.reactivex.rxjava3.c.a(nullPointerException, th2));
                }
            } else if (t == null) {
                NullPointerException a2 = j.a("onNext called with a null value.");
                try {
                    this.f47753b.dispose();
                    onError(a2);
                } catch (Throwable th3) {
                    b.b(th3);
                    onError(new io.reactivex.rxjava3.c.a(a2, th3));
                }
            } else {
                try {
                    this.f47752a.onNext(t);
                } catch (Throwable th4) {
                    b.b(th4);
                    onError(new io.reactivex.rxjava3.c.a(th, th4));
                }
            }
        }
    }

    public final void onError(Throwable th) {
        if (this.f47754c) {
            a.a(th);
            return;
        }
        this.f47754c = true;
        if (this.f47753b == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.f47752a.onSubscribe(d.INSTANCE);
                try {
                    this.f47752a.onError(new io.reactivex.rxjava3.c.a(th, nullPointerException));
                } catch (Throwable th2) {
                    b.b(th2);
                    a.a((Throwable) new io.reactivex.rxjava3.c.a(th, nullPointerException, th2));
                }
            } catch (Throwable th3) {
                b.b(th3);
                a.a((Throwable) new io.reactivex.rxjava3.c.a(th, nullPointerException, th3));
            }
        } else {
            if (th == null) {
                th = j.a("onError called with a null Throwable.");
            }
            try {
                this.f47752a.onError(th);
            } catch (Throwable th4) {
                b.b(th4);
                a.a((Throwable) new io.reactivex.rxjava3.c.a(th, th4));
            }
        }
    }

    public final void onComplete() {
        if (!this.f47754c) {
            this.f47754c = true;
            if (this.f47753b == null) {
                NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
                try {
                    this.f47752a.onSubscribe(d.INSTANCE);
                    try {
                        this.f47752a.onError(nullPointerException);
                    } catch (Throwable th) {
                        b.b(th);
                        a.a((Throwable) new io.reactivex.rxjava3.c.a(nullPointerException, th));
                    }
                } catch (Throwable th2) {
                    b.b(th2);
                    a.a((Throwable) new io.reactivex.rxjava3.c.a(nullPointerException, th2));
                }
            } else {
                try {
                    this.f47752a.onComplete();
                } catch (Throwable th3) {
                    b.b(th3);
                    a.a(th3);
                }
            }
        }
    }
}
