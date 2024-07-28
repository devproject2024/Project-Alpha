package io.reactivex.rxjava3.e.k;

import io.reactivex.rxjava3.a.w;
import java.util.concurrent.atomic.AtomicInteger;

public final class k {
    public static <T> void a(w<? super T> wVar, T t, AtomicInteger atomicInteger, c cVar) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            wVar.onNext(t);
            if (atomicInteger.decrementAndGet() != 0) {
                cVar.tryTerminateConsumer((w<?>) wVar);
            }
        }
    }

    public static void a(w<?> wVar, Throwable th, AtomicInteger atomicInteger, c cVar) {
        if (cVar.tryAddThrowableOrReport(th) && atomicInteger.getAndIncrement() == 0) {
            cVar.tryTerminateConsumer(wVar);
        }
    }

    public static void a(w<?> wVar, AtomicInteger atomicInteger, c cVar) {
        if (atomicInteger.getAndIncrement() == 0) {
            cVar.tryTerminateConsumer(wVar);
        }
    }
}
