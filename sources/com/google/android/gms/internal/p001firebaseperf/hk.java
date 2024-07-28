package com.google.android.gms.internal.p001firebaseperf;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-perf.hk  reason: invalid package */
public class hk<E> extends hn<E> {

    /* renamed from: a  reason: collision with root package name */
    public Object[] f9695a = new Object[4];

    /* renamed from: b  reason: collision with root package name */
    public int f9696b = 0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f9697c;

    hk() {
        hj.a(4, "initialCapacity");
    }

    public hk<E> a(E e2) {
        cc.a(e2);
        int i2 = this.f9696b + 1;
        Object[] objArr = this.f9695a;
        if (objArr.length < i2) {
            this.f9695a = Arrays.copyOf(objArr, a(objArr.length, i2));
            this.f9697c = false;
        } else if (this.f9697c) {
            this.f9695a = (Object[]) objArr.clone();
            this.f9697c = false;
        }
        Object[] objArr2 = this.f9695a;
        int i3 = this.f9696b;
        this.f9696b = i3 + 1;
        objArr2[i3] = e2;
        return this;
    }
}
