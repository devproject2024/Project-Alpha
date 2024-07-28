package net.one97.paytm.nativesdk.transactionsummary;

import androidx.lifecycle.z;
import kotlin.g.b.k;

final class TxnSummaryActivity$registerObserver$1<T> implements z<Boolean> {
    final /* synthetic */ TxnSummaryActivity this$0;

    TxnSummaryActivity$registerObserver$1(TxnSummaryActivity txnSummaryActivity) {
        this.this$0 = txnSummaryActivity;
    }

    public final void onChanged(Boolean bool) {
        if (k.a((Object) bool, (Object) Boolean.TRUE)) {
            this.this$0.showShimmer();
        } else if (k.a((Object) bool, (Object) Boolean.FALSE)) {
            this.this$0.hideShimmer();
        }
    }
}
