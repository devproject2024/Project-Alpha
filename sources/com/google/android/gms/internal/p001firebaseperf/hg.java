package com.google.android.gms.internal.p001firebaseperf;

import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.firebase-perf.hg  reason: invalid package */
abstract class hg<E> extends h<E> {

    /* renamed from: a  reason: collision with root package name */
    private final int f9690a;

    /* renamed from: b  reason: collision with root package name */
    private int f9691b;

    protected hg(int i2, int i3) {
        cc.b(i3, i2);
        this.f9690a = i2;
        this.f9691b = i3;
    }

    /* access modifiers changed from: protected */
    public abstract E a(int i2);

    public final boolean hasNext() {
        return this.f9691b < this.f9690a;
    }

    public final E next() {
        if (hasNext()) {
            int i2 = this.f9691b;
            this.f9691b = i2 + 1;
            return a(i2);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.f9691b;
    }

    public final boolean hasPrevious() {
        return this.f9691b > 0;
    }

    public final E previous() {
        if (hasPrevious()) {
            int i2 = this.f9691b - 1;
            this.f9691b = i2;
            return a(i2);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.f9691b - 1;
    }
}
