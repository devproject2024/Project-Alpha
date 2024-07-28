package androidx.a;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b<E> implements Collection<E>, Set<E> {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f921c = new int[0];

    /* renamed from: d  reason: collision with root package name */
    private static final Object[] f922d = new Object[0];

    /* renamed from: e  reason: collision with root package name */
    private static Object[] f923e;

    /* renamed from: f  reason: collision with root package name */
    private static int f924f;

    /* renamed from: g  reason: collision with root package name */
    private static Object[] f925g;

    /* renamed from: h  reason: collision with root package name */
    private static int f926h;

    /* renamed from: a  reason: collision with root package name */
    public Object[] f927a;

    /* renamed from: b  reason: collision with root package name */
    int f928b;

    /* renamed from: i  reason: collision with root package name */
    private int[] f929i;
    private f<E, E> j;

    private int a(Object obj, int i2) {
        int i3 = this.f928b;
        if (i3 == 0) {
            return -1;
        }
        int a2 = c.a(this.f929i, i3, i2);
        if (a2 < 0 || obj.equals(this.f927a[a2])) {
            return a2;
        }
        int i4 = a2 + 1;
        while (i4 < i3 && this.f929i[i4] == i2) {
            if (obj.equals(this.f927a[i4])) {
                return i4;
            }
            i4++;
        }
        int i5 = a2 - 1;
        while (i5 >= 0 && this.f929i[i5] == i2) {
            if (obj.equals(this.f927a[i5])) {
                return i5;
            }
            i5--;
        }
        return ~i4;
    }

    private int a() {
        int i2 = this.f928b;
        if (i2 == 0) {
            return -1;
        }
        int a2 = c.a(this.f929i, i2, 0);
        if (a2 < 0 || this.f927a[a2] == null) {
            return a2;
        }
        int i3 = a2 + 1;
        while (i3 < i2 && this.f929i[i3] == 0) {
            if (this.f927a[i3] == null) {
                return i3;
            }
            i3++;
        }
        int i4 = a2 - 1;
        while (i4 >= 0 && this.f929i[i4] == 0) {
            if (this.f927a[i4] == null) {
                return i4;
            }
            i4--;
        }
        return ~i3;
    }

    private void b(int i2) {
        Class<b> cls = b.class;
        if (i2 == 8) {
            synchronized (cls) {
                if (f925g != null) {
                    Object[] objArr = f925g;
                    this.f927a = objArr;
                    f925g = (Object[]) objArr[0];
                    this.f929i = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f926h--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (cls) {
                if (f923e != null) {
                    Object[] objArr2 = f923e;
                    this.f927a = objArr2;
                    f923e = (Object[]) objArr2[0];
                    this.f929i = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f924f--;
                    return;
                }
            }
        }
        this.f929i = new int[i2];
        this.f927a = new Object[i2];
    }

    private static void a(int[] iArr, Object[] objArr, int i2) {
        Class<b> cls = b.class;
        if (iArr.length == 8) {
            synchronized (cls) {
                if (f926h < 10) {
                    objArr[0] = f925g;
                    objArr[1] = iArr;
                    for (int i3 = i2 - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f925g = objArr;
                    f926h++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (cls) {
                if (f924f < 10) {
                    objArr[0] = f923e;
                    objArr[1] = iArr;
                    for (int i4 = i2 - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f923e = objArr;
                    f924f++;
                }
            }
        }
    }

    public b() {
        this(0);
    }

    public b(int i2) {
        if (i2 == 0) {
            this.f929i = f921c;
            this.f927a = f922d;
        } else {
            b(i2);
        }
        this.f928b = 0;
    }

    public b(Collection<E> collection) {
        this();
        if (collection != null) {
            addAll(collection);
        }
    }

    public final void clear() {
        int i2 = this.f928b;
        if (i2 != 0) {
            a(this.f929i, this.f927a, i2);
            this.f929i = f921c;
            this.f927a = f922d;
            this.f928b = 0;
        }
    }

    public final boolean contains(Object obj) {
        return a(obj) >= 0;
    }

    public final int a(Object obj) {
        return obj == null ? a() : a(obj, obj.hashCode());
    }

    public final boolean isEmpty() {
        return this.f928b <= 0;
    }

    public final boolean add(E e2) {
        int i2;
        int i3;
        if (e2 == null) {
            i3 = a();
            i2 = 0;
        } else {
            int hashCode = e2.hashCode();
            i2 = hashCode;
            i3 = a(e2, hashCode);
        }
        if (i3 >= 0) {
            return false;
        }
        int i4 = ~i3;
        int i5 = this.f928b;
        if (i5 >= this.f929i.length) {
            int i6 = 4;
            if (i5 >= 8) {
                i6 = (i5 >> 1) + i5;
            } else if (i5 >= 4) {
                i6 = 8;
            }
            int[] iArr = this.f929i;
            Object[] objArr = this.f927a;
            b(i6);
            int[] iArr2 = this.f929i;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f927a, 0, objArr.length);
            }
            a(iArr, objArr, this.f928b);
        }
        int i7 = this.f928b;
        if (i4 < i7) {
            int[] iArr3 = this.f929i;
            int i8 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i8, i7 - i4);
            Object[] objArr2 = this.f927a;
            System.arraycopy(objArr2, i4, objArr2, i8, this.f928b - i4);
        }
        this.f929i[i4] = i2;
        this.f927a[i4] = e2;
        this.f928b++;
        return true;
    }

    public final boolean remove(Object obj) {
        int a2 = a(obj);
        if (a2 < 0) {
            return false;
        }
        a(a2);
        return true;
    }

    public final E a(int i2) {
        E[] eArr = this.f927a;
        E e2 = eArr[i2];
        int i3 = this.f928b;
        if (i3 <= 1) {
            a(this.f929i, eArr, i3);
            this.f929i = f921c;
            this.f927a = f922d;
            this.f928b = 0;
        } else {
            int[] iArr = this.f929i;
            int i4 = 8;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                this.f928b--;
                int i5 = this.f928b;
                if (i2 < i5) {
                    int[] iArr2 = this.f929i;
                    int i6 = i2 + 1;
                    System.arraycopy(iArr2, i6, iArr2, i2, i5 - i2);
                    Object[] objArr = this.f927a;
                    System.arraycopy(objArr, i6, objArr, i2, this.f928b - i2);
                }
                this.f927a[this.f928b] = null;
            } else {
                if (i3 > 8) {
                    i4 = i3 + (i3 >> 1);
                }
                int[] iArr3 = this.f929i;
                Object[] objArr2 = this.f927a;
                b(i4);
                this.f928b--;
                if (i2 > 0) {
                    System.arraycopy(iArr3, 0, this.f929i, 0, i2);
                    System.arraycopy(objArr2, 0, this.f927a, 0, i2);
                }
                int i7 = this.f928b;
                if (i2 < i7) {
                    int i8 = i2 + 1;
                    System.arraycopy(iArr3, i8, this.f929i, i2, i7 - i2);
                    System.arraycopy(objArr2, i8, this.f927a, i2, this.f928b - i2);
                }
            }
        }
        return e2;
    }

    public final int size() {
        return this.f928b;
    }

    public final Object[] toArray() {
        int i2 = this.f928b;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.f927a, 0, objArr, 0, i2);
        return objArr;
    }

    public final <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f928b) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f928b);
        }
        System.arraycopy(this.f927a, 0, tArr, 0, this.f928b);
        int length = tArr.length;
        int i2 = this.f928b;
        if (length > i2) {
            tArr[i2] = null;
        }
        return tArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            int i2 = 0;
            while (i2 < this.f928b) {
                try {
                    if (!set.contains(this.f927a[i2])) {
                        return false;
                    }
                    i2++;
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int[] iArr = this.f929i;
        int i2 = this.f928b;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f928b * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.f928b; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object obj = this.f927a[i2];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public final boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public final boolean addAll(Collection<? extends E> collection) {
        int size = this.f928b + collection.size();
        int[] iArr = this.f929i;
        boolean z = false;
        if (iArr.length < size) {
            Object[] objArr = this.f927a;
            b(size);
            int i2 = this.f928b;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.f929i, 0, i2);
                System.arraycopy(objArr, 0, this.f927a, 0, this.f928b);
            }
            a(iArr, objArr, this.f928b);
        }
        for (Object add : collection) {
            z |= add(add);
        }
        return z;
    }

    public final boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object remove : collection) {
            z |= remove(remove);
        }
        return z;
    }

    public final boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i2 = this.f928b - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.f927a[i2])) {
                a(i2);
                z = true;
            }
        }
        return z;
    }

    public final Iterator<E> iterator() {
        if (this.j == null) {
            this.j = new f<E, E>() {
                /* access modifiers changed from: protected */
                public final int a() {
                    return b.this.f928b;
                }

                /* access modifiers changed from: protected */
                public final Object a(int i2, int i3) {
                    return b.this.f927a[i2];
                }

                /* access modifiers changed from: protected */
                public final int a(Object obj) {
                    return b.this.a(obj);
                }

                /* access modifiers changed from: protected */
                public final int b(Object obj) {
                    return b.this.a(obj);
                }

                /* access modifiers changed from: protected */
                public final Map<E, E> b() {
                    throw new UnsupportedOperationException("not a map");
                }

                /* access modifiers changed from: protected */
                public final void a(E e2, E e3) {
                    b.this.add(e2);
                }

                /* access modifiers changed from: protected */
                public final E a(int i2, E e2) {
                    throw new UnsupportedOperationException("not a map");
                }

                /* access modifiers changed from: protected */
                public final void a(int i2) {
                    b.this.a(i2);
                }

                /* access modifiers changed from: protected */
                public final void c() {
                    b.this.clear();
                }
            };
        }
        return this.j.d().iterator();
    }
}
