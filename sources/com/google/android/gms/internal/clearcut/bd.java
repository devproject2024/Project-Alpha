package com.google.android.gms.internal.clearcut;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class bd extends u<Float> implements bm<Float>, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final bd f9179b;

    /* renamed from: c  reason: collision with root package name */
    private float[] f9180c;

    /* renamed from: d  reason: collision with root package name */
    private int f9181d;

    bd() {
        this(new float[10], 0);
    }

    private bd(float[] fArr, int i2) {
        this.f9180c = fArr;
        this.f9181d = i2;
    }

    private final void a(int i2, float f2) {
        int i3;
        c();
        if (i2 < 0 || i2 > (i3 = this.f9181d)) {
            throw new IndexOutOfBoundsException(c(i2));
        }
        float[] fArr = this.f9180c;
        if (i3 < fArr.length) {
            System.arraycopy(fArr, i2, fArr, i2 + 1, i3 - i2);
        } else {
            float[] fArr2 = new float[(((i3 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            System.arraycopy(this.f9180c, i2, fArr2, i2 + 1, this.f9181d - i2);
            this.f9180c = fArr2;
        }
        this.f9180c[i2] = f2;
        this.f9181d++;
        this.modCount++;
    }

    private final void b(int i2) {
        if (i2 < 0 || i2 >= this.f9181d) {
            throw new IndexOutOfBoundsException(c(i2));
        }
    }

    private final String c(int i2) {
        int i3 = this.f9181d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    public final /* synthetic */ bm a(int i2) {
        if (i2 >= this.f9181d) {
            return new bd(Arrays.copyOf(this.f9180c, i2), this.f9181d);
        }
        throw new IllegalArgumentException();
    }

    public final void a(float f2) {
        a(this.f9181d, f2);
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        a(i2, ((Float) obj).floatValue());
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        c();
        bh.a(collection);
        if (!(collection instanceof bd)) {
            return super.addAll(collection);
        }
        bd bdVar = (bd) collection;
        int i2 = bdVar.f9181d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f9181d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            float[] fArr = this.f9180c;
            if (i4 > fArr.length) {
                this.f9180c = Arrays.copyOf(fArr, i4);
            }
            System.arraycopy(bdVar.f9180c, 0, this.f9180c, this.f9181d, bdVar.f9181d);
            this.f9181d = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bd)) {
            return super.equals(obj);
        }
        bd bdVar = (bd) obj;
        if (this.f9181d != bdVar.f9181d) {
            return false;
        }
        float[] fArr = bdVar.f9180c;
        for (int i2 = 0; i2 < this.f9181d; i2++) {
            if (this.f9180c[i2] != fArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i2) {
        b(i2);
        return Float.valueOf(this.f9180c[i2]);
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f9181d; i3++) {
            i2 = (i2 * 31) + Float.floatToIntBits(this.f9180c[i3]);
        }
        return i2;
    }

    public final /* synthetic */ Object remove(int i2) {
        c();
        b(i2);
        float[] fArr = this.f9180c;
        float f2 = fArr[i2];
        int i3 = this.f9181d;
        if (i2 < i3 - 1) {
            System.arraycopy(fArr, i2 + 1, fArr, i2, i3 - i2);
        }
        this.f9181d--;
        this.modCount++;
        return Float.valueOf(f2);
    }

    public final boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f9181d; i2++) {
            if (obj.equals(Float.valueOf(this.f9180c[i2]))) {
                float[] fArr = this.f9180c;
                System.arraycopy(fArr, i2 + 1, fArr, i2, this.f9181d - i2);
                this.f9181d--;
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
            float[] fArr = this.f9180c;
            System.arraycopy(fArr, i3, fArr, i2, this.f9181d - i3);
            this.f9181d -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        c();
        b(i2);
        float[] fArr = this.f9180c;
        float f2 = fArr[i2];
        fArr[i2] = floatValue;
        return Float.valueOf(f2);
    }

    public final int size() {
        return this.f9181d;
    }

    static {
        bd bdVar = new bd();
        f9179b = bdVar;
        bdVar.f9429a = false;
    }
}
