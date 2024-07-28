package com.paytmmall.clpartifact.view.viewmodel;

import androidx.lifecycle.z;
import com.paytmmall.clpartifact.network.Resource;

final class SFHomeVM$refreshHome$1<T> implements z<S> {
    final /* synthetic */ SFHomeVM this$0;

    SFHomeVM$refreshHome$1(SFHomeVM sFHomeVM) {
        this.this$0 = sFHomeVM;
    }

    public final void onChanged(Resource<HomeResponse> resource) {
        this.this$0.isHomeLoading = false;
        SFHomeVM sFHomeVM = this.this$0;
        sFHomeVM.handleResponse(sFHomeVM.getResponseLiveData(), resource);
    }
}
