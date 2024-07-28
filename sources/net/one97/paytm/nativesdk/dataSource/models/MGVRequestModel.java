package net.one97.paytm.nativesdk.dataSource.models;

import kotlin.g.b.k;
import net.one97.paytm.nativesdk.transcation.PayUtility;

public final class MGVRequestModel extends PaymentRequestModel {
    private final String templateId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MGVRequestModel(String str, String str2) {
        super(str);
        k.c(str, PayUtility.PAYMENT_FLOW);
        k.c(str2, PayUtility.TEMPLATE_ID);
        this.templateId = str2;
    }

    public final String getTemplateId() {
        return this.templateId;
    }
}
