package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class et extends cg<Long> implements ee, fs, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final et f10630b;

    /* renamed from: c  reason: collision with root package name */
    private long[] f10631c;

    /* renamed from: d  reason: collision with root package name */
    private int f10632d;

    public static et d() {
        return f10630b;
    }

    et() {
        this(new long[10], 0);
    }

    private et(long[] jArr, int i2) {
        this.f10631c = jArr;
        this.f10632d = i2;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i2, int i3) {
        r_();
        if (i3 >= i2) {
            long[] jArr = this.f10631c;
            System.arraycopy(jArr, i3, jArr, i2, this.f10632d - i3);
            this.f10632d -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof et)) {
            return super.equals(obj);
        }
        et etVar = (et) obj;
        if (this.f10632d != etVar.f10632d) {
            return false;
        }
        long[] jArr = etVar.f10631c;
        for (int i2 = 0; i2 < this.f10632d; i2++) {
            if (this.f10631c[i2] != jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f10632d; i3++) {
            i2 = (i2 * 31) + dx.a(this.f10631c[i3]);
        }
        return i2;
    }

    /* renamed from: c */
    public final ee a(int i2) {
        if (i2 >= this.f10632d) {
            return new et(Arrays.copyOf(this.f10631c, i2), this.f10632d);
        }
        throw new IllegalArgumentException();
    }

    public final long b(int i2) {
        d(i2);
        return this.f10631c[i2];
    }

    public final int size() {
        return this.f10632d;
    }

    public final void a(long j) {
        r_();
        int i2 = this.f10632d;
        long[] jArr = this.f10631c;
        if (i2 == jArr.length) {
            long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            this.f10631c = jArr2;
        }
        long[] jArr3 = this.f10631c;
        int i3 = this.f10632d;
        this.f10632d = i3 + 1;
        jArr3[i3] = j;
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        r_();
        dx.a(collection);
        if (!(collection instanceof et)) {
            return super.addAll(collection);
        }
        et etVar = (et) collection;
        int i2 = etVar.f10632d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f10632d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            long[] jArr = this.f10631c;
            if (i4 > jArr.length) {
                this.f10631c = Arrays.copyOf(jArr, i4);
            }
            System.arraycopy(etVar.f10631c, 0, this.f10631c, this.f10632d, etVar.f10632d);
            this.f10632d = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        r_();
        for (int i2 = 0; i2 < this.f10632d; i2++) {
            if (obj.equals(Long.valueOf(this.f10631c[i2]))) {
                long[] jArr = this.f10631c;
                System.arraycopy(jArr, i2 + 1, jArr, i2, (this.f10632d - i2) - 1);
                this.f10632d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void d(int i2) {
        if (i2 < 0 || i2 >= this.f10632d) {
            throw new IndexOutOfBoundsException(e(i2));
        }
    }

    private final String e(int i2) {
        int i3 = this.f10632d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        long longValue = ((Long) obj).longValue();
        r_();
        d(i2);
        long[] jArr = this.f10631c;
        long j = jArr[i2];
        jArr[i2] = longValue;
        return Long.valueOf(j);
    }

    public final /* synthetic */ Object remove(int i2) {
        r_();
        d(i2);
        long[] jArr = this.f10631c;
        long j = jArr[i2];
        int i3 = this.f10632d;
        if (i2 < i3 - 1) {
            System.arraycopy(jArr, i2 + 1, jArr, i2, (i3 - i2) - 1);
        }
        this.f10632d--;
        this.modCount++;
        return Long.valueOf(j);
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        long longValue = ((Long) obj).longValue();
        r_();
        if (i2 < 0 || i2 > (i3 = this.f10632d)) {
            throw new IndexOutOfBoundsException(e(i2));
        }
        long[] jArr = this.f10631c;
        if (i3 < jArr.length) {
            System.arraycopy(jArr, i2, jArr, i2 + 1, i3 - i2);
        } else {
            long[] jArr2 = new long[(((i3 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            System.arraycopy(this.f10631c, i2, jArr2, i2 + 1, this.f10632d - i2);
            this.f10631c = jArr2;
        }
        this.f10631c[i2] = longValue;
        this.f10632d++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        a(((Long) obj).longValue());
        return true;
    }

    public final /* synthetic */ Object get(int i2) {
        return Long.valueOf(b(i2));
    }

    static {
        et etVar = new et(new long[0], 0);
        f10630b = etVar;
        etVar.f10522a = false;
    }
}
