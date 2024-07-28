package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.d.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class cv<T> extends io.reactivex.rxjava3.f.a<T> {

    /* renamed from: e  reason: collision with root package name */
    static final b f47211e = new n();

    /* renamed from: a  reason: collision with root package name */
    final u<T> f47212a;

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<i<T>> f47213b;

    /* renamed from: c  reason: collision with root package name */
    final b<T> f47214c;

    /* renamed from: d  reason: collision with root package name */
    final u<T> f47215d;

    interface b<T> {
        g<T> a();
    }

    interface g<T> {
        void complete();

        void error(Throwable th);

        void next(T t);

        void replay(d<T> dVar);
    }

    public static <U, R> p<R> a(r<? extends io.reactivex.rxjava3.f.a<U>> rVar, io.reactivex.rxjava3.d.h<? super p<U>, ? extends u<R>> hVar) {
        return io.reactivex.rxjava3.h.a.a(new e(rVar, hVar));
    }

    public static <T> io.reactivex.rxjava3.f.a<T> a(u<? extends T> uVar) {
        return a(uVar, f47211e);
    }

    public static <T> io.reactivex.rxjava3.f.a<T> a(u<T> uVar, long j2, TimeUnit timeUnit, x xVar, boolean z) {
        return a(uVar, j2, timeUnit, xVar, Integer.MAX_VALUE, z);
    }

    public static <T> io.reactivex.rxjava3.f.a<T> a(u<T> uVar, long j2, TimeUnit timeUnit, x xVar, int i2, boolean z) {
        return a(uVar, new k(i2, j2, timeUnit, xVar, z));
    }

    private static <T> io.reactivex.rxjava3.f.a<T> a(u<T> uVar, b<T> bVar) {
        AtomicReference atomicReference = new AtomicReference();
        return io.reactivex.rxjava3.h.a.a(new cv(new j(atomicReference, bVar), uVar, atomicReference, bVar));
    }

    private cv(u<T> uVar, u<T> uVar2, AtomicReference<i<T>> atomicReference, b<T> bVar) {
        this.f47215d = uVar;
        this.f47212a = uVar2;
        this.f47213b = atomicReference;
        this.f47214c = bVar;
    }

    public final void a() {
        i iVar = this.f47213b.get();
        if (iVar != null && iVar.isDisposed()) {
            this.f47213b.compareAndSet(iVar, (Object) null);
        }
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f47215d.subscribe(wVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(io.reactivex.rxjava3.d.g<? super io.reactivex.rxjava3.b.c> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.e.f.e.cv$i<T>> r0 = r4.f47213b
            java.lang.Object r0 = r0.get()
            io.reactivex.rxjava3.e.f.e.cv$i r0 = (io.reactivex.rxjava3.e.f.e.cv.i) r0
            if (r0 == 0) goto L_0x0010
            boolean r1 = r0.isDisposed()
            if (r1 == 0) goto L_0x0026
        L_0x0010:
            io.reactivex.rxjava3.e.f.e.cv$b<T> r1 = r4.f47214c
            io.reactivex.rxjava3.e.f.e.cv$g r1 = r1.a()
            io.reactivex.rxjava3.e.f.e.cv$i r2 = new io.reactivex.rxjava3.e.f.e.cv$i
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.e.f.e.cv$i<T>> r3 = r4.f47213b
            r2.<init>(r1, r3)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.e.f.e.cv$i<T>> r1 = r4.f47213b
            boolean r0 = r1.compareAndSet(r0, r2)
            if (r0 == 0) goto L_0x0000
            r0 = r2
        L_0x0026:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.shouldConnect
            boolean r1 = r1.get()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x003a
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.shouldConnect
            boolean r1 = r1.compareAndSet(r3, r2)
            if (r1 == 0) goto L_0x003a
            r1 = 1
            goto L_0x003b
        L_0x003a:
            r1 = 0
        L_0x003b:
            r5.accept(r0)     // Catch:{ all -> 0x0046 }
            if (r1 == 0) goto L_0x0045
            io.reactivex.rxjava3.a.u<T> r5 = r4.f47212a
            r5.subscribe(r0)
        L_0x0045:
            return
        L_0x0046:
            r5 = move-exception
            io.reactivex.rxjava3.c.b.b(r5)
            if (r1 == 0) goto L_0x0051
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.shouldConnect
            r0.compareAndSet(r2, r3)
        L_0x0051:
            io.reactivex.rxjava3.c.b.b(r5)
            java.lang.RuntimeException r5 = io.reactivex.rxjava3.e.k.j.a((java.lang.Throwable) r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.e.f.e.cv.a(io.reactivex.rxjava3.d.g):void");
    }

    static final class i<T> extends AtomicReference<io.reactivex.rxjava3.b.c> implements w<T>, io.reactivex.rxjava3.b.c {
        static final d[] EMPTY = new d[0];
        static final d[] TERMINATED = new d[0];
        private static final long serialVersionUID = -533785617179540163L;
        final g<T> buffer;
        final AtomicReference<i<T>> current;
        boolean done;
        final AtomicReference<d[]> observers = new AtomicReference<>(EMPTY);
        final AtomicBoolean shouldConnect = new AtomicBoolean();

        i(g<T> gVar, AtomicReference<i<T>> atomicReference) {
            this.buffer = gVar;
            this.current = atomicReference;
        }

        public final boolean isDisposed() {
            return this.observers.get() == TERMINATED;
        }

        public final void dispose() {
            this.observers.set(TERMINATED);
            this.current.compareAndSet(this, (Object) null);
            io.reactivex.rxjava3.e.a.c.dispose(this);
        }

        /* access modifiers changed from: package-private */
        public final boolean add(d<T> dVar) {
            d[] dVarArr;
            d[] dVarArr2;
            do {
                dVarArr = this.observers.get();
                if (dVarArr == TERMINATED) {
                    return false;
                }
                int length = dVarArr.length;
                dVarArr2 = new d[(length + 1)];
                System.arraycopy(dVarArr, 0, dVarArr2, 0, length);
                dVarArr2[length] = dVar;
            } while (!this.observers.compareAndSet(dVarArr, dVarArr2));
            return true;
        }

        /* access modifiers changed from: package-private */
        public final void remove(d<T> dVar) {
            d[] dVarArr;
            d[] dVarArr2;
            do {
                dVarArr = this.observers.get();
                int length = dVarArr.length;
                if (length != 0) {
                    int i2 = -1;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        } else if (dVarArr[i3].equals(dVar)) {
                            i2 = i3;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (i2 >= 0) {
                        if (length == 1) {
                            dVarArr2 = EMPTY;
                        } else {
                            d[] dVarArr3 = new d[(length - 1)];
                            System.arraycopy(dVarArr, 0, dVarArr3, 0, i2);
                            System.arraycopy(dVarArr, i2 + 1, dVarArr3, i2, (length - i2) - 1);
                            dVarArr2 = dVarArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.observers.compareAndSet(dVarArr, dVarArr2));
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            if (io.reactivex.rxjava3.e.a.c.setOnce(this, cVar)) {
                replay();
            }
        }

        public final void onNext(T t) {
            if (!this.done) {
                this.buffer.next(t);
                replay();
            }
        }

        public final void onError(Throwable th) {
            if (!this.done) {
                this.done = true;
                this.buffer.error(th);
                replayFinal();
                return;
            }
            io.reactivex.rxjava3.h.a.a(th);
        }

        public final void onComplete() {
            if (!this.done) {
                this.done = true;
                this.buffer.complete();
                replayFinal();
            }
        }

        /* access modifiers changed from: package-private */
        public final void replay() {
            for (d replay : this.observers.get()) {
                this.buffer.replay(replay);
            }
        }

        /* access modifiers changed from: package-private */
        public final void replayFinal() {
            for (d replay : this.observers.getAndSet(TERMINATED)) {
                this.buffer.replay(replay);
            }
        }
    }

    static final class d<T> extends AtomicInteger implements io.reactivex.rxjava3.b.c {
        private static final long serialVersionUID = 2728361546769921047L;
        volatile boolean cancelled;
        final w<? super T> child;
        Object index;
        final i<T> parent;

        d(i<T> iVar, w<? super T> wVar) {
            this.parent = iVar;
            this.child = wVar;
        }

        public final boolean isDisposed() {
            return this.cancelled;
        }

        public final void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.parent.remove(this);
                this.index = null;
            }
        }

        /* access modifiers changed from: package-private */
        public final <U> U index() {
            return this.index;
        }
    }

    static final class o<T> extends ArrayList<Object> implements g<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;

        o(int i2) {
            super(i2);
        }

        public final void next(T t) {
            add(io.reactivex.rxjava3.e.k.m.next(t));
            this.size++;
        }

        public final void error(Throwable th) {
            add(io.reactivex.rxjava3.e.k.m.error(th));
            this.size++;
        }

        public final void complete() {
            add(io.reactivex.rxjava3.e.k.m.complete());
            this.size++;
        }

        public final void replay(d<T> dVar) {
            if (dVar.getAndIncrement() == 0) {
                w<? super T> wVar = dVar.child;
                int i2 = 1;
                while (!dVar.isDisposed()) {
                    int i3 = this.size;
                    Integer num = (Integer) dVar.index();
                    int intValue = num != null ? num.intValue() : 0;
                    while (intValue < i3) {
                        if (!io.reactivex.rxjava3.e.k.m.accept(get(intValue), wVar) && !dVar.isDisposed()) {
                            intValue++;
                        } else {
                            return;
                        }
                    }
                    dVar.index = Integer.valueOf(intValue);
                    i2 = dVar.addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }
    }

    static final class f extends AtomicReference<f> {
        private static final long serialVersionUID = 245354315435971818L;
        final Object value;

        f(Object obj) {
            this.value = obj;
        }
    }

    static abstract class a<T> extends AtomicReference<f> implements g<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        final boolean eagerTruncate;
        int size;
        f tail;

        /* access modifiers changed from: package-private */
        public Object enterTransform(Object obj) {
            return obj;
        }

        /* access modifiers changed from: package-private */
        public Object leaveTransform(Object obj) {
            return obj;
        }

        /* access modifiers changed from: package-private */
        public abstract void truncate();

        a(boolean z) {
            this.eagerTruncate = z;
            f fVar = new f((Object) null);
            this.tail = fVar;
            set(fVar);
        }

        /* access modifiers changed from: package-private */
        public final void addLast(f fVar) {
            this.tail.set(fVar);
            this.tail = fVar;
            this.size++;
        }

        /* access modifiers changed from: package-private */
        public final void removeFirst() {
            this.size--;
            setFirst((f) ((f) get()).get());
        }

        /* access modifiers changed from: package-private */
        public final void trimHead() {
            f fVar = (f) get();
            if (fVar.value != null) {
                f fVar2 = new f((Object) null);
                fVar2.lazySet(fVar.get());
                set(fVar2);
            }
        }

        /* access modifiers changed from: package-private */
        public final void removeSome(int i2) {
            f fVar = (f) get();
            while (i2 > 0) {
                fVar = (f) fVar.get();
                i2--;
                this.size--;
            }
            setFirst(fVar);
            f fVar2 = (f) get();
            if (fVar2.get() == null) {
                this.tail = fVar2;
            }
        }

        /* access modifiers changed from: package-private */
        public final void setFirst(f fVar) {
            if (this.eagerTruncate) {
                f fVar2 = new f((Object) null);
                fVar2.lazySet(fVar.get());
                fVar = fVar2;
            }
            set(fVar);
        }

        public final void next(T t) {
            addLast(new f(enterTransform(io.reactivex.rxjava3.e.k.m.next(t))));
            truncate();
        }

        public final void error(Throwable th) {
            addLast(new f(enterTransform(io.reactivex.rxjava3.e.k.m.error(th))));
            truncateFinal();
        }

        public final void complete() {
            addLast(new f(enterTransform(io.reactivex.rxjava3.e.k.m.complete())));
            truncateFinal();
        }

        public final void replay(d<T> dVar) {
            if (dVar.getAndIncrement() == 0) {
                int i2 = 1;
                do {
                    f fVar = (f) dVar.index();
                    if (fVar == null) {
                        fVar = getHead();
                        dVar.index = fVar;
                    }
                    while (!dVar.isDisposed()) {
                        f fVar2 = (f) fVar.get();
                        if (fVar2 == null) {
                            dVar.index = fVar;
                            i2 = dVar.addAndGet(-i2);
                        } else if (io.reactivex.rxjava3.e.k.m.accept(leaveTransform(fVar2.value), dVar.child)) {
                            dVar.index = null;
                            return;
                        } else {
                            fVar = fVar2;
                        }
                    }
                    dVar.index = null;
                    return;
                } while (i2 != 0);
            }
        }

        /* access modifiers changed from: package-private */
        public void truncateFinal() {
            trimHead();
        }

        /* access modifiers changed from: package-private */
        public final void collect(Collection<? super T> collection) {
            f head = getHead();
            while (true) {
                head = (f) head.get();
                if (head != null) {
                    Object leaveTransform = leaveTransform(head.value);
                    if (!io.reactivex.rxjava3.e.k.m.isComplete(leaveTransform) && !io.reactivex.rxjava3.e.k.m.isError(leaveTransform)) {
                        collection.add(io.reactivex.rxjava3.e.k.m.getValue(leaveTransform));
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean hasError() {
            return this.tail.value != null && io.reactivex.rxjava3.e.k.m.isError(leaveTransform(this.tail.value));
        }

        /* access modifiers changed from: package-private */
        public boolean hasCompleted() {
            return this.tail.value != null && io.reactivex.rxjava3.e.k.m.isComplete(leaveTransform(this.tail.value));
        }

        /* access modifiers changed from: package-private */
        public f getHead() {
            return (f) get();
        }
    }

    static final class m<T> extends a<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        m(int i2, boolean z) {
            super(z);
            this.limit = i2;
        }

        /* access modifiers changed from: package-private */
        public final void truncate() {
            if (this.size > this.limit) {
                removeFirst();
            }
        }
    }

    static final class l<T> extends a<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        final int limit;
        final long maxAge;
        final x scheduler;
        final TimeUnit unit;

        l(int i2, long j, TimeUnit timeUnit, x xVar, boolean z) {
            super(z);
            this.scheduler = xVar;
            this.limit = i2;
            this.maxAge = j;
            this.unit = timeUnit;
        }

        /* access modifiers changed from: package-private */
        public final Object enterTransform(Object obj) {
            return new io.reactivex.rxjava3.i.b(obj, x.a(this.unit), this.unit);
        }

        /* access modifiers changed from: package-private */
        public final Object leaveTransform(Object obj) {
            return ((io.reactivex.rxjava3.i.b) obj).f47781a;
        }

        /* access modifiers changed from: package-private */
        public final void truncate() {
            f fVar;
            long a2 = x.a(this.unit) - this.maxAge;
            f fVar2 = (f) get();
            f fVar3 = (f) fVar2.get();
            int i2 = 0;
            while (true) {
                f fVar4 = fVar3;
                fVar = fVar2;
                fVar2 = fVar4;
                if (this.size > 1) {
                    if (this.size <= this.limit) {
                        if (((io.reactivex.rxjava3.i.b) fVar2.value).f47782b > a2) {
                            break;
                        }
                        i2++;
                        this.size--;
                        fVar3 = (f) fVar2.get();
                    } else {
                        i2++;
                        this.size--;
                        fVar3 = (f) fVar2.get();
                    }
                } else {
                    break;
                }
            }
            if (i2 != 0) {
                setFirst(fVar);
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x0038  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void truncateFinal() {
            /*
                r10 = this;
                java.util.concurrent.TimeUnit r0 = r10.unit
                long r0 = io.reactivex.rxjava3.a.x.a((java.util.concurrent.TimeUnit) r0)
                long r2 = r10.maxAge
                long r0 = r0 - r2
                java.lang.Object r2 = r10.get()
                io.reactivex.rxjava3.e.f.e.cv$f r2 = (io.reactivex.rxjava3.e.f.e.cv.f) r2
                java.lang.Object r3 = r2.get()
                io.reactivex.rxjava3.e.f.e.cv$f r3 = (io.reactivex.rxjava3.e.f.e.cv.f) r3
                r4 = 0
            L_0x0016:
                r9 = r3
                r3 = r2
                r2 = r9
                int r5 = r10.size
                r6 = 1
                if (r5 <= r6) goto L_0x0036
                java.lang.Object r5 = r2.value
                io.reactivex.rxjava3.i.b r5 = (io.reactivex.rxjava3.i.b) r5
                long r7 = r5.f47782b
                int r5 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r5 > 0) goto L_0x0036
                int r4 = r4 + 1
                int r3 = r10.size
                int r3 = r3 - r6
                r10.size = r3
                java.lang.Object r3 = r2.get()
                io.reactivex.rxjava3.e.f.e.cv$f r3 = (io.reactivex.rxjava3.e.f.e.cv.f) r3
                goto L_0x0016
            L_0x0036:
                if (r4 == 0) goto L_0x003b
                r10.setFirst(r3)
            L_0x003b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.e.f.e.cv.l.truncateFinal():void");
        }

        /* access modifiers changed from: package-private */
        public final f getHead() {
            f fVar;
            long a2 = x.a(this.unit) - this.maxAge;
            f fVar2 = (f) get();
            Object obj = fVar2.get();
            while (true) {
                f fVar3 = (f) obj;
                fVar = fVar2;
                fVar2 = fVar3;
                if (fVar2 == null) {
                    break;
                }
                io.reactivex.rxjava3.i.b bVar = (io.reactivex.rxjava3.i.b) fVar2.value;
                if (io.reactivex.rxjava3.e.k.m.isComplete(bVar.f47781a) || io.reactivex.rxjava3.e.k.m.isError(bVar.f47781a) || bVar.f47782b > a2) {
                    break;
                }
                obj = fVar2.get();
            }
            return fVar;
        }
    }

    static final class n implements b<Object> {
        n() {
        }

        public final g<Object> a() {
            return new o(16);
        }
    }

    static final class c<R> implements io.reactivex.rxjava3.d.g<io.reactivex.rxjava3.b.c> {

        /* renamed from: a  reason: collision with root package name */
        private final er<R> f47216a;

        public final /* synthetic */ void accept(Object obj) throws Throwable {
            this.f47216a.setResource((io.reactivex.rxjava3.b.c) obj);
        }

        c(er<R> erVar) {
            this.f47216a = erVar;
        }
    }

    static final class h<T> implements b<T> {

        /* renamed from: a  reason: collision with root package name */
        final int f47219a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f47220b;

        h(int i2, boolean z) {
            this.f47219a = i2;
            this.f47220b = z;
        }

        public final g<T> a() {
            return new m(this.f47219a, this.f47220b);
        }
    }

    static final class k<T> implements b<T> {

        /* renamed from: a  reason: collision with root package name */
        final boolean f47223a;

        /* renamed from: b  reason: collision with root package name */
        private final int f47224b;

        /* renamed from: c  reason: collision with root package name */
        private final long f47225c;

        /* renamed from: d  reason: collision with root package name */
        private final TimeUnit f47226d;

        /* renamed from: e  reason: collision with root package name */
        private final x f47227e;

        k(int i2, long j, TimeUnit timeUnit, x xVar, boolean z) {
            this.f47224b = i2;
            this.f47225c = j;
            this.f47226d = timeUnit;
            this.f47227e = xVar;
            this.f47223a = z;
        }

        public final g<T> a() {
            return new l(this.f47224b, this.f47225c, this.f47226d, this.f47227e, this.f47223a);
        }
    }

    static final class j<T> implements u<T> {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicReference<i<T>> f47221a;

        /* renamed from: b  reason: collision with root package name */
        private final b<T> f47222b;

        j(AtomicReference<i<T>> atomicReference, b<T> bVar) {
            this.f47221a = atomicReference;
            this.f47222b = bVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void subscribe(io.reactivex.rxjava3.a.w<? super T> r4) {
            /*
                r3 = this;
            L_0x0000:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.e.f.e.cv$i<T>> r0 = r3.f47221a
                java.lang.Object r0 = r0.get()
                io.reactivex.rxjava3.e.f.e.cv$i r0 = (io.reactivex.rxjava3.e.f.e.cv.i) r0
                if (r0 != 0) goto L_0x0021
                io.reactivex.rxjava3.e.f.e.cv$b<T> r0 = r3.f47222b
                io.reactivex.rxjava3.e.f.e.cv$g r0 = r0.a()
                io.reactivex.rxjava3.e.f.e.cv$i r1 = new io.reactivex.rxjava3.e.f.e.cv$i
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.e.f.e.cv$i<T>> r2 = r3.f47221a
                r1.<init>(r0, r2)
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.e.f.e.cv$i<T>> r0 = r3.f47221a
                r2 = 0
                boolean r0 = r0.compareAndSet(r2, r1)
                if (r0 == 0) goto L_0x0000
                r0 = r1
            L_0x0021:
                io.reactivex.rxjava3.e.f.e.cv$d r1 = new io.reactivex.rxjava3.e.f.e.cv$d
                r1.<init>(r0, r4)
                r4.onSubscribe(r1)
                r0.add(r1)
                boolean r4 = r1.isDisposed()
                if (r4 == 0) goto L_0x0036
                r0.remove(r1)
                return
            L_0x0036:
                io.reactivex.rxjava3.e.f.e.cv$g<T> r4 = r0.buffer
                r4.replay(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.e.f.e.cv.j.subscribe(io.reactivex.rxjava3.a.w):void");
        }
    }

    static final class e<R, U> extends p<R> {

        /* renamed from: a  reason: collision with root package name */
        private final r<? extends io.reactivex.rxjava3.f.a<U>> f47217a;

        /* renamed from: b  reason: collision with root package name */
        private final io.reactivex.rxjava3.d.h<? super p<U>, ? extends u<R>> f47218b;

        e(r<? extends io.reactivex.rxjava3.f.a<U>> rVar, io.reactivex.rxjava3.d.h<? super p<U>, ? extends u<R>> hVar) {
            this.f47217a = rVar;
            this.f47218b = hVar;
        }

        public final void subscribeActual(w<? super R> wVar) {
            try {
                io.reactivex.rxjava3.f.a aVar = (io.reactivex.rxjava3.f.a) Objects.requireNonNull(this.f47217a.get(), "The connectableFactory returned a null ConnectableObservable");
                u uVar = (u) Objects.requireNonNull(this.f47218b.apply(aVar), "The selector returned a null ObservableSource");
                er erVar = new er(wVar);
                uVar.subscribe(erVar);
                aVar.a(new c(erVar));
            } catch (Throwable th) {
                io.reactivex.rxjava3.c.b.b(th);
                io.reactivex.rxjava3.e.a.d.error(th, (w<?>) wVar);
            }
        }
    }

    public static <T> io.reactivex.rxjava3.f.a<T> a(u<T> uVar, int i2, boolean z) {
        return i2 == Integer.MAX_VALUE ? a(uVar, f47211e) : a(uVar, new h(i2, z));
    }
}
