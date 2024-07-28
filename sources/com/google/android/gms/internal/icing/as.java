package com.google.android.gms.internal.icing;

import java.util.NoSuchElementException;

final class as extends au {

    /* renamed from: a  reason: collision with root package name */
    private int f10062a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final int f10063b = this.f10064c.size();

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ at f10064c;

    as(at atVar) {
        this.f10064c = atVar;
    }

    public final boolean hasNext() {
        return this.f10062a < this.f10063b;
    }

    public final byte a() {
        int i2 = this.f10062a;
        if (i2 < this.f10063b) {
            this.f10062a = i2 + 1;
            return this.f10064c.zzl(i2);
        }
        throw new NoSuchElementException();
    }
}
