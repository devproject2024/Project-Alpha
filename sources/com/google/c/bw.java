package com.google.c;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class bw extends AbstractList<String> implements ai, RandomAccess {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ai f37810a;

    public final ai e() {
        return this;
    }

    public bw(ai aiVar) {
        this.f37810a = aiVar;
    }

    public final Object b(int i2) {
        return this.f37810a.b(i2);
    }

    public final int size() {
        return this.f37810a.size();
    }

    public final void a(j jVar) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<String> listIterator(final int i2) {
        return new ListIterator<String>() {

            /* renamed from: a  reason: collision with root package name */
            ListIterator<String> f37811a = bw.this.f37810a.listIterator(i2);

            public final boolean hasNext() {
                return this.f37811a.hasNext();
            }

            public final boolean hasPrevious() {
                return this.f37811a.hasPrevious();
            }

            public final int nextIndex() {
                return this.f37811a.nextIndex();
            }

            public final int previousIndex() {
                return this.f37811a.previousIndex();
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

            public final /* bridge */ /* synthetic */ Object previous() {
                return this.f37811a.previous();
            }

            public final /* bridge */ /* synthetic */ Object next() {
                return this.f37811a.next();
            }
        };
    }

    public final Iterator<String> iterator() {
        return new Iterator<String>() {

            /* renamed from: a  reason: collision with root package name */
            Iterator<String> f37814a = bw.this.f37810a.iterator();

            public final boolean hasNext() {
                return this.f37814a.hasNext();
            }

            public final void remove() {
                throw new UnsupportedOperationException();
            }

            public final /* bridge */ /* synthetic */ Object next() {
                return this.f37814a.next();
            }
        };
    }

    public final List<?> d() {
        return this.f37810a.d();
    }

    public final /* bridge */ /* synthetic */ Object get(int i2) {
        return (String) this.f37810a.get(i2);
    }
}
