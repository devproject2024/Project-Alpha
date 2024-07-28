package com.google.android.exoplayer2.f.a;

import com.google.android.exoplayer2.f.a.d;
import com.google.android.exoplayer2.f.h;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.f.u;

public final class e implements i.a {

    /* renamed from: a  reason: collision with root package name */
    private final a f32332a;

    /* renamed from: b  reason: collision with root package name */
    private final i.a f32333b;

    /* renamed from: c  reason: collision with root package name */
    private final i.a f32334c;

    /* renamed from: d  reason: collision with root package name */
    private final int f32335d;

    /* renamed from: e  reason: collision with root package name */
    private final h.a f32336e;

    /* renamed from: f  reason: collision with root package name */
    private final d.a f32337f;

    /* renamed from: g  reason: collision with root package name */
    private final f f32338g;

    public e(a aVar, i.a aVar2) {
        this(aVar, aVar2, (byte) 0);
    }

    private e(a aVar, i.a aVar2, byte b2) {
        this(aVar, aVar2, new u(), new c(aVar));
    }

    private e(a aVar, i.a aVar2, i.a aVar3, h.a aVar4) {
        this(aVar, aVar2, aVar3, aVar4, (byte) 0);
    }

    private e(a aVar, i.a aVar2, i.a aVar3, h.a aVar4, byte b2) {
        this.f32332a = aVar;
        this.f32333b = aVar2;
        this.f32334c = aVar3;
        this.f32336e = aVar4;
        this.f32335d = 0;
        this.f32337f = null;
        this.f32338g = null;
    }

    public final /* synthetic */ i a() {
        h hVar;
        a aVar = this.f32332a;
        i a2 = this.f32333b.a();
        i a3 = this.f32334c.a();
        h.a aVar2 = this.f32336e;
        if (aVar2 == null) {
            hVar = null;
        } else {
            hVar = aVar2.a();
        }
        return new d(aVar, a2, a3, hVar, this.f32335d, this.f32337f, this.f32338g);
    }
}
