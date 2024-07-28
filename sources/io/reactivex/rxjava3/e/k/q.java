package io.reactivex.rxjava3.e.k;

import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.c.j;
import io.reactivex.rxjava3.e.c.k;

public final class q {
    public static <T, U> void a(j<T> jVar, w<? super U> wVar, c cVar, n<T, U> nVar) {
        int i2 = 1;
        while (!a(nVar.b(), jVar.isEmpty(), wVar, jVar, cVar, nVar)) {
            while (true) {
                boolean b2 = nVar.b();
                T poll = jVar.poll();
                boolean z = poll == null;
                if (!a(b2, z, wVar, jVar, cVar, nVar)) {
                    if (!z) {
                        nVar.a(wVar, poll);
                    } else {
                        i2 = nVar.a(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    private static <T, U> boolean a(boolean z, boolean z2, w<?> wVar, k<?> kVar, c cVar, n<T, U> nVar) {
        if (nVar.a()) {
            kVar.clear();
            cVar.dispose();
            return true;
        } else if (!z) {
            return false;
        } else {
            Throwable d2 = nVar.d();
            if (d2 != null) {
                kVar.clear();
                if (cVar != null) {
                    cVar.dispose();
                }
                wVar.onError(d2);
                return true;
            } else if (!z2) {
                return false;
            } else {
                if (cVar != null) {
                    cVar.dispose();
                }
                wVar.onComplete();
                return true;
            }
        }
    }
}
