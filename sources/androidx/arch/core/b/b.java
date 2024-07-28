package androidx.arch.core.b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: b  reason: collision with root package name */
    public c<K, V> f1852b;

    /* renamed from: c  reason: collision with root package name */
    public c<K, V> f1853c;

    /* renamed from: d  reason: collision with root package name */
    public WeakHashMap<f<K, V>, Boolean> f1854d = new WeakHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public int f1855e = 0;

    interface f<K, V> {
        void a_(c<K, V> cVar);
    }

    /* access modifiers changed from: protected */
    public c<K, V> a(K k) {
        c<K, V> cVar = this.f1852b;
        while (cVar != null && !cVar.f1856a.equals(k)) {
            cVar = cVar.f1858c;
        }
        return cVar;
    }

    public V a(K k, V v) {
        c a2 = a(k);
        if (a2 != null) {
            return a2.f1857b;
        }
        b(k, v);
        return null;
    }

    /* access modifiers changed from: protected */
    public final c<K, V> b(K k, V v) {
        c<K, V> cVar = new c<>(k, v);
        this.f1855e++;
        c<K, V> cVar2 = this.f1853c;
        if (cVar2 == null) {
            this.f1852b = cVar;
            this.f1853c = this.f1852b;
            return cVar;
        }
        cVar2.f1858c = cVar;
        cVar.f1859d = cVar2;
        this.f1853c = cVar;
        return cVar;
    }

    public V b(K k) {
        c a2 = a(k);
        if (a2 == null) {
            return null;
        }
        this.f1855e--;
        if (!this.f1854d.isEmpty()) {
            for (f<K, V> a_ : this.f1854d.keySet()) {
                a_.a_(a2);
            }
        }
        if (a2.f1859d != null) {
            a2.f1859d.f1858c = a2.f1858c;
        } else {
            this.f1852b = a2.f1858c;
        }
        if (a2.f1858c != null) {
            a2.f1858c.f1859d = a2.f1859d;
        } else {
            this.f1853c = a2.f1859d;
        }
        a2.f1858c = null;
        a2.f1859d = null;
        return a2.f1857b;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f1852b, this.f1853c);
        this.f1854d.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public final b<K, V>.d a() {
        b<K, V>.d dVar = new d();
        this.f1854d.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f1855e != bVar.f1855e) {
            return false;
        }
        Iterator it2 = iterator();
        Iterator it3 = bVar.iterator();
        while (it2.hasNext() && it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            Object next = it3.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return !it2.hasNext() && !it3.hasNext();
    }

    public int hashCode() {
        Iterator it2 = iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            i2 += ((Map.Entry) it2.next()).hashCode();
        }
        return i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            sb.append(((Map.Entry) it2.next()).toString());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    static abstract class e<K, V> implements f<K, V>, Iterator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        c<K, V> f1863a;

        /* renamed from: b  reason: collision with root package name */
        c<K, V> f1864b;

        /* access modifiers changed from: package-private */
        public abstract c<K, V> a(c<K, V> cVar);

        /* access modifiers changed from: package-private */
        public abstract c<K, V> b(c<K, V> cVar);

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f1863a = cVar2;
            this.f1864b = cVar;
        }

        public boolean hasNext() {
            return this.f1864b != null;
        }

        public final void a_(c<K, V> cVar) {
            if (this.f1863a == cVar && cVar == this.f1864b) {
                this.f1864b = null;
                this.f1863a = null;
            }
            c<K, V> cVar2 = this.f1863a;
            if (cVar2 == cVar) {
                this.f1863a = b(cVar2);
            }
            if (this.f1864b == cVar) {
                this.f1864b = a();
            }
        }

        private c<K, V> a() {
            c<K, V> cVar = this.f1864b;
            c<K, V> cVar2 = this.f1863a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return a(cVar);
        }

        public /* synthetic */ Object next() {
            c<K, V> cVar = this.f1864b;
            this.f1864b = a();
            return cVar;
        }
    }

    static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        public final c<K, V> a(c<K, V> cVar) {
            return cVar.f1858c;
        }

        /* access modifiers changed from: package-private */
        public final c<K, V> b(c<K, V> cVar) {
            return cVar.f1859d;
        }
    }

    /* renamed from: androidx.arch.core.b.b$b  reason: collision with other inner class name */
    public static class C0026b<K, V> extends e<K, V> {
        public C0026b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        public final c<K, V> a(c<K, V> cVar) {
            return cVar.f1859d;
        }

        /* access modifiers changed from: package-private */
        public final c<K, V> b(c<K, V> cVar) {
            return cVar.f1858c;
        }
    }

    public class d implements f<K, V>, Iterator<Map.Entry<K, V>> {

        /* renamed from: b  reason: collision with root package name */
        private c<K, V> f1861b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1862c = true;

        d() {
        }

        public final void a_(c<K, V> cVar) {
            c<K, V> cVar2 = this.f1861b;
            if (cVar == cVar2) {
                this.f1861b = cVar2.f1859d;
                this.f1862c = this.f1861b == null;
            }
        }

        public final boolean hasNext() {
            if (this.f1862c) {
                return b.this.f1852b != null;
            }
            c<K, V> cVar = this.f1861b;
            return (cVar == null || cVar.f1858c == null) ? false : true;
        }

        public final /* bridge */ /* synthetic */ Object next() {
            c<K, V> cVar;
            if (this.f1862c) {
                this.f1862c = false;
                cVar = b.this.f1852b;
            } else {
                c<K, V> cVar2 = this.f1861b;
                cVar = cVar2 != null ? cVar2.f1858c : null;
            }
            this.f1861b = cVar;
            return this.f1861b;
        }
    }

    public static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f1856a;

        /* renamed from: b  reason: collision with root package name */
        final V f1857b;

        /* renamed from: c  reason: collision with root package name */
        c<K, V> f1858c;

        /* renamed from: d  reason: collision with root package name */
        public c<K, V> f1859d;

        c(K k, V v) {
            this.f1856a = k;
            this.f1857b = v;
        }

        public final K getKey() {
            return this.f1856a;
        }

        public final V getValue() {
            return this.f1857b;
        }

        public final V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public final String toString() {
            return this.f1856a + "=" + this.f1857b;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f1856a.equals(cVar.f1856a) && this.f1857b.equals(cVar.f1857b);
        }

        public final int hashCode() {
            return this.f1856a.hashCode() ^ this.f1857b.hashCode();
        }
    }
}
