package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.s;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class c<T> implements Iterator<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final b<T> f8681a;

    /* renamed from: b  reason: collision with root package name */
    protected int f8682b = -1;

    public c(b<T> bVar) {
        this.f8681a = (b) s.a(bVar);
    }

    public final boolean hasNext() {
        return this.f8682b < this.f8681a.b() - 1;
    }

    public final T next() {
        if (hasNext()) {
            b<T> bVar = this.f8681a;
            int i2 = this.f8682b + 1;
            this.f8682b = i2;
            return bVar.a(i2);
        }
        int i3 = this.f8682b;
        StringBuilder sb = new StringBuilder(46);
        sb.append("Cannot advance the iterator beyond ");
        sb.append(i3);
        throw new NoSuchElementException(sb.toString());
    }

    public final void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
