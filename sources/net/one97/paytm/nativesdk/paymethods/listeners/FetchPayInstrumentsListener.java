package net.one97.paytm.nativesdk.paymethods.listeners;

import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;

public interface FetchPayInstrumentsListener {
    void onResponseReceived(CJPayMethodResponse cJPayMethodResponse);
}
