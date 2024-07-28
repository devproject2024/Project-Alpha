package net.one97.paytm.upgradeKyc.minkycotp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.upgradeKyc.R;

public final class KycVerifyOtpActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private d f66274a = new a(this);

    public static final class a implements d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ KycVerifyOtpActivity f66275a;

        a(KycVerifyOtpActivity kycVerifyOtpActivity) {
            this.f66275a = kycVerifyOtpActivity;
        }

        public final void a() {
            this.f66275a.setResult(-1);
            this.f66275a.finish();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_kyc_verify_otp);
        b bVar = new b();
        bVar.a(this.f66274a);
        getSupportFragmentManager().a().a(R.id.container, (Fragment) bVar).b();
    }
}
