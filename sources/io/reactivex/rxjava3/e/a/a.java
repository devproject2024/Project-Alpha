package io.reactivex.rxjava3.e.a;

import io.reactivex.rxjava3.b.c;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class a extends AtomicReferenceArray<c> implements c {
    private static final long serialVersionUID = 2746389416410565408L;

    public a(int i2) {
        super(i2);
    }

    public final boolean setResource(int i2, c cVar) {
        c cVar2;
        do {
            cVar2 = (c) get(i2);
            if (cVar2 == c.DISPOSED) {
                cVar.dispose();
                return false;
            }
        } while (!compareAndSet(i2, cVar2, cVar));
        if (cVar2 == null) {
            return true;
        }
        cVar2.dispose();
        return true;
    }

    public final c replaceResource(int i2, c cVar) {
        c cVar2;
        do {
            cVar2 = (c) get(i2);
            if (cVar2 == c.DISPOSED) {
                cVar.dispose();
                return null;
            }
        } while (!compareAndSet(i2, cVar2, cVar));
        return cVar2;
    }

    public final void dispose() {
        c cVar;
        if (get(0) != c.DISPOSED) {
            int length = length();
            for (int i2 = 0; i2 < length; i2++) {
                if (!(((c) get(i2)) == c.DISPOSED || (cVar = (c) getAndSet(i2, c.DISPOSED)) == c.DISPOSED || cVar == null)) {
                    cVar.dispose();
                }
            }
        }
    }

    public final boolean isDisposed() {
        return get(0) == c.DISPOSED;
    }
}
