package com.google.android.gms.internal.clearcut;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class y extends u<Boolean> implements bm<Boolean>, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final y f9435b;

    /* renamed from: c  reason: collision with root package name */
    private boolean[] f9436c;

    /* renamed from: d  reason: collision with root package name */
    private int f9437d;

    y() {
        this(new boolean[10], 0);
    }

    private y(boolean[] zArr, int i2) {
        this.f9436c = zArr;
        this.f9437d = i2;
    }

    private final void a(int i2, boolean z) {
        int i3;
        c();
        if (i2 < 0 || i2 > (i3 = this.f9437d)) {
            throw new IndexOutOfBoundsException(c(i2));
        }
        boolean[] zArr = this.f9436c;
        if (i3 < zArr.length) {
            System.arraycopy(zArr, i2, zArr, i2 + 1, i3 - i2);
        } else {
            boolean[] zArr2 = new boolean[(((i3 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            System.arraycopy(this.f9436c, i2, zArr2, i2 + 1, this.f9437d - i2);
            this.f9436c = zArr2;
        }
        this.f9436c[i2] = z;
        this.f9437d++;
        this.modCount++;
    }

    private final void b(int i2) {
        if (i2 < 0 || i2 >= this.f9437d) {
            throw new IndexOutOfBoundsException(c(i2));
        }
    }

    private final String c(int i2) {
        int i3 = this.f9437d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    public final /* synthetic */ bm a(int i2) {
        if (i2 >= this.f9437d) {
            return new y(Arrays.copyOf(this.f9436c, i2), this.f9437d);
        }
        throw new IllegalArgumentException();
    }

    public final void a(boolean z) {
        a(this.f9437d, z);
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        a(i2, ((Boolean) obj).booleanValue());
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        c();
        bh.a(collection);
        if (!(collection instanceof y)) {
            return super.addAll(collection);
        }
        y yVar = (y) collection;
        int i2 = yVar.f9437d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f9437d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            boolean[] zArr = this.f9436c;
            if (i4 > zArr.length) {
                this.f9436c = Arrays.copyOf(zArr, i4);
            }
            System.arraycopy(yVar.f9436c, 0, this.f9436c, this.f9437d, yVar.f9437d);
            this.f9437d = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return super.equals(obj);
        }
        y yVar = (y) obj;
        if (this.f9437d != yVar.f9437d) {
            return false;
        }
        boolean[] zArr = yVar.f9436c;
        for (int i2 = 0; i2 < this.f9437d; i2++) {
            if (this.f9436c[i2] != zArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i2) {
        b(i2);
        return Boolean.valueOf(this.f9436c[i2]);
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f9437d; i3++) {
            i2 = (i2 * 31) + bh.a(this.f9436c[i3]);
        }
        return i2;
    }

    public final /* synthetic */ Object remove(int i2) {
        c();
        b(i2);
        boolean[] zArr = this.f9436c;
        boolean z = zArr[i2];
        int i3 = this.f9437d;
        if (i2 < i3 - 1) {
            System.arraycopy(zArr, i2 + 1, zArr, i2, i3 - i2);
        }
        this.f9437d--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    public final boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f9437d; i2++) {
            if (obj.equals(Boolean.valueOf(this.f9436c[i2]))) {
                boolean[] zArr = this.f9436c;
                System.arraycopy(zArr, i2 + 1, zArr, i2, this.f9437d - i2);
                this.f9437d--;
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
            boolean[] zArr = this.f9436c;
            System.arraycopy(zArr, i3, zArr, i2, this.f9437d - i3);
            this.f9437d -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        c();
        b(i2);
        boolean[] zArr = this.f9436c;
        boolean z = zArr[i2];
        zArr[i2] = booleanValue;
        return Boolean.valueOf(z);
    }

    public final int size() {
        return this.f9437d;
    }

    static {
        y yVar = new y();
        f9435b = yVar;
        yVar.f9429a = false;
    }
}
