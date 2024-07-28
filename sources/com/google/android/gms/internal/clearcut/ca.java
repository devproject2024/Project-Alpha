package com.google.android.gms.internal.clearcut;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class ca extends u<Long> implements bm<Long>, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final ca f9234b;

    /* renamed from: c  reason: collision with root package name */
    private long[] f9235c;

    /* renamed from: d  reason: collision with root package name */
    private int f9236d;

    ca() {
        this(new long[10], 0);
    }

    private ca(long[] jArr, int i2) {
        this.f9235c = jArr;
        this.f9236d = i2;
    }

    private final void a(int i2, long j) {
        int i3;
        c();
        if (i2 < 0 || i2 > (i3 = this.f9236d)) {
            throw new IndexOutOfBoundsException(d(i2));
        }
        long[] jArr = this.f9235c;
        if (i3 < jArr.length) {
            System.arraycopy(jArr, i2, jArr, i2 + 1, i3 - i2);
        } else {
            long[] jArr2 = new long[(((i3 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            System.arraycopy(this.f9235c, i2, jArr2, i2 + 1, this.f9236d - i2);
            this.f9235c = jArr2;
        }
        this.f9235c[i2] = j;
        this.f9236d++;
        this.modCount++;
    }

    private final void c(int i2) {
        if (i2 < 0 || i2 >= this.f9236d) {
            throw new IndexOutOfBoundsException(d(i2));
        }
    }

    public static ca d() {
        return f9234b;
    }

    private final String d(int i2) {
        int i3 = this.f9236d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    public final /* synthetic */ bm a(int i2) {
        if (i2 >= this.f9236d) {
            return new ca(Arrays.copyOf(this.f9235c, i2), this.f9236d);
        }
        throw new IllegalArgumentException();
    }

    public final void a(long j) {
        a(this.f9236d, j);
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        a(i2, ((Long) obj).longValue());
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        c();
        bh.a(collection);
        if (!(collection instanceof ca)) {
            return super.addAll(collection);
        }
        ca caVar = (ca) collection;
        int i2 = caVar.f9236d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f9236d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            long[] jArr = this.f9235c;
            if (i4 > jArr.length) {
                this.f9235c = Arrays.copyOf(jArr, i4);
            }
            System.arraycopy(caVar.f9235c, 0, this.f9235c, this.f9236d, caVar.f9236d);
            this.f9236d = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final long b(int i2) {
        c(i2);
        return this.f9235c[i2];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ca)) {
            return super.equals(obj);
        }
        ca caVar = (ca) obj;
        if (this.f9236d != caVar.f9236d) {
            return false;
        }
        long[] jArr = caVar.f9235c;
        for (int i2 = 0; i2 < this.f9236d; i2++) {
            if (this.f9235c[i2] != jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i2) {
        return Long.valueOf(b(i2));
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f9236d; i3++) {
            i2 = (i2 * 31) + bh.a(this.f9235c[i3]);
        }
        return i2;
    }

    public final /* synthetic */ Object remove(int i2) {
        c();
        c(i2);
        long[] jArr = this.f9235c;
        long j = jArr[i2];
        int i3 = this.f9236d;
        if (i2 < i3 - 1) {
            System.arraycopy(jArr, i2 + 1, jArr, i2, i3 - i2);
        }
        this.f9236d--;
        this.modCount++;
        return Long.valueOf(j);
    }

    public final boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f9236d; i2++) {
            if (obj.equals(Long.valueOf(this.f9235c[i2]))) {
                long[] jArr = this.f9235c;
                System.arraycopy(jArr, i2 + 1, jArr, i2, this.f9236d - i2);
                this.f9236d--;
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
            long[] jArr = this.f9235c;
            System.arraycopy(jArr, i3, jArr, i2, this.f9236d - i3);
            this.f9236d -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        long longValue = ((Long) obj).longValue();
        c();
        c(i2);
        long[] jArr = this.f9235c;
        long j = jArr[i2];
        jArr[i2] = longValue;
        return Long.valueOf(j);
    }

    public final int size() {
        return this.f9236d;
    }

    static {
        ca caVar = new ca();
        f9234b = caVar;
        caVar.f9429a = false;
    }
}
