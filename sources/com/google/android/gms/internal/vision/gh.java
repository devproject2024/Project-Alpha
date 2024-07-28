package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.RandomAccess;

final class gh<E> extends cp<E> implements RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final gh<Object> f11176b;

    /* renamed from: c  reason: collision with root package name */
    private E[] f11177c;

    /* renamed from: d  reason: collision with root package name */
    private int f11178d;

    public static <E> gh<E> d() {
        return f11176b;
    }

    gh() {
        this(new Object[10], 0);
    }

    private gh(E[] eArr, int i2) {
        this.f11177c = eArr;
        this.f11178d = i2;
    }

    public final boolean add(E e2) {
        c();
        int i2 = this.f11178d;
        E[] eArr = this.f11177c;
        if (i2 == eArr.length) {
            this.f11177c = Arrays.copyOf(eArr, ((i2 * 3) / 2) + 1);
        }
        E[] eArr2 = this.f11177c;
        int i3 = this.f11178d;
        this.f11178d = i3 + 1;
        eArr2[i3] = e2;
        this.modCount++;
        return true;
    }

    public final void add(int i2, E e2) {
        int i3;
        c();
        if (i2 < 0 || i2 > (i3 = this.f11178d)) {
            throw new IndexOutOfBoundsException(c(i2));
        }
        E[] eArr = this.f11177c;
        if (i3 < eArr.length) {
            System.arraycopy(eArr, i2, eArr, i2 + 1, i3 - i2);
        } else {
            E[] eArr2 = new Object[(((i3 * 3) / 2) + 1)];
            System.arraycopy(eArr, 0, eArr2, 0, i2);
            System.arraycopy(this.f11177c, i2, eArr2, i2 + 1, this.f11178d - i2);
            this.f11177c = eArr2;
        }
        this.f11177c[i2] = e2;
        this.f11178d++;
        this.modCount++;
    }

    public final E get(int i2) {
        b(i2);
        return this.f11177c[i2];
    }

    public final E remove(int i2) {
        c();
        b(i2);
        E[] eArr = this.f11177c;
        E e2 = eArr[i2];
        int i3 = this.f11178d;
        if (i2 < i3 - 1) {
            System.arraycopy(eArr, i2 + 1, eArr, i2, (i3 - i2) - 1);
        }
        this.f11178d--;
        this.modCount++;
        return e2;
    }

    public final E set(int i2, E e2) {
        c();
        b(i2);
        E[] eArr = this.f11177c;
        E e3 = eArr[i2];
        eArr[i2] = e2;
        this.modCount++;
        return e3;
    }

    public final int size() {
        return this.f11178d;
    }

    private final void b(int i2) {
        if (i2 < 0 || i2 >= this.f11178d) {
            throw new IndexOutOfBoundsException(c(i2));
        }
    }

    private final String c(int i2) {
        int i3 = this.f11178d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    public final /* synthetic */ eq a(int i2) {
        if (i2 >= this.f11178d) {
            return new gh(Arrays.copyOf(this.f11177c, i2), this.f11178d);
        }
        throw new IllegalArgumentException();
    }

    static {
        gh<Object> ghVar = new gh<>(new Object[0], 0);
        f11176b = ghVar;
        ghVar.f11013a = false;
    }
}
