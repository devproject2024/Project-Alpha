package com.google.android.gms.internal.p001firebaseperf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-perf.el  reason: invalid package */
final class el extends cj<Long> implements dz<Long>, fl, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final el f9598b;

    /* renamed from: c  reason: collision with root package name */
    private long[] f9599c;

    /* renamed from: d  reason: collision with root package name */
    private int f9600d;

    el() {
        this(new long[10], 0);
    }

    private el(long[] jArr, int i2) {
        this.f9599c = jArr;
        this.f9600d = i2;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i2, int i3) {
        c();
        if (i3 >= i2) {
            long[] jArr = this.f9599c;
            System.arraycopy(jArr, i3, jArr, i2, this.f9600d - i3);
            this.f9600d -= i3 - i2;
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
        if (this.f9600d != elVar.f9600d) {
            return false;
        }
        long[] jArr = elVar.f9599c;
        for (int i2 = 0; i2 < this.f9600d; i2++) {
            if (this.f9599c[i2] != jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f9600d; i3++) {
            i2 = (i2 * 31) + dt.a(this.f9599c[i3]);
        }
        return i2;
    }

    public final long a(int i2) {
        b(i2);
        return this.f9599c[i2];
    }

    public final int size() {
        return this.f9600d;
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        c();
        dt.a(collection);
        if (!(collection instanceof el)) {
            return super.addAll(collection);
        }
        el elVar = (el) collection;
        int i2 = elVar.f9600d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f9600d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            long[] jArr = this.f9599c;
            if (i4 > jArr.length) {
                this.f9599c = Arrays.copyOf(jArr, i4);
            }
            System.arraycopy(elVar.f9599c, 0, this.f9599c, this.f9600d, elVar.f9600d);
            this.f9600d = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f9600d; i2++) {
            if (obj.equals(Long.valueOf(this.f9599c[i2]))) {
                long[] jArr = this.f9599c;
                System.arraycopy(jArr, i2 + 1, jArr, i2, (this.f9600d - i2) - 1);
                this.f9600d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void b(int i2) {
        if (i2 < 0 || i2 >= this.f9600d) {
            throw new IndexOutOfBoundsException(c(i2));
        }
    }

    private final String c(int i2) {
        int i3 = this.f9600d;
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
        b(i2);
        long[] jArr = this.f9599c;
        long j = jArr[i2];
        jArr[i2] = longValue;
        return Long.valueOf(j);
    }

    public final /* synthetic */ Object remove(int i2) {
        c();
        b(i2);
        long[] jArr = this.f9599c;
        long j = jArr[i2];
        int i3 = this.f9600d;
        if (i2 < i3 - 1) {
            System.arraycopy(jArr, i2 + 1, jArr, i2, (i3 - i2) - 1);
        }
        this.f9600d--;
        this.modCount++;
        return Long.valueOf(j);
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        long longValue = ((Long) obj).longValue();
        c();
        if (i2 < 0 || i2 > (i3 = this.f9600d)) {
            throw new IndexOutOfBoundsException(c(i2));
        }
        long[] jArr = this.f9599c;
        if (i3 < jArr.length) {
            System.arraycopy(jArr, i2, jArr, i2 + 1, i3 - i2);
        } else {
            long[] jArr2 = new long[(((i3 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            System.arraycopy(this.f9599c, i2, jArr2, i2 + 1, this.f9600d - i2);
            this.f9599c = jArr2;
        }
        this.f9599c[i2] = longValue;
        this.f9600d++;
        this.modCount++;
    }

    public final /* synthetic */ dz d(int i2) {
        if (i2 >= this.f9600d) {
            return new el(Arrays.copyOf(this.f9599c, i2), this.f9600d);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i2) {
        return Long.valueOf(a(i2));
    }

    static {
        el elVar = new el(new long[0], 0);
        f9598b = elVar;
        elVar.f9521a = false;
    }
}
