package net.one97.paytm.upi.util;

import com.appsflyer.internal.referrer.Payload;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.registration.b.a.a;

public final class UPICheckBalanceHelper$getUpiAccountBalance$2 implements a.C1389a {
    final /* synthetic */ UpiProfileDefaultBank $upiProfileDefaultBank;
    final /* synthetic */ UPICheckBalanceHelper this$0;

    UPICheckBalanceHelper$getUpiAccountBalance$2(UPICheckBalanceHelper uPICheckBalanceHelper, UpiProfileDefaultBank upiProfileDefaultBank) {
        this.this$0 = uPICheckBalanceHelper;
        this.$upiProfileDefaultBank = upiProfileDefaultBank;
    }

    public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
        k.c(upiBaseDataModel, Payload.RESPONSE);
        if (this.this$0.isFragmentAttached()) {
            if (upiBaseDataModel instanceof BaseUpiResponse) {
                UPICheckBalanceHelper uPICheckBalanceHelper = this.this$0;
                Object mobileAppData = ((BaseUpiResponse) upiBaseDataModel).getMobileAppData();
                if (mobileAppData != null) {
                    uPICheckBalanceHelper.fetchTokenForBalance((String) mobileAppData, this.$upiProfileDefaultBank);
                    return;
                }
                throw new u("null cannot be cast to non-null type kotlin.String");
            }
            this.this$0.onGetCredentialError("");
        }
    }

    public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
        k.c(upiCustomVolleyError, "error");
        if (this.this$0.isFragmentAttached()) {
            this.this$0.onGetCredentialError(upiCustomVolleyError.getAlertTitle());
        }
    }
}
