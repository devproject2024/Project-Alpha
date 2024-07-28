package com.google.android.gms.internal.vision;

import java.util.NoSuchElementException;

final class dc extends de {

    /* renamed from: a  reason: collision with root package name */
    private int f11033a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final int f11034b = this.f11035c.size();

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ cz f11035c;

    dc(cz czVar) {
        this.f11035c = czVar;
    }

    public final boolean hasNext() {
        return this.f11033a < this.f11034b;
    }

    public final byte a() {
        int i2 = this.f11033a;
        if (i2 < this.f11034b) {
            this.f11033a = i2 + 1;
            return this.f11035c.zzap(i2);
        }
        throw new NoSuchElementException();
    }
}
