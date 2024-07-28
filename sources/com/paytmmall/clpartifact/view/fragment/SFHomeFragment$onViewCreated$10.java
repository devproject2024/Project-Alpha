package com.paytmmall.clpartifact.view.fragment;

import android.widget.FrameLayout;
import androidx.lifecycle.z;
import com.paytmmall.clpartifact.widgets.blueprints.IWidgetProvider;
import kotlin.g.b.k;

public final class SFHomeFragment$onViewCreated$10 implements z<IWidgetProvider> {
    final /* synthetic */ SFHomeFragment this$0;

    SFHomeFragment$onViewCreated$10(SFHomeFragment sFHomeFragment) {
        this.this$0 = sFHomeFragment;
    }

    public final void onChanged(IWidgetProvider iWidgetProvider) {
        if (iWidgetProvider != null) {
            SFHomeFragment sFHomeFragment = this.this$0;
            FrameLayout frameLayout = SFHomeFragment.access$getViewBinding$p(sFHomeFragment).floatingNavContainer;
            k.a((Object) frameLayout, "viewBinding.floatingNavContainer");
            sFHomeFragment.updateBottomNav(frameLayout, iWidgetProvider);
            SFHomeFragment sFHomeFragment2 = this.this$0;
            FrameLayout frameLayout2 = SFHomeFragment.access$getViewBinding$p(sFHomeFragment2).floatingNavContainer;
            k.a((Object) frameLayout2, "viewBinding.floatingNavContainer");
            sFHomeFragment2.showBottomNav(frameLayout2);
        }
    }
}
