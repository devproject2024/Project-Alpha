package net.one97.paytm.moneytransfer.viewmodel;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import kotlin.g.b.k;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;

public final class MoneyTransferActivityViewModel$getBalanceCredentials$1 extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f54654a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f54655b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ UpiProfileDefaultBank f54656c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MoneyTransferActivityViewModel$getBalanceCredentials$1(b bVar, String str, UpiProfileDefaultBank upiProfileDefaultBank, Handler handler) {
        super(handler);
        this.f54654a = bVar;
        this.f54655b = str;
        this.f54656c = upiProfileDefaultBank;
    }

    /* access modifiers changed from: protected */
    public final void onReceiveResult(int i2, Bundle bundle) {
        k.c(bundle, "resultData");
        super.onReceiveResult(i2, bundle);
        b bVar = this.f54654a;
        int d2 = bVar.C;
        String str = this.f54655b;
        k.a((Object) str, "txnId");
        b.a(bVar, d2, bundle, str, this.f54656c);
    }
}
