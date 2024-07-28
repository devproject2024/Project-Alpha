package com.google.android.play.core.assetpacks;

import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.b.b;
import com.google.android.play.core.b.bh;
import com.google.android.play.core.d.aw;
import java.util.concurrent.Executor;

final class cw {

    /* renamed from: d  reason: collision with root package name */
    private static final b f37167d = new b("AssetPackManager");

    /* renamed from: a  reason: collision with root package name */
    final ad f37168a;

    /* renamed from: b  reason: collision with root package name */
    final bh<dk> f37169b;

    /* renamed from: c  reason: collision with root package name */
    final bh<Executor> f37170c;

    /* renamed from: e  reason: collision with root package name */
    private final x f37171e;

    /* renamed from: f  reason: collision with root package name */
    private final aw f37172f;

    /* renamed from: g  reason: collision with root package name */
    private final bo f37173g;

    /* renamed from: h  reason: collision with root package name */
    private final ba f37174h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final ap f37175i;
    private final Handler j = new Handler(Looper.getMainLooper());

    cw(ad adVar, bh<dk> bhVar, x xVar, aw awVar, bo boVar, ba baVar, ap apVar, bh<Executor> bhVar2) {
        this.f37168a = adVar;
        this.f37169b = bhVar;
        this.f37171e = xVar;
        this.f37172f = awVar;
        this.f37173g = boVar;
        this.f37174h = baVar;
        this.f37175i = apVar;
        this.f37170c = bhVar2;
    }

    private final void a() {
        this.f37170c.a().execute(new ct(this));
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z) {
        boolean a2 = this.f37171e.a();
        this.f37171e.a(z);
        if (z && !a2) {
            a();
        }
    }
}
