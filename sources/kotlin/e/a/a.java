package kotlin.e.a;

import kotlin.g.b.k;

public class a extends kotlin.e.a {
    public final void a(Throwable th, Throwable th2) {
        k.c(th, "cause");
        k.c(th2, "exception");
        th.addSuppressed(th2);
    }
}
