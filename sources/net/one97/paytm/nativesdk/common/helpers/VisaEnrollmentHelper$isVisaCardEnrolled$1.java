package net.one97.paytm.nativesdk.common.helpers;

import kotlin.g.b.k;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.Utils.CardData;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.listeners.EnrollmentData;
import net.one97.paytm.nativesdk.common.listeners.EnrollmentListener;
import net.one97.paytm.nativesdk.common.model.Body;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.payments.visascp.VisaSCPImpl;

public final class VisaEnrollmentHelper$isVisaCardEnrolled$1 implements VisaSCPImpl.IsEnrolledListener {
    final /* synthetic */ CardData $cardDetails;
    final /* synthetic */ EnrollmentListener $enrollmentListener;
    final /* synthetic */ double $orderAmount;
    final /* synthetic */ String $paymode;
    final /* synthetic */ VisaEnrollmentHelper this$0;

    public final void onRequestStart() {
    }

    VisaEnrollmentHelper$isVisaCardEnrolled$1(VisaEnrollmentHelper visaEnrollmentHelper, String str, double d2, CardData cardData, EnrollmentListener enrollmentListener) {
        this.this$0 = visaEnrollmentHelper;
        this.$paymode = str;
        this.$orderAmount = d2;
        this.$cardDetails = cardData;
        this.$enrollmentListener = enrollmentListener;
    }

    public final void onRequestEnd(boolean z, boolean z2, String str) {
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        if (!instance.isTransactionProcessing()) {
            DirectPaymentBL instance2 = DirectPaymentBL.getInstance();
            k.a((Object) instance2, "DirectPaymentBL.getInstance()");
            if (instance2.getCjPayMethodResponse() != null) {
                DirectPaymentBL instance3 = DirectPaymentBL.getInstance();
                k.a((Object) instance3, "DirectPaymentBL.getInstance()");
                CJPayMethodResponse cjPayMethodResponse = instance3.getCjPayMethodResponse();
                k.a((Object) cjPayMethodResponse, "DirectPaymentBL.getInstance().cjPayMethodResponse");
                if (cjPayMethodResponse.getBody() != null) {
                    DirectPaymentBL instance4 = DirectPaymentBL.getInstance();
                    k.a((Object) instance4, "DirectPaymentBL.getInstance()");
                    CJPayMethodResponse cjPayMethodResponse2 = instance4.getCjPayMethodResponse();
                    k.a((Object) cjPayMethodResponse2, "DirectPaymentBL.getInstance().cjPayMethodResponse");
                    Body body = cjPayMethodResponse2.getBody();
                    k.a((Object) body, "DirectPaymentBL.getInsta….cjPayMethodResponse.body");
                    double parseDouble = SDKUtility.parseDouble(body.getOneClickMaxAmount());
                    double amountWithRiskFee = DirectPaymentBL.getInstance().getAmountWithRiskFee(this.$paymode, this.$orderAmount);
                    this.this$0.primaryEnrollmentData = new EnrollmentData(z, z2, this.$cardDetails);
                    if (!z || amountWithRiskFee <= parseDouble) {
                        this.this$0.data = new EnrollmentData(z, z2, this.$cardDetails);
                    } else {
                        this.this$0.data = new EnrollmentData(false, false, this.$cardDetails);
                    }
                    EnrollmentListener enrollmentListener = this.$enrollmentListener;
                    if (enrollmentListener != null) {
                        EnrollmentData access$getData$p = this.this$0.data;
                        if (access$getData$p == null) {
                            k.a();
                        }
                        enrollmentListener.isEnrolled(access$getData$p);
                    }
                }
            }
        }
    }

    public final void onRequestError(String str, String str2) {
        onRequestEnd(false, false, (String) null);
    }
}
