package com.google.android.gms.internal.vision;

import java.util.ListIterator;

final class he implements ListIterator<String> {

    /* renamed from: a  reason: collision with root package name */
    private ListIterator<String> f11211a = this.f11213c.f11214a.listIterator(this.f11212b);

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ int f11212b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ hf f11213c;

    he(hf hfVar, int i2) {
        this.f11213c = hfVar;
        this.f11212b = i2;
    }

    public final boolean hasNext() {
        return this.f11211a.hasNext();
    }

    public final boolean hasPrevious() {
        return this.f11211a.hasPrevious();
    }

    public final int nextIndex() {
        return this.f11211a.nextIndex();
    }

    public final int previousIndex() {
        return this.f11211a.previousIndex();
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
        return this.f11211a.previous();
    }

    public final /* synthetic */ Object next() {
        return this.f11211a.next();
    }
}
