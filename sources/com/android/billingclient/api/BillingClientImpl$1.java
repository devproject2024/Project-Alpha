package com.android.billingclient.api;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.android.billingclient.a.a;

class BillingClientImpl$1 extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f30905a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BillingClientImpl$1(c cVar, Handler handler) {
        super(handler);
        this.f30905a = cVar;
    }

    public void onReceiveResult(int i2, Bundle bundle) {
        h a2 = this.f30905a.f30915b.f30908b.f30911c;
        if (a2 == null) {
            a.b("BillingClient");
        } else {
            a2.a(i2, a.a(bundle));
        }
    }
}
