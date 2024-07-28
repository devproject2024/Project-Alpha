package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.e.p;

final class q extends n<Void> {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ s f37232c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    q(s sVar, p<Void> pVar) {
        super(sVar, pVar);
        this.f37232c = sVar;
    }

    public final void a(Bundle bundle, Bundle bundle2) {
        super.a(bundle, bundle2);
        if (!this.f37232c.f37243g.compareAndSet(true, false)) {
            s.f37237a.e("Expected keepingAlive to be true, but was false.", new Object[0]);
        }
        if (bundle.getBoolean("keep_alive")) {
            this.f37232c.a();
        }
    }
}
