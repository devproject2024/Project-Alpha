package androidx.a;

import androidx.a.f;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class a<K, V> extends g<K, V> implements Map<K, V> {

    /* renamed from: a  reason: collision with root package name */
    f<K, V> f919a;

    public a() {
    }

    public a(int i2) {
        super(i2);
    }

    public a(g gVar) {
        super(gVar);
    }

    private f<K, V> a() {
        if (this.f919a == null) {
            this.f919a = new f<K, V>() {
                /* access modifiers changed from: protected */
                public final int a() {
                    return a.this.f960h;
                }

                /* access modifiers changed from: protected */
                public final Object a(int i2, int i3) {
                    return a.this.f959g[(i2 << 1) + i3];
                }

                /* access modifiers changed from: protected */
                public final int a(Object obj) {
                    return a.this.a(obj);
                }

                /* access modifiers changed from: protected */
                public final int b(Object obj) {
                    return a.this.b(obj);
                }

                /* access modifiers changed from: protected */
                public final Map<K, V> b() {
                    return a.this;
                }

                /* access modifiers changed from: protected */
                public final void a(K k, V v) {
                    a.this.put(k, v);
                }

                /* access modifiers changed from: protected */
                public final V a(int i2, V v) {
                    return a.this.a(i2, v);
                }

                /* access modifiers changed from: protected */
                public final void a(int i2) {
                    a.this.d(i2);
                }

                /* access modifiers changed from: protected */
                public final void c() {
                    a.this.clear();
                }
            };
        }
        return this.f919a;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        a(this.f960h + map.size());
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public Set<Map.Entry<K, V>> entrySet() {
        f a2 = a();
        if (a2.f939b == null) {
            a2.f939b = new f.b();
        }
        return a2.f939b;
    }

    public Set<K> keySet() {
        return a().d();
    }

    public Collection<V> values() {
        f a2 = a();
        if (a2.f941d == null) {
            a2.f941d = new f.e();
        }
        return a2.f941d;
    }
}
