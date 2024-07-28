package net.one97.paytm.upgradeKyc.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.paytm.utility.RoboTextView;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.helper.e;

public class KycNearbyActivity extends UpgradeKycBaseActivity {
    public void attachBaseContext(Context context) {
        e.a aVar = e.f66028b;
        super.attachBaseContext(e.a.a().f66030a.a(context));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RoboTextView roboTextView = (RoboTextView) findViewById(R.id.activity_kyc_bearby_tv_doc);
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("doc_number");
            if (!TextUtils.isEmpty(stringExtra)) {
                roboTextView.setText(getString(R.string.aadhaar_card) + " (" + stringExtra + ")");
            }
        }
        findViewById(R.id.payments_bank_info_btn_close).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                KycNearbyActivity.this.b(view);
            }
        });
        findViewById(R.id.activity_kyc_nearby_btn_done).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                KycNearbyActivity.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        e.a aVar = e.f66028b;
        e.a.b().a((Activity) this);
    }

    public final int a() {
        return R.layout.activity_kyc_nearby;
    }

    public final int b() {
        return R.layout.base_toolbar;
    }
}
