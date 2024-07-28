package net.one97.paytm.nativesdk.transcation;

import easypay.listeners.AppCallbacks;

public final class NativePlusPayActivity$initOtpHelper$2 implements AppCallbacks {
    final /* synthetic */ NativePlusPayActivity this$0;

    public final void onApiError(String str) {
    }

    public final void onNetworkError(String str) {
    }

    NativePlusPayActivity$initOtpHelper$2(NativePlusPayActivity nativePlusPayActivity) {
        this.this$0 = nativePlusPayActivity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0034, code lost:
        if ((r0.length() == 0) != true) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void smsReceivedCallback(java.lang.String r4, boolean r5) {
        /*
            r3 = this;
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r0 = r3.this$0
            java.lang.String r0 = r0.TAG
            java.lang.String r1 = java.lang.String.valueOf(r4)
            java.lang.String r2 = "received otp is "
            java.lang.String r1 = r2.concat(r1)
            net.one97.paytm.nativesdk.Utils.LogUtility.d(r0, r1)
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r0 = r3.this$0
            int r1 = net.one97.paytm.nativesdk.R.id.otpEditText
            android.view.View r0 = r0._$_findCachedViewById(r1)
            net.one97.paytm.nativesdk.transcation.OtpEditText r0 = (net.one97.paytm.nativesdk.transcation.OtpEditText) r0
            java.lang.String r1 = "otpEditText"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.text.Editable r0 = r0.getText()
            r1 = 1
            if (r0 == 0) goto L_0x0036
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0033
            r0 = 1
            goto L_0x0034
        L_0x0033:
            r0 = 0
        L_0x0034:
            if (r0 == r1) goto L_0x0038
        L_0x0036:
            if (r5 == 0) goto L_0x0059
        L_0x0038:
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r5 = r3.this$0
            int r0 = net.one97.paytm.nativesdk.R.id.otpEditText
            android.view.View r5 = r5._$_findCachedViewById(r0)
            net.one97.paytm.nativesdk.transcation.OtpEditText r5 = (net.one97.paytm.nativesdk.transcation.OtpEditText) r5
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r5.setText(r4)
            net.one97.paytm.nativesdk.transcation.NativePlusPayActivity r4 = r3.this$0
            r4.isOtpAutoFilled = r1
            java.lang.String r4 = "direct_otp_input"
            java.lang.String r5 = "auto_fill"
            java.lang.String r0 = ""
            java.util.Map r4 = net.one97.paytm.nativesdk.Utils.SDKUtility.getGenericEventParams(r4, r5, r0)
            net.one97.paytm.nativesdk.Utils.SDKUtility.sendGaEvents(r4)
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.transcation.NativePlusPayActivity$initOtpHelper$2.smsReceivedCallback(java.lang.String, boolean):void");
    }
}
