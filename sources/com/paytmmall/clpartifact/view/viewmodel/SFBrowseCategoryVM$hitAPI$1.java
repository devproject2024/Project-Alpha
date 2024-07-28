package com.paytmmall.clpartifact.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.w;
import androidx.lifecycle.z;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.network.Resource;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;

final class SFBrowseCategoryVM$hitAPI$1<T> implements z<S> {
    final /* synthetic */ SFBrowseCategoryVM this$0;

    SFBrowseCategoryVM$hitAPI$1(SFBrowseCategoryVM sFBrowseCategoryVM) {
        this.this$0 = sFBrowseCategoryVM;
    }

    public final void onChanged(Resource<HomeResponse> resource) {
        SFBrowseCategoryVM sFBrowseCategoryVM = this.this$0;
        LiveData<Resource<List<View>>> responseLiveData = sFBrowseCategoryVM.getResponseLiveData();
        if (responseLiveData != null) {
            k.a((Object) resource, "it");
            sFBrowseCategoryVM.handleResponse((w) responseLiveData, resource);
            return;
        }
        throw new u("null cannot be cast to non-null type androidx.lifecycle.MediatorLiveData<com.paytmmall.clpartifact.network.Resource<kotlin.collections.List<com.paytmmall.clpartifact.modal.clpCommon.View>>>");
    }
}
