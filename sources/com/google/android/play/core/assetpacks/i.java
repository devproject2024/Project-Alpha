package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.google.android.play.core.e.p;

final class i extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f37211a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ cw f37212b;

    public final void onReceiveResult(int i2, Bundle bundle) {
        if (i2 == 1) {
            this.f37211a.b(-1);
            this.f37212b.f37175i.f36990a = null;
        } else if (i2 != 2) {
            this.f37211a.b((Exception) new a(-100));
        } else {
            this.f37211a.b(0);
        }
    }
}
