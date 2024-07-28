package net.one97.paytm.nativesdk.dataSource.models;

import kotlin.g.b.k;
import net.one97.paytm.nativesdk.transcation.PayUtility;

public final class UpiCollectRequestModel extends PaymentRequestModel {
    private final String upiId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UpiCollectRequestModel(String str, String str2) {
        super(str);
        k.c(str, PayUtility.PAYMENT_FLOW);
        k.c(str2, "upiId");
        this.upiId = str2;
    }

    public final String getUpiId() {
        return this.upiId;
    }
}
