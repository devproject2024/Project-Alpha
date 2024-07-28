package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class el extends cp<Integer> implements eq<Integer>, gf, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final el f11116b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f11117c;

    /* renamed from: d  reason: collision with root package name */
    private int f11118d;

    public static el d() {
        return f11116b;
    }

    el() {
        this(new int[10], 0);
    }

    private el(int[] iArr, int i2) {
        this.f11117c = iArr;
        this.f11118d = i2;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i2, int i3) {
        c();
        if (i3 >= i2) {
            int[] iArr = this.f11117c;
            System.arraycopy(iArr, i3, iArr, i2, this.f11118d - i3);
            this.f11118d -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof el)) {
            return super.equals(obj);
        }
        el elVar = (el) obj;
        if (this.f11118d != elVar.f11118d) {
            return false;
        }
        int[] iArr = elVar.f11117c;
        for (int i2 = 0; i2 < this.f11118d; i2++) {
            if (this.f11117c[i2] != iArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f11118d; i3++) {
            i2 = (i2 * 31) + this.f11117c[i3];
        }
        return i2;
    }

    public final int b(int i2) {
        d(i2);
        return this.f11117c[i2];
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f11117c[i2] == intValue) {
                return i2;
            }
        }
        return -1;
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final int size() {
        return this.f11118d;
    }

    public final void c(int i2) {
        c();
        int i3 = this.f11118d;
        int[] iArr = this.f11117c;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[(((i3 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.f11117c = iArr2;
        }
        int[] iArr3 = this.f11117c;
        int i4 = this.f11118d;
        this.f11118d = i4 + 1;
        iArr3[i4] = i2;
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        c();
        ek.a(collection);
        if (!(collection instanceof el)) {
            return super.addAll(collection);
        }
        el elVar = (el) collection;
        int i2 = elVar.f11118d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f11118d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            int[] iArr = this.f11117c;
            if (i4 > iArr.length) {
                this.f11117c = Arrays.copyOf(iArr, i4);
            }
            System.arraycopy(elVar.f11117c, 0, this.f11117c, this.f11118d, elVar.f11118d);
            this.f11118d = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f11118d; i2++) {
            if (obj.equals(Integer.valueOf(this.f11117c[i2]))) {
                int[] iArr = this.f11117c;
                System.arraycopy(iArr, i2 + 1, iArr, i2, (this.f11118d - i2) - 1);
                this.f11118d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void d(int i2) {
        if (i2 < 0 || i2 >= this.f11118d) {
            throw new IndexOutOfBoundsException(e(i2));
        }
    }

    private final String e(int i2) {
        int i3 = this.f11118d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        int intValue = ((Integer) obj).intValue();
        c();
        d(i2);
        int[] iArr = this.f11117c;
        int i3 = iArr[i2];
        iArr[i2] = intValue;
        return Integer.valueOf(i3);
    }

    public final /* synthetic */ Object remove(int i2) {
        c();
        d(i2);
        int[] iArr = this.f11117c;
        int i3 = iArr[i2];
        int i4 = this.f11118d;
        if (i2 < i4 - 1) {
            System.arraycopy(iArr, i2 + 1, iArr, i2, (i4 - i2) - 1);
        }
        this.f11118d--;
        this.modCount++;
        return Integer.valueOf(i3);
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        int intValue = ((Integer) obj).intValue();
        c();
        if (i2 < 0 || i2 > (i3 = this.f11118d)) {
            throw new IndexOutOfBoundsException(e(i2));
        }
        int[] iArr = this.f11117c;
        if (i3 < iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i3 - i2);
        } else {
            int[] iArr2 = new int[(((i3 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            System.arraycopy(this.f11117c, i2, iArr2, i2 + 1, this.f11118d - i2);
            this.f11117c = iArr2;
        }
        this.f11117c[i2] = intValue;
        this.f11118d++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        c(((Integer) obj).intValue());
        return true;
    }

    public final /* synthetic */ eq a(int i2) {
        if (i2 >= this.f11118d) {
            return new el(Arrays.copyOf(this.f11117c, i2), this.f11118d);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i2) {
        return Integer.valueOf(b(i2));
    }

    static {
        el elVar = new el(new int[0], 0);
        f11116b = elVar;
        elVar.f11013a = false;
    }
}
