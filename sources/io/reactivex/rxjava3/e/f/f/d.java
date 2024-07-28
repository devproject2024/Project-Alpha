package io.reactivex.rxjava3.e.f.f;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.ac;
import io.reactivex.rxjava3.a.f;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.e.x;
import java.util.concurrent.atomic.AtomicReference;

public final class d<T> extends y<T> {

    /* renamed from: a  reason: collision with root package name */
    final ac<T> f47586a;

    /* renamed from: b  reason: collision with root package name */
    final f f47587b;

    public d(ac<T> acVar, f fVar) {
        this.f47586a = acVar;
        this.f47587b = fVar;
    }

    public final void b(aa<? super T> aaVar) {
        this.f47587b.a(new a(aaVar, this.f47586a));
    }

    static final class a<T> extends AtomicReference<c> implements io.reactivex.rxjava3.a.d, c {
        private static final long serialVersionUID = -8565274649390031272L;
        final aa<? super T> downstream;
        final ac<T> source;

        a(aa<? super T> aaVar, ac<T> acVar) {
            this.downstream = aaVar;
            this.source = acVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.setOnce(this, cVar)) {
                this.downstream.onSubscribe(this);
            }
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public final void onComplete() {
            this.source.a(new x(this, this.downstream));
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this);
        }

        public final boolean isDisposed() {
            return io.reactivex.rxjava3.e.a.c.isDisposed((c) get());
        }
    }
}
