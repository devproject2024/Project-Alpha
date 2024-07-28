package net.one97.paytm.upi.util;

import com.appsflyer.internal.referrer.Payload;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.utility.n;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.UpiCheckBalanceModel;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.profile.b.a;

public final class UPICheckBalanceHelper$fetchBalanceFromPSP$1 implements a.C1382a {
    final /* synthetic */ UpiProfileDefaultBank $upiProfileDefaultBank;
    final /* synthetic */ UPICheckBalanceHelper this$0;

    UPICheckBalanceHelper$fetchBalanceFromPSP$1(UPICheckBalanceHelper uPICheckBalanceHelper, UpiProfileDefaultBank upiProfileDefaultBank) {
        this.this$0 = uPICheckBalanceHelper;
        this.$upiProfileDefaultBank = upiProfileDefaultBank;
    }

    public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
        k.c(upiBaseDataModel, Payload.RESPONSE);
        if (upiBaseDataModel instanceof BaseUpiResponse) {
            this.this$0.listener.b();
            BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
            if (!baseUpiResponse.isSuccess() || !k.a((Object) "0", (Object) baseUpiResponse.getResponse())) {
                this.this$0.onCheckBalanceError((UpiCustomVolleyError) null, baseUpiResponse.getResponse());
            } else if (baseUpiResponse.getMobileAppData() instanceof UpiCheckBalanceModel) {
                Object mobileAppData = baseUpiResponse.getMobileAppData();
                if (mobileAppData != null) {
                    UpiCheckBalanceModel upiCheckBalanceModel = (UpiCheckBalanceModel) mobileAppData;
                    if (upiCheckBalanceModel == null || !this.this$0.isFragmentAttached()) {
                        this.this$0.onCheckBalanceError((UpiCustomVolleyError) null, "");
                        return;
                    }
                    n.c access$getListener$p = this.this$0.listener;
                    String totalBal = upiCheckBalanceModel.getTotalBal();
                    String availableBalance = upiCheckBalanceModel.getAvailableBalance();
                    String accountType = this.$upiProfileDefaultBank.getDebitBank().getAccountType();
                    k.a((Object) accountType, "upiProfileDefaultBank.debitBank.getAccountType()");
                    access$getListener$p.a(totalBal, availableBalance, accountType);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.upi.UpiCheckBalanceModel");
            }
        } else {
            this.this$0.listener.b();
            this.this$0.onCheckBalanceError((UpiCustomVolleyError) null, "");
        }
    }

    public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
        k.c(upiCustomVolleyError, "error");
        this.this$0.listener.b();
        this.this$0.onCheckBalanceError(upiCustomVolleyError, "");
    }
}
