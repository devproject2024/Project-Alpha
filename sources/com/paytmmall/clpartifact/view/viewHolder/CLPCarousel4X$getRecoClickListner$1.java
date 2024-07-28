package com.paytmmall.clpartifact.view.viewHolder;

import android.view.View;
import com.paytmmall.clpartifact.view.actions.RecoRvClick;
import kotlin.g.b.k;

public final class CLPCarousel4X$getRecoClickListner$1 implements RecoRvClick {
    final /* synthetic */ CLPCarousel4X this$0;

    public final void closeClick(int i2) {
    }

    public final void onItemClick(View view, int i2) {
        k.c(view, "itemView");
    }

    CLPCarousel4X$getRecoClickListner$1(CLPCarousel4X cLPCarousel4X) {
        this.this$0 = cLPCarousel4X;
    }

    public final void closeCount(int i2) {
        this.this$0.closeCountText(i2);
    }
}
