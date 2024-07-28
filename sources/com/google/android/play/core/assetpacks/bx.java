package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.b.bj;
import com.google.android.play.core.b.bl;
import java.io.File;
import java.util.concurrent.Executor;

public final class bx implements bl<bw> {

    /* renamed from: a  reason: collision with root package name */
    private final bl<String> f37104a;

    /* renamed from: b  reason: collision with root package name */
    private final bl<x> f37105b;

    /* renamed from: c  reason: collision with root package name */
    private final bl<ba> f37106c;

    /* renamed from: d  reason: collision with root package name */
    private final bl<Context> f37107d;

    /* renamed from: e  reason: collision with root package name */
    private final bl<cg> f37108e;

    /* renamed from: f  reason: collision with root package name */
    private final bl<Executor> f37109f;

    public bx(bl<String> blVar, bl<x> blVar2, bl<ba> blVar3, bl<Context> blVar4, bl<cg> blVar5, bl<Executor> blVar6) {
        this.f37104a = blVar;
        this.f37105b = blVar2;
        this.f37106c = blVar3;
        this.f37107d = blVar4;
        this.f37108e = blVar5;
        this.f37109f = blVar6;
    }

    public final /* synthetic */ Object a() {
        String a2 = this.f37104a.a();
        x a3 = this.f37105b.a();
        ba a4 = this.f37106c.a();
        Context a5 = df.a(((df) this.f37107d).f37193a);
        cg a6 = this.f37108e.a();
        return new bw(a2 != null ? new File(a5.getExternalFilesDir((String) null), a2) : a5.getExternalFilesDir((String) null), a3, a4, a5, a6, bj.b(this.f37109f));
    }
}
