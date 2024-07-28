package net.one97.paytm.moneytransferv4.home.presentation.viewmodel;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import kotlin.g.b.k;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;

public final class MoneyTransferV4ActivityViewModel$getBalanceCredentials$1 extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f55557a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f55558b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ UpiProfileDefaultBank f55559c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MoneyTransferV4ActivityViewModel$getBalanceCredentials$1(a aVar, String str, UpiProfileDefaultBank upiProfileDefaultBank, Handler handler) {
        super(handler);
        this.f55557a = aVar;
        this.f55558b = str;
        this.f55559c = upiProfileDefaultBank;
    }

    /* access modifiers changed from: protected */
    public final void onReceiveResult(int i2, Bundle bundle) {
        k.c(bundle, "resultData");
        super.onReceiveResult(i2, bundle);
        a aVar = this.f55557a;
        int d2 = aVar.C;
        String str = this.f55558b;
        k.a((Object) str, "txnId");
        a.a(aVar, d2, bundle, str, this.f55559c);
    }
}
