package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.f.ad;
import com.google.android.exoplayer2.f.y;
import com.google.android.exoplayer2.source.b.h;
import com.google.android.exoplayer2.source.dash.a.b;
import com.google.android.exoplayer2.source.dash.h;
import com.google.android.exoplayer2.trackselection.f;
import java.util.List;

public interface a extends h {

    /* renamed from: com.google.android.exoplayer2.source.dash.a$a  reason: collision with other inner class name */
    public interface C0547a {
        a a(y yVar, b bVar, int i2, int[] iArr, f fVar, int i3, long j, boolean z, List<Format> list, h.c cVar, ad adVar);
    }

    void a(b bVar, int i2);

    void a(f fVar);
}
