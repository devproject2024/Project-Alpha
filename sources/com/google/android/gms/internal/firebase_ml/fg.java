package com.google.android.gms.internal.firebase_ml;

import java.util.NoSuchElementException;

final class fg extends fi {

    /* renamed from: a  reason: collision with root package name */
    private int f9879a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final int f9880b = this.f9881c.size();

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ fh f9881c;

    fg(fh fhVar) {
        this.f9881c = fhVar;
    }

    public final boolean hasNext() {
        return this.f9879a < this.f9880b;
    }

    public final byte a() {
        int i2 = this.f9879a;
        if (i2 < this.f9880b) {
            this.f9879a = i2 + 1;
            return this.f9881c.zzcx(i2);
        }
        throw new NoSuchElementException();
    }
}
