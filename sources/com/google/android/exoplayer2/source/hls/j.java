package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.t;
import com.google.android.exoplayer2.source.u;
import java.io.IOException;

final class j implements u {

    /* renamed from: a  reason: collision with root package name */
    final int f33181a;

    /* renamed from: b  reason: collision with root package name */
    final k f33182b;

    /* renamed from: c  reason: collision with root package name */
    int f33183c = -1;

    public j(k kVar, int i2) {
        this.f33182b = kVar;
        this.f33181a = i2;
    }

    public final void c() {
        a.a(this.f33183c == -1);
        this.f33183c = this.f33182b.a(this.f33181a);
    }

    public final boolean a() {
        if (this.f33183c != -3) {
            if (d()) {
                k kVar = this.f33182b;
                if (kVar.y || (!kVar.h() && kVar.j[this.f33183c].f33388a.c())) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final void b() throws IOException {
        if (this.f33183c != -2) {
            this.f33182b.f33185b.a();
            return;
        }
        TrackGroupArray trackGroupArray = this.f33182b.r;
        throw new l(trackGroupArray.f32785c[this.f33181a].f32781b[0].f31069i);
    }

    public final int a(o oVar, e eVar, boolean z) {
        DrmInitData drmInitData;
        if (this.f33183c == -3) {
            eVar.a(4);
            return -4;
        }
        if (d()) {
            k kVar = this.f33182b;
            int i2 = this.f33183c;
            if (!kVar.h()) {
                int i3 = 0;
                if (!kVar.f33188e.isEmpty()) {
                    int i4 = 0;
                    while (true) {
                        boolean z2 = true;
                        if (i4 >= kVar.f33188e.size() - 1) {
                            break;
                        }
                        int i5 = kVar.f33188e.get(i4).f33168a;
                        int length = kVar.j.length;
                        int i6 = 0;
                        while (true) {
                            if (i6 < length) {
                                if (kVar.u[i6] && kVar.j[i6].a() == i5) {
                                    z2 = false;
                                    break;
                                }
                                i6++;
                            } else {
                                break;
                            }
                        }
                        if (!z2) {
                            break;
                        }
                        i4++;
                    }
                    ae.a(kVar.f33188e, 0, i4);
                    h hVar = kVar.f33188e.get(0);
                    Format format = hVar.f32816g;
                    if (!format.equals(kVar.p)) {
                        kVar.f33187d.a(kVar.f33184a, format, hVar.f32817h, hVar.f32818i, hVar.j);
                    }
                    kVar.p = format;
                }
                int a2 = kVar.j[i2].a(oVar, eVar, z, kVar.y, kVar.v);
                if (a2 == -5) {
                    Format format2 = oVar.f32757a;
                    if (i2 == kVar.k) {
                        int a3 = kVar.j[i2].a();
                        while (i3 < kVar.f33188e.size() && kVar.f33188e.get(i3).f33168a != a3) {
                            i3++;
                        }
                        format2 = format2.a(i3 < kVar.f33188e.size() ? kVar.f33188e.get(i3).f32816g : kVar.o);
                    }
                    if (!(format2.l == null || (drmInitData = kVar.f33192i.get(format2.l.f31354b)) == null)) {
                        format2 = format2.a(drmInitData);
                    }
                    oVar.f32757a = format2;
                }
                return a2;
            }
        }
        return -3;
    }

    public final int b_(long j) {
        if (!d()) {
            return 0;
        }
        k kVar = this.f33182b;
        int i2 = this.f33183c;
        if (kVar.h()) {
            return 0;
        }
        t tVar = kVar.j[i2];
        if (kVar.y && j > tVar.f33388a.e()) {
            return tVar.f33388a.i();
        }
        int a2 = tVar.a(j, true);
        if (a2 != -1) {
            return a2;
        }
        return 0;
    }

    private boolean d() {
        int i2 = this.f33183c;
        return (i2 == -1 || i2 == -3 || i2 == -2) ? false : true;
    }
}
