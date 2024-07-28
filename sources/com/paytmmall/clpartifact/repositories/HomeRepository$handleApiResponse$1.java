package com.paytmmall.clpartifact.repositories;

import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.network.RequestType;
import com.paytmmall.clpartifact.utils.HomeUtils;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;

final class HomeRepository$handleApiResponse$1 implements Runnable {
    final /* synthetic */ IJRPaytmDataModel $dataModel;
    final /* synthetic */ boolean $isForceRefresh;
    final /* synthetic */ y $liveData;
    final /* synthetic */ HomeRepository this$0;

    HomeRepository$handleApiResponse$1(HomeRepository homeRepository, IJRPaytmDataModel iJRPaytmDataModel, boolean z, y yVar) {
        this.this$0 = homeRepository;
        this.$dataModel = iJRPaytmDataModel;
        this.$isForceRefresh = z;
        this.$liveData = yVar;
    }

    public final void run() {
        HomeUtils.d("Got Api response from SF, parsing time", true);
        HomeResponse access$getParsedResponse = this.this$0.getParsedResponse(this.$dataModel);
        HomeUtils.d("Parse complete", true);
        RequestType requestType = this.$isForceRefresh ? RequestType.RELOAD : RequestType.REFRESH;
        if (access$getParsedResponse != null) {
            HomeUtils.d$default("Parse Success", false, 2, (Object) null);
            access$getParsedResponse.setDataSource(HomeUtils.INSTANCE.getDATA_SOURCE_NETWORK());
            HomeRepository.updateSuccessLiveData$default(this.this$0, this.$liveData, access$getParsedResponse, requestType, false, 8, (Object) null);
            return;
        }
        HomeUtils.d$default("Parse Error", false, 2, (Object) null);
        HomeRepository homeRepository = this.this$0;
        HomeRepository.updateErrorLiveData$default(homeRepository, this.$liveData, new Throwable(homeRepository.getContext().getString(R.string.home_parse_error)), requestType, false, 8, (Object) null);
    }
}
