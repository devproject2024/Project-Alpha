package com.google.android.gms.internal.measurement;

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

class ga<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    boolean f10677a;

    /* renamed from: b  reason: collision with root package name */
    private final int f10678b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public List<gf> f10679c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Map<K, V> f10680d;

    /* renamed from: e  reason: collision with root package name */
    private volatile gh f10681e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Map<K, V> f10682f;

    /* renamed from: g  reason: collision with root package name */
    private volatile gb f10683g;

    static <FieldDescriptorType extends dp<FieldDescriptorType>> ga<FieldDescriptorType, Object> a(int i2) {
        return new fz(i2);
    }

    private ga(int i2) {
        this.f10678b = i2;
        this.f10679c = Collections.emptyList();
        this.f10680d = Collections.emptyMap();
        this.f10682f = Collections.emptyMap();
    }

    public void a() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.f10677a) {
            if (this.f10680d.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.f10680d);
            }
            this.f10680d = map;
            if (this.f10682f.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.f10682f);
            }
            this.f10682f = map2;
            this.f10677a = true;
        }
    }

    public final int b() {
        return this.f10679c.size();
    }

    public final Map.Entry<K, V> b(int i2) {
        return this.f10679c.get(i2);
    }

    public final Iterable<Map.Entry<K, V>> c() {
        if (this.f10680d.isEmpty()) {
            return ge.a();
        }
        return this.f10680d.entrySet();
    }

    public int size() {
        return this.f10679c.size() + this.f10680d.size();
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f10680d.containsKey(comparable);
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return this.f10679c.get(a2).getValue();
        }
        return this.f10680d.get(comparable);
    }

    /* renamed from: a */
    public final V put(K k, V v) {
        e();
        int a2 = a(k);
        if (a2 >= 0) {
            return this.f10679c.get(a2).setValue(v);
        }
        e();
        if (this.f10679c.isEmpty() && !(this.f10679c instanceof ArrayList)) {
            this.f10679c = new ArrayList(this.f10678b);
        }
        int i2 = -(a2 + 1);
        if (i2 >= this.f10678b) {
            return f().put(k, v);
        }
        int size = this.f10679c.size();
        int i3 = this.f10678b;
        if (size == i3) {
            gf remove = this.f10679c.remove(i3 - 1);
            f().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.f10679c.add(i2, new gf(this, k, v));
        return null;
    }

    public void clear() {
        e();
        if (!this.f10679c.isEmpty()) {
            this.f10679c.clear();
        }
        if (!this.f10680d.isEmpty()) {
            this.f10680d.clear();
        }
    }

    public V remove(Object obj) {
        e();
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return c(a2);
        }
        if (this.f10680d.isEmpty()) {
            return null;
        }
        return this.f10680d.remove(comparable);
    }

    /* access modifiers changed from: private */
    public final V c(int i2) {
        e();
        V value = this.f10679c.remove(i2).getValue();
        if (!this.f10680d.isEmpty()) {
            Iterator it2 = f().entrySet().iterator();
            this.f10679c.add(new gf(this, (Map.Entry) it2.next()));
            it2.remove();
        }
        return value;
    }

    private final int a(K k) {
        int size = this.f10679c.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.f10679c.get(size).getKey());
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
            int compareTo2 = k.compareTo((Comparable) this.f10679c.get(i3).getKey());
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
        if (this.f10681e == null) {
            this.f10681e = new gh(this, (byte) 0);
        }
        return this.f10681e;
    }

    /* access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> d() {
        if (this.f10683g == null) {
            this.f10683g = new gb(this, (byte) 0);
        }
        return this.f10683g;
    }

    /* access modifiers changed from: private */
    public final void e() {
        if (this.f10677a) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> f() {
        e();
        if (this.f10680d.isEmpty() && !(this.f10680d instanceof TreeMap)) {
            this.f10680d = new TreeMap();
            this.f10682f = ((TreeMap) this.f10680d).descendingMap();
        }
        return (SortedMap) this.f10680d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ga)) {
            return super.equals(obj);
        }
        ga gaVar = (ga) obj;
        int size = size();
        if (size != gaVar.size()) {
            return false;
        }
        int b2 = b();
        if (b2 != gaVar.b()) {
            return entrySet().equals(gaVar.entrySet());
        }
        for (int i2 = 0; i2 < b2; i2++) {
            if (!b(i2).equals(gaVar.b(i2))) {
                return false;
            }
        }
        if (b2 != size) {
            return this.f10680d.equals(gaVar.f10680d);
        }
        return true;
    }

    public int hashCode() {
        int b2 = b();
        int i2 = 0;
        for (int i3 = 0; i3 < b2; i3++) {
            i2 += this.f10679c.get(i3).hashCode();
        }
        return this.f10680d.size() > 0 ? i2 + this.f10680d.hashCode() : i2;
    }

    /* synthetic */ ga(int i2, byte b2) {
        this(i2);
    }
}
