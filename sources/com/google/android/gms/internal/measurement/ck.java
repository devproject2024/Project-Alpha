package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class ck extends cg<Boolean> implements ed<Boolean>, fs, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final ck f10526b;

    /* renamed from: c  reason: collision with root package name */
    private boolean[] f10527c;

    /* renamed from: d  reason: collision with root package name */
    private int f10528d;

    ck() {
        this(new boolean[10], 0);
    }

    private ck(boolean[] zArr, int i2) {
        this.f10527c = zArr;
        this.f10528d = i2;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i2, int i3) {
        r_();
        if (i3 >= i2) {
            boolean[] zArr = this.f10527c;
            System.arraycopy(zArr, i3, zArr, i2, this.f10528d - i3);
            this.f10528d -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ck)) {
            return super.equals(obj);
        }
        ck ckVar = (ck) obj;
        if (this.f10528d != ckVar.f10528d) {
            return false;
        }
        boolean[] zArr = ckVar.f10527c;
        for (int i2 = 0; i2 < this.f10528d; i2++) {
            if (this.f10527c[i2] != zArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f10528d; i3++) {
            i2 = (i2 * 31) + dx.a(this.f10527c[i3]);
        }
        return i2;
    }

    public final int size() {
        return this.f10528d;
    }

    public final void a(boolean z) {
        r_();
        int i2 = this.f10528d;
        boolean[] zArr = this.f10527c;
        if (i2 == zArr.length) {
            boolean[] zArr2 = new boolean[(((i2 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            this.f10527c = zArr2;
        }
        boolean[] zArr3 = this.f10527c;
        int i3 = this.f10528d;
        this.f10528d = i3 + 1;
        zArr3[i3] = z;
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        r_();
        dx.a(collection);
        if (!(collection instanceof ck)) {
            return super.addAll(collection);
        }
        ck ckVar = (ck) collection;
        int i2 = ckVar.f10528d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f10528d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            boolean[] zArr = this.f10527c;
            if (i4 > zArr.length) {
                this.f10527c = Arrays.copyOf(zArr, i4);
            }
            System.arraycopy(ckVar.f10527c, 0, this.f10527c, this.f10528d, ckVar.f10528d);
            this.f10528d = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        r_();
        for (int i2 = 0; i2 < this.f10528d; i2++) {
            if (obj.equals(Boolean.valueOf(this.f10527c[i2]))) {
                boolean[] zArr = this.f10527c;
                System.arraycopy(zArr, i2 + 1, zArr, i2, (this.f10528d - i2) - 1);
                this.f10528d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void b(int i2) {
        if (i2 < 0 || i2 >= this.f10528d) {
            throw new IndexOutOfBoundsException(c(i2));
        }
    }

    private final String c(int i2) {
        int i3 = this.f10528d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        r_();
        b(i2);
        boolean[] zArr = this.f10527c;
        boolean z = zArr[i2];
        zArr[i2] = booleanValue;
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ Object remove(int i2) {
        r_();
        b(i2);
        boolean[] zArr = this.f10527c;
        boolean z = zArr[i2];
        int i3 = this.f10528d;
        if (i2 < i3 - 1) {
            System.arraycopy(zArr, i2 + 1, zArr, i2, (i3 - i2) - 1);
        }
        this.f10528d--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        r_();
        if (i2 < 0 || i2 > (i3 = this.f10528d)) {
            throw new IndexOutOfBoundsException(c(i2));
        }
        boolean[] zArr = this.f10527c;
        if (i3 < zArr.length) {
            System.arraycopy(zArr, i2, zArr, i2 + 1, i3 - i2);
        } else {
            boolean[] zArr2 = new boolean[(((i3 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            System.arraycopy(this.f10527c, i2, zArr2, i2 + 1, this.f10528d - i2);
            this.f10527c = zArr2;
        }
        this.f10527c[i2] = booleanValue;
        this.f10528d++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        a(((Boolean) obj).booleanValue());
        return true;
    }

    public final /* synthetic */ ed a(int i2) {
        if (i2 >= this.f10528d) {
            return new ck(Arrays.copyOf(this.f10527c, i2), this.f10528d);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i2) {
        b(i2);
        return Boolean.valueOf(this.f10527c[i2]);
    }

    static {
        ck ckVar = new ck(new boolean[0], 0);
        f10526b = ckVar;
        ckVar.f10522a = false;
    }
}
