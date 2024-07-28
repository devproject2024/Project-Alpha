package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.metadata.emsg.b;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.source.dash.a.e;
import com.google.android.exoplayer2.source.u;
import java.io.IOException;

final class g implements u {

    /* renamed from: a  reason: collision with root package name */
    e f33012a;

    /* renamed from: b  reason: collision with root package name */
    private final Format f33013b;

    /* renamed from: c  reason: collision with root package name */
    private final b f33014c = new b();

    /* renamed from: d  reason: collision with root package name */
    private long[] f33015d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f33016e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f33017f;

    /* renamed from: g  reason: collision with root package name */
    private int f33018g;

    /* renamed from: h  reason: collision with root package name */
    private long f33019h = -9223372036854775807L;

    public final boolean a() {
        return true;
    }

    public final void b() throws IOException {
    }

    public g(e eVar, Format format, boolean z) {
        this.f33013b = format;
        this.f33012a = eVar;
        this.f33015d = eVar.f32929b;
        a(eVar, z);
    }

    public final void a(e eVar, boolean z) {
        int i2 = this.f33018g;
        long j = i2 == 0 ? -9223372036854775807L : this.f33015d[i2 - 1];
        this.f33016e = z;
        this.f33012a = eVar;
        this.f33015d = eVar.f32929b;
        long j2 = this.f33019h;
        if (j2 != -9223372036854775807L) {
            b(j2);
        } else if (j != -9223372036854775807L) {
            this.f33018g = ae.a(this.f33015d, j, false, false);
        }
    }

    public final void b(long j) {
        boolean z = false;
        this.f33018g = ae.a(this.f33015d, j, true, false);
        if (this.f33016e && this.f33018g == this.f33015d.length) {
            z = true;
        }
        if (!z) {
            j = -9223372036854775807L;
        }
        this.f33019h = j;
    }

    public final int a(o oVar, com.google.android.exoplayer2.c.e eVar, boolean z) {
        if (z || !this.f33017f) {
            oVar.f32757a = this.f33013b;
            this.f33017f = true;
            return -5;
        }
        int i2 = this.f33018g;
        if (i2 != this.f33015d.length) {
            this.f33018g = i2 + 1;
            byte[] a2 = this.f33014c.a(this.f33012a.f32928a[i2]);
            if (a2 == null) {
                return -3;
            }
            eVar.c(a2.length);
            eVar.f31289a = 1;
            eVar.f31311c.put(a2);
            eVar.f31312d = this.f33015d[i2];
            return -4;
        } else if (this.f33016e) {
            return -3;
        } else {
            eVar.f31289a = 4;
            return -4;
        }
    }

    public final int b_(long j) {
        int max = Math.max(this.f33018g, ae.a(this.f33015d, j, true, false));
        int i2 = max - this.f33018g;
        this.f33018g = max;
        return i2;
    }
}
