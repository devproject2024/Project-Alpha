package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.e.k.j;
import io.reactivex.rxjava3.j.f;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class bn<TLeft, TRight, TLeftEnd, TRightEnd, R> extends a<TLeft, R> {

    /* renamed from: b  reason: collision with root package name */
    final u<? extends TRight> f47076b;

    /* renamed from: c  reason: collision with root package name */
    final h<? super TLeft, ? extends u<TLeftEnd>> f47077c;

    /* renamed from: d  reason: collision with root package name */
    final h<? super TRight, ? extends u<TRightEnd>> f47078d;

    /* renamed from: e  reason: collision with root package name */
    final io.reactivex.rxjava3.d.c<? super TLeft, ? super p<TRight>, ? extends R> f47079e;

    interface b {
        void innerClose(boolean z, c cVar);

        void innerCloseError(Throwable th);

        void innerComplete(d dVar);

        void innerError(Throwable th);

        void innerValue(boolean z, Object obj);
    }

    public bn(u<TLeft> uVar, u<? extends TRight> uVar2, h<? super TLeft, ? extends u<TLeftEnd>> hVar, h<? super TRight, ? extends u<TRightEnd>> hVar2, io.reactivex.rxjava3.d.c<? super TLeft, ? super p<TRight>, ? extends R> cVar) {
        super(uVar);
        this.f47076b = uVar2;
        this.f47077c = hVar;
        this.f47078d = hVar2;
        this.f47079e = cVar;
    }

    public final void subscribeActual(w<? super R> wVar) {
        a aVar = new a(wVar, this.f47077c, this.f47078d, this.f47079e);
        wVar.onSubscribe(aVar);
        d dVar = new d(aVar, true);
        aVar.disposables.a((io.reactivex.rxjava3.b.c) dVar);
        d dVar2 = new d(aVar, false);
        aVar.disposables.a((io.reactivex.rxjava3.b.c) dVar2);
        this.f46900a.subscribe(dVar);
        this.f47076b.subscribe(dVar2);
    }

    static final class a<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements io.reactivex.rxjava3.b.c, b {
        static final Integer LEFT_CLOSE = 3;
        static final Integer LEFT_VALUE = 1;
        static final Integer RIGHT_CLOSE = 4;
        static final Integer RIGHT_VALUE = 2;
        private static final long serialVersionUID = -6071216598687999801L;
        final AtomicInteger active;
        volatile boolean cancelled;
        final io.reactivex.rxjava3.b.b disposables = new io.reactivex.rxjava3.b.b();
        final w<? super R> downstream;
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final h<? super TLeft, ? extends u<TLeftEnd>> leftEnd;
        int leftIndex;
        final Map<Integer, f<TRight>> lefts = new LinkedHashMap();
        final io.reactivex.rxjava3.e.g.c<Object> queue = new io.reactivex.rxjava3.e.g.c<>(p.bufferSize());
        final io.reactivex.rxjava3.d.c<? super TLeft, ? super p<TRight>, ? extends R> resultSelector;
        final h<? super TRight, ? extends u<TRightEnd>> rightEnd;
        int rightIndex;
        final Map<Integer, TRight> rights = new LinkedHashMap();

        a(w<? super R> wVar, h<? super TLeft, ? extends u<TLeftEnd>> hVar, h<? super TRight, ? extends u<TRightEnd>> hVar2, io.reactivex.rxjava3.d.c<? super TLeft, ? super p<TRight>, ? extends R> cVar) {
            this.downstream = wVar;
            this.leftEnd = hVar;
            this.rightEnd = hVar2;
            this.resultSelector = cVar;
            this.active = new AtomicInteger(2);
        }

        public final void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelAll();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        public final boolean isDisposed() {
            return this.cancelled;
        }

        /* access modifiers changed from: package-private */
        public final void cancelAll() {
            this.disposables.dispose();
        }

        /* access modifiers changed from: package-private */
        public final void errorAll(w<?> wVar) {
            Throwable a2 = j.a(this.error);
            for (f<TRight> onError : this.lefts.values()) {
                onError.onError(a2);
            }
            this.lefts.clear();
            this.rights.clear();
            wVar.onError(a2);
        }

        /* access modifiers changed from: package-private */
        public final void fail(Throwable th, w<?> wVar, io.reactivex.rxjava3.e.g.c<?> cVar) {
            io.reactivex.rxjava3.c.b.b(th);
            j.a(this.error, th);
            cVar.clear();
            cancelAll();
            errorAll(wVar);
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            if (getAndIncrement() == 0) {
                io.reactivex.rxjava3.e.g.c<Object> cVar = this.queue;
                w<? super R> wVar = this.downstream;
                int i2 = 1;
                while (!this.cancelled) {
                    if (this.error.get() != null) {
                        cVar.clear();
                        cancelAll();
                        errorAll(wVar);
                        return;
                    }
                    boolean z = this.active.get() == 0;
                    Integer num = (Integer) cVar.poll();
                    boolean z2 = num == null;
                    if (z && z2) {
                        for (f<TRight> onComplete : this.lefts.values()) {
                            onComplete.onComplete();
                        }
                        this.lefts.clear();
                        this.rights.clear();
                        this.disposables.dispose();
                        wVar.onComplete();
                        return;
                    } else if (!z2) {
                        Object poll = cVar.poll();
                        if (num == LEFT_VALUE) {
                            f a2 = f.a();
                            int i3 = this.leftIndex;
                            this.leftIndex = i3 + 1;
                            this.lefts.put(Integer.valueOf(i3), a2);
                            try {
                                u uVar = (u) Objects.requireNonNull(this.leftEnd.apply(poll), "The leftEnd returned a null ObservableSource");
                                c cVar2 = new c(this, true, i3);
                                this.disposables.a((io.reactivex.rxjava3.b.c) cVar2);
                                uVar.subscribe(cVar2);
                                if (this.error.get() != null) {
                                    cVar.clear();
                                    cancelAll();
                                    errorAll(wVar);
                                    return;
                                }
                                try {
                                    wVar.onNext(Objects.requireNonNull(this.resultSelector.a(poll, a2), "The resultSelector returned a null value"));
                                    for (TRight onNext : this.rights.values()) {
                                        a2.onNext(onNext);
                                    }
                                } catch (Throwable th) {
                                    fail(th, wVar, cVar);
                                    return;
                                }
                            } catch (Throwable th2) {
                                fail(th2, wVar, cVar);
                                return;
                            }
                        } else if (num == RIGHT_VALUE) {
                            int i4 = this.rightIndex;
                            this.rightIndex = i4 + 1;
                            this.rights.put(Integer.valueOf(i4), poll);
                            try {
                                u uVar2 = (u) Objects.requireNonNull(this.rightEnd.apply(poll), "The rightEnd returned a null ObservableSource");
                                c cVar3 = new c(this, false, i4);
                                this.disposables.a((io.reactivex.rxjava3.b.c) cVar3);
                                uVar2.subscribe(cVar3);
                                if (this.error.get() != null) {
                                    cVar.clear();
                                    cancelAll();
                                    errorAll(wVar);
                                    return;
                                }
                                for (f<TRight> onNext2 : this.lefts.values()) {
                                    onNext2.onNext(poll);
                                }
                            } catch (Throwable th3) {
                                fail(th3, wVar, cVar);
                                return;
                            }
                        } else if (num == LEFT_CLOSE) {
                            c cVar4 = (c) poll;
                            f remove = this.lefts.remove(Integer.valueOf(cVar4.index));
                            this.disposables.b(cVar4);
                            if (remove != null) {
                                remove.onComplete();
                            }
                        } else {
                            c cVar5 = (c) poll;
                            this.rights.remove(Integer.valueOf(cVar5.index));
                            this.disposables.b(cVar5);
                        }
                    } else {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    }
                }
                cVar.clear();
            }
        }

        public final void innerError(Throwable th) {
            if (j.a(this.error, th)) {
                this.active.decrementAndGet();
                drain();
                return;
            }
            io.reactivex.rxjava3.h.a.a(th);
        }

        public final void innerComplete(d dVar) {
            this.disposables.c(dVar);
            this.active.decrementAndGet();
            drain();
        }

        public final void innerValue(boolean z, Object obj) {
            synchronized (this) {
                this.queue.a(z ? LEFT_VALUE : RIGHT_VALUE, obj);
            }
            drain();
        }

        public final void innerClose(boolean z, c cVar) {
            synchronized (this) {
                this.queue.a(z ? LEFT_CLOSE : RIGHT_CLOSE, cVar);
            }
            drain();
        }

        public final void innerCloseError(Throwable th) {
            if (j.a(this.error, th)) {
                drain();
            } else {
                io.reactivex.rxjava3.h.a.a(th);
            }
        }
    }

    static final class d extends AtomicReference<io.reactivex.rxjava3.b.c> implements w<Object>, io.reactivex.rxjava3.b.c {
        private static final long serialVersionUID = 1883890389173668373L;
        final boolean isLeft;
        final b parent;

        d(b bVar, boolean z) {
            this.parent = bVar;
            this.isLeft = z;
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this);
        }

        public final boolean isDisposed() {
            return io.reactivex.rxjava3.e.a.c.isDisposed((io.reactivex.rxjava3.b.c) get());
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            io.reactivex.rxjava3.e.a.c.setOnce(this, cVar);
        }

        public final void onNext(Object obj) {
            this.parent.innerValue(this.isLeft, obj);
        }

        public final void onError(Throwable th) {
            this.parent.innerError(th);
        }

        public final void onComplete() {
            this.parent.innerComplete(this);
        }
    }

    static final class c extends AtomicReference<io.reactivex.rxjava3.b.c> implements w<Object>, io.reactivex.rxjava3.b.c {
        private static final long serialVersionUID = 1883890389173668373L;
        final int index;
        final boolean isLeft;
        final b parent;

        c(b bVar, boolean z, int i2) {
            this.parent = bVar;
            this.isLeft = z;
            this.index = i2;
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this);
        }

        public final boolean isDisposed() {
            return io.reactivex.rxjava3.e.a.c.isDisposed((io.reactivex.rxjava3.b.c) get());
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            io.reactivex.rxjava3.e.a.c.setOnce(this, cVar);
        }

        public final void onNext(Object obj) {
            if (io.reactivex.rxjava3.e.a.c.dispose(this)) {
                this.parent.innerClose(this.isLeft, this);
            }
        }

        public final void onError(Throwable th) {
            this.parent.innerCloseError(th);
        }

        public final void onComplete() {
            this.parent.innerClose(this.isLeft, this);
        }
    }
}
