package com.google.android.gms.internal.firebase_ml;

import java.util.ListIterator;

final class b implements ListIterator<String> {

    /* renamed from: a  reason: collision with root package name */
    private ListIterator<String> f9757a = this.f9759c.f9772a.listIterator(this.f9758b);

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ int f9758b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ c f9759c;

    b(c cVar, int i2) {
        this.f9759c = cVar;
        this.f9758b = i2;
    }

    public final boolean hasNext() {
        return this.f9757a.hasNext();
    }

    public final boolean hasPrevious() {
        return this.f9757a.hasPrevious();
    }

    public final int nextIndex() {
        return this.f9757a.nextIndex();
    }

    public final int previousIndex() {
        return this.f9757a.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object previous() {
        return this.f9757a.previous();
    }

    public final /* synthetic */ Object next() {
        return this.f9757a.next();
    }
}
