package com.google.android.gms.internal.p001firebaseperf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-perf.gh  reason: invalid package */
public final class gh extends AbstractList<String> implements ej, RandomAccess {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ej f9669a;

    public gh(ej ejVar) {
        this.f9669a = ejVar;
    }

    public final ej e() {
        return this;
    }

    public final Object a(int i2) {
        return this.f9669a.a(i2);
    }

    public final int size() {
        return this.f9669a.size();
    }

    public final void a(co coVar) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<String> listIterator(int i2) {
        return new gk(this, i2);
    }

    public final Iterator<String> iterator() {
        return new gj(this);
    }

    public final List<?> d() {
        return this.f9669a.d();
    }

    public final /* synthetic */ Object get(int i2) {
        return (String) this.f9669a.get(i2);
    }
}
