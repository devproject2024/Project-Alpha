package com.google.c;

import com.google.c.ac;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class ak extends c<Long> implements ac.h, be, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final ak f37716b;

    /* renamed from: c  reason: collision with root package name */
    private long[] f37717c;

    /* renamed from: d  reason: collision with root package name */
    private int f37718d;

    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        long longValue = ((Long) obj).longValue();
        c();
        if (i2 < 0 || i2 > (i3 = this.f37718d)) {
            throw new IndexOutOfBoundsException(d(i2));
        }
        long[] jArr = this.f37717c;
        if (i3 < jArr.length) {
            System.arraycopy(jArr, i2, jArr, i2 + 1, i3 - i2);
        } else {
            long[] jArr2 = new long[(((i3 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            System.arraycopy(this.f37717c, i2, jArr2, i2 + 1, this.f37718d - i2);
            this.f37717c = jArr2;
        }
        this.f37717c[i2] = longValue;
        this.f37718d++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        a(((Long) obj).longValue());
        return true;
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        long longValue = ((Long) obj).longValue();
        c();
        c(i2);
        long[] jArr = this.f37717c;
        long j = jArr[i2];
        jArr[i2] = longValue;
        return Long.valueOf(j);
    }

    static {
        ak akVar = new ak(new long[0], 0);
        f37716b = akVar;
        akVar.f37832a = false;
    }

    ak() {
        this(new long[10], 0);
    }

    private ak(long[] jArr, int i2) {
        this.f37717c = jArr;
        this.f37718d = i2;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i2, int i3) {
        c();
        if (i3 >= i2) {
            long[] jArr = this.f37717c;
            System.arraycopy(jArr, i3, jArr, i2, this.f37718d - i3);
            this.f37718d -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ak)) {
            return super.equals(obj);
        }
        ak akVar = (ak) obj;
        if (this.f37718d != akVar.f37718d) {
            return false;
        }
        long[] jArr = akVar.f37717c;
        for (int i2 = 0; i2 < this.f37718d; i2++) {
            if (this.f37717c[i2] != jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f37718d; i3++) {
            i2 = (i2 * 31) + ac.a(this.f37717c[i3]);
        }
        return i2;
    }

    public final long b(int i2) {
        c(i2);
        return this.f37717c[i2];
    }

    public final int size() {
        return this.f37718d;
    }

    public final void a(long j) {
        c();
        int i2 = this.f37718d;
        long[] jArr = this.f37717c;
        if (i2 == jArr.length) {
            long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            this.f37717c = jArr2;
        }
        long[] jArr3 = this.f37717c;
        int i3 = this.f37718d;
        this.f37718d = i3 + 1;
        jArr3[i3] = j;
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        c();
        ac.a(collection);
        if (!(collection instanceof ak)) {
            return super.addAll(collection);
        }
        ak akVar = (ak) collection;
        int i2 = akVar.f37718d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f37718d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            long[] jArr = this.f37717c;
            if (i4 > jArr.length) {
                this.f37717c = Arrays.copyOf(jArr, i4);
            }
            System.arraycopy(akVar.f37717c, 0, this.f37717c, this.f37718d, akVar.f37718d);
            this.f37718d = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f37718d; i2++) {
            if (obj.equals(Long.valueOf(this.f37717c[i2]))) {
                long[] jArr = this.f37717c;
                System.arraycopy(jArr, i2 + 1, jArr, i2, (this.f37718d - i2) - 1);
                this.f37718d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private void c(int i2) {
        if (i2 < 0 || i2 >= this.f37718d) {
            throw new IndexOutOfBoundsException(d(i2));
        }
    }

    private String d(int i2) {
        return "Index:" + i2 + ", Size:" + this.f37718d;
    }

    public final /* synthetic */ Object remove(int i2) {
        c();
        c(i2);
        long[] jArr = this.f37717c;
        long j = jArr[i2];
        int i3 = this.f37718d;
        if (i2 < i3 - 1) {
            System.arraycopy(jArr, i2 + 1, jArr, i2, (i3 - i2) - 1);
        }
        this.f37718d--;
        this.modCount++;
        return Long.valueOf(j);
    }

    public final /* synthetic */ ac.i a(int i2) {
        if (i2 >= this.f37718d) {
            return new ak(Arrays.copyOf(this.f37717c, i2), this.f37718d);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i2) {
        return Long.valueOf(b(i2));
    }
}
