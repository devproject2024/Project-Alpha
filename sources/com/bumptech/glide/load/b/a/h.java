package com.bumptech.glide.load.b.a;

import com.bumptech.glide.load.b.a.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class h<K extends m, V> {

    /* renamed from: a  reason: collision with root package name */
    private final a<K, V> f6738a = new a<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<K, a<K, V>> f6739b = new HashMap();

    h() {
    }

    public final void a(K k, V v) {
        a aVar = this.f6739b.get(k);
        if (aVar == null) {
            aVar = new a(k);
            b(aVar);
            this.f6739b.put(k, aVar);
        } else {
            k.a();
        }
        aVar.a(v);
    }

    public final V a(K k) {
        a aVar = this.f6739b.get(k);
        if (aVar == null) {
            aVar = new a(k);
            this.f6739b.put(k, aVar);
        } else {
            k.a();
        }
        a(aVar);
        return aVar.a();
    }

    public final V a() {
        for (a<K, V> aVar = this.f6738a.f6742c; !aVar.equals(this.f6738a); aVar = aVar.f6742c) {
            V a2 = aVar.a();
            if (a2 != null) {
                return a2;
            }
            d(aVar);
            this.f6739b.remove(aVar.f6740a);
            ((m) aVar.f6740a).a();
        }
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a<K, V> aVar = this.f6738a.f6741b; !aVar.equals(this.f6738a); aVar = aVar.f6741b) {
            z = true;
            sb.append('{');
            sb.append(aVar.f6740a);
            sb.append(':');
            sb.append(aVar.b());
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }

    private void a(a<K, V> aVar) {
        d(aVar);
        a<K, V> aVar2 = this.f6738a;
        aVar.f6742c = aVar2;
        aVar.f6741b = aVar2.f6741b;
        c(aVar);
    }

    private void b(a<K, V> aVar) {
        d(aVar);
        aVar.f6742c = this.f6738a.f6742c;
        aVar.f6741b = this.f6738a;
        c(aVar);
    }

    private static <K, V> void c(a<K, V> aVar) {
        aVar.f6741b.f6742c = aVar;
        aVar.f6742c.f6741b = aVar;
    }

    private static <K, V> void d(a<K, V> aVar) {
        aVar.f6742c.f6741b = aVar.f6741b;
        aVar.f6741b.f6742c = aVar.f6742c;
    }

    static class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f6740a;

        /* renamed from: b  reason: collision with root package name */
        a<K, V> f6741b;

        /* renamed from: c  reason: collision with root package name */
        a<K, V> f6742c;

        /* renamed from: d  reason: collision with root package name */
        private List<V> f6743d;

        a() {
            this((Object) null);
        }

        a(K k) {
            this.f6742c = this;
            this.f6741b = this;
            this.f6740a = k;
        }

        public final V a() {
            int b2 = b();
            if (b2 > 0) {
                return this.f6743d.remove(b2 - 1);
            }
            return null;
        }

        public final int b() {
            List<V> list = this.f6743d;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public final void a(V v) {
            if (this.f6743d == null) {
                this.f6743d = new ArrayList();
            }
            this.f6743d.add(v);
        }
    }
}
