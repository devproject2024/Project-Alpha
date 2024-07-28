package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class dy extends cg<Integer> implements eb, fs, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final dy f10611b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f10612c;

    /* renamed from: d  reason: collision with root package name */
    private int f10613d;

    public static dy d() {
        return f10611b;
    }

    dy() {
        this(new int[10], 0);
    }

    private dy(int[] iArr, int i2) {
        this.f10612c = iArr;
        this.f10613d = i2;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i2, int i3) {
        r_();
        if (i3 >= i2) {
            int[] iArr = this.f10612c;
            System.arraycopy(iArr, i3, iArr, i2, this.f10613d - i3);
            this.f10613d -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dy)) {
            return super.equals(obj);
        }
        dy dyVar = (dy) obj;
        if (this.f10613d != dyVar.f10613d) {
            return false;
        }
        int[] iArr = dyVar.f10612c;
        for (int i2 = 0; i2 < this.f10613d; i2++) {
            if (this.f10612c[i2] != iArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f10613d; i3++) {
            i2 = (i2 * 31) + this.f10612c[i3];
        }
        return i2;
    }

    /* renamed from: b */
    public final eb a(int i2) {
        if (i2 >= this.f10613d) {
            return new dy(Arrays.copyOf(this.f10612c, i2), this.f10613d);
        }
        throw new IllegalArgumentException();
    }

    public final int c(int i2) {
        e(i2);
        return this.f10612c[i2];
    }

    public final int size() {
        return this.f10613d;
    }

    public final void d(int i2) {
        r_();
        int i3 = this.f10613d;
        int[] iArr = this.f10612c;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[(((i3 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.f10612c = iArr2;
        }
        int[] iArr3 = this.f10612c;
        int i4 = this.f10613d;
        this.f10613d = i4 + 1;
        iArr3[i4] = i2;
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        r_();
        dx.a(collection);
        if (!(collection instanceof dy)) {
            return super.addAll(collection);
        }
        dy dyVar = (dy) collection;
        int i2 = dyVar.f10613d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f10613d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            int[] iArr = this.f10612c;
            if (i4 > iArr.length) {
                this.f10612c = Arrays.copyOf(iArr, i4);
            }
            System.arraycopy(dyVar.f10612c, 0, this.f10612c, this.f10613d, dyVar.f10613d);
            this.f10613d = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        r_();
        for (int i2 = 0; i2 < this.f10613d; i2++) {
            if (obj.equals(Integer.valueOf(this.f10612c[i2]))) {
                int[] iArr = this.f10612c;
                System.arraycopy(iArr, i2 + 1, iArr, i2, (this.f10613d - i2) - 1);
                this.f10613d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void e(int i2) {
        if (i2 < 0 || i2 >= this.f10613d) {
            throw new IndexOutOfBoundsException(f(i2));
        }
    }

    private final String f(int i2) {
        int i3 = this.f10613d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        int intValue = ((Integer) obj).intValue();
        r_();
        e(i2);
        int[] iArr = this.f10612c;
        int i3 = iArr[i2];
        iArr[i2] = intValue;
        return Integer.valueOf(i3);
    }

    public final /* synthetic */ Object remove(int i2) {
        r_();
        e(i2);
        int[] iArr = this.f10612c;
        int i3 = iArr[i2];
        int i4 = this.f10613d;
        if (i2 < i4 - 1) {
            System.arraycopy(iArr, i2 + 1, iArr, i2, (i4 - i2) - 1);
        }
        this.f10613d--;
        this.modCount++;
        return Integer.valueOf(i3);
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        int intValue = ((Integer) obj).intValue();
        r_();
        if (i2 < 0 || i2 > (i3 = this.f10613d)) {
            throw new IndexOutOfBoundsException(f(i2));
        }
        int[] iArr = this.f10612c;
        if (i3 < iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i3 - i2);
        } else {
            int[] iArr2 = new int[(((i3 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            System.arraycopy(this.f10612c, i2, iArr2, i2 + 1, this.f10613d - i2);
            this.f10612c = iArr2;
        }
        this.f10612c[i2] = intValue;
        this.f10613d++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        d(((Integer) obj).intValue());
        return true;
    }

    public final /* synthetic */ Object get(int i2) {
        return Integer.valueOf(c(i2));
    }

    static {
        dy dyVar = new dy(new int[0], 0);
        f10611b = dyVar;
        dyVar.f10522a = false;
    }
}
