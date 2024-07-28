package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.b.bi;
import com.google.android.play.core.b.bj;
import com.google.android.play.core.b.bl;
import com.google.android.play.core.d.aw;
import java.util.concurrent.Executor;

public final class at implements e {

    /* renamed from: a  reason: collision with root package name */
    private final da f36993a;

    /* renamed from: b  reason: collision with root package name */
    private bl<Context> f36994b;

    /* renamed from: c  reason: collision with root package name */
    private bl<cg> f36995c = bj.a(new ch(this.f36994b));

    /* renamed from: d  reason: collision with root package name */
    private bl<ad> f36996d = bj.a(new ae(this.f36994b, this.f36995c));

    /* renamed from: e  reason: collision with root package name */
    private bl<ba> f36997e = bj.a(bb.f37041a);

    /* renamed from: f  reason: collision with root package name */
    private bl<s> f36998f = bj.a(new t(this.f36994b, this.f36997e));

    /* renamed from: g  reason: collision with root package name */
    private bl<String> f36999g = bj.a(new dg(this.f36994b));

    /* renamed from: h  reason: collision with root package name */
    private bl<dk> f37000h = new bi();

    /* renamed from: i  reason: collision with root package name */
    private bl<Executor> f37001i = bj.a(db.f37187a);
    private bl<bo> j = bj.a(new bp(this.f36996d, this.f37000h, this.f36997e, this.f37001i));
    private bl<x> k = new bi();
    private bl<av> l = bj.a(new aw(this.f36996d, this.f37000h, this.k, this.f36997e));
    private bl<cq> m = bj.a(new cr(this.f36996d));
    private bl<ca> n = bj.a(new cb(this.f36996d));
    private bl<ce> o = bj.a(new cf(this.f36996d, this.f37000h, this.j, this.f37001i, this.f36997e));
    private bl<cj> p = bj.a(new ck(this.f36996d, this.f37000h));
    private bl<am> q = bj.a(new an(this.f37000h));
    private bl<br> r = bj.a(new bs(this.j, this.f36996d, this.q));
    private bl<ay> s = bj.a(new az(this.j, this.f37000h, this.l, this.m, this.n, this.o, this.p, this.r));
    private bl<ap> t = bj.a(aq.f36991a);
    private bl<Executor> u = bj.a(di.f37196a);
    private bl<bw> v;
    private bl<aw> w;
    private bl<cw> x;
    private bl<Object> y;

    /* synthetic */ at(da daVar) {
        this.f36993a = daVar;
        this.f36994b = new df(daVar);
        bi.a(this.k, bj.a(new y(this.f36994b, this.j, this.s, this.f37000h, this.f36997e, this.t, this.f37001i, this.u)));
        this.v = bj.a(new bx(this.f36999g, this.k, this.f36997e, this.f36994b, this.f36995c, this.f37001i));
        bi.a(this.f37000h, bj.a(new de(this.f36994b, this.f36998f, this.v)));
        this.w = bj.a(new dh(this.f36994b));
        this.x = bj.a(new cx(this.f36996d, this.f37000h, this.k, this.w, this.j, this.f36997e, this.t, this.f37001i));
        this.y = bj.a(new dd(this.x, this.f36994b));
    }

    public final void a(AssetPackExtractionService assetPackExtractionService) {
        assetPackExtractionService.f36937a = df.a(this.f36993a);
        assetPackExtractionService.f36938b = this.x.a();
        assetPackExtractionService.f36939c = this.f36996d.a();
    }
}
