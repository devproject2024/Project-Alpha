package com.arthurivanets.arvi;

import com.google.android.exoplayer2.drm.e;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.f.n;
import com.google.android.exoplayer2.q;
import java.util.Arrays;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f30998a;

    /* renamed from: b  reason: collision with root package name */
    public final com.arthurivanets.arvi.a.b.a<?, ?> f30999b;

    /* renamed from: c  reason: collision with root package name */
    public final q f31000c;

    /* renamed from: d  reason: collision with root package name */
    public final com.arthurivanets.arvi.a.b.c f31001d;

    /* renamed from: e  reason: collision with root package name */
    public final e[] f31002e;

    /* renamed from: f  reason: collision with root package name */
    public final com.google.android.exoplayer2.f.a.a f31003f;

    /* renamed from: g  reason: collision with root package name */
    public final i.a f31004g;

    /* synthetic */ c(a aVar, byte b2) {
        this(aVar);
    }

    private c(a aVar) {
        this.f30998a = aVar.f31005a;
        this.f30999b = aVar.f31006b;
        this.f31000c = aVar.f31007c;
        this.f31001d = aVar.f31008d;
        this.f31002e = aVar.f31009e;
        this.f31003f = aVar.f31010f;
        this.f31004g = aVar.f31011g;
    }

    public final int hashCode() {
        boolean z = true;
        int i2 = 0;
        int hashCode = (((((((((((this.f30998a + 527) * 31) + this.f30999b.hashCode()) * 31) + this.f31000c.hashCode()) * 31) + this.f31001d.hashCode()) * 31) + (this.f31003f != null ? this.f31003f.hashCode() : 0)) * 31) + (this.f31004g != null ? this.f31004g.hashCode() : 0)) * 31;
        if (this.f31002e.length <= 0) {
            z = false;
        }
        if (z) {
            i2 = Arrays.hashCode(this.f31002e);
        }
        return hashCode + i2;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof c) && obj.hashCode() == hashCode();
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        int f31005a = 0;

        /* renamed from: b  reason: collision with root package name */
        com.arthurivanets.arvi.a.b.a<?, ?> f31006b;

        /* renamed from: c  reason: collision with root package name */
        q f31007c;

        /* renamed from: d  reason: collision with root package name */
        com.arthurivanets.arvi.a.b.c f31008d;

        /* renamed from: e  reason: collision with root package name */
        e[] f31009e;

        /* renamed from: f  reason: collision with root package name */
        com.google.android.exoplayer2.f.a.a f31010f;

        /* renamed from: g  reason: collision with root package name */
        i.a f31011g;

        /* renamed from: h  reason: collision with root package name */
        private final n f31012h = new n();

        public a() {
            n nVar = this.f31012h;
            this.f31006b = new com.arthurivanets.arvi.a.b.a<>(nVar, nVar);
            this.f31007c = new f();
            this.f31008d = com.arthurivanets.arvi.a.b.c.f30986a;
            this.f31009e = new e[0];
            this.f31010f = null;
            this.f31011g = null;
        }
    }
}
