package com.google.android.exoplayer2.e.h;

import com.google.android.exoplayer2.e.c;
import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.e.h.e;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class b extends c {

    /* renamed from: c  reason: collision with root package name */
    private static final int f31598c = ae.h("payl");

    /* renamed from: d  reason: collision with root package name */
    private static final int f31599d = ae.h("sttg");

    /* renamed from: e  reason: collision with root package name */
    private static final int f31600e = ae.h("vttc");

    /* renamed from: f  reason: collision with root package name */
    private final r f31601f = new r();

    /* renamed from: g  reason: collision with root package name */
    private final e.a f31602g = new e.a();

    public b() {
        super("Mp4WebvttDecoder");
    }

    private static com.google.android.exoplayer2.e.b a(r rVar, e.a aVar, int i2) throws g {
        aVar.a();
        while (i2 > 0) {
            if (i2 >= 8) {
                int i3 = rVar.i();
                int i4 = rVar.i();
                int i5 = i3 - 8;
                String a2 = ae.a(rVar.f32566a, rVar.f32567b, i5);
                rVar.d(i5);
                i2 = (i2 - 8) - i5;
                if (i4 == f31599d) {
                    f.a(a2, aVar);
                } else if (i4 == f31598c) {
                    f.a((String) null, a2.trim(), aVar, (List<d>) Collections.emptyList());
                }
            } else {
                throw new g("Incomplete vtt cue box header found.");
            }
        }
        return aVar.b();
    }

    public final /* synthetic */ com.google.android.exoplayer2.e.e a(byte[] bArr, int i2, boolean z) throws g {
        this.f31601f.a(bArr, i2);
        ArrayList arrayList = new ArrayList();
        while (this.f31601f.b() > 0) {
            if (this.f31601f.b() >= 8) {
                int i3 = this.f31601f.i();
                if (this.f31601f.i() == f31600e) {
                    arrayList.add(a(this.f31601f, this.f31602g, i3 - 8));
                } else {
                    this.f31601f.d(i3 - 8);
                }
            } else {
                throw new g("Incomplete Mp4Webvtt Top Level box header found.");
            }
        }
        return new c(arrayList);
    }
}
