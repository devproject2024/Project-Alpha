package com.paytmmall.clpartifact.view.activity;

import android.view.View;
import com.paytmmall.clpartifact.view.actions.RecoRvClick;
import kotlin.g.b.k;

public final class RecoExpandActivity$setRecoRV$clickListener$1 implements RecoRvClick {
    final /* synthetic */ RecoExpandActivity this$0;

    public final void onItemClick(View view, int i2) {
        k.c(view, "itemView");
    }

    RecoExpandActivity$setRecoRV$clickListener$1(RecoExpandActivity recoExpandActivity) {
        this.this$0 = recoExpandActivity;
    }

    public final void closeClick(int i2) {
        if (RecoExpandActivity.access$getFilteredList$p(this.this$0).size() == 1) {
            this.this$0.goBack();
        }
    }

    public final void closeCount(int i2) {
        if (i2 == this.this$0.CLICKED_OUTSIDE) {
            this.this$0.goBack();
        }
    }
}
