package net.one97.paytm.upgradeKyc.activity;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.d.d;

public class KycBaseActivity extends UpgradeKycBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private int f65322a = -1;

    /* renamed from: b  reason: collision with root package name */
    private Fragment f65323b = null;

    public final int b() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f65322a != 0) {
            this.f65323b = d.a();
            if (this.f65323b != null) {
                this.f65322a = 0;
                getSupportFragmentManager().a().b(R.id.kyc_base_frame_container, this.f65323b, (String) null).c();
            }
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().a(0.0f);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        setResult(0);
    }

    public final int a() {
        return R.layout.activity_kyc_base;
    }
}
