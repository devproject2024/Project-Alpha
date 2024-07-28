package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class ef extends cp<Float> implements eq<Float>, gf, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final ef f11085b;

    /* renamed from: c  reason: collision with root package name */
    private float[] f11086c;

    /* renamed from: d  reason: collision with root package name */
    private int f11087d;

    ef() {
        this(new float[10], 0);
    }

    private ef(float[] fArr, int i2) {
        this.f11086c = fArr;
        this.f11087d = i2;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i2, int i3) {
        c();
        if (i3 >= i2) {
            float[] fArr = this.f11086c;
            System.arraycopy(fArr, i3, fArr, i2, this.f11087d - i3);
            this.f11087d -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ef)) {
            return super.equals(obj);
        }
        ef efVar = (ef) obj;
        if (this.f11087d != efVar.f11087d) {
            return false;
        }
        float[] fArr = efVar.f11086c;
        for (int i2 = 0; i2 < this.f11087d; i2++) {
            if (Float.floatToIntBits(this.f11086c[i2]) != Float.floatToIntBits(fArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f11087d; i3++) {
            i2 = (i2 * 31) + Float.floatToIntBits(this.f11086c[i3]);
        }
        return i2;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f11086c[i2] == floatValue) {
                return i2;
            }
        }
        return -1;
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final int size() {
        return this.f11087d;
    }

    public final void a(float f2) {
        c();
        int i2 = this.f11087d;
        float[] fArr = this.f11086c;
        if (i2 == fArr.length) {
            float[] fArr2 = new float[(((i2 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            this.f11086c = fArr2;
        }
        float[] fArr3 = this.f11086c;
        int i3 = this.f11087d;
        this.f11087d = i3 + 1;
        fArr3[i3] = f2;
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        c();
        ek.a(collection);
        if (!(collection instanceof ef)) {
            return super.addAll(collection);
        }
        ef efVar = (ef) collection;
        int i2 = efVar.f11087d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f11087d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            float[] fArr = this.f11086c;
            if (i4 > fArr.length) {
                this.f11086c = Arrays.copyOf(fArr, i4);
            }
            System.arraycopy(efVar.f11086c, 0, this.f11086c, this.f11087d, efVar.f11087d);
            this.f11087d = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f11087d; i2++) {
            if (obj.equals(Float.valueOf(this.f11086c[i2]))) {
                float[] fArr = this.f11086c;
                System.arraycopy(fArr, i2 + 1, fArr, i2, (this.f11087d - i2) - 1);
                this.f11087d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void b(int i2) {
        if (i2 < 0 || i2 >= this.f11087d) {
            throw new IndexOutOfBoundsException(c(i2));
        }
    }

    private final String c(int i2) {
        int i3 = this.f11087d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        c();
        b(i2);
        float[] fArr = this.f11086c;
        float f2 = fArr[i2];
        fArr[i2] = floatValue;
        return Float.valueOf(f2);
    }

    public final /* synthetic */ Object remove(int i2) {
        c();
        b(i2);
        float[] fArr = this.f11086c;
        float f2 = fArr[i2];
        int i3 = this.f11087d;
        if (i2 < i3 - 1) {
            System.arraycopy(fArr, i2 + 1, fArr, i2, (i3 - i2) - 1);
        }
        this.f11087d--;
        this.modCount++;
        return Float.valueOf(f2);
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        float floatValue = ((Float) obj).floatValue();
        c();
        if (i2 < 0 || i2 > (i3 = this.f11087d)) {
            throw new IndexOutOfBoundsException(c(i2));
        }
        float[] fArr = this.f11086c;
        if (i3 < fArr.length) {
            System.arraycopy(fArr, i2, fArr, i2 + 1, i3 - i2);
        } else {
            float[] fArr2 = new float[(((i3 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            System.arraycopy(this.f11086c, i2, fArr2, i2 + 1, this.f11087d - i2);
            this.f11086c = fArr2;
        }
        this.f11086c[i2] = floatValue;
        this.f11087d++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        a(((Float) obj).floatValue());
        return true;
    }

    public final /* synthetic */ eq a(int i2) {
        if (i2 >= this.f11087d) {
            return new ef(Arrays.copyOf(this.f11086c, i2), this.f11087d);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i2) {
        b(i2);
        return Float.valueOf(this.f11086c[i2]);
    }

    static {
        ef efVar = new ef(new float[0], 0);
        f11085b = efVar;
        efVar.f11013a = false;
    }
}
