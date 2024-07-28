package net.one97.paytm.nativesdk.transactionsummary;

import android.view.View;
import android.widget.TextView;
import net.one97.paytm.nativesdk.R;

final class TxnSummaryActivity$initUI$2 implements View.OnClickListener {
    final /* synthetic */ TxnSummaryActivity this$0;

    TxnSummaryActivity$initUI$2(TxnSummaryActivity txnSummaryActivity) {
        this.this$0 = txnSummaryActivity;
    }

    public final void onClick(View view) {
        ((TextView) this.this$0._$_findCachedViewById(R.id.tv_view_passbook_title_asps)).performClick();
    }
}
