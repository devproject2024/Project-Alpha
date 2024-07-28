package com.sendbird.android.shadow.com.google.gson.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> NATURAL_ORDER = new Comparator<Comparable>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo((Comparable) obj2);
        }
    };
    Comparator<? super K> comparator;
    private LinkedHashTreeMap<K, V>.c entrySet;
    final f<K, V> header;
    private LinkedHashTreeMap<K, V>.d keySet;
    int modCount;
    int size;
    f<K, V>[] table;
    int threshold;

    private static int secondaryHash(int i2) {
        int i3 = i2 ^ ((i2 >>> 20) ^ (i2 >>> 12));
        return (i3 >>> 4) ^ ((i3 >>> 7) ^ i3);
    }

    public LinkedHashTreeMap() {
        this(NATURAL_ORDER);
    }

    public LinkedHashTreeMap(Comparator<? super K> comparator2) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator2 == null ? NATURAL_ORDER : comparator2;
        this.header = new f<>();
        this.table = new f[16];
        f<K, V>[] fVarArr = this.table;
        this.threshold = (fVarArr.length / 2) + (fVarArr.length / 4);
    }

    public final int size() {
        return this.size;
    }

    public final V get(Object obj) {
        f findByObject = findByObject(obj);
        if (findByObject != null) {
            return findByObject.f44916h;
        }
        return null;
    }

    public final boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    public final V put(K k, V v) {
        if (k != null) {
            f find = find(k, true);
            V v2 = find.f44916h;
            find.f44916h = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    public final void clear() {
        Arrays.fill(this.table, (Object) null);
        this.size = 0;
        this.modCount++;
        f<K, V> fVar = this.header;
        f<K, V> fVar2 = fVar.f44912d;
        while (fVar2 != fVar) {
            f<K, V> fVar3 = fVar2.f44912d;
            fVar2.f44913e = null;
            fVar2.f44912d = null;
            fVar2 = fVar3;
        }
        fVar.f44913e = fVar;
        fVar.f44912d = fVar;
    }

    public final V remove(Object obj) {
        f removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return removeInternalByKey.f44916h;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final f<K, V> find(K k, boolean z) {
        int i2;
        f<K, V> fVar;
        f<K, V> fVar2;
        int i3;
        f<K, V> fVar3;
        Comparator<? super K> comparator2 = this.comparator;
        f<K, V>[] fVarArr = this.table;
        int secondaryHash = secondaryHash(k.hashCode());
        int length = (fVarArr.length - 1) & secondaryHash;
        f<K, V> fVar4 = fVarArr[length];
        if (fVar4 != null) {
            Comparable comparable = comparator2 == NATURAL_ORDER ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    i3 = comparable.compareTo(fVar4.f44914f);
                } else {
                    i3 = comparator2.compare(k, fVar4.f44914f);
                }
                if (i3 != 0) {
                    if (i3 < 0) {
                        fVar3 = fVar4.f44910b;
                    } else {
                        fVar3 = fVar4.f44911c;
                    }
                    if (fVar3 == null) {
                        fVar = fVar4;
                        i2 = i3;
                        break;
                    }
                    fVar4 = fVar3;
                } else {
                    return fVar4;
                }
            }
        } else {
            fVar = fVar4;
            i2 = 0;
        }
        if (!z) {
            return null;
        }
        f<K, V> fVar5 = this.header;
        if (fVar != null) {
            fVar2 = new f<>(fVar, k, secondaryHash, fVar5, fVar5.f44913e);
            if (i2 < 0) {
                fVar.f44910b = fVar2;
            } else {
                fVar.f44911c = fVar2;
            }
            rebalance(fVar, true);
        } else if (comparator2 != NATURAL_ORDER || (k instanceof Comparable)) {
            fVar2 = new f<>(fVar, k, secondaryHash, fVar5, fVar5.f44913e);
            fVarArr[length] = fVar2;
        } else {
            throw new ClassCastException(k.getClass().getName() + " is not Comparable");
        }
        int i4 = this.size;
        this.size = i4 + 1;
        if (i4 > this.threshold) {
            doubleCapacity();
        }
        this.modCount++;
        return fVar2;
    }

    /* access modifiers changed from: package-private */
    public final f<K, V> findByObject(Object obj) {
        if (obj != null) {
            try {
                return find(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final f<K, V> findByEntry(Map.Entry<?, ?> entry) {
        f<K, V> findByObject = findByObject(entry.getKey());
        if (findByObject != null && equal(findByObject.f44916h, entry.getValue())) {
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
    public final void removeInternal(f<K, V> fVar, boolean z) {
        int i2;
        if (z) {
            fVar.f44913e.f44912d = fVar.f44912d;
            fVar.f44912d.f44913e = fVar.f44913e;
            fVar.f44913e = null;
            fVar.f44912d = null;
        }
        f<K, V> fVar2 = fVar.f44910b;
        f<K, V> fVar3 = fVar.f44911c;
        f<K, V> fVar4 = fVar.f44909a;
        int i3 = 0;
        if (fVar2 == null || fVar3 == null) {
            if (fVar2 != null) {
                replaceInParent(fVar, fVar2);
                fVar.f44910b = null;
            } else if (fVar3 != null) {
                replaceInParent(fVar, fVar3);
                fVar.f44911c = null;
            } else {
                replaceInParent(fVar, (f<K, V>) null);
            }
            rebalance(fVar4, false);
            this.size--;
            this.modCount++;
            return;
        }
        if (fVar2.f44917i > fVar3.f44917i) {
            f<K, V> fVar5 = fVar2.f44911c;
            while (true) {
                f<K, V> fVar6 = fVar5;
                fVar3 = fVar2;
                fVar2 = fVar6;
                if (fVar2 == null) {
                    break;
                }
                fVar5 = fVar2.f44911c;
            }
        } else {
            while (true) {
                f<K, V> fVar7 = fVar3.f44910b;
                if (fVar7 == null) {
                    break;
                }
                fVar3 = fVar7;
            }
        }
        removeInternal(fVar3, false);
        f<K, V> fVar8 = fVar.f44910b;
        if (fVar8 != null) {
            i2 = fVar8.f44917i;
            fVar3.f44910b = fVar8;
            fVar8.f44909a = fVar3;
            fVar.f44910b = null;
        } else {
            i2 = 0;
        }
        f<K, V> fVar9 = fVar.f44911c;
        if (fVar9 != null) {
            i3 = fVar9.f44917i;
            fVar3.f44911c = fVar9;
            fVar9.f44909a = fVar3;
            fVar.f44911c = null;
        }
        fVar3.f44917i = Math.max(i2, i3) + 1;
        replaceInParent(fVar, fVar3);
    }

    /* access modifiers changed from: package-private */
    public final f<K, V> removeInternalByKey(Object obj) {
        f<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject, true);
        }
        return findByObject;
    }

    private void replaceInParent(f<K, V> fVar, f<K, V> fVar2) {
        f<K, V> fVar3 = fVar.f44909a;
        fVar.f44909a = null;
        if (fVar2 != null) {
            fVar2.f44909a = fVar3;
        }
        if (fVar3 == null) {
            int i2 = fVar.f44915g;
            f<K, V>[] fVarArr = this.table;
            fVarArr[i2 & (fVarArr.length - 1)] = fVar2;
        } else if (fVar3.f44910b == fVar) {
            fVar3.f44910b = fVar2;
        } else {
            fVar3.f44911c = fVar2;
        }
    }

    private void rebalance(f<K, V> fVar, boolean z) {
        while (fVar != null) {
            f<K, V> fVar2 = fVar.f44910b;
            f<K, V> fVar3 = fVar.f44911c;
            int i2 = 0;
            int i3 = fVar2 != null ? fVar2.f44917i : 0;
            int i4 = fVar3 != null ? fVar3.f44917i : 0;
            int i5 = i3 - i4;
            if (i5 == -2) {
                f<K, V> fVar4 = fVar3.f44910b;
                f<K, V> fVar5 = fVar3.f44911c;
                int i6 = fVar5 != null ? fVar5.f44917i : 0;
                if (fVar4 != null) {
                    i2 = fVar4.f44917i;
                }
                int i7 = i2 - i6;
                if (i7 == -1 || (i7 == 0 && !z)) {
                    rotateLeft(fVar);
                } else {
                    rotateRight(fVar3);
                    rotateLeft(fVar);
                }
                if (z) {
                    return;
                }
            } else if (i5 == 2) {
                f<K, V> fVar6 = fVar2.f44910b;
                f<K, V> fVar7 = fVar2.f44911c;
                int i8 = fVar7 != null ? fVar7.f44917i : 0;
                if (fVar6 != null) {
                    i2 = fVar6.f44917i;
                }
                int i9 = i2 - i8;
                if (i9 == 1 || (i9 == 0 && !z)) {
                    rotateRight(fVar);
                } else {
                    rotateLeft(fVar2);
                    rotateRight(fVar);
                }
                if (z) {
                    return;
                }
            } else if (i5 == 0) {
                fVar.f44917i = i3 + 1;
                if (z) {
                    return;
                }
            } else {
                fVar.f44917i = Math.max(i3, i4) + 1;
                if (!z) {
                    return;
                }
            }
            fVar = fVar.f44909a;
        }
    }

    private void rotateLeft(f<K, V> fVar) {
        f<K, V> fVar2 = fVar.f44910b;
        f<K, V> fVar3 = fVar.f44911c;
        f<K, V> fVar4 = fVar3.f44910b;
        f<K, V> fVar5 = fVar3.f44911c;
        fVar.f44911c = fVar4;
        if (fVar4 != null) {
            fVar4.f44909a = fVar;
        }
        replaceInParent(fVar, fVar3);
        fVar3.f44910b = fVar;
        fVar.f44909a = fVar3;
        int i2 = 0;
        fVar.f44917i = Math.max(fVar2 != null ? fVar2.f44917i : 0, fVar4 != null ? fVar4.f44917i : 0) + 1;
        int i3 = fVar.f44917i;
        if (fVar5 != null) {
            i2 = fVar5.f44917i;
        }
        fVar3.f44917i = Math.max(i3, i2) + 1;
    }

    private void rotateRight(f<K, V> fVar) {
        f<K, V> fVar2 = fVar.f44910b;
        f<K, V> fVar3 = fVar.f44911c;
        f<K, V> fVar4 = fVar2.f44910b;
        f<K, V> fVar5 = fVar2.f44911c;
        fVar.f44910b = fVar5;
        if (fVar5 != null) {
            fVar5.f44909a = fVar;
        }
        replaceInParent(fVar, fVar2);
        fVar2.f44911c = fVar;
        fVar.f44909a = fVar2;
        int i2 = 0;
        fVar.f44917i = Math.max(fVar3 != null ? fVar3.f44917i : 0, fVar5 != null ? fVar5.f44917i : 0) + 1;
        int i3 = fVar.f44917i;
        if (fVar4 != null) {
            i2 = fVar4.f44917i;
        }
        fVar2.f44917i = Math.max(i3, i2) + 1;
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        LinkedHashTreeMap<K, V>.c cVar = this.entrySet;
        if (cVar != null) {
            return cVar;
        }
        LinkedHashTreeMap<K, V>.c cVar2 = new c();
        this.entrySet = cVar2;
        return cVar2;
    }

    public final Set<K> keySet() {
        LinkedHashTreeMap<K, V>.d dVar = this.keySet;
        if (dVar != null) {
            return dVar;
        }
        LinkedHashTreeMap<K, V>.d dVar2 = new d();
        this.keySet = dVar2;
        return dVar2;
    }

    static final class f<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        f<K, V> f44909a;

        /* renamed from: b  reason: collision with root package name */
        f<K, V> f44910b;

        /* renamed from: c  reason: collision with root package name */
        f<K, V> f44911c;

        /* renamed from: d  reason: collision with root package name */
        f<K, V> f44912d;

        /* renamed from: e  reason: collision with root package name */
        f<K, V> f44913e;

        /* renamed from: f  reason: collision with root package name */
        final K f44914f;

        /* renamed from: g  reason: collision with root package name */
        final int f44915g;

        /* renamed from: h  reason: collision with root package name */
        V f44916h;

        /* renamed from: i  reason: collision with root package name */
        int f44917i;

        f() {
            this.f44914f = null;
            this.f44915g = -1;
            this.f44913e = this;
            this.f44912d = this;
        }

        f(f<K, V> fVar, K k, int i2, f<K, V> fVar2, f<K, V> fVar3) {
            this.f44909a = fVar;
            this.f44914f = k;
            this.f44915g = i2;
            this.f44917i = 1;
            this.f44912d = fVar2;
            this.f44913e = fVar3;
            fVar3.f44912d = this;
            fVar2.f44913e = this;
        }

        public final K getKey() {
            return this.f44914f;
        }

        public final V getValue() {
            return this.f44916h;
        }

        public final V setValue(V v) {
            V v2 = this.f44916h;
            this.f44916h = v;
            return v2;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k = this.f44914f;
                if (k != null ? k.equals(entry.getKey()) : entry.getKey() == null) {
                    V v = this.f44916h;
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
            K k = this.f44914f;
            int i2 = 0;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.f44916h;
            if (v != null) {
                i2 = v.hashCode();
            }
            return hashCode ^ i2;
        }

        public final String toString() {
            return this.f44914f + "=" + this.f44916h;
        }
    }

    private void doubleCapacity() {
        this.table = doubleCapacity(this.table);
        f<K, V>[] fVarArr = this.table;
        this.threshold = (fVarArr.length / 2) + (fVarArr.length / 4);
    }

    static <K, V> f<K, V>[] doubleCapacity(f<K, V>[] fVarArr) {
        int length = fVarArr.length;
        f<K, V>[] fVarArr2 = new f[(length * 2)];
        b bVar = new b();
        a aVar = new a();
        a aVar2 = new a();
        for (int i2 = 0; i2 < length; i2++) {
            f<K, V> fVar = fVarArr[i2];
            if (fVar != null) {
                bVar.a(fVar);
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    f a2 = bVar.a();
                    if (a2 == null) {
                        break;
                    } else if ((a2.f44915g & length) == 0) {
                        i3++;
                    } else {
                        i4++;
                    }
                }
                aVar.a(i3);
                aVar2.a(i4);
                bVar.a(fVar);
                while (true) {
                    f a3 = bVar.a();
                    if (a3 == null) {
                        break;
                    } else if ((a3.f44915g & length) == 0) {
                        aVar.a(a3);
                    } else {
                        aVar2.a(a3);
                    }
                }
                f<K, V> fVar2 = null;
                fVarArr2[i2] = i3 > 0 ? aVar.a() : null;
                int i5 = i2 + length;
                if (i4 > 0) {
                    fVar2 = aVar2.a();
                }
                fVarArr2[i5] = fVar2;
            }
        }
        return fVarArr2;
    }

    static class b<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private f<K, V> f44900a;

        b() {
        }

        /* access modifiers changed from: package-private */
        public final void a(f<K, V> fVar) {
            f<K, V> fVar2 = null;
            while (true) {
                f<K, V> fVar3 = fVar2;
                fVar2 = fVar;
                f<K, V> fVar4 = fVar3;
                if (fVar2 != null) {
                    fVar2.f44909a = fVar4;
                    fVar = fVar2.f44910b;
                } else {
                    this.f44900a = fVar4;
                    return;
                }
            }
        }

        public final f<K, V> a() {
            f<K, V> fVar = this.f44900a;
            if (fVar == null) {
                return null;
            }
            f<K, V> fVar2 = fVar.f44909a;
            fVar.f44909a = null;
            f<K, V> fVar3 = fVar.f44911c;
            while (true) {
                f<K, V> fVar4 = fVar2;
                fVar2 = fVar3;
                f<K, V> fVar5 = fVar4;
                if (fVar2 != null) {
                    fVar2.f44909a = fVar5;
                    fVar3 = fVar2.f44910b;
                } else {
                    this.f44900a = fVar5;
                    return fVar;
                }
            }
        }
    }

    static final class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private f<K, V> f44896a;

        /* renamed from: b  reason: collision with root package name */
        private int f44897b;

        /* renamed from: c  reason: collision with root package name */
        private int f44898c;

        /* renamed from: d  reason: collision with root package name */
        private int f44899d;

        a() {
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2) {
            this.f44897b = ((Integer.highestOneBit(i2) * 2) - 1) - i2;
            this.f44899d = 0;
            this.f44898c = 0;
            this.f44896a = null;
        }

        /* access modifiers changed from: package-private */
        public final void a(f<K, V> fVar) {
            fVar.f44911c = null;
            fVar.f44909a = null;
            fVar.f44910b = null;
            fVar.f44917i = 1;
            int i2 = this.f44897b;
            if (i2 > 0) {
                int i3 = this.f44899d;
                if ((i3 & 1) == 0) {
                    this.f44899d = i3 + 1;
                    this.f44897b = i2 - 1;
                    this.f44898c++;
                }
            }
            fVar.f44909a = this.f44896a;
            this.f44896a = fVar;
            this.f44899d++;
            int i4 = this.f44897b;
            if (i4 > 0) {
                int i5 = this.f44899d;
                if ((i5 & 1) == 0) {
                    this.f44899d = i5 + 1;
                    this.f44897b = i4 - 1;
                    this.f44898c++;
                }
            }
            int i6 = 4;
            while (true) {
                int i7 = i6 - 1;
                if ((this.f44899d & i7) == i7) {
                    int i8 = this.f44898c;
                    if (i8 == 0) {
                        f<K, V> fVar2 = this.f44896a;
                        f<K, V> fVar3 = fVar2.f44909a;
                        f<K, V> fVar4 = fVar3.f44909a;
                        fVar3.f44909a = fVar4.f44909a;
                        this.f44896a = fVar3;
                        fVar3.f44910b = fVar4;
                        fVar3.f44911c = fVar2;
                        fVar3.f44917i = fVar2.f44917i + 1;
                        fVar4.f44909a = fVar3;
                        fVar2.f44909a = fVar3;
                    } else if (i8 == 1) {
                        f<K, V> fVar5 = this.f44896a;
                        f<K, V> fVar6 = fVar5.f44909a;
                        this.f44896a = fVar6;
                        fVar6.f44911c = fVar5;
                        fVar6.f44917i = fVar5.f44917i + 1;
                        fVar5.f44909a = fVar6;
                        this.f44898c = 0;
                    } else if (i8 == 2) {
                        this.f44898c = 0;
                    }
                    i6 *= 2;
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final f<K, V> a() {
            f<K, V> fVar = this.f44896a;
            if (fVar.f44909a == null) {
                return fVar;
            }
            throw new IllegalStateException();
        }
    }

    abstract class e<T> implements Iterator<T> {

        /* renamed from: b  reason: collision with root package name */
        f<K, V> f44905b = LinkedHashTreeMap.this.header.f44912d;

        /* renamed from: c  reason: collision with root package name */
        f<K, V> f44906c = null;

        /* renamed from: d  reason: collision with root package name */
        int f44907d = LinkedHashTreeMap.this.modCount;

        e() {
        }

        public final boolean hasNext() {
            return this.f44905b != LinkedHashTreeMap.this.header;
        }

        /* access modifiers changed from: package-private */
        public final f<K, V> a() {
            f<K, V> fVar = this.f44905b;
            if (fVar == LinkedHashTreeMap.this.header) {
                throw new NoSuchElementException();
            } else if (LinkedHashTreeMap.this.modCount == this.f44907d) {
                this.f44905b = fVar.f44912d;
                this.f44906c = fVar;
                return fVar;
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public final void remove() {
            f<K, V> fVar = this.f44906c;
            if (fVar != null) {
                LinkedHashTreeMap.this.removeInternal(fVar, true);
                this.f44906c = null;
                this.f44907d = LinkedHashTreeMap.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    final class c extends AbstractSet<Map.Entry<K, V>> {
        c() {
        }

        public final int size() {
            return LinkedHashTreeMap.this.size;
        }

        public final Iterator<Map.Entry<K, V>> iterator() {
            return new LinkedHashTreeMap<K, V>.e<Map.Entry<K, V>>() {
                {
                    LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
                }

                public final /* synthetic */ Object next() {
                    return a();
                }
            };
        }

        public final boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedHashTreeMap.this.findByEntry((Map.Entry) obj) != null;
        }

        public final boolean remove(Object obj) {
            f findByEntry;
            if (!(obj instanceof Map.Entry) || (findByEntry = LinkedHashTreeMap.this.findByEntry((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedHashTreeMap.this.removeInternal(findByEntry, true);
            return true;
        }

        public final void clear() {
            LinkedHashTreeMap.this.clear();
        }
    }

    final class d extends AbstractSet<K> {
        d() {
        }

        public final int size() {
            return LinkedHashTreeMap.this.size;
        }

        public final Iterator<K> iterator() {
            return new LinkedHashTreeMap<K, V>.e<K>() {
                {
                    LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
                }

                public final K next() {
                    return a().f44914f;
                }
            };
        }

        public final boolean contains(Object obj) {
            return LinkedHashTreeMap.this.containsKey(obj);
        }

        public final boolean remove(Object obj) {
            return LinkedHashTreeMap.this.removeInternalByKey(obj) != null;
        }

        public final void clear() {
            LinkedHashTreeMap.this.clear();
        }
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }
}
