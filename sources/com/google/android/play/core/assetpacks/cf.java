package com.google.android.play.core.assetpacks;

import com.google.android.play.core.b.bj;
import com.google.android.play.core.b.bl;
import java.util.concurrent.Executor;

public final class cf implements bl<ce> {

    /* renamed from: a  reason: collision with root package name */
    private final bl<ad> f37125a;

    /* renamed from: b  reason: collision with root package name */
    private final bl<dk> f37126b;

    /* renamed from: c  reason: collision with root package name */
    private final bl<bo> f37127c;

    /* renamed from: d  reason: collision with root package name */
    private final bl<Executor> f37128d;

    /* renamed from: e  reason: collision with root package name */
    private final bl<ba> f37129e;

    public cf(bl<ad> blVar, bl<dk> blVar2, bl<bo> blVar3, bl<Executor> blVar4, bl<ba> blVar5) {
        this.f37125a = blVar;
        this.f37126b = blVar2;
        this.f37127c = blVar3;
        this.f37128d = blVar4;
        this.f37129e = blVar5;
    }

    public final /* synthetic */ Object a() {
        ad a2 = this.f37125a.a();
        return new ce(a2, bj.b(this.f37126b), this.f37127c.a(), bj.b(this.f37128d), this.f37129e.a());
    }
}
