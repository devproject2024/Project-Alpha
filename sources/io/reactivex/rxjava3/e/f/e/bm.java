package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.e.a.d;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class bm<T, K, V> extends a<T, io.reactivex.rxjava3.f.b<K, V>> {

    /* renamed from: b  reason: collision with root package name */
    final h<? super T, ? extends K> f47071b;

    /* renamed from: c  reason: collision with root package name */
    final h<? super T, ? extends V> f47072c;

    /* renamed from: d  reason: collision with root package name */
    final int f47073d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f47074e;

    public bm(u<T> uVar, h<? super T, ? extends K> hVar, h<? super T, ? extends V> hVar2, int i2, boolean z) {
        super(uVar);
        this.f47071b = hVar;
        this.f47072c = hVar2;
        this.f47073d = i2;
        this.f47074e = z;
    }

    public final void subscribeActual(w<? super io.reactivex.rxjava3.f.b<K, V>> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f47071b, this.f47072c, this.f47073d, this.f47074e));
    }

    public static final class a<T, K, V> extends AtomicInteger implements w<T>, io.reactivex.rxjava3.b.c {
        static final Object NULL_KEY = new Object();
        private static final long serialVersionUID = -3688291656102519502L;
        final int bufferSize;
        final AtomicBoolean cancelled = new AtomicBoolean();
        final boolean delayError;
        final w<? super io.reactivex.rxjava3.f.b<K, V>> downstream;
        final Map<Object, b<K, V>> groups;
        final h<? super T, ? extends K> keySelector;
        io.reactivex.rxjava3.b.c upstream;
        final h<? super T, ? extends V> valueSelector;

        public a(w<? super io.reactivex.rxjava3.f.b<K, V>> wVar, h<? super T, ? extends K> hVar, h<? super T, ? extends V> hVar2, int i2, boolean z) {
            this.downstream = wVar;
            this.keySelector = hVar;
            this.valueSelector = hVar2;
            this.bufferSize = i2;
            this.delayError = z;
            this.groups = new ConcurrentHashMap();
            lazySet(1);
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            Object obj;
            try {
                Object apply = this.keySelector.apply(t);
                if (apply != null) {
                    obj = apply;
                } else {
                    obj = NULL_KEY;
                }
                b bVar = this.groups.get(obj);
                boolean z = false;
                if (bVar == null) {
                    if (!this.cancelled.get()) {
                        bVar = b.a(apply, this.bufferSize, this, this.delayError);
                        this.groups.put(obj, bVar);
                        getAndIncrement();
                        z = true;
                    } else {
                        return;
                    }
                }
                try {
                    bVar.f47075a.onNext(Objects.requireNonNull(this.valueSelector.apply(t), "The value supplied is null"));
                    if (z) {
                        this.downstream.onNext(bVar);
                        if (bVar.f47075a.tryAbandon()) {
                            cancel(apply);
                            bVar.f47075a.onComplete();
                        }
                    }
                } catch (Throwable th) {
                    io.reactivex.rxjava3.c.b.b(th);
                    this.upstream.dispose();
                    if (z) {
                        this.downstream.onNext(bVar);
                    }
                    onError(th);
                }
            } catch (Throwable th2) {
                io.reactivex.rxjava3.c.b.b(th2);
                this.upstream.dispose();
                onError(th2);
            }
        }

        public final void onError(Throwable th) {
            ArrayList<b> arrayList = new ArrayList<>(this.groups.values());
            this.groups.clear();
            for (b bVar : arrayList) {
                bVar.f47075a.onError(th);
            }
            this.downstream.onError(th);
        }

        public final void onComplete() {
            ArrayList<b> arrayList = new ArrayList<>(this.groups.values());
            this.groups.clear();
            for (b bVar : arrayList) {
                bVar.f47075a.onComplete();
            }
            this.downstream.onComplete();
        }

        public final void dispose() {
            if (this.cancelled.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.upstream.dispose();
            }
        }

        public final boolean isDisposed() {
            return this.cancelled.get();
        }

        public final void cancel(K k) {
            if (k == null) {
                k = NULL_KEY;
            }
            this.groups.remove(k);
            if (decrementAndGet() == 0) {
                this.upstream.dispose();
            }
        }
    }

    static final class b<K, T> extends io.reactivex.rxjava3.f.b<K, T> {

        /* renamed from: a  reason: collision with root package name */
        final c<T, K> f47075a;

        public static <T, K> b<K, T> a(K k, int i2, a<?, K, T> aVar, boolean z) {
            return new b<>(k, new c(i2, aVar, k, z));
        }

        private b(K k, c<T, K> cVar) {
            super(k);
            this.f47075a = cVar;
        }

        public final void subscribeActual(w<? super T> wVar) {
            this.f47075a.subscribe(wVar);
        }
    }

    static final class c<T, K> extends AtomicInteger implements u<T>, io.reactivex.rxjava3.b.c {
        static final int ABANDONED = 2;
        static final int ABANDONED_HAS_SUBSCRIBER = 3;
        static final int FRESH = 0;
        static final int HAS_SUBSCRIBER = 1;
        private static final long serialVersionUID = -3852313036005250360L;
        final AtomicReference<w<? super T>> actual = new AtomicReference<>();
        final AtomicBoolean cancelled = new AtomicBoolean();
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final K key;
        final AtomicInteger once = new AtomicInteger();
        final a<?, K, T> parent;
        final io.reactivex.rxjava3.e.g.c<T> queue;

        c(int i2, a<?, K, T> aVar, K k, boolean z) {
            this.queue = new io.reactivex.rxjava3.e.g.c<>(i2);
            this.parent = aVar;
            this.key = k;
            this.delayError = z;
        }

        public final void dispose() {
            if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.actual.lazySet((Object) null);
                cancelParent();
            }
        }

        public final boolean isDisposed() {
            return this.cancelled.get();
        }

        public final void subscribe(w<? super T> wVar) {
            int i2;
            do {
                i2 = this.once.get();
                if ((i2 & 1) == 0) {
                } else {
                    d.error((Throwable) new IllegalStateException("Only one Observer allowed!"), (w<?>) wVar);
                    return;
                }
            } while (!this.once.compareAndSet(i2, i2 | 1));
            wVar.onSubscribe(this);
            this.actual.lazySet(wVar);
            if (this.cancelled.get()) {
                this.actual.lazySet((Object) null);
            } else {
                drain();
            }
        }

        public final void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        public final void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        public final void onComplete() {
            this.done = true;
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            if (getAndIncrement() == 0) {
                io.reactivex.rxjava3.e.g.c<T> cVar = this.queue;
                boolean z = this.delayError;
                w wVar = this.actual.get();
                int i2 = 1;
                while (true) {
                    if (wVar != null) {
                        while (true) {
                            boolean z2 = this.done;
                            T poll = cVar.poll();
                            boolean z3 = poll == null;
                            if (!checkTerminated(z2, z3, wVar, z)) {
                                if (z3) {
                                    break;
                                }
                                wVar.onNext(poll);
                            } else {
                                return;
                            }
                        }
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                    if (wVar == null) {
                        wVar = this.actual.get();
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void cancelParent() {
            if ((this.once.get() & 2) == 0) {
                this.parent.cancel(this.key);
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean tryAbandon() {
            return this.once.get() == 0 && this.once.compareAndSet(0, 2);
        }

        /* access modifiers changed from: package-private */
        public final boolean checkTerminated(boolean z, boolean z2, w<? super T> wVar, boolean z3) {
            if (this.cancelled.get()) {
                this.queue.clear();
                this.actual.lazySet((Object) null);
                cancelParent();
                return true;
            } else if (!z) {
                return false;
            } else {
                if (!z3) {
                    Throwable th = this.error;
                    if (th != null) {
                        this.queue.clear();
                        this.actual.lazySet((Object) null);
                        wVar.onError(th);
                        return true;
                    } else if (!z2) {
                        return false;
                    } else {
                        this.actual.lazySet((Object) null);
                        wVar.onComplete();
                        return true;
                    }
                } else if (!z2) {
                    return false;
                } else {
                    Throwable th2 = this.error;
                    this.actual.lazySet((Object) null);
                    if (th2 != null) {
                        wVar.onError(th2);
                    } else {
                        wVar.onComplete();
                    }
                    return true;
                }
            }
        }
    }
}
