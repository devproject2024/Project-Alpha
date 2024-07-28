package com.paytm.contactsSdk.listener;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;

public interface EnrichmentDataSyncListener {
    void onComplete();

    void onError(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError);
}
