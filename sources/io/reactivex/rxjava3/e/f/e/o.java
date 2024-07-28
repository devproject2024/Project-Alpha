package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.d.r;
import io.reactivex.rxjava3.e.a.d;
import io.reactivex.rxjava3.e.e.t;
import io.reactivex.rxjava3.e.k.q;
import io.reactivex.rxjava3.g.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class o<T, U extends Collection<? super T>> extends a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final long f47505b;

    /* renamed from: c  reason: collision with root package name */
    final long f47506c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f47507d;

    /* renamed from: e  reason: collision with root package name */
    final x f47508e;

    /* renamed from: f  reason: collision with root package name */
    final r<U> f47509f;

    /* renamed from: g  reason: collision with root package name */
    final int f47510g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f47511h;

    public o(u<T> uVar, long j, long j2, TimeUnit timeUnit, x xVar, r<U> rVar, int i2, boolean z) {
        super(uVar);
        this.f47505b = j;
        this.f47506c = j2;
        this.f47507d = timeUnit;
        this.f47508e = xVar;
        this.f47509f = rVar;
        this.f47510g = i2;
        this.f47511h = z;
    }

    public final void subscribeActual(w<? super U> wVar) {
        if (this.f47505b == this.f47506c && this.f47510g == Integer.MAX_VALUE) {
            this.f46900a.subscribe(new b(new f(wVar), this.f47509f, this.f47505b, this.f47507d, this.f47508e));
            return;
        }
        x.c a2 = this.f47508e.a();
        if (this.f47505b == this.f47506c) {
            this.f46900a.subscribe(new a(new f(wVar), this.f47509f, this.f47505b, this.f47507d, this.f47510g, this.f47511h, a2));
        } else {
            this.f46900a.subscribe(new c(new f(wVar), this.f47509f, this.f47505b, this.f47506c, this.f47507d, a2));
        }
    }

    static final class b<T, U extends Collection<? super T>> extends t<T, U, U> implements io.reactivex.rxjava3.b.c, Runnable {

        /* renamed from: g  reason: collision with root package name */
        final r<U> f47515g;

        /* renamed from: h  reason: collision with root package name */
        final long f47516h;

        /* renamed from: i  reason: collision with root package name */
        final TimeUnit f47517i;
        final x j;
        io.reactivex.rxjava3.b.c k;
        U l;
        final AtomicReference<io.reactivex.rxjava3.b.c> m = new AtomicReference<>();

        public final /* synthetic */ void a(w wVar, Object obj) {
            this.f46734a.onNext((Collection) obj);
        }

        b(w<? super U> wVar, r<U> rVar, long j2, TimeUnit timeUnit, x xVar) {
            super(wVar, new io.reactivex.rxjava3.e.g.a());
            this.f47515g = rVar;
            this.f47516h = j2;
            this.f47517i = timeUnit;
            this.j = xVar;
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.k, cVar)) {
                this.k = cVar;
                try {
                    this.l = (Collection) Objects.requireNonNull(this.f47515g.get(), "The buffer supplied is null");
                    this.f46734a.onSubscribe(this);
                    if (!io.reactivex.rxjava3.e.a.c.isDisposed(this.m.get())) {
                        x xVar = this.j;
                        long j2 = this.f47516h;
                        io.reactivex.rxjava3.e.a.c.set(this.m, xVar.a(this, j2, j2, this.f47517i));
                    }
                } catch (Throwable th) {
                    io.reactivex.rxjava3.c.b.b(th);
                    dispose();
                    d.error(th, (w<?>) this.f46734a);
                }
            }
        }

        public final void onNext(T t) {
            synchronized (this) {
                U u = this.l;
                if (u != null) {
                    u.add(t);
                }
            }
        }

        public final void onError(Throwable th) {
            synchronized (this) {
                this.l = null;
            }
            this.f46734a.onError(th);
            io.reactivex.rxjava3.e.a.c.dispose(this.m);
        }

        public final void onComplete() {
            U u;
            synchronized (this) {
                u = this.l;
                this.l = null;
            }
            if (u != null) {
                this.f46735b.offer(u);
                this.f46737d = true;
                if (c()) {
                    q.a(this.f46735b, this.f46734a, (io.reactivex.rxjava3.b.c) null, this);
                }
            }
            io.reactivex.rxjava3.e.a.c.dispose(this.m);
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this.m);
            this.k.dispose();
        }

        public final boolean isDisposed() {
            return this.m.get() == io.reactivex.rxjava3.e.a.c.DISPOSED;
        }

        public final void run() {
            U u;
            try {
                U u2 = (Collection) Objects.requireNonNull(this.f47515g.get(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    u = this.l;
                    if (u != null) {
                        this.l = u2;
                    }
                }
                if (u == null) {
                    io.reactivex.rxjava3.e.a.c.dispose(this.m);
                } else {
                    a(u, (io.reactivex.rxjava3.b.c) this);
                }
            } catch (Throwable th) {
                io.reactivex.rxjava3.c.b.b(th);
                this.f46734a.onError(th);
                dispose();
            }
        }
    }

    static final class c<T, U extends Collection<? super T>> extends t<T, U, U> implements io.reactivex.rxjava3.b.c, Runnable {

        /* renamed from: g  reason: collision with root package name */
        final r<U> f47518g;

        /* renamed from: h  reason: collision with root package name */
        final long f47519h;

        /* renamed from: i  reason: collision with root package name */
        final long f47520i;
        final TimeUnit j;
        final x.c k;
        final List<U> l = new LinkedList();
        io.reactivex.rxjava3.b.c m;

        public final /* synthetic */ void a(w wVar, Object obj) {
            wVar.onNext((Collection) obj);
        }

        c(w<? super U> wVar, r<U> rVar, long j2, long j3, TimeUnit timeUnit, x.c cVar) {
            super(wVar, new io.reactivex.rxjava3.e.g.a());
            this.f47518g = rVar;
            this.f47519h = j2;
            this.f47520i = j3;
            this.j = timeUnit;
            this.k = cVar;
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.m, cVar)) {
                this.m = cVar;
                try {
                    Collection collection = (Collection) Objects.requireNonNull(this.f47518g.get(), "The buffer supplied is null");
                    this.l.add(collection);
                    this.f46734a.onSubscribe(this);
                    x.c cVar2 = this.k;
                    long j2 = this.f47520i;
                    cVar2.a(this, j2, j2, this.j);
                    this.k.a(new b(collection), this.f47519h, this.j);
                } catch (Throwable th) {
                    io.reactivex.rxjava3.c.b.b(th);
                    cVar.dispose();
                    d.error(th, (w<?>) this.f46734a);
                    this.k.dispose();
                }
            }
        }

        public final void onNext(T t) {
            synchronized (this) {
                for (U add : this.l) {
                    add.add(t);
                }
            }
        }

        public final void onError(Throwable th) {
            this.f46737d = true;
            e();
            this.f46734a.onError(th);
            this.k.dispose();
        }

        public final void onComplete() {
            ArrayList<Collection> arrayList;
            synchronized (this) {
                arrayList = new ArrayList<>(this.l);
                this.l.clear();
            }
            for (Collection offer : arrayList) {
                this.f46735b.offer(offer);
            }
            this.f46737d = true;
            if (c()) {
                q.a(this.f46735b, this.f46734a, this.k, this);
            }
        }

        public final void dispose() {
            if (!this.f46736c) {
                this.f46736c = true;
                e();
                this.m.dispose();
                this.k.dispose();
            }
        }

        public final boolean isDisposed() {
            return this.f46736c;
        }

        private void e() {
            synchronized (this) {
                this.l.clear();
            }
        }

        public final void run() {
            if (!this.f46736c) {
                try {
                    Collection collection = (Collection) Objects.requireNonNull(this.f47518g.get(), "The bufferSupplier returned a null buffer");
                    synchronized (this) {
                        if (!this.f46736c) {
                            this.l.add(collection);
                            this.k.a(new a(collection), this.f47519h, this.j);
                        }
                    }
                } catch (Throwable th) {
                    io.reactivex.rxjava3.c.b.b(th);
                    this.f46734a.onError(th);
                    dispose();
                }
            }
        }

        final class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            private final U f47522b;

            a(U u) {
                this.f47522b = u;
            }

            public final void run() {
                synchronized (c.this) {
                    c.this.l.remove(this.f47522b);
                }
                c cVar = c.this;
                cVar.b(this.f47522b, cVar.k);
            }
        }

        final class b implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            private final U f47524b;

            b(U u) {
                this.f47524b = u;
            }

            public final void run() {
                synchronized (c.this) {
                    c.this.l.remove(this.f47524b);
                }
                c cVar = c.this;
                cVar.b(this.f47524b, cVar.k);
            }
        }
    }

    static final class a<T, U extends Collection<? super T>> extends t<T, U, U> implements io.reactivex.rxjava3.b.c, Runnable {

        /* renamed from: g  reason: collision with root package name */
        final r<U> f47512g;

        /* renamed from: h  reason: collision with root package name */
        final long f47513h;

        /* renamed from: i  reason: collision with root package name */
        final TimeUnit f47514i;
        final int j;
        final boolean k;
        final x.c l;
        U m;
        io.reactivex.rxjava3.b.c n;
        io.reactivex.rxjava3.b.c o;
        long p;
        long q;

        public final /* synthetic */ void a(w wVar, Object obj) {
            wVar.onNext((Collection) obj);
        }

        a(w<? super U> wVar, r<U> rVar, long j2, TimeUnit timeUnit, int i2, boolean z, x.c cVar) {
            super(wVar, new io.reactivex.rxjava3.e.g.a());
            this.f47512g = rVar;
            this.f47513h = j2;
            this.f47514i = timeUnit;
            this.j = i2;
            this.k = z;
            this.l = cVar;
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.o, cVar)) {
                this.o = cVar;
                try {
                    this.m = (Collection) Objects.requireNonNull(this.f47512g.get(), "The buffer supplied is null");
                    this.f46734a.onSubscribe(this);
                    x.c cVar2 = this.l;
                    long j2 = this.f47513h;
                    this.n = cVar2.a(this, j2, j2, this.f47514i);
                } catch (Throwable th) {
                    io.reactivex.rxjava3.c.b.b(th);
                    cVar.dispose();
                    d.error(th, (w<?>) this.f46734a);
                    this.l.dispose();
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
            if (r7.k == false) goto L_0x0028;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
            r7.n.dispose();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
            b(r0, r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            r8 = (java.util.Collection) java.util.Objects.requireNonNull(r7.f47512g.get(), "The buffer supplied is null");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
            monitor-enter(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r7.m = r8;
            r7.q++;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0041, code lost:
            monitor-exit(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
            if (r7.k == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0046, code lost:
            r0 = r7.l;
            r4 = r7.f47513h;
            r7.n = r0.a(r7, r4, r4, r7.f47514i);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0058, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0059, code lost:
            io.reactivex.rxjava3.c.b.b(r8);
            r7.f46734a.onError(r8);
            dispose();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0064, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onNext(T r8) {
            /*
                r7 = this;
                monitor-enter(r7)
                U r0 = r7.m     // Catch:{ all -> 0x0065 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r7)     // Catch:{ all -> 0x0065 }
                return
            L_0x0007:
                r0.add(r8)     // Catch:{ all -> 0x0065 }
                int r8 = r0.size()     // Catch:{ all -> 0x0065 }
                int r1 = r7.j     // Catch:{ all -> 0x0065 }
                if (r8 >= r1) goto L_0x0014
                monitor-exit(r7)     // Catch:{ all -> 0x0065 }
                return
            L_0x0014:
                r8 = 0
                r7.m = r8     // Catch:{ all -> 0x0065 }
                long r1 = r7.p     // Catch:{ all -> 0x0065 }
                r3 = 1
                long r1 = r1 + r3
                r7.p = r1     // Catch:{ all -> 0x0065 }
                monitor-exit(r7)     // Catch:{ all -> 0x0065 }
                boolean r8 = r7.k
                if (r8 == 0) goto L_0x0028
                io.reactivex.rxjava3.b.c r8 = r7.n
                r8.dispose()
            L_0x0028:
                r7.b(r0, r7)
                io.reactivex.rxjava3.d.r<U> r8 = r7.f47512g     // Catch:{ all -> 0x0058 }
                java.lang.Object r8 = r8.get()     // Catch:{ all -> 0x0058 }
                java.lang.String r0 = "The buffer supplied is null"
                java.lang.Object r8 = java.util.Objects.requireNonNull(r8, r0)     // Catch:{ all -> 0x0058 }
                java.util.Collection r8 = (java.util.Collection) r8     // Catch:{ all -> 0x0058 }
                monitor-enter(r7)
                r7.m = r8     // Catch:{ all -> 0x0055 }
                long r0 = r7.q     // Catch:{ all -> 0x0055 }
                long r0 = r0 + r3
                r7.q = r0     // Catch:{ all -> 0x0055 }
                monitor-exit(r7)     // Catch:{ all -> 0x0055 }
                boolean r8 = r7.k
                if (r8 == 0) goto L_0x0054
                io.reactivex.rxjava3.a.x$c r0 = r7.l
                long r4 = r7.f47513h
                java.util.concurrent.TimeUnit r6 = r7.f47514i
                r1 = r7
                r2 = r4
                io.reactivex.rxjava3.b.c r8 = r0.a(r1, r2, r4, r6)
                r7.n = r8
            L_0x0054:
                return
            L_0x0055:
                r8 = move-exception
                monitor-exit(r7)     // Catch:{ all -> 0x0055 }
                throw r8
            L_0x0058:
                r8 = move-exception
                io.reactivex.rxjava3.c.b.b(r8)
                io.reactivex.rxjava3.a.w r0 = r7.f46734a
                r0.onError(r8)
                r7.dispose()
                return
            L_0x0065:
                r8 = move-exception
                monitor-exit(r7)     // Catch:{ all -> 0x0065 }
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.e.f.e.o.a.onNext(java.lang.Object):void");
        }

        public final void onError(Throwable th) {
            synchronized (this) {
                this.m = null;
            }
            this.f46734a.onError(th);
            this.l.dispose();
        }

        public final void onComplete() {
            U u;
            this.l.dispose();
            synchronized (this) {
                u = this.m;
                this.m = null;
            }
            if (u != null) {
                this.f46735b.offer(u);
                this.f46737d = true;
                if (c()) {
                    q.a(this.f46735b, this.f46734a, this, this);
                }
            }
        }

        public final void dispose() {
            if (!this.f46736c) {
                this.f46736c = true;
                this.o.dispose();
                this.l.dispose();
                synchronized (this) {
                    this.m = null;
                }
            }
        }

        public final boolean isDisposed() {
            return this.f46736c;
        }

        public final void run() {
            try {
                U u = (Collection) Objects.requireNonNull(this.f47512g.get(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    U u2 = this.m;
                    if (u2 != null) {
                        if (this.p == this.q) {
                            this.m = u;
                            b(u2, this);
                        }
                    }
                }
            } catch (Throwable th) {
                io.reactivex.rxjava3.c.b.b(th);
                dispose();
                this.f46734a.onError(th);
            }
        }
    }
}
