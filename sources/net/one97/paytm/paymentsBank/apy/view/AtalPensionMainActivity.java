package net.one97.paytm.paymentsBank.apy.view;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import net.one97.paytm.bankCommon.activity.PBBaseActivity;
import net.one97.paytm.paymentsBank.R;

public final class AtalPensionMainActivity extends PBBaseActivity {
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_atal_pension_main);
        getSupportFragmentManager().a().a(R.id.frame_fragment_container, (Fragment) new a()).b();
    }
}
