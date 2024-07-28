package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.g;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class cr<T> extends p<T> {

    /* renamed from: a  reason: collision with root package name */
    final io.reactivex.rxjava3.f.a<T> f47202a;

    /* renamed from: b  reason: collision with root package name */
    final int f47203b;

    /* renamed from: c  reason: collision with root package name */
    final long f47204c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f47205d;

    /* renamed from: e  reason: collision with root package name */
    final x f47206e;

    /* renamed from: f  reason: collision with root package name */
    a f47207f;

    public cr(io.reactivex.rxjava3.f.a<T> aVar) {
        this(aVar, TimeUnit.NANOSECONDS);
    }

    private cr(io.reactivex.rxjava3.f.a<T> aVar, TimeUnit timeUnit) {
        this.f47202a = aVar;
        this.f47203b = 1;
        this.f47204c = 0;
        this.f47205d = timeUnit;
        this.f47206e = null;
    }

    public final void subscribeActual(w<? super T> wVar) {
        a aVar;
        boolean z;
        synchronized (this) {
            aVar = this.f47207f;
            if (aVar == null) {
                aVar = new a(this);
                this.f47207f = aVar;
            }
            long j = aVar.subscriberCount;
            if (j == 0 && aVar.timer != null) {
                aVar.timer.dispose();
            }
            long j2 = j + 1;
            aVar.subscriberCount = j2;
            z = true;
            if (aVar.connected || j2 != ((long) this.f47203b)) {
                z = false;
            } else {
                aVar.connected = true;
            }
        }
        this.f47202a.subscribe(new b(wVar, this, aVar));
        if (z) {
            this.f47202a.a(aVar);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(a aVar) {
        synchronized (this) {
            if (this.f47207f == aVar) {
                if (aVar.timer != null) {
                    aVar.timer.dispose();
                    aVar.timer = null;
                }
                long j = aVar.subscriberCount - 1;
                aVar.subscriberCount = j;
                if (j == 0) {
                    this.f47207f = null;
                    this.f47202a.a();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(a aVar) {
        synchronized (this) {
            if (aVar.subscriberCount == 0 && aVar == this.f47207f) {
                this.f47207f = null;
                c cVar = (c) aVar.get();
                io.reactivex.rxjava3.e.a.c.dispose(aVar);
                if (cVar == null) {
                    aVar.disconnectedEarly = true;
                } else {
                    this.f47202a.a();
                }
            }
        }
    }

    static final class a extends AtomicReference<c> implements g<c>, Runnable {
        private static final long serialVersionUID = -4552101107598366241L;
        boolean connected;
        boolean disconnectedEarly;
        final cr<?> parent;
        long subscriberCount;
        c timer;

        a(cr<?> crVar) {
            this.parent = crVar;
        }

        public final void run() {
            this.parent.b(this);
        }

        public final void accept(c cVar) {
            io.reactivex.rxjava3.e.a.c.replace(this, cVar);
            synchronized (this.parent) {
                if (this.disconnectedEarly) {
                    this.parent.f47202a.a();
                }
            }
        }
    }

    static final class b<T> extends AtomicBoolean implements w<T>, c {
        private static final long serialVersionUID = -7419642935409022375L;
        final a connection;
        final w<? super T> downstream;
        final cr<T> parent;
        c upstream;

        b(w<? super T> wVar, cr<T> crVar, a aVar) {
            this.downstream = wVar;
            this.parent = crVar;
            this.connection = aVar;
        }

        public final void onNext(T t) {
            this.downstream.onNext(t);
        }

        public final void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.parent.a(this.connection);
                this.downstream.onError(th);
                return;
            }
            io.reactivex.rxjava3.h.a.a(th);
        }

        public final void onComplete() {
            if (compareAndSet(false, true)) {
                this.parent.a(this.connection);
                this.downstream.onComplete();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0051, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void dispose() {
            /*
                r7 = this;
                io.reactivex.rxjava3.b.c r0 = r7.upstream
                r0.dispose()
                r0 = 0
                r1 = 1
                boolean r0 = r7.compareAndSet(r0, r1)
                if (r0 == 0) goto L_0x0055
                io.reactivex.rxjava3.e.f.e.cr<T> r0 = r7.parent
                io.reactivex.rxjava3.e.f.e.cr$a r1 = r7.connection
                monitor-enter(r0)
                io.reactivex.rxjava3.e.f.e.cr$a r2 = r0.f47207f     // Catch:{ all -> 0x0052 }
                if (r2 == 0) goto L_0x0050
                io.reactivex.rxjava3.e.f.e.cr$a r2 = r0.f47207f     // Catch:{ all -> 0x0052 }
                if (r2 == r1) goto L_0x001b
                goto L_0x0050
            L_0x001b:
                long r2 = r1.subscriberCount     // Catch:{ all -> 0x0052 }
                r4 = 1
                long r2 = r2 - r4
                r1.subscriberCount = r2     // Catch:{ all -> 0x0052 }
                r4 = 0
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 != 0) goto L_0x004e
                boolean r2 = r1.connected     // Catch:{ all -> 0x0052 }
                if (r2 != 0) goto L_0x002d
                goto L_0x004e
            L_0x002d:
                long r2 = r0.f47204c     // Catch:{ all -> 0x0052 }
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 != 0) goto L_0x0038
                r0.b(r1)     // Catch:{ all -> 0x0052 }
                monitor-exit(r0)     // Catch:{ all -> 0x0052 }
                return
            L_0x0038:
                io.reactivex.rxjava3.e.a.f r2 = new io.reactivex.rxjava3.e.a.f     // Catch:{ all -> 0x0052 }
                r2.<init>()     // Catch:{ all -> 0x0052 }
                r1.timer = r2     // Catch:{ all -> 0x0052 }
                monitor-exit(r0)     // Catch:{ all -> 0x0052 }
                io.reactivex.rxjava3.a.x r3 = r0.f47206e
                long r4 = r0.f47204c
                java.util.concurrent.TimeUnit r0 = r0.f47205d
                io.reactivex.rxjava3.b.c r0 = r3.a(r1, r4, r0)
                r2.replace(r0)
                goto L_0x0055
            L_0x004e:
                monitor-exit(r0)     // Catch:{ all -> 0x0052 }
                return
            L_0x0050:
                monitor-exit(r0)     // Catch:{ all -> 0x0052 }
                return
            L_0x0052:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0052 }
                throw r1
            L_0x0055:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.e.f.e.cr.b.dispose():void");
        }

        public final boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
            }
        }
    }
}
