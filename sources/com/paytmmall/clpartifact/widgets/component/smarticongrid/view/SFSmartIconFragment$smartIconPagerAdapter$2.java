package com.paytmmall.clpartifact.widgets.component.smarticongrid.view;

import androidx.fragment.app.j;
import com.paytmmall.clpartifact.widgets.component.smarticongrid.view.SFSmartIconFragment;
import kotlin.g.a.a;
import kotlin.g.b.k;
import kotlin.g.b.l;

final class SFSmartIconFragment$smartIconPagerAdapter$2 extends l implements a<SFSmartIconFragment.SmartIconPagerAdapter> {
    final /* synthetic */ SFSmartIconFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SFSmartIconFragment$smartIconPagerAdapter$2(SFSmartIconFragment sFSmartIconFragment) {
        super(0);
        this.this$0 = sFSmartIconFragment;
    }

    public final SFSmartIconFragment.SmartIconPagerAdapter invoke() {
        SFSmartIconFragment sFSmartIconFragment = this.this$0;
        j childFragmentManager = sFSmartIconFragment.getChildFragmentManager();
        k.a((Object) childFragmentManager, "childFragmentManager");
        return new SFSmartIconFragment.SmartIconPagerAdapter(sFSmartIconFragment, childFragmentManager);
    }
}
