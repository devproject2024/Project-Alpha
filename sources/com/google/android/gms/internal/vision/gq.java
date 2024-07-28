package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class gq implements Iterator<Object> {
    gq() {
    }

    public final boolean hasNext() {
        return false;
    }

    public final Object next() {
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
