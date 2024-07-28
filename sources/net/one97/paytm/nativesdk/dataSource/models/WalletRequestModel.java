package net.one97.paytm.nativesdk.dataSource.models;

import kotlin.g.b.k;
import net.one97.paytm.nativesdk.transcation.PayUtility;

public final class WalletRequestModel extends PaymentRequestModel {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletRequestModel(String str) {
        super(str);
        k.c(str, PayUtility.PAYMENT_FLOW);
    }
}
