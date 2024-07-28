package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.RandomAccess;

final class fu<E> extends cg<E> implements RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final fu<Object> f10668b;

    /* renamed from: c  reason: collision with root package name */
    private E[] f10669c;

    /* renamed from: d  reason: collision with root package name */
    private int f10670d;

    public static <E> fu<E> d() {
        return f10668b;
    }

    fu() {
        this(new Object[10], 0);
    }

    private fu(E[] eArr, int i2) {
        this.f10669c = eArr;
        this.f10670d = i2;
    }

    public final boolean add(E e2) {
        r_();
        int i2 = this.f10670d;
        E[] eArr = this.f10669c;
        if (i2 == eArr.length) {
            this.f10669c = Arrays.copyOf(eArr, ((i2 * 3) / 2) + 1);
        }
        E[] eArr2 = this.f10669c;
        int i3 = this.f10670d;
        this.f10670d = i3 + 1;
        eArr2[i3] = e2;
        this.modCount++;
        return true;
    }

    public final void add(int i2, E e2) {
        int i3;
        r_();
        if (i2 < 0 || i2 > (i3 = this.f10670d)) {
            throw new IndexOutOfBoundsException(c(i2));
        }
        E[] eArr = this.f10669c;
        if (i3 < eArr.length) {
            System.arraycopy(eArr, i2, eArr, i2 + 1, i3 - i2);
        } else {
            E[] eArr2 = new Object[(((i3 * 3) / 2) + 1)];
            System.arraycopy(eArr, 0, eArr2, 0, i2);
            System.arraycopy(this.f10669c, i2, eArr2, i2 + 1, this.f10670d - i2);
            this.f10669c = eArr2;
        }
        this.f10669c[i2] = e2;
        this.f10670d++;
        this.modCount++;
    }

    public final E get(int i2) {
        b(i2);
        return this.f10669c[i2];
    }

    public final E remove(int i2) {
        r_();
        b(i2);
        E[] eArr = this.f10669c;
        E e2 = eArr[i2];
        int i3 = this.f10670d;
        if (i2 < i3 - 1) {
            System.arraycopy(eArr, i2 + 1, eArr, i2, (i3 - i2) - 1);
        }
        this.f10670d--;
        this.modCount++;
        return e2;
    }

    public final E set(int i2, E e2) {
        r_();
        b(i2);
        E[] eArr = this.f10669c;
        E e3 = eArr[i2];
        eArr[i2] = e2;
        this.modCount++;
        return e3;
    }

    public final int size() {
        return this.f10670d;
    }

    private final void b(int i2) {
        if (i2 < 0 || i2 >= this.f10670d) {
            throw new IndexOutOfBoundsException(c(i2));
        }
    }

    private final String c(int i2) {
        int i3 = this.f10670d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    public final /* synthetic */ ed a(int i2) {
        if (i2 >= this.f10670d) {
            return new fu(Arrays.copyOf(this.f10669c, i2), this.f10670d);
        }
        throw new IllegalArgumentException();
    }

    static {
        fu<Object> fuVar = new fu<>(new Object[0], 0);
        f10668b = fuVar;
        fuVar.f10522a = false;
    }
}
