package com.google.android.play.core.assetpacks;

import com.google.android.play.core.b.bj;
import com.google.android.play.core.b.bl;
import java.util.concurrent.Executor;

public final class bp implements bl<bo> {

    /* renamed from: a  reason: collision with root package name */
    private final bl<ad> f37078a;

    /* renamed from: b  reason: collision with root package name */
    private final bl<dk> f37079b;

    /* renamed from: c  reason: collision with root package name */
    private final bl<ba> f37080c;

    /* renamed from: d  reason: collision with root package name */
    private final bl<Executor> f37081d;

    public bp(bl<ad> blVar, bl<dk> blVar2, bl<ba> blVar3, bl<Executor> blVar4) {
        this.f37078a = blVar;
        this.f37079b = blVar2;
        this.f37080c = blVar3;
        this.f37081d = blVar4;
    }

    public final /* synthetic */ Object a() {
        ad a2 = this.f37078a.a();
        return new bo(a2, bj.b(this.f37079b), this.f37080c.a(), bj.b(this.f37081d));
    }
}
