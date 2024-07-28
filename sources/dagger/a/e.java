package dagger.a;

import dagger.a.a;
import java.util.Map;

public final class e<K, V> extends a<K, V, javax.a.a<V>> {
    /* synthetic */ e(Map map, byte b2) {
        this(map);
    }

    public static <K, V> a<K, V> a(int i2) {
        return new a<>(i2, (byte) 0);
    }

    private e(Map<K, javax.a.a<V>> map) {
        super(map);
    }

    public static final class a<K, V> extends a.C0766a<K, V, javax.a.a<V>> {
        /* synthetic */ a(int i2, byte b2) {
            this(i2);
        }

        private a(int i2) {
            super(i2);
        }

        /* renamed from: b */
        public final a<K, V> a(K k, javax.a.a<V> aVar) {
            super.a(k, aVar);
            return this;
        }

        public final e<K, V> a() {
            return new e<>(this.f45995a, (byte) 0);
        }
    }

    public final /* bridge */ /* synthetic */ Object get() {
        return this.f45994a;
    }
}
