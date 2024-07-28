package com.google.android.exoplayer2.extractor.g;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.e.a.f;
import com.google.android.exoplayer2.extractor.g.ac;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.r;
import java.util.List;

final class x {

    /* renamed from: a  reason: collision with root package name */
    private final List<Format> f32118a;

    /* renamed from: b  reason: collision with root package name */
    private final q[] f32119b;

    public x(List<Format> list) {
        this.f32118a = list;
        this.f32119b = new q[list.size()];
    }

    public final void a(i iVar, ac.d dVar) {
        for (int i2 = 0; i2 < this.f32119b.length; i2++) {
            dVar.a();
            q a2 = iVar.a(dVar.b(), 3);
            Format format = this.f32118a.get(i2);
            String str = format.f31069i;
            a.a("application/cea-608".equals(str) || "application/cea-708".equals(str), (Object) "Invalid closed caption mime type provided: ".concat(String.valueOf(str)));
            a2.a(Format.a(format.f31061a != null ? format.f31061a : dVar.c(), str, format.f31063c, format.A, format.B, (DrmInitData) null, Long.MAX_VALUE, format.k));
            this.f32119b[i2] = a2;
        }
    }

    public final void a(long j, r rVar) {
        f.a(j, rVar, this.f32119b);
    }
}
