package net.one97.paytm.nativesdk.transactionsummary;

import android.view.View;

final class TxnSummaryActivity$initUI$5 implements View.OnClickListener {
    final /* synthetic */ TxnSummaryActivity this$0;

    TxnSummaryActivity$initUI$5(TxnSummaryActivity txnSummaryActivity) {
        this.this$0 = txnSummaryActivity;
    }

    public final void onClick(View view) {
        this.this$0.onBackPressed();
        this.this$0.closeSdk();
    }
}
