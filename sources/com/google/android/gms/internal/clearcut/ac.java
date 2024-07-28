package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class ac implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    private int f9121a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final int f9122b = this.f9123c.size();

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ ab f9123c;

    ac(ab abVar) {
        this.f9123c = abVar;
    }

    private final byte a() {
        try {
            ab abVar = this.f9123c;
            int i2 = this.f9121a;
            this.f9121a = i2 + 1;
            return abVar.zzj(i2);
        } catch (IndexOutOfBoundsException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    public final boolean hasNext() {
        return this.f9121a < this.f9122b;
    }

    public final /* synthetic */ Object next() {
        return Byte.valueOf(a());
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
