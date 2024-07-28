package net.one97.paytm.upgradeKyc.activity;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import java.util.HashMap;
import net.one97.paytm.upgradeKyc.R;

public final class EKycCersaiSuccessActivity extends UpgradeKycBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f65285a;

    public final View a(int i2) {
        if (this.f65285a == null) {
            this.f65285a = new HashMap();
        }
        View view = (View) this.f65285a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f65285a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int b() {
        return R.layout.activity_full_kyc_pending;
    }

    public final int a() {
        return R.layout.activity_ekyc_cersai_success;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.a(0.0f);
        }
    }
}
