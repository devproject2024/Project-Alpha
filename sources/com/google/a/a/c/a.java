package com.google.a.a.c;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class a<K, V> extends AbstractMap<K, V> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    int f7540a;

    /* renamed from: b  reason: collision with root package name */
    Object[] f7541b;

    public static <K, V> a<K, V> a() {
        return new a<>();
    }

    public final int size() {
        return this.f7540a;
    }

    public final V a(int i2) {
        if (i2 < 0 || i2 >= this.f7540a) {
            return null;
        }
        return c((i2 << 1) + 1);
    }

    public final V a(int i2, V v) {
        int i3 = this.f7540a;
        if (i2 < 0 || i2 >= i3) {
            throw new IndexOutOfBoundsException();
        }
        int i4 = (i2 << 1) + 1;
        V c2 = c(i4);
        this.f7541b[i4] = v;
        return c2;
    }

    public final boolean containsKey(Object obj) {
        return -2 != a(obj);
    }

    public final V get(Object obj) {
        return c(a(obj) + 1);
    }

    public final V remove(Object obj) {
        return b(a(obj));
    }

    private void a(int i2, K k, V v) {
        Object[] objArr = this.f7541b;
        objArr[i2] = k;
        objArr[i2 + 1] = v;
    }

    private V c(int i2) {
        if (i2 < 0) {
            return null;
        }
        return this.f7541b[i2];
    }

    private int a(Object obj) {
        int i2 = this.f7540a << 1;
        Object[] objArr = this.f7541b;
        int i3 = 0;
        while (i3 < i2) {
            Object obj2 = objArr[i3];
            if (obj == null) {
                if (obj2 != null) {
                    i3 += 2;
                }
            } else if (!obj.equals(obj2)) {
                i3 += 2;
            }
            return i3;
        }
        return -2;
    }

    /* access modifiers changed from: package-private */
    public final V b(int i2) {
        int i3 = this.f7540a << 1;
        if (i2 < 0 || i2 >= i3) {
            return null;
        }
        V c2 = c(i2 + 1);
        Object[] objArr = this.f7541b;
        int i4 = (i3 - i2) - 2;
        if (i4 != 0) {
            System.arraycopy(objArr, i2 + 2, objArr, i2, i4);
        }
        this.f7540a--;
        a(i3 - 2, (Object) null, (Object) null);
        return c2;
    }

    public void clear() {
        this.f7540a = 0;
        this.f7541b = null;
    }

    public final boolean containsValue(Object obj) {
        int i2 = this.f7540a << 1;
        Object[] objArr = this.f7541b;
        int i3 = 1;
        while (i3 < i2) {
            Object obj2 = objArr[i3];
            if (obj == null) {
                if (obj2 != null) {
                    i3 += 2;
                }
            } else if (!obj.equals(obj2)) {
                i3 += 2;
            }
            return true;
        }
        return false;
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        return new c();
    }

    /* renamed from: b */
    public final a<K, V> clone() {
        try {
            a<K, V> aVar = (a) super.clone();
            Object[] objArr = this.f7541b;
            if (objArr != null) {
                int length = objArr.length;
                Object[] objArr2 = new Object[length];
                aVar.f7541b = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
            }
            return aVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    final class c extends AbstractSet<Map.Entry<K, V>> {
        c() {
        }

        public final Iterator<Map.Entry<K, V>> iterator() {
            return new b();
        }

        public final int size() {
            return a.this.f7540a;
        }
    }

    final class b implements Iterator<Map.Entry<K, V>> {

        /* renamed from: b  reason: collision with root package name */
        private boolean f7550b;

        /* renamed from: c  reason: collision with root package name */
        private int f7551c;

        b() {
        }

        public final boolean hasNext() {
            return this.f7551c < a.this.f7540a;
        }

        public final void remove() {
            int i2 = this.f7551c - 1;
            if (this.f7550b || i2 < 0) {
                throw new IllegalArgumentException();
            }
            a.this.b(i2 << 1);
            this.f7550b = true;
        }

        public final /* synthetic */ Object next() {
            int i2 = this.f7551c;
            if (i2 != a.this.f7540a) {
                this.f7551c++;
                return new C0107a(i2);
            }
            throw new NoSuchElementException();
        }
    }

    /* renamed from: com.google.a.a.c.a$a  reason: collision with other inner class name */
    final class C0107a implements Map.Entry<K, V> {

        /* renamed from: b  reason: collision with root package name */
        private int f7543b;

        C0107a(int i2) {
            this.f7543b = i2;
        }

        public final K getKey() {
            a aVar = a.this;
            int i2 = this.f7543b;
            if (i2 < 0 || i2 >= aVar.f7540a) {
                return null;
            }
            return aVar.f7541b[i2 << 1];
        }

        public final V getValue() {
            return a.this.a(this.f7543b);
        }

        public final V setValue(V v) {
            return a.this.a(this.f7543b, v);
        }

        public final int hashCode() {
            return getKey().hashCode() ^ getValue().hashCode();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return com.google.a.a.b.a.a.a.a.b.a(getKey(), entry.getKey()) && com.google.a.a.b.a.a.a.a.b.a(getValue(), entry.getValue());
        }
    }

    public final V put(K k, V v) {
        int i2;
        int a2 = a((Object) k) >> 1;
        if (a2 == -1) {
            a2 = this.f7540a;
        }
        if (a2 >= 0) {
            int i3 = a2 + 1;
            if (i3 >= 0) {
                Object[] objArr = this.f7541b;
                int i4 = i3 << 1;
                if (objArr == null) {
                    i2 = 0;
                } else {
                    i2 = objArr.length;
                }
                if (i4 > i2) {
                    int i5 = ((i2 / 2) * 3) + 1;
                    if (i5 % 2 != 0) {
                        i5++;
                    }
                    if (i5 < i4) {
                        i5 = i4;
                    }
                    if (i5 == 0) {
                        this.f7541b = null;
                    } else {
                        int i6 = this.f7540a;
                        Object[] objArr2 = this.f7541b;
                        if (i6 == 0 || i5 != objArr2.length) {
                            Object[] objArr3 = new Object[i5];
                            this.f7541b = objArr3;
                            if (i6 != 0) {
                                System.arraycopy(objArr2, 0, objArr3, 0, i6 << 1);
                            }
                        }
                    }
                }
                int i7 = a2 << 1;
                V c2 = c(i7 + 1);
                a(i7, k, v);
                if (i3 > this.f7540a) {
                    this.f7540a = i3;
                }
                return c2;
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IndexOutOfBoundsException();
    }
}
