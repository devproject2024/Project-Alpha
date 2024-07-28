package net.one97.paytm.upgradeKyc.kycV3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.activity.InPersonVerification;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity;
import net.one97.paytm.upgradeKyc.helper.d;

public final class MinKycStatusSuccessActivity extends UpgradeKycBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f66147a;

    public final View a(int i2) {
        if (this.f66147a == null) {
            this.f66147a = new HashMap();
        }
        View view = (View) this.f66147a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f66147a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int b() {
        return R.layout.base_toolbar;
    }

    public final int a() {
        return R.layout.min_kyc_status_success_lyt;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TextView textView = (TextView) a(R.id.tv_plimit_value);
        k.a((Object) textView, "tv_plimit_value");
        d.a aVar = d.f66026a;
        if (d.a.a() == null) {
            k.a();
        }
        textView.setText(d.a("minKycMonthlyLimit"));
        ((Button) a(R.id.btn_complete_kyc)).setOnClickListener(new a(this));
        a("/kyc/unlock-benefits", "kyc_new", "signal");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MinKycStatusSuccessActivity f66148a;

        a(MinKycStatusSuccessActivity minKycStatusSuccessActivity) {
            this.f66148a = minKycStatusSuccessActivity;
        }

        public final void onClick(View view) {
            UpgradeKycBaseActivity.a(this.f66148a, "/kyc/unlock-benefits", "unlock_benefits_clicked", (HashMap) null, (String) null, 12);
            MinKycStatusSuccessActivity.a(this.f66148a);
        }
    }

    public static final /* synthetic */ void a(MinKycStatusSuccessActivity minKycStatusSuccessActivity) {
        minKycStatusSuccessActivity.startActivity(new Intent(minKycStatusSuccessActivity, InPersonVerification.class));
        minKycStatusSuccessActivity.finish();
    }
}
