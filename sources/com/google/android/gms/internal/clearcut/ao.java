package com.google.android.gms.internal.clearcut;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class ao extends u<Double> implements bm<Double>, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final ao f9157b;

    /* renamed from: c  reason: collision with root package name */
    private double[] f9158c;

    /* renamed from: d  reason: collision with root package name */
    private int f9159d;

    ao() {
        this(new double[10], 0);
    }

    private ao(double[] dArr, int i2) {
        this.f9158c = dArr;
        this.f9159d = i2;
    }

    private final void a(int i2, double d2) {
        int i3;
        c();
        if (i2 < 0 || i2 > (i3 = this.f9159d)) {
            throw new IndexOutOfBoundsException(c(i2));
        }
        double[] dArr = this.f9158c;
        if (i3 < dArr.length) {
            System.arraycopy(dArr, i2, dArr, i2 + 1, i3 - i2);
        } else {
            double[] dArr2 = new double[(((i3 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            System.arraycopy(this.f9158c, i2, dArr2, i2 + 1, this.f9159d - i2);
            this.f9158c = dArr2;
        }
        this.f9158c[i2] = d2;
        this.f9159d++;
        this.modCount++;
    }

    private final void b(int i2) {
        if (i2 < 0 || i2 >= this.f9159d) {
            throw new IndexOutOfBoundsException(c(i2));
        }
    }

    private final String c(int i2) {
        int i3 = this.f9159d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    public final /* synthetic */ bm a(int i2) {
        if (i2 >= this.f9159d) {
            return new ao(Arrays.copyOf(this.f9158c, i2), this.f9159d);
        }
        throw new IllegalArgumentException();
    }

    public final void a(double d2) {
        a(this.f9159d, d2);
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        a(i2, ((Double) obj).doubleValue());
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        c();
        bh.a(collection);
        if (!(collection instanceof ao)) {
            return super.addAll(collection);
        }
        ao aoVar = (ao) collection;
        int i2 = aoVar.f9159d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f9159d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            double[] dArr = this.f9158c;
            if (i4 > dArr.length) {
                this.f9158c = Arrays.copyOf(dArr, i4);
            }
            System.arraycopy(aoVar.f9158c, 0, this.f9158c, this.f9159d, aoVar.f9159d);
            this.f9159d = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ao)) {
            return super.equals(obj);
        }
        ao aoVar = (ao) obj;
        if (this.f9159d != aoVar.f9159d) {
            return false;
        }
        double[] dArr = aoVar.f9158c;
        for (int i2 = 0; i2 < this.f9159d; i2++) {
            if (this.f9158c[i2] != dArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i2) {
        b(i2);
        return Double.valueOf(this.f9158c[i2]);
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f9159d; i3++) {
            i2 = (i2 * 31) + bh.a(Double.doubleToLongBits(this.f9158c[i3]));
        }
        return i2;
    }

    public final /* synthetic */ Object remove(int i2) {
        c();
        b(i2);
        double[] dArr = this.f9158c;
        double d2 = dArr[i2];
        int i3 = this.f9159d;
        if (i2 < i3 - 1) {
            System.arraycopy(dArr, i2 + 1, dArr, i2, i3 - i2);
        }
        this.f9159d--;
        this.modCount++;
        return Double.valueOf(d2);
    }

    public final boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f9159d; i2++) {
            if (obj.equals(Double.valueOf(this.f9158c[i2]))) {
                double[] dArr = this.f9158c;
                System.arraycopy(dArr, i2 + 1, dArr, i2, this.f9159d - i2);
                this.f9159d--;
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
            double[] dArr = this.f9158c;
            System.arraycopy(dArr, i3, dArr, i2, this.f9159d - i3);
            this.f9159d -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        c();
        b(i2);
        double[] dArr = this.f9158c;
        double d2 = dArr[i2];
        dArr[i2] = doubleValue;
        return Double.valueOf(d2);
    }

    public final int size() {
        return this.f9159d;
    }

    static {
        ao aoVar = new ao();
        f9157b = aoVar;
        aoVar.f9429a = false;
    }
}
