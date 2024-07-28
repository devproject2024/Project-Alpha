package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.b.an;
import com.google.android.play.core.b.bl;

public final class df implements bl<Context> {

    /* renamed from: a  reason: collision with root package name */
    final da f37193a;

    public df(da daVar) {
        this.f37193a = daVar;
    }

    public static Context a(da daVar) {
        Context context = daVar.f37186a;
        an.a(context, "Cannot return null from a non-@Nullable @Provides method");
        return context;
    }

    public final /* bridge */ /* synthetic */ Object a() {
        return a(this.f37193a);
    }
}
