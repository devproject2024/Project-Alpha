package com.google.android.gms.internal.p001firebaseperf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-perf.dr  reason: invalid package */
final class dr extends cj<Integer> implements dx, fl, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final dr f9578b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f9579c;

    /* renamed from: d  reason: collision with root package name */
    private int f9580d;

    public static dr d() {
        return f9578b;
    }

    dr() {
        this(new int[10], 0);
    }

    private dr(int[] iArr, int i2) {
        this.f9579c = iArr;
        this.f9580d = i2;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i2, int i3) {
        c();
        if (i3 >= i2) {
            int[] iArr = this.f9579c;
            System.arraycopy(iArr, i3, iArr, i2, this.f9580d - i3);
            this.f9580d -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dr)) {
            return super.equals(obj);
        }
        dr drVar = (dr) obj;
        if (this.f9580d != drVar.f9580d) {
            return false;
        }
        int[] iArr = drVar.f9579c;
        for (int i2 = 0; i2 < this.f9580d; i2++) {
            if (this.f9579c[i2] != iArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f9580d; i3++) {
            i2 = (i2 * 31) + this.f9579c[i3];
        }
        return i2;
    }

    /* renamed from: a */
    public final dx d(int i2) {
        if (i2 >= this.f9580d) {
            return new dr(Arrays.copyOf(this.f9579c, i2), this.f9580d);
        }
        throw new IllegalArgumentException();
    }

    public final int b(int i2) {
        e(i2);
        return this.f9579c[i2];
    }

    public final int size() {
        return this.f9580d;
    }

    public final void c(int i2) {
        a(this.f9580d, i2);
    }

    private final void a(int i2, int i3) {
        int i4;
        c();
        if (i2 < 0 || i2 > (i4 = this.f9580d)) {
            throw new IndexOutOfBoundsException(f(i2));
        }
        int[] iArr = this.f9579c;
        if (i4 < iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i4 - i2);
        } else {
            int[] iArr2 = new int[(((i4 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            System.arraycopy(this.f9579c, i2, iArr2, i2 + 1, this.f9580d - i2);
            this.f9579c = iArr2;
        }
        this.f9579c[i2] = i3;
        this.f9580d++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        c();
        dt.a(collection);
        if (!(collection instanceof dr)) {
            return super.addAll(collection);
        }
        dr drVar = (dr) collection;
        int i2 = drVar.f9580d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f9580d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            int[] iArr = this.f9579c;
            if (i4 > iArr.length) {
                this.f9579c = Arrays.copyOf(iArr, i4);
            }
            System.arraycopy(drVar.f9579c, 0, this.f9579c, this.f9580d, drVar.f9580d);
            this.f9580d = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f9580d; i2++) {
            if (obj.equals(Integer.valueOf(this.f9579c[i2]))) {
                int[] iArr = this.f9579c;
                System.arraycopy(iArr, i2 + 1, iArr, i2, (this.f9580d - i2) - 1);
                this.f9580d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void e(int i2) {
        if (i2 < 0 || i2 >= this.f9580d) {
            throw new IndexOutOfBoundsException(f(i2));
        }
    }

    private final String f(int i2) {
        int i3 = this.f9580d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        int intValue = ((Integer) obj).intValue();
        c();
        e(i2);
        int[] iArr = this.f9579c;
        int i3 = iArr[i2];
        iArr[i2] = intValue;
        return Integer.valueOf(i3);
    }

    public final /* synthetic */ Object remove(int i2) {
        c();
        e(i2);
        int[] iArr = this.f9579c;
        int i3 = iArr[i2];
        int i4 = this.f9580d;
        if (i2 < i4 - 1) {
            System.arraycopy(iArr, i2 + 1, iArr, i2, (i4 - i2) - 1);
        }
        this.f9580d--;
        this.modCount++;
        return Integer.valueOf(i3);
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        a(i2, ((Integer) obj).intValue());
    }

    public final /* synthetic */ Object get(int i2) {
        return Integer.valueOf(b(i2));
    }

    static {
        dr drVar = new dr(new int[0], 0);
        f9578b = drVar;
        drVar.f9521a = false;
    }
}
