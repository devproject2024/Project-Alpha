package com.google.android.gms.internal.clearcut;

import java.util.ListIterator;

final class dz implements ListIterator<String> {

    /* renamed from: a  reason: collision with root package name */
    private ListIterator<String> f9315a = this.f9317c.f9314a.listIterator(this.f9316b);

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ int f9316b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ dy f9317c;

    dz(dy dyVar, int i2) {
        this.f9317c = dyVar;
        this.f9316b = i2;
    }

    public final /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean hasNext() {
        return this.f9315a.hasNext();
    }

    public final boolean hasPrevious() {
        return this.f9315a.hasPrevious();
    }

    public final /* synthetic */ Object next() {
        return this.f9315a.next();
    }

    public final int nextIndex() {
        return this.f9315a.nextIndex();
    }

    public final /* synthetic */ Object previous() {
        return this.f9315a.previous();
    }

    public final int previousIndex() {
        return this.f9315a.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
