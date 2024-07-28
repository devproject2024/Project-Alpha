package net.one97.paytm.bankOpen.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.bankCommon.activity.PBBaseActivity;
import net.one97.paytm.bankCommon.mapping.c;
import net.one97.paytm.bankOpen.R;

public class BankAccountOpenReqSubmittedActivity extends PBBaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_bank_account_open_req_submitted);
        RoboTextView roboTextView = (RoboTextView) findViewById(R.id.activity_bank_acc_submitted_text);
        RoboTextView roboTextView2 = (RoboTextView) findViewById(R.id.activity_bank_account_submitted_pan_pending_tv_bottom);
        HashMap hashMap = new HashMap();
        hashMap.put("user_id", b.n((Context) this));
        c.a("bank_savings_account_kyc_success_screen_load", (Map<String, Object>) hashMap, (Context) this);
        if (getIntent().hasExtra("middle_text")) {
            roboTextView.setText(getIntent().getStringExtra("middle_text"));
            findViewById(R.id.divider).setVisibility(8);
            roboTextView2.setVisibility(8);
        }
        if (getIntent().hasExtra("bottom_text")) {
            roboTextView2.setVisibility(0);
            findViewById(R.id.divider).setVisibility(0);
            roboTextView2.setText(getIntent().getStringExtra("bottom_text"));
        }
        findViewById(R.id.activity_bank_account_submitted_btn_done).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BankAccountOpenReqSubmittedActivity.this.b(view);
            }
        });
        findViewById(R.id.payments_bank_info_btn_close).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BankAccountOpenReqSubmittedActivity.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        onBackPressed();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }
}
