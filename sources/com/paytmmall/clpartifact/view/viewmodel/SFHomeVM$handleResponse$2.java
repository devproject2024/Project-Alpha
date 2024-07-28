package com.paytmmall.clpartifact.view.viewmodel;

import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.network.RequestType;
import com.paytmmall.clpartifact.network.Resource;
import kotlin.g.b.k;

final class SFHomeVM$handleResponse$2 implements Runnable {
    final /* synthetic */ Resource $homeResponse;
    final /* synthetic */ SanitizedResponseModel $sanitizedResponse;
    final /* synthetic */ SFHomeVM this$0;

    SFHomeVM$handleResponse$2(SFHomeVM sFHomeVM, SanitizedResponseModel sanitizedResponseModel, Resource resource) {
        this.this$0 = sFHomeVM;
        this.$sanitizedResponse = sanitizedResponseModel;
        this.$homeResponse = resource;
    }

    public final void run() {
        this.this$0.handleOtherWidget(this.this$0.handleNonRVWidgets(this.$sanitizedResponse.getSfWidgets(), this.$homeResponse.getRequestType() == RequestType.REFRESH));
        SFHomeVM sFHomeVM = this.this$0;
        Object data = this.$homeResponse.getData();
        k.a(data, "homeResponse.data");
        sFHomeVM.updateCategoryUrl(sFHomeVM.getCategoryUpdateModel((HomeResponse) data));
    }
}
