package net.one97.paytm.nativesdk.transcation;

import androidx.lifecycle.z;
import net.one97.paytm.nativesdk.transcation.model.OtpApiResponse;

public final class NativePlusPayActivity$addCancelObserable$1 implements z<OtpApiResponse> {
    final /* synthetic */ NativePlusPayActivity this$0;

    NativePlusPayActivity$addCancelObserable$1(NativePlusPayActivity nativePlusPayActivity) {
        this.this$0 = nativePlusPayActivity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0009, code lost:
        r1 = (r1 = r9.getBody()).getResultInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onChanged(net.one97.paytm.nativesdk.transcation.model.OtpApiResponse r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x0014
            net.one97.paytm.nativesdk.transcation.model.Body r1 = r9.getBody()
            if (r1 == 0) goto L_0x0014
            net.one97.paytm.nativesdk.paymethods.model.processtransaction.ResultInfo r1 = r1.getResultInfo()
            if (r1 == 0) goto L_0x0014
            java.lang.Boolean r1 = r1.getRetry()
            goto L_0x0015
        L_0x0014:
            r1 = r0
        L_0x0015:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x0046
            java.lang.String r2 = ""
            java.lang.String r3 = "direct_otp_action"
            java.lang.String r4 = "cancel_otp"
            java.lang.String r5 = "retry_true"
            java.lang.String r6 = "Native_plus"
            java.lang.String r7 = ""
            java.util.Map r1 = net.one97.paytm.nativesdk.Utils.SDKUtility.getGenericEventParams(r2, r3, r4, r5, r6, r7)
            net.one97.paytm.nativesdk.Utils.SDKUtility.sendGaEvents(r1)
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r1 = r8.this$0
            net.one97.paytm.nativesdk.transcation.model.Body r9 = r9.getBody()
            if (r9 == 0) goto L_0x0042
            net.one97.paytm.nativesdk.paymethods.model.processtransaction.ResultInfo r9 = r9.getResultInfo()
            if (r9 == 0) goto L_0x0042
            java.lang.String r0 = r9.getResultMsg()
        L_0x0042:
            r1.redirectToPaymentOptions(r0)
            goto L_0x005e
        L_0x0046:
            java.lang.String r2 = ""
            java.lang.String r3 = "direct_otp_action"
            java.lang.String r4 = "cancel_otp"
            java.lang.String r5 = "retry_false"
            java.lang.String r6 = "Native_plus"
            java.lang.String r7 = ""
            java.util.Map r9 = net.one97.paytm.nativesdk.Utils.SDKUtility.getGenericEventParams(r2, r3, r4, r5, r6, r7)
            net.one97.paytm.nativesdk.Utils.SDKUtility.sendGaEvents(r9)
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r9 = r8.this$0
            r9.backPressCancelTransaction()
        L_0x005e:
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r9 = r8.this$0
            android.app.AlertDialog r9 = r9.mAlertDialog
            if (r9 == 0) goto L_0x0069
            r9.dismiss()
        L_0x0069:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.transcation.NativePlusPayActivity$addCancelObserable$1.onChanged(net.one97.paytm.nativesdk.transcation.model.OtpApiResponse):void");
    }
}
