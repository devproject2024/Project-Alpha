package net.one97.paytm.upi.util;

import com.appsflyer.internal.referrer.Payload;
import kotlin.g.b.k;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiToken;
import net.one97.paytm.upi.registration.b.a.a;

public final class UPICheckBalanceHelper$fetchTokenForBalance$$inlined$let$lambda$1 implements a.C1389a {
    final /* synthetic */ String $mobileAppData$inlined;
    final /* synthetic */ UpiProfileDefaultBank $upiProfileDefaultBank$inlined;
    final /* synthetic */ UPICheckBalanceHelper this$0;

    UPICheckBalanceHelper$fetchTokenForBalance$$inlined$let$lambda$1(UPICheckBalanceHelper uPICheckBalanceHelper, String str, UpiProfileDefaultBank upiProfileDefaultBank) {
        this.this$0 = uPICheckBalanceHelper;
        this.$mobileAppData$inlined = str;
        this.$upiProfileDefaultBank$inlined = upiProfileDefaultBank;
    }

    public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
        k.c(upiBaseDataModel, Payload.RESPONSE);
        if (this.this$0.isFragmentAttached()) {
            this.this$0.listener.b();
            if (upiBaseDataModel instanceof UpiToken) {
                UPICheckBalanceHelper uPICheckBalanceHelper = this.this$0;
                String str = this.$mobileAppData$inlined;
                String upiToken = ((UpiToken) upiBaseDataModel).getUpiToken();
                k.a((Object) upiToken, "response.upiToken");
                uPICheckBalanceHelper.getBalanceCredentials(str, upiToken, this.$upiProfileDefaultBank$inlined);
                return;
            }
            this.this$0.onCheckBalanceError((UpiCustomVolleyError) null, "");
        }
    }

    public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
        k.c(upiCustomVolleyError, "error");
        if (this.this$0.isFragmentAttached()) {
            this.this$0.listener.b();
            this.this$0.onCheckBalanceError(upiCustomVolleyError, upiCustomVolleyError.getAlertTitle());
        }
    }
}
