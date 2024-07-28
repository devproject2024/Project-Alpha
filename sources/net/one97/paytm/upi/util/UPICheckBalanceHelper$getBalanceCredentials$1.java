package net.one97.paytm.upi.util;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import kotlin.g.b.k;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;

public final class UPICheckBalanceHelper$getBalanceCredentials$1 extends ResultReceiver {
    final /* synthetic */ String $txnId;
    final /* synthetic */ UpiProfileDefaultBank $upiProfileDefaultBank;
    final /* synthetic */ UPICheckBalanceHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UPICheckBalanceHelper$getBalanceCredentials$1(UPICheckBalanceHelper uPICheckBalanceHelper, String str, UpiProfileDefaultBank upiProfileDefaultBank, Handler handler) {
        super(handler);
        this.this$0 = uPICheckBalanceHelper;
        this.$txnId = str;
        this.$upiProfileDefaultBank = upiProfileDefaultBank;
    }

    /* access modifiers changed from: protected */
    public final void onReceiveResult(int i2, Bundle bundle) {
        k.c(bundle, "resultData");
        super.onReceiveResult(i2, bundle);
        UPICheckBalanceHelper uPICheckBalanceHelper = this.this$0;
        int access$getREQUEST_CHECK_BALANCE$p = uPICheckBalanceHelper.REQUEST_CHECK_BALANCE;
        String str = this.$txnId;
        k.a((Object) str, "txnId");
        uPICheckBalanceHelper.parseResult(access$getREQUEST_CHECK_BALANCE$p, bundle, str, this.$upiProfileDefaultBank);
    }
}
