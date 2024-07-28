package com.paytmmall.clpartifact.view.fragment;

import androidx.lifecycle.z;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.network.Resource;
import java.util.List;

final class SFHomeFragment$onViewCreated$2<T> implements z<Resource<List<? extends View>>> {
    final /* synthetic */ SFHomeFragment this$0;

    SFHomeFragment$onViewCreated$2(SFHomeFragment sFHomeFragment) {
        this.this$0 = sFHomeFragment;
    }

    public final void onChanged(Resource<List<View>> resource) {
        this.this$0.handleSFResponse(resource);
    }
}
