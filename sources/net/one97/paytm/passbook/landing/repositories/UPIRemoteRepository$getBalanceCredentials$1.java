package net.one97.paytm.passbook.landing.repositories;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import kotlin.g.b.k;
import net.one97.paytm.passbook.beans.upi.UpiProfileDefaultBank;
import net.one97.paytm.passbook.landing.c.a;

public final class UPIRemoteRepository$getBalanceCredentials$1 extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f57761a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ UpiProfileDefaultBank f57762b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ a f57763c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UPIRemoteRepository$getBalanceCredentials$1(String str, UpiProfileDefaultBank upiProfileDefaultBank, a aVar, Handler handler) {
        super(handler);
        this.f57761a = str;
        this.f57762b = upiProfileDefaultBank;
        this.f57763c = aVar;
    }

    /* access modifiers changed from: protected */
    public final void onReceiveResult(int i2, Bundle bundle) {
        k.c(bundle, "resultData");
        super.onReceiveResult(i2, bundle);
        k kVar = k.f57801b;
        String str = this.f57761a;
        k.a((Object) str, "txnId");
        k.a(bundle, str, this.f57762b, this.f57763c);
    }
}
