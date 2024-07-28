package com.google.c;

import com.google.c.ac;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class y extends c<Float> implements ac.f, be, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final y f37932b;

    /* renamed from: c  reason: collision with root package name */
    private float[] f37933c;

    /* renamed from: d  reason: collision with root package name */
    private int f37934d;

    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        float floatValue = ((Float) obj).floatValue();
        c();
        if (i2 < 0 || i2 > (i3 = this.f37934d)) {
            throw new IndexOutOfBoundsException(c(i2));
        }
        float[] fArr = this.f37933c;
        if (i3 < fArr.length) {
            System.arraycopy(fArr, i2, fArr, i2 + 1, i3 - i2);
        } else {
            float[] fArr2 = new float[(((i3 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            System.arraycopy(this.f37933c, i2, fArr2, i2 + 1, this.f37934d - i2);
            this.f37933c = fArr2;
        }
        this.f37933c[i2] = floatValue;
        this.f37934d++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        a(((Float) obj).floatValue());
        return true;
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        c();
        b(i2);
        float[] fArr = this.f37933c;
        float f2 = fArr[i2];
        fArr[i2] = floatValue;
        return Float.valueOf(f2);
    }

    static {
        y yVar = new y(new float[0], 0);
        f37932b = yVar;
        yVar.f37832a = false;
    }

    y() {
        this(new float[10], 0);
    }

    private y(float[] fArr, int i2) {
        this.f37933c = fArr;
        this.f37934d = i2;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i2, int i3) {
        c();
        if (i3 >= i2) {
            float[] fArr = this.f37933c;
            System.arraycopy(fArr, i3, fArr, i2, this.f37934d - i3);
            this.f37934d -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return super.equals(obj);
        }
        y yVar = (y) obj;
        if (this.f37934d != yVar.f37934d) {
            return false;
        }
        float[] fArr = yVar.f37933c;
        for (int i2 = 0; i2 < this.f37934d; i2++) {
            if (Float.floatToIntBits(this.f37933c[i2]) != Float.floatToIntBits(fArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f37934d; i3++) {
            i2 = (i2 * 31) + Float.floatToIntBits(this.f37933c[i3]);
        }
        return i2;
    }

    public final int size() {
        return this.f37934d;
    }

    public final void a(float f2) {
        c();
        int i2 = this.f37934d;
        float[] fArr = this.f37933c;
        if (i2 == fArr.length) {
            float[] fArr2 = new float[(((i2 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            this.f37933c = fArr2;
        }
        float[] fArr3 = this.f37933c;
        int i3 = this.f37934d;
        this.f37934d = i3 + 1;
        fArr3[i3] = f2;
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        c();
        ac.a(collection);
        if (!(collection instanceof y)) {
            return super.addAll(collection);
        }
        y yVar = (y) collection;
        int i2 = yVar.f37934d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f37934d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            float[] fArr = this.f37933c;
            if (i4 > fArr.length) {
                this.f37933c = Arrays.copyOf(fArr, i4);
            }
            System.arraycopy(yVar.f37933c, 0, this.f37933c, this.f37934d, yVar.f37934d);
            this.f37934d = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f37934d; i2++) {
            if (obj.equals(Float.valueOf(this.f37933c[i2]))) {
                float[] fArr = this.f37933c;
                System.arraycopy(fArr, i2 + 1, fArr, i2, (this.f37934d - i2) - 1);
                this.f37934d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private void b(int i2) {
        if (i2 < 0 || i2 >= this.f37934d) {
            throw new IndexOutOfBoundsException(c(i2));
        }
    }

    private String c(int i2) {
        return "Index:" + i2 + ", Size:" + this.f37934d;
    }

    public final /* synthetic */ Object remove(int i2) {
        c();
        b(i2);
        float[] fArr = this.f37933c;
        float f2 = fArr[i2];
        int i3 = this.f37934d;
        if (i2 < i3 - 1) {
            System.arraycopy(fArr, i2 + 1, fArr, i2, (i3 - i2) - 1);
        }
        this.f37934d--;
        this.modCount++;
        return Float.valueOf(f2);
    }

    public final /* synthetic */ ac.i a(int i2) {
        if (i2 >= this.f37934d) {
            return new y(Arrays.copyOf(this.f37933c, i2), this.f37934d);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i2) {
        b(i2);
        return Float.valueOf(this.f37933c[i2]);
    }
}
