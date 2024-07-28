package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class df extends cg<Double> implements ed<Double>, fs, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final df f10565b;

    /* renamed from: c  reason: collision with root package name */
    private double[] f10566c;

    /* renamed from: d  reason: collision with root package name */
    private int f10567d;

    df() {
        this(new double[10], 0);
    }

    private df(double[] dArr, int i2) {
        this.f10566c = dArr;
        this.f10567d = i2;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i2, int i3) {
        r_();
        if (i3 >= i2) {
            double[] dArr = this.f10566c;
            System.arraycopy(dArr, i3, dArr, i2, this.f10567d - i3);
            this.f10567d -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof df)) {
            return super.equals(obj);
        }
        df dfVar = (df) obj;
        if (this.f10567d != dfVar.f10567d) {
            return false;
        }
        double[] dArr = dfVar.f10566c;
        for (int i2 = 0; i2 < this.f10567d; i2++) {
            if (Double.doubleToLongBits(this.f10566c[i2]) != Double.doubleToLongBits(dArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f10567d; i3++) {
            i2 = (i2 * 31) + dx.a(Double.doubleToLongBits(this.f10566c[i3]));
        }
        return i2;
    }

    public final int size() {
        return this.f10567d;
    }

    public final void a(double d2) {
        r_();
        int i2 = this.f10567d;
        double[] dArr = this.f10566c;
        if (i2 == dArr.length) {
            double[] dArr2 = new double[(((i2 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            this.f10566c = dArr2;
        }
        double[] dArr3 = this.f10566c;
        int i3 = this.f10567d;
        this.f10567d = i3 + 1;
        dArr3[i3] = d2;
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        r_();
        dx.a(collection);
        if (!(collection instanceof df)) {
            return super.addAll(collection);
        }
        df dfVar = (df) collection;
        int i2 = dfVar.f10567d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f10567d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            double[] dArr = this.f10566c;
            if (i4 > dArr.length) {
                this.f10566c = Arrays.copyOf(dArr, i4);
            }
            System.arraycopy(dfVar.f10566c, 0, this.f10566c, this.f10567d, dfVar.f10567d);
            this.f10567d = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        r_();
        for (int i2 = 0; i2 < this.f10567d; i2++) {
            if (obj.equals(Double.valueOf(this.f10566c[i2]))) {
                double[] dArr = this.f10566c;
                System.arraycopy(dArr, i2 + 1, dArr, i2, (this.f10567d - i2) - 1);
                this.f10567d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void b(int i2) {
        if (i2 < 0 || i2 >= this.f10567d) {
            throw new IndexOutOfBoundsException(c(i2));
        }
    }

    private final String c(int i2) {
        int i3 = this.f10567d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        r_();
        b(i2);
        double[] dArr = this.f10566c;
        double d2 = dArr[i2];
        dArr[i2] = doubleValue;
        return Double.valueOf(d2);
    }

    public final /* synthetic */ Object remove(int i2) {
        r_();
        b(i2);
        double[] dArr = this.f10566c;
        double d2 = dArr[i2];
        int i3 = this.f10567d;
        if (i2 < i3 - 1) {
            System.arraycopy(dArr, i2 + 1, dArr, i2, (i3 - i2) - 1);
        }
        this.f10567d--;
        this.modCount++;
        return Double.valueOf(d2);
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        double doubleValue = ((Double) obj).doubleValue();
        r_();
        if (i2 < 0 || i2 > (i3 = this.f10567d)) {
            throw new IndexOutOfBoundsException(c(i2));
        }
        double[] dArr = this.f10566c;
        if (i3 < dArr.length) {
            System.arraycopy(dArr, i2, dArr, i2 + 1, i3 - i2);
        } else {
            double[] dArr2 = new double[(((i3 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            System.arraycopy(this.f10566c, i2, dArr2, i2 + 1, this.f10567d - i2);
            this.f10566c = dArr2;
        }
        this.f10566c[i2] = doubleValue;
        this.f10567d++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        a(((Double) obj).doubleValue());
        return true;
    }

    public final /* synthetic */ ed a(int i2) {
        if (i2 >= this.f10567d) {
            return new df(Arrays.copyOf(this.f10566c, i2), this.f10567d);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i2) {
        b(i2);
        return Double.valueOf(this.f10566c[i2]);
    }

    static {
        df dfVar = new df(new double[0], 0);
        f10565b = dfVar;
        dfVar.f10522a = false;
    }
}
