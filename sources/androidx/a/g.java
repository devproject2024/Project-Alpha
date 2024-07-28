package androidx.a;

import java.util.ConcurrentModificationException;
import java.util.Map;

public class g<K, V> {

    /* renamed from: b  reason: collision with root package name */
    static Object[] f954b;

    /* renamed from: c  reason: collision with root package name */
    static int f955c;

    /* renamed from: d  reason: collision with root package name */
    static Object[] f956d;

    /* renamed from: e  reason: collision with root package name */
    static int f957e;

    /* renamed from: f  reason: collision with root package name */
    int[] f958f;

    /* renamed from: g  reason: collision with root package name */
    Object[] f959g;

    /* renamed from: h  reason: collision with root package name */
    int f960h;

    private static int a(int[] iArr, int i2, int i3) {
        try {
            return c.a(iArr, i2, i3);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private int a(Object obj, int i2) {
        int i3 = this.f960h;
        if (i3 == 0) {
            return -1;
        }
        int a2 = a(this.f958f, i3, i2);
        if (a2 < 0 || obj.equals(this.f959g[a2 << 1])) {
            return a2;
        }
        int i4 = a2 + 1;
        while (i4 < i3 && this.f958f[i4] == i2) {
            if (obj.equals(this.f959g[i4 << 1])) {
                return i4;
            }
            i4++;
        }
        int i5 = a2 - 1;
        while (i5 >= 0 && this.f958f[i5] == i2) {
            if (obj.equals(this.f959g[i5 << 1])) {
                return i5;
            }
            i5--;
        }
        return ~i4;
    }

    private int a() {
        int i2 = this.f960h;
        if (i2 == 0) {
            return -1;
        }
        int a2 = a(this.f958f, i2, 0);
        if (a2 < 0 || this.f959g[a2 << 1] == null) {
            return a2;
        }
        int i3 = a2 + 1;
        while (i3 < i2 && this.f958f[i3] == 0) {
            if (this.f959g[i3 << 1] == null) {
                return i3;
            }
            i3++;
        }
        int i4 = a2 - 1;
        while (i4 >= 0 && this.f958f[i4] == 0) {
            if (this.f959g[i4 << 1] == null) {
                return i4;
            }
            i4--;
        }
        return ~i3;
    }

    private void e(int i2) {
        Class<g> cls = g.class;
        if (i2 == 8) {
            synchronized (cls) {
                if (f956d != null) {
                    Object[] objArr = f956d;
                    this.f959g = objArr;
                    f956d = (Object[]) objArr[0];
                    this.f958f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f957e--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (cls) {
                if (f954b != null) {
                    Object[] objArr2 = f954b;
                    this.f959g = objArr2;
                    f954b = (Object[]) objArr2[0];
                    this.f958f = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f955c--;
                    return;
                }
            }
        }
        this.f958f = new int[i2];
        this.f959g = new Object[(i2 << 1)];
    }

    private static void a(int[] iArr, Object[] objArr, int i2) {
        Class<g> cls = g.class;
        if (iArr.length == 8) {
            synchronized (cls) {
                if (f957e < 10) {
                    objArr[0] = f956d;
                    objArr[1] = iArr;
                    for (int i3 = (i2 << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f956d = objArr;
                    f957e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (cls) {
                if (f955c < 10) {
                    objArr[0] = f954b;
                    objArr[1] = iArr;
                    for (int i4 = (i2 << 1) - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f954b = objArr;
                    f955c++;
                }
            }
        }
    }

    public g() {
        this.f958f = c.f931a;
        this.f959g = c.f933c;
        this.f960h = 0;
    }

    public g(int i2) {
        if (i2 == 0) {
            this.f958f = c.f931a;
            this.f959g = c.f933c;
        } else {
            e(i2);
        }
        this.f960h = 0;
    }

    public g(g<K, V> gVar) {
        this();
        if (gVar != null) {
            a(gVar);
        }
    }

    public void clear() {
        int i2 = this.f960h;
        if (i2 > 0) {
            int[] iArr = this.f958f;
            Object[] objArr = this.f959g;
            this.f958f = c.f931a;
            this.f959g = c.f933c;
            this.f960h = 0;
            a(iArr, objArr, i2);
        }
        if (this.f960h > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public final void a(int i2) {
        int i3 = this.f960h;
        int[] iArr = this.f958f;
        if (iArr.length < i2) {
            Object[] objArr = this.f959g;
            e(i2);
            if (this.f960h > 0) {
                System.arraycopy(iArr, 0, this.f958f, 0, i3);
                System.arraycopy(objArr, 0, this.f959g, 0, i3 << 1);
            }
            a(iArr, objArr, i3);
        }
        if (this.f960h != i3) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return a(obj) >= 0;
    }

    public final int a(Object obj) {
        return obj == null ? a() : a(obj, obj.hashCode());
    }

    /* access modifiers changed from: package-private */
    public final int b(Object obj) {
        int i2 = this.f960h * 2;
        Object[] objArr = this.f959g;
        if (obj == null) {
            for (int i3 = 1; i3 < i2; i3 += 2) {
                if (objArr[i3] == null) {
                    return i3 >> 1;
                }
            }
            return -1;
        }
        for (int i4 = 1; i4 < i2; i4 += 2) {
            if (obj.equals(objArr[i4])) {
                return i4 >> 1;
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return b(obj) >= 0;
    }

    public V get(Object obj) {
        return getOrDefault(obj, (Object) null);
    }

    public V getOrDefault(Object obj, V v) {
        int a2 = a(obj);
        return a2 >= 0 ? this.f959g[(a2 << 1) + 1] : v;
    }

    public final K b(int i2) {
        return this.f959g[i2 << 1];
    }

    public final V c(int i2) {
        return this.f959g[(i2 << 1) + 1];
    }

    public V a(int i2, V v) {
        int i3 = (i2 << 1) + 1;
        V[] vArr = this.f959g;
        V v2 = vArr[i3];
        vArr[i3] = v;
        return v2;
    }

    public boolean isEmpty() {
        return this.f960h <= 0;
    }

    public V put(K k, V v) {
        int i2;
        int i3;
        int i4 = this.f960h;
        if (k == null) {
            i3 = a();
            i2 = 0;
        } else {
            int hashCode = k.hashCode();
            i2 = hashCode;
            i3 = a((Object) k, hashCode);
        }
        if (i3 >= 0) {
            int i5 = (i3 << 1) + 1;
            V[] vArr = this.f959g;
            V v2 = vArr[i5];
            vArr[i5] = v;
            return v2;
        }
        int i6 = ~i3;
        if (i4 >= this.f958f.length) {
            int i7 = 4;
            if (i4 >= 8) {
                i7 = (i4 >> 1) + i4;
            } else if (i4 >= 4) {
                i7 = 8;
            }
            int[] iArr = this.f958f;
            Object[] objArr = this.f959g;
            e(i7);
            if (i4 == this.f960h) {
                int[] iArr2 = this.f958f;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr, 0, this.f959g, 0, objArr.length);
                }
                a(iArr, objArr, i4);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i6 < i4) {
            int[] iArr3 = this.f958f;
            int i8 = i6 + 1;
            System.arraycopy(iArr3, i6, iArr3, i8, i4 - i6);
            Object[] objArr2 = this.f959g;
            System.arraycopy(objArr2, i6 << 1, objArr2, i8 << 1, (this.f960h - i6) << 1);
        }
        int i9 = this.f960h;
        if (i4 == i9) {
            int[] iArr4 = this.f958f;
            if (i6 < iArr4.length) {
                iArr4[i6] = i2;
                Object[] objArr3 = this.f959g;
                int i10 = i6 << 1;
                objArr3[i10] = k;
                objArr3[i10 + 1] = v;
                this.f960h = i9 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public void a(g<? extends K, ? extends V> gVar) {
        int i2 = gVar.f960h;
        a(this.f960h + i2);
        if (this.f960h != 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                put(gVar.b(i3), gVar.c(i3));
            }
        } else if (i2 > 0) {
            System.arraycopy(gVar.f958f, 0, this.f958f, 0, i2);
            System.arraycopy(gVar.f959g, 0, this.f959g, 0, i2 << 1);
            this.f960h = i2;
        }
    }

    public V putIfAbsent(K k, V v) {
        V v2 = get(k);
        return v2 == null ? put(k, v) : v2;
    }

    public V remove(Object obj) {
        int a2 = a(obj);
        if (a2 >= 0) {
            return d(a2);
        }
        return null;
    }

    public boolean remove(Object obj, Object obj2) {
        int a2 = a(obj);
        if (a2 < 0) {
            return false;
        }
        Object c2 = c(a2);
        if (obj2 != c2 && (obj2 == null || !obj2.equals(c2))) {
            return false;
        }
        d(a2);
        return true;
    }

    public V d(int i2) {
        int i3;
        V[] vArr = this.f959g;
        int i4 = i2 << 1;
        V v = vArr[i4 + 1];
        int i5 = this.f960h;
        if (i5 <= 1) {
            a(this.f958f, (Object[]) vArr, i5);
            this.f958f = c.f931a;
            this.f959g = c.f933c;
            i3 = 0;
        } else {
            i3 = i5 - 1;
            int[] iArr = this.f958f;
            int i6 = 8;
            if (iArr.length <= 8 || i5 >= iArr.length / 3) {
                if (i2 < i3) {
                    int[] iArr2 = this.f958f;
                    int i7 = i2 + 1;
                    int i8 = i3 - i2;
                    System.arraycopy(iArr2, i7, iArr2, i2, i8);
                    Object[] objArr = this.f959g;
                    System.arraycopy(objArr, i7 << 1, objArr, i4, i8 << 1);
                }
                Object[] objArr2 = this.f959g;
                int i9 = i3 << 1;
                objArr2[i9] = null;
                objArr2[i9 + 1] = null;
            } else {
                if (i5 > 8) {
                    i6 = i5 + (i5 >> 1);
                }
                int[] iArr3 = this.f958f;
                Object[] objArr3 = this.f959g;
                e(i6);
                if (i5 == this.f960h) {
                    if (i2 > 0) {
                        System.arraycopy(iArr3, 0, this.f958f, 0, i2);
                        System.arraycopy(objArr3, 0, this.f959g, 0, i4);
                    }
                    if (i2 < i3) {
                        int i10 = i2 + 1;
                        int i11 = i3 - i2;
                        System.arraycopy(iArr3, i10, this.f958f, i2, i11);
                        System.arraycopy(objArr3, i10 << 1, this.f959g, i4, i11 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            }
        }
        if (i5 == this.f960h) {
            this.f960h = i3;
            return v;
        }
        throw new ConcurrentModificationException();
    }

    public V replace(K k, V v) {
        int a2 = a((Object) k);
        if (a2 >= 0) {
            return a(a2, v);
        }
        return null;
    }

    public boolean replace(K k, V v, V v2) {
        int a2 = a((Object) k);
        if (a2 < 0) {
            return false;
        }
        V c2 = c(a2);
        if (c2 != v && (v == null || !v.equals(c2))) {
            return false;
        }
        a(a2, v2);
        return true;
    }

    public int size() {
        return this.f960h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (size() != gVar.size()) {
                return false;
            }
            int i2 = 0;
            while (i2 < this.f960h) {
                try {
                    Object b2 = b(i2);
                    Object c2 = c(i2);
                    Object obj2 = gVar.get(b2);
                    if (c2 == null) {
                        if (obj2 != null || !gVar.containsKey(b2)) {
                            return false;
                        }
                    } else if (!c2.equals(obj2)) {
                        return false;
                    }
                    i2++;
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            int i3 = 0;
            while (i3 < this.f960h) {
                try {
                    Object b3 = b(i3);
                    Object c3 = c(i3);
                    Object obj3 = map.get(b3);
                    if (c3 == null) {
                        if (obj3 != null || !map.containsKey(b3)) {
                            return false;
                        }
                    } else if (!c3.equals(obj3)) {
                        return false;
                    }
                    i3++;
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int[] iArr = this.f958f;
        Object[] objArr = this.f959g;
        int i2 = this.f960h;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        while (i3 < i2) {
            Object obj = objArr[i5];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i5 += 2;
        }
        return i4;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f960h * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f960h; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object b2 = b(i2);
            if (b2 != this) {
                sb.append(b2);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object c2 = c(i2);
            if (c2 != this) {
                sb.append(c2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
