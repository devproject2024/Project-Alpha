package net.one97.paytm.nativesdk.transactionsummary;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import kotlin.g.b.k;

final class TxnSummaryActivity$initUI$4 implements View.OnClickListener {
    final /* synthetic */ TxnSummaryActivity this$0;

    TxnSummaryActivity$initUI$4(TxnSummaryActivity txnSummaryActivity) {
        this.this$0 = txnSummaryActivity;
    }

    public final void onClick(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        Uri parse = Uri.parse("paytmmp://contactus");
        k.a((Object) parse, "Uri.parse(\"paytmmp://contactus\")");
        intent.setData(parse);
        this.this$0.startActivityForResult(intent, 2);
    }
}
