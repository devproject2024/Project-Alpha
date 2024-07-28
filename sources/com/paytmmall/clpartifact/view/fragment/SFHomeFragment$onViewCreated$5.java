package com.paytmmall.clpartifact.view.fragment;

import androidx.lifecycle.z;
import com.paytmmall.clpartifact.view.actionmodel.IActionModel;
import kotlin.g.b.k;

final class SFHomeFragment$onViewCreated$5<T> implements z<IActionModel> {
    final /* synthetic */ SFHomeFragment this$0;

    SFHomeFragment$onViewCreated$5(SFHomeFragment sFHomeFragment) {
        this.this$0 = sFHomeFragment;
    }

    public final void onChanged(IActionModel iActionModel) {
        SFHomeFragment sFHomeFragment = this.this$0;
        k.a((Object) iActionModel, "it");
        sFHomeFragment.handleModelAction(iActionModel);
    }
}
