package net.one97.paytm.acceptPayment.model;

import com.business.common_module.e.a;
import com.paytm.network.model.IJRPaytmDataModel;

public final class MerchantInfoRaw extends IJRPaytmDataModel {
    private CJRMerchantContext merchantContext;
    private a merchantInfo;
    private String rawResponse;

    public final String getRawResponse() {
        return this.rawResponse;
    }

    public final void setRawResponse(String str) {
        this.rawResponse = str;
    }

    public final a getMerchantInfo() {
        return this.merchantInfo;
    }

    public final void setMerchantInfo(a aVar) {
        this.merchantInfo = aVar;
    }

    public final CJRMerchantContext getMerchantContext() {
        return this.merchantContext;
    }

    public final void setMerchantContext(CJRMerchantContext cJRMerchantContext) {
        this.merchantContext = cJRMerchantContext;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: net.one97.paytm.acceptPayment.model.CJRMerchantContext} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.paytm.network.model.IJRPaytmDataModel parseResponse(java.lang.String r3, com.google.gsonhtcfix.f r4) {
        /*
            r2 = this;
            r2.rawResponse = r3
            r0 = 0
            if (r4 == 0) goto L_0x000e
            java.lang.Class<com.business.common_module.e.a> r1 = com.business.common_module.e.a.class
            java.lang.Object r1 = r4.a((java.lang.String) r3, r1)
            com.business.common_module.e.a r1 = (com.business.common_module.e.a) r1
            goto L_0x000f
        L_0x000e:
            r1 = r0
        L_0x000f:
            r2.merchantInfo = r1
            if (r4 == 0) goto L_0x001c
            java.lang.Class<net.one97.paytm.acceptPayment.model.CJRMerchantContext> r0 = net.one97.paytm.acceptPayment.model.CJRMerchantContext.class
            java.lang.Object r3 = r4.a((java.lang.String) r3, r0)
            r0 = r3
            net.one97.paytm.acceptPayment.model.CJRMerchantContext r0 = (net.one97.paytm.acceptPayment.model.CJRMerchantContext) r0
        L_0x001c:
            r2.merchantContext = r0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.acceptPayment.model.MerchantInfoRaw.parseResponse(java.lang.String, com.google.gsonhtcfix.f):com.paytm.network.model.IJRPaytmDataModel");
    }
}
