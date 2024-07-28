package com.paytmmall.clpartifact.view.fragment;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.listeners.IHomeTraceListener;
import com.paytmmall.clpartifact.utils.RVLayoutListener;
import kotlin.g.b.k;

public final class BaseTracingFragment$getLayoutListener$1 extends RVLayoutListener {
    final /* synthetic */ RecyclerView $recyclerView;
    final /* synthetic */ BaseTracingFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseTracingFragment$getLayoutListener$1(BaseTracingFragment baseTracingFragment, RecyclerView recyclerView, RecyclerView recyclerView2) {
        super(recyclerView2);
        this.this$0 = baseTracingFragment;
        this.$recyclerView = recyclerView;
    }

    public final void runHomeSettle() {
        this.this$0.runHomeSettle();
    }

    public final void stopRenderingTrace() {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            IHomeTraceListener homeListener = this.this$0.getHomeListener();
            if (homeListener != null) {
                homeListener.stopAppClickToHomeRenderingTrace();
            }
            IHomeTraceListener homeListener2 = this.this$0.getHomeListener();
            if (homeListener2 != null) {
                k.a((Object) activity, "this");
                homeListener2.logAppStartTimeHawkeye(activity);
            }
        }
    }
}
