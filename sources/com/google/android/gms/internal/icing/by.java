package com.google.android.gms.internal.icing;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class by extends ap<Integer> implements ce<Integer>, dn, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final by f10124b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f10125c;

    /* renamed from: d  reason: collision with root package name */
    private int f10126d;

    by() {
        this(new int[10], 0);
    }

    private by(int[] iArr, int i2) {
        this.f10125c = iArr;
        this.f10126d = i2;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i2, int i3) {
        c();
        if (i3 >= i2) {
            int[] iArr = this.f10125c;
            System.arraycopy(iArr, i3, iArr, i2, this.f10126d - i3);
            this.f10126d -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof by)) {
            return super.equals(obj);
        }
        by byVar = (by) obj;
        if (this.f10126d != byVar.f10126d) {
            return false;
        }
        int[] iArr = byVar.f10125c;
        for (int i2 = 0; i2 < this.f10126d; i2++) {
            if (this.f10125c[i2] != iArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f10126d; i3++) {
            i2 = (i2 * 31) + this.f10125c[i3];
        }
        return i2;
    }

    public final int b(int i2) {
        c(i2);
        return this.f10125c[i2];
    }

    public final int size() {
        return this.f10126d;
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        c();
        bx.a(collection);
        if (!(collection instanceof by)) {
            return super.addAll(collection);
        }
        by byVar = (by) collection;
        int i2 = byVar.f10126d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f10126d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            int[] iArr = this.f10125c;
            if (i4 > iArr.length) {
                this.f10125c = Arrays.copyOf(iArr, i4);
            }
            System.arraycopy(byVar.f10125c, 0, this.f10125c, this.f10126d, byVar.f10126d);
            this.f10126d = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f10126d; i2++) {
            if (obj.equals(Integer.valueOf(this.f10125c[i2]))) {
                int[] iArr = this.f10125c;
                System.arraycopy(iArr, i2 + 1, iArr, i2, (this.f10126d - i2) - 1);
                this.f10126d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void c(int i2) {
        if (i2 < 0 || i2 >= this.f10126d) {
            throw new IndexOutOfBoundsException(d(i2));
        }
    }

    private final String d(int i2) {
        int i3 = this.f10126d;
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
        c(i2);
        int[] iArr = this.f10125c;
        int i3 = iArr[i2];
        iArr[i2] = intValue;
        return Integer.valueOf(i3);
    }

    public final /* synthetic */ Object remove(int i2) {
        c();
        c(i2);
        int[] iArr = this.f10125c;
        int i3 = iArr[i2];
        int i4 = this.f10126d;
        if (i2 < i4 - 1) {
            System.arraycopy(iArr, i2 + 1, iArr, i2, (i4 - i2) - 1);
        }
        this.f10126d--;
        this.modCount++;
        return Integer.valueOf(i3);
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        int intValue = ((Integer) obj).intValue();
        c();
        if (i2 < 0 || i2 > (i3 = this.f10126d)) {
            throw new IndexOutOfBoundsException(d(i2));
        }
        int[] iArr = this.f10125c;
        if (i3 < iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i3 - i2);
        } else {
            int[] iArr2 = new int[(((i3 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            System.arraycopy(this.f10125c, i2, iArr2, i2 + 1, this.f10126d - i2);
            this.f10125c = iArr2;
        }
        this.f10125c[i2] = intValue;
        this.f10126d++;
        this.modCount++;
    }

    public final /* synthetic */ ce a(int i2) {
        if (i2 >= this.f10126d) {
            return new by(Arrays.copyOf(this.f10125c, i2), this.f10126d);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i2) {
        return Integer.valueOf(b(i2));
    }

    static {
        by byVar = new by(new int[0], 0);
        f10124b = byVar;
        byVar.f10058a = false;
    }
}
