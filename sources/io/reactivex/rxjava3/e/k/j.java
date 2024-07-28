package io.reactivex.rxjava3.e.k;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final Throwable f47736a = new a();

    public static RuntimeException a(Throwable th) {
        if (th instanceof Error) {
            throw ((Error) th);
        } else if (th instanceof RuntimeException) {
            return (RuntimeException) th;
        } else {
            return new RuntimeException(th);
        }
    }

    public static boolean a(AtomicReference<Throwable> atomicReference, Throwable th) {
        Throwable th2;
        Throwable th3;
        do {
            th2 = atomicReference.get();
            if (th2 == f47736a) {
                return false;
            }
            if (th2 == null) {
                th3 = th;
            } else {
                th3 = new io.reactivex.rxjava3.c.a(th2, th);
            }
        } while (!atomicReference.compareAndSet(th2, th3));
        return true;
    }

    public static Throwable a(AtomicReference<Throwable> atomicReference) {
        Throwable th = atomicReference.get();
        Throwable th2 = f47736a;
        return th != th2 ? atomicReference.getAndSet(th2) : th;
    }

    public static <E extends Throwable> Exception b(Throwable th) throws Throwable {
        if (th instanceof Exception) {
            return (Exception) th;
        }
        throw th;
    }

    public static String a(long j, TimeUnit timeUnit) {
        return "The source did not signal an event for " + j + " " + timeUnit.toString().toLowerCase() + " and has been terminated.";
    }

    static final class a extends Throwable {
        private static final long serialVersionUID = -4649703670690200604L;

        public final Throwable fillInStackTrace() {
            return this;
        }

        a() {
            super("No further exceptions");
        }
    }

    public static NullPointerException a(String str) {
        return new NullPointerException(str + " Null values are generally not allowed in 3.x operators and sources.");
    }

    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw a(str);
    }
}
