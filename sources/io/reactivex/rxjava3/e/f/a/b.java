package io.reactivex.rxjava3.e.f.a;

import io.reactivex.rxjava3.a.d;
import io.reactivex.rxjava3.a.f;
import io.reactivex.rxjava3.b.c;
import java.util.concurrent.atomic.AtomicInteger;

public final class b extends io.reactivex.rxjava3.a.b {

    /* renamed from: a  reason: collision with root package name */
    final f[] f46746a;

    public b(f[] fVarArr) {
        this.f46746a = fVarArr;
    }

    public final void b(d dVar) {
        a aVar = new a(dVar, this.f46746a);
        dVar.onSubscribe(aVar.sd);
        aVar.next();
    }

    static final class a extends AtomicInteger implements d {
        private static final long serialVersionUID = -7965400327305809232L;
        final d downstream;
        int index;
        final io.reactivex.rxjava3.e.a.f sd = new io.reactivex.rxjava3.e.a.f();
        final f[] sources;

        a(d dVar, f[] fVarArr) {
            this.downstream = dVar;
            this.sources = fVarArr;
        }

        public final void onSubscribe(c cVar) {
            this.sd.replace(cVar);
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public final void onComplete() {
            next();
        }

        /* access modifiers changed from: package-private */
        public final void next() {
            if (!this.sd.isDisposed() && getAndIncrement() == 0) {
                f[] fVarArr = this.sources;
                while (!this.sd.isDisposed()) {
                    int i2 = this.index;
                    this.index = i2 + 1;
                    if (i2 == fVarArr.length) {
                        this.downstream.onComplete();
                        return;
                    }
                    fVarArr[i2].a(this);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }
    }
}
