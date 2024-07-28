package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.b.an;
import com.google.android.play.core.b.bj;
import com.google.android.play.core.b.bl;

public final class de implements bl<dk> {

    /* renamed from: a  reason: collision with root package name */
    private final bl<Context> f37190a;

    /* renamed from: b  reason: collision with root package name */
    private final bl<s> f37191b;

    /* renamed from: c  reason: collision with root package name */
    private final bl<bw> f37192c;

    public de(bl<Context> blVar, bl<s> blVar2, bl<bw> blVar3) {
        this.f37190a = blVar;
        this.f37191b = blVar2;
        this.f37192c = blVar3;
    }

    public final /* synthetic */ Object a() {
        dk dkVar = (dk) (da.a(df.a(((df) this.f37190a).f37193a)) == null ? bj.b(this.f37191b).a() : bj.b(this.f37192c).a());
        an.a(dkVar, "Cannot return null from a non-@Nullable @Provides method");
        return dkVar;
    }
}
