package net.one97.paytm.nativesdk.common.helpers;

import kotlin.g.b.x;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.common.model.PcfDetailsResponse;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;

public final class PCFHelperAIO$verifyCart$1 implements PaymentMethodDataSource.Callback<PcfDetailsResponse> {
    final /* synthetic */ PaytmSDKRequestClient.OnVerifyResponse $onVerifyResponse;
    final /* synthetic */ x.e $paymentMode;

    PCFHelperAIO$verifyCart$1(x.e eVar, PaytmSDKRequestClient.OnVerifyResponse onVerifyResponse) {
        this.$paymentMode = eVar;
        this.$onVerifyResponse = onVerifyResponse;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
        r5 = (r5 = r5.getBody()).getConsultDetails();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onResponse(net.one97.paytm.nativesdk.common.model.PcfDetailsResponse r5) {
        /*
            r4 = this;
            net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$VerifyResponseData r0 = new net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$VerifyResponseData
            r0.<init>()
            net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$ConvFeeResponse r1 = new net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$ConvFeeResponse
            r1.<init>()
            r2 = 0
            if (r5 == 0) goto L_0x0026
            net.one97.paytm.nativesdk.common.model.PcfDetailsResponse$PcfBody r5 = r5.getBody()
            if (r5 == 0) goto L_0x0026
            java.util.Map r5 = r5.getConsultDetails()
            if (r5 == 0) goto L_0x0026
            kotlin.g.b.x$e r3 = r4.$paymentMode
            T r3 = r3.element
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r5 = r5.get(r3)
            net.one97.paytm.nativesdk.common.model.PcfDetailsResponse$ConsultDetail r5 = (net.one97.paytm.nativesdk.common.model.PcfDetailsResponse.ConsultDetail) r5
            goto L_0x0027
        L_0x0026:
            r5 = r2
        L_0x0027:
            if (r5 == 0) goto L_0x0034
            net.one97.paytm.nativesdk.common.model.AccountBalance r3 = r5.getTotalConvenienceCharges()
            if (r3 == 0) goto L_0x0034
            java.lang.String r3 = r3.getValue()
            goto L_0x0035
        L_0x0034:
            r3 = r2
        L_0x0035:
            r1.setAggregatePGConvFee(r3)
            if (r5 == 0) goto L_0x003f
            java.lang.String r3 = r5.getText()
            goto L_0x0040
        L_0x003f:
            r3 = r2
        L_0x0040:
            r1.setConvFeeLabel(r3)
            if (r5 == 0) goto L_0x0050
            net.one97.paytm.nativesdk.common.model.AccountBalance r3 = r5.getTotalTransactionAmount()
            if (r3 == 0) goto L_0x0050
            java.lang.String r3 = r3.getValue()
            goto L_0x0051
        L_0x0050:
            r3 = r2
        L_0x0051:
            r1.setTotalAmtIncConvFee(r3)
            if (r5 == 0) goto L_0x0060
            net.one97.paytm.nativesdk.common.model.AccountBalance r5 = r5.getBaseTransactionAmount()
            if (r5 == 0) goto L_0x0060
            java.lang.String r2 = r5.getValue()
        L_0x0060:
            r1.setTotalAmtExConvFee(r2)
            r0.setConvFeeResponse(r1)
            net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$OnVerifyResponse r5 = r4.$onVerifyResponse
            if (r5 == 0) goto L_0x006d
            r5.onVerifySuccess(r0)
        L_0x006d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.common.helpers.PCFHelperAIO$verifyCart$1.onResponse(net.one97.paytm.nativesdk.common.model.PcfDetailsResponse):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        r3 = (r3 = (r3 = r3.getBody()).getResultInfo()).getResultCode();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onErrorResponse(com.android.volley.VolleyError r2, net.one97.paytm.nativesdk.common.model.PcfDetailsResponse r3) {
        /*
            r1 = this;
            net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$ApiResponseError r2 = new net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$ApiResponseError
            r2.<init>()
            if (r3 == 0) goto L_0x0019
            net.one97.paytm.nativesdk.common.model.PcfDetailsResponse$PcfBody r0 = r3.getBody()
            if (r0 == 0) goto L_0x0019
            net.one97.paytm.nativesdk.common.model.ResultInfo r0 = r0.getResultInfo()
            if (r0 == 0) goto L_0x0019
            java.lang.String r0 = r0.getResultMsg()
            if (r0 != 0) goto L_0x001b
        L_0x0019:
            java.lang.String r0 = "F"
        L_0x001b:
            r2.setErrorMsg(r0)
            if (r3 == 0) goto L_0x0037
            net.one97.paytm.nativesdk.common.model.PcfDetailsResponse$PcfBody r3 = r3.getBody()
            if (r3 == 0) goto L_0x0037
            net.one97.paytm.nativesdk.common.model.ResultInfo r3 = r3.getResultInfo()
            if (r3 == 0) goto L_0x0037
            java.lang.String r3 = r3.getResultCode()
            if (r3 == 0) goto L_0x0037
            int r3 = java.lang.Integer.parseInt(r3)
            goto L_0x0038
        L_0x0037:
            r3 = 0
        L_0x0038:
            r2.setStatusCode(r3)
            net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$OnVerifyResponse r3 = r1.$onVerifyResponse
            if (r3 == 0) goto L_0x0042
            r3.onVerifyError(r2)
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.common.helpers.PCFHelperAIO$verifyCart$1.onErrorResponse(com.android.volley.VolleyError, net.one97.paytm.nativesdk.common.model.PcfDetailsResponse):void");
    }
}
