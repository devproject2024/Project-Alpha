package com.google.android.gms.internal.firebase_ml;

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

class il<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    boolean f9998a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9999b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public List<iq> f10000c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Map<K, V> f10001d;

    /* renamed from: e  reason: collision with root package name */
    private volatile is f10002e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Map<K, V> f10003f;

    /* renamed from: g  reason: collision with root package name */
    private volatile im f10004g;

    static <FieldDescriptorType extends gb<FieldDescriptorType>> il<FieldDescriptorType, Object> a(int i2) {
        return new ik(i2);
    }

    private il(int i2) {
        this.f9999b = i2;
        this.f10000c = Collections.emptyList();
        this.f10001d = Collections.emptyMap();
        this.f10003f = Collections.emptyMap();
    }

    public void a() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.f9998a) {
            if (this.f10001d.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.f10001d);
            }
            this.f10001d = map;
            if (this.f10003f.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.f10003f);
            }
            this.f10003f = map2;
            this.f9998a = true;
        }
    }

    public final int b() {
        return this.f10000c.size();
    }

    public final Map.Entry<K, V> b(int i2) {
        return this.f10000c.get(i2);
    }

    public final Iterable<Map.Entry<K, V>> c() {
        if (this.f10001d.isEmpty()) {
            return ip.a();
        }
        return this.f10001d.entrySet();
    }

    public int size() {
        return this.f10000c.size() + this.f10001d.size();
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f10001d.containsKey(comparable);
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return this.f10000c.get(a2).getValue();
        }
        return this.f10001d.get(comparable);
    }

    /* renamed from: a */
    public final V put(K k, V v) {
        e();
        int a2 = a(k);
        if (a2 >= 0) {
            return this.f10000c.get(a2).setValue(v);
        }
        e();
        if (this.f10000c.isEmpty() && !(this.f10000c instanceof ArrayList)) {
            this.f10000c = new ArrayList(this.f9999b);
        }
        int i2 = -(a2 + 1);
        if (i2 >= this.f9999b) {
            return f().put(k, v);
        }
        int size = this.f10000c.size();
        int i3 = this.f9999b;
        if (size == i3) {
            iq remove = this.f10000c.remove(i3 - 1);
            f().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.f10000c.add(i2, new iq(this, k, v));
        return null;
    }

    public void clear() {
        e();
        if (!this.f10000c.isEmpty()) {
            this.f10000c.clear();
        }
        if (!this.f10001d.isEmpty()) {
            this.f10001d.clear();
        }
    }

    public V remove(Object obj) {
        e();
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return c(a2);
        }
        if (this.f10001d.isEmpty()) {
            return null;
        }
        return this.f10001d.remove(comparable);
    }

    /* access modifiers changed from: private */
    public final V c(int i2) {
        e();
        V value = this.f10000c.remove(i2).getValue();
        if (!this.f10001d.isEmpty()) {
            Iterator it2 = f().entrySet().iterator();
            this.f10000c.add(new iq(this, (Map.Entry) it2.next()));
            it2.remove();
        }
        return value;
    }

    private final int a(K k) {
        int size = this.f10000c.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.f10000c.get(size).getKey());
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
            int compareTo2 = k.compareTo((Comparable) this.f10000c.get(i3).getKey());
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
        if (this.f10002e == null) {
            this.f10002e = new is(this, (byte) 0);
        }
        return this.f10002e;
    }

    /* access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> d() {
        if (this.f10004g == null) {
            this.f10004g = new im(this, (byte) 0);
        }
        return this.f10004g;
    }

    /* access modifiers changed from: private */
    public final void e() {
        if (this.f9998a) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> f() {
        e();
        if (this.f10001d.isEmpty() && !(this.f10001d instanceof TreeMap)) {
            this.f10001d = new TreeMap();
            this.f10003f = ((TreeMap) this.f10001d).descendingMap();
        }
        return (SortedMap) this.f10001d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof il)) {
            return super.equals(obj);
        }
        il ilVar = (il) obj;
        int size = size();
        if (size != ilVar.size()) {
            return false;
        }
        int b2 = b();
        if (b2 != ilVar.b()) {
            return entrySet().equals(ilVar.entrySet());
        }
        for (int i2 = 0; i2 < b2; i2++) {
            if (!b(i2).equals(ilVar.b(i2))) {
                return false;
            }
        }
        if (b2 != size) {
            return this.f10001d.equals(ilVar.f10001d);
        }
        return true;
    }

    public int hashCode() {
        int b2 = b();
        int i2 = 0;
        for (int i3 = 0; i3 < b2; i3++) {
            i2 += this.f10000c.get(i3).hashCode();
        }
        return this.f10001d.size() > 0 ? i2 + this.f10001d.hashCode() : i2;
    }

    /* synthetic */ il(int i2, byte b2) {
        this(i2);
    }
}
