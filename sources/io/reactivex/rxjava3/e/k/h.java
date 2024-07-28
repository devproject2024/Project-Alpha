package io.reactivex.rxjava3.e.k;

import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.e;
import io.reactivex.rxjava3.h.a;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class h {
    public static boolean a(AtomicReference<c> atomicReference, c cVar, Class<?> cls) {
        Objects.requireNonNull(cVar, "next is null");
        if (atomicReference.compareAndSet((Object) null, cVar)) {
            return true;
        }
        cVar.dispose();
        if (atomicReference.get() == io.reactivex.rxjava3.e.a.c.DISPOSED) {
            return false;
        }
        a(cls);
        return false;
    }

    private static String a(String str) {
        return "It is not allowed to subscribe with a(n) " + str + " multiple times. Please create a fresh instance of " + str + " and subscribe that to the target source instead.";
    }

    public static void a(Class<?> cls) {
        a.a((Throwable) new e(a(cls.getName())));
    }
}
