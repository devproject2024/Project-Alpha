package com.google.c;

import com.google.c.ac;
import java.util.Arrays;
import java.util.RandomAccess;

final class bh<E> extends c<E> implements RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final bh<Object> f37753b;

    /* renamed from: c  reason: collision with root package name */
    private E[] f37754c;

    /* renamed from: d  reason: collision with root package name */
    private int f37755d;

    static {
        bh<Object> bhVar = new bh<>(new Object[0], 0);
        f37753b = bhVar;
        bhVar.f37832a = false;
    }

    public static <E> bh<E> d() {
        return f37753b;
    }

    bh() {
        this(new Object[10], 0);
    }

    private bh(E[] eArr, int i2) {
        this.f37754c = eArr;
        this.f37755d = i2;
    }

    public final boolean add(E e2) {
        c();
        int i2 = this.f37755d;
        E[] eArr = this.f37754c;
        if (i2 == eArr.length) {
            this.f37754c = Arrays.copyOf(eArr, ((i2 * 3) / 2) + 1);
        }
        E[] eArr2 = this.f37754c;
        int i3 = this.f37755d;
        this.f37755d = i3 + 1;
        eArr2[i3] = e2;
        this.modCount++;
        return true;
    }

    public final void add(int i2, E e2) {
        int i3;
        c();
        if (i2 < 0 || i2 > (i3 = this.f37755d)) {
            throw new IndexOutOfBoundsException(c(i2));
        }
        E[] eArr = this.f37754c;
        if (i3 < eArr.length) {
            System.arraycopy(eArr, i2, eArr, i2 + 1, i3 - i2);
        } else {
            E[] eArr2 = (Object[]) new Object[(((i3 * 3) / 2) + 1)];
            System.arraycopy(eArr, 0, eArr2, 0, i2);
            System.arraycopy(this.f37754c, i2, eArr2, i2 + 1, this.f37755d - i2);
            this.f37754c = eArr2;
        }
        this.f37754c[i2] = e2;
        this.f37755d++;
        this.modCount++;
    }

    public final E get(int i2) {
        b(i2);
        return this.f37754c[i2];
    }

    public final E remove(int i2) {
        c();
        b(i2);
        E[] eArr = this.f37754c;
        E e2 = eArr[i2];
        int i3 = this.f37755d;
        if (i2 < i3 - 1) {
            System.arraycopy(eArr, i2 + 1, eArr, i2, (i3 - i2) - 1);
        }
        this.f37755d--;
        this.modCount++;
        return e2;
    }

    public final E set(int i2, E e2) {
        c();
        b(i2);
        E[] eArr = this.f37754c;
        E e3 = eArr[i2];
        eArr[i2] = e2;
        this.modCount++;
        return e3;
    }

    public final int size() {
        return this.f37755d;
    }

    private void b(int i2) {
        if (i2 < 0 || i2 >= this.f37755d) {
            throw new IndexOutOfBoundsException(c(i2));
        }
    }

    private String c(int i2) {
        return "Index:" + i2 + ", Size:" + this.f37755d;
    }

    public final /* synthetic */ ac.i a(int i2) {
        if (i2 >= this.f37755d) {
            return new bh(Arrays.copyOf(this.f37754c, i2), this.f37755d);
        }
        throw new IllegalArgumentException();
    }
}
