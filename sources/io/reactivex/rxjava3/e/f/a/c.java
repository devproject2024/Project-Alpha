package io.reactivex.rxjava3.e.f.a;

import io.reactivex.rxjava3.a.b;
import io.reactivex.rxjava3.a.d;
import io.reactivex.rxjava3.a.e;
import io.reactivex.rxjava3.d.f;
import io.reactivex.rxjava3.e.k.j;
import java.util.concurrent.atomic.AtomicReference;

public final class c extends b {

    /* renamed from: a  reason: collision with root package name */
    final e f46747a;

    public c(e eVar) {
        this.f46747a = eVar;
    }

    public final void b(d dVar) {
        a aVar = new a(dVar);
        dVar.onSubscribe(aVar);
        try {
            this.f46747a.a(aVar);
        } catch (Throwable th) {
            io.reactivex.rxjava3.c.b.b(th);
            aVar.onError(th);
        }
    }

    static final class a extends AtomicReference<io.reactivex.rxjava3.b.c> implements io.reactivex.rxjava3.a.c, io.reactivex.rxjava3.b.c {
        private static final long serialVersionUID = -2467358622224974244L;
        final d downstream;

        a(d dVar) {
            this.downstream = dVar;
        }

        public final void onComplete() {
            io.reactivex.rxjava3.b.c cVar;
            if (get() != io.reactivex.rxjava3.e.a.c.DISPOSED && (cVar = (io.reactivex.rxjava3.b.c) getAndSet(io.reactivex.rxjava3.e.a.c.DISPOSED)) != io.reactivex.rxjava3.e.a.c.DISPOSED) {
                try {
                    this.downstream.onComplete();
                } finally {
                    if (cVar != null) {
                        cVar.dispose();
                    }
                }
            }
        }

        public final void onError(Throwable th) {
            if (!tryOnError(th)) {
                io.reactivex.rxjava3.h.a.a(th);
            }
        }

        public final boolean tryOnError(Throwable th) {
            io.reactivex.rxjava3.b.c cVar;
            if (th == null) {
                th = j.a("onError called with a null Throwable.");
            }
            if (get() == io.reactivex.rxjava3.e.a.c.DISPOSED || (cVar = (io.reactivex.rxjava3.b.c) getAndSet(io.reactivex.rxjava3.e.a.c.DISPOSED)) == io.reactivex.rxjava3.e.a.c.DISPOSED) {
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

        public final void setDisposable(io.reactivex.rxjava3.b.c cVar) {
            io.reactivex.rxjava3.e.a.c.set(this, cVar);
        }

        public final void setCancellable(f fVar) {
            setDisposable(new io.reactivex.rxjava3.e.a.b(fVar));
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this);
        }

        public final boolean isDisposed() {
            return io.reactivex.rxjava3.e.a.c.isDisposed((io.reactivex.rxjava3.b.c) get());
        }

        public final String toString() {
            return String.format("%s{%s}", new Object[]{getClass().getSimpleName(), super.toString()});
        }
    }
}
