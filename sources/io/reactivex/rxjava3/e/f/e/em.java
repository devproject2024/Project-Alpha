package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.e.a.f;
import io.reactivex.rxjava3.e.c.j;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class em<T> extends a<T, p<T>> {

    /* renamed from: b  reason: collision with root package name */
    final long f47422b;

    /* renamed from: c  reason: collision with root package name */
    final long f47423c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f47424d;

    /* renamed from: e  reason: collision with root package name */
    final x f47425e;

    /* renamed from: f  reason: collision with root package name */
    final long f47426f;

    /* renamed from: g  reason: collision with root package name */
    final int f47427g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f47428h;

    public em(p<T> pVar, long j, long j2, TimeUnit timeUnit, x xVar, long j3, int i2, boolean z) {
        super(pVar);
        this.f47422b = j;
        this.f47423c = j2;
        this.f47424d = timeUnit;
        this.f47425e = xVar;
        this.f47426f = j3;
        this.f47427g = i2;
        this.f47428h = z;
    }

    public final void subscribeActual(w<? super p<T>> wVar) {
        if (this.f47422b != this.f47423c) {
            this.f46900a.subscribe(new d(wVar, this.f47422b, this.f47423c, this.f47424d, this.f47425e.a(), this.f47427g));
        } else if (this.f47426f == Long.MAX_VALUE) {
            this.f46900a.subscribe(new c(wVar, this.f47422b, this.f47424d, this.f47425e, this.f47427g));
        } else {
            this.f46900a.subscribe(new b(wVar, this.f47422b, this.f47424d, this.f47425e, this.f47427g, this.f47426f, this.f47428h));
        }
    }

    static abstract class a<T> extends AtomicInteger implements w<T>, io.reactivex.rxjava3.b.c {
        private static final long serialVersionUID = 5724293814035355511L;
        final int bufferSize;
        volatile boolean done;
        final w<? super p<T>> downstream;
        final AtomicBoolean downstreamCancelled;
        long emitted;
        Throwable error;
        final j<Object> queue = new io.reactivex.rxjava3.e.g.a();
        final long timespan;
        final TimeUnit unit;
        io.reactivex.rxjava3.b.c upstream;
        volatile boolean upstreamCancelled;
        final AtomicInteger windowCount;

        /* access modifiers changed from: package-private */
        public abstract void cleanupResources();

        /* access modifiers changed from: package-private */
        public abstract void createFirstWindow();

        /* access modifiers changed from: package-private */
        public abstract void drain();

        a(w<? super p<T>> wVar, long j, TimeUnit timeUnit, int i2) {
            this.downstream = wVar;
            this.timespan = j;
            this.unit = timeUnit;
            this.bufferSize = i2;
            this.downstreamCancelled = new AtomicBoolean();
            this.windowCount = new AtomicInteger(1);
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
                createFirstWindow();
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

        public final void dispose() {
            if (this.downstreamCancelled.compareAndSet(false, true)) {
                windowDone();
            }
        }

        public final boolean isDisposed() {
            return this.downstreamCancelled.get();
        }

        /* access modifiers changed from: package-private */
        public final void windowDone() {
            if (this.windowCount.decrementAndGet() == 0) {
                cleanupResources();
                this.upstream.dispose();
                this.upstreamCancelled = true;
                drain();
            }
        }
    }

    static final class c<T> extends a<T> implements Runnable {
        static final Object NEXT_WINDOW = new Object();
        private static final long serialVersionUID = 1155822639622580836L;
        final x scheduler;
        final f timer = new f();
        io.reactivex.rxjava3.j.f<T> window;
        final Runnable windowRunnable = new a();

        c(w<? super p<T>> wVar, long j, TimeUnit timeUnit, x xVar, int i2) {
            super(wVar, j, timeUnit, i2);
            this.scheduler = xVar;
        }

        /* access modifiers changed from: package-private */
        public final void createFirstWindow() {
            if (!this.downstreamCancelled.get()) {
                this.windowCount.getAndIncrement();
                this.window = io.reactivex.rxjava3.j.f.a(this.bufferSize, this.windowRunnable);
                this.emitted = 1;
                el elVar = new el(this.window);
                this.downstream.onNext(elVar);
                this.timer.replace(this.scheduler.a(this, this.timespan, this.timespan, this.unit));
                if (elVar.a()) {
                    this.window.onComplete();
                }
            }
        }

        public final void run() {
            this.queue.offer(NEXT_WINDOW);
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            if (getAndIncrement() == 0) {
                j jVar = this.queue;
                w wVar = this.downstream;
                io.reactivex.rxjava3.j.f<T> fVar = this.window;
                int i2 = 1;
                while (true) {
                    if (this.upstreamCancelled) {
                        jVar.clear();
                        this.window = null;
                        fVar = null;
                    } else {
                        boolean z = this.done;
                        Object poll = jVar.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable th = this.error;
                            if (th != null) {
                                if (fVar != null) {
                                    fVar.onError(th);
                                }
                                wVar.onError(th);
                            } else {
                                if (fVar != null) {
                                    fVar.onComplete();
                                }
                                wVar.onComplete();
                            }
                            cleanupResources();
                            this.upstreamCancelled = true;
                        } else if (!z2) {
                            if (poll == NEXT_WINDOW) {
                                if (fVar != null) {
                                    fVar.onComplete();
                                    this.window = null;
                                    fVar = null;
                                }
                                if (this.downstreamCancelled.get()) {
                                    this.timer.dispose();
                                } else {
                                    this.emitted++;
                                    this.windowCount.getAndIncrement();
                                    fVar = io.reactivex.rxjava3.j.f.a(this.bufferSize, this.windowRunnable);
                                    this.window = fVar;
                                    el elVar = new el(fVar);
                                    wVar.onNext(elVar);
                                    if (elVar.a()) {
                                        fVar.onComplete();
                                    }
                                }
                            } else if (fVar != null) {
                                fVar.onNext(poll);
                            }
                        }
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void cleanupResources() {
            this.timer.dispose();
        }

        final class a implements Runnable {
            a() {
            }

            public final void run() {
                c.this.windowDone();
            }
        }
    }

    static final class b<T> extends a<T> implements Runnable {
        private static final long serialVersionUID = -6130475889925953722L;
        long count;
        final long maxSize;
        final boolean restartTimerOnMaxSize;
        final x scheduler;
        final f timer;
        io.reactivex.rxjava3.j.f<T> window;
        final x.c worker;

        b(w<? super p<T>> wVar, long j, TimeUnit timeUnit, x xVar, int i2, long j2, boolean z) {
            super(wVar, j, timeUnit, i2);
            this.scheduler = xVar;
            this.maxSize = j2;
            this.restartTimerOnMaxSize = z;
            if (z) {
                this.worker = xVar.a();
            } else {
                this.worker = null;
            }
            this.timer = new f();
        }

        /* access modifiers changed from: package-private */
        public final void createFirstWindow() {
            if (!this.downstreamCancelled.get()) {
                this.emitted = 1;
                this.windowCount.getAndIncrement();
                this.window = io.reactivex.rxjava3.j.f.a(this.bufferSize, (Runnable) this);
                el elVar = new el(this.window);
                this.downstream.onNext(elVar);
                a aVar = new a(this, 1);
                if (this.restartTimerOnMaxSize) {
                    this.timer.replace(this.worker.a(aVar, this.timespan, this.timespan, this.unit));
                } else {
                    this.timer.replace(this.scheduler.a(aVar, this.timespan, this.timespan, this.unit));
                }
                if (elVar.a()) {
                    this.window.onComplete();
                }
            }
        }

        public final void run() {
            windowDone();
        }

        /* access modifiers changed from: package-private */
        public final void cleanupResources() {
            this.timer.dispose();
            x.c cVar = this.worker;
            if (cVar != null) {
                cVar.dispose();
            }
        }

        /* access modifiers changed from: package-private */
        public final void boundary(a aVar) {
            this.queue.offer(aVar);
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            if (getAndIncrement() == 0) {
                j jVar = this.queue;
                w wVar = this.downstream;
                io.reactivex.rxjava3.j.f<T> fVar = this.window;
                int i2 = 1;
                while (true) {
                    if (this.upstreamCancelled) {
                        jVar.clear();
                        this.window = null;
                        fVar = null;
                    } else {
                        boolean z = this.done;
                        Object poll = jVar.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable th = this.error;
                            if (th != null) {
                                if (fVar != null) {
                                    fVar.onError(th);
                                }
                                wVar.onError(th);
                            } else {
                                if (fVar != null) {
                                    fVar.onComplete();
                                }
                                wVar.onComplete();
                            }
                            cleanupResources();
                            this.upstreamCancelled = true;
                        } else if (!z2) {
                            if (poll instanceof a) {
                                if (((a) poll).f47430b == this.emitted || !this.restartTimerOnMaxSize) {
                                    this.count = 0;
                                    fVar = createNewWindow(fVar);
                                }
                            } else if (fVar != null) {
                                fVar.onNext(poll);
                                long j = this.count + 1;
                                if (j == this.maxSize) {
                                    this.count = 0;
                                    fVar = createNewWindow(fVar);
                                } else {
                                    this.count = j;
                                }
                            }
                        }
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final io.reactivex.rxjava3.j.f<T> createNewWindow(io.reactivex.rxjava3.j.f<T> fVar) {
            if (fVar != null) {
                fVar.onComplete();
                fVar = null;
            }
            if (this.downstreamCancelled.get()) {
                cleanupResources();
            } else {
                long j = this.emitted + 1;
                this.emitted = j;
                this.windowCount.getAndIncrement();
                fVar = io.reactivex.rxjava3.j.f.a(this.bufferSize, (Runnable) this);
                this.window = fVar;
                el elVar = new el(fVar);
                this.downstream.onNext(elVar);
                if (this.restartTimerOnMaxSize) {
                    this.timer.update(this.worker.a(new a(this, j), this.timespan, this.timespan, this.unit));
                }
                if (elVar.a()) {
                    fVar.onComplete();
                }
            }
            return fVar;
        }

        static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final b<?> f47429a;

            /* renamed from: b  reason: collision with root package name */
            final long f47430b;

            a(b<?> bVar, long j) {
                this.f47429a = bVar;
                this.f47430b = j;
            }

            public final void run() {
                this.f47429a.boundary(this);
            }
        }
    }

    static final class d<T> extends a<T> implements Runnable {
        static final Object WINDOW_CLOSE = new Object();
        static final Object WINDOW_OPEN = new Object();
        private static final long serialVersionUID = -7852870764194095894L;
        final long timeskip;
        final List<io.reactivex.rxjava3.j.f<T>> windows = new LinkedList();
        final x.c worker;

        d(w<? super p<T>> wVar, long j, long j2, TimeUnit timeUnit, x.c cVar, int i2) {
            super(wVar, j, timeUnit, i2);
            this.timeskip = j2;
            this.worker = cVar;
        }

        /* access modifiers changed from: package-private */
        public final void createFirstWindow() {
            if (!this.downstreamCancelled.get()) {
                this.emitted = 1;
                this.windowCount.getAndIncrement();
                io.reactivex.rxjava3.j.f a2 = io.reactivex.rxjava3.j.f.a(this.bufferSize, (Runnable) this);
                this.windows.add(a2);
                el elVar = new el(a2);
                this.downstream.onNext(elVar);
                this.worker.a(new a(this, false), this.timespan, this.unit);
                x.c cVar = this.worker;
                a aVar = new a(this, true);
                long j = this.timeskip;
                cVar.a(aVar, j, j, this.unit);
                if (elVar.a()) {
                    a2.onComplete();
                    this.windows.remove(a2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void cleanupResources() {
            this.worker.dispose();
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            if (getAndIncrement() == 0) {
                j jVar = this.queue;
                w wVar = this.downstream;
                List<io.reactivex.rxjava3.j.f<T>> list = this.windows;
                int i2 = 1;
                while (true) {
                    if (this.upstreamCancelled) {
                        jVar.clear();
                        list.clear();
                    } else {
                        boolean z = this.done;
                        Object poll = jVar.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable th = this.error;
                            if (th != null) {
                                for (io.reactivex.rxjava3.j.f<T> onError : list) {
                                    onError.onError(th);
                                }
                                wVar.onError(th);
                            } else {
                                for (io.reactivex.rxjava3.j.f<T> onComplete : list) {
                                    onComplete.onComplete();
                                }
                                wVar.onComplete();
                            }
                            cleanupResources();
                            this.upstreamCancelled = true;
                        } else if (!z2) {
                            if (poll == WINDOW_OPEN) {
                                if (!this.downstreamCancelled.get()) {
                                    this.emitted++;
                                    this.windowCount.getAndIncrement();
                                    io.reactivex.rxjava3.j.f a2 = io.reactivex.rxjava3.j.f.a(this.bufferSize, (Runnable) this);
                                    list.add(a2);
                                    el elVar = new el(a2);
                                    wVar.onNext(elVar);
                                    this.worker.a(new a(this, false), this.timespan, this.unit);
                                    if (elVar.a()) {
                                        a2.onComplete();
                                    }
                                }
                            } else if (poll != WINDOW_CLOSE) {
                                for (io.reactivex.rxjava3.j.f<T> onNext : list) {
                                    onNext.onNext(poll);
                                }
                            } else if (!list.isEmpty()) {
                                list.remove(0).onComplete();
                            }
                        }
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        public final void run() {
            windowDone();
        }

        /* access modifiers changed from: package-private */
        public final void boundary(boolean z) {
            this.queue.offer(z ? WINDOW_OPEN : WINDOW_CLOSE);
            drain();
        }

        static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final d<?> f47432a;

            /* renamed from: b  reason: collision with root package name */
            final boolean f47433b;

            a(d<?> dVar, boolean z) {
                this.f47432a = dVar;
                this.f47433b = z;
            }

            public final void run() {
                this.f47432a.boundary(this.f47433b);
            }
        }
    }
}
