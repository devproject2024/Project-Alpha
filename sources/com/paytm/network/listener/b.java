package com.paytm.network.listener;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;

public interface b {
    void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError);

    void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel);
}
