package com.google.android.gms.internal.icing;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class en extends AbstractList<String> implements co, RandomAccess {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final co f10212a;

    public en(co coVar) {
        this.f10212a = coVar;
    }

    public final co e() {
        return this;
    }

    public final Object b(int i2) {
        return this.f10212a.b(i2);
    }

    public final int size() {
        return this.f10212a.size();
    }

    public final ListIterator<String> listIterator(int i2) {
        return new em(this, i2);
    }

    public final Iterator<String> iterator() {
        return new ep(this);
    }

    public final List<?> d() {
        return this.f10212a.d();
    }

    public final /* synthetic */ Object get(int i2) {
        return (String) this.f10212a.get(i2);
    }
}
