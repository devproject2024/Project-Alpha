package net.one97.paytm.nativesdk.Utils;

import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.VpaFetch;

public interface FetchPayOptionsListener {
    void onPaymentOptionsError();

    void onPaymentOptionsReceived(CJPayMethodResponse cJPayMethodResponse);

    void onRequestEnd(CJPayMethodResponse cJPayMethodResponse, VpaFetch vpaFetch);

    void onRequestStart();

    @Deprecated
    void onVpaReceived(VpaFetch vpaFetch);
}
