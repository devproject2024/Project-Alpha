package com.google.android.play.core.d;

import android.content.Context;
import android.content.Intent;

final class g implements aa {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f37415a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Intent f37416b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Context f37417c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ i f37418d;

    g(i iVar, d dVar, Intent intent, Context context) {
        this.f37418d = iVar;
        this.f37415a = dVar;
        this.f37416b = intent;
        this.f37417c = context;
    }

    public final void a() {
        this.f37418d.f37424b.post(new h(this.f37418d, this.f37415a, 5, 0));
    }

    public final void a(int i2) {
        this.f37418d.f37424b.post(new h(this.f37418d, this.f37415a, 6, i2));
    }

    public final void b() {
        if (!this.f37416b.getBooleanExtra("triggered_from_app_after_verification", false)) {
            this.f37416b.putExtra("triggered_from_app_after_verification", true);
            this.f37417c.sendBroadcast(this.f37416b);
            return;
        }
        this.f37418d.f37334d.b("Splits copied and verified more than once.", new Object[0]);
    }
}
