package net.one97.paytm.nativesdk.paymethods.views.fragments;

import androidx.fragment.app.FragmentActivity;
import kotlin.g.a.a;
import kotlin.g.b.l;
import kotlin.x;

final class OrderSummaryFragment$onViewCreated$1 extends l implements a<x> {
    final /* synthetic */ OrderSummaryFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OrderSummaryFragment$onViewCreated$1(OrderSummaryFragment orderSummaryFragment) {
        super(0);
        this.this$0 = orderSummaryFragment;
    }

    public final void invoke() {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
