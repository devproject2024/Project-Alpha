package com.google.android.gms.internal.clearcut;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class dy extends AbstractList<String> implements bv, RandomAccess {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final bv f9314a;

    public dy(bv bvVar) {
        this.f9314a = bvVar;
    }

    public final Object b(int i2) {
        return this.f9314a.b(i2);
    }

    public final List<?> d() {
        return this.f9314a.d();
    }

    public final bv e() {
        return this;
    }

    public final /* synthetic */ Object get(int i2) {
        return (String) this.f9314a.get(i2);
    }

    public final Iterator<String> iterator() {
        return new ea(this);
    }

    public final ListIterator<String> listIterator(int i2) {
        return new dz(this, i2);
    }

    public final int size() {
        return this.f9314a.size();
    }
}
