package com.sendbird.android.shadow.com.google.gson.internal;

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

public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> NATURAL_ORDER = new Comparator<Comparable>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo((Comparable) obj2);
        }
    };
    Comparator<? super K> comparator;
    private LinkedTreeMap<K, V>.defpackage.a entrySet;
    final d<K, V> header;
    private LinkedTreeMap<K, V>.defpackage.b keySet;
    int modCount;
    d<K, V> root;
    int size;

    public LinkedTreeMap() {
        this(NATURAL_ORDER);
    }

    public LinkedTreeMap(Comparator<? super K> comparator2) {
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
            return findByObject.f44932g;
        }
        return null;
    }

    public final boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    public final V put(K k, V v) {
        if (k != null) {
            d find = find(k, true);
            V v2 = find.f44932g;
            find.f44932g = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    public final void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        d<K, V> dVar = this.header;
        dVar.f44930e = dVar;
        dVar.f44929d = dVar;
    }

    public final V remove(Object obj) {
        d removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return removeInternalByKey.f44932g;
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
                if (comparable != null) {
                    i2 = comparable.compareTo(dVar3.f44931f);
                } else {
                    i2 = comparator2.compare(k, dVar3.f44931f);
                }
                if (i2 != 0) {
                    if (i2 < 0) {
                        dVar2 = dVar3.f44927b;
                    } else {
                        dVar2 = dVar3.f44928c;
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
            dVar = new d<>(dVar3, k, dVar4, dVar4.f44930e);
            if (i2 < 0) {
                dVar3.f44927b = dVar;
            } else {
                dVar3.f44928c = dVar;
            }
            rebalance(dVar3, true);
        } else if (comparator2 != NATURAL_ORDER || (k instanceof Comparable)) {
            dVar = new d<>(dVar3, k, dVar4, dVar4.f44930e);
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
        if (findByObject != null && equal(findByObject.f44932g, entry.getValue())) {
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
            dVar.f44930e.f44929d = dVar.f44929d;
            dVar.f44929d.f44930e = dVar.f44930e;
        }
        d<K, V> dVar2 = dVar.f44927b;
        d<K, V> dVar3 = dVar.f44928c;
        d<K, V> dVar4 = dVar.f44926a;
        int i3 = 0;
        if (dVar2 == null || dVar3 == null) {
            if (dVar2 != null) {
                replaceInParent(dVar, dVar2);
                dVar.f44927b = null;
            } else if (dVar3 != null) {
                replaceInParent(dVar, dVar3);
                dVar.f44928c = null;
            } else {
                replaceInParent(dVar, (d<K, V>) null);
            }
            rebalance(dVar4, false);
            this.size--;
            this.modCount++;
            return;
        }
        if (dVar2.f44933h > dVar3.f44933h) {
            d<K, V> dVar5 = dVar2.f44928c;
            while (true) {
                d<K, V> dVar6 = dVar5;
                dVar3 = dVar2;
                dVar2 = dVar6;
                if (dVar2 == null) {
                    break;
                }
                dVar5 = dVar2.f44928c;
            }
        } else {
            while (true) {
                d<K, V> dVar7 = dVar3.f44927b;
                if (dVar7 == null) {
                    break;
                }
                dVar3 = dVar7;
            }
        }
        removeInternal(dVar3, false);
        d<K, V> dVar8 = dVar.f44927b;
        if (dVar8 != null) {
            i2 = dVar8.f44933h;
            dVar3.f44927b = dVar8;
            dVar8.f44926a = dVar3;
            dVar.f44927b = null;
        } else {
            i2 = 0;
        }
        d<K, V> dVar9 = dVar.f44928c;
        if (dVar9 != null) {
            i3 = dVar9.f44933h;
            dVar3.f44928c = dVar9;
            dVar9.f44926a = dVar3;
            dVar.f44928c = null;
        }
        dVar3.f44933h = Math.max(i2, i3) + 1;
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
        d<K, V> dVar3 = dVar.f44926a;
        dVar.f44926a = null;
        if (dVar2 != null) {
            dVar2.f44926a = dVar3;
        }
        if (dVar3 == null) {
            this.root = dVar2;
        } else if (dVar3.f44927b == dVar) {
            dVar3.f44927b = dVar2;
        } else {
            dVar3.f44928c = dVar2;
        }
    }

    private void rebalance(d<K, V> dVar, boolean z) {
        while (dVar != null) {
            d<K, V> dVar2 = dVar.f44927b;
            d<K, V> dVar3 = dVar.f44928c;
            int i2 = 0;
            int i3 = dVar2 != null ? dVar2.f44933h : 0;
            int i4 = dVar3 != null ? dVar3.f44933h : 0;
            int i5 = i3 - i4;
            if (i5 == -2) {
                d<K, V> dVar4 = dVar3.f44927b;
                d<K, V> dVar5 = dVar3.f44928c;
                int i6 = dVar5 != null ? dVar5.f44933h : 0;
                if (dVar4 != null) {
                    i2 = dVar4.f44933h;
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
                d<K, V> dVar6 = dVar2.f44927b;
                d<K, V> dVar7 = dVar2.f44928c;
                int i8 = dVar7 != null ? dVar7.f44933h : 0;
                if (dVar6 != null) {
                    i2 = dVar6.f44933h;
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
                dVar.f44933h = i3 + 1;
                if (z) {
                    return;
                }
            } else {
                dVar.f44933h = Math.max(i3, i4) + 1;
                if (!z) {
                    return;
                }
            }
            dVar = dVar.f44926a;
        }
    }

    private void rotateLeft(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f44927b;
        d<K, V> dVar3 = dVar.f44928c;
        d<K, V> dVar4 = dVar3.f44927b;
        d<K, V> dVar5 = dVar3.f44928c;
        dVar.f44928c = dVar4;
        if (dVar4 != null) {
            dVar4.f44926a = dVar;
        }
        replaceInParent(dVar, dVar3);
        dVar3.f44927b = dVar;
        dVar.f44926a = dVar3;
        int i2 = 0;
        dVar.f44933h = Math.max(dVar2 != null ? dVar2.f44933h : 0, dVar4 != null ? dVar4.f44933h : 0) + 1;
        int i3 = dVar.f44933h;
        if (dVar5 != null) {
            i2 = dVar5.f44933h;
        }
        dVar3.f44933h = Math.max(i3, i2) + 1;
    }

    private void rotateRight(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f44927b;
        d<K, V> dVar3 = dVar.f44928c;
        d<K, V> dVar4 = dVar2.f44927b;
        d<K, V> dVar5 = dVar2.f44928c;
        dVar.f44927b = dVar5;
        if (dVar5 != null) {
            dVar5.f44926a = dVar;
        }
        replaceInParent(dVar, dVar2);
        dVar2.f44928c = dVar;
        dVar.f44926a = dVar2;
        int i2 = 0;
        dVar.f44933h = Math.max(dVar3 != null ? dVar3.f44933h : 0, dVar5 != null ? dVar5.f44933h : 0) + 1;
        int i3 = dVar.f44933h;
        if (dVar4 != null) {
            i2 = dVar4.f44933h;
        }
        dVar2.f44933h = Math.max(i3, i2) + 1;
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        LinkedTreeMap<K, V>.defpackage.a aVar = this.entrySet;
        if (aVar != null) {
            return aVar;
        }
        LinkedTreeMap<K, V>.defpackage.a aVar2 = new a();
        this.entrySet = aVar2;
        return aVar2;
    }

    public final Set<K> keySet() {
        LinkedTreeMap<K, V>.defpackage.b bVar = this.keySet;
        if (bVar != null) {
            return bVar;
        }
        LinkedTreeMap<K, V>.defpackage.b bVar2 = new b();
        this.keySet = bVar2;
        return bVar2;
    }

    static final class d<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        d<K, V> f44926a;

        /* renamed from: b  reason: collision with root package name */
        d<K, V> f44927b;

        /* renamed from: c  reason: collision with root package name */
        d<K, V> f44928c;

        /* renamed from: d  reason: collision with root package name */
        d<K, V> f44929d;

        /* renamed from: e  reason: collision with root package name */
        d<K, V> f44930e;

        /* renamed from: f  reason: collision with root package name */
        final K f44931f;

        /* renamed from: g  reason: collision with root package name */
        V f44932g;

        /* renamed from: h  reason: collision with root package name */
        int f44933h;

        d() {
            this.f44931f = null;
            this.f44930e = this;
            this.f44929d = this;
        }

        d(d<K, V> dVar, K k, d<K, V> dVar2, d<K, V> dVar3) {
            this.f44926a = dVar;
            this.f44931f = k;
            this.f44933h = 1;
            this.f44929d = dVar2;
            this.f44930e = dVar3;
            dVar3.f44929d = this;
            dVar2.f44930e = this;
        }

        public final K getKey() {
            return this.f44931f;
        }

        public final V getValue() {
            return this.f44932g;
        }

        public final V setValue(V v) {
            V v2 = this.f44932g;
            this.f44932g = v;
            return v2;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k = this.f44931f;
                if (k != null ? k.equals(entry.getKey()) : entry.getKey() == null) {
                    V v = this.f44932g;
                    if (v == null) {
                        if (entry.getValue() == null) {
                            return true;
                        }
                    } else if (v.equals(entry.getValue())) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final int hashCode() {
            K k = this.f44931f;
            int i2 = 0;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.f44932g;
            if (v != null) {
                i2 = v.hashCode();
            }
            return hashCode ^ i2;
        }

        public final String toString() {
            return this.f44931f + "=" + this.f44932g;
        }
    }

    abstract class c<T> implements Iterator<T> {

        /* renamed from: b  reason: collision with root package name */
        d<K, V> f44922b = LinkedTreeMap.this.header.f44929d;

        /* renamed from: c  reason: collision with root package name */
        d<K, V> f44923c = null;

        /* renamed from: d  reason: collision with root package name */
        int f44924d = LinkedTreeMap.this.modCount;

        c() {
        }

        public final boolean hasNext() {
            return this.f44922b != LinkedTreeMap.this.header;
        }

        /* access modifiers changed from: package-private */
        public final d<K, V> a() {
            d<K, V> dVar = this.f44922b;
            if (dVar == LinkedTreeMap.this.header) {
                throw new NoSuchElementException();
            } else if (LinkedTreeMap.this.modCount == this.f44924d) {
                this.f44922b = dVar.f44929d;
                this.f44923c = dVar;
                return dVar;
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public final void remove() {
            d<K, V> dVar = this.f44923c;
            if (dVar != null) {
                LinkedTreeMap.this.removeInternal(dVar, true);
                this.f44923c = null;
                this.f44924d = LinkedTreeMap.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    class a extends AbstractSet<Map.Entry<K, V>> {
        a() {
        }

        public final int size() {
            return LinkedTreeMap.this.size;
        }

        public final Iterator<Map.Entry<K, V>> iterator() {
            return new LinkedTreeMap<K, V>.c<Map.Entry<K, V>>() {
                {
                    LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
                }

                public final /* synthetic */ Object next() {
                    return a();
                }
            };
        }

        public final boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedTreeMap.this.findByEntry((Map.Entry) obj) != null;
        }

        public final boolean remove(Object obj) {
            d findByEntry;
            if (!(obj instanceof Map.Entry) || (findByEntry = LinkedTreeMap.this.findByEntry((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedTreeMap.this.removeInternal(findByEntry, true);
            return true;
        }

        public final void clear() {
            LinkedTreeMap.this.clear();
        }
    }

    final class b extends AbstractSet<K> {
        b() {
        }

        public final int size() {
            return LinkedTreeMap.this.size;
        }

        public final Iterator<K> iterator() {
            return new LinkedTreeMap<K, V>.c<K>() {
                {
                    LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
                }

                public final K next() {
                    return a().f44931f;
                }
            };
        }

        public final boolean contains(Object obj) {
            return LinkedTreeMap.this.containsKey(obj);
        }

        public final boolean remove(Object obj) {
            return LinkedTreeMap.this.removeInternalByKey(obj) != null;
        }

        public final void clear() {
            LinkedTreeMap.this.clear();
        }
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }
}
