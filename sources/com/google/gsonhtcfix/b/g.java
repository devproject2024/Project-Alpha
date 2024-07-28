package com.google.gsonhtcfix.b;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public final class g<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> NATURAL_ORDER = new Comparator<Comparable>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo((Comparable) obj2);
        }
    };
    Comparator<? super K> comparator;
    private g<K, V>.defpackage.a entrySet;
    final d<K, V> header;
    private g<K, V>.defpackage.b keySet;
    int modCount;
    d<K, V> root;
    int size;

    public g() {
        this(NATURAL_ORDER);
    }

    public g(Comparator<? super K> comparator2) {
        this.size = 0;
        this.modCount = 0;
        this.header = new d<>();
        this.comparator = comparator2 == null ? NATURAL_ORDER : comparator2;
    }

    public final int size() {
        return this.size;
    }

    public final V get(Object obj) {
        d findByObject = findByObject(obj);
        if (findByObject != null) {
            return findByObject.f39766g;
        }
        return null;
    }

    public final boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    public final V put(K k, V v) {
        if (k != null) {
            d find = find(k, true);
            V v2 = find.f39766g;
            find.f39766g = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    public final void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        d<K, V> dVar = this.header;
        dVar.f39764e = dVar;
        dVar.f39763d = dVar;
    }

    public final V remove(Object obj) {
        d removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return removeInternalByKey.f39766g;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final d<K, V> find(K k, boolean z) {
        int i2;
        d<K, V> dVar;
        d<K, V> dVar2;
        Comparator<? super K> comparator2 = this.comparator;
        d<K, V> dVar3 = this.root;
        if (dVar3 != null) {
            Comparable comparable = comparator2 == NATURAL_ORDER ? (Comparable) k : null;
            while (true) {
                K k2 = dVar3.f39765f;
                i2 = comparable != null ? comparable.compareTo(k2) : comparator2.compare(k, k2);
                if (i2 != 0) {
                    if (i2 < 0) {
                        dVar2 = dVar3.f39761b;
                    } else {
                        dVar2 = dVar3.f39762c;
                    }
                    if (dVar2 == null) {
                        break;
                    }
                    dVar3 = dVar2;
                } else {
                    return dVar3;
                }
            }
        } else {
            i2 = 0;
        }
        if (!z) {
            return null;
        }
        d<K, V> dVar4 = this.header;
        if (dVar3 != null) {
            dVar = new d<>(dVar3, k, dVar4, dVar4.f39764e);
            if (i2 < 0) {
                dVar3.f39761b = dVar;
            } else {
                dVar3.f39762c = dVar;
            }
            rebalance(dVar3, true);
        } else if (comparator2 != NATURAL_ORDER || (k instanceof Comparable)) {
            dVar = new d<>(dVar3, k, dVar4, dVar4.f39764e);
            this.root = dVar;
        } else {
            throw new ClassCastException(k.getClass().getName() + " is not Comparable");
        }
        this.size++;
        this.modCount++;
        return dVar;
    }

    /* access modifiers changed from: package-private */
    public final d<K, V> findByObject(Object obj) {
        if (obj != null) {
            try {
                return find(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final d<K, V> findByEntry(Map.Entry<?, ?> entry) {
        d<K, V> findByObject = findByObject(entry.getKey());
        if (findByObject != null && equal(findByObject.f39766g, entry.getValue())) {
            return findByObject;
        }
        return null;
    }

    private boolean equal(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void removeInternal(d<K, V> dVar, boolean z) {
        int i2;
        if (z) {
            dVar.f39764e.f39763d = dVar.f39763d;
            dVar.f39763d.f39764e = dVar.f39764e;
        }
        d<K, V> dVar2 = dVar.f39761b;
        d<K, V> dVar3 = dVar.f39762c;
        d<K, V> dVar4 = dVar.f39760a;
        int i3 = 0;
        if (dVar2 == null || dVar3 == null) {
            if (dVar2 != null) {
                replaceInParent(dVar, dVar2);
                dVar.f39761b = null;
            } else if (dVar3 != null) {
                replaceInParent(dVar, dVar3);
                dVar.f39762c = null;
            } else {
                replaceInParent(dVar, (d<K, V>) null);
            }
            rebalance(dVar4, false);
            this.size--;
            this.modCount++;
            return;
        }
        if (dVar2.f39767h > dVar3.f39767h) {
            d<K, V> dVar5 = dVar2.f39762c;
            while (true) {
                d<K, V> dVar6 = dVar5;
                dVar3 = dVar2;
                dVar2 = dVar6;
                if (dVar2 == null) {
                    break;
                }
                dVar5 = dVar2.f39762c;
            }
        } else {
            while (true) {
                d<K, V> dVar7 = dVar3.f39761b;
                if (dVar7 == null) {
                    break;
                }
                dVar3 = dVar7;
            }
        }
        removeInternal(dVar3, false);
        d<K, V> dVar8 = dVar.f39761b;
        if (dVar8 != null) {
            i2 = dVar8.f39767h;
            dVar3.f39761b = dVar8;
            dVar8.f39760a = dVar3;
            dVar.f39761b = null;
        } else {
            i2 = 0;
        }
        d<K, V> dVar9 = dVar.f39762c;
        if (dVar9 != null) {
            i3 = dVar9.f39767h;
            dVar3.f39762c = dVar9;
            dVar9.f39760a = dVar3;
            dVar.f39762c = null;
        }
        dVar3.f39767h = Math.max(i2, i3) + 1;
        replaceInParent(dVar, dVar3);
    }

    /* access modifiers changed from: package-private */
    public final d<K, V> removeInternalByKey(Object obj) {
        d<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject, true);
        }
        return findByObject;
    }

    private void replaceInParent(d<K, V> dVar, d<K, V> dVar2) {
        d<K, V> dVar3 = dVar.f39760a;
        dVar.f39760a = null;
        if (dVar2 != null) {
            dVar2.f39760a = dVar3;
        }
        if (dVar3 == null) {
            this.root = dVar2;
        } else if (dVar3.f39761b == dVar) {
            dVar3.f39761b = dVar2;
        } else {
            dVar3.f39762c = dVar2;
        }
    }

    private void rebalance(d<K, V> dVar, boolean z) {
        while (dVar != null) {
            d<K, V> dVar2 = dVar.f39761b;
            d<K, V> dVar3 = dVar.f39762c;
            int i2 = 0;
            int i3 = dVar2 != null ? dVar2.f39767h : 0;
            int i4 = dVar3 != null ? dVar3.f39767h : 0;
            int i5 = i3 - i4;
            if (i5 == -2) {
                d<K, V> dVar4 = dVar3.f39761b;
                d<K, V> dVar5 = dVar3.f39762c;
                int i6 = dVar5 != null ? dVar5.f39767h : 0;
                if (dVar4 != null) {
                    i2 = dVar4.f39767h;
                }
                int i7 = i2 - i6;
                if (i7 == -1 || (i7 == 0 && !z)) {
                    rotateLeft(dVar);
                } else {
                    rotateRight(dVar3);
                    rotateLeft(dVar);
                }
                if (z) {
                    return;
                }
            } else if (i5 == 2) {
                d<K, V> dVar6 = dVar2.f39761b;
                d<K, V> dVar7 = dVar2.f39762c;
                int i8 = dVar7 != null ? dVar7.f39767h : 0;
                if (dVar6 != null) {
                    i2 = dVar6.f39767h;
                }
                int i9 = i2 - i8;
                if (i9 == 1 || (i9 == 0 && !z)) {
                    rotateRight(dVar);
                } else {
                    rotateLeft(dVar2);
                    rotateRight(dVar);
                }
                if (z) {
                    return;
                }
            } else if (i5 == 0) {
                dVar.f39767h = i3 + 1;
                if (z) {
                    return;
                }
            } else {
                dVar.f39767h = Math.max(i3, i4) + 1;
                if (!z) {
                    return;
                }
            }
            dVar = dVar.f39760a;
        }
    }

    private void rotateLeft(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f39761b;
        d<K, V> dVar3 = dVar.f39762c;
        d<K, V> dVar4 = dVar3.f39761b;
        d<K, V> dVar5 = dVar3.f39762c;
        dVar.f39762c = dVar4;
        if (dVar4 != null) {
            dVar4.f39760a = dVar;
        }
        replaceInParent(dVar, dVar3);
        dVar3.f39761b = dVar;
        dVar.f39760a = dVar3;
        int i2 = 0;
        dVar.f39767h = Math.max(dVar2 != null ? dVar2.f39767h : 0, dVar4 != null ? dVar4.f39767h : 0) + 1;
        int i3 = dVar.f39767h;
        if (dVar5 != null) {
            i2 = dVar5.f39767h;
        }
        dVar3.f39767h = Math.max(i3, i2) + 1;
    }

    private void rotateRight(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f39761b;
        d<K, V> dVar3 = dVar.f39762c;
        d<K, V> dVar4 = dVar2.f39761b;
        d<K, V> dVar5 = dVar2.f39762c;
        dVar.f39761b = dVar5;
        if (dVar5 != null) {
            dVar5.f39760a = dVar;
        }
        replaceInParent(dVar, dVar2);
        dVar2.f39762c = dVar;
        dVar.f39760a = dVar2;
        int i2 = 0;
        dVar.f39767h = Math.max(dVar3 != null ? dVar3.f39767h : 0, dVar5 != null ? dVar5.f39767h : 0) + 1;
        int i3 = dVar.f39767h;
        if (dVar4 != null) {
            i2 = dVar4.f39767h;
        }
        dVar2.f39767h = Math.max(i3, i2) + 1;
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        g<K, V>.defpackage.a aVar = this.entrySet;
        if (aVar != null) {
            return aVar;
        }
        g<K, V>.defpackage.a aVar2 = new a();
        this.entrySet = aVar2;
        return aVar2;
    }

    public final Set<K> keySet() {
        g<K, V>.defpackage.b bVar = this.keySet;
        if (bVar != null) {
            return bVar;
        }
        g<K, V>.defpackage.b bVar2 = new b();
        this.keySet = bVar2;
        return bVar2;
    }

    static final class d<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        d<K, V> f39760a;

        /* renamed from: b  reason: collision with root package name */
        d<K, V> f39761b;

        /* renamed from: c  reason: collision with root package name */
        d<K, V> f39762c;

        /* renamed from: d  reason: collision with root package name */
        d<K, V> f39763d;

        /* renamed from: e  reason: collision with root package name */
        d<K, V> f39764e;

        /* renamed from: f  reason: collision with root package name */
        final K f39765f;

        /* renamed from: g  reason: collision with root package name */
        V f39766g;

        /* renamed from: h  reason: collision with root package name */
        int f39767h;

        d() {
            this.f39765f = null;
            this.f39764e = this;
            this.f39763d = this;
        }

        d(d<K, V> dVar, K k, d<K, V> dVar2, d<K, V> dVar3) {
            this.f39760a = dVar;
            this.f39765f = k;
            this.f39767h = 1;
            this.f39763d = dVar2;
            this.f39764e = dVar3;
            dVar3.f39763d = this;
            dVar2.f39764e = this;
        }

        public final K getKey() {
            return this.f39765f;
        }

        public final V getValue() {
            return this.f39766g;
        }

        public final V setValue(V v) {
            V v2 = this.f39766g;
            this.f39766g = v;
            return v2;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k = this.f39765f;
                if (k != null ? k.equals(entry.getKey()) : entry.getKey() == null) {
                    V v = this.f39766g;
                    Object value = entry.getValue();
                    if (v == null) {
                        if (value == null) {
                            return true;
                        }
                    } else if (v.equals(value)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final int hashCode() {
            K k = this.f39765f;
            int i2 = 0;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.f39766g;
            if (v != null) {
                i2 = v.hashCode();
            }
            return hashCode ^ i2;
        }

        public final String toString() {
            return this.f39765f + "=" + this.f39766g;
        }
    }

    abstract class c<T> implements Iterator<T> {

        /* renamed from: b  reason: collision with root package name */
        d<K, V> f39756b;

        /* renamed from: c  reason: collision with root package name */
        d<K, V> f39757c;

        /* renamed from: d  reason: collision with root package name */
        int f39758d;

        private c() {
            this.f39756b = g.this.header.f39763d;
            this.f39757c = null;
            this.f39758d = g.this.modCount;
        }

        /* synthetic */ c(g gVar, byte b2) {
            this();
        }

        public final boolean hasNext() {
            return this.f39756b != g.this.header;
        }

        /* access modifiers changed from: package-private */
        public final d<K, V> a() {
            d<K, V> dVar = this.f39756b;
            if (dVar == g.this.header) {
                throw new NoSuchElementException();
            } else if (g.this.modCount == this.f39758d) {
                this.f39756b = dVar.f39763d;
                this.f39757c = dVar;
                return dVar;
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public final void remove() {
            d<K, V> dVar = this.f39757c;
            if (dVar != null) {
                g.this.removeInternal(dVar, true);
                this.f39757c = null;
                this.f39758d = g.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    class a extends AbstractSet<Map.Entry<K, V>> {
        a() {
        }

        public final int size() {
            return g.this.size;
        }

        public final Iterator<Map.Entry<K, V>> iterator() {
            return new g<K, V>.c<Map.Entry<K, V>>() {
                {
                    g gVar = g.this;
                }

                public final /* synthetic */ Object next() {
                    return a();
                }
            };
        }

        public final boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && g.this.findByEntry((Map.Entry) obj) != null;
        }

        public final boolean remove(Object obj) {
            d findByEntry;
            if (!(obj instanceof Map.Entry) || (findByEntry = g.this.findByEntry((Map.Entry) obj)) == null) {
                return false;
            }
            g.this.removeInternal(findByEntry, true);
            return true;
        }

        public final void clear() {
            g.this.clear();
        }
    }

    class b extends AbstractSet<K> {
        b() {
        }

        public final int size() {
            return g.this.size;
        }

        public final Iterator<K> iterator() {
            return new g<K, V>.c<K>() {
                {
                    g gVar = g.this;
                }

                public final K next() {
                    return a().f39765f;
                }
            };
        }

        public final boolean contains(Object obj) {
            return g.this.containsKey(obj);
        }

        public final boolean remove(Object obj) {
            return g.this.removeInternalByKey(obj) != null;
        }

        public final void clear() {
            g.this.clear();
        }
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }
}
