package com.paytmmall.clpartifact.view.viewHolder;

import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.view.actions.RecoRvClick;
import kotlin.g.b.k;

public final class SmartIconHeaderV2RootVH$setRecoRV$clickListener$1 implements RecoRvClick {
    final /* synthetic */ View $view;
    final /* synthetic */ SmartIconHeaderV2RootVH this$0;

    public final void closeClick(int i2) {
    }

    SmartIconHeaderV2RootVH$setRecoRV$clickListener$1(SmartIconHeaderV2RootVH smartIconHeaderV2RootVH, View view) {
        this.this$0 = smartIconHeaderV2RootVH;
        this.$view = view;
    }

    public final void onItemClick(android.view.View view, int i2) {
        k.c(view, "itemView");
        this.this$0.itemClick(view, this.$view);
    }

    public final void closeCount(int i2) {
        this.this$0.closeCountText();
    }
}
