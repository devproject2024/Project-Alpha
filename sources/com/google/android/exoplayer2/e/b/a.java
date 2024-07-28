package com.google.android.exoplayer2.e.b;

import com.google.android.exoplayer2.e.b.b;
import com.google.android.exoplayer2.e.c;
import com.google.android.exoplayer2.e.e;
import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.g.r;
import java.util.List;

public final class a extends c {

    /* renamed from: c  reason: collision with root package name */
    private final b f31454c;

    public a(List<byte[]> list) {
        super("DvbDecoder");
        r rVar = new r(list.get(0));
        this.f31454c = new b(rVar.d(), rVar.d());
    }

    public final /* synthetic */ e a(byte[] bArr, int i2, boolean z) throws g {
        if (z) {
            b.h hVar = this.f31454c.f31458a;
            hVar.f31501c.clear();
            hVar.f31502d.clear();
            hVar.f31503e.clear();
            hVar.f31504f.clear();
            hVar.f31505g.clear();
            hVar.f31506h = null;
            hVar.f31507i = null;
        }
        return new c(this.f31454c.a(bArr, i2));
    }
}
