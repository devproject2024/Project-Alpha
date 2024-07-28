package com.paytm.contactsSdk.api.callback;

import com.paytm.contactsSdk.models.EnrichmentData;
import java.util.List;

public interface EnrichedPhoneNumbersCallback {
    void onEnrichedPhoneNumbersReady(List<EnrichmentData> list);
}
