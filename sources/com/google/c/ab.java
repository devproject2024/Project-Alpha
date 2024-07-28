package com.google.c;

import com.google.c.ac;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class ab extends c<Integer> implements ac.g, be, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final ab f37694b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f37695c;

    /* renamed from: d  reason: collision with root package name */
    private int f37696d;

    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        int intValue = ((Integer) obj).intValue();
        c();
        if (i2 < 0 || i2 > (i3 = this.f37696d)) {
            throw new IndexOutOfBoundsException(e(i2));
        }
        int[] iArr = this.f37695c;
        if (i3 < iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i3 - i2);
        } else {
            int[] iArr2 = new int[(((i3 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            System.arraycopy(this.f37695c, i2, iArr2, i2 + 1, this.f37696d - i2);
            this.f37695c = iArr2;
        }
        this.f37695c[i2] = intValue;
        this.f37696d++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        c(((Integer) obj).intValue());
        return true;
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        int intValue = ((Integer) obj).intValue();
        c();
        d(i2);
        int[] iArr = this.f37695c;
        int i3 = iArr[i2];
        iArr[i2] = intValue;
        return Integer.valueOf(i3);
    }

    static {
        ab abVar = new ab(new int[0], 0);
        f37694b = abVar;
        abVar.f37832a = false;
    }

    ab() {
        this(new int[10], 0);
    }

    private ab(int[] iArr, int i2) {
        this.f37695c = iArr;
        this.f37696d = i2;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i2, int i3) {
        c();
        if (i3 >= i2) {
            int[] iArr = this.f37695c;
            System.arraycopy(iArr, i3, iArr, i2, this.f37696d - i3);
            this.f37696d -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ab)) {
            return super.equals(obj);
        }
        ab abVar = (ab) obj;
        if (this.f37696d != abVar.f37696d) {
            return false;
        }
        int[] iArr = abVar.f37695c;
        for (int i2 = 0; i2 < this.f37696d; i2++) {
            if (this.f37695c[i2] != iArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f37696d; i3++) {
            i2 = (i2 * 31) + this.f37695c[i3];
        }
        return i2;
    }

    public final int b(int i2) {
        d(i2);
        return this.f37695c[i2];
    }

    public final int size() {
        return this.f37696d;
    }

    public final void c(int i2) {
        c();
        int i3 = this.f37696d;
        int[] iArr = this.f37695c;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[(((i3 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.f37695c = iArr2;
        }
        int[] iArr3 = this.f37695c;
        int i4 = this.f37696d;
        this.f37696d = i4 + 1;
        iArr3[i4] = i2;
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        c();
        ac.a(collection);
        if (!(collection instanceof ab)) {
            return super.addAll(collection);
        }
        ab abVar = (ab) collection;
        int i2 = abVar.f37696d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f37696d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            int[] iArr = this.f37695c;
            if (i4 > iArr.length) {
                this.f37695c = Arrays.copyOf(iArr, i4);
            }
            System.arraycopy(abVar.f37695c, 0, this.f37695c, this.f37696d, abVar.f37696d);
            this.f37696d = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f37696d; i2++) {
            if (obj.equals(Integer.valueOf(this.f37695c[i2]))) {
                int[] iArr = this.f37695c;
                System.arraycopy(iArr, i2 + 1, iArr, i2, (this.f37696d - i2) - 1);
                this.f37696d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private void d(int i2) {
        if (i2 < 0 || i2 >= this.f37696d) {
            throw new IndexOutOfBoundsException(e(i2));
        }
    }

    private String e(int i2) {
        return "Index:" + i2 + ", Size:" + this.f37696d;
    }

    public final /* synthetic */ Object remove(int i2) {
        c();
        d(i2);
        int[] iArr = this.f37695c;
        int i3 = iArr[i2];
        int i4 = this.f37696d;
        if (i2 < i4 - 1) {
            System.arraycopy(iArr, i2 + 1, iArr, i2, (i4 - i2) - 1);
        }
        this.f37696d--;
        this.modCount++;
        return Integer.valueOf(i3);
    }

    public final /* synthetic */ ac.i a(int i2) {
        if (i2 >= this.f37696d) {
            return new ab(Arrays.copyOf(this.f37695c, i2), this.f37696d);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i2) {
        return Integer.valueOf(b(i2));
    }
}
