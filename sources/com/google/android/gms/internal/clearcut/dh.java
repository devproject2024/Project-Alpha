package com.google.android.gms.internal.clearcut;

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

class dh<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    boolean f9286a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9287b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public List<Cdo> f9288c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Map<K, V> f9289d;

    /* renamed from: e  reason: collision with root package name */
    private volatile dq f9290e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Map<K, V> f9291f;

    /* renamed from: g  reason: collision with root package name */
    private volatile dk f9292g;

    private dh(int i2) {
        this.f9287b = i2;
        this.f9288c = Collections.emptyList();
        this.f9289d = Collections.emptyMap();
        this.f9291f = Collections.emptyMap();
    }

    /* synthetic */ dh(int i2, byte b2) {
        this(i2);
    }

    private final int a(K k) {
        int size = this.f9288c.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.f9288c.get(size).getKey());
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
            int compareTo2 = k.compareTo((Comparable) this.f9288c.get(i3).getKey());
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

    static <FieldDescriptorType extends az<FieldDescriptorType>> dh<FieldDescriptorType, Object> a(int i2) {
        return new di(i2);
    }

    /* access modifiers changed from: private */
    public final V c(int i2) {
        e();
        V value = this.f9288c.remove(i2).getValue();
        if (!this.f9289d.isEmpty()) {
            Iterator it2 = f().entrySet().iterator();
            this.f9288c.add(new Cdo(this, (Map.Entry) it2.next()));
            it2.remove();
        }
        return value;
    }

    /* access modifiers changed from: private */
    public final void e() {
        if (this.f9286a) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> f() {
        e();
        if (this.f9289d.isEmpty() && !(this.f9289d instanceof TreeMap)) {
            this.f9289d = new TreeMap();
            this.f9291f = ((TreeMap) this.f9289d).descendingMap();
        }
        return (SortedMap) this.f9289d;
    }

    /* renamed from: a */
    public final V put(K k, V v) {
        e();
        int a2 = a(k);
        if (a2 >= 0) {
            return this.f9288c.get(a2).setValue(v);
        }
        e();
        if (this.f9288c.isEmpty() && !(this.f9288c instanceof ArrayList)) {
            this.f9288c = new ArrayList(this.f9287b);
        }
        int i2 = -(a2 + 1);
        if (i2 >= this.f9287b) {
            return f().put(k, v);
        }
        int size = this.f9288c.size();
        int i3 = this.f9287b;
        if (size == i3) {
            Cdo remove = this.f9288c.remove(i3 - 1);
            f().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.f9288c.add(i2, new Cdo(this, k, v));
        return null;
    }

    public void a() {
        if (!this.f9286a) {
            this.f9289d = this.f9289d.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f9289d);
            this.f9291f = this.f9291f.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f9291f);
            this.f9286a = true;
        }
    }

    public final int b() {
        return this.f9288c.size();
    }

    public final Map.Entry<K, V> b(int i2) {
        return this.f9288c.get(i2);
    }

    public final Iterable<Map.Entry<K, V>> c() {
        return this.f9289d.isEmpty() ? dl.a() : this.f9289d.entrySet();
    }

    public void clear() {
        e();
        if (!this.f9288c.isEmpty()) {
            this.f9288c.clear();
        }
        if (!this.f9289d.isEmpty()) {
            this.f9289d.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f9289d.containsKey(comparable);
    }

    /* access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> d() {
        if (this.f9292g == null) {
            this.f9292g = new dk(this, (byte) 0);
        }
        return this.f9292g;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f9290e == null) {
            this.f9290e = new dq(this, (byte) 0);
        }
        return this.f9290e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dh)) {
            return super.equals(obj);
        }
        dh dhVar = (dh) obj;
        int size = size();
        if (size != dhVar.size()) {
            return false;
        }
        int b2 = b();
        if (b2 != dhVar.b()) {
            return entrySet().equals(dhVar.entrySet());
        }
        for (int i2 = 0; i2 < b2; i2++) {
            if (!b(i2).equals(dhVar.b(i2))) {
                return false;
            }
        }
        if (b2 != size) {
            return this.f9289d.equals(dhVar.f9289d);
        }
        return true;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        return a2 >= 0 ? this.f9288c.get(a2).getValue() : this.f9289d.get(comparable);
    }

    public int hashCode() {
        int b2 = b();
        int i2 = 0;
        for (int i3 = 0; i3 < b2; i3++) {
            i2 += this.f9288c.get(i3).hashCode();
        }
        return this.f9289d.size() > 0 ? i2 + this.f9289d.hashCode() : i2;
    }

    public V remove(Object obj) {
        e();
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return c(a2);
        }
        if (this.f9289d.isEmpty()) {
            return null;
        }
        return this.f9289d.remove(comparable);
    }

    public int size() {
        return this.f9288c.size() + this.f9289d.size();
    }
}
