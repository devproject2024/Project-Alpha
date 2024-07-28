package com.bumptech.glide.g;

import androidx.a.a;
import androidx.a.g;

public final class b<K, V> extends a<K, V> {

    /* renamed from: i  reason: collision with root package name */
    private int f6606i;

    public final void clear() {
        this.f6606i = 0;
        super.clear();
    }

    public final V a(int i2, V v) {
        this.f6606i = 0;
        return super.a(i2, v);
    }

    public final V put(K k, V v) {
        this.f6606i = 0;
        return super.put(k, v);
    }

    public final void a(g<? extends K, ? extends V> gVar) {
        this.f6606i = 0;
        super.a(gVar);
    }

    public final V d(int i2) {
        this.f6606i = 0;
        return super.d(i2);
    }

    public final int hashCode() {
        if (this.f6606i == 0) {
            this.f6606i = super.hashCode();
        }
        return this.f6606i;
    }
}
