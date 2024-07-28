package net.one97.paytm.paymentsBank.pdc.activity;

import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.q;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.activity.PBBaseToolbarActivity;
import net.one97.paytm.paymentsBank.pdc.a.h;

public class PDCPromocodeActivity extends PBBaseToolbarActivity {
    public final int e() {
        return 0;
    }

    public final int f() {
        return R.layout.item_toolbar_normal_layout;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((TextView) findViewById(R.id.title)).setText(R.string.pb_pdc_have_promo_title);
        if (getIntent() != null && getIntent().getExtras() != null) {
            String stringExtra = getIntent().getStringExtra("productid");
            String stringExtra2 = getIntent().getStringExtra("amount");
            h hVar = new h();
            Bundle bundle2 = new Bundle();
            bundle2.putString("productid", stringExtra);
            bundle2.putString("amount", stringExtra2);
            hVar.setArguments(bundle2);
            q a2 = getSupportFragmentManager().a();
            a2.b(R.id.container_framelayout, hVar, (String) null);
            a2.b();
        }
    }
}
