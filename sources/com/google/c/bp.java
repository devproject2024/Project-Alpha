package com.google.c;

import com.google.c.w;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class bp<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    boolean f37777a;

    /* renamed from: b  reason: collision with root package name */
    private final int f37778b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public List<bp<K, V>.d> f37779c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Map<K, V> f37780d;

    /* renamed from: e  reason: collision with root package name */
    private volatile bp<K, V>.f f37781e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Map<K, V> f37782f;

    /* renamed from: g  reason: collision with root package name */
    private volatile bp<K, V>.defpackage.b f37783g;

    /* synthetic */ bp(int i2, byte b2) {
        this(i2);
    }

    static <FieldDescriptorType extends w.a<FieldDescriptorType>> bp<FieldDescriptorType, Object> a(int i2) {
        return new bp<FieldDescriptorType, Object>(i2) {
            public final /* synthetic */ Object put(Object obj, Object obj2) {
                return bp.super.put((w.a) obj, obj2);
            }

            public final void a() {
                if (!this.f37777a) {
                    for (int i2 = 0; i2 < b(); i2++) {
                        Map.Entry b2 = b(i2);
                        if (((w.a) b2.getKey()).d()) {
                            b2.setValue(Collections.unmodifiableList((List) b2.getValue()));
                        }
                    }
                    for (Map.Entry entry : c()) {
                        if (((w.a) entry.getKey()).d()) {
                            entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                        }
                    }
                }
                bp.super.a();
            }
        };
    }

    private bp(int i2) {
        this.f37778b = i2;
        this.f37779c = Collections.emptyList();
        this.f37780d = Collections.emptyMap();
        this.f37782f = Collections.emptyMap();
    }

    public void a() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.f37777a) {
            if (this.f37780d.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.f37780d);
            }
            this.f37780d = map;
            if (this.f37782f.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.f37782f);
            }
            this.f37782f = map2;
            this.f37777a = true;
        }
    }

    public final int b() {
        return this.f37779c.size();
    }

    public final Map.Entry<K, V> b(int i2) {
        return this.f37779c.get(i2);
    }

    public final Iterable<Map.Entry<K, V>> c() {
        if (this.f37780d.isEmpty()) {
            return c.a();
        }
        return this.f37780d.entrySet();
    }

    public int size() {
        return this.f37779c.size() + this.f37780d.size();
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f37780d.containsKey(comparable);
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return this.f37779c.get(a2).getValue();
        }
        return this.f37780d.get(comparable);
    }

    /* renamed from: a */
    public final V put(K k, V v) {
        e();
        int a2 = a(k);
        if (a2 >= 0) {
            return this.f37779c.get(a2).setValue(v);
        }
        g();
        int i2 = -(a2 + 1);
        if (i2 >= this.f37778b) {
            return f().put(k, v);
        }
        int size = this.f37779c.size();
        int i3 = this.f37778b;
        if (size == i3) {
            d remove = this.f37779c.remove(i3 - 1);
            f().put(remove.f37790a, remove.getValue());
        }
        this.f37779c.add(i2, new d(k, v));
        return null;
    }

    public void clear() {
        e();
        if (!this.f37779c.isEmpty()) {
            this.f37779c.clear();
        }
        if (!this.f37780d.isEmpty()) {
            this.f37780d.clear();
        }
    }

    public V remove(Object obj) {
        e();
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return c(a2);
        }
        if (this.f37780d.isEmpty()) {
            return null;
        }
        return this.f37780d.remove(comparable);
    }

    /* access modifiers changed from: private */
    public V c(int i2) {
        e();
        V value = this.f37779c.remove(i2).getValue();
        if (!this.f37780d.isEmpty()) {
            Iterator it2 = f().entrySet().iterator();
            this.f37779c.add(new d(this, (Map.Entry) it2.next()));
            it2.remove();
        }
        return value;
    }

    private int a(K k) {
        int size = this.f37779c.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo(this.f37779c.get(size).f37790a);
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
            int compareTo2 = k.compareTo(this.f37779c.get(i3).f37790a);
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
        if (this.f37781e == null) {
            this.f37781e = new f(this, (byte) 0);
        }
        return this.f37781e;
    }

    /* access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> d() {
        if (this.f37783g == null) {
            this.f37783g = new b(this, (byte) 0);
        }
        return this.f37783g;
    }

    /* access modifiers changed from: private */
    public void e() {
        if (this.f37777a) {
            throw new UnsupportedOperationException();
        }
    }

    private SortedMap<K, V> f() {
        e();
        if (this.f37780d.isEmpty() && !(this.f37780d instanceof TreeMap)) {
            this.f37780d = new TreeMap();
            this.f37782f = ((TreeMap) this.f37780d).descendingMap();
        }
        return (SortedMap) this.f37780d;
    }

    private void g() {
        e();
        if (this.f37779c.isEmpty() && !(this.f37779c instanceof ArrayList)) {
            this.f37779c = new ArrayList(this.f37778b);
        }
    }

    class d implements Comparable<bp<K, V>.d>, Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f37790a;

        /* renamed from: c  reason: collision with root package name */
        private V f37792c;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return this.f37790a.compareTo(((d) obj).f37790a);
        }

        d(bp bpVar, Map.Entry<K, V> entry) {
            this((Comparable) entry.getKey(), entry.getValue());
        }

        d(K k, V v) {
            this.f37790a = k;
            this.f37792c = v;
        }

        public final V getValue() {
            return this.f37792c;
        }

        public final V setValue(V v) {
            bp.this.e();
            V v2 = this.f37792c;
            this.f37792c = v;
            return v2;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a(this.f37790a, entry.getKey()) && a(this.f37792c, entry.getValue());
        }

        public final int hashCode() {
            K k = this.f37790a;
            int i2 = 0;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.f37792c;
            if (v != null) {
                i2 = v.hashCode();
            }
            return hashCode ^ i2;
        }

        public final String toString() {
            return this.f37790a + "=" + this.f37792c;
        }

        private static boolean a(Object obj, Object obj2) {
            if (obj == null) {
                return obj2 == null;
            }
            return obj.equals(obj2);
        }

        public final /* bridge */ /* synthetic */ Object getKey() {
            return this.f37790a;
        }
    }

    class f extends AbstractSet<Map.Entry<K, V>> {
        private f() {
        }

        /* synthetic */ f(bp bpVar, byte b2) {
            this();
        }

        public /* synthetic */ boolean add(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (contains(entry)) {
                return false;
            }
            bp.this.put((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new e(bp.this, (byte) 0);
        }

        public int size() {
            return bp.this.size();
        }

        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = bp.this.get(entry.getKey());
            Object value = entry.getValue();
            if (obj2 != value) {
                return obj2 != null && obj2.equals(value);
            }
            return true;
        }

        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            bp.this.remove(entry.getKey());
            return true;
        }

        public void clear() {
            bp.this.clear();
        }
    }

    class b extends bp<K, V>.f {
        private b() {
            super(bp.this, (byte) 0);
        }

        /* synthetic */ b(bp bpVar, byte b2) {
            this();
        }

        public final Iterator<Map.Entry<K, V>> iterator() {
            return new a(bp.this, (byte) 0);
        }
    }

    class e implements Iterator<Map.Entry<K, V>> {

        /* renamed from: b  reason: collision with root package name */
        private int f37794b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f37795c;

        /* renamed from: d  reason: collision with root package name */
        private Iterator<Map.Entry<K, V>> f37796d;

        private e() {
            this.f37794b = -1;
        }

        /* synthetic */ e(bp bpVar, byte b2) {
            this();
        }

        public final boolean hasNext() {
            if (this.f37794b + 1 < bp.this.f37779c.size() || (!bp.this.f37780d.isEmpty() && a().hasNext())) {
                return true;
            }
            return false;
        }

        public final void remove() {
            if (this.f37795c) {
                this.f37795c = false;
                bp.this.e();
                if (this.f37794b < bp.this.f37779c.size()) {
                    bp bpVar = bp.this;
                    int i2 = this.f37794b;
                    this.f37794b = i2 - 1;
                    Object unused = bpVar.c(i2);
                    return;
                }
                a().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }

        private Iterator<Map.Entry<K, V>> a() {
            if (this.f37796d == null) {
                this.f37796d = bp.this.f37780d.entrySet().iterator();
            }
            return this.f37796d;
        }

        public final /* synthetic */ Object next() {
            this.f37795c = true;
            int i2 = this.f37794b + 1;
            this.f37794b = i2;
            if (i2 < bp.this.f37779c.size()) {
                return (Map.Entry) bp.this.f37779c.get(this.f37794b);
            }
            return (Map.Entry) a().next();
        }
    }

    class a implements Iterator<Map.Entry<K, V>> {

        /* renamed from: b  reason: collision with root package name */
        private int f37785b;

        /* renamed from: c  reason: collision with root package name */
        private Iterator<Map.Entry<K, V>> f37786c;

        private a() {
            this.f37785b = bp.this.f37779c.size();
        }

        /* synthetic */ a(bp bpVar, byte b2) {
            this();
        }

        public final boolean hasNext() {
            int i2 = this.f37785b;
            return (i2 > 0 && i2 <= bp.this.f37779c.size()) || a().hasNext();
        }

        public final void remove() {
            throw new UnsupportedOperationException();
        }

        private Iterator<Map.Entry<K, V>> a() {
            if (this.f37786c == null) {
                this.f37786c = bp.this.f37782f.entrySet().iterator();
            }
            return this.f37786c;
        }

        public final /* synthetic */ Object next() {
            if (a().hasNext()) {
                return (Map.Entry) a().next();
            }
            List b2 = bp.this.f37779c;
            int i2 = this.f37785b - 1;
            this.f37785b = i2;
            return (Map.Entry) b2.get(i2);
        }
    }

    static class c {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final Iterator<Object> f37788a = new Iterator<Object>() {
            public final boolean hasNext() {
                return false;
            }

            public final Object next() {
                throw new NoSuchElementException();
            }

            public final void remove() {
                throw new UnsupportedOperationException();
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private static final Iterable<Object> f37789b = new Iterable<Object>() {
            public final Iterator<Object> iterator() {
                return c.f37788a;
            }
        };

        static <T> Iterable<T> a() {
            return f37789b;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bp)) {
            return super.equals(obj);
        }
        bp bpVar = (bp) obj;
        int size = size();
        if (size != bpVar.size()) {
            return false;
        }
        int b2 = b();
        if (b2 != bpVar.b()) {
            return entrySet().equals(bpVar.entrySet());
        }
        for (int i2 = 0; i2 < b2; i2++) {
            if (!b(i2).equals(bpVar.b(i2))) {
                return false;
            }
        }
        if (b2 != size) {
            return this.f37780d.equals(bpVar.f37780d);
        }
        return true;
    }

    public int hashCode() {
        int b2 = b();
        int i2 = 0;
        for (int i3 = 0; i3 < b2; i3++) {
            i2 += this.f37779c.get(i3).hashCode();
        }
        return this.f37780d.size() > 0 ? i2 + this.f37780d.hashCode() : i2;
    }
}
