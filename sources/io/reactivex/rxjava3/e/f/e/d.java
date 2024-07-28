package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.e.k.j;
import io.reactivex.rxjava3.e.k.m;
import io.reactivex.rxjava3.g.b;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class d<T> implements Iterable<T> {

    /* renamed from: a  reason: collision with root package name */
    final u<T> f47236a;

    /* renamed from: b  reason: collision with root package name */
    final T f47237b;

    public d(u<T> uVar, T t) {
        this.f47236a = uVar;
        this.f47237b = t;
    }

    public final Iterator<T> iterator() {
        a aVar = new a(this.f47237b);
        this.f47236a.subscribe(aVar);
        return new a.C0813a();
    }

    static final class a<T> extends b<T> {

        /* renamed from: a  reason: collision with root package name */
        volatile Object f47238a;

        a(T t) {
            this.f47238a = m.next(t);
        }

        public final void onComplete() {
            this.f47238a = m.complete();
        }

        public final void onError(Throwable th) {
            this.f47238a = m.error(th);
        }

        public final void onNext(T t) {
            this.f47238a = m.next(t);
        }

        /* renamed from: io.reactivex.rxjava3.e.f.e.d$a$a  reason: collision with other inner class name */
        final class C0813a implements Iterator<T> {

            /* renamed from: b  reason: collision with root package name */
            private Object f47240b;

            C0813a() {
            }

            public final boolean hasNext() {
                this.f47240b = a.this.f47238a;
                return !m.isComplete(this.f47240b);
            }

            public final T next() {
                Object obj = null;
                try {
                    if (this.f47240b == null) {
                        obj = a.this.f47238a;
                    }
                    if (m.isComplete(this.f47240b)) {
                        throw new NoSuchElementException();
                    } else if (!m.isError(this.f47240b)) {
                        T value = m.getValue(this.f47240b);
                        this.f47240b = obj;
                        return value;
                    } else {
                        throw j.a(m.getError(this.f47240b));
                    }
                } finally {
                    this.f47240b = obj;
                }
            }

            public final void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }
    }
}
