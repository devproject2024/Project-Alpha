package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class cx extends cp<Boolean> implements eq<Boolean>, gf, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final cx f11023b;

    /* renamed from: c  reason: collision with root package name */
    private boolean[] f11024c;

    /* renamed from: d  reason: collision with root package name */
    private int f11025d;

    cx() {
        this(new boolean[10], 0);
    }

    private cx(boolean[] zArr, int i2) {
        this.f11024c = zArr;
        this.f11025d = i2;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i2, int i3) {
        c();
        if (i3 >= i2) {
            boolean[] zArr = this.f11024c;
            System.arraycopy(zArr, i3, zArr, i2, this.f11025d - i3);
            this.f11025d -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cx)) {
            return super.equals(obj);
        }
        cx cxVar = (cx) obj;
        if (this.f11025d != cxVar.f11025d) {
            return false;
        }
        boolean[] zArr = cxVar.f11024c;
        for (int i2 = 0; i2 < this.f11025d; i2++) {
            if (this.f11024c[i2] != zArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f11025d; i3++) {
            i2 = (i2 * 31) + ek.a(this.f11024c[i3]);
        }
        return i2;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f11024c[i2] == booleanValue) {
                return i2;
            }
        }
        return -1;
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final int size() {
        return this.f11025d;
    }

    public final void a(boolean z) {
        c();
        int i2 = this.f11025d;
        boolean[] zArr = this.f11024c;
        if (i2 == zArr.length) {
            boolean[] zArr2 = new boolean[(((i2 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            this.f11024c = zArr2;
        }
        boolean[] zArr3 = this.f11024c;
        int i3 = this.f11025d;
        this.f11025d = i3 + 1;
        zArr3[i3] = z;
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        c();
        ek.a(collection);
        if (!(collection instanceof cx)) {
            return super.addAll(collection);
        }
        cx cxVar = (cx) collection;
        int i2 = cxVar.f11025d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f11025d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            boolean[] zArr = this.f11024c;
            if (i4 > zArr.length) {
                this.f11024c = Arrays.copyOf(zArr, i4);
            }
            System.arraycopy(cxVar.f11024c, 0, this.f11024c, this.f11025d, cxVar.f11025d);
            this.f11025d = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f11025d; i2++) {
            if (obj.equals(Boolean.valueOf(this.f11024c[i2]))) {
                boolean[] zArr = this.f11024c;
                System.arraycopy(zArr, i2 + 1, zArr, i2, (this.f11025d - i2) - 1);
                this.f11025d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void b(int i2) {
        if (i2 < 0 || i2 >= this.f11025d) {
            throw new IndexOutOfBoundsException(c(i2));
        }
    }

    private final String c(int i2) {
        int i3 = this.f11025d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        c();
        b(i2);
        boolean[] zArr = this.f11024c;
        boolean z = zArr[i2];
        zArr[i2] = booleanValue;
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ Object remove(int i2) {
        c();
        b(i2);
        boolean[] zArr = this.f11024c;
        boolean z = zArr[i2];
        int i3 = this.f11025d;
        if (i2 < i3 - 1) {
            System.arraycopy(zArr, i2 + 1, zArr, i2, (i3 - i2) - 1);
        }
        this.f11025d--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        c();
        if (i2 < 0 || i2 > (i3 = this.f11025d)) {
            throw new IndexOutOfBoundsException(c(i2));
        }
        boolean[] zArr = this.f11024c;
        if (i3 < zArr.length) {
            System.arraycopy(zArr, i2, zArr, i2 + 1, i3 - i2);
        } else {
            boolean[] zArr2 = new boolean[(((i3 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            System.arraycopy(this.f11024c, i2, zArr2, i2 + 1, this.f11025d - i2);
            this.f11024c = zArr2;
        }
        this.f11024c[i2] = booleanValue;
        this.f11025d++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        a(((Boolean) obj).booleanValue());
        return true;
    }

    public final /* synthetic */ eq a(int i2) {
        if (i2 >= this.f11025d) {
            return new cx(Arrays.copyOf(this.f11024c, i2), this.f11025d);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i2) {
        b(i2);
        return Boolean.valueOf(this.f11024c[i2]);
    }

    static {
        cx cxVar = new cx(new boolean[0], 0);
        f11023b = cxVar;
        cxVar.f11013a = false;
    }
}
