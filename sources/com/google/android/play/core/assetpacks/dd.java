package com.google.android.play.core.assetpacks;

import android.content.ComponentName;
import android.content.Context;
import com.google.android.play.core.b.an;
import com.google.android.play.core.b.bl;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;

public final class dd implements bl<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final bl<cw> f37188a;

    /* renamed from: b  reason: collision with root package name */
    private final bl<Context> f37189b;

    public dd(bl<cw> blVar, bl<Context> blVar2) {
        this.f37188a = blVar;
        this.f37189b = blVar2;
    }

    public final /* synthetic */ Object a() {
        cw a2 = this.f37188a.a();
        Context a3 = df.a(((df) this.f37189b).f37193a);
        cw cwVar = a2;
        an.a(a3.getPackageManager(), new ComponentName(a3.getPackageName(), "com.google.android.play.core.assetpacks.AssetPackExtractionService"));
        PlayCoreDialogWrapperActivity.a(a3);
        an.a(cwVar, "Cannot return null from a non-@Nullable @Provides method");
        return cwVar;
    }
}
