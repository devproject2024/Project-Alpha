package com.google.android.gms.internal.p001firebaseperf;

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

/* renamed from: com.google.android.gms.internal.firebase-perf.fq  reason: invalid package */
class fq<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    boolean f9637a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9638b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public List<fz> f9639c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Map<K, V> f9640d;

    /* renamed from: e  reason: collision with root package name */
    private volatile ga f9641e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Map<K, V> f9642f;

    /* renamed from: g  reason: collision with root package name */
    private volatile fv f9643g;

    static <FieldDescriptorType extends dk<FieldDescriptorType>> fq<FieldDescriptorType, Object> a(int i2) {
        return new ft(i2);
    }

    private fq(int i2) {
        this.f9638b = i2;
        this.f9639c = Collections.emptyList();
        this.f9640d = Collections.emptyMap();
        this.f9642f = Collections.emptyMap();
    }

    public void a() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.f9637a) {
            if (this.f9640d.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.f9640d);
            }
            this.f9640d = map;
            if (this.f9642f.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.f9642f);
            }
            this.f9642f = map2;
            this.f9637a = true;
        }
    }

    public final int b() {
        return this.f9639c.size();
    }

    public final Map.Entry<K, V> b(int i2) {
        return this.f9639c.get(i2);
    }

    public final Iterable<Map.Entry<K, V>> c() {
        if (this.f9640d.isEmpty()) {
            return fu.a();
        }
        return this.f9640d.entrySet();
    }

    public int size() {
        return this.f9639c.size() + this.f9640d.size();
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f9640d.containsKey(comparable);
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return this.f9639c.get(a2).getValue();
        }
        return this.f9640d.get(comparable);
    }

    /* renamed from: a */
    public final V put(K k, V v) {
        e();
        int a2 = a(k);
        if (a2 >= 0) {
            return this.f9639c.get(a2).setValue(v);
        }
        e();
        if (this.f9639c.isEmpty() && !(this.f9639c instanceof ArrayList)) {
            this.f9639c = new ArrayList(this.f9638b);
        }
        int i2 = -(a2 + 1);
        if (i2 >= this.f9638b) {
            return f().put(k, v);
        }
        int size = this.f9639c.size();
        int i3 = this.f9638b;
        if (size == i3) {
            fz remove = this.f9639c.remove(i3 - 1);
            f().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.f9639c.add(i2, new fz(this, k, v));
        return null;
    }

    public void clear() {
        e();
        if (!this.f9639c.isEmpty()) {
            this.f9639c.clear();
        }
        if (!this.f9640d.isEmpty()) {
            this.f9640d.clear();
        }
    }

    public V remove(Object obj) {
        e();
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return c(a2);
        }
        if (this.f9640d.isEmpty()) {
            return null;
        }
        return this.f9640d.remove(comparable);
    }

    /* access modifiers changed from: private */
    public final V c(int i2) {
        e();
        V value = this.f9639c.remove(i2).getValue();
        if (!this.f9640d.isEmpty()) {
            Iterator it2 = f().entrySet().iterator();
            this.f9639c.add(new fz(this, (Map.Entry) it2.next()));
            it2.remove();
        }
        return value;
    }

    private final int a(K k) {
        int size = this.f9639c.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.f9639c.get(size).getKey());
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
            int compareTo2 = k.compareTo((Comparable) this.f9639c.get(i3).getKey());
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
        if (this.f9641e == null) {
            this.f9641e = new ga(this, (byte) 0);
        }
        return this.f9641e;
    }

    /* access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> d() {
        if (this.f9643g == null) {
            this.f9643g = new fv(this, (byte) 0);
        }
        return this.f9643g;
    }

    /* access modifiers changed from: private */
    public final void e() {
        if (this.f9637a) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> f() {
        e();
        if (this.f9640d.isEmpty() && !(this.f9640d instanceof TreeMap)) {
            this.f9640d = new TreeMap();
            this.f9642f = ((TreeMap) this.f9640d).descendingMap();
        }
        return (SortedMap) this.f9640d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fq)) {
            return super.equals(obj);
        }
        fq fqVar = (fq) obj;
        int size = size();
        if (size != fqVar.size()) {
            return false;
        }
        int b2 = b();
        if (b2 != fqVar.b()) {
            return entrySet().equals(fqVar.entrySet());
        }
        for (int i2 = 0; i2 < b2; i2++) {
            if (!b(i2).equals(fqVar.b(i2))) {
                return false;
            }
        }
        if (b2 != size) {
            return this.f9640d.equals(fqVar.f9640d);
        }
        return true;
    }

    public int hashCode() {
        int b2 = b();
        int i2 = 0;
        for (int i3 = 0; i3 < b2; i3++) {
            i2 += this.f9639c.get(i3).hashCode();
        }
        return this.f9640d.size() > 0 ? i2 + this.f9640d.hashCode() : i2;
    }

    /* synthetic */ fq(int i2, byte b2) {
        this(i2);
    }
}
