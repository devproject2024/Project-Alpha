package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class ds extends cp<Double> implements eq<Double>, gf, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final ds f11061b;

    /* renamed from: c  reason: collision with root package name */
    private double[] f11062c;

    /* renamed from: d  reason: collision with root package name */
    private int f11063d;

    ds() {
        this(new double[10], 0);
    }

    private ds(double[] dArr, int i2) {
        this.f11062c = dArr;
        this.f11063d = i2;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i2, int i3) {
        c();
        if (i3 >= i2) {
            double[] dArr = this.f11062c;
            System.arraycopy(dArr, i3, dArr, i2, this.f11063d - i3);
            this.f11063d -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ds)) {
            return super.equals(obj);
        }
        ds dsVar = (ds) obj;
        if (this.f11063d != dsVar.f11063d) {
            return false;
        }
        double[] dArr = dsVar.f11062c;
        for (int i2 = 0; i2 < this.f11063d; i2++) {
            if (Double.doubleToLongBits(this.f11062c[i2]) != Double.doubleToLongBits(dArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f11063d; i3++) {
            i2 = (i2 * 31) + ek.a(Double.doubleToLongBits(this.f11062c[i3]));
        }
        return i2;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f11062c[i2] == doubleValue) {
                return i2;
            }
        }
        return -1;
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final int size() {
        return this.f11063d;
    }

    public final void a(double d2) {
        c();
        int i2 = this.f11063d;
        double[] dArr = this.f11062c;
        if (i2 == dArr.length) {
            double[] dArr2 = new double[(((i2 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            this.f11062c = dArr2;
        }
        double[] dArr3 = this.f11062c;
        int i3 = this.f11063d;
        this.f11063d = i3 + 1;
        dArr3[i3] = d2;
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        c();
        ek.a(collection);
        if (!(collection instanceof ds)) {
            return super.addAll(collection);
        }
        ds dsVar = (ds) collection;
        int i2 = dsVar.f11063d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f11063d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            double[] dArr = this.f11062c;
            if (i4 > dArr.length) {
                this.f11062c = Arrays.copyOf(dArr, i4);
            }
            System.arraycopy(dsVar.f11062c, 0, this.f11062c, this.f11063d, dsVar.f11063d);
            this.f11063d = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f11063d; i2++) {
            if (obj.equals(Double.valueOf(this.f11062c[i2]))) {
                double[] dArr = this.f11062c;
                System.arraycopy(dArr, i2 + 1, dArr, i2, (this.f11063d - i2) - 1);
                this.f11063d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void b(int i2) {
        if (i2 < 0 || i2 >= this.f11063d) {
            throw new IndexOutOfBoundsException(c(i2));
        }
    }

    private final String c(int i2) {
        int i3 = this.f11063d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        c();
        b(i2);
        double[] dArr = this.f11062c;
        double d2 = dArr[i2];
        dArr[i2] = doubleValue;
        return Double.valueOf(d2);
    }

    public final /* synthetic */ Object remove(int i2) {
        c();
        b(i2);
        double[] dArr = this.f11062c;
        double d2 = dArr[i2];
        int i3 = this.f11063d;
        if (i2 < i3 - 1) {
            System.arraycopy(dArr, i2 + 1, dArr, i2, (i3 - i2) - 1);
        }
        this.f11063d--;
        this.modCount++;
        return Double.valueOf(d2);
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        double doubleValue = ((Double) obj).doubleValue();
        c();
        if (i2 < 0 || i2 > (i3 = this.f11063d)) {
            throw new IndexOutOfBoundsException(c(i2));
        }
        double[] dArr = this.f11062c;
        if (i3 < dArr.length) {
            System.arraycopy(dArr, i2, dArr, i2 + 1, i3 - i2);
        } else {
            double[] dArr2 = new double[(((i3 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            System.arraycopy(this.f11062c, i2, dArr2, i2 + 1, this.f11063d - i2);
            this.f11062c = dArr2;
        }
        this.f11062c[i2] = doubleValue;
        this.f11063d++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        a(((Double) obj).doubleValue());
        return true;
    }

    public final /* synthetic */ eq a(int i2) {
        if (i2 >= this.f11063d) {
            return new ds(Arrays.copyOf(this.f11062c, i2), this.f11063d);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i2) {
        b(i2);
        return Double.valueOf(this.f11062c[i2]);
    }

    static {
        ds dsVar = new ds(new double[0], 0);
        f11061b = dsVar;
        dsVar.f11013a = false;
    }
}
