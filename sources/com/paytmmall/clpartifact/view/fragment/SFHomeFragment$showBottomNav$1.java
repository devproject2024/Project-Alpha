package com.paytmmall.clpartifact.view.fragment;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.g.b.k;

final class SFHomeFragment$showBottomNav$1 implements Runnable {
    final /* synthetic */ ViewGroup $floatingNavContainer;
    final /* synthetic */ SFHomeFragment this$0;

    SFHomeFragment$showBottomNav$1(SFHomeFragment sFHomeFragment, ViewGroup viewGroup) {
        this.this$0 = sFHomeFragment;
        this.$floatingNavContainer = viewGroup;
    }

    public final void run() {
        if (this.$floatingNavContainer.getChildCount() > 0 && this.$floatingNavContainer.getVisibility() == 4 && !this.this$0.getBottomViewHidden()) {
            FrameLayout frameLayout = SFHomeFragment.access$getViewBinding$p(this.this$0).floatingNavContainer;
            k.a((Object) frameLayout, "viewBinding.floatingNavContainer");
            frameLayout.setVisibility(0);
        }
    }
}
