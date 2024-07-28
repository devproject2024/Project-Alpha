package com.google.c;

import com.google.c.ac;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class o extends c<Double> implements ac.b, be, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final o f37900b;

    /* renamed from: c  reason: collision with root package name */
    private double[] f37901c;

    /* renamed from: d  reason: collision with root package name */
    private int f37902d;

    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        double doubleValue = ((Double) obj).doubleValue();
        c();
        if (i2 < 0 || i2 > (i3 = this.f37902d)) {
            throw new IndexOutOfBoundsException(c(i2));
        }
        double[] dArr = this.f37901c;
        if (i3 < dArr.length) {
            System.arraycopy(dArr, i2, dArr, i2 + 1, i3 - i2);
        } else {
            double[] dArr2 = new double[(((i3 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            System.arraycopy(this.f37901c, i2, dArr2, i2 + 1, this.f37902d - i2);
            this.f37901c = dArr2;
        }
        this.f37901c[i2] = doubleValue;
        this.f37902d++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        a(((Double) obj).doubleValue());
        return true;
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        c();
        b(i2);
        double[] dArr = this.f37901c;
        double d2 = dArr[i2];
        dArr[i2] = doubleValue;
        return Double.valueOf(d2);
    }

    static {
        o oVar = new o(new double[0], 0);
        f37900b = oVar;
        oVar.f37832a = false;
    }

    o() {
        this(new double[10], 0);
    }

    private o(double[] dArr, int i2) {
        this.f37901c = dArr;
        this.f37902d = i2;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i2, int i3) {
        c();
        if (i3 >= i2) {
            double[] dArr = this.f37901c;
            System.arraycopy(dArr, i3, dArr, i2, this.f37902d - i3);
            this.f37902d -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return super.equals(obj);
        }
        o oVar = (o) obj;
        if (this.f37902d != oVar.f37902d) {
            return false;
        }
        double[] dArr = oVar.f37901c;
        for (int i2 = 0; i2 < this.f37902d; i2++) {
            if (Double.doubleToLongBits(this.f37901c[i2]) != Double.doubleToLongBits(dArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f37902d; i3++) {
            i2 = (i2 * 31) + ac.a(Double.doubleToLongBits(this.f37901c[i3]));
        }
        return i2;
    }

    public final int size() {
        return this.f37902d;
    }

    public final void a(double d2) {
        c();
        int i2 = this.f37902d;
        double[] dArr = this.f37901c;
        if (i2 == dArr.length) {
            double[] dArr2 = new double[(((i2 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            this.f37901c = dArr2;
        }
        double[] dArr3 = this.f37901c;
        int i3 = this.f37902d;
        this.f37902d = i3 + 1;
        dArr3[i3] = d2;
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        c();
        ac.a(collection);
        if (!(collection instanceof o)) {
            return super.addAll(collection);
        }
        o oVar = (o) collection;
        int i2 = oVar.f37902d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f37902d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            double[] dArr = this.f37901c;
            if (i4 > dArr.length) {
                this.f37901c = Arrays.copyOf(dArr, i4);
            }
            System.arraycopy(oVar.f37901c, 0, this.f37901c, this.f37902d, oVar.f37902d);
            this.f37902d = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f37902d; i2++) {
            if (obj.equals(Double.valueOf(this.f37901c[i2]))) {
                double[] dArr = this.f37901c;
                System.arraycopy(dArr, i2 + 1, dArr, i2, (this.f37902d - i2) - 1);
                this.f37902d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private void b(int i2) {
        if (i2 < 0 || i2 >= this.f37902d) {
            throw new IndexOutOfBoundsException(c(i2));
        }
    }

    private String c(int i2) {
        return "Index:" + i2 + ", Size:" + this.f37902d;
    }

    public final /* synthetic */ Object remove(int i2) {
        c();
        b(i2);
        double[] dArr = this.f37901c;
        double d2 = dArr[i2];
        int i3 = this.f37902d;
        if (i2 < i3 - 1) {
            System.arraycopy(dArr, i2 + 1, dArr, i2, (i3 - i2) - 1);
        }
        this.f37902d--;
        this.modCount++;
        return Double.valueOf(d2);
    }

    public final /* synthetic */ ac.i a(int i2) {
        if (i2 >= this.f37902d) {
            return new o(Arrays.copyOf(this.f37901c, i2), this.f37902d);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i2) {
        b(i2);
        return Double.valueOf(this.f37901c[i2]);
    }
}
