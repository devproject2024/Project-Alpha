package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class du extends cg<Float> implements ed<Float>, fs, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final du f10589b;

    /* renamed from: c  reason: collision with root package name */
    private float[] f10590c;

    /* renamed from: d  reason: collision with root package name */
    private int f10591d;

    du() {
        this(new float[10], 0);
    }

    private du(float[] fArr, int i2) {
        this.f10590c = fArr;
        this.f10591d = i2;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i2, int i3) {
        r_();
        if (i3 >= i2) {
            float[] fArr = this.f10590c;
            System.arraycopy(fArr, i3, fArr, i2, this.f10591d - i3);
            this.f10591d -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof du)) {
            return super.equals(obj);
        }
        du duVar = (du) obj;
        if (this.f10591d != duVar.f10591d) {
            return false;
        }
        float[] fArr = duVar.f10590c;
        for (int i2 = 0; i2 < this.f10591d; i2++) {
            if (Float.floatToIntBits(this.f10590c[i2]) != Float.floatToIntBits(fArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f10591d; i3++) {
            i2 = (i2 * 31) + Float.floatToIntBits(this.f10590c[i3]);
        }
        return i2;
    }

    public final int size() {
        return this.f10591d;
    }

    public final void a(float f2) {
        r_();
        int i2 = this.f10591d;
        float[] fArr = this.f10590c;
        if (i2 == fArr.length) {
            float[] fArr2 = new float[(((i2 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            this.f10590c = fArr2;
        }
        float[] fArr3 = this.f10590c;
        int i3 = this.f10591d;
        this.f10591d = i3 + 1;
        fArr3[i3] = f2;
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        r_();
        dx.a(collection);
        if (!(collection instanceof du)) {
            return super.addAll(collection);
        }
        du duVar = (du) collection;
        int i2 = duVar.f10591d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f10591d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            float[] fArr = this.f10590c;
            if (i4 > fArr.length) {
                this.f10590c = Arrays.copyOf(fArr, i4);
            }
            System.arraycopy(duVar.f10590c, 0, this.f10590c, this.f10591d, duVar.f10591d);
            this.f10591d = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        r_();
        for (int i2 = 0; i2 < this.f10591d; i2++) {
            if (obj.equals(Float.valueOf(this.f10590c[i2]))) {
                float[] fArr = this.f10590c;
                System.arraycopy(fArr, i2 + 1, fArr, i2, (this.f10591d - i2) - 1);
                this.f10591d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void b(int i2) {
        if (i2 < 0 || i2 >= this.f10591d) {
            throw new IndexOutOfBoundsException(c(i2));
        }
    }

    private final String c(int i2) {
        int i3 = this.f10591d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        r_();
        b(i2);
        float[] fArr = this.f10590c;
        float f2 = fArr[i2];
        fArr[i2] = floatValue;
        return Float.valueOf(f2);
    }

    public final /* synthetic */ Object remove(int i2) {
        r_();
        b(i2);
        float[] fArr = this.f10590c;
        float f2 = fArr[i2];
        int i3 = this.f10591d;
        if (i2 < i3 - 1) {
            System.arraycopy(fArr, i2 + 1, fArr, i2, (i3 - i2) - 1);
        }
        this.f10591d--;
        this.modCount++;
        return Float.valueOf(f2);
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        float floatValue = ((Float) obj).floatValue();
        r_();
        if (i2 < 0 || i2 > (i3 = this.f10591d)) {
            throw new IndexOutOfBoundsException(c(i2));
        }
        float[] fArr = this.f10590c;
        if (i3 < fArr.length) {
            System.arraycopy(fArr, i2, fArr, i2 + 1, i3 - i2);
        } else {
            float[] fArr2 = new float[(((i3 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            System.arraycopy(this.f10590c, i2, fArr2, i2 + 1, this.f10591d - i2);
            this.f10590c = fArr2;
        }
        this.f10590c[i2] = floatValue;
        this.f10591d++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        a(((Float) obj).floatValue());
        return true;
    }

    public final /* synthetic */ ed a(int i2) {
        if (i2 >= this.f10591d) {
            return new du(Arrays.copyOf(this.f10590c, i2), this.f10591d);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i2) {
        b(i2);
        return Float.valueOf(this.f10590c[i2]);
    }

    static {
        du duVar = new du(new float[0], 0);
        f10589b = duVar;
        duVar.f10522a = false;
    }
}
