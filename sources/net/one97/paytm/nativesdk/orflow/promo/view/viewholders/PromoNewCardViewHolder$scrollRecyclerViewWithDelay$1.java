package net.one97.paytm.nativesdk.orflow.promo.view.viewholders;

import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;

final class PromoNewCardViewHolder$scrollRecyclerViewWithDelay$1 implements Runnable {
    final /* synthetic */ int $px;
    final /* synthetic */ PromoNewCardViewHolder this$0;

    PromoNewCardViewHolder$scrollRecyclerViewWithDelay$1(PromoNewCardViewHolder promoNewCardViewHolder, int i2) {
        this.this$0 = promoNewCardViewHolder;
        this.$px = i2;
    }

    public final void run() {
        ViewParent parent = this.this$0.getMView().getParent();
        if (!(parent instanceof RecyclerView)) {
            parent = null;
        }
        RecyclerView recyclerView = (RecyclerView) parent;
        if (recyclerView != null) {
            recyclerView.smoothScrollBy(0, this.$px);
        }
    }
}
