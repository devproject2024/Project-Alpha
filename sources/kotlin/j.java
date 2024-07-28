package kotlin;

import kotlin.g.a.a;
import kotlin.g.b.g;
import kotlin.g.b.k;

public class j {
    public static final <T> g<T> a(a<? extends T> aVar) {
        k.d(aVar, "initializer");
        return new r<>(aVar, (Object) null, 2, (g) null);
    }

    public static final <T> g<T> a(l lVar, a<? extends T> aVar) {
        k.d(lVar, "mode");
        k.d(aVar, "initializer");
        int i2 = i.f47934a[lVar.ordinal()];
        if (i2 == 1) {
            return new r<>(aVar, (Object) null, 2, (g) null);
        }
        if (i2 == 2) {
            return new q<>(aVar);
        }
        if (i2 == 3) {
            return new y<>(aVar);
        }
        throw new m();
    }
}
