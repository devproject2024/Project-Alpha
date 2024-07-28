package androidx.work.impl.utils.a;

import com.paytm.android.chat.bean.jsonbean.TxNotifyData;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class a<V> implements com.google.b.a.a.a<V> {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f5406a = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: b  reason: collision with root package name */
    static final C0078a f5407b;

    /* renamed from: f  reason: collision with root package name */
    private static final Logger f5408f;

    /* renamed from: g  reason: collision with root package name */
    private static final Object f5409g = new Object();

    /* renamed from: c  reason: collision with root package name */
    volatile Object f5410c;

    /* renamed from: d  reason: collision with root package name */
    volatile d f5411d;

    /* renamed from: e  reason: collision with root package name */
    volatile h f5412e;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: androidx.work.impl.utils.a.a$e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: androidx.work.impl.utils.a.a$g} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: androidx.work.impl.utils.a.a$e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: androidx.work.impl.utils.a.a$e} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.String r0 = "c"
            java.lang.Class<androidx.work.impl.utils.a.a> r1 = androidx.work.impl.utils.a.a.class
            java.lang.String r2 = "guava.concurrent.generate_cancellation_cause"
            java.lang.String r3 = "false"
            java.lang.String r2 = java.lang.System.getProperty(r2, r3)
            boolean r2 = java.lang.Boolean.parseBoolean(r2)
            f5406a = r2
            java.lang.String r2 = r1.getName()
            java.util.logging.Logger r2 = java.util.logging.Logger.getLogger(r2)
            f5408f = r2
            androidx.work.impl.utils.a.a$e r2 = new androidx.work.impl.utils.a.a$e     // Catch:{ all -> 0x004c }
            java.lang.Class<androidx.work.impl.utils.a.a$h> r3 = androidx.work.impl.utils.a.a.h.class
            java.lang.Class<java.lang.Thread> r4 = java.lang.Thread.class
            java.lang.String r5 = "b"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r3, r4, r5)     // Catch:{ all -> 0x004c }
            java.lang.Class<androidx.work.impl.utils.a.a$h> r3 = androidx.work.impl.utils.a.a.h.class
            java.lang.Class<androidx.work.impl.utils.a.a$h> r5 = androidx.work.impl.utils.a.a.h.class
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r3, r5, r0)     // Catch:{ all -> 0x004c }
            java.lang.Class<androidx.work.impl.utils.a.a$h> r3 = androidx.work.impl.utils.a.a.h.class
            java.lang.String r6 = "e"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r3, r6)     // Catch:{ all -> 0x004c }
            java.lang.Class<androidx.work.impl.utils.a.a$d> r3 = androidx.work.impl.utils.a.a.d.class
            java.lang.String r7 = "d"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r3, r7)     // Catch:{ all -> 0x004c }
            java.lang.Class<java.lang.Object> r3 = java.lang.Object.class
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r8 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r3, r0)     // Catch:{ all -> 0x004c }
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x004c }
            r0 = 0
            goto L_0x0052
        L_0x004c:
            r0 = move-exception
            androidx.work.impl.utils.a.a$g r2 = new androidx.work.impl.utils.a.a$g
            r2.<init>()
        L_0x0052:
            f5407b = r2
            java.lang.Class<java.util.concurrent.locks.LockSupport> r1 = java.util.concurrent.locks.LockSupport.class
            if (r0 == 0) goto L_0x0061
            java.util.logging.Logger r1 = f5408f
            java.util.logging.Level r2 = java.util.logging.Level.SEVERE
            java.lang.String r3 = "SafeAtomicHelper is broken!"
            r1.log(r2, r3, r0)
        L_0x0061:
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            f5409g = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.a.a.<clinit>():void");
    }

    static final class h {

        /* renamed from: a  reason: collision with root package name */
        static final h f5430a = new h();

        /* renamed from: b  reason: collision with root package name */
        volatile Thread f5431b;

        /* renamed from: c  reason: collision with root package name */
        volatile h f5432c;

        h() {
        }

        h(byte b2) {
            a.f5407b.a(this, Thread.currentThread());
        }

        /* access modifiers changed from: package-private */
        public final void a(h hVar) {
            a.f5407b.a(this, hVar);
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            Thread thread = this.f5431b;
            if (thread != null) {
                this.f5431b = null;
                LockSupport.unpark(thread);
            }
        }
    }

    private void a(h hVar) {
        hVar.f5431b = null;
        while (true) {
            h hVar2 = this.f5412e;
            if (hVar2 != h.f5430a) {
                h hVar3 = null;
                while (hVar2 != null) {
                    h hVar4 = hVar2.f5432c;
                    if (hVar2.f5431b != null) {
                        hVar3 = hVar2;
                    } else if (hVar3 != null) {
                        hVar3.f5432c = hVar4;
                        if (hVar3.f5431b == null) {
                        }
                    } else if (f5407b.a((a<?>) this, hVar2, hVar4)) {
                    }
                    hVar2 = hVar4;
                }
                return;
            }
            return;
        }
    }

    static final class d {

        /* renamed from: a  reason: collision with root package name */
        static final d f5419a = new d((Runnable) null, (Executor) null);

        /* renamed from: b  reason: collision with root package name */
        final Runnable f5420b;

        /* renamed from: c  reason: collision with root package name */
        final Executor f5421c;

        /* renamed from: d  reason: collision with root package name */
        d f5422d;

        d(Runnable runnable, Executor executor) {
            this.f5420b = runnable;
            this.f5421c = executor;
        }
    }

    static final class c {

        /* renamed from: a  reason: collision with root package name */
        static final c f5417a = new c(new Throwable("Failure occurred while trying to finish a future.") {
            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* renamed from: b  reason: collision with root package name */
        final Throwable f5418b;

        c(Throwable th) {
            this.f5418b = (Throwable) a.b(th);
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        static final b f5413a;

        /* renamed from: b  reason: collision with root package name */
        static final b f5414b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f5415c;

        /* renamed from: d  reason: collision with root package name */
        final Throwable f5416d;

        static {
            if (a.f5406a) {
                f5414b = null;
                f5413a = null;
                return;
            }
            f5414b = new b(false, (Throwable) null);
            f5413a = new b(true, (Throwable) null);
        }

        b(boolean z, Throwable th) {
            this.f5415c = z;
            this.f5416d = th;
        }
    }

    static final class f<V> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final a<V> f5428a;

        /* renamed from: b  reason: collision with root package name */
        final com.google.b.a.a.a<? extends V> f5429b;

        f(a<V> aVar, com.google.b.a.a.a<? extends V> aVar2) {
            this.f5428a = aVar;
            this.f5429b = aVar2;
        }

        public final void run() {
            if (this.f5428a.f5410c == this) {
                if (a.f5407b.a((a<?>) this.f5428a, (Object) this, a.b((com.google.b.a.a.a<?>) this.f5429b))) {
                    a.a((a<?>) this.f5428a);
                }
            }
        }
    }

    protected a() {
    }

    public final V get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long j2 = j;
        TimeUnit timeUnit2 = timeUnit;
        long nanos = timeUnit2.toNanos(j2);
        if (!Thread.interrupted()) {
            Object obj = this.f5410c;
            if ((obj != null) && (!(obj instanceof f))) {
                return c(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                h hVar = this.f5412e;
                if (hVar != h.f5430a) {
                    h hVar2 = new h((byte) 0);
                    while (true) {
                        hVar2.a(hVar);
                        if (f5407b.a((a<?>) this, hVar, hVar2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f5410c;
                                    if ((obj2 != null) && (!(obj2 instanceof f))) {
                                        return c(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    a(hVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            a(hVar2);
                        } else {
                            hVar = this.f5412e;
                            if (hVar == h.f5430a) {
                                break;
                            }
                        }
                    }
                }
                return c(this.f5410c);
            }
            while (nanos > 0) {
                Object obj3 = this.f5410c;
                if ((obj3 != null) && (!(obj3 instanceof f))) {
                    return c(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String aVar = toString();
            String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
            String str = "Waited " + j2 + " " + timeUnit.toString().toLowerCase(Locale.ROOT);
            if (nanos + 1000 < 0) {
                String str2 = str + " (plus ";
                long j3 = -nanos;
                long convert = timeUnit2.convert(j3, TimeUnit.NANOSECONDS);
                long nanos2 = j3 - timeUnit2.toNanos(convert);
                int i2 = (convert > 0 ? 1 : (convert == 0 ? 0 : -1));
                boolean z = i2 == 0 || nanos2 > 1000;
                if (i2 > 0) {
                    String str3 = str2 + convert + " " + lowerCase;
                    if (z) {
                        str3 = str3 + AppConstants.COMMA;
                    }
                    str2 = str3 + " ";
                }
                if (z) {
                    str2 = str2 + nanos2 + " nanoseconds ";
                }
                str = str2 + "delay)";
            }
            if (isDone()) {
                throw new TimeoutException(str + " but future completed as timeout expired");
            }
            throw new TimeoutException(str + " for " + aVar);
        }
        throw new InterruptedException();
    }

    public final V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f5410c;
            if ((obj2 != null) && (!(obj2 instanceof f))) {
                return c(obj2);
            }
            h hVar = this.f5412e;
            if (hVar != h.f5430a) {
                h hVar2 = new h((byte) 0);
                do {
                    hVar2.a(hVar);
                    if (f5407b.a((a<?>) this, hVar, hVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f5410c;
                            } else {
                                a(hVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof f))));
                        return c(obj);
                    }
                    hVar = this.f5412e;
                } while (hVar != h.f5430a);
            }
            return c(this.f5410c);
        }
        throw new InterruptedException();
    }

    private static V c(Object obj) throws ExecutionException {
        if (obj instanceof b) {
            throw a("Task was cancelled.", ((b) obj).f5416d);
        } else if (obj instanceof c) {
            throw new ExecutionException(((c) obj).f5418b);
        } else if (obj == f5409g) {
            return null;
        } else {
            return obj;
        }
    }

    public final boolean isDone() {
        Object obj = this.f5410c;
        return (!(obj instanceof f)) & (obj != null);
    }

    public final boolean isCancelled() {
        return this.f5410c instanceof b;
    }

    public final boolean cancel(boolean z) {
        b bVar;
        Object obj = this.f5410c;
        if (!(obj == null) && !(obj instanceof f)) {
            return false;
        }
        if (f5406a) {
            bVar = new b(z, new CancellationException("Future.cancel() was called."));
        } else if (z) {
            bVar = b.f5413a;
        } else {
            bVar = b.f5414b;
        }
        boolean z2 = false;
        Object obj2 = obj;
        a aVar = this;
        while (true) {
            if (f5407b.a((a<?>) aVar, obj2, (Object) bVar)) {
                a((a<?>) aVar);
                if (!(obj2 instanceof f)) {
                    return true;
                }
                com.google.b.a.a.a<? extends V> aVar2 = ((f) obj2).f5429b;
                if (aVar2 instanceof a) {
                    aVar = (a) aVar2;
                    obj2 = aVar.f5410c;
                    if (!(obj2 == null) && !(obj2 instanceof f)) {
                        return true;
                    }
                    z2 = true;
                } else {
                    aVar2.cancel(z);
                    return true;
                }
            } else {
                obj2 = aVar.f5410c;
                if (!(obj2 instanceof f)) {
                    return z2;
                }
            }
        }
    }

    public final void a(Runnable runnable, Executor executor) {
        b(runnable);
        b(executor);
        d dVar = this.f5411d;
        if (dVar != d.f5419a) {
            d dVar2 = new d(runnable, executor);
            do {
                dVar2.f5422d = dVar;
                if (!f5407b.a((a<?>) this, dVar, dVar2)) {
                    dVar = this.f5411d;
                } else {
                    return;
                }
            } while (dVar != d.f5419a);
        }
        b(runnable, executor);
    }

    /* access modifiers changed from: protected */
    public boolean a(V v) {
        if (v == null) {
            v = f5409g;
        }
        if (!f5407b.a((a<?>) this, (Object) null, (Object) v)) {
            return false;
        }
        a((a<?>) this);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean a(Throwable th) {
        if (!f5407b.a((a<?>) this, (Object) null, (Object) new c((Throwable) b(th)))) {
            return false;
        }
        a((a<?>) this);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean a(com.google.b.a.a.a<? extends V> aVar) {
        f fVar;
        c cVar;
        b(aVar);
        Object obj = this.f5410c;
        if (obj == null) {
            if (aVar.isDone()) {
                if (!f5407b.a((a<?>) this, (Object) null, b((com.google.b.a.a.a<?>) aVar))) {
                    return false;
                }
                a((a<?>) this);
                return true;
            }
            fVar = new f(this, aVar);
            if (f5407b.a((a<?>) this, (Object) null, (Object) fVar)) {
                try {
                    aVar.a(fVar, b.INSTANCE);
                } catch (Throwable unused) {
                    cVar = c.f5417a;
                }
                return true;
            }
            obj = this.f5410c;
        }
        if (obj instanceof b) {
            aVar.cancel(((b) obj).f5415c);
        }
        return false;
        f5407b.a((a<?>) this, (Object) fVar, (Object) cVar);
        return true;
    }

    static Object b(com.google.b.a.a.a<?> aVar) {
        if (aVar instanceof a) {
            Object obj = ((a) aVar).f5410c;
            if (!(obj instanceof b)) {
                return obj;
            }
            b bVar = (b) obj;
            if (!bVar.f5415c) {
                return obj;
            }
            if (bVar.f5416d != null) {
                return new b(false, bVar.f5416d);
            }
            return b.f5414b;
        }
        boolean isCancelled = aVar.isCancelled();
        if ((!f5406a) && isCancelled) {
            return b.f5414b;
        }
        try {
            Object a2 = a(aVar);
            if (a2 == null) {
                return f5409g;
            }
            return a2;
        } catch (ExecutionException e2) {
            return new c(e2.getCause());
        } catch (CancellationException e3) {
            if (!isCancelled) {
                return new c(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(aVar)), e3));
            }
            return new b(false, e3);
        } catch (Throwable th) {
            return new c(th);
        }
    }

    private static <V> V a(Future<V> future) throws ExecutionException {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    static void a(a<?> aVar) {
        d dVar = null;
        a<V> aVar2 = aVar;
        while (true) {
            aVar2.a();
            d a2 = aVar2.a(dVar);
            while (true) {
                if (a2 != null) {
                    dVar = a2.f5422d;
                    Runnable runnable = a2.f5420b;
                    if (runnable instanceof f) {
                        f fVar = (f) runnable;
                        a<V> aVar3 = fVar.f5428a;
                        if (aVar3.f5410c == fVar) {
                            if (f5407b.a((a<?>) aVar3, (Object) fVar, b((com.google.b.a.a.a<?>) fVar.f5429b))) {
                                aVar2 = aVar3;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        b(runnable, a2.f5421c);
                    }
                    a2 = dVar;
                } else {
                    return;
                }
            }
        }
    }

    private void a() {
        h hVar;
        do {
            hVar = this.f5412e;
        } while (!f5407b.a((a<?>) this, hVar, h.f5430a));
        while (hVar != null) {
            hVar.a();
            hVar = hVar.f5432c;
        }
    }

    private d a(d dVar) {
        d dVar2;
        do {
            dVar2 = this.f5411d;
        } while (!f5407b.a((a<?>) this, dVar2, d.f5419a));
        d dVar3 = dVar2;
        d dVar4 = dVar;
        d dVar5 = dVar3;
        while (dVar5 != null) {
            d dVar6 = dVar5.f5422d;
            dVar5.f5422d = dVar4;
            dVar4 = dVar5;
            dVar5 = dVar6;
        }
        return dVar4;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append(TxNotifyData.UPI_STATUS_CANCELLED);
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                Object obj = this.f5410c;
                if (obj instanceof f) {
                    str = "setFuture=[" + d(((f) obj).f5429b) + "]";
                } else if (this instanceof ScheduledFuture) {
                    str = "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
                } else {
                    str = null;
                }
            } catch (RuntimeException e2) {
                str = "Exception thrown from implementation: " + e2.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append("]");
            } else if (isDone()) {
                a(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void a(StringBuilder sb) {
        try {
            Object a2 = a(this);
            sb.append("SUCCESS, result=[");
            sb.append(d(a2));
            sb.append("]");
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append(TxNotifyData.UPI_STATUS_CANCELLED);
        } catch (RuntimeException e3) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e3.getClass());
            sb.append(" thrown from get()]");
        }
    }

    private String d(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    private static void b(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = f5408f;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e2);
        }
    }

    /* renamed from: androidx.work.impl.utils.a.a$a  reason: collision with other inner class name */
    static abstract class C0078a {
        /* access modifiers changed from: package-private */
        public abstract void a(h hVar, h hVar2);

        /* access modifiers changed from: package-private */
        public abstract void a(h hVar, Thread thread);

        /* access modifiers changed from: package-private */
        public abstract boolean a(a<?> aVar, d dVar, d dVar2);

        /* access modifiers changed from: package-private */
        public abstract boolean a(a<?> aVar, h hVar, h hVar2);

        /* access modifiers changed from: package-private */
        public abstract boolean a(a<?> aVar, Object obj, Object obj2);

        private C0078a() {
        }

        /* synthetic */ C0078a(byte b2) {
            this();
        }
    }

    static final class e extends C0078a {

        /* renamed from: a  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<h, Thread> f5423a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<h, h> f5424b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, h> f5425c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, d> f5426d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, Object> f5427e;

        e(AtomicReferenceFieldUpdater<h, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<h, h> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<a, h> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<a, d> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<a, Object> atomicReferenceFieldUpdater5) {
            super((byte) 0);
            this.f5423a = atomicReferenceFieldUpdater;
            this.f5424b = atomicReferenceFieldUpdater2;
            this.f5425c = atomicReferenceFieldUpdater3;
            this.f5426d = atomicReferenceFieldUpdater4;
            this.f5427e = atomicReferenceFieldUpdater5;
        }

        /* access modifiers changed from: package-private */
        public final void a(h hVar, Thread thread) {
            this.f5423a.lazySet(hVar, thread);
        }

        /* access modifiers changed from: package-private */
        public final void a(h hVar, h hVar2) {
            this.f5424b.lazySet(hVar, hVar2);
        }

        /* access modifiers changed from: package-private */
        public final boolean a(a<?> aVar, h hVar, h hVar2) {
            return this.f5425c.compareAndSet(aVar, hVar, hVar2);
        }

        /* access modifiers changed from: package-private */
        public final boolean a(a<?> aVar, d dVar, d dVar2) {
            return this.f5426d.compareAndSet(aVar, dVar, dVar2);
        }

        /* access modifiers changed from: package-private */
        public final boolean a(a<?> aVar, Object obj, Object obj2) {
            return this.f5427e.compareAndSet(aVar, obj, obj2);
        }
    }

    static final class g extends C0078a {
        g() {
            super((byte) 0);
        }

        /* access modifiers changed from: package-private */
        public final void a(h hVar, Thread thread) {
            hVar.f5431b = thread;
        }

        /* access modifiers changed from: package-private */
        public final void a(h hVar, h hVar2) {
            hVar.f5432c = hVar2;
        }

        /* access modifiers changed from: package-private */
        public final boolean a(a<?> aVar, h hVar, h hVar2) {
            synchronized (aVar) {
                if (aVar.f5412e != hVar) {
                    return false;
                }
                aVar.f5412e = hVar2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean a(a<?> aVar, d dVar, d dVar2) {
            synchronized (aVar) {
                if (aVar.f5411d != dVar) {
                    return false;
                }
                aVar.f5411d = dVar2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean a(a<?> aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                if (aVar.f5410c != obj) {
                    return false;
                }
                aVar.f5410c = obj2;
                return true;
            }
        }
    }

    private static CancellationException a(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    static <T> T b(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }
}
