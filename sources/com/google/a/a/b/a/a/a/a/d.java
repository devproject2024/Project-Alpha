package com.google.a.a.b.a.a.a.a;

public final class d {
    public static <X extends Throwable> void a(Throwable th, Class<X> cls) throws Throwable {
        if (th != null && cls.isInstance(th)) {
            throw ((Throwable) cls.cast(th));
        }
    }
}
