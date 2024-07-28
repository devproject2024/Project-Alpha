package net.one97.paytm.nativesdk.transactionsummary;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.R;

final class TxnSummaryActivity$initUI$6 implements View.OnClickListener {
    final /* synthetic */ TxnSummaryActivity this$0;

    TxnSummaryActivity$initUI$6(TxnSummaryActivity txnSummaryActivity) {
        this.this$0 = txnSummaryActivity;
    }

    public final void onClick(View view) {
        TextView textView = (TextView) this.this$0._$_findCachedViewById(R.id.tv_status_message_asps);
        k.a((Object) textView, "tv_status_message_asps");
        String obj = textView.getText().toString();
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", obj);
        intent.setType("text/plain");
        this.this$0.startActivity(Intent.createChooser(intent, (CharSequence) null));
    }
}
