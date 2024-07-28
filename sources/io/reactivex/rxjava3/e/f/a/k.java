package io.reactivex.rxjava3.e.f.a;

import io.reactivex.rxjava3.a.b;
import io.reactivex.rxjava3.a.d;
import io.reactivex.rxjava3.a.f;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.g;

public final class k extends b {

    /* renamed from: a  reason: collision with root package name */
    final f f46757a;

    /* renamed from: b  reason: collision with root package name */
    final g<? super c> f46758b;

    /* renamed from: c  reason: collision with root package name */
    final g<? super Throwable> f46759c;

    /* renamed from: d  reason: collision with root package name */
    final io.reactivex.rxjava3.d.a f46760d;

    /* renamed from: e  reason: collision with root package name */
    final io.reactivex.rxjava3.d.a f46761e;

    /* renamed from: f  reason: collision with root package name */
    final io.reactivex.rxjava3.d.a f46762f;

    /* renamed from: g  reason: collision with root package name */
    final io.reactivex.rxjava3.d.a f46763g;

    public k(f fVar, g<? super c> gVar, g<? super Throwable> gVar2, io.reactivex.rxjava3.d.a aVar, io.reactivex.rxjava3.d.a aVar2, io.reactivex.rxjava3.d.a aVar3, io.reactivex.rxjava3.d.a aVar4) {
        this.f46757a = fVar;
        this.f46758b = gVar;
        this.f46759c = gVar2;
        this.f46760d = aVar;
        this.f46761e = aVar2;
        this.f46762f = aVar3;
        this.f46763g = aVar4;
    }

    public final void b(d dVar) {
        this.f46757a.a(new a(dVar));
    }

    final class a implements d, c {

        /* renamed from: a  reason: collision with root package name */
        final d f46764a;

        /* renamed from: b  reason: collision with root package name */
        c f46765b;

        a(d dVar) {
            this.f46764a = dVar;
        }

        public final void onSubscribe(c cVar) {
            try {
                k.this.f46758b.accept(cVar);
                if (io.reactivex.rxjava3.e.a.c.validate(this.f46765b, cVar)) {
                    this.f46765b = cVar;
                    this.f46764a.onSubscribe(this);
                }
            } catch (Throwable th) {
                io.reactivex.rxjava3.c.b.b(th);
                cVar.dispose();
                this.f46765b = io.reactivex.rxjava3.e.a.c.DISPOSED;
                io.reactivex.rxjava3.e.a.d.error(th, this.f46764a);
            }
        }

        public final void onError(Throwable th) {
            if (this.f46765b == io.reactivex.rxjava3.e.a.c.DISPOSED) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            try {
                k.this.f46759c.accept(th);
                k.this.f46761e.run();
            } catch (Throwable th2) {
                io.reactivex.rxjava3.c.b.b(th2);
                th = new io.reactivex.rxjava3.c.a(th, th2);
            }
            this.f46764a.onError(th);
            a();
        }

        public final void onComplete() {
            if (this.f46765b != io.reactivex.rxjava3.e.a.c.DISPOSED) {
                try {
                    k.this.f46760d.run();
                    k.this.f46761e.run();
                    this.f46764a.onComplete();
                    a();
                } catch (Throwable th) {
                    io.reactivex.rxjava3.c.b.b(th);
                    this.f46764a.onError(th);
                }
            }
        }

        private void a() {
            try {
                k.this.f46762f.run();
            } catch (Throwable th) {
                io.reactivex.rxjava3.c.b.b(th);
                io.reactivex.rxjava3.h.a.a(th);
            }
        }

        public final void dispose() {
            try {
                k.this.f46763g.run();
            } catch (Throwable th) {
                io.reactivex.rxjava3.c.b.b(th);
                io.reactivex.rxjava3.h.a.a(th);
            }
            this.f46765b.dispose();
        }

        public final boolean isDisposed() {
            return this.f46765b.isDisposed();
        }
    }
}
