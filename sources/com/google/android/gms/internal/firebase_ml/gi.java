package com.google.android.gms.internal.firebase_ml;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class gi extends fe<Integer> implements gn, hy, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final gi f9932b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f9933c;

    /* renamed from: d  reason: collision with root package name */
    private int f9934d;

    public static gi a() {
        return f9932b;
    }

    gi() {
        this(new int[10], 0);
    }

    private gi(int[] iArr, int i2) {
        this.f9933c = iArr;
        this.f9934d = i2;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i2, int i3) {
        e();
        if (i3 >= i2) {
            int[] iArr = this.f9933c;
            System.arraycopy(iArr, i3, iArr, i2, this.f9934d - i3);
            this.f9934d -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gi)) {
            return super.equals(obj);
        }
        gi giVar = (gi) obj;
        if (this.f9934d != giVar.f9934d) {
            return false;
        }
        int[] iArr = giVar.f9933c;
        for (int i2 = 0; i2 < this.f9934d; i2++) {
            if (this.f9933c[i2] != iArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f9934d; i3++) {
            i2 = (i2 * 31) + this.f9933c[i3];
        }
        return i2;
    }

    /* renamed from: a */
    public final gn d(int i2) {
        if (i2 >= this.f9934d) {
            return new gi(Arrays.copyOf(this.f9933c, i2), this.f9934d);
        }
        throw new IllegalArgumentException();
    }

    public final int b(int i2) {
        e(i2);
        return this.f9933c[i2];
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f9933c[i2] == intValue) {
                return i2;
            }
        }
        return -1;
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final int size() {
        return this.f9934d;
    }

    public final void c(int i2) {
        e();
        int i3 = this.f9934d;
        int[] iArr = this.f9933c;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[(((i3 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.f9933c = iArr2;
        }
        int[] iArr3 = this.f9933c;
        int i4 = this.f9934d;
        this.f9934d = i4 + 1;
        iArr3[i4] = i2;
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        e();
        gk.a(collection);
        if (!(collection instanceof gi)) {
            return super.addAll(collection);
        }
        gi giVar = (gi) collection;
        int i2 = giVar.f9934d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f9934d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            int[] iArr = this.f9933c;
            if (i4 > iArr.length) {
                this.f9933c = Arrays.copyOf(iArr, i4);
            }
            System.arraycopy(giVar.f9933c, 0, this.f9933c, this.f9934d, giVar.f9934d);
            this.f9934d = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        e();
        for (int i2 = 0; i2 < this.f9934d; i2++) {
            if (obj.equals(Integer.valueOf(this.f9933c[i2]))) {
                int[] iArr = this.f9933c;
                System.arraycopy(iArr, i2 + 1, iArr, i2, (this.f9934d - i2) - 1);
                this.f9934d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void e(int i2) {
        if (i2 < 0 || i2 >= this.f9934d) {
            throw new IndexOutOfBoundsException(f(i2));
        }
    }

    private final String f(int i2) {
        int i3 = this.f9934d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        int intValue = ((Integer) obj).intValue();
        e();
        e(i2);
        int[] iArr = this.f9933c;
        int i3 = iArr[i2];
        iArr[i2] = intValue;
        return Integer.valueOf(i3);
    }

    public final /* synthetic */ Object remove(int i2) {
        e();
        e(i2);
        int[] iArr = this.f9933c;
        int i3 = iArr[i2];
        int i4 = this.f9934d;
        if (i2 < i4 - 1) {
            System.arraycopy(iArr, i2 + 1, iArr, i2, (i4 - i2) - 1);
        }
        this.f9934d--;
        this.modCount++;
        return Integer.valueOf(i3);
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        int intValue = ((Integer) obj).intValue();
        e();
        if (i2 < 0 || i2 > (i3 = this.f9934d)) {
            throw new IndexOutOfBoundsException(f(i2));
        }
        int[] iArr = this.f9933c;
        if (i3 < iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i3 - i2);
        } else {
            int[] iArr2 = new int[(((i3 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            System.arraycopy(this.f9933c, i2, iArr2, i2 + 1, this.f9934d - i2);
            this.f9933c = iArr2;
        }
        this.f9933c[i2] = intValue;
        this.f9934d++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        c(((Integer) obj).intValue());
        return true;
    }

    public final /* synthetic */ Object get(int i2) {
        return Integer.valueOf(b(i2));
    }

    static {
        gi giVar = new gi(new int[0], 0);
        f9932b = giVar;
        giVar.f9878a = false;
    }
}
