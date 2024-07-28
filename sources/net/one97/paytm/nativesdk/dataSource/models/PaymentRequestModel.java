package net.one97.paytm.nativesdk.dataSource.models;

import kotlin.g.b.k;
import net.one97.paytm.nativesdk.transcation.PayUtility;

public class PaymentRequestModel {
    private final String paymentFlow;

    public PaymentRequestModel(String str) {
        k.c(str, PayUtility.PAYMENT_FLOW);
        this.paymentFlow = str;
    }

    public final String getPaymentFlow() {
        return this.paymentFlow;
    }
}
