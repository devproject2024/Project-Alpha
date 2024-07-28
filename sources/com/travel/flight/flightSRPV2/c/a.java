package com.travel.flight.flightSRPV2.c;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.k;

public final class a<T> extends ArrayList<T> {
    public final int getSize() {
        return super.size();
    }

    public final T remove(int i2) {
        return removeAt(i2);
    }

    public final Object removeAt(int i2) {
        return super.remove(i2);
    }

    public final int size() {
        return getSize();
    }

    public a() {
    }

    public a(int i2) {
        super(i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Collection<? extends T> collection) {
        super(collection);
        k.c(collection, "collection");
    }

    public final void deleteRange(int i2, int i3) {
        removeRange(i2, i3);
    }
}
