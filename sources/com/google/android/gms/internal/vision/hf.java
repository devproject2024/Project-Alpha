package com.google.android.gms.internal.vision;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class hf extends AbstractList<String> implements fa, RandomAccess {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final fa f11214a;

    public hf(fa faVar) {
        this.f11214a = faVar;
    }

    public final fa v_() {
        return this;
    }

    public final Object b(int i2) {
        return this.f11214a.b(i2);
    }

    public final int size() {
        return this.f11214a.size();
    }

    public final void a(cz czVar) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<String> listIterator(int i2) {
        return new he(this, i2);
    }

    public final Iterator<String> iterator() {
        return new hh(this);
    }

    public final List<?> u_() {
        return this.f11214a.u_();
    }

    public final /* synthetic */ Object get(int i2) {
        return (String) this.f11214a.get(i2);
    }
}
