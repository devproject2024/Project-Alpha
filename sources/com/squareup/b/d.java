package com.squareup.b;

import com.squareup.b.c;
import com.squareup.b.g;

public final class d<T extends c<?>, E> implements Comparable<d<?, ?>> {

    /* renamed from: a  reason: collision with root package name */
    final Class<T> f16046a;

    /* renamed from: b  reason: collision with root package name */
    final Class<? extends g> f16047b;

    /* renamed from: c  reason: collision with root package name */
    final Class<? extends j> f16048c;

    /* renamed from: d  reason: collision with root package name */
    final String f16049d;

    /* renamed from: e  reason: collision with root package name */
    final int f16050e;

    /* renamed from: f  reason: collision with root package name */
    final g.a f16051f;

    /* renamed from: g  reason: collision with root package name */
    final g.b f16052g;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int compareTo(d<?, ?> dVar) {
        int value;
        int value2;
        if (dVar == this) {
            return 0;
        }
        int i2 = this.f16050e;
        int i3 = dVar.f16050e;
        if (i2 != i3) {
            return i2 - i3;
        }
        g.a aVar = this.f16051f;
        if (aVar != dVar.f16051f) {
            value = aVar.value();
            value2 = dVar.f16051f.value();
        } else {
            g.b bVar = this.f16052g;
            if (bVar != dVar.f16052g) {
                value = bVar.value();
                value2 = dVar.f16052g.value();
            } else {
                Class<T> cls = this.f16046a;
                if (cls != null && !cls.equals(dVar.f16046a)) {
                    return this.f16046a.getName().compareTo(dVar.f16046a.getName());
                }
                Class<? extends g> cls2 = this.f16047b;
                if (cls2 != null && !cls2.equals(dVar.f16047b)) {
                    return this.f16047b.getName().compareTo(dVar.f16047b.getName());
                }
                Class<? extends j> cls3 = this.f16048c;
                if (cls3 == null || cls3.equals(dVar.f16048c)) {
                    return 0;
                }
                return this.f16048c.getName().compareTo(dVar.f16048c.getName());
            }
        }
        return value - value2;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof d) && compareTo((d) obj) == 0;
    }

    public final int hashCode() {
        int value = ((((((this.f16050e * 37) + this.f16051f.value()) * 37) + this.f16052g.value()) * 37) + this.f16046a.hashCode()) * 37;
        Class<? extends g> cls = this.f16047b;
        int i2 = 0;
        int hashCode = (value + (cls != null ? cls.hashCode() : 0)) * 37;
        Class<? extends j> cls2 = this.f16048c;
        if (cls2 != null) {
            i2 = cls2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return String.format("[%s %s %s = %d]", new Object[]{this.f16052g, this.f16051f, this.f16049d, Integer.valueOf(this.f16050e)});
    }
}
