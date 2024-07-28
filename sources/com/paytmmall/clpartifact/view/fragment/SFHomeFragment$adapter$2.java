package com.paytmmall.clpartifact.view.fragment;

import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.view.adapter.SFHomeAdapter;
import kotlin.g.a.a;
import kotlin.g.b.l;

final class SFHomeFragment$adapter$2 extends l implements a<SFHomeAdapter> {
    final /* synthetic */ SFHomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SFHomeFragment$adapter$2(SFHomeFragment sFHomeFragment) {
        super(0);
        this.this$0 = sFHomeFragment;
    }

    public final SFHomeAdapter invoke() {
        return new SFHomeAdapter((IGAHandlerListener) null, this.this$0.getCustomActionModel());
    }
}
