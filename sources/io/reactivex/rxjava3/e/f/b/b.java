package io.reactivex.rxjava3.e.f.b;

import io.reactivex.rxjava3.a.i;
import io.reactivex.rxjava3.a.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class b<T> extends io.reactivex.rxjava3.a.h<T> {

    /* renamed from: b  reason: collision with root package name */
    final j<T> f46771b;

    /* renamed from: c  reason: collision with root package name */
    final io.reactivex.rxjava3.a.a f46772c;

    public b(j<T> jVar, io.reactivex.rxjava3.a.a aVar) {
        this.f46771b = jVar;
        this.f46772c = aVar;
    }

    /* renamed from: io.reactivex.rxjava3.e.f.b.b$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f46773a = new int[io.reactivex.rxjava3.a.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                io.reactivex.rxjava3.a.a[] r0 = io.reactivex.rxjava3.a.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f46773a = r0
                int[] r0 = f46773a     // Catch:{ NoSuchFieldError -> 0x0014 }
                io.reactivex.rxjava3.a.a r1 = io.reactivex.rxjava3.a.a.MISSING     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f46773a     // Catch:{ NoSuchFieldError -> 0x001f }
                io.reactivex.rxjava3.a.a r1 = io.reactivex.rxjava3.a.a.ERROR     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f46773a     // Catch:{ NoSuchFieldError -> 0x002a }
                io.reactivex.rxjava3.a.a r1 = io.reactivex.rxjava3.a.a.DROP     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f46773a     // Catch:{ NoSuchFieldError -> 0x0035 }
                io.reactivex.rxjava3.a.a r1 = io.reactivex.rxjava3.a.a.LATEST     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.e.f.b.b.AnonymousClass1.<clinit>():void");
        }
    }

    public final void b(org.a.b<? super T> bVar) {
        a aVar;
        int i2 = AnonymousClass1.f46773a[this.f46772c.ordinal()];
        if (i2 == 1) {
            aVar = new f(bVar);
        } else if (i2 == 2) {
            aVar = new d(bVar);
        } else if (i2 == 3) {
            aVar = new c(bVar);
        } else if (i2 != 4) {
            aVar = new C0789b(bVar, io.reactivex.rxjava3.a.h.f46609a);
        } else {
            aVar = new e(bVar);
        }
        bVar.onSubscribe(aVar);
        try {
            this.f46771b.subscribe(aVar);
        } catch (Throwable th) {
            io.reactivex.rxjava3.c.b.b(th);
            aVar.onError(th);
        }
    }

    static final class h<T> extends AtomicInteger implements i<T> {
        private static final long serialVersionUID = 4883307006032401862L;
        volatile boolean done;
        final a<T> emitter;
        final io.reactivex.rxjava3.e.k.c errors = new io.reactivex.rxjava3.e.k.c();
        final io.reactivex.rxjava3.e.c.j<T> queue = new io.reactivex.rxjava3.e.g.c(16);

        public final i<T> serialize() {
            return this;
        }

        h(a<T> aVar) {
            this.emitter = aVar;
        }

        public final void onNext(T t) {
            if (!this.emitter.isCancelled() && !this.done) {
                if (t == null) {
                    onError(io.reactivex.rxjava3.e.k.j.a("onNext called with a null value."));
                    return;
                }
                if (get() != 0 || !compareAndSet(0, 1)) {
                    io.reactivex.rxjava3.e.c.j<T> jVar = this.queue;
                    synchronized (jVar) {
                        jVar.offer(t);
                    }
                    if (getAndIncrement() != 0) {
                        return;
                    }
                } else {
                    this.emitter.onNext(t);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                drainLoop();
            }
        }

        public final void onError(Throwable th) {
            if (!tryOnError(th)) {
                io.reactivex.rxjava3.h.a.a(th);
            }
        }

        public final boolean tryOnError(Throwable th) {
            if (!this.emitter.isCancelled() && !this.done) {
                if (th == null) {
                    th = io.reactivex.rxjava3.e.k.j.a("onError called with a null Throwable.");
                }
                if (this.errors.tryAddThrowable(th)) {
                    this.done = true;
                    drain();
                    return true;
                }
            }
            return false;
        }

        public final void onComplete() {
            if (!this.emitter.isCancelled() && !this.done) {
                this.done = true;
                drain();
            }
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* access modifiers changed from: package-private */
        public final void drainLoop() {
            a<T> aVar = this.emitter;
            io.reactivex.rxjava3.e.c.j<T> jVar = this.queue;
            io.reactivex.rxjava3.e.k.c cVar = this.errors;
            int i2 = 1;
            while (!aVar.isCancelled()) {
                if (cVar.get() != null) {
                    jVar.clear();
                    cVar.tryTerminateConsumer((io.reactivex.rxjava3.a.g<?>) aVar);
                    return;
                }
                boolean z = this.done;
                T poll = jVar.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    aVar.onComplete();
                    return;
                } else if (!z2) {
                    aVar.onNext(poll);
                } else {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
            jVar.clear();
        }

        public final void setDisposable(io.reactivex.rxjava3.b.c cVar) {
            this.emitter.setDisposable(cVar);
        }

        public final void setCancellable(io.reactivex.rxjava3.d.f fVar) {
            this.emitter.setCancellable(fVar);
        }

        public final long requested() {
            return this.emitter.requested();
        }

        public final boolean isCancelled() {
            return this.emitter.isCancelled();
        }

        public final String toString() {
            return this.emitter.toString();
        }
    }

    static abstract class a<T> extends AtomicLong implements i<T>, org.a.c {
        private static final long serialVersionUID = 7326289992464377023L;
        final org.a.b<? super T> downstream;
        final io.reactivex.rxjava3.e.a.f serial = new io.reactivex.rxjava3.e.a.f();

        /* access modifiers changed from: package-private */
        public void onRequested() {
        }

        /* access modifiers changed from: package-private */
        public void onUnsubscribed() {
        }

        a(org.a.b<? super T> bVar) {
            this.downstream = bVar;
        }

        public void onComplete() {
            completeDownstream();
        }

        /* access modifiers changed from: protected */
        public void completeDownstream() {
            if (!isCancelled()) {
                try {
                    this.downstream.onComplete();
                } finally {
                    this.serial.dispose();
                }
            }
        }

        public final void onError(Throwable th) {
            if (th == null) {
                th = io.reactivex.rxjava3.e.k.j.a("onError called with a null Throwable.");
            }
            if (!signalError(th)) {
                io.reactivex.rxjava3.h.a.a(th);
            }
        }

        public final boolean tryOnError(Throwable th) {
            if (th == null) {
                th = io.reactivex.rxjava3.e.k.j.a("tryOnError called with a null Throwable.");
            }
            return signalError(th);
        }

        public boolean signalError(Throwable th) {
            return errorDownstream(th);
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: protected */
        public boolean errorDownstream(Throwable th) {
            if (isCancelled()) {
                return false;
            }
            try {
                this.downstream.onError(th);
                this.serial.dispose();
                return true;
            } catch (Throwable th2) {
                this.serial.dispose();
                throw th2;
            }
        }

        public final void cancel() {
            this.serial.dispose();
            onUnsubscribed();
        }

        public final boolean isCancelled() {
            return this.serial.isDisposed();
        }

        public final void request(long j) {
            if (io.reactivex.rxjava3.e.j.g.validate(j)) {
                io.reactivex.rxjava3.e.k.d.a((AtomicLong) this, j);
                onRequested();
            }
        }

        public final void setDisposable(io.reactivex.rxjava3.b.c cVar) {
            this.serial.update(cVar);
        }

        public final void setCancellable(io.reactivex.rxjava3.d.f fVar) {
            setDisposable(new io.reactivex.rxjava3.e.a.b(fVar));
        }

        public final long requested() {
            return get();
        }

        public final i<T> serialize() {
            return new h(this);
        }

        public String toString() {
            return String.format("%s{%s}", new Object[]{getClass().getSimpleName(), super.toString()});
        }
    }

    static final class f<T> extends a<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        f(org.a.b<? super T> bVar) {
            super(bVar);
        }

        public final void onNext(T t) {
            long j;
            if (!isCancelled()) {
                if (t != null) {
                    this.downstream.onNext(t);
                    do {
                        j = get();
                        if (j == 0 || compareAndSet(j, j - 1)) {
                            return;
                        }
                        j = get();
                        return;
                    } while (compareAndSet(j, j - 1));
                    return;
                }
                onError(io.reactivex.rxjava3.e.k.j.a("onNext called with a null value."));
            }
        }
    }

    static abstract class g<T> extends a<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        /* access modifiers changed from: package-private */
        public abstract void onOverflow();

        g(org.a.b<? super T> bVar) {
            super(bVar);
        }

        public final void onNext(T t) {
            if (!isCancelled()) {
                if (t == null) {
                    onError(io.reactivex.rxjava3.e.k.j.a("onNext called with a null value."));
                } else if (get() != 0) {
                    this.downstream.onNext(t);
                    io.reactivex.rxjava3.e.k.d.b(this, 1);
                } else {
                    onOverflow();
                }
            }
        }
    }

    static final class c<T> extends g<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        /* access modifiers changed from: package-private */
        public final void onOverflow() {
        }

        c(org.a.b<? super T> bVar) {
            super(bVar);
        }
    }

    static final class d<T> extends g<T> {
        private static final long serialVersionUID = 338953216916120960L;

        d(org.a.b<? super T> bVar) {
            super(bVar);
        }

        /* access modifiers changed from: package-private */
        public final void onOverflow() {
            onError(new io.reactivex.rxjava3.c.c("create: could not emit value due to lack of requests"));
        }
    }

    /* renamed from: io.reactivex.rxjava3.e.f.b.b$b  reason: collision with other inner class name */
    static final class C0789b<T> extends a<T> {
        private static final long serialVersionUID = 2427151001689639875L;
        volatile boolean done;
        Throwable error;
        final io.reactivex.rxjava3.e.g.c<T> queue;
        final AtomicInteger wip = new AtomicInteger();

        C0789b(org.a.b<? super T> bVar, int i2) {
            super(bVar);
            this.queue = new io.reactivex.rxjava3.e.g.c<>(i2);
        }

        public final void onNext(T t) {
            if (!this.done && !isCancelled()) {
                if (t == null) {
                    onError(io.reactivex.rxjava3.e.k.j.a("onNext called with a null value."));
                    return;
                }
                this.queue.offer(t);
                drain();
            }
        }

        public final boolean signalError(Throwable th) {
            if (this.done || isCancelled()) {
                return false;
            }
            this.error = th;
            this.done = true;
            drain();
            return true;
        }

        public final void onComplete() {
            this.done = true;
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void onRequested() {
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            int i2;
            if (this.wip.getAndIncrement() == 0) {
                org.a.b bVar = this.downstream;
                io.reactivex.rxjava3.e.g.c<T> cVar = this.queue;
                int i3 = 1;
                do {
                    long j = get();
                    long j2 = 0;
                    while (true) {
                        i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        } else if (isCancelled()) {
                            cVar.clear();
                            return;
                        } else {
                            boolean z = this.done;
                            T poll = cVar.poll();
                            boolean z2 = poll == null;
                            if (!z || !z2) {
                                if (z2) {
                                    break;
                                }
                                bVar.onNext(poll);
                                j2++;
                            } else {
                                Throwable th = this.error;
                                if (th != null) {
                                    errorDownstream(th);
                                    return;
                                } else {
                                    completeDownstream();
                                    return;
                                }
                            }
                        }
                    }
                    if (i2 == 0) {
                        if (isCancelled()) {
                            cVar.clear();
                            return;
                        }
                        boolean z3 = this.done;
                        boolean isEmpty = cVar.isEmpty();
                        if (z3 && isEmpty) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                errorDownstream(th2);
                                return;
                            } else {
                                completeDownstream();
                                return;
                            }
                        }
                    }
                    if (j2 != 0) {
                        io.reactivex.rxjava3.e.k.d.b(this, j2);
                    }
                    i3 = this.wip.addAndGet(-i3);
                } while (i3 != 0);
            }
        }
    }

    static final class e<T> extends a<T> {
        private static final long serialVersionUID = 4023437720691792495L;
        volatile boolean done;
        Throwable error;
        final AtomicReference<T> queue = new AtomicReference<>();
        final AtomicInteger wip = new AtomicInteger();

        e(org.a.b<? super T> bVar) {
            super(bVar);
        }

        public final void onNext(T t) {
            if (!this.done && !isCancelled()) {
                if (t == null) {
                    onError(io.reactivex.rxjava3.e.k.j.a("onNext called with a null value."));
                    return;
                }
                this.queue.set(t);
                drain();
            }
        }

        public final boolean signalError(Throwable th) {
            if (this.done || isCancelled()) {
                return false;
            }
            this.error = th;
            this.done = true;
            drain();
            return true;
        }

        public final void onComplete() {
            this.done = true;
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void onRequested() {
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.lazySet((Object) null);
            }
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            boolean z;
            int i2;
            if (this.wip.getAndIncrement() == 0) {
                org.a.b bVar = this.downstream;
                AtomicReference<T> atomicReference = this.queue;
                int i3 = 1;
                do {
                    long j = get();
                    long j2 = 0;
                    while (true) {
                        z = false;
                        i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        } else if (isCancelled()) {
                            atomicReference.lazySet((Object) null);
                            return;
                        } else {
                            boolean z2 = this.done;
                            T andSet = atomicReference.getAndSet((Object) null);
                            boolean z3 = andSet == null;
                            if (!z2 || !z3) {
                                if (z3) {
                                    break;
                                }
                                bVar.onNext(andSet);
                                j2++;
                            } else {
                                Throwable th = this.error;
                                if (th != null) {
                                    errorDownstream(th);
                                    return;
                                } else {
                                    completeDownstream();
                                    return;
                                }
                            }
                        }
                    }
                    if (i2 == 0) {
                        if (isCancelled()) {
                            atomicReference.lazySet((Object) null);
                            return;
                        }
                        boolean z4 = this.done;
                        if (atomicReference.get() == null) {
                            z = true;
                        }
                        if (z4 && z) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                errorDownstream(th2);
                                return;
                            } else {
                                completeDownstream();
                                return;
                            }
                        }
                    }
                    if (j2 != 0) {
                        io.reactivex.rxjava3.e.k.d.b(this, j2);
                    }
                    i3 = this.wip.addAndGet(-i3);
                } while (i3 != 0);
            }
        }
    }
}
