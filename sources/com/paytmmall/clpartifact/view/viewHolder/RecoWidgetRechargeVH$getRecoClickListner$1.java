package com.paytmmall.clpartifact.view.viewHolder;

import android.view.View;
import com.paytmmall.clpartifact.view.actions.RecoRvClick;
import kotlin.g.b.k;

public final class RecoWidgetRechargeVH$getRecoClickListner$1 implements RecoRvClick {
    final /* synthetic */ RecoWidgetRechargeVH this$0;

    RecoWidgetRechargeVH$getRecoClickListner$1(RecoWidgetRechargeVH recoWidgetRechargeVH) {
        this.this$0 = recoWidgetRechargeVH;
    }

    public final void onItemClick(View view, int i2) {
        k.c(view, "itemView");
        this.this$0.onRecoItemClick(view, i2);
    }

    public final void closeClick(int i2) {
        this.this$0.onItemClosed(i2);
    }

    public final void closeCount(int i2) {
        this.this$0.closeCountHandle(i2);
    }
}
