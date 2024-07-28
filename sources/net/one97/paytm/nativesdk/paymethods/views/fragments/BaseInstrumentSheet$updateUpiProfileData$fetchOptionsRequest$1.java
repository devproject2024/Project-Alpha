package net.one97.paytm.nativesdk.paymethods.views.fragments;

import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.VpaFetch;

public final class BaseInstrumentSheet$updateUpiProfileData$fetchOptionsRequest$1 implements FetchPayOptionsListener {
    final /* synthetic */ BaseInstrumentSheet this$0;

    public final void onPaymentOptionsError() {
    }

    public final void onPaymentOptionsReceived(CJPayMethodResponse cJPayMethodResponse) {
        k.c(cJPayMethodResponse, "cjPayMethodResponse");
    }

    public final void onRequestStart() {
    }

    public final void onVpaReceived(VpaFetch vpaFetch) {
        k.c(vpaFetch, "vpaFetch");
    }

    BaseInstrumentSheet$updateUpiProfileData$fetchOptionsRequest$1(BaseInstrumentSheet baseInstrumentSheet) {
        this.this$0 = baseInstrumentSheet;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007d, code lost:
        r5 = (r5 = r5.getUpiProfile()).getRespDetails();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a9, code lost:
        if (((r15 == null || (r15 = r15.getUpiProfile()) == null || (r15 = r15.getRespDetails()) == null || (r15 = r15.getProfileDetail()) == null) ? null : r15.getBankAccounts()) == null) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0137, code lost:
        if (((r15 == null || (r15 = r15.getUpiProfile()) == null || (r15 = r15.getRespDetails()) == null || (r15 = r15.getProfileDetail()) == null) ? null : r15.getBankAccounts()) == null) goto L_0x0139;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onRequestEnd(net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r14, net.one97.paytm.nativesdk.instruments.upipush.pojo.VpaFetch r15) {
        /*
            r13 = this;
            if (r14 != 0) goto L_0x0005
            kotlin.g.b.k.a()
        L_0x0005:
            net.one97.paytm.nativesdk.common.model.Body r15 = r14.getBody()
            java.lang.String r0 = "cjPayMethodResponse!!.body"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r0)
            net.one97.paytm.nativesdk.common.model.MerchantPayOption r15 = r15.getMerchantPayOption()
            java.lang.String r0 = "cjPayMethodResponse.body"
            if (r15 != 0) goto L_0x0051
            net.one97.paytm.nativesdk.common.model.Body r15 = r14.getBody()
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r0)
            net.one97.paytm.nativesdk.common.model.MerchantPayOption r15 = r15.getAddMoneyPayOption()
            if (r15 == 0) goto L_0x0024
            goto L_0x0051
        L_0x0024:
            r14 = 0
            net.one97.paytm.nativesdk.paymethods.views.fragments.BaseInstrumentSheet r15 = r13.this$0
            java.util.ArrayList r15 = r15.instrumentsBaseView
            java.util.Collection r15 = (java.util.Collection) r15
            int r15 = r15.size()
        L_0x0031:
            if (r14 >= r15) goto L_0x0050
            net.one97.paytm.nativesdk.paymethods.views.fragments.BaseInstrumentSheet r0 = r13.this$0
            java.util.ArrayList r0 = r0.instrumentsBaseView
            java.lang.Object r0 = r0.get(r14)
            java.lang.String r1 = "instrumentsBaseView[i]"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.nativesdk.instruments.PaytmBaseView r0 = (net.one97.paytm.nativesdk.instruments.PaytmBaseView) r0
            boolean r1 = r0 instanceof net.one97.paytm.nativesdk.instruments.upionboarding.UpiOnboardingView
            if (r1 == 0) goto L_0x004d
            net.one97.paytm.nativesdk.instruments.upionboarding.UpiOnboardingView r0 = (net.one97.paytm.nativesdk.instruments.upionboarding.UpiOnboardingView) r0
            r0.hideView()
        L_0x004d:
            int r14 = r14 + 1
            goto L_0x0031
        L_0x0050:
            return
        L_0x0051:
            net.one97.paytm.nativesdk.DirectPaymentBL r15 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            java.lang.String r1 = "DirectPaymentBL.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r1)
            net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r15 = r15.getCjPayMethodResponse()
            java.lang.String r2 = "DirectPaymentBL.getInsta….cjPayMethodResponse.body"
            java.lang.String r3 = "DirectPaymentBL.getInstance().cjPayMethodResponse"
            r4 = 0
            if (r15 == 0) goto L_0x00e6
            net.one97.paytm.nativesdk.common.model.Body r15 = r15.getBody()
            if (r15 == 0) goto L_0x00e6
            net.one97.paytm.nativesdk.common.model.MerchantPayOption r5 = r15.getMerchantPayOption()
            if (r5 == 0) goto L_0x00e6
            net.one97.paytm.nativesdk.common.model.MerchantPayOption r5 = r15.getMerchantPayOption()
            if (r5 == 0) goto L_0x0088
            net.one97.paytm.nativesdk.instruments.upipush.model.UpiProfile r5 = r5.getUpiProfile()
            if (r5 == 0) goto L_0x0088
            net.one97.paytm.nativesdk.instruments.upipush.model.ResponseDetails r5 = r5.getRespDetails()
            if (r5 == 0) goto L_0x0088
            net.one97.paytm.nativesdk.instruments.upipush.model.ProfileData r5 = r5.getProfileDetail()
            goto L_0x0089
        L_0x0088:
            r5 = r4
        L_0x0089:
            if (r5 == 0) goto L_0x00ab
            net.one97.paytm.nativesdk.common.model.MerchantPayOption r15 = r15.getMerchantPayOption()
            if (r15 == 0) goto L_0x00a8
            net.one97.paytm.nativesdk.instruments.upipush.model.UpiProfile r15 = r15.getUpiProfile()
            if (r15 == 0) goto L_0x00a8
            net.one97.paytm.nativesdk.instruments.upipush.model.ResponseDetails r15 = r15.getRespDetails()
            if (r15 == 0) goto L_0x00a8
            net.one97.paytm.nativesdk.instruments.upipush.model.ProfileData r15 = r15.getProfileDetail()
            if (r15 == 0) goto L_0x00a8
            java.util.List r15 = r15.getBankAccounts()
            goto L_0x00a9
        L_0x00a8:
            r15 = r4
        L_0x00a9:
            if (r15 != 0) goto L_0x00e6
        L_0x00ab:
            boolean r15 = net.one97.paytm.nativesdk.Utils.SDKUtility.isUpiPushEnabledOnMerchant()
            if (r15 == 0) goto L_0x00e6
            net.one97.paytm.nativesdk.DirectPaymentBL r15 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r1)
            net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r15 = r15.getCjPayMethodResponse()
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r3)
            net.one97.paytm.nativesdk.common.model.Body r15 = r15.getBody()
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r2)
            net.one97.paytm.nativesdk.common.model.MerchantPayOption r15 = r15.getMerchantPayOption()
            java.lang.String r5 = "DirectPaymentBL.getInsta…se.body.merchantPayOption"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r5)
            net.one97.paytm.nativesdk.common.model.Body r5 = r14.getBody()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r0)
            net.one97.paytm.nativesdk.common.model.MerchantPayOption r5 = r5.getMerchantPayOption()
            java.lang.String r6 = "cjPayMethodResponse.body.merchantPayOption"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            net.one97.paytm.nativesdk.instruments.upipush.model.UpiProfile r5 = r5.getUpiProfile()
            r15.setUpiProfile(r5)
        L_0x00e6:
            net.one97.paytm.nativesdk.DirectPaymentBL r15 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r1)
            net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r15 = r15.getCjPayMethodResponse()
            if (r15 == 0) goto L_0x0174
            net.one97.paytm.nativesdk.common.model.Body r15 = r15.getBody()
            if (r15 == 0) goto L_0x0174
            net.one97.paytm.nativesdk.common.model.MerchantPayOption r5 = r15.getAddMoneyPayOption()
            if (r5 == 0) goto L_0x0174
            net.one97.paytm.nativesdk.common.model.MerchantPayOption r5 = r15.getAddMoneyPayOption()
            if (r5 == 0) goto L_0x0116
            net.one97.paytm.nativesdk.instruments.upipush.model.UpiProfile r5 = r5.getUpiProfile()
            if (r5 == 0) goto L_0x0116
            net.one97.paytm.nativesdk.instruments.upipush.model.ResponseDetails r5 = r5.getRespDetails()
            if (r5 == 0) goto L_0x0116
            net.one97.paytm.nativesdk.instruments.upipush.model.ProfileData r5 = r5.getProfileDetail()
            goto L_0x0117
        L_0x0116:
            r5 = r4
        L_0x0117:
            if (r5 == 0) goto L_0x0139
            net.one97.paytm.nativesdk.common.model.MerchantPayOption r15 = r15.getAddMoneyPayOption()
            if (r15 == 0) goto L_0x0136
            net.one97.paytm.nativesdk.instruments.upipush.model.UpiProfile r15 = r15.getUpiProfile()
            if (r15 == 0) goto L_0x0136
            net.one97.paytm.nativesdk.instruments.upipush.model.ResponseDetails r15 = r15.getRespDetails()
            if (r15 == 0) goto L_0x0136
            net.one97.paytm.nativesdk.instruments.upipush.model.ProfileData r15 = r15.getProfileDetail()
            if (r15 == 0) goto L_0x0136
            java.util.List r15 = r15.getBankAccounts()
            goto L_0x0137
        L_0x0136:
            r15 = r4
        L_0x0137:
            if (r15 != 0) goto L_0x0174
        L_0x0139:
            boolean r15 = net.one97.paytm.nativesdk.Utils.SDKUtility.isUpiPushEnabledOnMerchant()
            if (r15 == 0) goto L_0x0174
            net.one97.paytm.nativesdk.DirectPaymentBL r15 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r1)
            net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r15 = r15.getCjPayMethodResponse()
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r3)
            net.one97.paytm.nativesdk.common.model.Body r15 = r15.getBody()
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r2)
            net.one97.paytm.nativesdk.common.model.MerchantPayOption r15 = r15.getAddMoneyPayOption()
            java.lang.String r2 = "DirectPaymentBL.getInsta…se.body.addMoneyPayOption"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r2)
            net.one97.paytm.nativesdk.common.model.Body r2 = r14.getBody()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r0)
            net.one97.paytm.nativesdk.common.model.MerchantPayOption r0 = r2.getAddMoneyPayOption()
            java.lang.String r2 = "cjPayMethodResponse.body.addMoneyPayOption"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            net.one97.paytm.nativesdk.instruments.upipush.model.UpiProfile r0 = r0.getUpiProfile()
            r15.setUpiProfile(r0)
        L_0x0174:
            net.one97.paytm.nativesdk.common.model.Body r15 = r14.getBody()
            java.lang.String r0 = "|"
            if (r15 == 0) goto L_0x01b1
            net.one97.paytm.nativesdk.common.model.MerchantPayOption r15 = r15.getMerchantPayOption()
            if (r15 == 0) goto L_0x01b1
            net.one97.paytm.nativesdk.instruments.upipush.model.UpiProfile r15 = r15.getUpiProfile()
            if (r15 == 0) goto L_0x01b1
            net.one97.paytm.nativesdk.instruments.upipush.model.ResponseDetails r15 = r15.getRespDetails()
            if (r15 == 0) goto L_0x01b1
            net.one97.paytm.nativesdk.instruments.upipush.model.ProfileData r15 = r15.getProfileDetail()
            if (r15 == 0) goto L_0x01b1
            java.util.List r15 = r15.getBankAccounts()
            if (r15 == 0) goto L_0x01b1
            r5 = r15
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            r6 = r0
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            net.one97.paytm.nativesdk.paymethods.views.fragments.BaseInstrumentSheet$updateUpiProfileData$fetchOptionsRequest$1$onRequestEnd$bnkNames$1 r15 = net.one97.paytm.nativesdk.paymethods.views.fragments.BaseInstrumentSheet$updateUpiProfileData$fetchOptionsRequest$1$onRequestEnd$bnkNames$1.INSTANCE
            r11 = r15
            kotlin.g.a.b r11 = (kotlin.g.a.b) r11
            r12 = 30
            java.lang.String r15 = kotlin.a.k.a((java.lang.Iterable) r5, (java.lang.CharSequence) r6, (java.lang.CharSequence) r7, (java.lang.CharSequence) r8, (int) r9, (java.lang.CharSequence) r10, (kotlin.g.a.b) r11, (int) r12)
            goto L_0x01b2
        L_0x01b1:
            r15 = r4
        L_0x01b2:
            if (r15 != 0) goto L_0x01ee
            net.one97.paytm.nativesdk.common.model.Body r14 = r14.getBody()
            if (r14 == 0) goto L_0x01ed
            net.one97.paytm.nativesdk.common.model.MerchantPayOption r14 = r14.getAddMoneyPayOption()
            if (r14 == 0) goto L_0x01ed
            net.one97.paytm.nativesdk.instruments.upipush.model.UpiProfile r14 = r14.getUpiProfile()
            if (r14 == 0) goto L_0x01ed
            net.one97.paytm.nativesdk.instruments.upipush.model.ResponseDetails r14 = r14.getRespDetails()
            if (r14 == 0) goto L_0x01ed
            net.one97.paytm.nativesdk.instruments.upipush.model.ProfileData r14 = r14.getProfileDetail()
            if (r14 == 0) goto L_0x01ed
            java.util.List r14 = r14.getBankAccounts()
            if (r14 == 0) goto L_0x01ed
            r5 = r14
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            r6 = r0
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            net.one97.paytm.nativesdk.paymethods.views.fragments.BaseInstrumentSheet$updateUpiProfileData$fetchOptionsRequest$1$onRequestEnd$3 r14 = net.one97.paytm.nativesdk.paymethods.views.fragments.BaseInstrumentSheet$updateUpiProfileData$fetchOptionsRequest$1$onRequestEnd$3.INSTANCE
            r11 = r14
            kotlin.g.a.b r11 = (kotlin.g.a.b) r11
            r12 = 30
            java.lang.String r4 = kotlin.a.k.a((java.lang.Iterable) r5, (java.lang.CharSequence) r6, (java.lang.CharSequence) r7, (java.lang.CharSequence) r8, (int) r9, (java.lang.CharSequence) r10, (kotlin.g.a.b) r11, (int) r12)
        L_0x01ed:
            r15 = r4
        L_0x01ee:
            net.one97.paytm.nativesdk.MerchantBL r14 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            java.lang.String r0 = "MerchantBL.getMerchantInstance()"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r0)
            java.lang.String r14 = r14.getMid()
            java.lang.String r0 = "upi_onboarding"
            java.lang.String r2 = "UPI_onboarding_result"
            java.lang.String r3 = "Success"
            java.util.Map r14 = net.one97.paytm.nativesdk.Utils.SDKUtility.getGenericEventUPI(r0, r2, r3, r15, r14)
            net.one97.paytm.nativesdk.Utils.SDKUtility.sendGaEvents(r14)
            net.one97.paytm.nativesdk.paymethods.views.fragments.BaseInstrumentSheet r14 = r13.this$0
            net.one97.paytm.nativesdk.paymethods.views.fragments.BaseInstrumentSheet$CashierInstrumentCom r14 = r14.cashierInstrumentCom
            if (r14 == 0) goto L_0x0226
            net.one97.paytm.nativesdk.DirectPaymentBL r15 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r1)
            java.lang.String r15 = r15.getPaymentFlowAvailable()
            r0 = 1
            java.lang.String r1 = "ADDANDPAY"
            boolean r15 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r15, (boolean) r0)
            r14.loadInstruments(r15)
        L_0x0226:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.paymethods.views.fragments.BaseInstrumentSheet$updateUpiProfileData$fetchOptionsRequest$1.onRequestEnd(net.one97.paytm.nativesdk.common.model.CJPayMethodResponse, net.one97.paytm.nativesdk.instruments.upipush.pojo.VpaFetch):void");
    }
}
