package com.google.android.gms.internal.firebase_ml;

import java.util.NoSuchElementException;

abstract class ar<E> extends ax<E> {

    /* renamed from: a  reason: collision with root package name */
    private final int f9752a;

    /* renamed from: b  reason: collision with root package name */
    private int f9753b;

    protected ar(int i2, int i3) {
        ap.b(i3, i2);
        this.f9752a = i2;
        this.f9753b = i3;
    }

    /* access modifiers changed from: protected */
    public abstract E a(int i2);

    public final boolean hasNext() {
        return this.f9753b < this.f9752a;
    }

    public final E next() {
        if (hasNext()) {
            int i2 = this.f9753b;
            this.f9753b = i2 + 1;
            return a(i2);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.f9753b;
    }

    public final boolean hasPrevious() {
        return this.f9753b > 0;
    }

    public final E previous() {
        if (hasPrevious()) {
            int i2 = this.f9753b - 1;
            this.f9753b = i2;
            return a(i2);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.f9753b - 1;
    }
}
