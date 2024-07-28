package com.google.android.gms.internal.firebase_ml;

import java.util.Arrays;
import java.util.RandomAccess;

final class ia<E> extends fe<E> implements RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final ia<Object> f9978b;

    /* renamed from: c  reason: collision with root package name */
    private E[] f9979c;

    /* renamed from: d  reason: collision with root package name */
    private int f9980d;

    public static <E> ia<E> a() {
        return f9978b;
    }

    ia() {
        this(new Object[10], 0);
    }

    private ia(E[] eArr, int i2) {
        this.f9979c = eArr;
        this.f9980d = i2;
    }

    public final boolean add(E e2) {
        e();
        int i2 = this.f9980d;
        E[] eArr = this.f9979c;
        if (i2 == eArr.length) {
            this.f9979c = Arrays.copyOf(eArr, ((i2 * 3) / 2) + 1);
        }
        E[] eArr2 = this.f9979c;
        int i3 = this.f9980d;
        this.f9980d = i3 + 1;
        eArr2[i3] = e2;
        this.modCount++;
        return true;
    }

    public final void add(int i2, E e2) {
        int i3;
        e();
        if (i2 < 0 || i2 > (i3 = this.f9980d)) {
            throw new IndexOutOfBoundsException(b(i2));
        }
        E[] eArr = this.f9979c;
        if (i3 < eArr.length) {
            System.arraycopy(eArr, i2, eArr, i2 + 1, i3 - i2);
        } else {
            E[] eArr2 = new Object[(((i3 * 3) / 2) + 1)];
            System.arraycopy(eArr, 0, eArr2, 0, i2);
            System.arraycopy(this.f9979c, i2, eArr2, i2 + 1, this.f9980d - i2);
            this.f9979c = eArr2;
        }
        this.f9979c[i2] = e2;
        this.f9980d++;
        this.modCount++;
    }

    public final E get(int i2) {
        a(i2);
        return this.f9979c[i2];
    }

    public final E remove(int i2) {
        e();
        a(i2);
        E[] eArr = this.f9979c;
        E e2 = eArr[i2];
        int i3 = this.f9980d;
        if (i2 < i3 - 1) {
            System.arraycopy(eArr, i2 + 1, eArr, i2, (i3 - i2) - 1);
        }
        this.f9980d--;
        this.modCount++;
        return e2;
    }

    public final E set(int i2, E e2) {
        e();
        a(i2);
        E[] eArr = this.f9979c;
        E e3 = eArr[i2];
        eArr[i2] = e2;
        this.modCount++;
        return e3;
    }

    public final int size() {
        return this.f9980d;
    }

    private final void a(int i2) {
        if (i2 < 0 || i2 >= this.f9980d) {
            throw new IndexOutOfBoundsException(b(i2));
        }
    }

    private final String b(int i2) {
        int i3 = this.f9980d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    public final /* synthetic */ gq d(int i2) {
        if (i2 >= this.f9980d) {
            return new ia(Arrays.copyOf(this.f9979c, i2), this.f9980d);
        }
        throw new IllegalArgumentException();
    }

    static {
        ia<Object> iaVar = new ia<>(new Object[0], 0);
        f9978b = iaVar;
        iaVar.f9878a = false;
    }
}
