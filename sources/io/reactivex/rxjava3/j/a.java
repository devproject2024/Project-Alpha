package io.reactivex.rxjava3.j;

import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.k.a;
import io.reactivex.rxjava3.e.k.j;
import io.reactivex.rxjava3.e.k.m;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class a<T> extends e<T> {

    /* renamed from: c  reason: collision with root package name */
    static final C0828a[] f47784c = new C0828a[0];

    /* renamed from: d  reason: collision with root package name */
    static final C0828a[] f47785d = new C0828a[0];

    /* renamed from: a  reason: collision with root package name */
    final AtomicReference<Object> f47786a = new AtomicReference<>((Object) null);

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<C0828a<T>[]> f47787b = new AtomicReference<>(f47784c);

    /* renamed from: e  reason: collision with root package name */
    final ReadWriteLock f47788e = new ReentrantReadWriteLock();

    /* renamed from: f  reason: collision with root package name */
    final Lock f47789f = this.f47788e.readLock();

    /* renamed from: g  reason: collision with root package name */
    final Lock f47790g = this.f47788e.writeLock();

    /* renamed from: h  reason: collision with root package name */
    final AtomicReference<Throwable> f47791h = new AtomicReference<>();

    /* renamed from: i  reason: collision with root package name */
    long f47792i;

    public static <T> a<T> a() {
        return new a<>();
    }

    private a() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0064, code lost:
        if (r8 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006a, code lost:
        if (r0.test(r8) != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x006e, code lost:
        if (r0.f47799g != false) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0070, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r8 = r0.f47797e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0073, code lost:
        if (r8 != null) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0075, code lost:
        r0.f47796d = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0077, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0078, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0079, code lost:
        r0.f47797e = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x007c, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x007d, code lost:
        r8.a((io.reactivex.rxjava3.e.k.a.C0826a<? super java.lang.Object>) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void subscribeActual(io.reactivex.rxjava3.a.w<? super T> r8) {
        /*
            r7 = this;
            io.reactivex.rxjava3.j.a$a r0 = new io.reactivex.rxjava3.j.a$a
            r0.<init>(r8, r7)
            r8.onSubscribe(r0)
        L_0x0008:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.j.a$a<T>[]> r1 = r7.f47787b
            java.lang.Object r1 = r1.get()
            io.reactivex.rxjava3.j.a$a[] r1 = (io.reactivex.rxjava3.j.a.C0828a[]) r1
            io.reactivex.rxjava3.j.a$a[] r2 = f47785d
            r3 = 1
            r4 = 0
            if (r1 != r2) goto L_0x0018
            r1 = 0
            goto L_0x002b
        L_0x0018:
            int r2 = r1.length
            int r5 = r2 + 1
            io.reactivex.rxjava3.j.a$a[] r5 = new io.reactivex.rxjava3.j.a.C0828a[r5]
            java.lang.System.arraycopy(r1, r4, r5, r4, r2)
            r5[r2] = r0
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.j.a$a<T>[]> r2 = r7.f47787b
            boolean r1 = r2.compareAndSet(r1, r5)
            if (r1 == 0) goto L_0x0008
            r1 = 1
        L_0x002b:
            if (r1 == 0) goto L_0x0088
            boolean r8 = r0.f47799g
            if (r8 == 0) goto L_0x0035
            r7.a(r0)
            return
        L_0x0035:
            boolean r8 = r0.f47799g
            if (r8 != 0) goto L_0x0087
            monitor-enter(r0)
            boolean r8 = r0.f47799g     // Catch:{ all -> 0x0084 }
            if (r8 == 0) goto L_0x0040
            monitor-exit(r0)     // Catch:{ all -> 0x0084 }
            return
        L_0x0040:
            boolean r8 = r0.f47795c     // Catch:{ all -> 0x0084 }
            if (r8 == 0) goto L_0x0046
            monitor-exit(r0)     // Catch:{ all -> 0x0084 }
            return
        L_0x0046:
            io.reactivex.rxjava3.j.a<T> r8 = r0.f47794b     // Catch:{ all -> 0x0084 }
            java.util.concurrent.locks.Lock r1 = r8.f47789f     // Catch:{ all -> 0x0084 }
            r1.lock()     // Catch:{ all -> 0x0084 }
            long r5 = r8.f47792i     // Catch:{ all -> 0x0084 }
            r0.f47800h = r5     // Catch:{ all -> 0x0084 }
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r8 = r8.f47786a     // Catch:{ all -> 0x0084 }
            java.lang.Object r8 = r8.get()     // Catch:{ all -> 0x0084 }
            r1.unlock()     // Catch:{ all -> 0x0084 }
            if (r8 == 0) goto L_0x005e
            r1 = 1
            goto L_0x005f
        L_0x005e:
            r1 = 0
        L_0x005f:
            r0.f47796d = r1     // Catch:{ all -> 0x0084 }
            r0.f47795c = r3     // Catch:{ all -> 0x0084 }
            monitor-exit(r0)     // Catch:{ all -> 0x0084 }
            if (r8 == 0) goto L_0x0087
            boolean r8 = r0.test(r8)
            if (r8 != 0) goto L_0x0087
        L_0x006c:
            boolean r8 = r0.f47799g
            if (r8 != 0) goto L_0x0087
            monitor-enter(r0)
            io.reactivex.rxjava3.e.k.a<java.lang.Object> r8 = r0.f47797e     // Catch:{ all -> 0x0081 }
            if (r8 != 0) goto L_0x0079
            r0.f47796d = r4     // Catch:{ all -> 0x0081 }
            monitor-exit(r0)     // Catch:{ all -> 0x0081 }
            return
        L_0x0079:
            r1 = 0
            r0.f47797e = r1     // Catch:{ all -> 0x0081 }
            monitor-exit(r0)     // Catch:{ all -> 0x0081 }
            r8.a(r0)
            goto L_0x006c
        L_0x0081:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0081 }
            throw r8
        L_0x0084:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0084 }
            throw r8
        L_0x0087:
            return
        L_0x0088:
            java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r7.f47791h
            java.lang.Object r0 = r0.get()
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            java.lang.Throwable r1 = io.reactivex.rxjava3.e.k.j.f47736a
            if (r0 != r1) goto L_0x0098
            r8.onComplete()
            return
        L_0x0098:
            r8.onError(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.j.a.subscribeActual(io.reactivex.rxjava3.a.w):void");
    }

    public final void onSubscribe(c cVar) {
        if (this.f47791h.get() != null) {
            cVar.dispose();
        }
    }

    public final void onNext(T t) {
        j.a(t, "onNext called with a null value.");
        if (this.f47791h.get() == null) {
            Object next = m.next(t);
            b(next);
            for (C0828a a2 : (C0828a[]) this.f47787b.get()) {
                a2.a(next, this.f47792i);
            }
        }
    }

    public final void onError(Throwable th) {
        j.a(th, "onError called with a null Throwable.");
        if (!this.f47791h.compareAndSet((Object) null, th)) {
            io.reactivex.rxjava3.h.a.a(th);
            return;
        }
        Object error = m.error(th);
        for (C0828a a2 : a(error)) {
            a2.a(error, this.f47792i);
        }
    }

    public final void onComplete() {
        if (this.f47791h.compareAndSet((Object) null, j.f47736a)) {
            Object complete = m.complete();
            for (C0828a a2 : a(complete)) {
                a2.a(complete, this.f47792i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(C0828a<T> aVar) {
        C0828a<T>[] aVarArr;
        C0828a[] aVarArr2;
        do {
            aVarArr = (C0828a[]) this.f47787b.get();
            int length = aVarArr.length;
            if (length != 0) {
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (aVarArr[i3] == aVar) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        aVarArr2 = f47784c;
                    } else {
                        C0828a[] aVarArr3 = new C0828a[(length - 1)];
                        System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                        System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                        aVarArr2 = aVarArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f47787b.compareAndSet(aVarArr, aVarArr2));
    }

    private C0828a<T>[] a(Object obj) {
        b(obj);
        return (C0828a[]) this.f47787b.getAndSet(f47785d);
    }

    private void b(Object obj) {
        this.f47790g.lock();
        this.f47792i++;
        this.f47786a.lazySet(obj);
        this.f47790g.unlock();
    }

    /* renamed from: io.reactivex.rxjava3.j.a$a  reason: collision with other inner class name */
    static final class C0828a<T> implements c, a.C0826a<Object> {

        /* renamed from: a  reason: collision with root package name */
        final w<? super T> f47793a;

        /* renamed from: b  reason: collision with root package name */
        final a<T> f47794b;

        /* renamed from: c  reason: collision with root package name */
        boolean f47795c;

        /* renamed from: d  reason: collision with root package name */
        boolean f47796d;

        /* renamed from: e  reason: collision with root package name */
        io.reactivex.rxjava3.e.k.a<Object> f47797e;

        /* renamed from: f  reason: collision with root package name */
        boolean f47798f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f47799g;

        /* renamed from: h  reason: collision with root package name */
        long f47800h;

        C0828a(w<? super T> wVar, a<T> aVar) {
            this.f47793a = wVar;
            this.f47794b = aVar;
        }

        public final void dispose() {
            if (!this.f47799g) {
                this.f47799g = true;
                this.f47794b.a(this);
            }
        }

        public final boolean isDisposed() {
            return this.f47799g;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0030, code lost:
            r3.f47798f = true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(java.lang.Object r4, long r5) {
            /*
                r3 = this;
                boolean r0 = r3.f47799g
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                boolean r0 = r3.f47798f
                if (r0 != 0) goto L_0x0036
                monitor-enter(r3)
                boolean r0 = r3.f47799g     // Catch:{ all -> 0x0033 }
                if (r0 == 0) goto L_0x0010
                monitor-exit(r3)     // Catch:{ all -> 0x0033 }
                return
            L_0x0010:
                long r0 = r3.f47800h     // Catch:{ all -> 0x0033 }
                int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
                if (r2 != 0) goto L_0x0018
                monitor-exit(r3)     // Catch:{ all -> 0x0033 }
                return
            L_0x0018:
                boolean r5 = r3.f47796d     // Catch:{ all -> 0x0033 }
                if (r5 == 0) goto L_0x002c
                io.reactivex.rxjava3.e.k.a<java.lang.Object> r5 = r3.f47797e     // Catch:{ all -> 0x0033 }
                if (r5 != 0) goto L_0x0027
                io.reactivex.rxjava3.e.k.a r5 = new io.reactivex.rxjava3.e.k.a     // Catch:{ all -> 0x0033 }
                r5.<init>()     // Catch:{ all -> 0x0033 }
                r3.f47797e = r5     // Catch:{ all -> 0x0033 }
            L_0x0027:
                r5.a(r4)     // Catch:{ all -> 0x0033 }
                monitor-exit(r3)     // Catch:{ all -> 0x0033 }
                return
            L_0x002c:
                r5 = 1
                r3.f47795c = r5     // Catch:{ all -> 0x0033 }
                monitor-exit(r3)     // Catch:{ all -> 0x0033 }
                r3.f47798f = r5
                goto L_0x0036
            L_0x0033:
                r4 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0033 }
                throw r4
            L_0x0036:
                r3.test(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.j.a.C0828a.a(java.lang.Object, long):void");
        }

        public final boolean test(Object obj) {
            return this.f47799g || m.accept(obj, this.f47793a);
        }
    }
}
