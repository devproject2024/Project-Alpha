package net.one97.paytm.upgradeKyc.form60.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.upgradeKyc.KYCForm60;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.helper.e;

public class Form60DetailsFilledActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    RoboTextView f66019a;

    /* renamed from: b  reason: collision with root package name */
    RoboTextView f66020b;

    /* renamed from: c  reason: collision with root package name */
    KYCForm60 f66021c;

    public void attachBaseContext(Context context) {
        e.a aVar = e.f66028b;
        super.attachBaseContext(e.a.b().a(context));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_form60_details_filled);
        if (getSupportActionBar() != null) {
            getSupportActionBar().a(0.0f);
        }
        this.f66019a = (RoboTextView) findViewById(R.id.agriIncome);
        this.f66020b = (RoboTextView) findViewById(R.id.nonAgriIncome);
        if (getIntent() != null && getIntent().hasExtra("kycform60")) {
            this.f66021c = (KYCForm60) getIntent().getSerializableExtra("kycform60");
        }
        KYCForm60 kYCForm60 = this.f66021c;
        if (kYCForm60 != null) {
            if (!TextUtils.isEmpty(kYCForm60.getAgriIncom())) {
                RoboTextView roboTextView = this.f66019a;
                roboTextView.setText("₹ " + b.T(this.f66021c.getAgriIncom()));
            }
            if (!TextUtils.isEmpty(this.f66021c.getNonAgriIncom())) {
                RoboTextView roboTextView2 = this.f66020b;
                roboTextView2.setText("₹ " + b.T(this.f66021c.getNonAgriIncom()));
            }
        }
        findViewById(R.id.details_filled_update_details_tv).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                Form60DetailsFilledActivity.this.b(view);
            }
        });
        findViewById(R.id.form60_iv_back_button).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                Form60DetailsFilledActivity.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        onBackPressed();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 121 && i3 == -1) {
            Intent intent2 = new Intent();
            if (!(intent == null || intent.getExtras() == null)) {
                intent2.putExtras(intent.getExtras());
            }
            setResult(-1, intent2);
            finish();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        Intent intent = new Intent(this, FillForm60Activity.class);
        intent.putExtra("kycform60", this.f66021c);
        startActivityForResult(intent, 121);
    }
}
