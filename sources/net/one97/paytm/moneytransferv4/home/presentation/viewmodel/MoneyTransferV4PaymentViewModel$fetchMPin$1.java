package net.one97.paytm.moneytransferv4.home.presentation.viewmodel;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import kotlin.g.b.k;

public final class MoneyTransferV4PaymentViewModel$fetchMPin$1 extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f55560a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MoneyTransferV4PaymentViewModel$fetchMPin$1(c cVar, Handler handler) {
        super(handler);
        this.f55560a = cVar;
    }

    /* access modifiers changed from: protected */
    public final void onReceiveResult(int i2, Bundle bundle) {
        k.c(bundle, "resultData");
        super.onReceiveResult(i2, bundle);
        c.a(this.f55560a, bundle);
    }
}
