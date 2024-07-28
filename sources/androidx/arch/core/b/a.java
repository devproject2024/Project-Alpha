package androidx.arch.core.b;

import androidx.arch.core.b.b;
import java.util.HashMap;

public final class a<K, V> extends b<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<K, b.c<K, V>> f1851a = new HashMap<>();

    /* access modifiers changed from: protected */
    public final b.c<K, V> a(K k) {
        return this.f1851a.get(k);
    }

    public final V a(K k, V v) {
        b.c a2 = a(k);
        if (a2 != null) {
            return a2.f1857b;
        }
        this.f1851a.put(k, b(k, v));
        return null;
    }

    public final V b(K k) {
        V b2 = super.b(k);
        this.f1851a.remove(k);
        return b2;
    }

    public final boolean c(K k) {
        return this.f1851a.containsKey(k);
    }
}
