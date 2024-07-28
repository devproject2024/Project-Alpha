package com.google.android.gms.internal.vision;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class gn<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    boolean f11183a;

    /* renamed from: b  reason: collision with root package name */
    private final int f11184b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public List<gt> f11185c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Map<K, V> f11186d;

    /* renamed from: e  reason: collision with root package name */
    private volatile gv f11187e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Map<K, V> f11188f;

    /* renamed from: g  reason: collision with root package name */
    private volatile go f11189g;

    static <FieldDescriptorType extends eb<FieldDescriptorType>> gn<FieldDescriptorType, Object> a(int i2) {
        return new gm(i2);
    }

    private gn(int i2) {
        this.f11184b = i2;
        this.f11185c = Collections.emptyList();
        this.f11186d = Collections.emptyMap();
        this.f11188f = Collections.emptyMap();
    }

    public void a() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.f11183a) {
            if (this.f11186d.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.f11186d);
            }
            this.f11186d = map;
            if (this.f11188f.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.f11188f);
            }
            this.f11188f = map2;
            this.f11183a = true;
        }
    }

    public final int b() {
        return this.f11185c.size();
    }

    public final Map.Entry<K, V> b(int i2) {
        return this.f11185c.get(i2);
    }

    public final Iterable<Map.Entry<K, V>> c() {
        if (this.f11186d.isEmpty()) {
            return gs.a();
        }
        return this.f11186d.entrySet();
    }

    public int size() {
        return this.f11185c.size() + this.f11186d.size();
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f11186d.containsKey(comparable);
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return this.f11185c.get(a2).getValue();
        }
        return this.f11186d.get(comparable);
    }

    /* renamed from: a */
    public final V put(K k, V v) {
        e();
        int a2 = a(k);
        if (a2 >= 0) {
            return this.f11185c.get(a2).setValue(v);
        }
        e();
        if (this.f11185c.isEmpty() && !(this.f11185c instanceof ArrayList)) {
            this.f11185c = new ArrayList(this.f11184b);
        }
        int i2 = -(a2 + 1);
        if (i2 >= this.f11184b) {
            return f().put(k, v);
        }
        int size = this.f11185c.size();
        int i3 = this.f11184b;
        if (size == i3) {
            gt remove = this.f11185c.remove(i3 - 1);
            f().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.f11185c.add(i2, new gt(this, k, v));
        return null;
    }

    public void clear() {
        e();
        if (!this.f11185c.isEmpty()) {
            this.f11185c.clear();
        }
        if (!this.f11186d.isEmpty()) {
            this.f11186d.clear();
        }
    }

    public V remove(Object obj) {
        e();
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return c(a2);
        }
        if (this.f11186d.isEmpty()) {
            return null;
        }
        return this.f11186d.remove(comparable);
    }

    /* access modifiers changed from: private */
    public final V c(int i2) {
        e();
        V value = this.f11185c.remove(i2).getValue();
        if (!this.f11186d.isEmpty()) {
            Iterator it2 = f().entrySet().iterator();
            this.f11185c.add(new gt(this, (Map.Entry) it2.next()));
            it2.remove();
        }
        return value;
    }

    private final int a(K k) {
        int size = this.f11185c.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.f11185c.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) / 2;
            int compareTo2 = k.compareTo((Comparable) this.f11185c.get(i3).getKey());
            if (compareTo2 < 0) {
                size = i3 - 1;
            } else if (compareTo2 <= 0) {
                return i3;
            } else {
                i2 = i3 + 1;
            }
        }
        return -(i2 + 1);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f11187e == null) {
            this.f11187e = new gv(this, (byte) 0);
        }
        return this.f11187e;
    }

    /* access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> d() {
        if (this.f11189g == null) {
            this.f11189g = new go(this, (byte) 0);
        }
        return this.f11189g;
    }

    /* access modifiers changed from: private */
    public final void e() {
        if (this.f11183a) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> f() {
        e();
        if (this.f11186d.isEmpty() && !(this.f11186d instanceof TreeMap)) {
            this.f11186d = new TreeMap();
            this.f11188f = ((TreeMap) this.f11186d).descendingMap();
        }
        return (SortedMap) this.f11186d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gn)) {
            return super.equals(obj);
        }
        gn gnVar = (gn) obj;
        int size = size();
        if (size != gnVar.size()) {
            return false;
        }
        int b2 = b();
        if (b2 != gnVar.b()) {
            return entrySet().equals(gnVar.entrySet());
        }
        for (int i2 = 0; i2 < b2; i2++) {
            if (!b(i2).equals(gnVar.b(i2))) {
                return false;
            }
        }
        if (b2 != size) {
            return this.f11186d.equals(gnVar.f11186d);
        }
        return true;
    }

    public int hashCode() {
        int b2 = b();
        int i2 = 0;
        for (int i3 = 0; i3 < b2; i3++) {
            i2 += this.f11185c.get(i3).hashCode();
        }
        return this.f11186d.size() > 0 ? i2 + this.f11186d.hashCode() : i2;
    }

    /* synthetic */ gn(int i2, byte b2) {
        this(i2);
    }
}
