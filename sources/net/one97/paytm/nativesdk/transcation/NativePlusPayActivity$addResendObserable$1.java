package net.one97.paytm.nativesdk.transcation;

import androidx.lifecycle.z;
import net.one97.paytm.nativesdk.transcation.model.OtpApiResponse;

public final class NativePlusPayActivity$addResendObserable$1 implements z<OtpApiResponse> {
    final /* synthetic */ NativePlusPayActivity this$0;

    NativePlusPayActivity$addResendObserable$1(NativePlusPayActivity nativePlusPayActivity) {
        this.this$0 = nativePlusPayActivity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r0 = r9.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onChanged(net.one97.paytm.nativesdk.transcation.model.OtpApiResponse r9) {
        /*
            r8 = this;
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r0 = r8.this$0
            r0.enableResendButton()
            if (r9 == 0) goto L_0x0012
            net.one97.paytm.nativesdk.transcation.model.Body r0 = r9.getBody()
            if (r0 == 0) goto L_0x0012
            net.one97.paytm.nativesdk.paymethods.model.processtransaction.ResultInfo r0 = r0.getResultInfo()
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            java.lang.String r1 = "getString(R.string.default_resend_otp_failed_msg)"
            if (r0 != 0) goto L_0x003a
            java.lang.String r2 = ""
            java.lang.String r3 = "direct_otp_action"
            java.lang.String r4 = "resend_otp"
            java.lang.String r5 = "timeout"
            java.lang.String r6 = "Native_plus"
            java.lang.String r7 = ""
            java.util.Map r9 = net.one97.paytm.nativesdk.Utils.SDKUtility.getGenericEventParams(r2, r3, r4, r5, r6, r7)
            net.one97.paytm.nativesdk.Utils.SDKUtility.sendGaEvents(r9)
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r9 = r8.this$0
            int r0 = net.one97.paytm.nativesdk.R.string.default_resend_otp_failed_msg
            java.lang.String r0 = r9.getString(r0)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r9.showOtpErrorView(r0)
            goto L_0x00a6
        L_0x003a:
            net.one97.paytm.nativesdk.transcation.model.Body r9 = r9.getBody()
            if (r9 == 0) goto L_0x00a6
            net.one97.paytm.nativesdk.paymethods.model.processtransaction.ResultInfo r9 = r9.getResultInfo()
            if (r9 == 0) goto L_0x00a6
            java.lang.String r0 = r9.getResultCode()
            java.lang.String r2 = "0000"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r0)
            if (r0 != 0) goto L_0x0089
            java.lang.String r0 = r9.getResultStatus()
            java.lang.String r2 = "S"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x005f
            goto L_0x0089
        L_0x005f:
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r0 = r8.this$0
            java.lang.String r9 = r9.getResultMsg()
            if (r9 != 0) goto L_0x0072
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r9 = r8.this$0
            int r2 = net.one97.paytm.nativesdk.R.string.default_resend_otp_failed_msg
            java.lang.String r9 = r9.getString(r2)
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r1)
        L_0x0072:
            r0.showOtpErrorView(r9)
            java.lang.String r1 = ""
            java.lang.String r2 = "direct_otp_action"
            java.lang.String r3 = "resend_otp"
            java.lang.String r4 = "failed"
            java.lang.String r5 = "Native_plus"
            java.lang.String r6 = ""
            java.util.Map r9 = net.one97.paytm.nativesdk.Utils.SDKUtility.getGenericEventParams(r1, r2, r3, r4, r5, r6)
            net.one97.paytm.nativesdk.Utils.SDKUtility.sendGaEvents(r9)
            goto L_0x00a6
        L_0x0089:
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r0 = r8.this$0
            java.lang.String r9 = r9.getResultMsg()
            r0.showResendOtpSuccessUi(r9)
            java.lang.String r1 = ""
            java.lang.String r2 = "direct_otp_action"
            java.lang.String r3 = "resend_otp"
            java.lang.String r4 = "success"
            java.lang.String r5 = "Native_plus"
            java.lang.String r6 = ""
            java.util.Map r9 = net.one97.paytm.nativesdk.Utils.SDKUtility.getGenericEventParams(r1, r2, r3, r4, r5, r6)
            net.one97.paytm.nativesdk.Utils.SDKUtility.sendGaEvents(r9)
        L_0x00a6:
            android.os.Handler r9 = new android.os.Handler
            r9.<init>()
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity$addResendObserable$1$onChanged$2 r0 = new net.one97.paytm.nativesdk.transcation.NativePlusPayActivity$addResendObserable$1$onChanged$2
            r0.<init>(r8)
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            r1 = 4000(0xfa0, double:1.9763E-320)
            r9.postDelayed(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.transcation.NativePlusPayActivity$addResendObserable$1.onChanged(net.one97.paytm.nativesdk.transcation.model.OtpApiResponse):void");
    }
}
