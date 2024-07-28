package com.paytmmall.clpartifact.repositories;

import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.network.RequestType;
import com.paytmmall.clpartifact.utils.HomeUtils;

public final class HomeRepository$getHomeResponse$1$networkCallBuilder$1 implements b {
    final /* synthetic */ HomeRepository$getHomeResponse$1 this$0;

    HomeRepository$getHomeResponse$1$networkCallBuilder$1(HomeRepository$getHomeResponse$1 homeRepository$getHomeResponse$1) {
        this.this$0 = homeRepository$getHomeResponse$1;
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        HomeUtils.d("Response recieved", true);
        HomeRepository.handleApiResponse$default(this.this$0.this$0, this.this$0.$liveData, iJRPaytmDataModel, false, 4, (Object) null);
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        HomeUtils.d("API ERROR RECIEVED", true);
        HomeRepository.updateErrorLiveData$default(this.this$0.this$0, this.this$0.$liveData, networkCustomError, RequestType.REFRESH, false, 8, (Object) null);
    }
}
