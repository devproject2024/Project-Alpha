package com.paytmmall.clpartifact.utils;

import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.listeners.IGAEnableListener;
import com.paytmmall.clpartifact.network.SFCallbackListener;

public final class SFUtils$getRefreshableResponse$networkCallBuilder$1 implements b {
    final /* synthetic */ int $clientType;
    final /* synthetic */ IGAEnableListener $gaEnableListener;
    final /* synthetic */ SFCallbackListener $listener;
    final /* synthetic */ String $verticalName;

    SFUtils$getRefreshableResponse$networkCallBuilder$1(SFCallbackListener sFCallbackListener, String str, int i2, IGAEnableListener iGAEnableListener) {
        this.$listener = sFCallbackListener;
        this.$verticalName = str;
        this.$clientType = i2;
        this.$gaEnableListener = iGAEnableListener;
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        SFUtils.INSTANCE.handleApiResponse(iJRPaytmDataModel, this.$listener, this.$verticalName, this.$clientType, this.$gaEnableListener);
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        SFUtils.INSTANCE.handleErrorResponse(i2, iJRPaytmDataModel, networkCustomError, this.$listener);
    }
}
