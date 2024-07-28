package com.google.android.exoplayer2.b;

import android.media.AudioAttributes;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f31165a;

    /* renamed from: b  reason: collision with root package name */
    public final int f31166b;

    /* renamed from: c  reason: collision with root package name */
    public final int f31167c;

    /* renamed from: d  reason: collision with root package name */
    public final int f31168d;

    /* renamed from: e  reason: collision with root package name */
    private AudioAttributes f31169e;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        int f31170a = 0;

        /* renamed from: b  reason: collision with root package name */
        int f31171b = 0;

        /* renamed from: c  reason: collision with root package name */
        int f31172c = 1;
    }

    private /* synthetic */ c(int i2, int i3, int i4, byte b2) {
        this(i2, i3, i4);
    }

    static {
        a aVar = new a();
        f31165a = new c(aVar.f31170a, aVar.f31171b, aVar.f31172c, (byte) 0);
    }

    private c(int i2, int i3, int i4) {
        this.f31166b = i2;
        this.f31167c = i3;
        this.f31168d = i4;
    }

    public final AudioAttributes a() {
        if (this.f31169e == null) {
            this.f31169e = new AudioAttributes.Builder().setContentType(this.f31166b).setFlags(this.f31167c).setUsage(this.f31168d).build();
        }
        return this.f31169e;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            c cVar = (c) obj;
            return this.f31166b == cVar.f31166b && this.f31167c == cVar.f31167c && this.f31168d == cVar.f31168d;
        }
    }

    public final int hashCode() {
        return ((((this.f31166b + 527) * 31) + this.f31167c) * 31) + this.f31168d;
    }
}
