package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.j.f;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class ei<T> extends a<T, p<T>> {

    /* renamed from: b  reason: collision with root package name */
    final long f47405b;

    /* renamed from: c  reason: collision with root package name */
    final long f47406c;

    /* renamed from: d  reason: collision with root package name */
    final int f47407d;

    public ei(u<T> uVar, long j, long j2, int i2) {
        super(uVar);
        this.f47405b = j;
        this.f47406c = j2;
        this.f47407d = i2;
    }

    public final void subscribeActual(w<? super p<T>> wVar) {
        if (this.f47405b == this.f47406c) {
            this.f46900a.subscribe(new a(wVar, this.f47405b, this.f47407d));
            return;
        }
        this.f46900a.subscribe(new b(wVar, this.f47405b, this.f47406c, this.f47407d));
    }

    static final class a<T> extends AtomicInteger implements w<T>, c, Runnable {
        private static final long serialVersionUID = -7481782523886138128L;
        volatile boolean cancelled;
        final int capacityHint;
        final long count;
        final w<? super p<T>> downstream;
        long size;
        c upstream;
        f<T> window;

        a(w<? super p<T>> wVar, long j, int i2) {
            this.downstream = wVar;
            this.count = j;
            this.capacityHint = i2;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            el elVar;
            f<T> fVar = this.window;
            if (fVar != null || this.cancelled) {
                elVar = null;
            } else {
                fVar = f.a(this.capacityHint, (Runnable) this);
                this.window = fVar;
                elVar = new el(fVar);
                this.downstream.onNext(elVar);
            }
            if (fVar != null) {
                fVar.onNext(t);
                long j = this.size + 1;
                this.size = j;
                if (j >= this.count) {
                    this.size = 0;
                    this.window = null;
                    fVar.onComplete();
                    if (this.cancelled) {
                        this.upstream.dispose();
                    }
                }
                if (elVar != null && elVar.a()) {
                    fVar.onComplete();
                    this.window = null;
                }
            }
        }

        public final void onError(Throwable th) {
            f<T> fVar = this.window;
            if (fVar != null) {
                this.window = null;
                fVar.onError(th);
            }
            this.downstream.onError(th);
        }

        public final void onComplete() {
            f<T> fVar = this.window;
            if (fVar != null) {
                this.window = null;
                fVar.onComplete();
            }
            this.downstream.onComplete();
        }

        public final void dispose() {
            this.cancelled = true;
        }

        public final boolean isDisposed() {
            return this.cancelled;
        }

        public final void run() {
            if (this.cancelled) {
                this.upstream.dispose();
            }
        }
    }

    static final class b<T> extends AtomicBoolean implements w<T>, c, Runnable {
        private static final long serialVersionUID = 3366976432059579510L;
        volatile boolean cancelled;
        final int capacityHint;
        final long count;
        final w<? super p<T>> downstream;
        long firstEmission;
        long index;
        final long skip;
        c upstream;
        final ArrayDeque<f<T>> windows;
        final AtomicInteger wip = new AtomicInteger();

        b(w<? super p<T>> wVar, long j, long j2, int i2) {
            this.downstream = wVar;
            this.count = j;
            this.skip = j2;
            this.capacityHint = i2;
            this.windows = new ArrayDeque<>();
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            el elVar;
            ArrayDeque<f<T>> arrayDeque = this.windows;
            long j = this.index;
            long j2 = this.skip;
            if (j % j2 != 0 || this.cancelled) {
                elVar = null;
            } else {
                this.wip.getAndIncrement();
                f a2 = f.a(this.capacityHint, (Runnable) this);
                elVar = new el(a2);
                arrayDeque.offer(a2);
                this.downstream.onNext(elVar);
            }
            long j3 = this.firstEmission + 1;
            Iterator<f<T>> it2 = arrayDeque.iterator();
            while (it2.hasNext()) {
                it2.next().onNext(t);
            }
            if (j3 >= this.count) {
                arrayDeque.poll().onComplete();
                if (!arrayDeque.isEmpty() || !this.cancelled) {
                    this.firstEmission = j3 - j2;
                } else {
                    this.upstream.dispose();
                    return;
                }
            } else {
                this.firstEmission = j3;
            }
            this.index = j + 1;
            if (elVar != null && elVar.a()) {
                elVar.f47420a.onComplete();
            }
        }

        public final void onError(Throwable th) {
            ArrayDeque<f<T>> arrayDeque = this.windows;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onError(th);
            }
            this.downstream.onError(th);
        }

        public final void onComplete() {
            ArrayDeque<f<T>> arrayDeque = this.windows;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onComplete();
            }
            this.downstream.onComplete();
        }

        public final void dispose() {
            this.cancelled = true;
        }

        public final boolean isDisposed() {
            return this.cancelled;
        }

        public final void run() {
            if (this.wip.decrementAndGet() == 0 && this.cancelled) {
                this.upstream.dispose();
            }
        }
    }
}
