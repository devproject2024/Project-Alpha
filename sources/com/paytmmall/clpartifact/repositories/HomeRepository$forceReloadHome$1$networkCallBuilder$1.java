package com.paytmmall.clpartifact.repositories;

import android.os.Build;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.network.RequestType;
import com.paytmmall.clpartifact.utils.HomeUtils;

public final class HomeRepository$forceReloadHome$1$networkCallBuilder$1 implements b {
    final /* synthetic */ HomeRepository$forceReloadHome$1 this$0;

    HomeRepository$forceReloadHome$1$networkCallBuilder$1(HomeRepository$forceReloadHome$1 homeRepository$forceReloadHome$1) {
        this.this$0 = homeRepository$forceReloadHome$1;
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        HomeUtils.d("Response recieved", true);
        if (Build.VERSION.SDK_INT >= 21) {
            this.this$0.this$0.handleApiResponse(this.this$0.$liveData, iJRPaytmDataModel, true);
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        HomeUtils.d("API ERROR RECIEVED", true);
        HomeRepository.updateErrorLiveData$default(this.this$0.this$0, this.this$0.$liveData, networkCustomError, RequestType.REFRESH, false, 8, (Object) null);
    }
}
