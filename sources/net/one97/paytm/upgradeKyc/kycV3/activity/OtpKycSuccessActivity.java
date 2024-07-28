package net.one97.paytm.upgradeKyc.kycV3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.activity.InPersonVerification;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.utils.j;

public final class OtpKycSuccessActivity extends UpgradeKycBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f66149a;

    public final View a(int i2) {
        if (this.f66149a == null) {
            this.f66149a = new HashMap();
        }
        View view = (View) this.f66149a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f66149a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int b() {
        return R.layout.base_toolbar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e.a aVar = e.f66028b;
        String g2 = j.g(e.a.b().a());
        if (!TextUtils.isEmpty(g2)) {
            LinearLayout linearLayout = (LinearLayout) a(R.id.ll_additional_benefits);
            k.a((Object) linearLayout, "ll_additional_benefits");
            linearLayout.setVisibility(0);
            TextView textView = (TextView) a(R.id.tv_benefits_expiry);
            k.a((Object) textView, "tv_benefits_expiry");
            textView.setText(getString(R.string.kyc_additional_benefits_till) + ' ' + g2);
        }
        ((Button) a(R.id.btn_complete_kyc)).setOnClickListener(new a(this));
    }

    public final int a() {
        return R.layout.aadhaar_completed_benefits_activity;
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ OtpKycSuccessActivity f66150a;

        a(OtpKycSuccessActivity otpKycSuccessActivity) {
            this.f66150a = otpKycSuccessActivity;
        }

        public final void onClick(View view) {
            OtpKycSuccessActivity.a(this.f66150a);
        }
    }

    public static final /* synthetic */ void a(OtpKycSuccessActivity otpKycSuccessActivity) {
        otpKycSuccessActivity.startActivity(new Intent(otpKycSuccessActivity, InPersonVerification.class));
        otpKycSuccessActivity.finish();
    }
}
