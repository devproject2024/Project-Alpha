package io.reactivex.rxjava3.e.a;

import io.reactivex.rxjava3.c.e;
import io.reactivex.rxjava3.h.a;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public enum c implements io.reactivex.rxjava3.b.c {
    DISPOSED;

    public final void dispose() {
    }

    public final boolean isDisposed() {
        return true;
    }

    public static boolean isDisposed(io.reactivex.rxjava3.b.c cVar) {
        return cVar == DISPOSED;
    }

    public static boolean set(AtomicReference<io.reactivex.rxjava3.b.c> atomicReference, io.reactivex.rxjava3.b.c cVar) {
        io.reactivex.rxjava3.b.c cVar2;
        do {
            cVar2 = atomicReference.get();
            if (cVar2 == DISPOSED) {
                if (cVar == null) {
                    return false;
                }
                cVar.dispose();
                return false;
            }
        } while (!atomicReference.compareAndSet(cVar2, cVar));
        if (cVar2 == null) {
            return true;
        }
        cVar2.dispose();
        return true;
    }

    public static boolean setOnce(AtomicReference<io.reactivex.rxjava3.b.c> atomicReference, io.reactivex.rxjava3.b.c cVar) {
        Objects.requireNonNull(cVar, "d is null");
        if (atomicReference.compareAndSet((Object) null, cVar)) {
            return true;
        }
        cVar.dispose();
        if (atomicReference.get() == DISPOSED) {
            return false;
        }
        reportDisposableSet();
        return false;
    }

    public static boolean replace(AtomicReference<io.reactivex.rxjava3.b.c> atomicReference, io.reactivex.rxjava3.b.c cVar) {
        io.reactivex.rxjava3.b.c cVar2;
        do {
            cVar2 = atomicReference.get();
            if (cVar2 == DISPOSED) {
                if (cVar == null) {
                    return false;
                }
                cVar.dispose();
                return false;
            }
        } while (!atomicReference.compareAndSet(cVar2, cVar));
        return true;
    }

    public static boolean dispose(AtomicReference<io.reactivex.rxjava3.b.c> atomicReference) {
        io.reactivex.rxjava3.b.c andSet;
        io.reactivex.rxjava3.b.c cVar = atomicReference.get();
        c cVar2 = DISPOSED;
        if (cVar == cVar2 || (andSet = atomicReference.getAndSet(cVar2)) == cVar2) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.dispose();
        return true;
    }

    public static boolean validate(io.reactivex.rxjava3.b.c cVar, io.reactivex.rxjava3.b.c cVar2) {
        if (cVar2 == null) {
            a.a((Throwable) new NullPointerException("next is null"));
            return false;
        } else if (cVar == null) {
            return true;
        } else {
            cVar2.dispose();
            reportDisposableSet();
            return false;
        }
    }

    public static void reportDisposableSet() {
        a.a((Throwable) new e("Disposable already set!"));
    }

    public static boolean trySet(AtomicReference<io.reactivex.rxjava3.b.c> atomicReference, io.reactivex.rxjava3.b.c cVar) {
        if (atomicReference.compareAndSet((Object) null, cVar)) {
            return true;
        }
        if (atomicReference.get() != DISPOSED) {
            return false;
        }
        cVar.dispose();
        return false;
    }
}
