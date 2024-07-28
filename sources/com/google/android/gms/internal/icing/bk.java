package com.google.android.gms.internal.icing;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class bk extends ap<Double> implements ce<Double>, dn, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final bk f10087b;

    /* renamed from: c  reason: collision with root package name */
    private double[] f10088c;

    /* renamed from: d  reason: collision with root package name */
    private int f10089d;

    public static bk d() {
        return f10087b;
    }

    bk() {
        this(new double[10], 0);
    }

    private bk(double[] dArr, int i2) {
        this.f10088c = dArr;
        this.f10089d = i2;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i2, int i3) {
        c();
        if (i3 >= i2) {
            double[] dArr = this.f10088c;
            System.arraycopy(dArr, i3, dArr, i2, this.f10089d - i3);
            this.f10089d -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bk)) {
            return super.equals(obj);
        }
        bk bkVar = (bk) obj;
        if (this.f10089d != bkVar.f10089d) {
            return false;
        }
        double[] dArr = bkVar.f10088c;
        for (int i2 = 0; i2 < this.f10089d; i2++) {
            if (Double.doubleToLongBits(this.f10088c[i2]) != Double.doubleToLongBits(dArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f10089d; i3++) {
            i2 = (i2 * 31) + bx.a(Double.doubleToLongBits(this.f10088c[i3]));
        }
        return i2;
    }

    public final int size() {
        return this.f10089d;
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        c();
        bx.a(collection);
        if (!(collection instanceof bk)) {
            return super.addAll(collection);
        }
        bk bkVar = (bk) collection;
        int i2 = bkVar.f10089d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f10089d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            double[] dArr = this.f10088c;
            if (i4 > dArr.length) {
                this.f10088c = Arrays.copyOf(dArr, i4);
            }
            System.arraycopy(bkVar.f10088c, 0, this.f10088c, this.f10089d, bkVar.f10089d);
            this.f10089d = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f10089d; i2++) {
            if (obj.equals(Double.valueOf(this.f10088c[i2]))) {
                double[] dArr = this.f10088c;
                System.arraycopy(dArr, i2 + 1, dArr, i2, (this.f10089d - i2) - 1);
                this.f10089d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void b(int i2) {
        if (i2 < 0 || i2 >= this.f10089d) {
            throw new IndexOutOfBoundsException(c(i2));
        }
    }

    private final String c(int i2) {
        int i3 = this.f10089d;
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
        double[] dArr = this.f10088c;
        double d2 = dArr[i2];
        dArr[i2] = doubleValue;
        return Double.valueOf(d2);
    }

    public final /* synthetic */ Object remove(int i2) {
        c();
        b(i2);
        double[] dArr = this.f10088c;
        double d2 = dArr[i2];
        int i3 = this.f10089d;
        if (i2 < i3 - 1) {
            System.arraycopy(dArr, i2 + 1, dArr, i2, (i3 - i2) - 1);
        }
        this.f10089d--;
        this.modCount++;
        return Double.valueOf(d2);
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        double doubleValue = ((Double) obj).doubleValue();
        c();
        if (i2 < 0 || i2 > (i3 = this.f10089d)) {
            throw new IndexOutOfBoundsException(c(i2));
        }
        double[] dArr = this.f10088c;
        if (i3 < dArr.length) {
            System.arraycopy(dArr, i2, dArr, i2 + 1, i3 - i2);
        } else {
            double[] dArr2 = new double[(((i3 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            System.arraycopy(this.f10088c, i2, dArr2, i2 + 1, this.f10089d - i2);
            this.f10088c = dArr2;
        }
        this.f10088c[i2] = doubleValue;
        this.f10089d++;
        this.modCount++;
    }

    public final /* synthetic */ ce a(int i2) {
        if (i2 >= this.f10089d) {
            return new bk(Arrays.copyOf(this.f10088c, i2), this.f10089d);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i2) {
        b(i2);
        return Double.valueOf(this.f10088c[i2]);
    }

    static {
        bk bkVar = new bk(new double[0], 0);
        f10087b = bkVar;
        bkVar.f10058a = false;
    }
}
