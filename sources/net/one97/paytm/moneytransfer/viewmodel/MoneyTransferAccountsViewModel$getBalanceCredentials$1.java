package net.one97.paytm.moneytransfer.viewmodel;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import kotlin.g.b.k;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;

public final class MoneyTransferAccountsViewModel$getBalanceCredentials$1 extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f54651a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f54652b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ UpiProfileDefaultBank f54653c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MoneyTransferAccountsViewModel$getBalanceCredentials$1(a aVar, String str, UpiProfileDefaultBank upiProfileDefaultBank, Handler handler) {
        super(handler);
        this.f54651a = aVar;
        this.f54652b = str;
        this.f54653c = upiProfileDefaultBank;
    }

    /* access modifiers changed from: protected */
    public final void onReceiveResult(int i2, Bundle bundle) {
        k.c(bundle, "resultData");
        super.onReceiveResult(i2, bundle);
        a aVar = this.f54651a;
        int b2 = aVar.f54660c;
        String str = this.f54652b;
        k.a((Object) str, "txnId");
        a.a(aVar, b2, bundle, str, this.f54653c);
    }
}
