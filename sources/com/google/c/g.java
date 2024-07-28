package com.google.c;

import com.google.c.ac;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class g extends c<Boolean> implements ac.a, be, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final g f37848b;

    /* renamed from: c  reason: collision with root package name */
    private boolean[] f37849c;

    /* renamed from: d  reason: collision with root package name */
    private int f37850d;

    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        c();
        if (i2 < 0 || i2 > (i3 = this.f37850d)) {
            throw new IndexOutOfBoundsException(c(i2));
        }
        boolean[] zArr = this.f37849c;
        if (i3 < zArr.length) {
            System.arraycopy(zArr, i2, zArr, i2 + 1, i3 - i2);
        } else {
            boolean[] zArr2 = new boolean[(((i3 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            System.arraycopy(this.f37849c, i2, zArr2, i2 + 1, this.f37850d - i2);
            this.f37849c = zArr2;
        }
        this.f37849c[i2] = booleanValue;
        this.f37850d++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        a(((Boolean) obj).booleanValue());
        return true;
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        c();
        b(i2);
        boolean[] zArr = this.f37849c;
        boolean z = zArr[i2];
        zArr[i2] = booleanValue;
        return Boolean.valueOf(z);
    }

    static {
        g gVar = new g(new boolean[0], 0);
        f37848b = gVar;
        gVar.f37832a = false;
    }

    g() {
        this(new boolean[10], 0);
    }

    private g(boolean[] zArr, int i2) {
        this.f37849c = zArr;
        this.f37850d = i2;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i2, int i3) {
        c();
        if (i3 >= i2) {
            boolean[] zArr = this.f37849c;
            System.arraycopy(zArr, i3, zArr, i2, this.f37850d - i3);
            this.f37850d -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return super.equals(obj);
        }
        g gVar = (g) obj;
        if (this.f37850d != gVar.f37850d) {
            return false;
        }
        boolean[] zArr = gVar.f37849c;
        for (int i2 = 0; i2 < this.f37850d; i2++) {
            if (this.f37849c[i2] != zArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f37850d; i3++) {
            i2 = (i2 * 31) + ac.a(this.f37849c[i3]);
        }
        return i2;
    }

    public final int size() {
        return this.f37850d;
    }

    public final void a(boolean z) {
        c();
        int i2 = this.f37850d;
        boolean[] zArr = this.f37849c;
        if (i2 == zArr.length) {
            boolean[] zArr2 = new boolean[(((i2 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            this.f37849c = zArr2;
        }
        boolean[] zArr3 = this.f37849c;
        int i3 = this.f37850d;
        this.f37850d = i3 + 1;
        zArr3[i3] = z;
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        c();
        ac.a(collection);
        if (!(collection instanceof g)) {
            return super.addAll(collection);
        }
        g gVar = (g) collection;
        int i2 = gVar.f37850d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f37850d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            boolean[] zArr = this.f37849c;
            if (i4 > zArr.length) {
                this.f37849c = Arrays.copyOf(zArr, i4);
            }
            System.arraycopy(gVar.f37849c, 0, this.f37849c, this.f37850d, gVar.f37850d);
            this.f37850d = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f37850d; i2++) {
            if (obj.equals(Boolean.valueOf(this.f37849c[i2]))) {
                boolean[] zArr = this.f37849c;
                System.arraycopy(zArr, i2 + 1, zArr, i2, (this.f37850d - i2) - 1);
                this.f37850d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private void b(int i2) {
        if (i2 < 0 || i2 >= this.f37850d) {
            throw new IndexOutOfBoundsException(c(i2));
        }
    }

    private String c(int i2) {
        return "Index:" + i2 + ", Size:" + this.f37850d;
    }

    public final /* synthetic */ Object remove(int i2) {
        c();
        b(i2);
        boolean[] zArr = this.f37849c;
        boolean z = zArr[i2];
        int i3 = this.f37850d;
        if (i2 < i3 - 1) {
            System.arraycopy(zArr, i2 + 1, zArr, i2, (i3 - i2) - 1);
        }
        this.f37850d--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ ac.i a(int i2) {
        if (i2 >= this.f37850d) {
            return new g(Arrays.copyOf(this.f37849c, i2), this.f37850d);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i2) {
        b(i2);
        return Boolean.valueOf(this.f37849c[i2]);
    }
}
