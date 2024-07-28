package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.b.an;
import com.google.android.play.core.b.bl;
import com.google.android.play.core.d.aw;

public final class dh implements bl<aw> {

    /* renamed from: a  reason: collision with root package name */
    private final bl<Context> f37195a;

    public dh(bl<Context> blVar) {
        this.f37195a = blVar;
    }

    public final /* synthetic */ Object a() {
        Context a2 = df.a(((df) this.f37195a).f37193a);
        aw awVar = new aw(a2, a2.getPackageName());
        an.a(awVar, "Cannot return null from a non-@Nullable @Provides method");
        return awVar;
    }
}
