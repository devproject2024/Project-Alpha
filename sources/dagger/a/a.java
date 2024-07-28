package dagger.a;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

abstract class a<K, V, V2> implements c<Map<K, V2>> {

    /* renamed from: a  reason: collision with root package name */
    final Map<K, javax.a.a<V>> f45994a;

    a(Map<K, javax.a.a<V>> map) {
        this.f45994a = Collections.unmodifiableMap(map);
    }

    /* renamed from: dagger.a.a$a  reason: collision with other inner class name */
    public static abstract class C0766a<K, V, V2> {

        /* renamed from: a  reason: collision with root package name */
        final LinkedHashMap<K, javax.a.a<V>> f45995a;

        C0766a(int i2) {
            this.f45995a = new LinkedHashMap<>(i2 < 3 ? i2 + 1 : i2 < 1073741824 ? (int) ((((float) i2) / 0.75f) + 1.0f) : Integer.MAX_VALUE);
        }

        /* access modifiers changed from: package-private */
        public C0766a<K, V, V2> a(K k, javax.a.a<V> aVar) {
            this.f45995a.put(g.a(k, "key"), g.a(aVar, "provider"));
            return this;
        }
    }
}
