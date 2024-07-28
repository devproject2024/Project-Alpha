package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.f.v;
import com.google.android.exoplayer2.g.a;

public final class r extends v.a {

    /* renamed from: a  reason: collision with root package name */
    private final String f32449a;

    /* renamed from: b  reason: collision with root package name */
    private final ad f32450b;

    /* renamed from: c  reason: collision with root package name */
    private final int f32451c;

    /* renamed from: d  reason: collision with root package name */
    private final int f32452d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f32453e;

    public r(String str) {
        this(str, (ad) null);
    }

    public r(String str, ad adVar) {
        this(str, adVar, (byte) 0);
    }

    private r(String str, ad adVar, byte b2) {
        this.f32449a = a.a(str);
        this.f32450b = adVar;
        this.f32451c = 8000;
        this.f32452d = 8000;
        this.f32453e = false;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ v a(v.f fVar) {
        q qVar = new q(this.f32449a, this.f32451c, this.f32452d, this.f32453e, fVar);
        ad adVar = this.f32450b;
        if (adVar != null) {
            qVar.a(adVar);
        }
        return qVar;
    }
}
