package com.google.android.gms.internal.vision;

import java.util.NoSuchElementException;

abstract class au<E> extends bj<E> {

    /* renamed from: a  reason: collision with root package name */
    private final int f10994a;

    /* renamed from: b  reason: collision with root package name */
    private int f10995b;

    protected au(int i2, int i3) {
        al.b(i3, i2);
        this.f10994a = i2;
        this.f10995b = i3;
    }

    /* access modifiers changed from: protected */
    public abstract E a(int i2);

    public final boolean hasNext() {
        return this.f10995b < this.f10994a;
    }

    public final E next() {
        if (hasNext()) {
            int i2 = this.f10995b;
            this.f10995b = i2 + 1;
            return a(i2);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.f10995b;
    }

    public final boolean hasPrevious() {
        return this.f10995b > 0;
    }

    public final E previous() {
        if (hasPrevious()) {
            int i2 = this.f10995b - 1;
            this.f10995b = i2;
            return a(i2);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.f10995b - 1;
    }
}
