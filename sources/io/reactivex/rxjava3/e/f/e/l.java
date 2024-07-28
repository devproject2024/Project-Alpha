package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.r;
import io.reactivex.rxjava3.e.a.d;
import io.reactivex.rxjava3.e.k.j;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public final class l<T, U extends Collection<? super T>> extends a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final int f47487b;

    /* renamed from: c  reason: collision with root package name */
    final int f47488c;

    /* renamed from: d  reason: collision with root package name */
    final r<U> f47489d;

    public l(u<T> uVar, int i2, int i3, r<U> rVar) {
        super(uVar);
        this.f47487b = i2;
        this.f47488c = i3;
        this.f47489d = rVar;
    }

    public final void subscribeActual(w<? super U> wVar) {
        int i2 = this.f47488c;
        int i3 = this.f47487b;
        if (i2 == i3) {
            a aVar = new a(wVar, i3, this.f47489d);
            if (aVar.a()) {
                this.f46900a.subscribe(aVar);
                return;
            }
            return;
        }
        this.f46900a.subscribe(new b(wVar, this.f47487b, this.f47488c, this.f47489d));
    }

    static final class a<T, U extends Collection<? super T>> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final w<? super U> f47490a;

        /* renamed from: b  reason: collision with root package name */
        final int f47491b;

        /* renamed from: c  reason: collision with root package name */
        final r<U> f47492c;

        /* renamed from: d  reason: collision with root package name */
        U f47493d;

        /* renamed from: e  reason: collision with root package name */
        int f47494e;

        /* renamed from: f  reason: collision with root package name */
        c f47495f;

        a(w<? super U> wVar, int i2, r<U> rVar) {
            this.f47490a = wVar;
            this.f47491b = i2;
            this.f47492c = rVar;
        }

        /* access modifiers changed from: package-private */
        public final boolean a() {
            try {
                this.f47493d = (Collection) Objects.requireNonNull(this.f47492c.get(), "Empty buffer supplied");
                return true;
            } catch (Throwable th) {
                io.reactivex.rxjava3.c.b.b(th);
                this.f47493d = null;
                c cVar = this.f47495f;
                if (cVar == null) {
                    d.error(th, (w<?>) this.f47490a);
                    return false;
                }
                cVar.dispose();
                this.f47490a.onError(th);
                return false;
            }
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47495f, cVar)) {
                this.f47495f = cVar;
                this.f47490a.onSubscribe(this);
            }
        }

        public final void dispose() {
            this.f47495f.dispose();
        }

        public final boolean isDisposed() {
            return this.f47495f.isDisposed();
        }

        public final void onNext(T t) {
            U u = this.f47493d;
            if (u != null) {
                u.add(t);
                int i2 = this.f47494e + 1;
                this.f47494e = i2;
                if (i2 >= this.f47491b) {
                    this.f47490a.onNext(u);
                    this.f47494e = 0;
                    a();
                }
            }
        }

        public final void onError(Throwable th) {
            this.f47493d = null;
            this.f47490a.onError(th);
        }

        public final void onComplete() {
            U u = this.f47493d;
            if (u != null) {
                this.f47493d = null;
                if (!u.isEmpty()) {
                    this.f47490a.onNext(u);
                }
                this.f47490a.onComplete();
            }
        }
    }

    static final class b<T, U extends Collection<? super T>> extends AtomicBoolean implements w<T>, c {
        private static final long serialVersionUID = -8223395059921494546L;
        final r<U> bufferSupplier;
        final ArrayDeque<U> buffers = new ArrayDeque<>();
        final int count;
        final w<? super U> downstream;
        long index;
        final int skip;
        c upstream;

        b(w<? super U> wVar, int i2, int i3, r<U> rVar) {
            this.downstream = wVar;
            this.count = i2;
            this.skip = i3;
            this.bufferSupplier = rVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
            }
        }

        public final void dispose() {
            this.upstream.dispose();
        }

        public final boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        public final void onNext(T t) {
            long j = this.index;
            this.index = 1 + j;
            if (j % ((long) this.skip) == 0) {
                try {
                    this.buffers.offer((Collection) j.a(this.bufferSupplier.get(), "The bufferSupplier returned a null Collection."));
                } catch (Throwable th) {
                    io.reactivex.rxjava3.c.b.b(th);
                    this.buffers.clear();
                    this.upstream.dispose();
                    this.downstream.onError(th);
                    return;
                }
            }
            Iterator<U> it2 = this.buffers.iterator();
            while (it2.hasNext()) {
                Collection collection = (Collection) it2.next();
                collection.add(t);
                if (this.count <= collection.size()) {
                    it2.remove();
                    this.downstream.onNext(collection);
                }
            }
        }

        public final void onError(Throwable th) {
            this.buffers.clear();
            this.downstream.onError(th);
        }

        public final void onComplete() {
            while (!this.buffers.isEmpty()) {
                this.downstream.onNext(this.buffers.poll());
            }
            this.downstream.onComplete();
        }
    }
}
