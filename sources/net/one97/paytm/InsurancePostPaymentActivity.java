package net.one97.paytm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import f.a.a;
import kotlin.g.b.k;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.insurance.R;
import net.one97.paytm.insurance.b.c;
import net.one97.paytm.insurance.common.a.b;

public final class InsurancePostPaymentActivity extends PaytmActivity {
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_insurance_post_payment);
        Fragment fragment = new Fragment();
        a aVar = a.f13515a;
        String b2 = a.b();
        if (b2 != null) {
            int hashCode = b2.hashCode();
            if (hashCode != -1196055108) {
                if (hashCode == 1523927324 && b2.equals("insurance_type_health")) {
                    fragment = new common.insuranceOrderSummary.a();
                }
            } else if (b2.equals("insurance_type_life")) {
                fragment = new b();
            }
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("insurance_post_payment_url", getIntent().getStringExtra("insurance_post_payment_url"));
        bundle2.putString("order_id", getIntent().getStringExtra("order_id"));
        bundle2.putBoolean("IS_MY_ORDER_SCREEN", getIntent().getBooleanExtra("IS_MY_ORDER_SCREEN", false));
        fragment.setArguments(bundle2);
        getSupportFragmentManager().a().b(R.id.fragment_container, fragment, (String) null).b();
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(c.a().getBaseContext(context));
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }

    public final void onBackPressed() {
        if (getIntent().getBooleanExtra("IS_MY_ORDER_SCREEN", false)) {
            super.onBackPressed();
            return;
        }
        net.one97.paytm.insurance.a.a a2 = c.a();
        k.a((Object) a2, "InsuranceHelper.getInsuranceListener()");
        Intent intent = new Intent(this, a2.getLandingActivityClass());
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        intent.setFlags(536870912);
        intent.putExtra("CLEAR_MOBILE_DATA", true);
        intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "main");
        startActivity(intent);
        finish();
    }
}
