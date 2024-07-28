package net.one97.paytm.nativesdk.app;

import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;

public interface VerifyPromoResultListener {
    void onNonPromoError(String str);

    void onVerifyPromoError(String str);

    void onVerifyPromoNetworkError(PaytmSDKRequestClient.ApiResponseError apiResponseError);

    void onVerifyPromoSuccess(CJPayMethodResponse cJPayMethodResponse, boolean z, PaytmSDKRequestClient.VerifyResponseData verifyResponseData);
}
