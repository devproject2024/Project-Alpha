package net.one97.paytm.recharge.presentation.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import kotlin.g.b.k;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.presentation.c.d;

public final class AJRPrepaidAutomaticSetupSettingsActivity extends PaytmActivity {
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_prepaid_automatic_setup);
        Bundle bundle2 = new Bundle();
        Intent intent = getIntent();
        String str = null;
        bundle2.putString("operator_name", intent != null ? intent.getStringExtra("operator_name") : null);
        Intent intent2 = getIntent();
        bundle2.putString("recharge_number", intent2 != null ? intent2.getStringExtra("recharge_number") : null);
        Intent intent3 = getIntent();
        bundle2.putString("operator_logo", intent3 != null ? intent3.getStringExtra("operator_logo") : null);
        Intent intent4 = getIntent();
        bundle2.putString("amount_field_regex", intent4 != null ? intent4.getStringExtra("amount_field_regex") : null);
        Intent intent5 = getIntent();
        bundle2.putString("min_amount", intent5 != null ? intent5.getStringExtra("min_amount") : null);
        Intent intent6 = getIntent();
        bundle2.putString("max_amount", intent6 != null ? intent6.getStringExtra("max_amount") : null);
        Intent intent7 = getIntent();
        if (intent7 != null) {
            str = intent7.getStringExtra(CLPConstants.PRODUCT_ID);
        }
        bundle2.putString(CLPConstants.PRODUCT_ID, str);
        q a2 = getSupportFragmentManager().a();
        int i2 = R.id.frame_layout;
        d.b bVar = d.f64827a;
        k.c(bundle2, "bundle");
        d dVar = new d();
        dVar.setArguments(bundle2);
        a2.a(i2, (Fragment) dVar).b();
    }
}
