package kotlin;

import kotlin.g.b.k;
import kotlin.p;

public final class ResultKt {
    public static final Object a(Throwable th) {
        k.d(th, "exception");
        return new p.b(th);
    }

    public static final void a(Object obj) {
        if (obj instanceof p.b) {
            throw ((p.b) obj).exception;
        }
    }
}
