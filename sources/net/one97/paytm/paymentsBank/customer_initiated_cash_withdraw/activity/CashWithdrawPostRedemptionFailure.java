package net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.bankCommon.mapping.a;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.b;
import net.one97.paytm.paymentsBank.utils.o;

public class CashWithdrawPostRedemptionFailure extends PaytmActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    double f18266a;

    /* renamed from: b  reason: collision with root package name */
    TextView f18267b;

    /* renamed from: c  reason: collision with root package name */
    TextView f18268c;

    /* renamed from: d  reason: collision with root package name */
    TextView f18269d;

    public void onClick(View view) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.a_failue);
        String stringExtra = getIntent().getStringExtra("amount");
        this.f18266a = getIntent().getDoubleExtra("effectivebalance", 0.0d);
        this.f18267b = (TextView) findViewById(R.id.tv_amnt);
        this.f18267b.setText(getString(R.string.rs_str, new Object[]{a.ac(stringExtra)}));
        this.f18268c = (TextView) findViewById(R.id.tv_updated_saving_account);
        this.f18269d = (TextView) findViewById(R.id.tv_amount_in_rupees);
        TextView textView = this.f18268c;
        textView.setText("Updated Savings Account Balance: " + getString(R.string.rs_str, new Object[]{a.c(Double.valueOf(this.f18266a - Double.valueOf(stringExtra).doubleValue()))}));
        this.f18269d.setText(b.a(Math.round(Double.valueOf(stringExtra).doubleValue())));
        findViewById(R.id.iv_back_arrow).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CashWithdrawPostRedemptionFailure.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        onBackPressed();
    }

    public void attachBaseContext(Context context) {
        if (o.b()) {
            super.attachBaseContext(context);
            return;
        }
        super.attachBaseContext(o.a().getBaseContext(context));
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }
}
