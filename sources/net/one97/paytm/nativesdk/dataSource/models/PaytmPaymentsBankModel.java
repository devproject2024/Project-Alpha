package net.one97.paytm.nativesdk.dataSource.models;

import kotlin.g.b.k;
import net.one97.paytm.nativesdk.transcation.PayUtility;

public final class PaytmPaymentsBankModel extends PaymentRequestModel {
    private final String pin;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaytmPaymentsBankModel(String str, String str2) {
        super(str2);
        k.c(str, "pin");
        k.c(str2, PayUtility.PAYMENT_FLOW);
        this.pin = str;
    }

    public final String getPin() {
        return this.pin;
    }
}
