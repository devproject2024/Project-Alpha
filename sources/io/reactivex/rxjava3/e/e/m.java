package io.reactivex.rxjava3.e.e;

import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.a;
import io.reactivex.rxjava3.d.g;
import io.reactivex.rxjava3.e.a.d;

public final class m<T> implements w<T>, c {

    /* renamed from: a  reason: collision with root package name */
    final w<? super T> f46727a;

    /* renamed from: b  reason: collision with root package name */
    final g<? super c> f46728b;

    /* renamed from: c  reason: collision with root package name */
    final a f46729c;

    /* renamed from: d  reason: collision with root package name */
    c f46730d;

    public m(w<? super T> wVar, g<? super c> gVar, a aVar) {
        this.f46727a = wVar;
        this.f46728b = gVar;
        this.f46729c = aVar;
    }

    public final void onSubscribe(c cVar) {
        try {
            this.f46728b.accept(cVar);
            if (io.reactivex.rxjava3.e.a.c.validate(this.f46730d, cVar)) {
                this.f46730d = cVar;
                this.f46727a.onSubscribe(this);
            }
        } catch (Throwable th) {
            b.b(th);
            cVar.dispose();
            this.f46730d = io.reactivex.rxjava3.e.a.c.DISPOSED;
            d.error(th, (w<?>) this.f46727a);
        }
    }

    public final void onNext(T t) {
        this.f46727a.onNext(t);
    }

    public final void onError(Throwable th) {
        if (this.f46730d != io.reactivex.rxjava3.e.a.c.DISPOSED) {
            this.f46730d = io.reactivex.rxjava3.e.a.c.DISPOSED;
            this.f46727a.onError(th);
            return;
        }
        io.reactivex.rxjava3.h.a.a(th);
    }

    public final void onComplete() {
        if (this.f46730d != io.reactivex.rxjava3.e.a.c.DISPOSED) {
            this.f46730d = io.reactivex.rxjava3.e.a.c.DISPOSED;
            this.f46727a.onComplete();
        }
    }

    public final void dispose() {
        c cVar = this.f46730d;
        if (cVar != io.reactivex.rxjava3.e.a.c.DISPOSED) {
            this.f46730d = io.reactivex.rxjava3.e.a.c.DISPOSED;
            try {
                this.f46729c.run();
            } catch (Throwable th) {
                b.b(th);
                io.reactivex.rxjava3.h.a.a(th);
            }
            cVar.dispose();
        }
    }

    public final boolean isDisposed() {
        return this.f46730d.isDisposed();
    }
}
