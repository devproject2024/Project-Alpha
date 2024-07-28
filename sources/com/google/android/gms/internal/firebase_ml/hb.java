package com.google.android.gms.internal.firebase_ml;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class hb extends fe<Long> implements gq<Long>, hy, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final hb f9952b;

    /* renamed from: c  reason: collision with root package name */
    private long[] f9953c;

    /* renamed from: d  reason: collision with root package name */
    private int f9954d;

    hb() {
        this(new long[10], 0);
    }

    private hb(long[] jArr, int i2) {
        this.f9953c = jArr;
        this.f9954d = i2;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i2, int i3) {
        e();
        if (i3 >= i2) {
            long[] jArr = this.f9953c;
            System.arraycopy(jArr, i3, jArr, i2, this.f9954d - i3);
            this.f9954d -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof hb)) {
            return super.equals(obj);
        }
        hb hbVar = (hb) obj;
        if (this.f9954d != hbVar.f9954d) {
            return false;
        }
        long[] jArr = hbVar.f9953c;
        for (int i2 = 0; i2 < this.f9954d; i2++) {
            if (this.f9953c[i2] != jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f9954d; i3++) {
            i2 = (i2 * 31) + gk.a(this.f9953c[i3]);
        }
        return i2;
    }

    public final long a(int i2) {
        b(i2);
        return this.f9953c[i2];
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f9953c[i2] == longValue) {
                return i2;
            }
        }
        return -1;
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final int size() {
        return this.f9954d;
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        e();
        gk.a(collection);
        if (!(collection instanceof hb)) {
            return super.addAll(collection);
        }
        hb hbVar = (hb) collection;
        int i2 = hbVar.f9954d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f9954d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            long[] jArr = this.f9953c;
            if (i4 > jArr.length) {
                this.f9953c = Arrays.copyOf(jArr, i4);
            }
            System.arraycopy(hbVar.f9953c, 0, this.f9953c, this.f9954d, hbVar.f9954d);
            this.f9954d = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        e();
        for (int i2 = 0; i2 < this.f9954d; i2++) {
            if (obj.equals(Long.valueOf(this.f9953c[i2]))) {
                long[] jArr = this.f9953c;
                System.arraycopy(jArr, i2 + 1, jArr, i2, (this.f9954d - i2) - 1);
                this.f9954d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void b(int i2) {
        if (i2 < 0 || i2 >= this.f9954d) {
            throw new IndexOutOfBoundsException(c(i2));
        }
    }

    private final String c(int i2) {
        int i3 = this.f9954d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        long longValue = ((Long) obj).longValue();
        e();
        b(i2);
        long[] jArr = this.f9953c;
        long j = jArr[i2];
        jArr[i2] = longValue;
        return Long.valueOf(j);
    }

    public final /* synthetic */ Object remove(int i2) {
        e();
        b(i2);
        long[] jArr = this.f9953c;
        long j = jArr[i2];
        int i3 = this.f9954d;
        if (i2 < i3 - 1) {
            System.arraycopy(jArr, i2 + 1, jArr, i2, (i3 - i2) - 1);
        }
        this.f9954d--;
        this.modCount++;
        return Long.valueOf(j);
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        long longValue = ((Long) obj).longValue();
        e();
        if (i2 < 0 || i2 > (i3 = this.f9954d)) {
            throw new IndexOutOfBoundsException(c(i2));
        }
        long[] jArr = this.f9953c;
        if (i3 < jArr.length) {
            System.arraycopy(jArr, i2, jArr, i2 + 1, i3 - i2);
        } else {
            long[] jArr2 = new long[(((i3 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            System.arraycopy(this.f9953c, i2, jArr2, i2 + 1, this.f9954d - i2);
            this.f9953c = jArr2;
        }
        this.f9953c[i2] = longValue;
        this.f9954d++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        long longValue = ((Long) obj).longValue();
        e();
        int i2 = this.f9954d;
        long[] jArr = this.f9953c;
        if (i2 == jArr.length) {
            long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            this.f9953c = jArr2;
        }
        long[] jArr3 = this.f9953c;
        int i3 = this.f9954d;
        this.f9954d = i3 + 1;
        jArr3[i3] = longValue;
        return true;
    }

    public final /* synthetic */ gq d(int i2) {
        if (i2 >= this.f9954d) {
            return new hb(Arrays.copyOf(this.f9953c, i2), this.f9954d);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i2) {
        return Long.valueOf(a(i2));
    }

    static {
        hb hbVar = new hb(new long[0], 0);
        f9952b = hbVar;
        hbVar.f9878a = false;
    }
}
