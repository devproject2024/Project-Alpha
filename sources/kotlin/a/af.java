package kotlin.a;

import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.g.b.k;

class af {
    public static final <K, V> V a(Map<K, ? extends V> map, K k) {
        k.d(map, "$this$getOrImplicitDefault");
        if (map instanceof ad) {
            return ((ad) map).a();
        }
        V v = map.get(k);
        if (v != null || map.containsKey(k)) {
            return v;
        }
        throw new NoSuchElementException("Key " + k + " is missing in the map.");
    }
}
