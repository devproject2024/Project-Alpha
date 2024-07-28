package com.paytmmall.clpartifact.repositories;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytmmall.clpartifact.network.RequestType;
import com.paytmmall.clpartifact.utils.HomeUtils;

final class ShowMoreRepository$hitApi$networkCallBuilder$1$onApiSuccess$1 implements Runnable {
    final /* synthetic */ IJRPaytmDataModel $response;
    final /* synthetic */ ShowMoreRepository$hitApi$networkCallBuilder$1 this$0;

    ShowMoreRepository$hitApi$networkCallBuilder$1$onApiSuccess$1(ShowMoreRepository$hitApi$networkCallBuilder$1 showMoreRepository$hitApi$networkCallBuilder$1, IJRPaytmDataModel iJRPaytmDataModel) {
        this.this$0 = showMoreRepository$hitApi$networkCallBuilder$1;
        this.$response = iJRPaytmDataModel;
    }

    public final void run() {
        this.this$0.this$0.handleSucessResponse(this.this$0.$liveData, HomeUtils.INSTANCE.getParsedResponse(this.$response), RequestType.REFRESH);
    }
}
