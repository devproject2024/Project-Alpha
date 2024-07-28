package net.one97.paytm.nativesdk.app;

import java.util.ArrayList;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;

public interface VerifyPromoCallbackListener {
    void clearPromoCode(String str, PaytmSDKRequestClient.ApplyAnotherOfferListener applyAnotherOfferListener);

    void onPaymentIntentSelected(String str, ArrayList<PaymentIntent> arrayList, @Deprecated String str2, VerifyPromoResultListener verifyPromoResultListener);

    void onPromoSelected(String str, int i2, String str2, VerifyPromoResultListener verifyPromoResultListener);
}
