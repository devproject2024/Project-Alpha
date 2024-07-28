package com.paytmmall.clpartifact.widgets.component.smarticongrid;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytmmall.clpartifact.network.Resource;
import com.paytmmall.clpartifact.network.Status;
import com.paytmmall.clpartifact.utils.CategoryImpressionAndApiHandler;
import com.paytmmall.clpartifact.utils.HomeUtils;

final class SmartIconGridRepository$callCategoryAPI$request$1$onApiSuccess$1 implements Runnable {
    final /* synthetic */ IJRPaytmDataModel $dataModel;
    final /* synthetic */ SmartIconGridRepository$callCategoryAPI$request$1 this$0;

    SmartIconGridRepository$callCategoryAPI$request$1$onApiSuccess$1(SmartIconGridRepository$callCategoryAPI$request$1 smartIconGridRepository$callCategoryAPI$request$1, IJRPaytmDataModel iJRPaytmDataModel) {
        this.this$0 = smartIconGridRepository$callCategoryAPI$request$1;
        this.$dataModel = iJRPaytmDataModel;
    }

    public final void run() {
        CategoryImpressionAndApiHandler.INSTANCE.setFirstApiCallFromCategoryPopup(false);
        this.this$0.$liveData.postValue(new Resource.Builder().body(HomeUtils.INSTANCE.getParsedResponse(this.$dataModel)).status(Status.SUCCESS).build());
    }
}
