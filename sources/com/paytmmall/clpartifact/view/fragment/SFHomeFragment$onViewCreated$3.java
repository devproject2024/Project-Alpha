package com.paytmmall.clpartifact.view.fragment;

import androidx.lifecycle.z;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;

final class SFHomeFragment$onViewCreated$3<T> implements z<SanitizedResponseModel> {
    final /* synthetic */ SFHomeFragment this$0;

    SFHomeFragment$onViewCreated$3(SFHomeFragment sFHomeFragment) {
        this.this$0 = sFHomeFragment;
    }

    public final void onChanged(SanitizedResponseModel sanitizedResponseModel) {
        if (sanitizedResponseModel != null) {
            this.this$0.homeGAListener = sanitizedResponseModel.getGaListener();
            this.this$0.getAdapter().setGaListener(this.this$0.homeGAListener);
            this.this$0.getAdapter().setCustomAction(this.this$0.getCustomActionModel());
        }
    }
}
