package com.paytmmall.clpartifact.view.fragment;

import androidx.lifecycle.z;
import com.paytmmall.clpartifact.view.actionmodel.HomeParentActionModel;
import kotlin.g.b.k;

final class SFHomeFragment$onViewCreated$4<T> implements z<HomeParentActionModel> {
    final /* synthetic */ SFHomeFragment this$0;

    SFHomeFragment$onViewCreated$4(SFHomeFragment sFHomeFragment) {
        this.this$0 = sFHomeFragment;
    }

    public final void onChanged(HomeParentActionModel homeParentActionModel) {
        SFHomeFragment sFHomeFragment = this.this$0;
        k.a((Object) homeParentActionModel, "it");
        sFHomeFragment.handleAction(homeParentActionModel);
    }
}
