package com.google.android.gms.internal.icing;

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

class dw<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    boolean f10181a;

    /* renamed from: b  reason: collision with root package name */
    private final int f10182b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public List<eb> f10183c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Map<K, V> f10184d;

    /* renamed from: e  reason: collision with root package name */
    private volatile ed f10185e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Map<K, V> f10186f;

    /* renamed from: g  reason: collision with root package name */
    private volatile dx f10187g;

    static <FieldDescriptorType extends bs<FieldDescriptorType>> dw<FieldDescriptorType, Object> a(int i2) {
        return new dv(i2);
    }

    private dw(int i2) {
        this.f10182b = i2;
        this.f10183c = Collections.emptyList();
        this.f10184d = Collections.emptyMap();
        this.f10186f = Collections.emptyMap();
    }

    public void a() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.f10181a) {
            if (this.f10184d.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.f10184d);
            }
            this.f10184d = map;
            if (this.f10186f.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.f10186f);
            }
            this.f10186f = map2;
            this.f10181a = true;
        }
    }

    public final int b() {
        return this.f10183c.size();
    }

    public final Map.Entry<K, V> b(int i2) {
        return this.f10183c.get(i2);
    }

    public final Iterable<Map.Entry<K, V>> c() {
        if (this.f10184d.isEmpty()) {
            return ea.a();
        }
        return this.f10184d.entrySet();
    }

    public int size() {
        return this.f10183c.size() + this.f10184d.size();
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f10184d.containsKey(comparable);
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return this.f10183c.get(a2).getValue();
        }
        return this.f10184d.get(comparable);
    }

    /* renamed from: a */
    public final V put(K k, V v) {
        e();
        int a2 = a(k);
        if (a2 >= 0) {
            return this.f10183c.get(a2).setValue(v);
        }
        e();
        if (this.f10183c.isEmpty() && !(this.f10183c instanceof ArrayList)) {
            this.f10183c = new ArrayList(this.f10182b);
        }
        int i2 = -(a2 + 1);
        if (i2 >= this.f10182b) {
            return f().put(k, v);
        }
        int size = this.f10183c.size();
        int i3 = this.f10182b;
        if (size == i3) {
            eb remove = this.f10183c.remove(i3 - 1);
            f().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.f10183c.add(i2, new eb(this, k, v));
        return null;
    }

    public void clear() {
        e();
        if (!this.f10183c.isEmpty()) {
            this.f10183c.clear();
        }
        if (!this.f10184d.isEmpty()) {
            this.f10184d.clear();
        }
    }

    public V remove(Object obj) {
        e();
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return c(a2);
        }
        if (this.f10184d.isEmpty()) {
            return null;
        }
        return this.f10184d.remove(comparable);
    }

    /* access modifiers changed from: private */
    public final V c(int i2) {
        e();
        V value = this.f10183c.remove(i2).getValue();
        if (!this.f10184d.isEmpty()) {
            Iterator it2 = f().entrySet().iterator();
            this.f10183c.add(new eb(this, (Map.Entry) it2.next()));
            it2.remove();
        }
        return value;
    }

    private final int a(K k) {
        int size = this.f10183c.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.f10183c.get(size).getKey());
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
            int compareTo2 = k.compareTo((Comparable) this.f10183c.get(i3).getKey());
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
        if (this.f10185e == null) {
            this.f10185e = new ed(this, (byte) 0);
        }
        return this.f10185e;
    }

    /* access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> d() {
        if (this.f10187g == null) {
            this.f10187g = new dx(this, (byte) 0);
        }
        return this.f10187g;
    }

    /* access modifiers changed from: private */
    public final void e() {
        if (this.f10181a) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> f() {
        e();
        if (this.f10184d.isEmpty() && !(this.f10184d instanceof TreeMap)) {
            this.f10184d = new TreeMap();
            this.f10186f = ((TreeMap) this.f10184d).descendingMap();
        }
        return (SortedMap) this.f10184d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dw)) {
            return super.equals(obj);
        }
        dw dwVar = (dw) obj;
        int size = size();
        if (size != dwVar.size()) {
            return false;
        }
        int b2 = b();
        if (b2 != dwVar.b()) {
            return entrySet().equals(dwVar.entrySet());
        }
        for (int i2 = 0; i2 < b2; i2++) {
            if (!b(i2).equals(dwVar.b(i2))) {
                return false;
            }
        }
        if (b2 != size) {
            return this.f10184d.equals(dwVar.f10184d);
        }
        return true;
    }

    public int hashCode() {
        int b2 = b();
        int i2 = 0;
        for (int i3 = 0; i3 < b2; i3++) {
            i2 += this.f10183c.get(i3).hashCode();
        }
        return this.f10184d.size() > 0 ? i2 + this.f10184d.hashCode() : i2;
    }

    /* synthetic */ dw(int i2, byte b2) {
        this(i2);
    }
}
