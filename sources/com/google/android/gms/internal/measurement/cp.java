package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

final class cp extends cr {

    /* renamed from: a  reason: collision with root package name */
    private int f10533a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final int f10534b = this.f10535c.zza();

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ cm f10535c;

    cp(cm cmVar) {
        this.f10535c = cmVar;
    }

    public final boolean hasNext() {
        return this.f10533a < this.f10534b;
    }

    public final byte a() {
        int i2 = this.f10533a;
        if (i2 < this.f10534b) {
            this.f10533a = i2 + 1;
            return this.f10535c.zzb(i2);
        }
        throw new NoSuchElementException();
    }
}
