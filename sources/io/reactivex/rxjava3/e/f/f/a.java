package io.reactivex.rxjava3.e.f.f;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.ab;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.a.z;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.f;
import io.reactivex.rxjava3.e.k.j;
import java.util.concurrent.atomic.AtomicReference;

public final class a<T> extends y<T> {

    /* renamed from: a  reason: collision with root package name */
    final ab<T> f47572a;

    public a(ab<T> abVar) {
        this.f47572a = abVar;
    }

    public final void b(aa<? super T> aaVar) {
        C0820a aVar = new C0820a(aaVar);
        aaVar.onSubscribe(aVar);
        try {
            this.f47572a.subscribe(aVar);
        } catch (Throwable th) {
            b.b(th);
            aVar.onError(th);
        }
    }

    /* renamed from: io.reactivex.rxjava3.e.f.f.a$a  reason: collision with other inner class name */
    static final class C0820a<T> extends AtomicReference<c> implements z<T>, c {
        private static final long serialVersionUID = -2467358622224974244L;
        final aa<? super T> downstream;

        C0820a(aa<? super T> aaVar) {
            this.downstream = aaVar;
        }

        public final void onSuccess(T t) {
            c cVar;
            if (get() != io.reactivex.rxjava3.e.a.c.DISPOSED && (cVar = (c) getAndSet(io.reactivex.rxjava3.e.a.c.DISPOSED)) != io.reactivex.rxjava3.e.a.c.DISPOSED) {
                if (t == null) {
                    try {
                        this.downstream.onError(j.a("onSuccess called with a null value."));
                    } catch (Throwable th) {
                        if (cVar != null) {
                            cVar.dispose();
                        }
                        throw th;
                    }
                } else {
                    this.downstream.onSuccess(t);
                }
                if (cVar != null) {
                    cVar.dispose();
                }
            }
        }

        public final void onError(Throwable th) {
            if (!tryOnError(th)) {
                io.reactivex.rxjava3.h.a.a(th);
            }
        }

        public final boolean tryOnError(Throwable th) {
            c cVar;
            if (th == null) {
                th = j.a("onError called with a null Throwable.");
            }
            if (get() == io.reactivex.rxjava3.e.a.c.DISPOSED || (cVar = (c) getAndSet(io.reactivex.rxjava3.e.a.c.DISPOSED)) == io.reactivex.rxjava3.e.a.c.DISPOSED) {
                return false;
            }
            try {
                this.downstream.onError(th);
            } finally {
                if (cVar != null) {
                    cVar.dispose();
                }
            }
        }

        public final void setDisposable(c cVar) {
            io.reactivex.rxjava3.e.a.c.set(this, cVar);
        }

        public final void setCancellable(f fVar) {
            setDisposable(new io.reactivex.rxjava3.e.a.b(fVar));
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this);
        }

        public final boolean isDisposed() {
            return io.reactivex.rxjava3.e.a.c.isDisposed((c) get());
        }

        public final String toString() {
            return String.format("%s{%s}", new Object[]{getClass().getSimpleName(), super.toString()});
        }
    }
}
