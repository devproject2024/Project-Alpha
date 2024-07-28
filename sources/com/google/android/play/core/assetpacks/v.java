package com.google.android.play.core.assetpacks;

import android.os.Bundle;

final /* synthetic */ class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final x f37248a;

    /* renamed from: b  reason: collision with root package name */
    private final Bundle f37249b;

    /* renamed from: c  reason: collision with root package name */
    private final c f37250c;

    v(x xVar, Bundle bundle, c cVar) {
        this.f37248a = xVar;
        this.f37249b = bundle;
        this.f37250c = cVar;
    }

    public final void run() {
        x xVar = this.f37248a;
        Bundle bundle = this.f37249b;
        c cVar = this.f37250c;
        bo boVar = xVar.f37253a;
        if (((Boolean) boVar.a(new be(boVar, bundle))).booleanValue()) {
            xVar.a(cVar);
            xVar.f37255c.a().a();
        }
    }
}
