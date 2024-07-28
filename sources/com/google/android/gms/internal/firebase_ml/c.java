package com.google.android.gms.internal.firebase_ml;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class c extends AbstractList<String> implements gz, RandomAccess {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final gz f9772a;

    public c(gz gzVar) {
        this.f9772a = gzVar;
    }

    public final gz b() {
        return this;
    }

    public final Object a(int i2) {
        return this.f9772a.a(i2);
    }

    public final int size() {
        return this.f9772a.size();
    }

    public final void a(fh fhVar) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<String> listIterator(int i2) {
        return new b(this, i2);
    }

    public final Iterator<String> iterator() {
        return new e(this);
    }

    public final List<?> a() {
        return this.f9772a.a();
    }

    public final /* synthetic */ Object get(int i2) {
        return (String) this.f9772a.get(i2);
    }
}
