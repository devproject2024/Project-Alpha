package com.google.android.gms.internal.icing;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class cq extends ap<Long> implements ce<Long>, dn, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final cq f10139b;

    /* renamed from: c  reason: collision with root package name */
    private long[] f10140c;

    /* renamed from: d  reason: collision with root package name */
    private int f10141d;

    public static cq d() {
        return f10139b;
    }

    cq() {
        this(new long[10], 0);
    }

    private cq(long[] jArr, int i2) {
        this.f10140c = jArr;
        this.f10141d = i2;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i2, int i3) {
        c();
        if (i3 >= i2) {
            long[] jArr = this.f10140c;
            System.arraycopy(jArr, i3, jArr, i2, this.f10141d - i3);
            this.f10141d -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cq)) {
            return super.equals(obj);
        }
        cq cqVar = (cq) obj;
        if (this.f10141d != cqVar.f10141d) {
            return false;
        }
        long[] jArr = cqVar.f10140c;
        for (int i2 = 0; i2 < this.f10141d; i2++) {
            if (this.f10140c[i2] != jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f10141d; i3++) {
            i2 = (i2 * 31) + bx.a(this.f10140c[i3]);
        }
        return i2;
    }

    public final long b(int i2) {
        c(i2);
        return this.f10140c[i2];
    }

    public final int size() {
        return this.f10141d;
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        c();
        bx.a(collection);
        if (!(collection instanceof cq)) {
            return super.addAll(collection);
        }
        cq cqVar = (cq) collection;
        int i2 = cqVar.f10141d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f10141d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            long[] jArr = this.f10140c;
            if (i4 > jArr.length) {
                this.f10140c = Arrays.copyOf(jArr, i4);
            }
            System.arraycopy(cqVar.f10140c, 0, this.f10140c, this.f10141d, cqVar.f10141d);
            this.f10141d = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f10141d; i2++) {
            if (obj.equals(Long.valueOf(this.f10140c[i2]))) {
                long[] jArr = this.f10140c;
                System.arraycopy(jArr, i2 + 1, jArr, i2, (this.f10141d - i2) - 1);
                this.f10141d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void c(int i2) {
        if (i2 < 0 || i2 >= this.f10141d) {
            throw new IndexOutOfBoundsException(d(i2));
        }
    }

    private final String d(int i2) {
        int i3 = this.f10141d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        long longValue = ((Long) obj).longValue();
        c();
        c(i2);
        long[] jArr = this.f10140c;
        long j = jArr[i2];
        jArr[i2] = longValue;
        return Long.valueOf(j);
    }

    public final /* synthetic */ Object remove(int i2) {
        c();
        c(i2);
        long[] jArr = this.f10140c;
        long j = jArr[i2];
        int i3 = this.f10141d;
        if (i2 < i3 - 1) {
            System.arraycopy(jArr, i2 + 1, jArr, i2, (i3 - i2) - 1);
        }
        this.f10141d--;
        this.modCount++;
        return Long.valueOf(j);
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        long longValue = ((Long) obj).longValue();
        c();
        if (i2 < 0 || i2 > (i3 = this.f10141d)) {
            throw new IndexOutOfBoundsException(d(i2));
        }
        long[] jArr = this.f10140c;
        if (i3 < jArr.length) {
            System.arraycopy(jArr, i2, jArr, i2 + 1, i3 - i2);
        } else {
            long[] jArr2 = new long[(((i3 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            System.arraycopy(this.f10140c, i2, jArr2, i2 + 1, this.f10141d - i2);
            this.f10140c = jArr2;
        }
        this.f10140c[i2] = longValue;
        this.f10141d++;
        this.modCount++;
    }

    public final /* synthetic */ ce a(int i2) {
        if (i2 >= this.f10141d) {
            return new cq(Arrays.copyOf(this.f10140c, i2), this.f10141d);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i2) {
        return Long.valueOf(b(i2));
    }

    static {
        cq cqVar = new cq(new long[0], 0);
        f10139b = cqVar;
        cqVar.f10058a = false;
    }
}
