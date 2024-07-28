package com.paytmmall.clpartifact.network;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;

public interface SFCallbackListener {
    public static final int PARSE_ERROR = 1000;

    /* renamed from: com.paytmmall.clpartifact.network.SFCallbackListener$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onFailure(SFCallbackListener sFCallbackListener, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        }
    }

    void onFailure(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError);

    void onSuccess(SanitizedResponseModel sanitizedResponseModel);
}
