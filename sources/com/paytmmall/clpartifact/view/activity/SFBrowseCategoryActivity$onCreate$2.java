package com.paytmmall.clpartifact.view.activity;

import androidx.lifecycle.z;
import com.paytmmall.clpartifact.listeners.IGAEnableListener;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.network.Resource;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.g.b.k;

final class SFBrowseCategoryActivity$onCreate$2<T> implements z<Resource<List<? extends View>>> {
    final /* synthetic */ SFBrowseCategoryActivity this$0;

    SFBrowseCategoryActivity$onCreate$2(SFBrowseCategoryActivity sFBrowseCategoryActivity) {
        this.this$0 = sFBrowseCategoryActivity;
    }

    public final void onChanged(Resource<List<View>> resource) {
        if (resource != null) {
            this.this$0.networkRequestType = resource.getRequestType();
            if (resource.getData() != null) {
                List<View> data = resource.getData();
                k.a((Object) data, "response.data");
                IGAEnableListener gaEnableListener = new SanitizedResponseModel(data, new LinkedHashMap(), (String) null, CLPConstants.GTM_SCREEN_NAME_SHOW_MORE, 1008, new SFBrowseCategoryActivity$onCreate$2$$special$$inlined$let$lambda$2(this, resource)).getGaEnableListener();
                if (gaEnableListener != null) {
                    this.this$0.gaHandler.setIgaEnableListener(gaEnableListener);
                }
            }
            this.this$0.handleResponse(resource);
        }
    }
}
