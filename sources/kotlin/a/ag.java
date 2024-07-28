package kotlin.a;

import java.util.Collections;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.o;

public class ag extends af {
    public static final int a(int i2) {
        if (i2 < 0) {
            return i2;
        }
        if (i2 < 3) {
            return i2 + 1;
        }
        if (i2 < 1073741824) {
            return (int) ((((float) i2) / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static final <K, V> Map<K, V> a(o<? extends K, ? extends V> oVar) {
        k.d(oVar, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(oVar.getFirst(), oVar.getSecond());
        k.b(singletonMap, "java.util.Collections.si…(pair.first, pair.second)");
        return singletonMap;
    }
}
