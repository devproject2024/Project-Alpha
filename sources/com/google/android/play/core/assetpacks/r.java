package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.e.p;

final class r extends n<Void> {

    /* renamed from: c  reason: collision with root package name */
    final int f37233c;

    /* renamed from: d  reason: collision with root package name */
    final String f37234d;

    /* renamed from: e  reason: collision with root package name */
    final int f37235e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ s f37236f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    r(s sVar, p<Void> pVar, int i2, String str, int i3) {
        super(sVar, pVar);
        this.f37236f = sVar;
        this.f37233c = i2;
        this.f37234d = str;
        this.f37235e = i3;
    }

    public final void a(Bundle bundle) {
        this.f37236f.f37241e.a();
        int i2 = bundle.getInt("error_code");
        s.f37237a.b("onError(%d), retrying notifyModuleCompleted...", Integer.valueOf(i2));
        int i3 = this.f37235e;
        if (i3 > 0) {
            this.f37236f.a(this.f37233c, this.f37234d, i3 - 1);
        }
    }
}
