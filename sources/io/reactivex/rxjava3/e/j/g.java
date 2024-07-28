package io.reactivex.rxjava3.e.j;

import io.reactivex.rxjava3.c.e;
import io.reactivex.rxjava3.e.k.d;
import io.reactivex.rxjava3.h.a;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;

public enum g implements c {
    CANCELLED;

    public final void cancel() {
    }

    public final void request(long j) {
    }

    public static boolean validate(c cVar, c cVar2) {
        if (cVar2 == null) {
            a.a((Throwable) new NullPointerException("next is null"));
            return false;
        } else if (cVar == null) {
            return true;
        } else {
            cVar2.cancel();
            reportSubscriptionSet();
            return false;
        }
    }

    public static void reportSubscriptionSet() {
        a.a((Throwable) new e("Subscription already set!"));
    }

    public static boolean validate(long j) {
        if (j > 0) {
            return true;
        }
        a.a((Throwable) new IllegalArgumentException("n > 0 required but it was ".concat(String.valueOf(j))));
        return false;
    }

    public static void reportMoreProduced(long j) {
        a.a((Throwable) new e("More produced than requested: ".concat(String.valueOf(j))));
    }

    public static boolean set(AtomicReference<c> atomicReference, c cVar) {
        c cVar2;
        do {
            cVar2 = atomicReference.get();
            if (cVar2 == CANCELLED) {
                if (cVar == null) {
                    return false;
                }
                cVar.cancel();
                return false;
            }
        } while (!atomicReference.compareAndSet(cVar2, cVar));
        if (cVar2 == null) {
            return true;
        }
        cVar2.cancel();
        return true;
    }

    public static boolean setOnce(AtomicReference<c> atomicReference, c cVar) {
        Objects.requireNonNull(cVar, "s is null");
        if (atomicReference.compareAndSet((Object) null, cVar)) {
            return true;
        }
        cVar.cancel();
        if (atomicReference.get() == CANCELLED) {
            return false;
        }
        reportSubscriptionSet();
        return false;
    }

    public static boolean replace(AtomicReference<c> atomicReference, c cVar) {
        c cVar2;
        do {
            cVar2 = atomicReference.get();
            if (cVar2 == CANCELLED) {
                if (cVar == null) {
                    return false;
                }
                cVar.cancel();
                return false;
            }
        } while (!atomicReference.compareAndSet(cVar2, cVar));
        return true;
    }

    public static boolean cancel(AtomicReference<c> atomicReference) {
        c andSet;
        c cVar = atomicReference.get();
        g gVar = CANCELLED;
        if (cVar == gVar || (andSet = atomicReference.getAndSet(gVar)) == CANCELLED) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.cancel();
        return true;
    }

    public static boolean deferredSetOnce(AtomicReference<c> atomicReference, AtomicLong atomicLong, c cVar) {
        if (!setOnce(atomicReference, cVar)) {
            return false;
        }
        long andSet = atomicLong.getAndSet(0);
        if (andSet == 0) {
            return true;
        }
        cVar.request(andSet);
        return true;
    }

    public static void deferredRequest(AtomicReference<c> atomicReference, AtomicLong atomicLong, long j) {
        c cVar = atomicReference.get();
        if (cVar != null) {
            cVar.request(j);
        } else if (validate(j)) {
            d.a(atomicLong, j);
            c cVar2 = atomicReference.get();
            if (cVar2 != null) {
                long andSet = atomicLong.getAndSet(0);
                if (andSet != 0) {
                    cVar2.request(andSet);
                }
            }
        }
    }

    public static boolean setOnce(AtomicReference<c> atomicReference, c cVar, long j) {
        if (!setOnce(atomicReference, cVar)) {
            return false;
        }
        cVar.request(j);
        return true;
    }
}
