package com.google.android.gms.internal.vision;

import java.util.Iterator;

public abstract class bk<E> implements Iterator<E> {
    protected bk() {
    }

    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
