package androidx.a;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class f<K, V> {

    /* renamed from: b  reason: collision with root package name */
    f<K, V>.defpackage.b f939b;

    /* renamed from: c  reason: collision with root package name */
    f<K, V>.c f940c;

    /* renamed from: d  reason: collision with root package name */
    f<K, V>.e f941d;

    /* access modifiers changed from: protected */
    public abstract int a();

    /* access modifiers changed from: protected */
    public abstract int a(Object obj);

    /* access modifiers changed from: protected */
    public abstract Object a(int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract V a(int i2, V v);

    /* access modifiers changed from: protected */
    public abstract void a(int i2);

    /* access modifiers changed from: protected */
    public abstract void a(K k, V v);

    /* access modifiers changed from: protected */
    public abstract int b(Object obj);

    /* access modifiers changed from: protected */
    public abstract Map<K, V> b();

    /* access modifiers changed from: protected */
    public abstract void c();

    f() {
    }

    final class a<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        final int f942a;

        /* renamed from: b  reason: collision with root package name */
        int f943b;

        /* renamed from: c  reason: collision with root package name */
        int f944c;

        /* renamed from: d  reason: collision with root package name */
        boolean f945d = false;

        a(int i2) {
            this.f942a = i2;
            this.f943b = f.this.a();
        }

        public final boolean hasNext() {
            return this.f944c < this.f943b;
        }

        public final T next() {
            if (hasNext()) {
                T a2 = f.this.a(this.f944c, this.f942a);
                this.f944c++;
                this.f945d = true;
                return a2;
            }
            throw new NoSuchElementException();
        }

        public final void remove() {
            if (this.f945d) {
                this.f944c--;
                this.f943b--;
                this.f945d = false;
                f.this.a(this.f944c);
                return;
            }
            throw new IllegalStateException();
        }
    }

    final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        int f949a;

        /* renamed from: b  reason: collision with root package name */
        int f950b;

        /* renamed from: c  reason: collision with root package name */
        boolean f951c = false;

        d() {
            this.f949a = f.this.a() - 1;
            this.f950b = -1;
        }

        public final boolean hasNext() {
            return this.f950b < this.f949a;
        }

        public final void remove() {
            if (this.f951c) {
                f.this.a(this.f950b);
                this.f950b--;
                this.f949a--;
                this.f951c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public final K getKey() {
            if (this.f951c) {
                return f.this.a(this.f950b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final V getValue() {
            if (this.f951c) {
                return f.this.a(this.f950b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final V setValue(V v) {
            if (this.f951c) {
                return f.this.a(this.f950b, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final boolean equals(Object obj) {
            if (!this.f951c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Map.Entry)) {
                return false;
            } else {
                Map.Entry entry = (Map.Entry) obj;
                if (!c.a(entry.getKey(), f.this.a(this.f950b, 0)) || !c.a(entry.getValue(), f.this.a(this.f950b, 1))) {
                    return false;
                }
                return true;
            }
        }

        public final int hashCode() {
            int i2;
            if (this.f951c) {
                int i3 = 0;
                Object a2 = f.this.a(this.f950b, 0);
                Object a3 = f.this.a(this.f950b, 1);
                if (a2 == null) {
                    i2 = 0;
                } else {
                    i2 = a2.hashCode();
                }
                if (a3 != null) {
                    i3 = a3.hashCode();
                }
                return i2 ^ i3;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }

        public final /* synthetic */ Object next() {
            if (hasNext()) {
                this.f950b++;
                this.f951c = true;
                return this;
            }
            throw new NoSuchElementException();
        }
    }

    final class b implements Set<Map.Entry<K, V>> {
        b() {
        }

        public final boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int a2 = f.this.a();
            for (Map.Entry entry : collection) {
                f.this.a(entry.getKey(), entry.getValue());
            }
            return a2 != f.this.a();
        }

        public final void clear() {
            f.this.c();
        }

        public final boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int a2 = f.this.a(entry.getKey());
            if (a2 < 0) {
                return false;
            }
            return c.a(f.this.a(a2, 1), entry.getValue());
        }

        public final boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            return f.this.a() == 0;
        }

        public final Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public final int size() {
            return f.this.a();
        }

        public final Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public final <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        public final boolean equals(Object obj) {
            return f.a(this, obj);
        }

        public final int hashCode() {
            int i2;
            int i3;
            int i4 = 0;
            for (int a2 = f.this.a() - 1; a2 >= 0; a2--) {
                Object a3 = f.this.a(a2, 0);
                Object a4 = f.this.a(a2, 1);
                if (a3 == null) {
                    i2 = 0;
                } else {
                    i2 = a3.hashCode();
                }
                if (a4 == null) {
                    i3 = 0;
                } else {
                    i3 = a4.hashCode();
                }
                i4 += i2 ^ i3;
            }
            return i4;
        }

        public final /* synthetic */ boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }
    }

    final class c implements Set<K> {
        c() {
        }

        public final boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            f.this.c();
        }

        public final boolean contains(Object obj) {
            return f.this.a(obj) >= 0;
        }

        public final boolean containsAll(Collection<?> collection) {
            Map b2 = f.this.b();
            for (Object containsKey : collection) {
                if (!b2.containsKey(containsKey)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            return f.this.a() == 0;
        }

        public final Iterator<K> iterator() {
            return new a(0);
        }

        public final boolean remove(Object obj) {
            int a2 = f.this.a(obj);
            if (a2 < 0) {
                return false;
            }
            f.this.a(a2);
            return true;
        }

        public final boolean removeAll(Collection<?> collection) {
            Map b2 = f.this.b();
            int size = b2.size();
            for (Object remove : collection) {
                b2.remove(remove);
            }
            return size != b2.size();
        }

        public final boolean retainAll(Collection<?> collection) {
            return f.a(f.this.b(), collection);
        }

        public final int size() {
            return f.this.a();
        }

        public final Object[] toArray() {
            return f.this.b(0);
        }

        public final <T> T[] toArray(T[] tArr) {
            return f.this.a(tArr, 0);
        }

        public final boolean equals(Object obj) {
            return f.a(this, obj);
        }

        public final int hashCode() {
            int i2;
            int i3 = 0;
            for (int a2 = f.this.a() - 1; a2 >= 0; a2--) {
                Object a3 = f.this.a(a2, 0);
                if (a3 == null) {
                    i2 = 0;
                } else {
                    i2 = a3.hashCode();
                }
                i3 += i2;
            }
            return i3;
        }
    }

    final class e implements Collection<V> {
        e() {
        }

        public final boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            f.this.c();
        }

        public final boolean contains(Object obj) {
            return f.this.b(obj) >= 0;
        }

        public final boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            return f.this.a() == 0;
        }

        public final Iterator<V> iterator() {
            return new a(1);
        }

        public final boolean remove(Object obj) {
            int b2 = f.this.b(obj);
            if (b2 < 0) {
                return false;
            }
            f.this.a(b2);
            return true;
        }

        public final boolean removeAll(Collection<?> collection) {
            int a2 = f.this.a();
            int i2 = 0;
            boolean z = false;
            while (i2 < a2) {
                if (collection.contains(f.this.a(i2, 1))) {
                    f.this.a(i2);
                    i2--;
                    a2--;
                    z = true;
                }
                i2++;
            }
            return z;
        }

        public final boolean retainAll(Collection<?> collection) {
            int a2 = f.this.a();
            int i2 = 0;
            boolean z = false;
            while (i2 < a2) {
                if (!collection.contains(f.this.a(i2, 1))) {
                    f.this.a(i2);
                    i2--;
                    a2--;
                    z = true;
                }
                i2++;
            }
            return z;
        }

        public final int size() {
            return f.this.a();
        }

        public final Object[] toArray() {
            return f.this.b(1);
        }

        public final <T> T[] toArray(T[] tArr) {
            return f.this.a(tArr, 1);
        }
    }

    public static <K, V> boolean a(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it2 = map.keySet().iterator();
        while (it2.hasNext()) {
            if (!collection.contains(it2.next())) {
                it2.remove();
            }
        }
        return size != map.size();
    }

    public final Object[] b(int i2) {
        int a2 = a();
        Object[] objArr = new Object[a2];
        for (int i3 = 0; i3 < a2; i3++) {
            objArr[i3] = a(i3, i2);
        }
        return objArr;
    }

    public final <T> T[] a(T[] tArr, int i2) {
        int a2 = a();
        if (tArr.length < a2) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a2);
        }
        for (int i3 = 0; i3 < a2; i3++) {
            tArr[i3] = a(i3, i2);
        }
        if (tArr.length > a2) {
            tArr[a2] = null;
        }
        return tArr;
    }

    public static <T> boolean a(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                return set.size() == set2.size() && set.containsAll(set2);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
    }

    public final Set<K> d() {
        if (this.f940c == null) {
            this.f940c = new c();
        }
        return this.f940c;
    }
}
