package net.one97.paytm.upi.util;

import com.appsflyer.internal.referrer.Payload;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.utility.n;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountBalanceModel;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.CJRAccountSummary;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.profile.b.a;

public final class UPICheckBalanceHelper$getUpiAccountBalance$1 implements a.C1382a {
    final /* synthetic */ UpiProfileDefaultBank $upiProfileDefaultBank;
    final /* synthetic */ UPICheckBalanceHelper this$0;

    UPICheckBalanceHelper$getUpiAccountBalance$1(UPICheckBalanceHelper uPICheckBalanceHelper, UpiProfileDefaultBank upiProfileDefaultBank) {
        this.this$0 = uPICheckBalanceHelper;
        this.$upiProfileDefaultBank = upiProfileDefaultBank;
    }

    public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
        k.c(upiBaseDataModel, Payload.RESPONSE);
        if (this.this$0.isFragmentAttached()) {
            this.this$0.listener.b();
        }
        if (upiBaseDataModel instanceof CJRAccountSummary) {
            CJRAccountSummary cJRAccountSummary = (CJRAccountSummary) upiBaseDataModel;
            if (cJRAccountSummary.getStatus() == null || !p.a(cJRAccountSummary.getStatus(), "success", true)) {
                this.this$0.onCheckBalanceError((UpiCustomVolleyError) null, "");
                return;
            }
            AccountBalanceModel accountBalanceModel = cJRAccountSummary.getAccounts().get(0);
            if (accountBalanceModel == null || !this.this$0.isFragmentAttached()) {
                this.this$0.onCheckBalanceError((UpiCustomVolleyError) null, "");
                return;
            }
            n.c access$getListener$p = this.this$0.listener;
            String valueOf = String.valueOf(accountBalanceModel.getEffectiveBalance());
            String valueOf2 = String.valueOf(accountBalanceModel.getEffectiveBalance());
            BankAccountDetails.BankAccount debitBank = this.$upiProfileDefaultBank.getDebitBank();
            k.a((Object) debitBank, "upiProfileDefaultBank.debitBank");
            String accountType = debitBank.getAccountType();
            k.a((Object) accountType, "upiProfileDefaultBank.debitBank.accountType");
            access$getListener$p.a(valueOf, valueOf2, accountType);
            return;
        }
        this.this$0.onCheckBalanceError((UpiCustomVolleyError) null, "");
    }

    public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
        k.c(upiCustomVolleyError, "error");
        if (this.this$0.isFragmentAttached()) {
            this.this$0.listener.b();
        }
        this.this$0.onCheckBalanceError(upiCustomVolleyError, "");
    }
}
