package com.google.android.play.core.assetpacks;

import com.google.android.play.core.b.bh;
import com.google.android.play.core.b.bj;
import com.google.android.play.core.b.bl;
import com.google.android.play.core.d.aw;
import java.util.concurrent.Executor;

public final class cx implements bl<cw> {

    /* renamed from: a  reason: collision with root package name */
    private final bl<ad> f37176a;

    /* renamed from: b  reason: collision with root package name */
    private final bl<dk> f37177b;

    /* renamed from: c  reason: collision with root package name */
    private final bl<x> f37178c;

    /* renamed from: d  reason: collision with root package name */
    private final bl<aw> f37179d;

    /* renamed from: e  reason: collision with root package name */
    private final bl<bo> f37180e;

    /* renamed from: f  reason: collision with root package name */
    private final bl<ba> f37181f;

    /* renamed from: g  reason: collision with root package name */
    private final bl<ap> f37182g;

    /* renamed from: h  reason: collision with root package name */
    private final bl<Executor> f37183h;

    public cx(bl<ad> blVar, bl<dk> blVar2, bl<x> blVar3, bl<aw> blVar4, bl<bo> blVar5, bl<ba> blVar6, bl<ap> blVar7, bl<Executor> blVar8) {
        this.f37176a = blVar;
        this.f37177b = blVar2;
        this.f37178c = blVar3;
        this.f37179d = blVar4;
        this.f37180e = blVar5;
        this.f37181f = blVar6;
        this.f37182g = blVar7;
        this.f37183h = blVar8;
    }

    public final /* synthetic */ Object a() {
        ad a2 = this.f37176a.a();
        bh<dk> b2 = bj.b(this.f37177b);
        x a3 = this.f37178c.a();
        return new cw(a2, b2, a3, this.f37179d.a(), this.f37180e.a(), this.f37181f.a(), this.f37182g.a(), bj.b(this.f37183h));
    }
}
