package com.google.android.gms.internal.measurement;

import java.util.ListIterator;

final class gq implements ListIterator<String> {

    /* renamed from: a  reason: collision with root package name */
    private ListIterator<String> f10705a = this.f10707c.f10708a.listIterator(this.f10706b);

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ int f10706b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ gs f10707c;

    gq(gs gsVar, int i2) {
        this.f10707c = gsVar;
        this.f10706b = i2;
    }

    public final boolean hasNext() {
        return this.f10705a.hasNext();
    }

    public final boolean hasPrevious() {
        return this.f10705a.hasPrevious();
    }

    public final int nextIndex() {
        return this.f10705a.nextIndex();
    }

    public final int previousIndex() {
        return this.f10705a.previousIndex();
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
        return this.f10705a.previous();
    }

    public final /* synthetic */ Object next() {
        return this.f10705a.next();
    }
}
