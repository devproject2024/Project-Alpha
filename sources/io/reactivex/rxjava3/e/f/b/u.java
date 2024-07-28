package io.reactivex.rxjava3.e.f.b;

import io.reactivex.rxjava3.a.h;
import io.reactivex.rxjava3.a.k;
import io.reactivex.rxjava3.d.c;
import io.reactivex.rxjava3.e.j.g;
import java.util.Objects;
import org.a.b;

public final class u<T> extends a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final c<T, T, T> f46827c;

    public u(h<T> hVar, c<T, T, T> cVar) {
        super(hVar);
        this.f46827c = cVar;
    }

    public final void b(b<? super T> bVar) {
        this.f46770b.a(new a(bVar, this.f46827c));
    }

    static final class a<T> implements k<T>, org.a.c {

        /* renamed from: a  reason: collision with root package name */
        final b<? super T> f46828a;

        /* renamed from: b  reason: collision with root package name */
        final c<T, T, T> f46829b;

        /* renamed from: c  reason: collision with root package name */
        org.a.c f46830c;

        /* renamed from: d  reason: collision with root package name */
        T f46831d;

        /* renamed from: e  reason: collision with root package name */
        boolean f46832e;

        a(b<? super T> bVar, c<T, T, T> cVar) {
            this.f46828a = bVar;
            this.f46829b = cVar;
        }

        public final void onSubscribe(org.a.c cVar) {
            if (g.validate(this.f46830c, cVar)) {
                this.f46830c = cVar;
                this.f46828a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (!this.f46832e) {
                b<? super T> bVar = this.f46828a;
                T t2 = this.f46831d;
                if (t2 == null) {
                    this.f46831d = t;
                    bVar.onNext(t);
                    return;
                }
                try {
                    T requireNonNull = Objects.requireNonNull(this.f46829b.a(t2, t), "The value returned by the accumulator is null");
                    this.f46831d = requireNonNull;
                    bVar.onNext(requireNonNull);
                } catch (Throwable th) {
                    io.reactivex.rxjava3.c.b.b(th);
                    this.f46830c.cancel();
                    onError(th);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f46832e) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            this.f46832e = true;
            this.f46828a.onError(th);
        }

        public final void onComplete() {
            if (!this.f46832e) {
                this.f46832e = true;
                this.f46828a.onComplete();
            }
        }

        public final void request(long j) {
            this.f46830c.request(j);
        }

        public final void cancel() {
            this.f46830c.cancel();
        }
    }
}
