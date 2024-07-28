package com.paytmmall.clpartifact.widgets.component.smarticongrid.viewmodel;

import androidx.lifecycle.w;
import androidx.lifecycle.z;
import com.appsflyer.internal.referrer.Payload;
import com.paytmmall.clpartifact.network.Resource;
import com.paytmmall.clpartifact.network.Status;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import kotlin.g.b.k;

public final class SFSmartIconFragmentViewModel$loadData$1 implements z<Resource<HomeResponse>> {
    final /* synthetic */ w $liveData;
    final /* synthetic */ SFSmartIconFragmentViewModel this$0;

    SFSmartIconFragmentViewModel$loadData$1(SFSmartIconFragmentViewModel sFSmartIconFragmentViewModel, w wVar) {
        this.this$0 = sFSmartIconFragmentViewModel;
        this.$liveData = wVar;
    }

    public final void onChanged(Resource<HomeResponse> resource) {
        k.c(resource, Payload.RESPONSE);
        if (resource.getStatus() == Status.SUCCESS) {
            this.this$0.handleApiResponse(resource.getData(), this.$liveData);
        }
    }
}
