package net.one97.paytm.upgradeKyc.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.helper.e;

public class MinKycDetailsSubmittedActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    Button f65369a;

    /* renamed from: b  reason: collision with root package name */
    LinearLayout f65370b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<String, View> f65371c = new HashMap<>();

    public void attachBaseContext(Context context) {
        e.a aVar = e.f66028b;
        super.attachBaseContext(e.a.b().a(context));
    }

    public void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        setContentView(R.layout.activity_min_kyc_success);
        e.a aVar = e.f66028b;
        e.a.b().a("/min-kyc/popup/success", "wallet", (Context) this);
        this.f65370b = (LinearLayout) findViewById(R.id.lyt_bottom_tab_bar);
        TextView textView = (TextView) findViewById(R.id.doc_details_submitted_tv);
        this.f65369a = (Button) findViewById(R.id.min_kyc_success_upgrade_btn);
        if (!(getIntent() == null || (extras = getIntent().getExtras()) == null)) {
            if (extras.getBoolean("min_kyc_success_via_deep_link")) {
                textView.setText(getString(R.string.doc_details_submitted));
            } else {
                textView.setVisibility(0);
                String string = extras.getString("min_kyc_details_submiited");
                textView.setText(getString(R.string.min_kyc_details_submitted, new Object[]{string}));
            }
        }
        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MinKycDetailsSubmittedActivity.this.b(view);
            }
        });
        String str = null;
        d.a aVar2 = d.f66026a;
        if (d.a.a() != null) {
            d.a aVar3 = d.f66026a;
            d.a.a();
            str = d.a("keyKycWidgetText");
        }
        if (!TextUtils.isEmpty(str)) {
            this.f65369a.setText(str);
        }
        this.f65369a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MinKycDetailsSubmittedActivity.this.a(view);
            }
        });
        e.a aVar4 = e.f66028b;
        e.a.b().a((Activity) this, this.f65370b);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        ArrayList arrayList = new ArrayList();
        e.a aVar = e.f66028b;
        e.a.b().a(this, "wallet_min_kyc_popup", "complete_kyc_clicked", arrayList, "", "/min-kyc/popup/success", "wallet");
        startActivity(new Intent(this, UpgradeKycActivity.class));
        finish();
    }
}
