package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class gs extends AbstractList<String> implements em, RandomAccess {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final em f10708a;

    public gs(em emVar) {
        this.f10708a = emVar;
    }

    public final em c() {
        return this;
    }

    public final Object b(int i2) {
        return this.f10708a.b(i2);
    }

    public final int size() {
        return this.f10708a.size();
    }

    public final void a(cm cmVar) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<String> listIterator(int i2) {
        return new gq(this, i2);
    }

    public final Iterator<String> iterator() {
        return new gu(this);
    }

    public final List<?> q_() {
        return this.f10708a.q_();
    }

    public final /* synthetic */ Object get(int i2) {
        return (String) this.f10708a.get(i2);
    }
}
