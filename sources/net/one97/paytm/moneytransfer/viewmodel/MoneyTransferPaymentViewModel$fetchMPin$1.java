package net.one97.paytm.moneytransfer.viewmodel;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import kotlin.g.b.k;

public final class MoneyTransferPaymentViewModel$fetchMPin$1 extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f54657a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MoneyTransferPaymentViewModel$fetchMPin$1(e eVar, Handler handler) {
        super(handler);
        this.f54657a = eVar;
    }

    /* access modifiers changed from: protected */
    public final void onReceiveResult(int i2, Bundle bundle) {
        k.c(bundle, "resultData");
        super.onReceiveResult(i2, bundle);
        e.a(this.f54657a, bundle);
    }
}
