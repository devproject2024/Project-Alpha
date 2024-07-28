package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class fg extends cp<Long> implements eq<Long>, gf, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final fg f11134b;

    /* renamed from: c  reason: collision with root package name */
    private long[] f11135c;

    /* renamed from: d  reason: collision with root package name */
    private int f11136d;

    fg() {
        this(new long[10], 0);
    }

    private fg(long[] jArr, int i2) {
        this.f11135c = jArr;
        this.f11136d = i2;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i2, int i3) {
        c();
        if (i3 >= i2) {
            long[] jArr = this.f11135c;
            System.arraycopy(jArr, i3, jArr, i2, this.f11136d - i3);
            this.f11136d -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fg)) {
            return super.equals(obj);
        }
        fg fgVar = (fg) obj;
        if (this.f11136d != fgVar.f11136d) {
            return false;
        }
        long[] jArr = fgVar.f11135c;
        for (int i2 = 0; i2 < this.f11136d; i2++) {
            if (this.f11135c[i2] != jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f11136d; i3++) {
            i2 = (i2 * 31) + ek.a(this.f11135c[i3]);
        }
        return i2;
    }

    public final long b(int i2) {
        c(i2);
        return this.f11135c[i2];
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f11135c[i2] == longValue) {
                return i2;
            }
        }
        return -1;
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final int size() {
        return this.f11136d;
    }

    public final void a(long j) {
        c();
        int i2 = this.f11136d;
        long[] jArr = this.f11135c;
        if (i2 == jArr.length) {
            long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            this.f11135c = jArr2;
        }
        long[] jArr3 = this.f11135c;
        int i3 = this.f11136d;
        this.f11136d = i3 + 1;
        jArr3[i3] = j;
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        c();
        ek.a(collection);
        if (!(collection instanceof fg)) {
            return super.addAll(collection);
        }
        fg fgVar = (fg) collection;
        int i2 = fgVar.f11136d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f11136d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            long[] jArr = this.f11135c;
            if (i4 > jArr.length) {
                this.f11135c = Arrays.copyOf(jArr, i4);
            }
            System.arraycopy(fgVar.f11135c, 0, this.f11135c, this.f11136d, fgVar.f11136d);
            this.f11136d = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f11136d; i2++) {
            if (obj.equals(Long.valueOf(this.f11135c[i2]))) {
                long[] jArr = this.f11135c;
                System.arraycopy(jArr, i2 + 1, jArr, i2, (this.f11136d - i2) - 1);
                this.f11136d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void c(int i2) {
        if (i2 < 0 || i2 >= this.f11136d) {
            throw new IndexOutOfBoundsException(d(i2));
        }
    }

    private final String d(int i2) {
        int i3 = this.f11136d;
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
        long[] jArr = this.f11135c;
        long j = jArr[i2];
        jArr[i2] = longValue;
        return Long.valueOf(j);
    }

    public final /* synthetic */ Object remove(int i2) {
        c();
        c(i2);
        long[] jArr = this.f11135c;
        long j = jArr[i2];
        int i3 = this.f11136d;
        if (i2 < i3 - 1) {
            System.arraycopy(jArr, i2 + 1, jArr, i2, (i3 - i2) - 1);
        }
        this.f11136d--;
        this.modCount++;
        return Long.valueOf(j);
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        long longValue = ((Long) obj).longValue();
        c();
        if (i2 < 0 || i2 > (i3 = this.f11136d)) {
            throw new IndexOutOfBoundsException(d(i2));
        }
        long[] jArr = this.f11135c;
        if (i3 < jArr.length) {
            System.arraycopy(jArr, i2, jArr, i2 + 1, i3 - i2);
        } else {
            long[] jArr2 = new long[(((i3 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            System.arraycopy(this.f11135c, i2, jArr2, i2 + 1, this.f11136d - i2);
            this.f11135c = jArr2;
        }
        this.f11135c[i2] = longValue;
        this.f11136d++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        a(((Long) obj).longValue());
        return true;
    }

    public final /* synthetic */ eq a(int i2) {
        if (i2 >= this.f11136d) {
            return new fg(Arrays.copyOf(this.f11135c, i2), this.f11136d);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i2) {
        return Long.valueOf(b(i2));
    }

    static {
        fg fgVar = new fg(new long[0], 0);
        f11134b = fgVar;
        fgVar.f11013a = false;
    }
}
