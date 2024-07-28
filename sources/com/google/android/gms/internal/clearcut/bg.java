package com.google.android.gms.internal.clearcut;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class bg extends u<Integer> implements bm<Integer>, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final bg f9205b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f9206c;

    /* renamed from: d  reason: collision with root package name */
    private int f9207d;

    bg() {
        this(new int[10], 0);
    }

    private bg(int[] iArr, int i2) {
        this.f9206c = iArr;
        this.f9207d = i2;
    }

    private final void a(int i2, int i3) {
        int i4;
        c();
        if (i2 < 0 || i2 > (i4 = this.f9207d)) {
            throw new IndexOutOfBoundsException(e(i2));
        }
        int[] iArr = this.f9206c;
        if (i4 < iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i4 - i2);
        } else {
            int[] iArr2 = new int[(((i4 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            System.arraycopy(this.f9206c, i2, iArr2, i2 + 1, this.f9207d - i2);
            this.f9206c = iArr2;
        }
        this.f9206c[i2] = i3;
        this.f9207d++;
        this.modCount++;
    }

    public static bg d() {
        return f9205b;
    }

    private final void d(int i2) {
        if (i2 < 0 || i2 >= this.f9207d) {
            throw new IndexOutOfBoundsException(e(i2));
        }
    }

    private final String e(int i2) {
        int i3 = this.f9207d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    public final /* synthetic */ bm a(int i2) {
        if (i2 >= this.f9207d) {
            return new bg(Arrays.copyOf(this.f9206c, i2), this.f9207d);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        a(i2, ((Integer) obj).intValue());
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        c();
        bh.a(collection);
        if (!(collection instanceof bg)) {
            return super.addAll(collection);
        }
        bg bgVar = (bg) collection;
        int i2 = bgVar.f9207d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f9207d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            int[] iArr = this.f9206c;
            if (i4 > iArr.length) {
                this.f9206c = Arrays.copyOf(iArr, i4);
            }
            System.arraycopy(bgVar.f9206c, 0, this.f9206c, this.f9207d, bgVar.f9207d);
            this.f9207d = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final int b(int i2) {
        d(i2);
        return this.f9206c[i2];
    }

    public final void c(int i2) {
        a(this.f9207d, i2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bg)) {
            return super.equals(obj);
        }
        bg bgVar = (bg) obj;
        if (this.f9207d != bgVar.f9207d) {
            return false;
        }
        int[] iArr = bgVar.f9206c;
        for (int i2 = 0; i2 < this.f9207d; i2++) {
            if (this.f9206c[i2] != iArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i2) {
        return Integer.valueOf(b(i2));
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f9207d; i3++) {
            i2 = (i2 * 31) + this.f9206c[i3];
        }
        return i2;
    }

    public final /* synthetic */ Object remove(int i2) {
        c();
        d(i2);
        int[] iArr = this.f9206c;
        int i3 = iArr[i2];
        int i4 = this.f9207d;
        if (i2 < i4 - 1) {
            System.arraycopy(iArr, i2 + 1, iArr, i2, i4 - i2);
        }
        this.f9207d--;
        this.modCount++;
        return Integer.valueOf(i3);
    }

    public final boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f9207d; i2++) {
            if (obj.equals(Integer.valueOf(this.f9206c[i2]))) {
                int[] iArr = this.f9206c;
                System.arraycopy(iArr, i2 + 1, iArr, i2, this.f9207d - i2);
                this.f9207d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i2, int i3) {
        c();
        if (i3 >= i2) {
            int[] iArr = this.f9206c;
            System.arraycopy(iArr, i3, iArr, i2, this.f9207d - i3);
            this.f9207d -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        int intValue = ((Integer) obj).intValue();
        c();
        d(i2);
        int[] iArr = this.f9206c;
        int i3 = iArr[i2];
        iArr[i2] = intValue;
        return Integer.valueOf(i3);
    }

    public final int size() {
        return this.f9207d;
    }

    static {
        bg bgVar = new bg();
        f9205b = bgVar;
        bgVar.f9429a = false;
    }
}
