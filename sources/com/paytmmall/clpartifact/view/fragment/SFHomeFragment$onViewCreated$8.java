package com.paytmmall.clpartifact.view.fragment;

import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.widgets.HidingScrollListener;
import kotlin.g.b.k;

public final class SFHomeFragment$onViewCreated$8 extends HidingScrollListener {
    final /* synthetic */ SFHomeFragment this$0;

    SFHomeFragment$onViewCreated$8(SFHomeFragment sFHomeFragment) {
        this.this$0 = sFHomeFragment;
    }

    public final void onHide() {
        this.this$0.setBottomViewHidden(true);
        SFHomeFragment sFHomeFragment = this.this$0;
        FrameLayout frameLayout = SFHomeFragment.access$getViewBinding$p(sFHomeFragment).floatingNavContainer;
        k.a((Object) frameLayout, "viewBinding.floatingNavContainer");
        sFHomeFragment.hideView(frameLayout);
        SFHomeFragment sFHomeFragment2 = this.this$0;
        TextView textView = SFHomeFragment.access$getViewBinding$p(sFHomeFragment2).scanBtn;
        k.a((Object) textView, "viewBinding.scanBtn");
        sFHomeFragment2.hideView(textView);
    }

    public final void onShow() {
        this.this$0.setBottomViewHidden(false);
        SFHomeFragment sFHomeFragment = this.this$0;
        FrameLayout frameLayout = SFHomeFragment.access$getViewBinding$p(sFHomeFragment).floatingNavContainer;
        k.a((Object) frameLayout, "viewBinding.floatingNavContainer");
        sFHomeFragment.showView(frameLayout);
        SFHomeFragment sFHomeFragment2 = this.this$0;
        TextView textView = SFHomeFragment.access$getViewBinding$p(sFHomeFragment2).scanBtn;
        k.a((Object) textView, "viewBinding.scanBtn");
        sFHomeFragment2.showView(textView);
    }

    public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        k.c(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, i2);
        if (!recyclerView.canScrollVertically(1) && i2 == 0 && this.this$0.isTopToBottom) {
            CLPArtifact instance = CLPArtifact.getInstance();
            k.a((Object) instance, "CLPArtifact.getInstance()");
            instance.getCommunicationListener().sendCustomGTMEvents(this.this$0.getContext(), this.this$0.getString(R.string.category_scroll), this.this$0.getString(R.string.action_scroll_up), (String) null, "/", "/", this.this$0.getString(R.string.verticalId));
            this.this$0.isTopToBottom = false;
            this.this$0.isBottomToTop = true;
        }
        if (!recyclerView.canScrollVertically(-1) && i2 == 0 && this.this$0.isBottomToTop) {
            CLPArtifact instance2 = CLPArtifact.getInstance();
            k.a((Object) instance2, "CLPArtifact.getInstance()");
            instance2.getCommunicationListener().sendCustomGTMEvents(this.this$0.getContext(), this.this$0.getString(R.string.category_scroll), this.this$0.getString(R.string.action_scroll_down), (String) null, "/", "/", this.this$0.getString(R.string.verticalId));
            this.this$0.isBottomToTop = false;
            this.this$0.isTopToBottom = true;
        }
    }
}
