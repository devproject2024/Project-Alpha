package com.google.android.gms.internal.icing;

import java.util.ListIterator;

final class em implements ListIterator<String> {

    /* renamed from: a  reason: collision with root package name */
    private ListIterator<String> f10209a = this.f10211c.f10212a.listIterator(this.f10210b);

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ int f10210b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ en f10211c;

    em(en enVar, int i2) {
        this.f10211c = enVar;
        this.f10210b = i2;
    }

    public final boolean hasNext() {
        return this.f10209a.hasNext();
    }

    public final boolean hasPrevious() {
        return this.f10209a.hasPrevious();
    }

    public final int nextIndex() {
        return this.f10209a.nextIndex();
    }

    public final int previousIndex() {
        return this.f10209a.previousIndex();
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
        return this.f10209a.previous();
    }

    public final /* synthetic */ Object next() {
        return this.f10209a.next();
    }
}
