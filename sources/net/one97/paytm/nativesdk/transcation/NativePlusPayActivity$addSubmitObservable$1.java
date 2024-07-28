package net.one97.paytm.nativesdk.transcation;

import androidx.lifecycle.z;
import net.one97.paytm.nativesdk.transcation.model.OtpApiResponse;

public final class NativePlusPayActivity$addSubmitObservable$1 implements z<OtpApiResponse> {
    final /* synthetic */ NativePlusPayActivity this$0;

    NativePlusPayActivity$addSubmitObservable$1(NativePlusPayActivity nativePlusPayActivity) {
        this.this$0 = nativePlusPayActivity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r1 = r9.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onChanged(net.one97.paytm.nativesdk.transcation.model.OtpApiResponse r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x000e
            net.one97.paytm.nativesdk.transcation.model.Body r1 = r9.getBody()
            if (r1 == 0) goto L_0x000e
            net.one97.paytm.nativesdk.paymethods.model.processtransaction.ResultInfo r1 = r1.getResultInfo()
            goto L_0x000f
        L_0x000e:
            r1 = r0
        L_0x000f:
            if (r1 != 0) goto L_0x003e
            java.lang.String r9 = "api_timeout"
            java.lang.String r1 = "otp_submit_api"
            java.lang.String r2 = "direct_otp_page"
            java.util.Map r9 = net.one97.paytm.nativesdk.Utils.SDKUtility.getGenericEventParams(r9, r1, r2)
            net.one97.paytm.nativesdk.Utils.SDKUtility.sendGaEvents(r9)
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r9 = r8.this$0
            r9.enableUiInteraction()
            java.lang.String r1 = ""
            java.lang.String r2 = "direct_otp_action"
            java.lang.String r3 = "submit_otp"
            java.lang.String r4 = "timeout"
            java.lang.String r5 = "Native_plus"
            java.lang.String r6 = ""
            java.util.Map r9 = net.one97.paytm.nativesdk.Utils.SDKUtility.getGenericEventParams(r1, r2, r3, r4, r5, r6)
            net.one97.paytm.nativesdk.Utils.SDKUtility.sendGaEvents(r9)
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r9 = r8.this$0
            android.app.Activity r9 = (android.app.Activity) r9
            net.one97.paytm.nativesdk.transcation.PayUtility.finishSdk(r9, r0)
            return
        L_0x003e:
            net.one97.paytm.nativesdk.transcation.model.Body r1 = r9.getBody()
            if (r1 == 0) goto L_0x01e5
            net.one97.paytm.nativesdk.paymethods.model.processtransaction.ResultInfo r1 = r1.getResultInfo()
            if (r1 == 0) goto L_0x01e5
            java.lang.String r2 = r1.getResultCode()
            java.lang.String r3 = "0000"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r2)
            if (r2 != 0) goto L_0x017d
            java.lang.String r2 = r1.getResultStatus()
            java.lang.String r3 = "S"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x0064
            goto L_0x017d
        L_0x0064:
            java.lang.Boolean r2 = r1.getBankRetry()
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x00be
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r9 = r8.this$0
            net.one97.paytm.nativesdk.transcation.PaymentInstrument r9 = r9.paymentInstrument
            if (r9 == 0) goto L_0x0098
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r9 = r8.this$0
            net.one97.paytm.nativesdk.transcation.PaymentInstrument r9 = r9.paymentInstrument
            if (r9 == 0) goto L_0x0084
            java.lang.String r0 = r9.getGaPaymentMethod()
        L_0x0084:
            r4 = r0
            java.lang.String r5 = r1.getResultMsg()
            java.lang.String r2 = ""
            java.lang.String r3 = "pay_clicked_error"
            java.lang.String r6 = "Native_plus"
            java.lang.String r7 = "Failed"
            java.util.Map r9 = net.one97.paytm.nativesdk.Utils.SDKUtility.getGenericEventParams(r2, r3, r4, r5, r6, r7)
            net.one97.paytm.nativesdk.Utils.SDKUtility.sendGaEvents(r9)
        L_0x0098:
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r9 = r8.this$0
            r9.enableUiInteraction()
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r9 = r8.this$0
            java.lang.String r0 = r1.getResultMsg()
            if (r0 != 0) goto L_0x00a7
            java.lang.String r0 = ""
        L_0x00a7:
            r9.showRetryDialog(r0)
            java.lang.String r1 = ""
            java.lang.String r2 = "direct_otp_action"
            java.lang.String r3 = "submit_otp"
            java.lang.String r4 = "retry_true"
            java.lang.String r5 = "Native_plus"
            java.lang.String r6 = ""
            java.util.Map r9 = net.one97.paytm.nativesdk.Utils.SDKUtility.getGenericEventParams(r1, r2, r3, r4, r5, r6)
            net.one97.paytm.nativesdk.Utils.SDKUtility.sendGaEvents(r9)
            return
        L_0x00be:
            java.lang.Boolean r2 = r1.getRetry()
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0114
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r9 = r8.this$0
            net.one97.paytm.nativesdk.transcation.PaymentInstrument r9 = r9.paymentInstrument
            if (r9 == 0) goto L_0x00f2
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r9 = r8.this$0
            net.one97.paytm.nativesdk.transcation.PaymentInstrument r9 = r9.paymentInstrument
            if (r9 == 0) goto L_0x00de
            java.lang.String r0 = r9.getGaPaymentMethod()
        L_0x00de:
            r4 = r0
            java.lang.String r5 = r1.getResultMsg()
            java.lang.String r2 = ""
            java.lang.String r3 = "pay_clicked_error"
            java.lang.String r6 = "Native_plus"
            java.lang.String r7 = "Failed"
            java.util.Map r9 = net.one97.paytm.nativesdk.Utils.SDKUtility.getGenericEventParams(r2, r3, r4, r5, r6, r7)
            net.one97.paytm.nativesdk.Utils.SDKUtility.sendGaEvents(r9)
        L_0x00f2:
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r9 = r8.this$0
            r9.enableUiInteraction()
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r9 = r8.this$0
            java.lang.String r0 = r1.getResultMsg()
            r9.redirectToPaymentOptions(r0)
            java.lang.String r1 = ""
            java.lang.String r2 = "direct_otp_action"
            java.lang.String r3 = "submit_otp"
            java.lang.String r4 = "retry_true"
            java.lang.String r5 = "Native_plus"
            java.lang.String r6 = ""
            java.util.Map r9 = net.one97.paytm.nativesdk.Utils.SDKUtility.getGenericEventParams(r1, r2, r3, r4, r5, r6)
            net.one97.paytm.nativesdk.Utils.SDKUtility.sendGaEvents(r9)
            return
        L_0x0114:
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r1 = r8.this$0
            net.one97.paytm.nativesdk.transcation.PaymentInstrument r1 = r1.paymentInstrument
            if (r1 == 0) goto L_0x0149
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r1 = r8.this$0
            net.one97.paytm.nativesdk.transcation.PaymentInstrument r1 = r1.paymentInstrument
            if (r1 == 0) goto L_0x012a
            java.lang.String r1 = r1.getGaPaymentMethod()
            r4 = r1
            goto L_0x012b
        L_0x012a:
            r4 = r0
        L_0x012b:
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r1 = r8.this$0
            net.one97.paytm.nativesdk.transcation.PaymentInstrument r1 = r1.paymentInstrument
            if (r1 == 0) goto L_0x0139
            java.lang.String r1 = r1.getGaPaymentMode()
            r5 = r1
            goto L_0x013a
        L_0x0139:
            r5 = r0
        L_0x013a:
            java.lang.String r2 = ""
            java.lang.String r3 = "pay_complete"
            java.lang.String r6 = "Native_plus"
            java.lang.String r7 = "Failed"
            java.util.Map r1 = net.one97.paytm.nativesdk.Utils.SDKUtility.getGenericEventParams(r2, r3, r4, r5, r6, r7)
            net.one97.paytm.nativesdk.Utils.SDKUtility.sendGaEvents(r1)
        L_0x0149:
            java.lang.String r2 = ""
            java.lang.String r3 = "direct_otp_action"
            java.lang.String r4 = "submit_otp"
            java.lang.String r5 = "retry_false"
            java.lang.String r6 = "Native_plus"
            java.lang.String r7 = ""
            java.util.Map r1 = net.one97.paytm.nativesdk.Utils.SDKUtility.getGenericEventParams(r2, r3, r4, r5, r6, r7)
            net.one97.paytm.nativesdk.Utils.SDKUtility.sendGaEvents(r1)
            net.one97.paytm.nativesdk.transcation.model.Body r1 = r9.getBody()
            if (r1 == 0) goto L_0x0167
            java.lang.Object r1 = r1.getTxnInfo()
            goto L_0x0168
        L_0x0167:
            r1 = r0
        L_0x0168:
            if (r1 != 0) goto L_0x0177
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r9 = r8.this$0
            r9.enableUiInteraction()
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r9 = r8.this$0
            android.app.Activity r9 = (android.app.Activity) r9
            net.one97.paytm.nativesdk.transcation.PayUtility.finishSdk(r9, r0)
            return
        L_0x0177:
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r0 = r8.this$0
            r0.postDataOnCallBack(r9)
            return
        L_0x017d:
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r1 = r8.this$0
            net.one97.paytm.nativesdk.transcation.PaymentInstrument r1 = r1.paymentInstrument
            if (r1 == 0) goto L_0x01b2
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r1 = r8.this$0
            net.one97.paytm.nativesdk.transcation.PaymentInstrument r1 = r1.paymentInstrument
            if (r1 == 0) goto L_0x0193
            java.lang.String r1 = r1.getGaPaymentMethod()
            r4 = r1
            goto L_0x0194
        L_0x0193:
            r4 = r0
        L_0x0194:
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r1 = r8.this$0
            net.one97.paytm.nativesdk.transcation.PaymentInstrument r1 = r1.paymentInstrument
            if (r1 == 0) goto L_0x01a2
            java.lang.String r1 = r1.getGaPaymentMode()
            r5 = r1
            goto L_0x01a3
        L_0x01a2:
            r5 = r0
        L_0x01a3:
            java.lang.String r2 = ""
            java.lang.String r3 = "pay_complete"
            java.lang.String r6 = "Native_plus"
            java.lang.String r7 = "Success"
            java.util.Map r1 = net.one97.paytm.nativesdk.Utils.SDKUtility.getGenericEventParams(r2, r3, r4, r5, r6, r7)
            net.one97.paytm.nativesdk.Utils.SDKUtility.sendGaEvents(r1)
        L_0x01b2:
            java.lang.String r2 = ""
            java.lang.String r3 = "direct_otp_action"
            java.lang.String r4 = "submit_otp"
            java.lang.String r5 = "success"
            java.lang.String r6 = "Native_plus"
            java.lang.String r7 = ""
            java.util.Map r1 = net.one97.paytm.nativesdk.Utils.SDKUtility.getGenericEventParams(r2, r3, r4, r5, r6, r7)
            net.one97.paytm.nativesdk.Utils.SDKUtility.sendGaEvents(r1)
            net.one97.paytm.nativesdk.transcation.model.Body r1 = r9.getBody()
            if (r1 == 0) goto L_0x01d0
            java.lang.Object r1 = r1.getTxnInfo()
            goto L_0x01d1
        L_0x01d0:
            r1 = r0
        L_0x01d1:
            if (r1 != 0) goto L_0x01e0
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r9 = r8.this$0
            r9.enableUiInteraction()
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r9 = r8.this$0
            android.app.Activity r9 = (android.app.Activity) r9
            net.one97.paytm.nativesdk.transcation.PayUtility.finishSdk(r9, r0)
            return
        L_0x01e0:
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r0 = r8.this$0
            r0.postDataOnCallBack(r9)
        L_0x01e5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.transcation.NativePlusPayActivity$addSubmitObservable$1.onChanged(net.one97.paytm.nativesdk.transcation.model.OtpApiResponse):void");
    }
}
