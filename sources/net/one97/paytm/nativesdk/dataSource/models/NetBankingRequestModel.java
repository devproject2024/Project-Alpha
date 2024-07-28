package net.one97.paytm.nativesdk.dataSource.models;

import kotlin.g.b.k;
import net.one97.paytm.nativesdk.transcation.PayUtility;

public final class NetBankingRequestModel extends PaymentRequestModel {
    private final String bankCode;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetBankingRequestModel(String str, String str2) {
        super(str);
        k.c(str, PayUtility.PAYMENT_FLOW);
        k.c(str2, "bankCode");
        this.bankCode = str2;
    }

    public final String getBankCode() {
        return this.bankCode;
    }
}
