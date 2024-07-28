package net.one97.paytm.nativesdk.orflow.promo.view;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.orflow.Utility;

final class PromoPayOptionsBottomSheet$scrollRecyclerViewWithDelay$1 implements Runnable {
    final /* synthetic */ PromoPayOptionsBottomSheet this$0;

    PromoPayOptionsBottomSheet$scrollRecyclerViewWithDelay$1(PromoPayOptionsBottomSheet promoPayOptionsBottomSheet) {
        this.this$0 = promoPayOptionsBottomSheet;
    }

    public final void run() {
        RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(R.id.rv_promo_pay_options);
        if (recyclerView != null) {
            Utility utility = Utility.INSTANCE;
            FragmentActivity activity = this.this$0.getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            recyclerView.smoothScrollBy(0, 60 * ((int) utility.getDensity(activity)));
        }
    }
}
