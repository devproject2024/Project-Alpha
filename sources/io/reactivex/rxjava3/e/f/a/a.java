package io.reactivex.rxjava3.e.f.a;

import io.reactivex.rxjava3.a.d;
import io.reactivex.rxjava3.a.f;
import io.reactivex.rxjava3.b.c;
import java.util.concurrent.atomic.AtomicReference;

public final class a extends io.reactivex.rxjava3.a.b {

    /* renamed from: a  reason: collision with root package name */
    final f f46742a;

    /* renamed from: b  reason: collision with root package name */
    final f f46743b;

    public a(f fVar, f fVar2) {
        this.f46742a = fVar;
        this.f46743b = fVar2;
    }

    public final void b(d dVar) {
        this.f46742a.a(new b(dVar, this.f46743b));
    }

    static final class b extends AtomicReference<c> implements d, c {
        private static final long serialVersionUID = -4101678820158072998L;
        final d actualObserver;
        final f next;

        b(d dVar, f fVar) {
            this.actualObserver = dVar;
            this.next = fVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.setOnce(this, cVar)) {
                this.actualObserver.onSubscribe(this);
            }
        }

        public final void onError(Throwable th) {
            this.actualObserver.onError(th);
        }

        public final void onComplete() {
            this.next.a(new C0788a(this, this.actualObserver));
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this);
        }

        public final boolean isDisposed() {
            return io.reactivex.rxjava3.e.a.c.isDisposed((c) get());
        }
    }

    /* renamed from: io.reactivex.rxjava3.e.f.a.a$a  reason: collision with other inner class name */
    static final class C0788a implements d {

        /* renamed from: a  reason: collision with root package name */
        final AtomicReference<c> f46744a;

        /* renamed from: b  reason: collision with root package name */
        final d f46745b;

        C0788a(AtomicReference<c> atomicReference, d dVar) {
            this.f46744a = atomicReference;
            this.f46745b = dVar;
        }

        public final void onSubscribe(c cVar) {
            io.reactivex.rxjava3.e.a.c.replace(this.f46744a, cVar);
        }

        public final void onComplete() {
            this.f46745b.onComplete();
        }

        public final void onError(Throwable th) {
            this.f46745b.onError(th);
        }
    }
}
