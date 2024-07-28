package net.one97.paytm.nativesdk.transcation;

import easypay.listeners.AssistBuilderCallBack;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.Utils.SDKUtility;

public final class NativePlusPayActivity$initOtpHelper$1 implements AssistBuilderCallBack {
    final /* synthetic */ NativePlusPayActivity this$0;

    NativePlusPayActivity$initOtpHelper$1(NativePlusPayActivity nativePlusPayActivity) {
        this.this$0 = nativePlusPayActivity;
    }

    public final void onBuilderStartFailure(String str, Exception exc) {
        String str2;
        MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
        String mid = merchantInstance.getMid();
        if (this.this$0.paymentInstrument != null) {
            PaymentInstrument access$getPaymentInstrument$p = this.this$0.paymentInstrument;
            str2 = access$getPaymentInstrument$p != null ? access$getPaymentInstrument$p.getMid() : null;
        } else {
            str2 = "";
        }
        SDKUtility.logCrashAndException(getClass().getSimpleName(), "MID from MerchantBL:" + mid + " and mid from payment instrument:" + str2, exc);
    }
}
