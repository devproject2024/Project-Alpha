package net.one97.paytm.o2o.movies.common.a;

import io.reactivex.rxjava3.a.z;
import kotlin.g.b.k;

public final class c {
    public static final <T> void a(z<T> zVar, Throwable th) {
        k.c(th, "error");
        if (zVar != null && !zVar.isDisposed()) {
            zVar.onError(th);
        }
    }

    public static final <T> void a(z<T> zVar, T t) {
        if (zVar != null && !zVar.isDisposed()) {
            zVar.onSuccess(t);
        }
    }
}
