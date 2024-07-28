package net.one97.paytm.nativesdk.transactionsummary;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import kotlin.g.b.k;

final class TxnSummaryActivity$initUI$3 implements View.OnClickListener {
    final /* synthetic */ TxnSummaryActivity this$0;

    TxnSummaryActivity$initUI$3(TxnSummaryActivity txnSummaryActivity) {
        this.this$0 = txnSummaryActivity;
    }

    public final void onClick(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        Uri parse = Uri.parse("paytmmp://cash_wallet");
        k.a((Object) parse, "Uri.parse(\"paytmmp\" + \"://cash_wallet\")");
        Uri.Builder buildUpon = parse.buildUpon();
        k.a((Object) buildUpon, "uri.buildUpon()");
        buildUpon.appendQueryParameter("featuretype", "cash_ledger");
        Uri build = buildUpon.build();
        k.a((Object) build, "builder.build()");
        intent.setData(build);
        this.this$0.startActivityForResult(intent, 2);
    }
}
