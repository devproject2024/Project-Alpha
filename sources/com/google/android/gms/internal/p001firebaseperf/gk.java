package com.google.android.gms.internal.p001firebaseperf;

import java.util.ListIterator;

/* renamed from: com.google.android.gms.internal.firebase-perf.gk  reason: invalid package */
final class gk implements ListIterator<String> {

    /* renamed from: a  reason: collision with root package name */
    private ListIterator<String> f9672a = this.f9674c.f9669a.listIterator(this.f9673b);

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ int f9673b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ gh f9674c;

    gk(gh ghVar, int i2) {
        this.f9674c = ghVar;
        this.f9673b = i2;
    }

    public final boolean hasNext() {
        return this.f9672a.hasNext();
    }

    public final boolean hasPrevious() {
        return this.f9672a.hasPrevious();
    }

    public final int nextIndex() {
        return this.f9672a.nextIndex();
    }

    public final int previousIndex() {
        return this.f9672a.previousIndex();
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
        return this.f9672a.previous();
    }

    public final /* synthetic */ Object next() {
        return this.f9672a.next();
    }
}
