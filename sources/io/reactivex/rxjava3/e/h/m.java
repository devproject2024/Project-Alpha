package io.reactivex.rxjava3.e.h;

import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.b.d;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class m extends AtomicReferenceArray<Object> implements c, Runnable, Callable<Object> {
    static final Object ASYNC_DISPOSED = new Object();
    static final Object DONE = new Object();
    static final int FUTURE_INDEX = 1;
    static final Object PARENT_DISPOSED = new Object();
    static final int PARENT_INDEX = 0;
    static final Object SYNC_DISPOSED = new Object();
    static final int THREAD_INDEX = 2;
    private static final long serialVersionUID = -6120223772001106981L;
    final Runnable actual;

    public m(Runnable runnable, d dVar) {
        super(3);
        this.actual = runnable;
        lazySet(0, dVar);
    }

    public final Object call() {
        run();
        return null;
    }

    public final void run() {
        Object obj;
        Object obj2;
        lazySet(2, Thread.currentThread());
        try {
            this.actual.run();
            lazySet(2, (Object) null);
            Object obj3 = get(0);
            if (!(obj3 == PARENT_DISPOSED || !compareAndSet(0, obj3, DONE) || obj3 == null)) {
                ((d) obj3).c(this);
            }
            do {
                obj2 = get(1);
                if (obj2 == SYNC_DISPOSED || obj2 == ASYNC_DISPOSED || compareAndSet(1, obj2, DONE)) {
                }
                obj2 = get(1);
                return;
            } while (compareAndSet(1, obj2, DONE));
        } catch (Throwable th) {
            lazySet(2, (Object) null);
            Object obj4 = get(0);
            if (!(obj4 == PARENT_DISPOSED || !compareAndSet(0, obj4, DONE) || obj4 == null)) {
                ((d) obj4).c(this);
            }
            do {
                obj = get(1);
                if (obj == SYNC_DISPOSED || obj == ASYNC_DISPOSED || compareAndSet(1, obj, DONE)) {
                    throw th;
                }
                obj = get(1);
                break;
            } while (compareAndSet(1, obj, DONE));
            throw th;
        }
    }

    public final void setFuture(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj != DONE) {
                if (obj == SYNC_DISPOSED) {
                    future.cancel(false);
                    return;
                } else if (obj == ASYNC_DISPOSED) {
                    future.cancel(true);
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dispose() {
        /*
            r5 = this;
        L_0x0000:
            r0 = 1
            java.lang.Object r1 = r5.get(r0)
            java.lang.Object r2 = DONE
            r3 = 0
            if (r1 == r2) goto L_0x0034
            java.lang.Object r2 = SYNC_DISPOSED
            if (r1 == r2) goto L_0x0034
            java.lang.Object r2 = ASYNC_DISPOSED
            if (r1 == r2) goto L_0x0034
            r2 = 2
            java.lang.Object r2 = r5.get(r2)
            java.lang.Thread r4 = java.lang.Thread.currentThread()
            if (r2 == r4) goto L_0x001f
            r2 = 1
            goto L_0x0020
        L_0x001f:
            r2 = 0
        L_0x0020:
            if (r2 == 0) goto L_0x0025
            java.lang.Object r4 = ASYNC_DISPOSED
            goto L_0x0027
        L_0x0025:
            java.lang.Object r4 = SYNC_DISPOSED
        L_0x0027:
            boolean r0 = r5.compareAndSet(r0, r1, r4)
            if (r0 == 0) goto L_0x0000
            if (r1 == 0) goto L_0x0034
            java.util.concurrent.Future r1 = (java.util.concurrent.Future) r1
            r1.cancel(r2)
        L_0x0034:
            java.lang.Object r0 = r5.get(r3)
            java.lang.Object r1 = DONE
            if (r0 == r1) goto L_0x004e
            java.lang.Object r1 = PARENT_DISPOSED
            if (r0 == r1) goto L_0x004e
            if (r0 != 0) goto L_0x0043
            goto L_0x004e
        L_0x0043:
            boolean r1 = r5.compareAndSet(r3, r0, r1)
            if (r1 == 0) goto L_0x0034
            io.reactivex.rxjava3.b.d r0 = (io.reactivex.rxjava3.b.d) r0
            r0.c(r5)
        L_0x004e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.e.h.m.dispose():void");
    }

    public final boolean isDisposed() {
        Object obj = get(0);
        if (obj == PARENT_DISPOSED || obj == DONE) {
            return true;
        }
        return false;
    }
}
