package com.paytm.contactsSdk.api.callback;

import com.paytm.contactsSdk.models.EnrichedContactModel;
import java.util.List;

public interface EnrichedContactsCallback {
    void onEnrichedContactsReady(List<EnrichedContactModel> list);
}
