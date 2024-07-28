package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.c.e;
import java.util.NoSuchElementException;

public final class ar<T> extends y<T> implements e<T> {

    /* renamed from: a  reason: collision with root package name */
    final u<T> f47002a;

    /* renamed from: b  reason: collision with root package name */
    final long f47003b;

    /* renamed from: c  reason: collision with root package name */
    final T f47004c;

    public ar(u<T> uVar, long j, T t) {
        this.f47002a = uVar;
        this.f47003b = j;
        this.f47004c = t;
    }

    public final void b(aa<? super T> aaVar) {
        this.f47002a.subscribe(new a(aaVar, this.f47003b, this.f47004c));
    }

    public final p<T> U_() {
        return io.reactivex.rxjava3.h.a.a(new ap(this.f47002a, this.f47003b, this.f47004c, true));
    }

    static final class a<T> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final aa<? super T> f47005a;

        /* renamed from: b  reason: collision with root package name */
        final long f47006b;

        /* renamed from: c  reason: collision with root package name */
        final T f47007c;

        /* renamed from: d  reason: collision with root package name */
        c f47008d;

        /* renamed from: e  reason: collision with root package name */
        long f47009e;

        /* renamed from: f  reason: collision with root package name */
        boolean f47010f;

        a(aa<? super T> aaVar, long j, T t) {
            this.f47005a = aaVar;
            this.f47006b = j;
            this.f47007c = t;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47008d, cVar)) {
                this.f47008d = cVar;
                this.f47005a.onSubscribe(this);
            }
        }

        public final void dispose() {
            this.f47008d.dispose();
        }

        public final boolean isDisposed() {
            return this.f47008d.isDisposed();
        }

        public final void onNext(T t) {
            if (!this.f47010f) {
                long j = this.f47009e;
                if (j == this.f47006b) {
                    this.f47010f = true;
                    this.f47008d.dispose();
                    this.f47005a.onSuccess(t);
                    return;
                }
                this.f47009e = j + 1;
            }
        }

        public final void onError(Throwable th) {
            if (this.f47010f) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            this.f47010f = true;
            this.f47005a.onError(th);
        }

        public final void onComplete() {
            if (!this.f47010f) {
                this.f47010f = true;
                T t = this.f47007c;
                if (t != null) {
                    this.f47005a.onSuccess(t);
                } else {
                    this.f47005a.onError(new NoSuchElementException());
                }
            }
        }
    }
}
