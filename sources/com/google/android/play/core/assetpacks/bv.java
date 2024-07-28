package com.google.android.play.core.assetpacks;

import android.content.Intent;

final /* synthetic */ class bv implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final bw f37093a;

    /* renamed from: b  reason: collision with root package name */
    private final Intent f37094b;

    bv(bw bwVar, Intent intent) {
        this.f37093a = bwVar;
        this.f37094b = intent;
    }

    public final void run() {
        bw bwVar = this.f37093a;
        bwVar.f37097b.a(bwVar.f37098c, this.f37094b);
    }
}
