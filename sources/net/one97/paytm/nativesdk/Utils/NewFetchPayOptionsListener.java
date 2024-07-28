package net.one97.paytm.nativesdk.Utils;

import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.model.CustomVolleyError;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.VpaFetch;

public interface NewFetchPayOptionsListener extends FetchPayOptionsListener {
    void onPaymentOptionsError(CustomVolleyError customVolleyError);

    void onPaymentOptionsReceived(CJPayMethodResponse cJPayMethodResponse);

    void onRequestEnd(CJPayMethodResponse cJPayMethodResponse, VpaFetch vpaFetch);

    void onRequestStart();

    @Deprecated
    void onVpaReceived(VpaFetch vpaFetch);
}
