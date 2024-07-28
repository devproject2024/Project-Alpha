package com.google.android.gms.internal.icing;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class ar extends ap<Boolean> implements ce<Boolean>, dn, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final ar f10059b;

    /* renamed from: c  reason: collision with root package name */
    private boolean[] f10060c;

    /* renamed from: d  reason: collision with root package name */
    private int f10061d;

    public static ar d() {
        return f10059b;
    }

    ar() {
        this(new boolean[10], 0);
    }

    private ar(boolean[] zArr, int i2) {
        this.f10060c = zArr;
        this.f10061d = i2;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i2, int i3) {
        c();
        if (i3 >= i2) {
            boolean[] zArr = this.f10060c;
            System.arraycopy(zArr, i3, zArr, i2, this.f10061d - i3);
            this.f10061d -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ar)) {
            return super.equals(obj);
        }
        ar arVar = (ar) obj;
        if (this.f10061d != arVar.f10061d) {
            return false;
        }
        boolean[] zArr = arVar.f10060c;
        for (int i2 = 0; i2 < this.f10061d; i2++) {
            if (this.f10060c[i2] != zArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f10061d; i3++) {
            i2 = (i2 * 31) + bx.a(this.f10060c[i3]);
        }
        return i2;
    }

    public final int size() {
        return this.f10061d;
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        c();
        bx.a(collection);
        if (!(collection instanceof ar)) {
            return super.addAll(collection);
        }
        ar arVar = (ar) collection;
        int i2 = arVar.f10061d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f10061d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            boolean[] zArr = this.f10060c;
            if (i4 > zArr.length) {
                this.f10060c = Arrays.copyOf(zArr, i4);
            }
            System.arraycopy(arVar.f10060c, 0, this.f10060c, this.f10061d, arVar.f10061d);
            this.f10061d = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        c();
        for (int i2 = 0; i2 < this.f10061d; i2++) {
            if (obj.equals(Boolean.valueOf(this.f10060c[i2]))) {
                boolean[] zArr = this.f10060c;
                System.arraycopy(zArr, i2 + 1, zArr, i2, (this.f10061d - i2) - 1);
                this.f10061d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void b(int i2) {
        if (i2 < 0 || i2 >= this.f10061d) {
            throw new IndexOutOfBoundsException(c(i2));
        }
    }

    private final String c(int i2) {
        int i3 = this.f10061d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        c();
        b(i2);
        boolean[] zArr = this.f10060c;
        boolean z = zArr[i2];
        zArr[i2] = booleanValue;
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ Object remove(int i2) {
        c();
        b(i2);
        boolean[] zArr = this.f10060c;
        boolean z = zArr[i2];
        int i3 = this.f10061d;
        if (i2 < i3 - 1) {
            System.arraycopy(zArr, i2 + 1, zArr, i2, (i3 - i2) - 1);
        }
        this.f10061d--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        c();
        if (i2 < 0 || i2 > (i3 = this.f10061d)) {
            throw new IndexOutOfBoundsException(c(i2));
        }
        boolean[] zArr = this.f10060c;
        if (i3 < zArr.length) {
            System.arraycopy(zArr, i2, zArr, i2 + 1, i3 - i2);
        } else {
            boolean[] zArr2 = new boolean[(((i3 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            System.arraycopy(this.f10060c, i2, zArr2, i2 + 1, this.f10061d - i2);
            this.f10060c = zArr2;
        }
        this.f10060c[i2] = booleanValue;
        this.f10061d++;
        this.modCount++;
    }

    public final /* synthetic */ ce a(int i2) {
        if (i2 >= this.f10061d) {
            return new ar(Arrays.copyOf(this.f10060c, i2), this.f10061d);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i2) {
        b(i2);
        return Boolean.valueOf(this.f10060c[i2]);
    }

    static {
        ar arVar = new ar(new boolean[0], 0);
        f10059b = arVar;
        arVar.f10058a = false;
    }
}
