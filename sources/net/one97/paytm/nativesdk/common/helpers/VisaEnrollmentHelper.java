package net.one97.paytm.nativesdk.common.helpers;

import android.content.Context;
import android.view.View;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.Utils.CardData;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtils;
import net.one97.paytm.nativesdk.common.Requester.TransactionProcessor;
import net.one97.paytm.nativesdk.common.listeners.EnrollmentData;
import net.one97.paytm.nativesdk.common.listeners.EnrollmentListener;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickLoadingSheet;
import net.one97.paytm.nativesdk.transcation.PaymentInstrument;
import net.one97.paytm.payments.visascp.VisaSCP;

public final class VisaEnrollmentHelper {
    public static final Companion Companion = new Companion((g) null);
    public static final String TAG = "VisaEnrollmentHelper";
    private CardData cardDetails;
    private final Context context;
    /* access modifiers changed from: private */
    public EnrollmentData data;
    private EnrollmentListener enrollmentListener;
    /* access modifiers changed from: private */
    public EnrollmentData primaryEnrollmentData;

    public VisaEnrollmentHelper() {
        Context appContext = PaytmSDK.getAppContext();
        k.a((Object) appContext, "PaytmSDK.getAppContext()");
        this.context = appContext;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public final void createOnClickInfoObject(CardData cardData) {
        k.c(cardData, "cardData");
        try {
            VisaSCP visaSDK = SDKUtils.getVisaSDK(this.context);
            String firstSixDigit = cardData.getFirstSixDigit();
            String lastFourDigit = cardData.getLastFourDigit();
            String expiryDate = cardData.getExpiryDate();
            DirectPaymentBL instance = DirectPaymentBL.getInstance();
            k.a((Object) instance, "DirectPaymentBL.getInstance()");
            visaSDK.createOneClickInfoObject(firstSixDigit, lastFourDigit, expiryDate, instance.getCustomerId());
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005b, code lost:
        if (r1.getLastFourDigit().equals(r25.getLastFourDigit()) == false) goto L_0x005d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final net.one97.paytm.nativesdk.common.listeners.EnrollmentData isVisaCardEnrolled(android.content.Context r24, net.one97.paytm.nativesdk.Utils.CardData r25, java.lang.String r26, net.one97.paytm.nativesdk.common.listeners.EnrollmentListener r27, double r28, java.lang.String r30) {
        /*
            r23 = this;
            r7 = r23
            r8 = r25
            r0 = r26
            r9 = r27
            r10 = r28
            java.lang.String r1 = "context"
            r2 = r24
            kotlin.g.b.k.c(r2, r1)
            java.lang.String r1 = "cardDetails"
            kotlin.g.b.k.c(r8, r1)
            java.lang.String r1 = "cardType"
            kotlin.g.b.k.c(r0, r1)
            java.lang.String r1 = "enrollmentListener"
            kotlin.g.b.k.c(r9, r1)
            java.lang.String r1 = "paymode"
            r3 = r30
            kotlin.g.b.k.c(r3, r1)
            net.one97.paytm.nativesdk.common.listeners.EnrollmentData r1 = r7.data
            java.lang.String r12 = "DirectPaymentBL.getInstance()"
            if (r1 != 0) goto L_0x0031
            net.one97.paytm.nativesdk.common.listeners.EnrollmentListener r1 = r7.enrollmentListener
            if (r1 == 0) goto L_0x005d
        L_0x0031:
            net.one97.paytm.nativesdk.Utils.CardData r1 = r7.cardDetails
            if (r1 == 0) goto L_0x005d
            if (r1 != 0) goto L_0x003a
            kotlin.g.b.k.a()
        L_0x003a:
            java.lang.String r1 = r1.getFirstSixDigit()
            java.lang.String r4 = r25.getFirstSixDigit()
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x005d
            net.one97.paytm.nativesdk.Utils.CardData r1 = r7.cardDetails
            if (r1 != 0) goto L_0x004f
            kotlin.g.b.k.a()
        L_0x004f:
            java.lang.String r1 = r1.getLastFourDigit()
            java.lang.String r4 = r25.getLastFourDigit()
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x00b9
        L_0x005d:
            java.lang.Double r1 = java.lang.Double.valueOf(r28)
            r8.setAmount(r1)
            java.lang.String r1 = "Enrollment_option_disp"
            java.lang.String r4 = "ENROLLMENT"
            java.util.Map r0 = net.one97.paytm.nativesdk.Utils.SDKUtility.getVisaEventParams(r1, r4, r0)
            net.one97.paytm.nativesdk.Utils.SDKUtility.sendGaEvents(r0)
            r7.cardDetails = r8
            r7.enrollmentListener = r9
            net.one97.paytm.payments.visascp.VisaSCP r13 = net.one97.paytm.nativesdk.Utils.SDKUtils.getVisaSDK(r24)
            java.lang.String r14 = r25.getFirstSixDigit()
            java.lang.String r15 = r25.getLastFourDigit()
            java.lang.String r16 = r25.getExpiryDate()
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r12)
            java.lang.String r17 = r0.getCustomerId()
            net.one97.paytm.nativesdk.MerchantBL r0 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            java.lang.String r1 = "MerchantBL.getMerchantInstance()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r18 = r0.getSsoToken()
            r20 = 0
            r21 = 0
            net.one97.paytm.nativesdk.common.helpers.VisaEnrollmentHelper$isVisaCardEnrolled$1 r19 = new net.one97.paytm.nativesdk.common.helpers.VisaEnrollmentHelper$isVisaCardEnrolled$1
            r0 = r19
            r1 = r23
            r2 = r30
            r3 = r28
            r5 = r25
            r6 = r27
            r0.<init>(r1, r2, r3, r5, r6)
            r22 = r19
            net.one97.paytm.payments.visascp.VisaSCPImpl$IsEnrolledListener r22 = (net.one97.paytm.payments.visascp.VisaSCPImpl.IsEnrolledListener) r22
            java.lang.String r19 = "SSO"
            r13.isEnrolled(r14, r15, r16, r17, r18, r19, r20, r21, r22)
        L_0x00b9:
            net.one97.paytm.nativesdk.common.listeners.EnrollmentData r0 = r7.data
            if (r0 == 0) goto L_0x0145
            net.one97.paytm.nativesdk.Utils.CardData r0 = r7.cardDetails
            if (r0 == 0) goto L_0x00c6
            java.lang.Double r0 = r0.getAmount()
            goto L_0x00c7
        L_0x00c6:
            r0 = 0
        L_0x00c7:
            boolean r0 = kotlin.g.b.k.a((double) r10, (java.lang.Double) r0)
            if (r0 == 0) goto L_0x00d8
            net.one97.paytm.nativesdk.common.listeners.EnrollmentData r0 = r7.data
            if (r0 != 0) goto L_0x00d4
            kotlin.g.b.k.a()
        L_0x00d4:
            r9.isEnrolled(r0)
            goto L_0x0145
        L_0x00d8:
            net.one97.paytm.nativesdk.Utils.CardData r0 = r7.cardDetails
            if (r0 == 0) goto L_0x00e3
            java.lang.Double r1 = java.lang.Double.valueOf(r28)
            r0.setAmount(r1)
        L_0x00e3:
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r12)
            net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r0 = r0.getCjPayMethodResponse()
            java.lang.String r1 = "DirectPaymentBL.getInstance().cjPayMethodResponse"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.nativesdk.common.model.Body r0 = r0.getBody()
            java.lang.String r1 = "DirectPaymentBL.getInsta….cjPayMethodResponse.body"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r0 = r0.getOneClickMaxAmount()
            double r0 = net.one97.paytm.nativesdk.Utils.SDKUtility.parseDouble(r0)
            net.one97.paytm.nativesdk.common.listeners.EnrollmentData r2 = r7.primaryEnrollmentData
            if (r2 == 0) goto L_0x011c
            boolean r2 = r2.isEnrolled()
            r3 = 1
            if (r2 != r3) goto L_0x011c
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x011c
            net.one97.paytm.nativesdk.common.listeners.EnrollmentData r0 = new net.one97.paytm.nativesdk.common.listeners.EnrollmentData
            r1 = 0
            r0.<init>(r1, r1, r8)
            r7.data = r0
            goto L_0x013b
        L_0x011c:
            net.one97.paytm.nativesdk.common.listeners.EnrollmentData r0 = r7.primaryEnrollmentData
            if (r0 == 0) goto L_0x013b
            net.one97.paytm.nativesdk.common.listeners.EnrollmentData r1 = new net.one97.paytm.nativesdk.common.listeners.EnrollmentData
            if (r0 != 0) goto L_0x0127
            kotlin.g.b.k.a()
        L_0x0127:
            boolean r0 = r0.isEnrolled()
            net.one97.paytm.nativesdk.common.listeners.EnrollmentData r2 = r7.primaryEnrollmentData
            if (r2 != 0) goto L_0x0132
            kotlin.g.b.k.a()
        L_0x0132:
            boolean r2 = r2.isEligible()
            r1.<init>(r0, r2, r8)
            r7.data = r1
        L_0x013b:
            net.one97.paytm.nativesdk.common.listeners.EnrollmentData r0 = r7.data
            if (r0 != 0) goto L_0x0142
            kotlin.g.b.k.a()
        L_0x0142:
            r9.isEnrolled(r0)
        L_0x0145:
            net.one97.paytm.nativesdk.common.listeners.EnrollmentData r0 = r7.data
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.common.helpers.VisaEnrollmentHelper.isVisaCardEnrolled(android.content.Context, net.one97.paytm.nativesdk.Utils.CardData, java.lang.String, net.one97.paytm.nativesdk.common.listeners.EnrollmentListener, double, java.lang.String):net.one97.paytm.nativesdk.common.listeners.EnrollmentData");
    }

    public final void proceedForTranscation(Context context2, TransactionProcessor transactionProcessor, PaymentInstrument paymentInstrument, View view, String str) {
        OneClickLoadingSheet oneClickLoadingSheet;
        k.c(context2, "context");
        k.c(transactionProcessor, "txnProcessor");
        k.c(paymentInstrument, "paymentInstrument");
        k.c(str, "channelCode");
        if (view == null) {
            if (p.a(SDKConstants.VISA, str, true)) {
                oneClickLoadingSheet = OneClickLoadingSheet.Companion.getInstance(SDKUtility.getCardImage(SDKConstants.VISA_NEW));
            } else {
                oneClickLoadingSheet = OneClickLoadingSheet.Companion.getInstance(SDKUtility.getCardImage(str));
            }
            oneClickLoadingSheet.show(context2);
            transactionProcessor.setTranscationListener(oneClickLoadingSheet);
        }
        transactionProcessor.startTransaction(view);
    }
}
