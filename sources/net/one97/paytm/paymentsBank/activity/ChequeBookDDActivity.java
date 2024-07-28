package net.one97.paytm.paymentsBank.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import net.one97.paytm.bankCommon.activity.PBBaseActivity;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.paymentsBank.R;

public class ChequeBookDDActivity extends PBBaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_cheque_book_dd);
        findViewById(R.id.toolbar_close).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ChequeBookDDActivity.this.a(view);
            }
        });
        TextView textView = (TextView) findViewById(R.id.cheque_title);
        TextView textView2 = (TextView) findViewById(R.id.cheque_subtitle);
        d.b();
        String a2 = d.a("chequeMessage");
        if (!TextUtils.isEmpty(a2) && a2.contains("##")) {
            String[] split = a2.split("##");
            if (split.length == 2) {
                textView.setText(split[0]);
                textView2.setText(split[1]);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        onBackPressed();
    }
}
